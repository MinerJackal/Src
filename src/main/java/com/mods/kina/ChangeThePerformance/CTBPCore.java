package com.mods.kina.ChangeThePerformance;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fluids.FluidRegistry;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Mod(modid = "kina_OverwriteInformationMod")
public class CTBPCore{
    public final static String BLOCK = "Block";
    public final static String ITEM = "Item";
    public static final String FOOD = "ItemFood";
    public static final String FLUID = "Fluid";
    public static String lightOpacity;
    public static String hardness;
    public static String resistance;
    public static String lightLevel;
    public static String creativeTab;
    public static String stepSound;
    public static String harvestLevelB;
    public static String creativeTabI;
    public static String maxDamage;
    public static String maxStackSize;
    public static String potionEffect;
    public static String harvestLevel;
    public static String full3D;
    public static String alwaysEdible;
    public static String potionEffectF;
    public static String fluidLuminosity;
    public static String fluidDensity;
    public static String fluidTemperature;
    public static String fluidViscosity;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        Configuration config = new Configuration(new File(event.getModConfigurationDirectory(), "OverwriteInformationMod.cfg"));
        try{
            config.load();
            lightOpacity = config.get(BLOCK, "LightOpacity_Block", "", "set light opacity \"Block,Level;\"").getString();
            resistance = config.get(BLOCK, "Resistance_Block", "", "set resistance(Explosion) \"Block,Level;\"").getString();
            hardness = config.get(BLOCK, "Hardness_Block", "", "set hardness(Mining) \"Block,Level;\"").getString();
            lightLevel = config.get(BLOCK, "LightLevel_Block", "", "set light level \"Block,Level;\"").getString();
            creativeTab = config.get(BLOCK, "CreativeTab_Block", "", "set creative tab \"Block,Tab;\"Tabs=(Block,Brewing,Combat,Decorations,Food,Materials,Misc,Redstone,Tools,Transport)").getString();
            stepSound = config.get(BLOCK, "StepSound_Block", "", "set step sound \"Block,Sound;\"Sounds=(Anvil,Cloth,Grass,Glass,Gravel,Ladder,Metal,Piston,Sand,Stone,Wood)").getString();
            harvestLevelB = config.get(BLOCK, "HarvestLevel_Block", "", "set harvest level \"Block,Tool,Level;\"Tools=(axe,pickaxe,shovel),Levels=(Wood:0,Stone:1,Iron:2,Diamond:3,Gold:0)").getString();
            creativeTabI = config.get(ITEM, "CreativeTab_Item", "", "set creative tab \"Item,Tab;\"Tabs=(Block,Brewing,Combat,Decorations,Food,Materials,Misc,Redstone,Tools,Transport)").getString();
            maxDamage = config.get(ITEM, "MaxDamage_Item", "", "set durability \"Item,MaxDamage;\"").getString();
            maxStackSize = config.get(ITEM, "MaxStackSize_Item", "", "set max stack size \"Item,MaxStackSize;\"").getString();
            potionEffect = config.get(ITEM, "PotionRecipe_Item", "", "set potion recipe \"Item,VanillaPosition;\"Positions=(BlazePowder,FermentedSpiderEye,Glowstone,GoldenCarrot,GoldenMelon,Gunpowder,MagmaCream,NetherWart,Redstone,SpiderEye,Sugar,Unimplemented)").getString();
            harvestLevel = config.get(ITEM, "HarvestLevel_Item", "", "set harvest level \"Item,Tool,Level;\"Tools=(axe,pickaxe,shovel),Levels=(Wood:0,Stone:1,Iron:2,Diamond:3,Gold:0)").getString();
            full3D = config.get(ITEM, "HoldToolLike_Item", "", "set hold tool like \"Item;\"").getString();
            alwaysEdible = config.get(FOOD, "AlwaysEdible_Food", "", "set always edible \"Food;\"").getString();
            potionEffectF = config.get(FOOD, "PotionEffect_Food", "", "set potion effect \"Food,Effect(name or id),Duration,AmplifierLevel,Probability;\"Effects=(Speed,Slowness,Haste,MiningFatigue,Strength,InstantHealth,InstantDamage,JumpBoost,Nausea,Regeneration,Resistance,FireResistance,WaterBreathing,Invisibility,Blindness,NightVision,Hunger,Weakness,Poison,Wither,HealthBoost,Absorption,Saturation)").getString();
            fluidLuminosity = config.get(FLUID, "LightLevel_Fluid", "", "set light level \"Fluid,Level\"").getString();
            fluidDensity = config.get(FLUID, "Density_Fluid", "", "set density \"Fluid,Level\"").getString();
            fluidTemperature = config.get(FLUID, "Temperature_Fluid", "", "set temperature \"Fluid,Degree\"").getString();
            fluidViscosity = config.get(FLUID, "Viscosity_Fluid", "", "set viscosity \"Fluid,Level\"").getString();
        } catch(Exception e){
            FMLLog.severe("Error Message");
        }finally{
            config.save();
        }
    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event){
        //Block
        if(!lightOpacity.equals("")) for(String a : getSet1(lightOpacity))
            Block.getBlockFromName(getSet2(a)[0]).setLightOpacity(Integer.valueOf(getSet2(a)[1]));
        if(!hardness.equals("")) for(String a : getSet1(hardness))
            Block.getBlockFromName(getSet2(a)[0]).setHardness(Float.valueOf(getSet2(a)[1] + "f"));
        if(!resistance.equals("")) for(String a : getSet1(resistance))
            Block.getBlockFromName(getSet2(a)[0]).setResistance(Float.valueOf(getSet2(a)[1] + "f"));
        if(!lightLevel.equals("")) for(String a : getSet1(lightLevel))
            Block.getBlockFromName(getSet2(a)[0]).setLightLevel(Float.valueOf(getSet2(a)[1] + "f"));
        if(!creativeTab.equals("")) for(String a : getSet1(creativeTab))
            Block.getBlockFromName(getSet2(a)[0]).setCreativeTab(getTab(getSet2(a)[1]));
        if(!stepSound.equals("")) for(String a : getSet1(stepSound))
            Block.getBlockFromName(getSet2(a)[0]).setStepSound(getSound(getSet2(a)[1]));
        if(!harvestLevelB.equals("")) for(String a : getSet1(harvestLevelB))
            Block.getBlockFromName(getSet2(a)[0]).setHarvestLevel(getSet2(a)[1], Integer.valueOf(getSet2(a)[2]));
        //Item
        if(!creativeTabI.equals("")) for(String a : getSet1(creativeTabI))
            getItemFromName(getSet2(a)[0]).setCreativeTab(getTab(getSet2(a)[1]));
        if(!maxDamage.equals("")) for(String a : getSet1(maxDamage))
            getItemFromName(getSet2(a)[0]).setMaxDamage(Integer.valueOf(getSet2(a)[1]));
        if(!maxStackSize.equals("")) for(String a : getSet1(maxStackSize))
            getItemFromName(getSet2(a)[0]).setMaxStackSize(Integer.valueOf(getSet2(a)[1]));
        if(!potionEffect.equals("")) for(String a : getSet1(potionEffect))
            getItemFromName(getSet2(a)[0]).setPotionEffect(getPotionEffect(getSet2(a)[1]));
        if(!harvestLevel.equals("")) for(String a : getSet1(harvestLevel))
            getItemFromName(getSet2(a)[0]).setHarvestLevel(getSet2(a)[1], Integer.valueOf(getSet2(a)[2]));
        if(!full3D.equals("")) for(String a : getSet1(full3D))
            getItemFromName(a).setFull3D();
        //Food
        if(!alwaysEdible.equals("")) for(String a : getSet1(alwaysEdible))
            getItemFoodFromName(a).setAlwaysEdible();
        if(!potionEffectF.equals("")) for(String a : getSet1(potionEffectF))
            getItemFoodFromName(getSet2(a)[0]).setPotionEffect(getPotionIdFromName(getSet2(a)[1]), Integer.valueOf(getSet2(a)[2]), Integer.valueOf(getSet2(a)[3]), Float.valueOf(getSet2(a)[4] + "f"));
        //Fluid
        if(!fluidLuminosity.equals("")) for(String a : getSet1(fluidLuminosity))
            FluidRegistry.getFluid(getSet2(a)[0]).setLuminosity(Integer.valueOf(getSet2(a)[1]));
        if(!fluidDensity.equals("")) for(String a : getSet1(fluidDensity))
            FluidRegistry.getFluid(getSet2(a)[0]).setDensity(Integer.valueOf(getSet2(a)[1]));
        if(!fluidTemperature.equals("")) for(String a : getSet1(fluidTemperature))
            FluidRegistry.getFluid(getSet2(a)[0]).setTemperature(Integer.valueOf(getSet2(a)[1]));
        if(!fluidViscosity.equals("")) for(String a : getSet1(fluidViscosity))
            FluidRegistry.getFluid(getSet2(a)[0]).setViscosity(Integer.valueOf(getSet2(a)[1]));
    }

    public CreativeTabs getTab(String s){
        if(s.equalsIgnoreCase("Block")) return CreativeTabs.tabBlock;
        else if(s.equalsIgnoreCase("Brewing")) return CreativeTabs.tabBrewing;
        else if(s.equalsIgnoreCase("Combat")) return CreativeTabs.tabCombat;
        else if(s.equalsIgnoreCase("Decorations")) return CreativeTabs.tabDecorations;
        else if(s.equalsIgnoreCase("Food")) return CreativeTabs.tabFood;
        else if(s.equalsIgnoreCase("Materials")) return CreativeTabs.tabMaterials;
        else if(s.equalsIgnoreCase("Misc")) return CreativeTabs.tabMisc;
        else if(s.equalsIgnoreCase("Redstone")) return CreativeTabs.tabRedstone;
        else if(s.equalsIgnoreCase("Tools")) return CreativeTabs.tabTools;
        else if(s.equalsIgnoreCase("Transport")) return CreativeTabs.tabTransport;
        else return (CreativeTabs)getClassFromName(s);
    }

    public Block.SoundType getSound(String s){
        if(s.equalsIgnoreCase("Anvil")) return Block.soundTypeAnvil;
        else if(s.equalsIgnoreCase("Cloth")) return Block.soundTypeCloth;
        else if(s.equalsIgnoreCase("Glass")) return Block.soundTypeGlass;
        else if(s.equalsIgnoreCase("Grass")) return Block.soundTypeGrass;
        else if(s.equalsIgnoreCase("Gravel")) return Block.soundTypeGravel;
        else if(s.equalsIgnoreCase("Ladder")) return Block.soundTypeLadder;
        else if(s.equalsIgnoreCase("Metal")) return Block.soundTypeMetal;
        else if(s.equalsIgnoreCase("Piston")) return Block.soundTypePiston;
        else if(s.equalsIgnoreCase("Sand")) return Block.soundTypeSand;
        else if(s.equalsIgnoreCase("Snow")) return Block.soundTypeSnow;
        else if(s.equalsIgnoreCase("Stone")) return Block.soundTypeStone;
        else if(s.equalsIgnoreCase("Wood")) return Block.soundTypeWood;
        else return null;
    }

    public String getPotionEffect(String s){
        if(s.equalsIgnoreCase("Sugar")) return "-0+1-2-3&4-4+13";
        else if(s.equalsIgnoreCase("MagmaCream")) return "+0+1-2-3&4-4+13";
        else if(s.equalsIgnoreCase("GoldenMelon")) return "+0-1+2-3&4-4+13";
        else if(s.equalsIgnoreCase("SpiderEye")) return "-0-1+2-3&4-4+13";
        else if(s.equalsIgnoreCase("FermentedSpiderEye")) return "-0+3-4+13";
        else if(s.equalsIgnoreCase("BlazePowder")) return "+0-1-2+3&4-4+13";
        else if(s.equalsIgnoreCase("GoldenCarrot")) return "-0+1+2-3+13&4-4";
        else if(s.equalsIgnoreCase("Glowstone")) return "+5-6-7";
        else if(s.equalsIgnoreCase("Redstone")) return "-5+6-7";
        else if(s.equalsIgnoreCase("Gunpowder")) return "+14&13-13";
        else if(s.equalsIgnoreCase("NetherWart")) return "+4";
        else if(s.equalsIgnoreCase("Unimplemented")) return "+0-1+2+3+13&4-4";
        else return null;
    }

    public int getPotionIdFromName(String s){
        if(isInteger(s)) return Integer.valueOf(s);
        else{
            if(s.equalsIgnoreCase("Speed")) return Potion.moveSpeed.id;
            else if(s.equalsIgnoreCase("Slowness")) return Potion.moveSlowdown.id;
            else if(s.equalsIgnoreCase("Haste")) return Potion.digSpeed.id;
            else if(s.equalsIgnoreCase("MiningFatigue")) return Potion.digSlowdown.id;
            else if(s.equalsIgnoreCase("Strength")) return Potion.damageBoost.id;
            else if(s.equalsIgnoreCase("InstantHealth")) return Potion.heal.id;
            else if(s.equalsIgnoreCase("InstantDamage")) return Potion.harm.id;
            else if(s.equalsIgnoreCase("JumpBoost")) return Potion.jump.id;
            else if(s.equalsIgnoreCase("Nausea")) return Potion.confusion.id;
            else if(s.equalsIgnoreCase("Regeneration")) return Potion.regeneration.id;
            else if(s.equalsIgnoreCase("Resistance")) return Potion.resistance.id;
            else if(s.equalsIgnoreCase("FireResistance")) return Potion.fireResistance.id;
            else if(s.equalsIgnoreCase("WaterBreathing")) return Potion.waterBreathing.id;
            else if(s.equalsIgnoreCase("Invisibility")) return Potion.invisibility.id;
            else if(s.equalsIgnoreCase("Blindness")) return Potion.blindness.id;
            else if(s.equalsIgnoreCase("NightVision")) return Potion.nightVision.id;
            else if(s.equalsIgnoreCase("Hunger")) return Potion.hunger.id;
            else if(s.equalsIgnoreCase("Weakness")) return Potion.weakness.id;
            else if(s.equalsIgnoreCase("Poison")) return Potion.poison.id;
            else if(s.equalsIgnoreCase("Wither")) return Potion.wither.id;
            else if(s.equalsIgnoreCase("HealthBoost")) return Potion.field_76434_w.id;
            else if(s.equalsIgnoreCase("Absorption")) return Potion.field_76444_x.id;
            else if(s.equalsIgnoreCase("Saturation")) return Potion.field_76443_y.id;
            else return 0;
        }
    }

    public boolean isInteger(String s){
        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher(s);
        return matcher.find();
    }

    public Item getItemFromName(String s){
        return (Item) Item.itemRegistry.getObject(s);
    }

    public ItemFood getItemFoodFromName(String s){
        return (ItemFood) getItemFromName(s);
    }

    public ItemBlock getItemBlockFromName(String s){
        return (ItemBlock) Item.getItemFromBlock(Block.getBlockFromName(s));
    }

    public Object getClassFromName(String s){
        try{
            return Class.forName(s);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }

    public String[] getSet1(String s){
        return s.split(";");
    }

    public String[] getSet2(String s){
        return s.split(",");
    }
}
