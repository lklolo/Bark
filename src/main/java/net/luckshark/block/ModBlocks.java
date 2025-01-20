package net.luckshark.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.luckshark.Bark;
import net.luckshark.block.custom.YanCraft;
import net.luckshark.item.ModItemGroups;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.HashMap;
import java.util.Map;

public class ModBlocks {

    public static Map<Block, String> idMap = new HashMap<>();

    public static final Block YAN_CRAFT = BlockRegisters.registerBlock("yan_craft", new YanCraft(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)), ItemGroups.FUNCTIONAL, ModItemGroups.BARK_GROUP_LIST);
    public static final Block QUILMOR = quilmor();
    public static final Block POTTED_QUILMOR = pottedQuilmor();

    public static Block quilmor() {
        Block block = Registry.register(Registries.BLOCK, Identifier.of(Bark.MOD_ID, "quilmor"),
                new FlowerBlock(null, 0, AbstractBlock.Settings.copy(Blocks.DANDELION)));
        Item item =  Registry.register(Registries.ITEM, Identifier.of(Bark.MOD_ID, "quilmor"),
                new BlockItem(block, new Item.Settings().rarity(Rarity.UNCOMMON).maxDamage(16)));
        if (item instanceof BlockItem){
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> entries.add(item));
        ModItemGroups.BARK_GROUP_LIST.add(item);
        return block;
    }

    private static Block pottedQuilmor() {
        return Registry.register(Registries.BLOCK, Identifier.of(Bark.MOD_ID, "quilmor"),
                new FlowerPotBlock(QUILMOR, AbstractBlock.Settings.copy(Blocks.POTTED_DANDELION)));
    }

    public static void registerModBlocks() {
    }
}
