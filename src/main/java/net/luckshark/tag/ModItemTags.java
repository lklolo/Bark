package net.luckshark.tag;

import net.luckshark.Bark;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItemTags {

    private static TagKey<Item> of(String id) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(Bark.MOD_ID, id));
    }

    public static void registerModItemTags() {
    }
}
