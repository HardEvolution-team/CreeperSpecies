package com.electrifiedded.creeperspecies;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import javax.annotation.Nullable;

public class EntityModifiedCreeper extends EntityCreeper {
    protected Item drop;

    public EntityModifiedCreeper(World w) {
        super(w);
    }

    public EntityModifiedCreeper setDrop(Item item) {
        this.drop = item;
        return this;
    }

    public EntityModifiedCreeper setExplosionRadius(int radius) {
        ReflectionHelper.setPrivateValue(EntityCreeper.class, this, radius, "explosionRadius", "field_82226_g");
        return this;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(60.0);
    }

    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return null;
    }

    @Override
    protected void dropFewItems(boolean recent, int looting) {
        Item d = drop != null ? drop : net.minecraft.init.Items.GUNPOWDER;
        int n = rand.nextInt(3) + rand.nextInt(looting + 1);
        if (n > 0) entityDropItem(new ItemStack(d, n), 0.0F);
    }
}
