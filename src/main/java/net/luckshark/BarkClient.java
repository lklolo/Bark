package net.luckshark;

import net.fabricmc.api.ClientModInitializer;
import net.luckshark.screen.ModScreenHandlers;
import net.luckshark.screen.YanCraftScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class BarkClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.YAN_CRAFT_SCREEN_HANDLER, YanCraftScreen::new);
    }
}
