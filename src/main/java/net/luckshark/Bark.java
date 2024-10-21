package net.luckshark;

import net.fabricmc.api.ModInitializer;

import net.luckshark.block.ModBlocks;
import net.luckshark.block.entity.ModBlockEntities;
import net.luckshark.item.ModItemGroups;
import net.luckshark.item.ModItems;
import net.luckshark.recipe.ModRecipeTypes;
import net.luckshark.screen.ModScreenHandlers;
import net.luckshark.tag.ModBlockTags;
import net.luckshark.tag.ModItemTags;

import net.luckshark.world.gen.ModFlowerGeneration;
import net.luckshark.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bark implements ModInitializer {
	public static final String MOD_ID = "bark";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerBlockEntities();
		ModWorldGeneration.generateModWorldGen();
		ModScreenHandlers.registerScreenHandlers();
		ModRecipeTypes.registerRecipeTypes();
		ModItemGroups.registerModItemGroups();
		ModItemTags.registerModItemTags();
		ModBlockTags.registerModBlockTags();
	}
}