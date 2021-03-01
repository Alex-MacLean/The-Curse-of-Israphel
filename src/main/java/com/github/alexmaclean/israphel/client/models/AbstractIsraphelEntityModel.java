package com.github.alexmaclean.israphel.client.models;

import net.minecraft.client.model.ModelPlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class AbstractIsraphelEntityModel extends ModelPlayer {
    public AbstractIsraphelEntityModel(float modelSize, boolean smallArmsIn) {
        super(modelSize, smallArmsIn);
    }
}