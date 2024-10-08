package net.luckshark.tag;

import net.luckshark.Bark;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModBlockTags {

    public static final TagKey<Block> LOG = of("log");
    public static final TagKey<Block> WOOD = of("wood");

    private static TagKey<Block> of(String id) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Bark.MOD_ID, id));
    }

    public static void registerModBlockTags() {
    }
}
