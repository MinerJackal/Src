package com.mods.kina.lib;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import java.util.Random;

public class KinaLib{
    public World world;
    public static int h;
    public KinaLib(){
        super();
    }

    /**
     Sets the block ID and metadata at a given location. Args: X, Y, Z, new block ID, new metadata, flags. Flag 1 will
     cause a block update. Flag 2 will send the change to clients (you almost always want this). Flag 4 prevents the
     block from being re-rendered, if this is a client world. Flags can be added together.
     */
    public boolean setOnBlock(int x, int y, int z, Block block, World world, EntityPlayer player, ItemStack itemStack, int side, int metadata, int flags){
        if (side == 0) {
            --y;
        }

        if (side == 1) {
            ++y;
        }

        if (side == 2) {
            --z;
        }

        if (side == 3) {
            ++z;
        }

        if (side == 4) {
            --x;
        }

        if (side == 5) {
            ++x;
        }

        if (!player.canPlayerEdit(x, y, z, side, itemStack)) {
            return false;
        } else {
            world.setBlock(x, y, z, block, metadata, flags);
            return true;
        }
    }

    public boolean setOnBlock(int x, int y, int z, Block block, World world, EntityPlayer player, ItemStack itemStack, int side){
        setOnBlock(x, y, z, block, world, player, itemStack, side, 0, 3);
        return true;
    }

    public boolean spawnThunder(World world, int x, int y, int z){
        Random rand = new Random();
        EntityLightningBolt entitylightningbolt = new EntityLightningBolt(world, x, y, z);
        world.spawnEntityInWorld(entitylightningbolt);
        if (!world.isRemote && world.getGameRules().getGameRuleBooleanValue("doFireTick") && (world.difficultySetting == EnumDifficulty.PEACEFUL || world.difficultySetting == EnumDifficulty.EASY) && world.doChunksNearChunkExist(MathHelper.floor_double((double) x), MathHelper.floor_double((double) y), MathHelper.floor_double((double) z), 10)) {
            int i = MathHelper.floor_double((double) x);
            int j = MathHelper.floor_double((double) y);
            int k = MathHelper.floor_double((double) z);

            if (world.getBlock(i, j, k).getMaterial() == Material.air && Blocks.fire.canPlaceBlockAt(world, i, j, k)) {
                world.setBlock(i, j, k, Blocks.fire);
            }

            for (i = 0; i < 4; ++i) {
                j = MathHelper.floor_double((double) x) + rand.nextInt(3) - 1;
                k = MathHelper.floor_double((double) y) + rand.nextInt(3) - 1;
                int l = MathHelper.floor_double((double) z) + rand.nextInt(3) - 1;

                if (world.getBlock(j, k, l).getMaterial() == Material.air && Blocks.fire.canPlaceBlockAt(world, j, k, l)) {
                    world.setBlock(j, k, l, Blocks.fire);
                }
            }
        }
        return true;
    }
    /*public boolean isAirOverBlock(Block block,World world,int x,int y,int z){
        h=y;
        boolean flag1=true;
        while(h<=256){
            h+=1;
            flag1=block.isAir(world,x,h,z);
            while(!flag1){
                flag1=block.isAir(world,x,h,z);
            }
        }
        return flag1;
    }*/
    public int getH(){
        return h;
    }
}
