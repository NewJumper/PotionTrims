package com.newjumper.potiontrims;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(PotionTrims.MOD_ID)
public class PotionTrims {
    public static final String MOD_ID = "potiontrims";

    public PotionTrims() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventBusSubscriber(modid = MOD_ID)
    public static class DeeperDarkerEvents {
        @SubscribeEvent
        public static void playerTick(final TickEvent.PlayerTickEvent event) {
            for (ItemStack stack : event.player.getInventory().armor) {
                if(stack.getItem() instanceof ArmorItem && stack.hasTag()) {
                    System.out.println(stack.getTag());
                }
            }
        }
    }
}
