package net.luckshark.mixin;

import net.luckshark.item.ItemRegisters;
import net.luckshark.item.ModItems;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(AbstractFurnaceBlockEntity.class)
public abstract class AbstractFurnaceBlockEntityMixin {

    @Shadow private static volatile Map<Item, Integer> fuelTimes;

    @Inject(method = "createFuelTimeMap", at = @At("TAIL"))
    private static void addFuelTimes(CallbackInfoReturnable<Map<Item, Integer>> cir) {
        for (int i = 0; i < ModItems.BARK_LIST.size(); i++) {
            if (!ItemRegisters.INCOMBUSTIBILITY_LIST.contains(ModItems.BARK_LIST.get(i))) {
                fuelTimes.put(ModItems.BARK_LIST.get(i), 30);
            }
        }
        for (int i = 0; i < ModItems.BARK_ARMOR_LIST.size(); i++) {
            if (!ItemRegisters.INCOMBUSTIBILITY_LIST.contains(ModItems.BARK_ARMOR_LIST.get(i))) {
                fuelTimes.put(ModItems.BARK_ARMOR_LIST.get(i), 180);
            }
        }

    }
}
