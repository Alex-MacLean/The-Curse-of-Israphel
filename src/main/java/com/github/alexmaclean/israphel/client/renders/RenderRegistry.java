package com.github.alexmaclean.israphel.client.renders;

import com.github.alexmaclean.israphel.entities.*;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderRegistry {
    public static void registerEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(IsraphelMageEntity.class, AbstractIsraphelMageEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(FakeIsraphelMageEntity.class, AbstractIsraphelMageEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(IsraphelSpyEntity.class, AbstractIsraphelEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(IsraphelBuilderEntity.class, AbstractIsraphelEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(IsraphelWarriorEntity.class, AbstractIsraphelEntityRenderer::new);
    }
}