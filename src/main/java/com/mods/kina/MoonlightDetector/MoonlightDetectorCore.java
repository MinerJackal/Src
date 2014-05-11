package com.mods.kina.MoonlightDetector;

import com.mods.kina.MoonlightDetector.blocks.BlockMoonlightDetector;
import com.mods.kina.MoonlightDetector.blocks.TileEntityMoonlightDetector;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

@Mod(modid = "moonlightdetector", version = "1.0.0")
public class MoonlightDetectorCore{
    public static Block blockMoonlightDetector;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        blockMoonlightDetector = (new BlockMoonlightDetector());
        GameRegistry.registerBlock(blockMoonlightDetector, "kina_blockMoonlightDetector");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        GameRegistry.registerTileEntity(TileEntityMoonlightDetector.class, "TileEntityMoonlightDetector");
        GameRegistry.addRecipe(new ItemStack(blockMoonlightDetector, 1), new Object[]{"XXX", "HDH", "HRH", 'X', Blocks.obsidian, 'H', Blocks.end_stone, 'D', Blocks.daylight_detector, 'R', Blocks.redstone_torch});
    }
}
