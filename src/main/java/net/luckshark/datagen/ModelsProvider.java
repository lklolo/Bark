package net.luckshark.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.luckshark.block.ModBlocks;
import net.luckshark.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModelsProvider extends FabricModelProvider {
    public ModelsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleState(ModBlocks.YAN_CRAFT);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        for (int i = 0; i < ModItems.BARK_LIST.size(); i++) {
            itemModelGenerator.register(ModItems.BARK_LIST.get(i), Models.GENERATED);
        }
        for (int i = 0; i < ModItems.BARK_ARMOR_LIST.size(); i++) {
            itemModelGenerator.registerArmor((ArmorItem) ModItems.BARK_ARMOR_LIST.get(i));
        }
        for (int i = 0; i < ModItems.BARK_ESSENCE_LIST.size(); i++) {
            itemModelGenerator.register(ModItems.BARK_ESSENCE_LIST.get(i), Models.GENERATED);
        }
    }
}
