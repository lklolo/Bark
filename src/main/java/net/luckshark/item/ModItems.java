package net.luckshark.item;

import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

    public static List<Item> ARMOR_LIST = new ArrayList<>();
    public static List<Item> BARK_LIST = new ArrayList<>();

    public static List<Item> INCOMBUSTIBILITY_LIST = new ArrayList<>();

    public static final Item OAK_BARK = RMethods.DRBark("oak_bark");
    public static final Item SPRUCE_BARK = RMethods.DRBark("spruce_bark");
    public static final Item BIRCH_BARK = RMethods.DRBark("birch_bark");
    public static final Item JUNGLE_BARK = RMethods.DRBark("jungle_bark");
    public static final Item ACACIA_BARK = RMethods.DRBark("acacia_bark");
    public static final Item DARK_OAK_BARK = RMethods.DRBark("dark_oak_bark");
    public static final Item MANGROVE_BARK = RMethods.DRBark("mangrove_bark");
    public static final Item CHERRY_BARK = RMethods.DRBark("cherry_bark");
    public static final Item BAMBOO_BARK = RMethods.DRBark("bamboo_bark");
    public static final Item CRIMSON_BARK = RMethods.incombustibility(RMethods.DRBark("crimson_bark"));
    public static final Item WARPED_BARK = RMethods.incombustibility(RMethods.DRBark("warped_bark"));

    public static final Item OAK_BARK_HELMET = RMethods.DRArmorItem("oak_bark_helmet", ModArmorMaterials.OAK_BARK, 6, RMethods.HELMET);
    public static final Item SPRUCE_BARK_HELMET = RMethods.DRArmorItem("spruce_bark_helmet", ModArmorMaterials.SPRUCE_BARK, 6, RMethods.HELMET);
    public static final Item BIRCH_BARK_HELMET = RMethods.DRArmorItem("birch_bark_helmet", ModArmorMaterials.BIRCH_BARK, 6, RMethods.HELMET);
    public static final Item JUNGLE_BARK_HELMET = RMethods.DRArmorItem("jungle_bark_helmet", ModArmorMaterials.JUNGLE_BARK, 6, RMethods.HELMET);
    public static final Item ACACIA_BARK_HELMET = RMethods.DRArmorItem("acacia_bark_helmet", ModArmorMaterials.ACACIA_BARK, 6, RMethods.HELMET);
    public static final Item DARK_OAK_BARK_HELMET = RMethods.DRArmorItem("dark_oak_bark_helmet", ModArmorMaterials.DARK_OAK_BARK, 6, RMethods.HELMET);
    public static final Item MANGROVE_BARK_HELMET = RMethods.DRArmorItem("mangrove_bark_helmet", ModArmorMaterials.MANGROVE_BARK, 6, RMethods.HELMET);
    public static final Item CHERRY_BARK_HELMET = RMethods.DRArmorItem("cherry_bark_helmet", ModArmorMaterials.CHERRY_BARK, 6, RMethods.HELMET);
    public static final Item BAMBOO_BARK_HELMET = RMethods.DRArmorItem("bamboo_bark_helmet", ModArmorMaterials.BAMBOO_BARK, 4, RMethods.HELMET);
    public static final Item CRIMSON_BARK_HELMET = RMethods.incombustibility(RMethods.DRArmorItem("crimson_bark_helmet", ModArmorMaterials.CRIMSON_BARK, 6, RMethods.HELMET, true));
    public static final Item WARPED_BARK_HELMET = RMethods.incombustibility(RMethods.DRArmorItem("warped_bark_helmet", ModArmorMaterials.WARPED_BARK, 6, RMethods.HELMET, true));
    public static final Item OAK_BARK_CHESTPLATE = RMethods.DRArmorItem("oak_bark_chestplate", ModArmorMaterials.OAK_BARK, 8, RMethods.CHESTPLATE);
    public static final Item SPRUCE_BARK_CHESTPLATE = RMethods.DRArmorItem("spruce_bark_chestplate", ModArmorMaterials.SPRUCE_BARK, 8, RMethods.CHESTPLATE);
    public static final Item BIRCH_BARK_CHESTPLATE = RMethods.DRArmorItem("birch_bark_chestplate", ModArmorMaterials.BIRCH_BARK, 8, RMethods.CHESTPLATE);
    public static final Item JUNGLE_BARK_CHESTPLATE = RMethods.DRArmorItem("jungle_bark_chestplate", ModArmorMaterials.JUNGLE_BARK, 8, RMethods.CHESTPLATE);
    public static final Item ACACIA_BARK_CHESTPLATE = RMethods.DRArmorItem("acacia_bark_chestplate", ModArmorMaterials.ACACIA_BARK, 8, RMethods.CHESTPLATE);
    public static final Item DARK_OAK_BARK_CHESTPLATE = RMethods.DRArmorItem("dark_oak_bark_chestplate", ModArmorMaterials.DARK_OAK_BARK, 8, RMethods.CHESTPLATE);
    public static final Item MANGROVE_BARK_CHESTPLATE = RMethods.DRArmorItem("mangrove_bark_chestplate", ModArmorMaterials.MANGROVE_BARK, 8, RMethods.CHESTPLATE);
    public static final Item CHERRY_BARK_CHESTPLATE = RMethods.DRArmorItem("cherry_bark_chestplate", ModArmorMaterials.CHERRY_BARK, 8, RMethods.CHESTPLATE);
    public static final Item BAMBOO_BARK_CHESTPLATE = RMethods.DRArmorItem("bamboo_bark_chestplate", ModArmorMaterials.BAMBOO_BARK, 6, RMethods.CHESTPLATE);
    public static final Item CRIMSON_BARK_CHESTPLATE = RMethods.incombustibility(RMethods.DRArmorItem("crimson_bark_chestplate", ModArmorMaterials.CRIMSON_BARK, 8, RMethods.CHESTPLATE, true));
    public static final Item WARPED_BARK_CHESTPLATE = RMethods.incombustibility(RMethods.DRArmorItem("warped_bark_chestplate", ModArmorMaterials.WARPED_BARK, 8, RMethods.CHESTPLATE, true));
    public static final Item OAK_BARK_LEGGINGS = RMethods.DRArmorItem("oak_bark_leggings", ModArmorMaterials.OAK_BARK, 7, RMethods.LEGGINGS);
    public static final Item SPRUCE_BARK_LEGGINGS = RMethods.DRArmorItem("spruce_bark_leggings", ModArmorMaterials.SPRUCE_BARK, 7, RMethods.LEGGINGS);
    public static final Item BIRCH_BARK_LEGGINGS = RMethods.DRArmorItem("birch_bark_leggings", ModArmorMaterials.BIRCH_BARK, 7, RMethods.LEGGINGS);
    public static final Item JUNGLE_BARK_LEGGINGS = RMethods.DRArmorItem("jungle_bark_leggings", ModArmorMaterials.JUNGLE_BARK, 7, RMethods.LEGGINGS);
    public static final Item ACACIA_BARK_LEGGINGS = RMethods.DRArmorItem("acacia_bark_leggings", ModArmorMaterials.ACACIA_BARK, 7, RMethods.LEGGINGS);
    public static final Item DARK_OAK_BARK_LEGGINGS = RMethods.DRArmorItem("dark_oak_bark_leggings", ModArmorMaterials.DARK_OAK_BARK, 7, RMethods.LEGGINGS);
    public static final Item MANGROVE_BARK_LEGGINGS = RMethods.DRArmorItem("mangrove_bark_leggings", ModArmorMaterials.MANGROVE_BARK, 7, RMethods.LEGGINGS);
    public static final Item CHERRY_BARK_LEGGINGS = RMethods.DRArmorItem("cherry_bark_leggings", ModArmorMaterials.CHERRY_BARK, 7, RMethods.LEGGINGS);
    public static final Item BAMBOO_BARK_LEGGINGS = RMethods.DRArmorItem("bamboo_bark_leggings", ModArmorMaterials.BAMBOO_BARK, 5, RMethods.LEGGINGS);
    public static final Item CRIMSON_BARK_LEGGINGS = RMethods.incombustibility(RMethods.DRArmorItem("crimson_bark_leggings", ModArmorMaterials.CRIMSON_BARK, 7, RMethods.LEGGINGS, true));
    public static final Item WARPED_BARK_LEGGINGS = RMethods.incombustibility(RMethods.DRArmorItem("warped_bark_leggings", ModArmorMaterials.WARPED_BARK, 7, RMethods.LEGGINGS, true));
    public static final Item OAK_BARK_BOOTS = RMethods.DRArmorItem("oak_bark_boots", ModArmorMaterials.OAK_BARK, 5, RMethods.BOOTS);
    public static final Item SPRUCE_BARK_BOOTS = RMethods.DRArmorItem("spruce_bark_boots", ModArmorMaterials.SPRUCE_BARK, 5, RMethods.BOOTS);
    public static final Item BIRCH_BARK_BOOTS = RMethods.DRArmorItem("birch_bark_boots", ModArmorMaterials.BIRCH_BARK, 5, RMethods.BOOTS);
    public static final Item JUNGLE_BARK_BOOTS = RMethods.DRArmorItem("jungle_bark_boots", ModArmorMaterials.JUNGLE_BARK, 5, RMethods.BOOTS);
    public static final Item ACACIA_BARK_BOOTS = RMethods.DRArmorItem("acacia_bark_boots", ModArmorMaterials.ACACIA_BARK, 5, RMethods.BOOTS);
    public static final Item DARK_OAK_BARK_BOOTS = RMethods.DRArmorItem("dark_oak_bark_boots", ModArmorMaterials.DARK_OAK_BARK, 5, RMethods.BOOTS);
    public static final Item MANGROVE_BARK_BOOTS = RMethods.DRArmorItem("mangrove_bark_boots", ModArmorMaterials.MANGROVE_BARK, 5, RMethods.BOOTS);
    public static final Item CHERRY_BARK_BOOTS = RMethods.DRArmorItem("cherry_bark_boots", ModArmorMaterials.CHERRY_BARK, 5, RMethods.BOOTS);
    public static final Item BAMBOO_BARK_BOOTS = RMethods.DRArmorItem("bamboo_bark_boots", ModArmorMaterials.BAMBOO_BARK, 3, RMethods.BOOTS);
    public static final Item CRIMSON_BARK_BOOTS = RMethods.incombustibility(RMethods.DRArmorItem("crimson_bark_boots", ModArmorMaterials.CRIMSON_BARK, 5, RMethods.BOOTS, true));
    public static final Item WARPED_BARK_BOOTS = RMethods.incombustibility(RMethods.DRArmorItem("warped_bark_boots", ModArmorMaterials.WARPED_BARK, 5, RMethods.BOOTS, true));

    public static void registerModItems(){
    }

}
