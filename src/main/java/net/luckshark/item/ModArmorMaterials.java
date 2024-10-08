package net.luckshark.item;

import net.luckshark.Bark;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {

    public static final RegistryEntry<ArmorMaterial> OAK_BARK = defaultRegisterBarkMaterial("oak_bark", ModItems.OAK_BARK);
    public static final RegistryEntry<ArmorMaterial> SPRUCE_BARK = defaultRegisterBarkMaterial("spruce_bark", ModItems.SPRUCE_BARK);
    public static final RegistryEntry<ArmorMaterial> BIRCH_BARK = defaultRegisterBarkMaterial("birch_bark", ModItems.BIRCH_BARK);
    public static final RegistryEntry<ArmorMaterial> JUNGLE_BARK = defaultRegisterBarkMaterial("jungle_bark", ModItems.JUNGLE_BARK);
    public static final RegistryEntry<ArmorMaterial> ACACIA_BARK = defaultRegisterBarkMaterial("acacia_bark", ModItems.ACACIA_BARK);
    public static final RegistryEntry<ArmorMaterial> DARK_OAK_BARK = defaultRegisterBarkMaterial("dark_oak_bark", ModItems.DARK_OAK_BARK);
    public static final RegistryEntry<ArmorMaterial> MANGROVE_BARK = defaultRegisterBarkMaterial("mangrove_bark", ModItems.MANGROVE_BARK);
    public static final RegistryEntry<ArmorMaterial> CHERRY_BARK = defaultRegisterBarkMaterial("cherry_bark", ModItems.CHERRY_BARK);
    public static final RegistryEntry<ArmorMaterial> CRIMSON_BARK = defaultRegisterBarkMaterial("crimson_bark", ModItems.CRIMSON_BARK);
    public static final RegistryEntry<ArmorMaterial> WARPED_BARK = defaultRegisterBarkMaterial("warped_bark", ModItems.WARPED_BARK);
    public static final RegistryEntry<ArmorMaterial> BAMBOO_BARK = defaultRegisterMaterial(
            "bamboo_bark",
            1,
            4,
            5,
            2,
            4,
            12,
            SoundEvents.ITEM_ARMOR_EQUIP_WOLF,
            6.0F,
            0.2F,
            Items.BAMBOO);

    private static RegistryEntry<ArmorMaterial> defaultRegisterBarkMaterial(String id, Item item) {
        return defaultRegisterMaterial(
                id,
                1,
                4,
                5,
                2,
                4,
                12,
                SoundEvents.ITEM_ARMOR_EQUIP_WOLF,
                3.0F,
                0.5F,
                item);
    }

    private static RegistryEntry<ArmorMaterial> defaultRegisterMaterial(
            String id,
            int BOOTS,
            int LEGGINGS,
            int CHESTPLATE,
            int HELMET,
            int BODY,
            int enchantability,
            RegistryEntry<SoundEvent> sound,
            float toughness,
            float knockbackResistance,
            Item IngredientItem
    ) {
        return register(id, Util.make(new EnumMap(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.BOOTS, BOOTS);
            map.put(ArmorItem.Type.LEGGINGS, LEGGINGS);
            map.put(ArmorItem.Type.CHESTPLATE, CHESTPLATE);
            map.put(ArmorItem.Type.HELMET, HELMET);
            map.put(ArmorItem.Type.BODY, BODY);
        }), enchantability, sound, toughness, knockbackResistance, () -> Ingredient.ofItems(IngredientItem));
    }

    private static RegistryEntry<ArmorMaterial> register(
            String id,
            EnumMap<ArmorItem.Type, Integer> defense,
            int enchantability,
            RegistryEntry<SoundEvent> equipSound,
            float toughness,
            float knockbackResistance,
            Supplier<Ingredient> repairIngredient
    ) {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(Identifier.of(Bark.MOD_ID, id)));
        return register(id, defense, enchantability, equipSound, toughness, knockbackResistance, repairIngredient, list);
    }

    private static RegistryEntry<ArmorMaterial> register(
            String id,
            EnumMap<ArmorItem.Type, Integer> defense,
            int enchantability,
            RegistryEntry<SoundEvent> equipSound,
            float toughness,
            float knockbackResistance,
            Supplier<Ingredient> repairIngredient,
            List<ArmorMaterial.Layer> layers
    ) {
        EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap(ArmorItem.Type.class);

        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            enumMap.put(type, (Integer)defense.get(type));
        }

        return Registry.registerReference(
                Registries.ARMOR_MATERIAL,
                Identifier.ofVanilla(id),
                new ArmorMaterial(enumMap, enchantability, equipSound, repairIngredient, layers, toughness, knockbackResistance)
        );
    }
}

