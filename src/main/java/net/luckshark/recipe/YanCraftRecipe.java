package net.luckshark.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.luckshark.recipe.input.SimpleTwoStackRecipeInput;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.World;

public class YanCraftRecipe implements Recipe<SimpleTwoStackRecipeInput> {

    private final Ingredient input1;
    private final Ingredient input2;
    private final ItemStack output;
    private static final double successRate = 0.7;

    public YanCraftRecipe(Ingredient input1, Ingredient input2, ItemStack output) {
        this.input1 = input1;
        this.input2 = input2;
        this.output = output;
    }

    public Ingredient getIngredients(int index) {
        return switch (index) {
            case 0:
                yield input1;
            case 1:
                yield input2;
            default:
                throw new IllegalArgumentException("Invalid index: " + index);
        };
    }

    @Override
    public boolean matches(SimpleTwoStackRecipeInput input, World world) {
        if (world.isClient()) {
            return false;
        }
        return input1.test(input.getStackInSlot(0)) && input2.test(input.getStackInSlot(1));
    }

    @Override
    public ItemStack craft(SimpleTwoStackRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
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

    public static double getSuccessRate() {
        return successRate;
    }

    public static class Type implements RecipeType<YanCraftRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "yan_craft";
    }

    public static class Serializer implements RecipeSerializer<YanCraftRecipe> {

        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "yan_craft";

        public static final MapCodec<YanCraftRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("input1").forGetter(recipe -> recipe.getIngredients(0)),
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("input2").forGetter(recipe -> recipe.getIngredients(1)),
                ItemStack.VALIDATED_CODEC.fieldOf("output").forGetter(recipe -> recipe.output)
        ).apply(instance, YanCraftRecipe::new));

        public static final PacketCodec<RegistryByteBuf, YanCraftRecipe> PACKET_CODEC = PacketCodec.ofStatic(
                Serializer::write, Serializer::read
        );

        private static YanCraftRecipe read(RegistryByteBuf registryByteBuf) {
            Ingredient input1 = Ingredient.PACKET_CODEC.decode(registryByteBuf);
            Ingredient input2 = Ingredient.PACKET_CODEC.decode(registryByteBuf);
            ItemStack output = ItemStack.PACKET_CODEC.decode(registryByteBuf);
            return new YanCraftRecipe(input1, input2, output);
        }

        private static void write(RegistryByteBuf registryByteBuf, YanCraftRecipe recipe) {
            Ingredient.PACKET_CODEC.encode(registryByteBuf, recipe.getIngredients(0));  // 写入第一个输入
            Ingredient.PACKET_CODEC.encode(registryByteBuf, recipe.getIngredients(1));  // 写入第二个输入
            ItemStack.PACKET_CODEC.encode(registryByteBuf, recipe.getResult(null)); // 写入输出
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
