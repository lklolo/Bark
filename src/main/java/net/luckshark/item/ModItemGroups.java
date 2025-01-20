package net.luckshark.item;

import net.luckshark.Bark;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModItemGroups {

    private static Map<List<Item>, RegistryKey<ItemGroup>> groupMap = new HashMap<>();

    public static final List<Item> BARK_GROUP_LIST = new ArrayList<>();

    public static final RegistryKey<ItemGroup> BARK_GROUP = register("bark_group", BARK_GROUP_LIST);

    private static RegistryKey<ItemGroup> register(String id, List<Item> list) {
        RegistryKey<ItemGroup> group = RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(Bark.MOD_ID, id));
        groupMap.put(list, group);
        return group;
    }

    public static void addItemToGroup(Item item, List<Item> list) {
        list.add(item);
    }

    public static void registerModItemGroups(){
        Registry.register(Registries.ITEM_GROUP,
                BARK_GROUP,
                ItemGroup.create(ItemGroup.Row.TOP, -1)
                        .displayName(Text.translatable("itemGroup.bark.bark_group"))
                        .icon(() -> new ItemStack(ModItems.OAK_BARK))
                        .entries((displayContext, entries) -> {
                            for (Item item : BARK_GROUP_LIST) {
                                entries.add(item);
                            }
                        })
                        .build()
        );
    }
}
