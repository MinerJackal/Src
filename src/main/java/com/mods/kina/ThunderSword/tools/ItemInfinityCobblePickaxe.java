package com.mods.kina.ThunderSword.tools;

import com.mods.kina.lib.KinaLib;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemInfinityCobblePickaxe extends ItemPickaxe{
    public ItemInfinityCobblePickaxe(ToolMaterial material){
        super(material);
        this.setUnlocalizedName("itemI12ePickaxe");
        this.setTextureName("kina:infinitycobble_pickaxe");
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    @Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10){
        KinaLib kinaLib = new KinaLib();
        kinaLib.setOnBlock(par4, par5, par6, Blocks.cobblestone, par3World, par2EntityPlayer, par1ItemStack, par7);
        par1ItemStack.damageItem(1, par2EntityPlayer);
        return true;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer){
        ItemStack itemstack1 = new ItemStack(Blocks.cobblestone);
        if(entityplayer.isSneaking()){
            entityplayer.inventory.addItemStackToInventory(itemstack1);
            itemstack.damageItem(1, entityplayer);
        }else{
            itemstack.damageItem(-1, entityplayer);
        }


        return itemstack;
    }
}