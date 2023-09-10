package com.newjumper.potiontrims.mixin;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.ItemCombinerScreen;
import net.minecraft.client.gui.screens.inventory.SmithingScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.SmithingMenu;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = SmithingScreen.class)
public class SmithingScreenMixin extends ItemCombinerScreen<SmithingMenu> {
    public SmithingScreenMixin(SmithingMenu pMenu, Inventory pPlayerInventory, Component pTitle, ResourceLocation pMenuResource) {
        super(pMenu, pPlayerInventory, pTitle, pMenuResource);
    }

    @Inject(method = "renderOnboardingTooltips", at = @At("HEAD"))
    public void renderOnboardingTooltips(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, CallbackInfo cir) {
        if(isHovering(44, 30, 16, 16, pMouseX, pMouseY)) {
            pGuiGraphics.renderTooltip(this.font, Component.literal("Add potion"), pMouseX, pMouseY);
        }
    }

    @Override
    protected void renderErrorIcon(@NotNull GuiGraphics pGuiGraphics, int pX, int pY) {
    }
}
