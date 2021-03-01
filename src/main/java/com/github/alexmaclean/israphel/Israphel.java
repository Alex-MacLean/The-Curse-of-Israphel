package com.github.alexmaclean.israphel;

import com.github.alexmaclean.israphel.client.renders.RenderRegistry;
import com.github.alexmaclean.israphel.util.entities.EntityRegistry;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@Mod(name = Israphel.NAME, useMetadata = true, acceptedMinecraftVersions = Israphel.MCVERSION, version = Israphel.VERSION, modid = Israphel.MODID)
public class Israphel {
    public static final String NAME = "The Curse of Israphel";
    public static final String MCVERSION = "[1.12.2]";
    public static final String VERSION = "1.0";
    public static final String MODID = "israphel";

    @Contract("_ -> new")
    public static @NotNull ResourceLocation location(String location) {
        return new ResourceLocation(MODID, location);
    }

    @Mod.Instance
    public static Israphel instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        EntityRegistry.registerEntities();
        EntityRegistry.registerSpawnPlacement();
        EntityRegistry.registerEntityWorldSpawns();
    }

    @SideOnly(Side.CLIENT)
    @Mod.EventHandler
    public static void clientRegistries(FMLPreInitializationEvent event) {
        RenderRegistry.registerEntityRenders();
    }
}