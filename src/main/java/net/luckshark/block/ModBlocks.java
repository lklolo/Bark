package net.luckshark.block;

import net.luckshark.item.ModItemGroups;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroups;

import java.util.HashMap;
import java.util.Map;

public class ModBlocks {

    public static Map<Block, String> idMap = new HashMap<>();

    public static final Block YAN = BlockRegisters.registerBlock("yan", new Block(AbstractBlock.Settings.copy(Blocks.FURNACE)), ItemGroups.OPERATOR, ModItemGroups.BARK_GROUP_LIST);

    public static void registerModBlocks() {
    }
}
