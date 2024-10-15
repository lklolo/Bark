package net.luckshark;

import net.fabricmc.api.ModInitializer;

import net.luckshark.item.ModItemGroups;
import net.luckshark.item.ModItems;
import net.luckshark.tag.ModBlockTags;
import net.luckshark.tag.ModItemTags;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bark implements ModInitializer {
	public static final String MOD_ID = "bark";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModItems.registerModItems();
		//ModBlocks.registerModBlocks();
		ModItemGroups.registerModItemGroups();
		ModItemTags.registerModItemTags();
		ModBlockTags.registerModBlockTags();
	}
}