package net.luckshark.mixin;

import com.google.common.collect.ImmutableMap;
import net.luckshark.item.ModItems;
import net.luckshark.tag.ModBlockTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Mixin(AxeItem.class)
public class TryStripMixin {

    private static final ImmutableMap<Block, Item> BARKS = new ImmutableMap.Builder<Block, Item>()
            .put(Blocks.STRIPPED_OAK_WOOD,          ModItems.OAK_BARK)
            .put(Blocks.STRIPPED_OAK_LOG,           ModItems.OAK_BARK)
            .put(Blocks.STRIPPED_DARK_OAK_WOOD,     ModItems.DARK_OAK_BARK)
            .put(Blocks.STRIPPED_DARK_OAK_LOG,      ModItems.DARK_OAK_BARK)
            .put(Blocks.STRIPPED_ACACIA_WOOD,       ModItems.ACACIA_BARK)
            .put(Blocks.STRIPPED_ACACIA_LOG,        ModItems.ACACIA_BARK)
            .put(Blocks.STRIPPED_CHERRY_WOOD,       ModItems.CHERRY_BARK)
            .put(Blocks.STRIPPED_CHERRY_LOG,        ModItems.CHERRY_BARK)
            .put(Blocks.STRIPPED_BIRCH_WOOD,        ModItems.BIRCH_BARK)
            .put(Blocks.STRIPPED_BIRCH_LOG,         ModItems.BAMBOO_BARK)
            .put(Blocks.STRIPPED_JUNGLE_WOOD,       ModItems.JUNGLE_BARK)
            .put(Blocks.STRIPPED_JUNGLE_LOG,        ModItems.JUNGLE_BARK)
            .put(Blocks.STRIPPED_SPRUCE_WOOD,       ModItems.SPRUCE_BARK)
            .put(Blocks.STRIPPED_SPRUCE_LOG,        ModItems.SPRUCE_BARK)
            .put(Blocks.STRIPPED_WARPED_STEM,       ModItems.WARPED_BARK)
            .put(Blocks.STRIPPED_WARPED_HYPHAE,     ModItems.WARPED_BARK)
            .put(Blocks.STRIPPED_CRIMSON_STEM,      ModItems.CRIMSON_BARK)
            .put(Blocks.STRIPPED_CRIMSON_HYPHAE,    ModItems.CRIMSON_BARK)
            .put(Blocks.STRIPPED_MANGROVE_WOOD,     ModItems.MANGROVE_BARK)
            .put(Blocks.STRIPPED_MANGROVE_LOG,      ModItems.MANGROVE_BARK)
            .put(Blocks.STRIPPED_BAMBOO_BLOCK,      ModItems.BAMBOO_BARK)
            .build();

    @Inject(method = "tryStrip", at = @At(value = "RETURN", ordinal = 0), cancellable = true)
    private void beforeReturnOptional(World world, BlockPos pos, PlayerEntity player, BlockState state, CallbackInfoReturnable<Optional<BlockState>> cir) {

        Optional<BlockState> optional = cir.getReturnValue();

        if (optional.isPresent()) {
            if (!world.isClient) {
                Item item = BARKS.get(optional.get().getBlock());
                if (state.isIn(ModBlockTags.LOG)){
                    Block.dropStack(world, pos, new ItemStack(item, 4));
                }else if (state.isIn(ModBlockTags.WOOD)){
                    Block.dropStack(world, pos, new ItemStack(item, 6));
                }
            }
        }
    }
}
