package net.luckshark.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.luckshark.Bark;
import net.luckshark.item.custom.ModArmorItem;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ItemRegisters {

    public static List<Item> INCOMBUSTIBILITY_LIST = new ArrayList<>();

    public static void incombustibility(Item item) {
        INCOMBUSTIBILITY_LIST.add(item);
    }

    public static Item RegisterItem(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Bark.MOD_ID, id), item);
    }

    public static Item RegisterItem(String id, Item Item, RegistryKey<ItemGroup> itemGroup, List<Item> list) {
        Item item = RegisterItem(id, Item);
        ItemGroupEvents.modifyEntriesEvent(itemGroup).register(entries -> entries.add(item));
        ModItemGroups.addItemToGroup(item, list);
        return item;
    }

    public static Item Bark(String id) {
        Item Item = RegisterItem(id, new Item(new Item.Settings().food(ModFoodComponents.MAP.get(id))), ItemGroups.INGREDIENTS, ModItemGroups.BARK_GROUP_LIST);
        ModItems.BARK_LIST.add(Item);
        return Item;
    }

    public static Item barkArmor(String id, RegistryEntry<ArmorMaterial> material, int multiplier, int type) {
        Item item;
        switch (type) {
            case 3 :
                item = RegisterItem(id,
                    new ModArmorItem(
                            material,
                            ArmorItem.Type.HELMET,
                            new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(multiplier))
                    ),
                    ItemGroups.COMBAT,
                    ModItemGroups.BARK_GROUP_LIST
            );
                ModItems.BARK_ARMOR_LIST.add(item);
                ModItems.BARK_HELMET_LIST.add(item);
                return item;
            case 2 :
                item = RegisterItem(id,
                    new ModArmorItem(
                            material,
                            ArmorItem.Type.CHESTPLATE,
                            new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(multiplier))
                    ),
                    ItemGroups.COMBAT,
                    ModItemGroups.BARK_GROUP_LIST
            );
                ModItems.BARK_ARMOR_LIST.add(item);
                ModItems.BARK_CHESTPLATE_LIST.add(item);
                return item;
            case 1 :
                item = RegisterItem(id,
                    new ModArmorItem(
                            material,
                            ArmorItem.Type.LEGGINGS,
                            new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(multiplier))
                    ),
                    ItemGroups.COMBAT,
                    ModItemGroups.BARK_GROUP_LIST
            );
                ModItems.BARK_ARMOR_LIST.add(item);
                ModItems.BARK_LEGGINGS_LIST.add(item);
                return item;
            case 0 :
                item = RegisterItem(id,
                    new ModArmorItem(
                            material,
                            ArmorItem.Type.BOOTS,
                            new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(multiplier))
                    ),
                    ItemGroups.COMBAT,
                    ModItemGroups.BARK_GROUP_LIST
            );
                ModItems.BARK_ARMOR_LIST.add(item);
                ModItems.BARK_BOOTS_LIST.add(item);
                return item;
            default : {
                return null;
            }
        }
    }

    public static Item barkArmor(String id, RegistryEntry<ArmorMaterial> material, int multiplier, int type, boolean fireproof) {
        if (!fireproof) return barkArmor(id, material, multiplier, type);
        Item item;
        switch (type) {
            case 3 :
                item = RegisterItem(id,
                        new ModArmorItem(
                                material,
                                ArmorItem.Type.HELMET,
                                new Item.Settings().fireproof().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(multiplier))
                        ),
                        ItemGroups.COMBAT,
                        ModItemGroups.BARK_GROUP_LIST
                );
                ModItems.BARK_ARMOR_LIST.add(item);
                ModItems.BARK_HELMET_LIST.add(item);
                return item;
            case 2 :
                item = RegisterItem(id,
                        new ModArmorItem(
                                material,
                                ArmorItem.Type.CHESTPLATE,
                                new Item.Settings().fireproof().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(multiplier))
                        ),
                        ItemGroups.COMBAT,
                        ModItemGroups.BARK_GROUP_LIST
                );
                ModItems.BARK_ARMOR_LIST.add(item);
                ModItems.BARK_CHESTPLATE_LIST.add(item);
                return item;
            case 1 :
                item = RegisterItem(id,
                        new ModArmorItem(
                                material,
                                ArmorItem.Type.LEGGINGS,
                                new Item.Settings().fireproof().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(multiplier))
                        ),
                        ItemGroups.COMBAT,
                        ModItemGroups.BARK_GROUP_LIST
                );
                ModItems.BARK_ARMOR_LIST.add(item);
                ModItems.BARK_LEGGINGS_LIST.add(item);
                return item;
            case 0 :
                item = RegisterItem(id,
                        new ModArmorItem(
                                material,
                                ArmorItem.Type.BOOTS,
                                new Item.Settings().fireproof().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(multiplier))
                        ),
                        ItemGroups.COMBAT,
                        ModItemGroups.BARK_GROUP_LIST
                );
                ModItems.BARK_ARMOR_LIST.add(item);
                ModItems.BARK_BOOTS_LIST.add(item);
                return item;
            default : {
                return null;
            }
        }
    }
}