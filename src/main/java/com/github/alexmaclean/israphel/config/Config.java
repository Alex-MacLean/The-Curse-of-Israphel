package com.github.alexmaclean.israphel.config;

import com.github.alexmaclean.israphel.Israphel;

@net.minecraftforge.common.config.Config(modid = Israphel.MODID, name = "Israphel-common", type = net.minecraftforge.common.config.Config.Type.INSTANCE)
public class Config {

    @net.minecraftforge.common.config.Config.Name("BuilderBuilds")
    @net.minecraftforge.common.config.Config.Comment("Determines if the Israphel Builder builds structures.")
    @net.minecraftforge.common.config.Config.RequiresMcRestart
    public static boolean BuilderBuilds = true;

    @net.minecraftforge.common.config.Config.Name("WarriorBreaksBlocks")
    @net.minecraftforge.common.config.Config.Comment("Determines if the Israphel Warrior can break blocks.")
    @net.minecraftforge.common.config.Config.RequiresMcRestart
    public static boolean WarriorBreaksBlocks = true;

    @net.minecraftforge.common.config.Config.RangeInt(min = 0, max = 1024)
    @net.minecraftforge.common.config.Config.Name("IsraphelWarriorWeight")
    @net.minecraftforge.common.config.Config.Comment("The spawn weight of the Israphel warrior. Higher values makes it more common, while 0 disables it.")
    @net.minecraftforge.common.config.Config.RequiresMcRestart
    public static int IsraphelWarriorWeight = 1;

    @net.minecraftforge.common.config.Config.RangeInt(min = 0, max = 1024)
    @net.minecraftforge.common.config.Config.Name("IsraphelSpyWeight")
    @net.minecraftforge.common.config.Config.Comment("The spawn weight of the Israphel spy. Higher values makes it more common, while 0 disables it.")
    @net.minecraftforge.common.config.Config.RequiresMcRestart
    public static int IsraphelSpyWeight = 1;

    @net.minecraftforge.common.config.Config.RangeInt(min = 0, max = 1024)
    @net.minecraftforge.common.config.Config.Name("IsraphelBuilderWeight")
    @net.minecraftforge.common.config.Config.Comment("The spawn weight of the Israphel builder. Higher values makes it more common, while 0 disables it.")
    @net.minecraftforge.common.config.Config.RequiresMcRestart
    public static int IsraphelBuilderWeight = 1;

    @net.minecraftforge.common.config.Config.RangeInt(min = 0, max = 1024)
    @net.minecraftforge.common.config.Config.Name("IsraphelMageWeight")
    @net.minecraftforge.common.config.Config.Comment("The spawn weight of the Israphel mage. Higher values makes it more common, while 0 disables it.")
    @net.minecraftforge.common.config.Config.RequiresMcRestart
    public static int IsraphelMageWeight = 1;

    @net.minecraftforge.common.config.Config.RangeInt(min = 0, max = 64)
    @net.minecraftforge.common.config.Config.Name("IsraphelSpyObservationDistance")
    @net.minecraftforge.common.config.Config.Comment("The distance in blocks the Israphel spy observes the player from.")
    @net.minecraftforge.common.config.Config.RequiresMcRestart
    public static int IsraphelSpyObservationDistance = 32;
}