package com.github.alexmaclean.israphel.client.renders;

import com.github.alexmaclean.israphel.Israphel;
import com.github.alexmaclean.israphel.client.models.AbstractIsraphelEntityModel;
import com.github.alexmaclean.israphel.entities.AbstractIsraphelEntity;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;

@SideOnly(Side.CLIENT)
public class AbstractIsraphelEntityRenderer extends RenderLiving<AbstractIsraphelEntity> {
    public AbstractIsraphelEntityRenderer(RenderManager manager) {
        super(manager, new AbstractIsraphelEntityModel(0.0f, false), 0.5F);
        this.addLayer(new LayerHeldItem(this));
    }
    @Override
    protected ResourceLocation getEntityTexture(@NotNull AbstractIsraphelEntity entity) {
        return Israphel.location("textures/entity/israphel.png");
    }
    @Override
    public void transformHeldFull3DItemLayer() {
        GlStateManager.translate(0.0F, 0.1875F, 0.0F);
    }

    @Override
    protected void preRenderCallback(@NotNull AbstractIsraphelEntity entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(0.9375F, 0.9375F, 0.9375F);
    }
}