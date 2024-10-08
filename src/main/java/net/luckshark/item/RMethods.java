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

import java.util.List;

public class RMethods {

    public static final int HELMET = 3;
    public static final int CHESTPLATE = 2;
    public static final int LEGGINGS = 1;
    public static final int BOOTS = 0;

    public static Item incombustibility(Item item) {
        ModItems.INCOMBUSTIBILITY_LIST.add(item);
        return item;
    }

    //下列方法命名中，'R'表示"register、'DR'表示"defaultRegister"
    public static Item RItems(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Bark.MOD_ID, id), item);
    }

    public static Item DRItems(String id, Item newItem, RegistryKey<ItemGroup> itemGroup, List<Item> list) {
        Item item = RItems(id, newItem);
        ItemGroupEvents.modifyEntriesEvent(itemGroup).register(entries -> entries.add(item));
        ModItemGroups.addItemToGroup(item, list);
        return item;
    }

    public static Item DRBark(String id) {
        Item Item = DRItems(id, new Item(new Item.Settings()), ItemGroups.INGREDIENTS, ModItemGroups.BARK_GROUP_LIST);
        ModItems.BARK_LIST.add(Item);
        return Item;
    }

    public static Item DRArmorItem(String id, RegistryEntry<ArmorMaterial> material, int multiplier, int type) {
        Item item;
        switch (type) {
            case 3 :
                item = DRItems(id,
                    new ModArmorItem(
                            material,
                            ArmorItem.Type.HELMET,
                            new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(multiplier))
                    ),
                    ItemGroups.COMBAT,
                    ModItemGroups.BARK_GROUP_LIST
            );
                ModItems.ARMOR_LIST.add(item);
                return item;
            case 2 :
                item = DRItems(id,
                    new ModArmorItem(
                            material,
                            ArmorItem.Type.CHESTPLATE,
                            new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(multiplier))
                    ),
                    ItemGroups.COMBAT,
                    ModItemGroups.BARK_GROUP_LIST
            );
                ModItems.ARMOR_LIST.add(item);
                return item;
            case 1 :
                item = DRItems(id,
                    new ModArmorItem(
                            material,
                            ArmorItem.Type.LEGGINGS,
                            new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(multiplier))
                    ),
                    ItemGroups.COMBAT,
                    ModItemGroups.BARK_GROUP_LIST
            );
                ModItems.ARMOR_LIST.add(item);
                return item;
            case 0 :
                item = DRItems(id,
                    new ModArmorItem(
                            material,
                            ArmorItem.Type.BOOTS,
                            new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(multiplier))
                    ),
                    ItemGroups.COMBAT,
                    ModItemGroups.BARK_GROUP_LIST
            );
                ModItems.ARMOR_LIST.add(item);
                return item;
            default : {
                return null;
            }
        }
    }

    public static Item DRArmorItem(String id, RegistryEntry<ArmorMaterial> material, int multiplier, int type, boolean fireproof) {
        if (!fireproof) return DRArmorItem(id, material, multiplier, type);
        Item item;
        switch (type) {
            case 3 :
                item = DRItems(id,
                        new ModArmorItem(
                                material,
                                ArmorItem.Type.HELMET,
                                new Item.Settings().fireproof().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(multiplier))
                        ),
                        ItemGroups.COMBAT,
                        ModItemGroups.BARK_GROUP_LIST
                );
                ModItems.ARMOR_LIST.add(item);
                return item;
            case 2 :
                item = DRItems(id,
                        new ModArmorItem(
                                material,
                                ArmorItem.Type.CHESTPLATE,
                                new Item.Settings().fireproof().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(multiplier))
                        ),
                        ItemGroups.COMBAT,
                        ModItemGroups.BARK_GROUP_LIST
                );
                ModItems.ARMOR_LIST.add(item);
                return item;
            case 1 :
                item = DRItems(id,
                        new ModArmorItem(
                                material,
                                ArmorItem.Type.LEGGINGS,
                                new Item.Settings().fireproof().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(multiplier))
                        ),
                        ItemGroups.COMBAT,
                        ModItemGroups.BARK_GROUP_LIST
                );
                ModItems.ARMOR_LIST.add(item);
                return item;
            case 0 :
                item = DRItems(id,
                        new ModArmorItem(
                                material,
                                ArmorItem.Type.BOOTS,
                                new Item.Settings().fireproof().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(multiplier))
                        ),
                        ItemGroups.COMBAT,
                        ModItemGroups.BARK_GROUP_LIST
                );
                ModItems.ARMOR_LIST.add(item);
                return item;
            default : {
                return null;
            }
        }
    }
}
