package com.electrifiedded.creeperspecies;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityNetherStarCreeper extends EntityModifiedCreeper {
    public EntityNetherStarCreeper(World w) {
        super(w);
        setExplosionRadius(10);
    }

    @Override
    protected void dropFewItems(boolean recent, int looting) {
        super.dropFewItems(recent, looting);
        if (rand.nextInt(3) == 0) entityDropItem(new ItemStack(Items.NETHER_STAR), 0.0F);
    }
}
