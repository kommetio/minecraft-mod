package com.example.minecraftmod.client;

import com.example.minecraftmod.MinecraftMod;
import com.example.minecraftmod.SilhouetteEntity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

public final class SilhouetteRenderer
        extends MobRenderer<SilhouetteEntity, LivingEntityRenderState, SilhouetteModel> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(
            MinecraftMod.MOD_ID, "textures/entity/silhouette.png");

    public SilhouetteRenderer(EntityRendererProvider.Context context) {
        super(context, new SilhouetteModel(context.bakeLayer(SilhouetteModel.LAYER)), 0.3F);
    }

    @Override
    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }

    @Override
    public Identifier getTextureLocation(LivingEntityRenderState state) {
        return TEXTURE;
    }
}
