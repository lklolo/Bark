package net.luckshark.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.luckshark.block.ModBlocks;
import net.luckshark.tag.ModBlockTags;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class BlockTagsProvider extends FabricTagProvider.BlockTagProvider{
    public BlockTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(ModBlockTags.LOG)
                .add(Blocks.OAK_LOG)
                .add(Blocks.DARK_OAK_LOG)
                .add(Blocks.ACACIA_LOG)
                .add(Blocks.CHERRY_LOG)
                .add(Blocks.BIRCH_LOG)
                .add(Blocks.JUNGLE_LOG)
                .add(Blocks.SPRUCE_LOG)
                .add(Blocks.WARPED_STEM)
                .add(Blocks.CRIMSON_STEM)
                .add(Blocks.MANGROVE_LOG)
                .add(Blocks.BAMBOO_BLOCK)
        ;

        getOrCreateTagBuilder(ModBlockTags.WOOD)
                .add(Blocks.OAK_WOOD)
                .add(Blocks.DARK_OAK_WOOD)
                .add(Blocks.ACACIA_WOOD)
                .add(Blocks.CHERRY_WOOD)
                .add(Blocks.BIRCH_WOOD)
                .add(Blocks.JUNGLE_WOOD)
                .add(Blocks.SPRUCE_WOOD)
                .add(Blocks.WARPED_HYPHAE)
                .add(Blocks.CRIMSON_HYPHAE)
                .add(Blocks.MANGROVE_WOOD)
        ;

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.YAN_CRAFT);
    }
}
