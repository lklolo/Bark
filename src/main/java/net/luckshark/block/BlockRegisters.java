package net.luckshark.block;

import net.luckshark.Bark;
import net.luckshark.item.ItemRegisters;
import net.minecraft.block.Block;
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
        Item item =  ItemRegisters.registerItem(id, new BlockItem(block, new Item.Settings()));
        if(item instanceof BlockItem){
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }
    }
    public static Block registerBlock(String id, Block block) {
        registerBlockItems(id, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Bark.MOD_ID, id), block);
    }
    public static Block registerBlock(String id, Block Block, RegistryKey<ItemGroup> itemGroup, List<Item> list) {
        registerBlockItems(id, Block);
        Block block = registerBlock(id, Block);
        ModBlocks.idMap.put(block, id);
        return block;
    }
}
