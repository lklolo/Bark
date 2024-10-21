package net.luckshark.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.luckshark.Bark;
import net.luckshark.block.ModBlocks;
import net.luckshark.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class RecipesProvider extends FabricRecipeProvider {

    RecipeExporter exporter;

    public RecipesProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        this.exporter = exporter;
        helmet(ModItems.OAK_BARK, ModItems.OAK_BARK_HELMET);
        helmet(ModItems.SPRUCE_BARK, ModItems.SPRUCE_BARK_HELMET);
        helmet(ModItems.BIRCH_BARK, ModItems.BIRCH_BARK_HELMET);
        helmet(ModItems.JUNGLE_BARK, ModItems.JUNGLE_BARK_HELMET);
        helmet(ModItems.ACACIA_BARK, ModItems.ACACIA_BARK_HELMET);
        helmet(ModItems.DARK_OAK_BARK, ModItems.DARK_OAK_BARK_HELMET);
        helmet(ModItems.MANGROVE_BARK, ModItems.MANGROVE_BARK_HELMET);
        helmet(ModItems.CHERRY_BARK, ModItems.CHERRY_BARK_HELMET);
        helmet(ModItems.BAMBOO_BARK, ModItems.BAMBOO_BARK_HELMET);
        helmet(ModItems.CRIMSON_BARK, ModItems.CRIMSON_BARK_HELMET);
        helmet(ModItems.WARPED_BARK, ModItems.WARPED_BARK_HELMET);

        chestplate(ModItems.OAK_BARK, ModItems.OAK_BARK_CHESTPLATE);
        chestplate(ModItems.SPRUCE_BARK, ModItems.SPRUCE_BARK_CHESTPLATE);
        chestplate(ModItems.BIRCH_BARK, ModItems.BIRCH_BARK_CHESTPLATE);
        chestplate(ModItems.JUNGLE_BARK, ModItems.JUNGLE_BARK_CHESTPLATE);
        chestplate(ModItems.ACACIA_BARK, ModItems.ACACIA_BARK_CHESTPLATE);
        chestplate(ModItems.DARK_OAK_BARK, ModItems.DARK_OAK_BARK_CHESTPLATE);
        chestplate(ModItems.MANGROVE_BARK, ModItems.MANGROVE_BARK_CHESTPLATE);
        chestplate(ModItems.CHERRY_BARK, ModItems.CHERRY_BARK_CHESTPLATE);
        chestplate(ModItems.BAMBOO_BARK, ModItems.BAMBOO_BARK_CHESTPLATE);
        chestplate(ModItems.CRIMSON_BARK, ModItems.CRIMSON_BARK_CHESTPLATE);
        chestplate(ModItems.WARPED_BARK, ModItems.WARPED_BARK_CHESTPLATE);

        leggings(ModItems.WARPED_BARK, ModItems.WARPED_BARK_LEGGINGS);
        leggings(ModItems.CRIMSON_BARK, ModItems.CRIMSON_BARK_LEGGINGS);
        leggings(ModItems.BAMBOO_BARK, ModItems.BAMBOO_BARK_LEGGINGS);
        leggings(ModItems.CHERRY_BARK, ModItems.CHERRY_BARK_LEGGINGS);
        leggings(ModItems.MANGROVE_BARK, ModItems.MANGROVE_BARK_LEGGINGS);
        leggings(ModItems.DARK_OAK_BARK, ModItems.DARK_OAK_BARK_LEGGINGS);
        leggings(ModItems.ACACIA_BARK, ModItems.ACACIA_BARK_LEGGINGS);
        leggings(ModItems.BIRCH_BARK, ModItems.BIRCH_BARK_LEGGINGS);
        leggings(ModItems.JUNGLE_BARK, ModItems.JUNGLE_BARK_LEGGINGS);
        leggings(ModItems.SPRUCE_BARK, ModItems.SPRUCE_BARK_LEGGINGS);
        leggings(ModItems.OAK_BARK, ModItems.OAK_BARK_LEGGINGS);

        boots(ModItems.OAK_BARK, ModItems.OAK_BARK_BOOTS);
        boots(ModItems.SPRUCE_BARK, ModItems.SPRUCE_BARK_BOOTS);
        boots(ModItems.BIRCH_BARK, ModItems.BIRCH_BARK_BOOTS);
        boots(ModItems.JUNGLE_BARK, ModItems.JUNGLE_BARK_BOOTS);
        boots(ModItems.ACACIA_BARK, ModItems.ACACIA_BARK_BOOTS);
        boots(ModItems.DARK_OAK_BARK, ModItems.DARK_OAK_BARK_BOOTS);
        boots(ModItems.MANGROVE_BARK, ModItems.MANGROVE_BARK_BOOTS);
        boots(ModItems.CHERRY_BARK, ModItems.CHERRY_BARK_BOOTS);
        boots(ModItems.BAMBOO_BARK, ModItems.BAMBOO_BARK_BOOTS);
        boots(ModItems.CRIMSON_BARK, ModItems.CRIMSON_BARK_BOOTS);
        boots(ModItems.WARPED_BARK, ModItems.WARPED_BARK_BOOTS);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModBlocks.YAN_CRAFT, 1)
                .pattern("BBB")
                .pattern("AAA")
                .pattern("AAA")
                .input('A', Items.COBBLESTONE)
                .input('B', Items.FLINT)
                .criterion("has_item", RecipeProvider.conditionsFromItem(Items.COBBLESTONE))
                .criterion("has_item", RecipeProvider.conditionsFromItem(Items.FLINT))
                .offerTo(exporter, Identifier.of(Bark.MOD_ID, "yan_craft"));
    }

    private void helmet(Item materialsItem, Item resultItem) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, resultItem, 1)
                .pattern("AAA")
                .pattern("A A")
                .input('A', materialsItem)
                .criterion("has_item", RecipeProvider.conditionsFromItem(materialsItem))
                .offerTo(exporter, Identifier.of(Bark.MOD_ID, ModItems.idMap.get(resultItem)));
    }
    private void chestplate(Item materialsItem, Item resultItem) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, resultItem, 1)
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .input('A', materialsItem)
                .criterion("has_item", RecipeProvider.conditionsFromItem(materialsItem))
                .offerTo(exporter, Identifier.of(Bark.MOD_ID, ModItems.idMap.get(resultItem)));
    }
    private void leggings(Item materialsItem, Item resultItem) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, resultItem, 1)
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .input('A', materialsItem)
                .criterion("has_item", RecipeProvider.conditionsFromItem(materialsItem))
                .offerTo(exporter, Identifier.of(Bark.MOD_ID, ModItems.idMap.get(resultItem)));
    }
    private void boots(Item materialsItem, Item resultItem) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, resultItem, 1)
                .pattern("A A")
                .pattern("A A")
                .input('A', materialsItem)
                .criterion("has_item", RecipeProvider.conditionsFromItem(materialsItem))
                .offerTo(exporter, Identifier.of(Bark.MOD_ID, ModItems.idMap.get(resultItem)));
    }
}
