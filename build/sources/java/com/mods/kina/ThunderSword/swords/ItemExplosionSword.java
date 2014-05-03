package com.mods.kina.ThunderSword.swords;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class ItemExplosionSword extends ItemSword{
    public ItemExplosionSword(ToolMaterial material){
        super(material);
        this.setUnlocalizedName("itemExplosionSword");
        this.setTextureName("kina:explosion_sword");
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    @Override
    public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float disX, float disY, float disZ){
        EntityLightningBolt entitylightningbolt = new EntityLightningBolt(world, x, y, z);
        world.addWeatherEffect(entitylightningbolt);
        world.createExplosion(null, x, y, z, 1.0F, true);
        item.damageItem(10, player);
        return true;
    }
}