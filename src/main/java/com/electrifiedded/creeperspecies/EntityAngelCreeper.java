package com.electrifiedded.creeperspecies;

import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityAngelCreeper extends EntityFlying implements IMob {
    public int courseChangeCooldown = 0;
    public double waypointX, waypointY, waypointZ;

    public EntityAngelCreeper(World w) {
        super(w);
        isImmuneToFire = true;
        experienceValue = 5;
        setSize(0.6F, 1.7F);
    }

    @Override
    public boolean getCanSpawnHere() {
        return rand.nextInt(20) == 0 && super.getCanSpawnHere() && world.getDifficulty() != EnumDifficulty.PEACEFUL;
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_CREEPER_DEATH;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_CREEPER_PRIMED;
    }

    @Override
    protected void updateAITasks() {
        if (!world.isRemote && world.getDifficulty() == EnumDifficulty.PEACEFUL) {
            setDead();
        }
        super.updateAITasks();
        double dx = waypointX - posX, dy = waypointY - posY, dz = waypointZ - posZ;
        double d = dx * dx + dy * dy + dz * dz;
        if (d < 1.0 || d > 3600.0) {
            waypointX = posX + (rand.nextFloat() * 2.0F - 1.0F) * 16.0F;
            waypointY = posY + (rand.nextFloat() * 2.0F - 1.0F) * 16.0F;
            waypointZ = posZ + (rand.nextFloat() * 2.0F - 1.0F) * 16.0F;
        }
        if (courseChangeCooldown-- <= 0) {
            courseChangeCooldown += rand.nextInt(5) + 2;
            d = MathHelper.sqrt(d);
            if (d > 0 && isCourseTraversable(dx, dy, dz, d)) {
                motionX += dx / d * 0.1;
                motionY += dy / d * 0.1;
                motionZ += dz / d * 0.1;
            } else {
                waypointX = posX;
                waypointY = posY;
                waypointZ = posZ;
            }
        }
    }

    private boolean isCourseTraversable(double dx, double dy, double dz, double dist) {
        double sx = dx / dist, sy = dy / dist, sz = dz / dist;
        AxisAlignedBB bb = getEntityBoundingBox();
        for (int i = 1; i < dist; i++) {
            bb = bb.offset(sx, sy, sz);
            if (!world.getCollisionBoxes(this, bb).isEmpty()) return false;
        }
        return true;
    }
}
