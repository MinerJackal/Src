package com.mods.kina.ThunderSword;

import com.mods.kina.ThunderSword.misc.ItemGrassPart;
import com.mods.kina.ThunderSword.misc.ItemMycelPart;
import com.mods.kina.ThunderSword.misc.ItemTileWatcher;
import com.mods.kina.ThunderSword.swords.*;
import com.mods.kina.ThunderSword.tools.ItemCreeperPickaxe;
import com.mods.kina.ThunderSword.tools.ItemInfinityCobblePickaxe;
import com.mods.kina.ThunderSword.tools.ItemPickHoe;
import com.mods.kina.ThunderSword.tools.ItemTntPickaxe;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = ThunderSwordCore.MODID, version = ThunderSwordCore.VERSION)
public class ThunderSwordCore{
    public static final String MODID = "kina_tsmod";
    public static final String VERSION = "1.5.1";
    public static final Item.ToolMaterial THUNDER = EnumHelper.addToolMaterial("THUNDER", 0, 150, 4.0F, 2.0F, 15);
    public static final Item.ToolMaterial EXPLOSION = EnumHelper.addToolMaterial("EXPLOSION", 0, 200, 4.0F, 2.5F, 10);
    public static final Item.ToolMaterial LIGHT = EnumHelper.addToolMaterial("LIGHT", 0, 100, 4.0F, 1.0F, 35);
    public static final Item.ToolMaterial TELEPORT = EnumHelper.addToolMaterial("TELEPORT", 0, 200, 4.0F, 2.0F, 10);
    public static final Item.ToolMaterial TNT = EnumHelper.addToolMaterial("TNT", 2, 200, 2.0F, 0.0F, 10);
    public static final Item.ToolMaterial RUSTY = EnumHelper.addToolMaterial("RUSTY", 0, 59, 2.0F, 0.0F, 15);
    public static final Item.ToolMaterial TIME = EnumHelper.addToolMaterial("TIME", 0, 200, 2.0F, 0.0F, 15);
    public static final Item.ToolMaterial FIRE = EnumHelper.addToolMaterial("FIRE", 0, 250, 2.0F, 0.0F, 10);
    public static final Item.ToolMaterial WATER = EnumHelper.addToolMaterial("WATER", 2, 250, 1.0F, 1.0F, 12);
    public static final Item.ToolMaterial LAVA = EnumHelper.addToolMaterial("LAVA", 2, 200, 1.0F, 2.0F, 12);
    public static final Item.ToolMaterial BONE = EnumHelper.addToolMaterial("BONE", 2, 200, 1.0F, 0.0F, 1);
    //public static Item ;
    public static Item itemThunderSword;
    public static Item itemExplosionSword;
    public static Item itemLightSword;
    public static Item itemTeleportSword;
    public static Item itemRustySword;
    public static Item itemBrokenSword;
    public static Item itemTntSword;
    public static Item itemTntPickaxe;
    public static Item itemCreeperPickaxe;
    public static Item itemTimeSword;
    public static Item itemFireSword;

    //public static Item itemEnderBow;
    public static Item itemWaterSword;
    public static Item itemLavaSword;
    public static Item itemInfinityCobblePickaxe;
    public static Item itemBoneMealSword;
    public static Item itemCraftSword;
    public static Item itemPickHoe;
    public static Item itemGrassPart;
    public static Item itemMycelPart;
    public static Item itemEdibleSword;
    public static Item itemTileWatcher;
    private final String DUNGEON_CHEST = ChestGenHooks.DUNGEON_CHEST;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        itemThunderSword = (new ItemThunderSword(THUNDER));
        itemExplosionSword = (new ItemExplosionSword(EXPLOSION));
        itemLightSword = (new ItemLightSword(LIGHT));
        itemTeleportSword = (new ItemTeleportSword(TELEPORT));
        itemRustySword = (new ItemSword(RUSTY).setUnlocalizedName("itemRustySword").setTextureName("kina:rusty_sword").setCreativeTab(CreativeTabs.tabCombat));
        itemBrokenSword = (new Item()).setUnlocalizedName("itemBrokenSword").setTextureName("kina:broken_sword").setCreativeTab(CreativeTabs.tabCombat);
        itemTntSword = (new ItemTntSword(TNT));
        itemTntPickaxe = (new ItemTntPickaxe(TNT));
        itemCreeperPickaxe = (new ItemCreeperPickaxe(Item.ToolMaterial.EMERALD));
        itemTimeSword = (new ItemTimeSword(TIME));
        itemFireSword = (new ItemFireSword(FIRE));
        itemWaterSword = (new ItemWaterSword(WATER));
        itemLavaSword = (new ItemLavaSword(LAVA));
        itemInfinityCobblePickaxe = (new ItemInfinityCobblePickaxe(Item.ToolMaterial.STONE));
        itemBoneMealSword = (new ItemBoneMealSword(BONE));
        itemCraftSword = (new ItemCraftSword());
        itemPickHoe = (new ItemPickHoe(Item.ToolMaterial.WOOD));
        itemGrassPart = (new ItemGrassPart());
        itemMycelPart = (new ItemMycelPart());
        itemEdibleSword = (new ItemEdibleSword(5));
        itemTileWatcher = (new ItemTileWatcher());
        //itemEnderBow=(new ItemEnderBow());


        GameRegistry.registerItem(itemThunderSword, "kina_itemThunderSword");
        GameRegistry.registerItem(itemExplosionSword, "kina_itemExplosionSword");
        GameRegistry.registerItem(itemLightSword, "kina_itemLightSword");
        GameRegistry.registerItem(itemTeleportSword, "kina_itemTeleportSword");
        GameRegistry.registerItem(itemRustySword, "kina_itemRustySword");
        GameRegistry.registerItem(itemBrokenSword, "kina_itemBrokenSword");
        GameRegistry.registerItem(itemTntSword, "kina_itemTntSword");
        GameRegistry.registerItem(itemTntPickaxe, "kina_itemTntPickaxe");
        GameRegistry.registerItem(itemCreeperPickaxe, "kina_itemCreeperPickaxe");
        GameRegistry.registerItem(itemTimeSword, "kina_itemTimeSword");
        GameRegistry.registerItem(itemFireSword, "kina_itemFireSword");
        GameRegistry.registerItem(itemWaterSword, "kina_itemWaterSword");
        GameRegistry.registerItem(itemLavaSword, "kina_itemLavaSword");
        GameRegistry.registerItem(itemInfinityCobblePickaxe, "kina_itemInfinityCobblePickaxe");
        GameRegistry.registerItem(itemBoneMealSword, "kina_itemBoneMealSword");
        GameRegistry.registerItem(itemCraftSword, "kina_itemCraftSword");
        GameRegistry.registerItem(itemPickHoe, "kina_itemPickHoe");
        GameRegistry.registerItem(itemGrassPart, "kina_itemGrassPart");
        GameRegistry.registerItem(itemMycelPart, "kina_itemMycelPart");
        GameRegistry.registerItem(itemEdibleSword, "kina_itemEdibleSword");
        GameRegistry.registerItem(itemTileWatcher, "kina_itemTileWatcher");
        //GameRegistry.registerItem(itemEnderBow,"kina_itemEnderBow");
    }

    @EventHandler
    public void init(FMLInitializationEvent event){

        ItemStack lightsword = new ItemStack(itemLightSword, 1);
        lightsword.addEnchantment(Enchantment.smite, 2);
        ItemStack firesword = new ItemStack(itemFireSword, 1);
        firesword.addEnchantment(Enchantment.fireAspect, 1);
        ItemStack lavasword = new ItemStack(itemLavaSword, 1);
        lavasword.addEnchantment(Enchantment.fireAspect, 3);
        GameRegistry.addRecipe(new ItemStack(itemThunderSword, 1), new Object[]{"X", "X", "Y", 'X', Items.iron_ingot, 'Y', Blocks.stone});
        GameRegistry.addRecipe(new ItemStack(itemExplosionSword, 1), new Object[]{" Y ", "YXY", " Y ", 'X', itemThunderSword, 'Y', Items.gunpowder});
        GameRegistry.addRecipe(lightsword, new Object[]{"YYY", "YXY", "YYY", 'X', itemThunderSword, 'Y', Blocks.glowstone});
        GameRegistry.addRecipe(new ItemStack(this.itemTeleportSword, 1),new Object[]{ "YXY",'X',this.itemExplosionSword ,'Y',Items.ender_pearl });
        GameRegistry.addShapelessRecipe(new ItemStack(itemTntSword, 1), new Object[]{new ItemStack(itemExplosionSword, 1), new ItemStack(Items.flint_and_steel, 1), new ItemStack(Blocks.tnt, 1)});
        GameRegistry.addRecipe(new ItemStack(itemTntPickaxe, 1), new Object[]{"YYY", " X ", " Z ", 'X', itemTntSword, 'Y', Items.iron_ingot, 'Z', Items.stick});
        GameRegistry.addRecipe(new ItemStack(itemCreeperPickaxe, 1), new Object[]{"YYY", " X ", " Z ", 'X', itemTntPickaxe, 'Y', Items.diamond, 'Z', Items.stick});
        GameRegistry.addRecipe(firesword, new Object[]{"FTI", 'F', Items.flint, 'T', itemThunderSword, 'I', Items.iron_ingot});
        GameRegistry.addRecipe(new ItemStack(itemWaterSword, 1), new Object[]{" W ", " W ", " T ", 'W', Items.water_bucket, 'T', itemTntSword});
        GameRegistry.addShapelessRecipe(lavasword, new Object[]{new ItemStack(itemFireSword), new ItemStack(Blocks.obsidian), new ItemStack(Items.lava_bucket, 2)});
        GameRegistry.addRecipe(new ItemStack(itemInfinityCobblePickaxe), new Object[]{"LCW", " B ", " B ", 'L', itemLavaSword, 'W', itemWaterSword, 'C', Blocks.cobblestone, 'B', Items.stick});
        GameRegistry.addRecipe(new ItemStack(itemInfinityCobblePickaxe), new Object[]{"WCL", " B ", " B ", 'L', itemLavaSword, 'W', itemWaterSword, 'C', Blocks.cobblestone, 'B', Items.stick});
        GameRegistry.addRecipe(new ItemStack(itemBoneMealSword), new Object[]{" B ", " B ", " T ", 'B', Items.bone, 'T', itemTntSword});
        GameRegistry.addShapelessRecipe(new ItemStack(itemPickHoe, 1), new Object[]{new ItemStack(itemBoneMealSword, 1), new ItemStack(Items.wooden_hoe, 1)});
        GameRegistry.addRecipe(new ItemStack(itemTileWatcher), new Object[]{"PPP", "PBP", "PPP", 'B', Items.ender_eye, 'P', Items.paper});
        GameRegistry.addShapelessRecipe(new ItemStack(itemEdibleSword, 1), new Object[]{new ItemStack(Items.poisonous_potato, 1), new ItemStack(Items.iron_sword, 1), new ItemStack(Items.cooked_beef, 1),new ItemStack(Items.cooked_chicken, 1),new ItemStack(Items.cooked_fished, 1),new ItemStack(Items.cooked_porkchop, 1),new ItemStack(Items.spider_eye, 1),new ItemStack(Items.rotten_flesh, 1),new ItemStack(Items.rotten_flesh, 1)});
        GameRegistry.addSmelting(itemRustySword, new ItemStack(itemTimeSword, 1), 0.1F);
        ChestGenHooks.addItem(DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(itemRustySword), 1, 1, 3));
        ChestGenHooks.getInfo(DUNGEON_CHEST).setMax(10);
        ChestGenHooks.getInfo(DUNGEON_CHEST).setMin(5);
    }
}