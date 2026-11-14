package com.example.minecraftmod;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.SpawnEggItem;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(MinecraftMod.MOD_ID)
public final class MinecraftMod {
    public static final String MOD_ID = "cat_widmo991";
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final DeferredRegister.Entities ENTITIES = DeferredRegister.createEntities(MOD_ID);
    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<SilhouetteEntity>> SILHOUETTE =
            ENTITIES.registerEntityType("silhouette", SilhouetteEntity::new, MobCategory.CREATURE,
                    builder -> builder.sized(0.5F, 1.5F));
    public static final DeferredItem<SpawnEggItem> SILHOUETTE_SPAWN_EGG =
            ITEMS.registerItem("silhouette_spawn_egg", SpawnEggItem::new,
                    properties -> properties.spawnEgg(SILHOUETTE.get()));

    public MinecraftMod(IEventBus modEventBus, ModContainer modContainer) {
        ENTITIES.register(modEventBus);
        ITEMS.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::createAttributes);
        modEventBus.addListener(this::addCreativeItems);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("Loaded {}", MOD_ID);
    }

    private void createAttributes(EntityAttributeCreationEvent event) {
        event.put(SILHOUETTE.get(), SilhouetteEntity.createAttributes().build());
    }

    private void addCreativeItems(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(SILHOUETTE_SPAWN_EGG);
        }
    }
}
