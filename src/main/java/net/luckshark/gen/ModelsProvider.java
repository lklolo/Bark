package net.luckshark.gen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
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
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        for (int i = 0; i < ModItems.BARK_LIST.size(); i++) {
            itemModelGenerator.register(ModItems.BARK_LIST.get(i), Models.GENERATED);
        }

        for (int i = 0; i < ModItems.ARMOR_LIST.size(); i++) {
            itemModelGenerator.registerArmor((ArmorItem) ModItems.ARMOR_LIST.get(i));
        }

    }
}
