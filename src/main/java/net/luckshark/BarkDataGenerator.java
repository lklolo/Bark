package net.luckshark;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.luckshark.gen.*;

public class BarkDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {

		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(BlockTagsProvider::new);
		pack.addProvider(ItemTagsProvider::new);
		pack.addProvider(ModelsProvider::new);

	}
}
