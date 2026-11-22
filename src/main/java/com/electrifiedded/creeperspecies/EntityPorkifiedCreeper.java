package com.electrifiedded.creeperspecies;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityPorkifiedCreeper extends EntityCreeper {
    public EntityPorkifiedCreeper(World w) {
        super(w);
    }

    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return null;
    }

    @Override
    protected void dropFewItems(boolean recent, int looting) {
        int n = rand.nextInt(3) + rand.nextInt(looting + 1);
        if (n > 0) entityDropItem(new ItemStack(Items.PORKCHOP, n), 0.0F);
    }
}
