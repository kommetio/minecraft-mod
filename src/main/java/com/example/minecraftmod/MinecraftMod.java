package com.example.minecraftmod;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(MinecraftMod.MOD_ID)
public final class MinecraftMod {
    public static final String MOD_ID = "cat_widmo991";
    private static final Logger LOGGER = LogUtils.getLogger();

    public MinecraftMod(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("Loaded {}", MOD_ID);
    }
}
