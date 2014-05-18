package com.mods.kina.DispensableBlock;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

@Mod(modid = "kina_DispensableBlockMod")
public class DispensableBlockCore{
    public static String ignoreItems;
    public static Minecraft minecraft = Minecraft.getMinecraft();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        Configuration config = new Configuration(new File(event.getModConfigurationDirectory(), "DispensableBlockMod.cfg"));
        try{
            config.load();
            ignoreItems = config.get("BlackList", "black_Item_Block", "minecraft:tnt", "set Ignorings Item and Block").getString();
        } catch(Exception e){
            FMLLog.severe("Error Message");
        }finally{
            config.save();
        }
    }


    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        for(int i = 1; i <= 4095; i++){
            if(Item.getItemById(i) != null && isNotIgnoreItem(i) && Item.getItemById(i) instanceof ItemBlock){
                BlockDispenser.dispenseBehaviorRegistry.putObject(Item.getItemById(i), new IBehaviorDispenseItem(){
                    public ItemStack dispense(IBlockSource var1, ItemStack var2){
                        World world = var1.getWorld();
                        Block block = Block.getBlockFromItem(var2.getItem());
                        IPosition iposition = BlockDispenser.func_149939_a(var1);
                        int x = (int) iposition.getX();
                        int y = (int) iposition.getY();
                        int z = (int) iposition.getZ();
                        if(world.isAirBlock(x, y, z)){
                            minecraft.getSoundHandler().playSound((new PositionedSoundRecord(new ResourceLocation(block.stepSound.getBreakSound()), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F, (float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F)));
                            world.setBlock(x, y, z, block);
                            return var2.splitStack(var2.stackSize - 1);
                        }else{
                            return var2;
                        }
                    }
                });
            }
        }

        for(int i = 256; i <= 31999; i++){
            if(Item.getItemById(i) != null && Item.getItemById(i) instanceof ItemTool && isNotIgnoreItem(i)){
                BlockDispenser.dispenseBehaviorRegistry.putObject(Item.getItemById(i), new IBehaviorDispenseItem(){
                    public ItemStack dispense(IBlockSource var1, ItemStack var2){
                        World world = var1.getWorld();
                        IPosition iposition = BlockDispenser.func_149939_a(var1);
                        int x = (int) iposition.getX();
                        int y = (int) iposition.getY();
                        int z = (int) iposition.getZ();
                        Block block = world.getBlock(x, y, z);
                        int metadata = world.getBlockMetadata(x, y, z);
                        if((var2.func_150998_b(block) || block.getMaterial().isToolNotRequired()) && !world.isAirBlock(x, y, z)){
                            world.playAuxSFX(2001, x, y, z, Block.getIdFromBlock(block));
                            block.dropBlockAsItem(world, x, y, z, metadata, 0);
                            world.setBlockToAir(x, y, z);
                            var2.setItemDamage(var2.getItemDamage() + 1);
                        }
                        return var2;
                    }
                });
            }
        }
    }

    public boolean isNotIgnoreItem(int i){
        if(!ignoreItems.equals("")){
            for(String a : getIgnoreString(ignoreItems)){
                Item item1 = (Item) Item.itemRegistry.getObject(a);
                Item item = Item.getItemById(i);
                if(item.equals(item1)){
                    return false;
                }
            }
        }
        return true;

    }

    public String[] getIgnoreString(String s){
        return s.split(",");
    }
}
