package com.electrifiedded.creeperspecies;

import net.minecraft.world.World;

public class EntityMysteryCreeper extends EntityModifiedCreeper {
    public EntityMysteryCreeper(World w) {
        super(w);
        setExplosionRadius(6);
        setDrop(CreeperSpecies.mysteryStone);
    }
}
