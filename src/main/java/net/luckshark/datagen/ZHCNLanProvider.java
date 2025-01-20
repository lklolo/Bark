package net.luckshark.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.luckshark.block.ModBlocks;
import net.luckshark.item.ModItemGroups;
import net.luckshark.item.ModItems;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ZHCNLanProvider extends FabricLanguageProvider {
    public ZHCNLanProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "zh_cn", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItemGroups.BARK_GROUP, "犬吠");

        translationBuilder.add(ModItems.OAK_BARK, "橡树皮");
        translationBuilder.add(ModItems.SPRUCE_BARK, "云杉皮");
        translationBuilder.add(ModItems.BIRCH_BARK, "白桦皮");
        translationBuilder.add(ModItems.JUNGLE_BARK, "丛林原木皮");
        translationBuilder.add(ModItems.ACACIA_BARK, "金合欢皮");
        translationBuilder.add(ModItems.DARK_OAK_BARK, "深色橡树皮");
        translationBuilder.add(ModItems.MANGROVE_BARK, "红树皮");
        translationBuilder.add(ModItems.CHERRY_BARK, "樱花树皮");
        translationBuilder.add(ModItems.CRIMSON_BARK, "绯红菌菌柄切片");
        translationBuilder.add(ModItems.WARPED_BARK, "诡异菌菌柄切片");
        translationBuilder.add(ModItems.BAMBOO_BARK, "竹皮");

        translationBuilder.add(ModItems.OAK_BARK_HELMET, "橡树皮头盔");
        translationBuilder.add(ModItems.SPRUCE_BARK_HELMET, "云杉皮头盔");
        translationBuilder.add(ModItems.BIRCH_BARK_HELMET, "白桦皮头盔");
        translationBuilder.add(ModItems.JUNGLE_BARK_HELMET, "丛林原木皮头盔");
        translationBuilder.add(ModItems.ACACIA_BARK_HELMET, "金合欢皮头盔");
        translationBuilder.add(ModItems.DARK_OAK_BARK_HELMET, "深色橡树皮头盔");
        translationBuilder.add(ModItems.MANGROVE_BARK_HELMET, "红树皮头盔");
        translationBuilder.add(ModItems.CHERRY_BARK_HELMET, "樱花树皮头盔");
        translationBuilder.add(ModItems.CRIMSON_BARK_HELMET, "绯红菌菌柄头盔");
        translationBuilder.add(ModItems.WARPED_BARK_HELMET, "诡异菌菌柄头盔");
        translationBuilder.add(ModItems.BAMBOO_BARK_HELMET, "竹头盔");
        translationBuilder.add(ModItems.OAK_BARK_CHESTPLATE, "橡树皮胸甲");
        translationBuilder.add(ModItems.SPRUCE_BARK_CHESTPLATE, "云杉皮胸甲");
        translationBuilder.add(ModItems.BIRCH_BARK_CHESTPLATE, "白桦皮胸甲");
        translationBuilder.add(ModItems.JUNGLE_BARK_CHESTPLATE, "丛林原木皮胸甲");
        translationBuilder.add(ModItems.ACACIA_BARK_CHESTPLATE, "金合欢皮胸甲");
        translationBuilder.add(ModItems.DARK_OAK_BARK_CHESTPLATE, "深色橡树皮胸甲");
        translationBuilder.add(ModItems.MANGROVE_BARK_CHESTPLATE, "红树皮胸甲");
        translationBuilder.add(ModItems.CHERRY_BARK_CHESTPLATE, "樱花树皮胸甲");
        translationBuilder.add(ModItems.CRIMSON_BARK_CHESTPLATE, "绯红菌菌柄胸甲");
        translationBuilder.add(ModItems.WARPED_BARK_CHESTPLATE, "诡异菌菌柄胸甲");
        translationBuilder.add(ModItems.BAMBOO_BARK_CHESTPLATE, "竹胸甲");
        translationBuilder.add(ModItems.OAK_BARK_LEGGINGS, "橡树皮护腿");
        translationBuilder.add(ModItems.SPRUCE_BARK_LEGGINGS, "云杉皮护腿");
        translationBuilder.add(ModItems.BIRCH_BARK_LEGGINGS, "白桦皮护腿");
        translationBuilder.add(ModItems.JUNGLE_BARK_LEGGINGS, "丛林原木皮护腿");
        translationBuilder.add(ModItems.ACACIA_BARK_LEGGINGS, "金合欢皮护腿");
        translationBuilder.add(ModItems.DARK_OAK_BARK_LEGGINGS, "深色橡树皮护腿");
        translationBuilder.add(ModItems.MANGROVE_BARK_LEGGINGS, "红树皮护腿");
        translationBuilder.add(ModItems.CHERRY_BARK_LEGGINGS, "樱花树皮护腿");
        translationBuilder.add(ModItems.CRIMSON_BARK_LEGGINGS, "绯红菌菌柄护腿");
        translationBuilder.add(ModItems.WARPED_BARK_LEGGINGS, "诡异菌菌柄护腿");
        translationBuilder.add(ModItems.BAMBOO_BARK_LEGGINGS, "竹护腿");
        translationBuilder.add(ModItems.OAK_BARK_BOOTS, "橡树皮靴子");
        translationBuilder.add(ModItems.SPRUCE_BARK_BOOTS, "云杉皮靴子");
        translationBuilder.add(ModItems.BIRCH_BARK_BOOTS, "白桦皮靴子");
        translationBuilder.add(ModItems.JUNGLE_BARK_BOOTS, "丛林原木皮靴子");
        translationBuilder.add(ModItems.ACACIA_BARK_BOOTS, "金合欢皮靴子");
        translationBuilder.add(ModItems.DARK_OAK_BARK_BOOTS, "深色橡树皮靴子");
        translationBuilder.add(ModItems.MANGROVE_BARK_BOOTS, "红树皮靴子");
        translationBuilder.add(ModItems.CHERRY_BARK_BOOTS, "樱花树皮靴子");
        translationBuilder.add(ModItems.CRIMSON_BARK_BOOTS, "绯红菌菌柄靴子");
        translationBuilder.add(ModItems.WARPED_BARK_BOOTS, "诡异菌菌柄靴子");
        translationBuilder.add(ModItems.BAMBOO_BARK_BOOTS, "竹靴子");

        translationBuilder.add("trim_material.bark.oak_bark_essence", "橡树质");
        translationBuilder.add("trim_material.bark.spruce_bark_essence", "云杉质");
        translationBuilder.add("trim_material.bark.birch_bark_essence", "白桦质");
        translationBuilder.add("trim_material.bark.jungle_bark_essence", "丛林原木质");
        translationBuilder.add("trim_material.bark.acacia_bark_essence", "金合欢质");
        translationBuilder.add("trim_material.bark.dark_oak_bark_essence", "深色橡树质");
        translationBuilder.add("trim_material.bark.mangrove_bark_essence", "红树质");
        translationBuilder.add("trim_material.bark.cherry_bark_essence", "樱花树质");
        translationBuilder.add("trim_material.bark.crimson_bark_essence", "绯红菌质");
        translationBuilder.add("trim_material.bark.warped_bark_essence", "诡异菌质");
        translationBuilder.add("trim_material.bark.bamboo_bark_essence", "竹质");

        translationBuilder.add(ModItems.OAK_BARK_ESSENCE, "橡树精华");
        translationBuilder.add(ModItems.SPRUCE_BARK_ESSENCE, "云杉精华");
        translationBuilder.add(ModItems.BIRCH_BARK_ESSENCE, "白桦精华");
        translationBuilder.add(ModItems.JUNGLE_BARK_ESSENCE, "丛林原木精华");
        translationBuilder.add(ModItems.ACACIA_BARK_ESSENCE, "金合欢精华");
        translationBuilder.add(ModItems.DARK_OAK_BARK_ESSENCE, "深色橡树精华");
        translationBuilder.add(ModItems.MANGROVE_BARK_ESSENCE, "红树精华");
        translationBuilder.add(ModItems.CHERRY_BARK_ESSENCE, "樱花树精华");
        translationBuilder.add(ModItems.CRIMSON_BARK_ESSENCE, "绯红菌质精华");
        translationBuilder.add(ModItems.WARPED_BARK_ESSENCE, "诡异菌质精华");
        translationBuilder.add(ModItems.BAMBOO_BARK_ESSENCE, "竹精华");

        translationBuilder.add(ModBlocks.QUILMOR, "虬杪馥凝");
        translationBuilder.add(ModBlocks.YAN_CRAFT, "砚");
        translationBuilder.add("container.yan_craft", "砚");
        translationBuilder.add("gui.yan_craft.rate", "成功概率：");
    }
}
