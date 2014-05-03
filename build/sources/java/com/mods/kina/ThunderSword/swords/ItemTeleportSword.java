package com.mods.kina.ThunderSword.swords;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class ItemTeleportSword extends ItemSword{
    public static int posx;
    public static int posy;
    public static int posz;
    public static boolean flag;

    public ItemTeleportSword(ToolMaterial material){
        super(material);
        this.setUnlocalizedName("itemTeleportSword");
        this.setTextureName("kina:teleport_sword");
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, EntityLivingBase par3EntityLivingBase){
        /*if(!(par3EntityLivingBase instanceof EntityAgeable) && !par3EntityLivingBase.worldObj.isRemote){
            par2EntityPlayer.addChatMessage(new ChatComponentText("\u3053\u306EMob\u306F\u8EE2\u9001\u3067\u304D\u307E\u305B\u3093"));
        }else{
            if(!par3EntityLivingBase.worldObj.isRemote){
                par3EntityLivingBase.setPosition(posx, posy + 1, posz);
                par2EntityPlayer.addChatMessage(new ChatComponentText("\u4F4D\u7F6E" + posx + "," + posy + "," + posz + "\u306BMob\u3092\u8EE2\u9001\u3057\u307E\u3057\u305F"));
            }
        }*/
        Random rand = new Random();
        if(!(par3EntityLivingBase instanceof EntityAgeable) && !par3EntityLivingBase.worldObj.isRemote){
            par2EntityPlayer.addChatMessage(new ChatComponentText(getEntityString(par3EntityLivingBase)+"\u306F\u8EE2\u9001\u3067\u304D\u307E\u305B\u3093"));
        }else{
            if(posx == 0 && posy == 0 && posz == 0){
                par2EntityPlayer.addChatMessage(new ChatComponentText("\u5730\u70B9\u3092\u767B\u9332\u3057\u3066\u304F\u3060\u3055\u3044"));
            }else{
                if(!par3EntityLivingBase.worldObj.isRemote){

                    //entity.worldObj.spawnParticle("portal", entity.posX + (rand.nextDouble() - 0.5D) * (double)entity.width, entity.posY + rand.nextDouble() * (double)entity.height - 0.25D, entity.posZ + (rand.nextDouble() - 0.5D) * (double)entity.width, (rand.nextDouble() - 0.5D) * 2.0D, -rand.nextDouble(), (rand.nextDouble() - 0.5D) * 2.0D);
                    par3EntityLivingBase.setPosition((double)posx, (double)posy + 1, (double)posz);
                    par2EntityPlayer.addChatMessage(new ChatComponentText("\u4F4D\u7F6E" + posx + "," + posy + "," + posz + "\u306B" + getEntityString(par3EntityLivingBase) + "\u3092\u8EE2\u9001\u3057\u307E\u3057\u305F"));
                    par1ItemStack.damageItem((int) par3EntityLivingBase.getHealth(), par3EntityLivingBase);
                    flag = true;
                }else{
                    byte i = 0;
                    while(i <= 10){
                        i++;
                        par3EntityLivingBase.worldObj.spawnParticle("portal", par3EntityLivingBase.posX + (rand.nextDouble() - 0.5D) * (double) par3EntityLivingBase.width, par3EntityLivingBase.posY + rand.nextDouble() * (double) par3EntityLivingBase.height - 0.25D, par3EntityLivingBase.posZ + (rand.nextDouble() - 0.5D) * (double) par3EntityLivingBase.width, (rand.nextDouble() - 0.5D) * 2.0D, -rand.nextDouble(), (rand.nextDouble() - 0.5D) * 2.0D);
                    }
                }
            }
        }
        return flag;
    }

    @Override
    public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float disX, float disY, float disZ){
        /*int a = *//*(double)*//*x - 3;
        int c = *//*(double)*//*x + 3;
        int b = *//*(double)*//*z - 3;
        int d = *//*(double)*//*z + 3;

        world.createExplosion(null, a, y, d, 1.0F, true);
        world.createExplosion(null, a, y, b, 1.0F, true);
        world.createExplosion(null, c, y, b, 1.0F, true);
        world.createExplosion(null, c, y, d, 1.0F, true);
        world.createExplosion(null, a, y, z, 1.0F, true);
        world.createExplosion(null, c, y, z, 1.0F, true);
        world.createExplosion(null, x, y, b, 1.0F, true);
        world.createExplosion(null, x, y, d, 1.0F, true);*/
        posx = x;
        posy = y;
        posz = z;
        if(!world.isRemote){
            player.addChatMessage(new ChatComponentText("\u4F4D\u7F6E" + posx + "," + posy + "," + posz + "\u3092\u8A18\u9332\u3057\u307E\u3057\u305F"));
        }
        return true;
    }

    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity){
        if(!player.isSneaking()){
            //player.addChatMessage(new ChatComponentText("\u3053\u306EMob\u306F\u8EE2\u9001\u3067\u304D\u307E\u305B\u3093"));
            flag = false;
        }else{
            itemInteractionForEntity(stack, player, (EntityLivingBase) entity);
        }
        return flag;
    }

    public String getEntityString(Entity entity){
        //EntityList list = new EntityList();
        //String list = EntityList.getEntityString(entity);
        return EntityList.getEntityString(entity);
    }


}