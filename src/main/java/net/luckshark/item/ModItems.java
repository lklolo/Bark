package net.luckshark.item;

import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModItems {

    public static Map<Item, String> idMap = new HashMap<>();

    public static List<Item> BARK_ARMOR_LIST = new ArrayList<>();
    public static List<Item> BARK_HELMET_LIST = new ArrayList<>();
    public static List<Item> BARK_CHESTPLATE_LIST = new ArrayList<>();
    public static List<Item> BARK_LEGGINGS_LIST = new ArrayList<>();
    public static List<Item> BARK_BOOTS_LIST = new ArrayList<>();
    public static List<Item> BARK_LIST = new ArrayList<>();
    public static List<Item> BARK_ESSENCE_LIST = new ArrayList<>();

    public static final Item OAK_BARK = ItemRegisters.bark("oak_bark");
    public static final Item SPRUCE_BARK = ItemRegisters.bark("spruce_bark");
    public static final Item BIRCH_BARK = ItemRegisters.bark("birch_bark");
    public static final Item JUNGLE_BARK = ItemRegisters.bark("jungle_bark");
    public static final Item ACACIA_BARK = ItemRegisters.bark("acacia_bark");
    public static final Item DARK_OAK_BARK = ItemRegisters.bark("dark_oak_bark");
    public static final Item MANGROVE_BARK = ItemRegisters.bark("mangrove_bark");
    public static final Item CHERRY_BARK = ItemRegisters.bark("cherry_bark");
    public static final Item BAMBOO_BARK = ItemRegisters.bark("bamboo_bark");
    public static final Item CRIMSON_BARK = ItemRegisters.bark("crimson_bark");
    public static final Item WARPED_BARK = ItemRegisters.bark("warped_bark");

    public static final Item OAK_BARK_ESSENCE = ItemRegisters.essence("oak_bark_essence");
    public static final Item SPRUCE_BARK_ESSENCE = ItemRegisters.essence("spruce_bark_essence");
    public static final Item BIRCH_BARK_ESSENCE = ItemRegisters.essence("birch_bark_essence");
    public static final Item JUNGLE_BARK_ESSENCE = ItemRegisters.essence("jungle_bark_essence");
    public static final Item ACACIA_BARK_ESSENCE = ItemRegisters.essence("acacia_bark_essence");
    public static final Item DARK_OAK_BARK_ESSENCE = ItemRegisters.essence("dark_oak_bark_essence");
    public static final Item MANGROVE_BARK_ESSENCE = ItemRegisters.essence("mangrove_bark_essence");
    public static final Item CHERRY_BARK_ESSENCE = ItemRegisters.essence("cherry_bark_essence");
    public static final Item BAMBOO_BARK_ESSENCE = ItemRegisters.essence("bamboo_bark_essence");
    public static final Item CRIMSON_BARK_ESSENCE = ItemRegisters.essence("crimson_bark_essence");
    public static final Item WARPED_BARK_ESSENCE = ItemRegisters.essence("warped_bark_essence");

    public static final Item OAK_BARK_HELMET = ItemRegisters.barkArmor("oak_bark_helmet", ModArmorMaterials.OAK_BARK, 6, 3);
    public static final Item SPRUCE_BARK_HELMET = ItemRegisters.barkArmor("spruce_bark_helmet", ModArmorMaterials.SPRUCE_BARK, 6, 3);
    public static final Item BIRCH_BARK_HELMET = ItemRegisters.barkArmor("birch_bark_helmet", ModArmorMaterials.BIRCH_BARK, 6, 3);
    public static final Item JUNGLE_BARK_HELMET = ItemRegisters.barkArmor("jungle_bark_helmet", ModArmorMaterials.JUNGLE_BARK, 6, 3);
    public static final Item ACACIA_BARK_HELMET = ItemRegisters.barkArmor("acacia_bark_helmet", ModArmorMaterials.ACACIA_BARK, 6, 3);
    public static final Item DARK_OAK_BARK_HELMET = ItemRegisters.barkArmor("dark_oak_bark_helmet", ModArmorMaterials.DARK_OAK_BARK, 6, 3);
    public static final Item MANGROVE_BARK_HELMET = ItemRegisters.barkArmor("mangrove_bark_helmet", ModArmorMaterials.MANGROVE_BARK, 6, 3);
    public static final Item CHERRY_BARK_HELMET = ItemRegisters.barkArmor("cherry_bark_helmet", ModArmorMaterials.CHERRY_BARK, 6, 3);
    public static final Item BAMBOO_BARK_HELMET = ItemRegisters.barkArmor("bamboo_bark_helmet", ModArmorMaterials.BAMBOO_BARK, 4, 3);
    public static final Item CRIMSON_BARK_HELMET = ItemRegisters.barkArmor("crimson_bark_helmet", ModArmorMaterials.CRIMSON_BARK, 6, 3, true);
    public static final Item WARPED_BARK_HELMET = ItemRegisters.barkArmor("warped_bark_helmet", ModArmorMaterials.WARPED_BARK, 6, 3, true);
    public static final Item OAK_BARK_CHESTPLATE = ItemRegisters.barkArmor("oak_bark_chestplate", ModArmorMaterials.OAK_BARK, 8, 2);
    public static final Item SPRUCE_BARK_CHESTPLATE = ItemRegisters.barkArmor("spruce_bark_chestplate", ModArmorMaterials.SPRUCE_BARK, 8, 2);
    public static final Item BIRCH_BARK_CHESTPLATE = ItemRegisters.barkArmor("birch_bark_chestplate", ModArmorMaterials.BIRCH_BARK, 8, 2);
    public static final Item JUNGLE_BARK_CHESTPLATE = ItemRegisters.barkArmor("jungle_bark_chestplate", ModArmorMaterials.JUNGLE_BARK, 8, 2);
    public static final Item ACACIA_BARK_CHESTPLATE = ItemRegisters.barkArmor("acacia_bark_chestplate", ModArmorMaterials.ACACIA_BARK, 8, 2);
    public static final Item DARK_OAK_BARK_CHESTPLATE = ItemRegisters.barkArmor("dark_oak_bark_chestplate", ModArmorMaterials.DARK_OAK_BARK, 8, 2);
    public static final Item MANGROVE_BARK_CHESTPLATE = ItemRegisters.barkArmor("mangrove_bark_chestplate", ModArmorMaterials.MANGROVE_BARK, 8, 2);
    public static final Item CHERRY_BARK_CHESTPLATE = ItemRegisters.barkArmor("cherry_bark_chestplate", ModArmorMaterials.CHERRY_BARK, 8, 2);
    public static final Item BAMBOO_BARK_CHESTPLATE = ItemRegisters.barkArmor("bamboo_bark_chestplate", ModArmorMaterials.BAMBOO_BARK, 6, 2);
    public static final Item CRIMSON_BARK_CHESTPLATE = ItemRegisters.barkArmor("crimson_bark_chestplate", ModArmorMaterials.CRIMSON_BARK, 8, 2, true);
    public static final Item WARPED_BARK_CHESTPLATE = ItemRegisters.barkArmor("warped_bark_chestplate", ModArmorMaterials.WARPED_BARK, 8, 2, true);
    public static final Item OAK_BARK_LEGGINGS = ItemRegisters.barkArmor("oak_bark_leggings", ModArmorMaterials.OAK_BARK, 7, 1);
    public static final Item SPRUCE_BARK_LEGGINGS = ItemRegisters.barkArmor("spruce_bark_leggings", ModArmorMaterials.SPRUCE_BARK, 7, 1);
    public static final Item BIRCH_BARK_LEGGINGS = ItemRegisters.barkArmor("birch_bark_leggings", ModArmorMaterials.BIRCH_BARK, 7, 1);
    public static final Item JUNGLE_BARK_LEGGINGS = ItemRegisters.barkArmor("jungle_bark_leggings", ModArmorMaterials.JUNGLE_BARK, 7, 1);
    public static final Item ACACIA_BARK_LEGGINGS = ItemRegisters.barkArmor("acacia_bark_leggings", ModArmorMaterials.ACACIA_BARK, 7, 1);
    public static final Item DARK_OAK_BARK_LEGGINGS = ItemRegisters.barkArmor("dark_oak_bark_leggings", ModArmorMaterials.DARK_OAK_BARK, 7, 1);
    public static final Item MANGROVE_BARK_LEGGINGS = ItemRegisters.barkArmor("mangrove_bark_leggings", ModArmorMaterials.MANGROVE_BARK, 7, 1);
    public static final Item CHERRY_BARK_LEGGINGS = ItemRegisters.barkArmor("cherry_bark_leggings", ModArmorMaterials.CHERRY_BARK, 7, 1);
    public static final Item BAMBOO_BARK_LEGGINGS = ItemRegisters.barkArmor("bamboo_bark_leggings", ModArmorMaterials.BAMBOO_BARK, 5, 1);
    public static final Item CRIMSON_BARK_LEGGINGS = ItemRegisters.barkArmor("crimson_bark_leggings", ModArmorMaterials.CRIMSON_BARK, 7, 1, true);
    public static final Item WARPED_BARK_LEGGINGS = ItemRegisters.barkArmor("warped_bark_leggings", ModArmorMaterials.WARPED_BARK, 7, 1, true);
    public static final Item OAK_BARK_BOOTS = ItemRegisters.barkArmor("oak_bark_boots", ModArmorMaterials.OAK_BARK, 5, 0);
    public static final Item SPRUCE_BARK_BOOTS = ItemRegisters.barkArmor("spruce_bark_boots", ModArmorMaterials.SPRUCE_BARK, 5, 0);
    public static final Item BIRCH_BARK_BOOTS = ItemRegisters.barkArmor("birch_bark_boots", ModArmorMaterials.BIRCH_BARK, 5, 0);
    public static final Item JUNGLE_BARK_BOOTS = ItemRegisters.barkArmor("jungle_bark_boots", ModArmorMaterials.JUNGLE_BARK, 5, 0);
    public static final Item ACACIA_BARK_BOOTS = ItemRegisters.barkArmor("acacia_bark_boots", ModArmorMaterials.ACACIA_BARK, 5, 0);
    public static final Item DARK_OAK_BARK_BOOTS = ItemRegisters.barkArmor("dark_oak_bark_boots", ModArmorMaterials.DARK_OAK_BARK, 5, 0);
    public static final Item MANGROVE_BARK_BOOTS = ItemRegisters.barkArmor("mangrove_bark_boots", ModArmorMaterials.MANGROVE_BARK, 5, 0);
    public static final Item CHERRY_BARK_BOOTS = ItemRegisters.barkArmor("cherry_bark_boots", ModArmorMaterials.CHERRY_BARK, 5, 0);
    public static final Item BAMBOO_BARK_BOOTS = ItemRegisters.barkArmor("bamboo_bark_boots", ModArmorMaterials.BAMBOO_BARK, 3, 0);
    public static final Item CRIMSON_BARK_BOOTS = ItemRegisters.barkArmor("crimson_bark_boots", ModArmorMaterials.CRIMSON_BARK, 5, 0, true);
    public static final Item WARPED_BARK_BOOTS = ItemRegisters.barkArmor("warped_bark_boots", ModArmorMaterials.WARPED_BARK, 5, 0, true);

    public static void registerModItems(){
        ItemRegisters.incombustibility(CRIMSON_BARK);
        ItemRegisters.incombustibility(WARPED_BARK);
        ItemRegisters.incombustibility(CRIMSON_BARK_HELMET);
        ItemRegisters.incombustibility(WARPED_BARK_HELMET);
        ItemRegisters.incombustibility(CRIMSON_BARK_CHESTPLATE);
        ItemRegisters.incombustibility(WARPED_BARK_CHESTPLATE);
        ItemRegisters.incombustibility(CRIMSON_BARK_LEGGINGS);
        ItemRegisters.incombustibility(WARPED_BARK_LEGGINGS);
        ItemRegisters.incombustibility(CRIMSON_BARK_BOOTS);
        ItemRegisters.incombustibility(WARPED_BARK_BOOTS);
    }


}
