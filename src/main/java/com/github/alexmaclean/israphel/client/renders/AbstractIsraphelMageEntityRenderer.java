package com.github.alexmaclean.israphel.client.renders;

import com.github.alexmaclean.israphel.Israphel;
import com.github.alexmaclean.israphel.client.models.AbstractIsraphelMageEntityModel;
import com.github.alexmaclean.israphel.entities.AbstractIsraphelEntity;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;

@SideOnly(Side.CLIENT)
public class AbstractIsraphelMageEntityRenderer extends RenderLiving<AbstractIsraphelEntity> {
    public AbstractIsraphelMageEntityRenderer(RenderManager manager) {
        super(manager, new AbstractIsraphelMageEntityModel(), 0.5F);
    }
    @Override
    protected ResourceLocation getEntityTexture(@NotNull AbstractIsraphelEntity entity) {
        return Israphel.location("textures/entity/israphel.png");
    }

    @Override
    protected void preRenderCallback(@NotNull AbstractIsraphelEntity entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(0.9375F, 0.9375F, 0.9375F);
    }
}