package com.github.alexmaclean.israphel.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;

public class AbstractIsraphelEntity extends EntityMob {
    public AbstractIsraphelEntity(World worldIn) {
        super(worldIn);
    }

    // (from Guliver Jham)
    // This is made to correct 20 instances of if statements to make it the code easier.
    private static final HashSet<String> aef_conditions = new HashSet<String>()
    {{
        DamageSource[] damageSources = new DamageSource[]
                {
                        // All of the damage sources below will make the function
                        // "attackEntityFrom" return false.
                        DamageSource.FALL,
                        DamageSource.CACTUS,
                        DamageSource.DROWN,
                        DamageSource.LIGHTNING_BOLT,
                        DamageSource.IN_FIRE,
                        DamageSource.ON_FIRE,
                        DamageSource.ANVIL,
                        DamageSource.CRAMMING,
                        DamageSource.DRAGON_BREATH,
                        DamageSource.FALLING_BLOCK,
                        DamageSource.FLY_INTO_WALL,
                        DamageSource.HOT_FLOOR,
                        DamageSource.LAVA,
                        DamageSource.IN_WALL,
                        DamageSource.MAGIC,
                        DamageSource.STARVE,
                        DamageSource.WITHER,
                        DamageSource.FIREWORKS
                };
        //This piece right here adds all 'possibilities' to the hash set.
        for (DamageSource damageSource : damageSources) add(damageSource.getDamageType());
    }};

    @Override
    public boolean attackEntityFrom(@NotNull DamageSource source, float amount) {
        if (source.getImmediateSource() instanceof EntityAreaEffectCloud)
            return false;
        if (source.getImmediateSource() instanceof EntityPotion)
            return false;
        if (aef_conditions.contains( source.getDamageType() ))
            return false;
        return super.attackEntityFrom(source, amount);
    }

    @Override
    public boolean attackEntityAsMob(@NotNull Entity entityIn) {
        boolean flag = super.attackEntityAsMob(entityIn);
        if (flag)
        {
            float f = this.world.getDifficultyForLocation(new BlockPos(this)).getAdditionalDifficulty();

            if (this.isBurning() && this.rand.nextFloat() < f * 0.3F)
            {
                entityIn.setFire(2 * (int)f);
            }
        }
        return flag;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        this.clearActivePotions();
    }
}
