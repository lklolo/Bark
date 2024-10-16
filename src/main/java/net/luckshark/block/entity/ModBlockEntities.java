package net.luckshark.block.entity;

import com.mojang.datafixers.types.Type;
import net.luckshark.Bark;
import net.luckshark.block.ModBlocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class ModBlockEntities {

    public static final BlockEntityType<YanCraftBlockEntity> YAN_CRAFT_BLOCK_ENTITY = create("yan_craft_block_entity",
            BlockEntityType.Builder.create(YanCraftBlockEntity::new, ModBlocks.YAN_CRAFT));

    private static <T extends BlockEntity> BlockEntityType<T> create(String id, BlockEntityType.Builder<T> builder) {
        Type<?> type = Util.getChoiceType(TypeReferences.BLOCK_ENTITY, id);
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Bark.MOD_ID, id), builder.build(type));
    }
    public static void registerBlockEntities() {
    }
}
