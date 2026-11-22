package com.electrifiedded.creeperspecies;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemMysteryStone extends Item {
    public ItemMysteryStone() {
        setMaxStackSize(64);
        setCreativeTab(CreativeTabs.MISC);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getItemStackDisplayName(ItemStack stack) {
        return "§1" + I18n.format(getTranslationKey(stack) + ".name");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tip, ITooltipFlag flag) {
        tip.add(I18n.format("item.MysteryStone.tooltip.base"));
        if (flag.isAdvanced()) tip.add(I18n.format("item.MysteryStone.tooltip.advanced"));
    }
}
