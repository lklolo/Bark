package net.luckshark.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.luckshark.Bark;
import net.luckshark.recipe.YanCraftRecipe;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class YanCraftScreen extends HandledScreen<YanCraftScreenHandler> {

    private static final Identifier TEXTURE = Identifier.of(Bark.MOD_ID, "textures/gui/yan_craft_gui.png");
    private static final Text RATE = Text.translatable("gui.yan_craft.rate");

    public YanCraftScreen(YanCraftScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        super.drawForeground(context, mouseX, mouseY);
        context.drawText(this.textRenderer, RATE, 120, 6, 0x404040, false);
        context.drawText(this.textRenderer, String.valueOf(YanCraftRecipe.getSuccessRate()), 120, 16, 0x404040, false);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (this.width - this.backgroundWidth) / 2;
        int y = (this.height - this.backgroundHeight) / 2;

        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

        renderProgressArrow(context, x, y);
    }

    private void renderProgressArrow(DrawContext context, int x, int y) {
        if (handler.isCrafting()) {
            context.drawTexture(TEXTURE, x + 85, y + 30, 176, 0, 8, handler.getScaledProgress());
        }
    }
}
