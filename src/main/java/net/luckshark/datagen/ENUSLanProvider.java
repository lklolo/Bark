package net.luckshark.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
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
        translationBuilder.add(ModItemGroups.BARK_GROUP, "Bark");

        translationBuilder.add(ModItems.OAK_BARK, "Oak Bark");
        translationBuilder.add(ModItems.SPRUCE_BARK, "Spruce Bark");
        translationBuilder.add(ModItems.BIRCH_BARK, "Birch Bark");
        translationBuilder.add(ModItems.JUNGLE_BARK, "Jungle Bark");
        translationBuilder.add(ModItems.ACACIA_BARK, "Acacia Bark");
        translationBuilder.add(ModItems.DARK_OAK_BARK, "Dark Oak Bark");
        translationBuilder.add(ModItems.MANGROVE_BARK, "Mangrove Bark");
        translationBuilder.add(ModItems.CHERRY_BARK, "Cherry Bark");
        translationBuilder.add(ModItems.CRIMSON_BARK, "Crimson Fungus Slice");
        translationBuilder.add(ModItems.WARPED_BARK, "Warped Fungus Slice");
        translationBuilder.add(ModItems.BAMBOO_BARK, "Bamboo Bark");

        translationBuilder.add(ModItems.OAK_BARK_HELMET, "Oak Bark Helmet");
        translationBuilder.add(ModItems.SPRUCE_BARK_HELMET, "Spruce Bark Helmet");
        translationBuilder.add(ModItems.BIRCH_BARK_HELMET, "Birch Bark Helmet");
        translationBuilder.add(ModItems.JUNGLE_BARK_HELMET, "Jungle Bark Helmet");
        translationBuilder.add(ModItems.ACACIA_BARK_HELMET, "Acacia Bark Helmet");
        translationBuilder.add(ModItems.DARK_OAK_BARK_HELMET, "Dark Oak Bark Helmet");
        translationBuilder.add(ModItems.MANGROVE_BARK_HELMET, "Mangrove Bark Helmet");
        translationBuilder.add(ModItems.CHERRY_BARK_HELMET, "Cherry Bark Helmet");
        translationBuilder.add(ModItems.CRIMSON_BARK_HELMET, "Crimson Helmet");
        translationBuilder.add(ModItems.WARPED_BARK_HELMET, "Warped Helmet");
        translationBuilder.add(ModItems.BAMBOO_BARK_HELMET, "Bamboo Helmet");
        translationBuilder.add(ModItems.OAK_BARK_CHESTPLATE, "Oak Bark Chestplate");
        translationBuilder.add(ModItems.SPRUCE_BARK_CHESTPLATE, "Spruce Bark Chestplate");
        translationBuilder.add(ModItems.BIRCH_BARK_CHESTPLATE, "Birch Bark Chestplate");
        translationBuilder.add(ModItems.JUNGLE_BARK_CHESTPLATE, "Jungle Bark Chestplate");
        translationBuilder.add(ModItems.ACACIA_BARK_CHESTPLATE, "Acacia Bark Chestplate");
        translationBuilder.add(ModItems.DARK_OAK_BARK_CHESTPLATE, "Dark Oak Bark Chestplate");
        translationBuilder.add(ModItems.MANGROVE_BARK_CHESTPLATE, "Mangrove Bark Chestplate");
        translationBuilder.add(ModItems.CHERRY_BARK_CHESTPLATE, "Cherry Bark Chestplate");
        translationBuilder.add(ModItems.CRIMSON_BARK_CHESTPLATE, "Crimson Chestplate");
        translationBuilder.add(ModItems.WARPED_BARK_CHESTPLATE, "Warped Chestplate");
        translationBuilder.add(ModItems.BAMBOO_BARK_CHESTPLATE, "Bamboo Chestplate");
        translationBuilder.add(ModItems.OAK_BARK_LEGGINGS, "Oak Bark Leggings");
        translationBuilder.add(ModItems.SPRUCE_BARK_LEGGINGS, "Spruce Bark Leggings");
        translationBuilder.add(ModItems.BIRCH_BARK_LEGGINGS, "Birch Bark Leggings");
        translationBuilder.add(ModItems.JUNGLE_BARK_LEGGINGS, "Jungle Bark Leggings");
        translationBuilder.add(ModItems.ACACIA_BARK_LEGGINGS, "Acacia Bark Leggings");
        translationBuilder.add(ModItems.DARK_OAK_BARK_LEGGINGS, "Dark Oak Bark Leggings");
        translationBuilder.add(ModItems.MANGROVE_BARK_LEGGINGS, "Mangrove Bark Leggings");
        translationBuilder.add(ModItems.CHERRY_BARK_LEGGINGS, "Cherry Bark Leggings");
        translationBuilder.add(ModItems.CRIMSON_BARK_LEGGINGS, "Crimson Leggings");
        translationBuilder.add(ModItems.WARPED_BARK_LEGGINGS, "Warped Leggings");
        translationBuilder.add(ModItems.BAMBOO_BARK_LEGGINGS, "Bamboo Leggings");
        translationBuilder.add(ModItems.OAK_BARK_BOOTS, "Oak Bark Boots");
        translationBuilder.add(ModItems.SPRUCE_BARK_BOOTS, "Spruce Bark Boots");
        translationBuilder.add(ModItems.BIRCH_BARK_BOOTS, "Birch Bark Boots");
        translationBuilder.add(ModItems.JUNGLE_BARK_BOOTS, "Jungle Bark Boots");
        translationBuilder.add(ModItems.ACACIA_BARK_BOOTS, "Acacia Bark Boots");
        translationBuilder.add(ModItems.DARK_OAK_BARK_BOOTS, "Dark Oak Bark Boots");
        translationBuilder.add(ModItems.MANGROVE_BARK_BOOTS, "Mangrove Bark Boots");
        translationBuilder.add(ModItems.CHERRY_BARK_BOOTS, "Cherry Bark Boots");
        translationBuilder.add(ModItems.CRIMSON_BARK_BOOTS, "Crimson Boots");
        translationBuilder.add(ModItems.WARPED_BARK_BOOTS, "Warped Boots");
        translationBuilder.add(ModItems.BAMBOO_BARK_BOOTS, "Bamboo Boots");



    }
}
