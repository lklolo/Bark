package net.luckshark.item.custom;

import net.luckshark.item.AbstractDurabilityItem;
import net.minecraft.item.Item;

public class Quilmor extends Item implements AbstractDurabilityItem {
    public Quilmor(Item.Settings settings) {
        super(settings.maxDamage(32));
    }
}
