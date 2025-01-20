package net.luckshark.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.luckshark.block.ModBlocks;
import net.luckshark.item.ModItemGroups;
import net.luckshark.item.ModItems;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ENUSLanProvider extends FabricLanguageProvider {
    public ENUSLanProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItemGroups.BARK_GROUP, "bark");

        translationBuilder.add(ModItems.OAK_BARK, "Oak bark");
        translationBuilder.add(ModItems.SPRUCE_BARK, "Spruce bark");
        translationBuilder.add(ModItems.BIRCH_BARK, "Birch bark");
        translationBuilder.add(ModItems.JUNGLE_BARK, "Jungle bark");
        translationBuilder.add(ModItems.ACACIA_BARK, "Acacia bark");
        translationBuilder.add(ModItems.DARK_OAK_BARK, "Dark Oak bark");
        translationBuilder.add(ModItems.MANGROVE_BARK, "Mangrove bark");
        translationBuilder.add(ModItems.CHERRY_BARK, "Cherry bark");
        translationBuilder.add(ModItems.CRIMSON_BARK, "Crimson Fungus Slice");
        translationBuilder.add(ModItems.WARPED_BARK, "Warped Fungus Slice");
        translationBuilder.add(ModItems.BAMBOO_BARK, "Bamboo bark");

        translationBuilder.add(ModItems.OAK_BARK_HELMET, "Oak bark Helmet");
        translationBuilder.add(ModItems.SPRUCE_BARK_HELMET, "Spruce bark Helmet");
        translationBuilder.add(ModItems.BIRCH_BARK_HELMET, "Birch bark Helmet");
        translationBuilder.add(ModItems.JUNGLE_BARK_HELMET, "Jungle bark Helmet");
        translationBuilder.add(ModItems.ACACIA_BARK_HELMET, "Acacia bark Helmet");
        translationBuilder.add(ModItems.DARK_OAK_BARK_HELMET, "Dark Oak bark Helmet");
        translationBuilder.add(ModItems.MANGROVE_BARK_HELMET, "Mangrove bark Helmet");
        translationBuilder.add(ModItems.CHERRY_BARK_HELMET, "Cherry bark Helmet");
        translationBuilder.add(ModItems.CRIMSON_BARK_HELMET, "Crimson Helmet");
        translationBuilder.add(ModItems.WARPED_BARK_HELMET, "Warped Helmet");
        translationBuilder.add(ModItems.BAMBOO_BARK_HELMET, "Bamboo Helmet");
        translationBuilder.add(ModItems.OAK_BARK_CHESTPLATE, "Oak bark Chestplate");
        translationBuilder.add(ModItems.SPRUCE_BARK_CHESTPLATE, "Spruce bark Chestplate");
        translationBuilder.add(ModItems.BIRCH_BARK_CHESTPLATE, "Birch bark Chestplate");
        translationBuilder.add(ModItems.JUNGLE_BARK_CHESTPLATE, "Jungle bark Chestplate");
        translationBuilder.add(ModItems.ACACIA_BARK_CHESTPLATE, "Acacia bark Chestplate");
        translationBuilder.add(ModItems.DARK_OAK_BARK_CHESTPLATE, "Dark Oak bark Chestplate");
        translationBuilder.add(ModItems.MANGROVE_BARK_CHESTPLATE, "Mangrove bark Chestplate");
        translationBuilder.add(ModItems.CHERRY_BARK_CHESTPLATE, "Cherry bark Chestplate");
        translationBuilder.add(ModItems.CRIMSON_BARK_CHESTPLATE, "Crimson Chestplate");
        translationBuilder.add(ModItems.WARPED_BARK_CHESTPLATE, "Warped Chestplate");
        translationBuilder.add(ModItems.BAMBOO_BARK_CHESTPLATE, "Bamboo Chestplate");
        translationBuilder.add(ModItems.OAK_BARK_LEGGINGS, "Oak bark Leggings");
        translationBuilder.add(ModItems.SPRUCE_BARK_LEGGINGS, "Spruce bark Leggings");
        translationBuilder.add(ModItems.BIRCH_BARK_LEGGINGS, "Birch bark Leggings");
        translationBuilder.add(ModItems.JUNGLE_BARK_LEGGINGS, "Jungle bark Leggings");
        translationBuilder.add(ModItems.ACACIA_BARK_LEGGINGS, "Acacia bark Leggings");
        translationBuilder.add(ModItems.DARK_OAK_BARK_LEGGINGS, "Dark Oak bark Leggings");
        translationBuilder.add(ModItems.MANGROVE_BARK_LEGGINGS, "Mangrove bark Leggings");
        translationBuilder.add(ModItems.CHERRY_BARK_LEGGINGS, "Cherry bark Leggings");
        translationBuilder.add(ModItems.CRIMSON_BARK_LEGGINGS, "Crimson Leggings");
        translationBuilder.add(ModItems.WARPED_BARK_LEGGINGS, "Warped Leggings");
        translationBuilder.add(ModItems.BAMBOO_BARK_LEGGINGS, "Bamboo Leggings");
        translationBuilder.add(ModItems.OAK_BARK_BOOTS, "Oak bark Boots");
        translationBuilder.add(ModItems.SPRUCE_BARK_BOOTS, "Spruce bark Boots");
        translationBuilder.add(ModItems.BIRCH_BARK_BOOTS, "Birch bark Boots");
        translationBuilder.add(ModItems.JUNGLE_BARK_BOOTS, "Jungle bark Boots");
        translationBuilder.add(ModItems.ACACIA_BARK_BOOTS, "Acacia bark Boots");
        translationBuilder.add(ModItems.DARK_OAK_BARK_BOOTS, "Dark Oak bark Boots");
        translationBuilder.add(ModItems.MANGROVE_BARK_BOOTS, "Mangrove bark Boots");
        translationBuilder.add(ModItems.CHERRY_BARK_BOOTS, "Cherry bark Boots");
        translationBuilder.add(ModItems.CRIMSON_BARK_BOOTS, "Crimson Boots");
        translationBuilder.add(ModItems.WARPED_BARK_BOOTS, "Warped Boots");
        translationBuilder.add(ModItems.BAMBOO_BARK_BOOTS, "Bamboo Boots");

        translationBuilder.add("trim_material.bark.oak_bark_essence", "Oak Material");
        translationBuilder.add("trim_material.bark.spruce_bark_essence", "Spruce Material");
        translationBuilder.add("trim_material.bark.birch_bark_essence", "Birch Material");
        translationBuilder.add("trim_material.bark.jungle_bark_essence", "Jungle Material");
        translationBuilder.add("trim_material.bark.acacia_bark_essence", "Acacia Material");
        translationBuilder.add("trim_material.bark.dark_oak_bark_essence", "Dark Oak Material");
        translationBuilder.add("trim_material.bark.mangrove_bark_essence", "Mangrove Material");
        translationBuilder.add("trim_material.bark.cherry_bark_essence", "Cherry Material");
        translationBuilder.add("trim_material.bark.crimson_bark_essence", "Crimson Material");
        translationBuilder.add("trim_material.bark.warped_bark_essence", "Warped Material");
        translationBuilder.add("trim_material.bark.bamboo_bark_essence", "Bamboo Material");

        translationBuilder.add(ModItems.OAK_BARK_ESSENCE, "Oak Essence");
        translationBuilder.add(ModItems.SPRUCE_BARK_ESSENCE, "Spruce Essence");
        translationBuilder.add(ModItems.BIRCH_BARK_ESSENCE, "Birch Essence");
        translationBuilder.add(ModItems.JUNGLE_BARK_ESSENCE, "Jungle Essence");
        translationBuilder.add(ModItems.ACACIA_BARK_ESSENCE, "Acacia Essence");
        translationBuilder.add(ModItems.DARK_OAK_BARK_ESSENCE, "Dark Oak Essence");
        translationBuilder.add(ModItems.MANGROVE_BARK_ESSENCE, "Mangrove Essence");
        translationBuilder.add(ModItems.CHERRY_BARK_ESSENCE, "Cherry Essence");
        translationBuilder.add(ModItems.CRIMSON_BARK_ESSENCE, "Crimson Essence");
        translationBuilder.add(ModItems.WARPED_BARK_ESSENCE, "Warped Essence");
        translationBuilder.add(ModItems.BAMBOO_BARK_ESSENCE, "Bamboo Essence");

        translationBuilder.add(ModBlocks.QUILMOR, "Quilmor");

        translationBuilder.add(ModBlocks.YAN_CRAFT, "Yan");
        translationBuilder.add("container.yan_craft", "Yan Craft");
        translationBuilder.add("gui.yan_craft.rate", "Success rate:");
    }
}
