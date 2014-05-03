package com.mods.kina.ThunderSword.swords;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCraftSword extends Item{
    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer){
        int getScore = entityplayer.experienceTotal;
        if(getScore != 0){
            entityplayer.addExperience(-1);
            itemstack.damageItem(-1, entityplayer);
        }
        return itemstack;
    }
}