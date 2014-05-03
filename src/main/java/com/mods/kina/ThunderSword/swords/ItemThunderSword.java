package com.mods.kina.ThunderSword.swords;

import com.mods.kina.lib.KinaLib;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class ItemThunderSword extends ItemSword{
    public ItemThunderSword(ToolMaterial material){
        super(material);
        this.setUnlocalizedName("itemThunderSword");
        this.setTextureName("kina:thunder_sword");
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    @Override
    public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float disX, float disY, float disZ){
        KinaLib kinaLib = new KinaLib();
        kinaLib.spawnThunder(world, x, y, z);
        item.damageItem(5, player);//-5
        return true;
    }
}