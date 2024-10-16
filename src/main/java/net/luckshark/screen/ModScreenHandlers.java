package net.luckshark.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.luckshark.Bark;
import net.luckshark.data.YanCraftData;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {

    public static final ScreenHandlerType<YanCraftScreenHandler> YAN_CRAFT_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(Bark.MOD_ID, "yan_craft"),
                    new ExtendedScreenHandlerType<>(YanCraftScreenHandler::new, YanCraftData.CODEC));

    public static void registerScreenHandlers() {
    }
}
