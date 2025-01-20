package net.luckshark.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.luckshark.block.ModBlocks;
import net.luckshark.item.ModItems;
import net.luckshark.tag.ModItemTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ItemTagsProvider extends FabricTagProvider.ItemTagProvider{
    public ItemTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        for (int i = 0; i < ModItems.BARK_ARMOR_LIST.size(); i++) {
            getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR).add(ModItems.BARK_ARMOR_LIST.get(i));
        }
        for (int i = 0; i < ModItems.BARK_ESSENCE_LIST.size(); i++) {
            getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS).add(ModItems.BARK_ESSENCE_LIST.get(i));
        }
    }

}
