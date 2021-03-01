package com.github.alexmaclean.israphel.util.entities;

import com.github.alexmaclean.israphel.Israphel;
import com.github.alexmaclean.israphel.config.Config;
import com.github.alexmaclean.israphel.entities.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import java.util.Set;

public class EntityRegistry {
    public static void registerEntities() {
        registerEntity("israphel_warrior", IsraphelWarriorEntity.class, 1742128,0x000000, 0xFF0000);
        registerEntity("israphel_builder", IsraphelBuilderEntity.class, 4589318,0x000000, 0xFFFF00);
        registerEntity("israphel_spy", IsraphelSpyEntity.class, 3792584, 0x000000,0x00FF00);
        registerEntity("israphel_mage", IsraphelMageEntity.class, 9572941,0x000000,0x0000FF);
        registerEntityWithoutEgg("fake_israphel_mage", FakeIsraphelMageEntity.class,2486184);
    }

    private static void registerEntity(String name, Class<? extends Entity> entity, int id, int color1, int color2) {
        net.minecraftforge.fml.common.registry.EntityRegistry.registerModEntity(new ResourceLocation(Israphel.MODID + ":" + name), entity, Israphel.MODID + "." + name, id, Israphel.instance, 8192, 1, true, color1, color2);
    }

    private static void registerEntityWithoutEgg(String name, Class<? extends Entity> entity, int id) {
        net.minecraftforge.fml.common.registry.EntityRegistry.registerModEntity(new ResourceLocation(Israphel.MODID + ":" + name), entity, Israphel.MODID + "." + name, id, Israphel.instance, 8192, 1, true);
    }

    public static void registerSpawnPlacement() {
        EntitySpawnPlacementRegistry.setPlacementType(IsraphelBuilderEntity.class, EntityLiving.SpawnPlacementType.ON_GROUND);
        EntitySpawnPlacementRegistry.setPlacementType(IsraphelMageEntity.class, EntityLiving.SpawnPlacementType.ON_GROUND);
        EntitySpawnPlacementRegistry.setPlacementType(IsraphelSpyEntity.class, EntityLiving.SpawnPlacementType.ON_GROUND);
        EntitySpawnPlacementRegistry.setPlacementType(IsraphelWarriorEntity.class, EntityLiving.SpawnPlacementType.ON_GROUND);
        EntitySpawnPlacementRegistry.setPlacementType(IsraphelBuilderEntity.class, EntityLiving.SpawnPlacementType.ON_GROUND);
    }

    public static void registerEntityWorldSpawns() {

        BiomeDictionary.Type[] NetherTypes = {
                BiomeDictionary.Type.NETHER
        };

        BiomeDictionary.Type[] EndTypes = {
                BiomeDictionary.Type.END
        };

        BiomeDictionary.Type[] IsraphelTypes = {
                BiomeDictionary.Type.CONIFEROUS,
                BiomeDictionary.Type.DEAD,
                BiomeDictionary.Type.DENSE,
                BiomeDictionary.Type.FOREST,
                BiomeDictionary.Type.HILLS,
                BiomeDictionary.Type.JUNGLE,
                BiomeDictionary.Type.LUSH,
                BiomeDictionary.Type.MAGICAL,
                BiomeDictionary.Type.MESA,
                BiomeDictionary.Type.MOUNTAIN,
                BiomeDictionary.Type.PLAINS,
                BiomeDictionary.Type.SANDY,
                BiomeDictionary.Type.SAVANNA,
                BiomeDictionary.Type.SNOWY,
                BiomeDictionary.Type.SPARSE,
                BiomeDictionary.Type.SPOOKY,
                BiomeDictionary.Type.SWAMP,
                BiomeDictionary.Type.WASTELAND,
                BiomeDictionary.Type.WET,

                BiomeDictionary.Type.OCEAN
        };

        for (BiomeDictionary.Type t : IsraphelTypes) {
            Set<Biome> biomes = BiomeDictionary.getBiomes(t);
            for (Biome currentBiome : biomes) {
                currentBiome.getSpawnableList(EnumCreatureType.MONSTER).add(new Biome.SpawnListEntry(IsraphelBuilderEntity.class, Config.IsraphelBuilderWeight, 1, 1));
                currentBiome.getSpawnableList(EnumCreatureType.MONSTER).add(new Biome.SpawnListEntry(IsraphelMageEntity.class, Config.IsraphelMageWeight, 1, 1));
                currentBiome.getSpawnableList(EnumCreatureType.MONSTER).add(new Biome.SpawnListEntry(IsraphelSpyEntity.class, Config.IsraphelSpyWeight, 1, 1));
                currentBiome.getSpawnableList(EnumCreatureType.MONSTER).add(new Biome.SpawnListEntry(IsraphelWarriorEntity.class, Config.IsraphelWarriorWeight, 1, 1));
            }
        }

        //In Minecraft 1.12 The End is all considered to the one biome Israphel can't spawn in the vanilla end dimension. This is here so Israphel can spawn in modded end biomes, but in most cases not on the main island where the Ender Dragon is fought.
        for (BiomeDictionary.Type t : EndTypes) {
            Set<Biome> biomes = BiomeDictionary.getBiomes(t);
            for (Biome currentBiome : biomes) {
                if(currentBiome != Biomes.SKY) {
                    currentBiome.getSpawnableList(EnumCreatureType.MONSTER).add(new Biome.SpawnListEntry(IsraphelBuilderEntity.class, 1, 1, 1));
                    currentBiome.getSpawnableList(EnumCreatureType.MONSTER).add(new Biome.SpawnListEntry(IsraphelMageEntity.class, 1, 1, 1));
                    currentBiome.getSpawnableList(EnumCreatureType.MONSTER).add(new Biome.SpawnListEntry(IsraphelSpyEntity.class, 1, 1, 1));
                    currentBiome.getSpawnableList(EnumCreatureType.MONSTER).add(new Biome.SpawnListEntry(IsraphelWarriorEntity.class, 1, 1, 1));
                }
            }
        }

        for (BiomeDictionary.Type t : NetherTypes) {
            Set<Biome> biomes = BiomeDictionary.getBiomes(t);
            for (Biome currentBiome : biomes) {
                currentBiome.getSpawnableList(EnumCreatureType.MONSTER).add(new Biome.SpawnListEntry(IsraphelBuilderEntity.class, Config.IsraphelBuilderWeight / 5, 1, 1));
                currentBiome.getSpawnableList(EnumCreatureType.MONSTER).add(new Biome.SpawnListEntry(IsraphelMageEntity.class, Config.IsraphelMageWeight / 5, 1, 1));
                currentBiome.getSpawnableList(EnumCreatureType.MONSTER).add(new Biome.SpawnListEntry(IsraphelSpyEntity.class, Config.IsraphelSpyWeight / 5, 1, 1));
                currentBiome.getSpawnableList(EnumCreatureType.MONSTER).add(new Biome.SpawnListEntry(IsraphelWarriorEntity.class, Config.IsraphelWarriorWeight / 5, 1, 1));
            }
        }
    }
}