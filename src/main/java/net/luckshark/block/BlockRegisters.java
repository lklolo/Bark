package net.luckshark.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.luckshark.Bark;
import net.luckshark.item.ItemRegisters;
import net.luckshark.item.ModItemGroups;
import net.luckshark.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.FlowerBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import java.util.List;

public class BlockRegisters {
    public static void registerBlockItems(String id, Block block) {
        Item item =  Registry.register(Registries.ITEM, Identifier.of(Bark.MOD_ID, id), new BlockItem(block, new Item.Settings()));
        if (item instanceof BlockItem){
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }
    }
    public static void registerBlockItems(String id, Block block, RegistryKey<ItemGroup> itemGroup, List<Item> list) {
        Item item =  Registry.register(Registries.ITEM, Identifier.of(Bark.MOD_ID, id), new BlockItem(block, new Item.Settings()));
        if (item instanceof BlockItem){
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }
        ItemGroupEvents.modifyEntriesEvent(itemGroup).register(entries -> entries.add(item));
        ModItemGroups.BARK_GROUP_LIST.add(item);
    }
    public static Block registerBlock(String id, Block block) {
        registerBlockItems(id, block);
        ModBlocks.idMap.put(block, id);
        return Registry.register(Registries.BLOCK, Identifier.of(Bark.MOD_ID, id), block);
    }
    public static Block registerBlock(String id, Block Block, RegistryKey<ItemGroup> itemGroup, List<Item> list) {
        registerBlockItems(id, Block, itemGroup, list);
        Block block = registerBlock(id, Block);
        return block;
    }
}
