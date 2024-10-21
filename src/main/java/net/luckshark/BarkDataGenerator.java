package net.luckshark;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.luckshark.datagen.*;
import net.luckshark.datagen.custom.TrimMaterialsProvider;
import net.luckshark.datagen.custom.YanCraftRecipesProvider;
import net.luckshark.item.ModItems;

public class BarkDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {

		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(BlockTagsProvider::new);
		pack.addProvider(ItemTagsProvider::new);
		pack.addProvider(ModelsProvider::new);
		pack.addProvider(RecipesProvider::new);
		pack.addProvider(ENUSLanProvider::new);
		pack.addProvider(ZHCNLanProvider::new);
		pack.addProvider(LootTableProvider::new);
		TrimMaterialsProvider.generate(ModItems.BARK_ESSENCE_LIST);
		YanCraftRecipesProvider.generate();
	}

}
