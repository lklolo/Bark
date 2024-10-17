package net.luckshark.recipe;

import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.List;

public class YanCraftRecipe implements Recipe<SingleStackRecipeInput> {

    private final ItemStack output;
    private final List<Ingredient> recipeItems;

    public YanCraftRecipe(List<Ingredient> recipeItems, ItemStack output) {
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.ofSize(this.recipeItems.size());
        list.addAll(recipeItems);
        return list;
    }

    @Override
    public boolean matches(SingleStackRecipeInput input, World world) {
        if (world.isClient()){
            return false;
        }
        return recipeItems.get(0).test(input.item());
    }

    @Override
    public ItemStack craft(SingleStackRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return this.output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return this.output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class  Type implements RecipeType<YanCraftRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "yan_craft";
    }

    public static class Serializer implements RecipeSerializer<YanCraftRecipe> {

        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "yan_craft";

        public static final MapCodec<YanCraftRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                (Ingredient.DISALLOW_EMPTY_CODEC.listOf().fieldOf("ingredients")).flatXmap(ingredients -> {
                    Ingredient[] ingredients1 = (Ingredient[]) ingredients.stream().filter(ingredient -> !ingredient.isEmpty()).toArray(Ingredient[]::new);
                    if (ingredients1.length == 0) {
                        return DataResult.error(() -> "No ingredients");
                    }
                    if (ingredients1.length > 9) {
                        return DataResult.error(() -> "Too many ingredients");
                    }
                    return DataResult.success(DefaultedList.copyOf(Ingredient.EMPTY, ingredients1));
                }, DataResult::success).forGetter(recipe -> recipe.getIngredients()),
                (ItemStack.VALIDATED_CODEC.fieldOf("output")).forGetter(recipe -> recipe.output)
        ).apply(instance, YanCraftRecipe::new));

        public static final PacketCodec<RegistryByteBuf, YanCraftRecipe> PACKET_CODEC = PacketCodec.ofStatic(
                Serializer::write, Serializer::read
        );

        private static YanCraftRecipe read(RegistryByteBuf registryByteBuf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(registryByteBuf.readInt(),Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.PACKET_CODEC.decode(registryByteBuf));
            }
            ItemStack output = ItemStack.PACKET_CODEC.decode(registryByteBuf);
            return new YanCraftRecipe(inputs, output);
        }

        private static void write(RegistryByteBuf registryByteBuf, YanCraftRecipe yanCraftRecipe) {
            registryByteBuf.writeInt(yanCraftRecipe.getIngredients().size());

            for (Ingredient ingredient : yanCraftRecipe.getIngredients()) {
                Ingredient.PACKET_CODEC.encode(registryByteBuf, ingredient);
            }
            ItemStack.PACKET_CODEC.encode(registryByteBuf, yanCraftRecipe.getResult(null));
        }

        @Override
        public MapCodec<YanCraftRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, YanCraftRecipe> packetCodec() {
            return PACKET_CODEC;
        }
    }
}
