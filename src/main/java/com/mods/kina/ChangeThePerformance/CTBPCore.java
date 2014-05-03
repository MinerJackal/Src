package com.mods.kina.ChangeThePerformance;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.config.Configuration;

@Mod(modid = "ChangeTheBlockPerformanceMod")
public class CTBPCore{
    //public static String[] lightO;
    public static String lightOpacity;
    public static String hardness;
    public static String resistance;
    public static String lightLevel;
    public static String creativeTab;
    public static String stepSound;
    /*public static String creativeTabs;
    public static String stepSounds;
    public static int[] lightOpacityInt;
    public static int[] hardnessFloat;
    public static int[] resistanceFloat;
    public static int[] lightLevelFloat;*/

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        try{
            config.load();
            lightOpacity = config.get("LightOpacity", "LightOpacity_Block", "", "set light opacity \"Block,Level;\"").getString();
            //lightOpacityInt = config.get("LightOpacity","LightOpacity_Level","","set light opacity \"Level\"").getIntList();
            resistance = config.get("Resistance", "Resistance_Block", "", "set resistance(Explosion) \"Block,Level;\"").getString();
            //resistanceFloat = config.get("Resistance","Resistance_Level","","set resistance \"Level\"").getDoubleList();
            hardness = config.get("Hardness", "Hardness_Block", "", "set hardness(Mining) \"Block,Level;\"").getString();
            //hardnessFloat=config.get("Hardness","Hardness_Level","","set hardness \"Level\"").getDoubleList();
            lightLevel = config.get("LightLevel", "LightLevel_Block", "", "set light level \"Block,Level;\"").getString();
            //lightLevelFloat=config.get("LightLevel","LightLevel_Level","","set light level \"Level\"").getDoubleList();
            creativeTab = config.get("CreativeTab", "CreativeTab_Block", "", "set creative tab \"Block,Tab;\"Tabs=(Block,Brewing,Combat,Decorations,Food,Materials,Misc,Redstone,Tools,Transport)").getString();
            //creativeTabs=config.get("CreativeTab","CreativeTab_TAB","","set creative tab \"TAB\"").getStringList();
            stepSound = config.get("StepSound", "StepSound_Block", "", "set step sound \"Block,Sound;\"Sounds=(Anvil,Cloth,Grass,Glass,Gravel,Ladder,Metal,Piston,Sand,Stone,Wood)").getString();
            //stepSounds=config.get("StepSound","StepSound_Sound","","set step sound \"Sound\"").getStringList();
        } catch(Exception e){
            /*
			 * ファイルの読み込み/書き込み時に例外が発生した場合, ログに残す.
			 */
            FMLLog.severe("Error Message");
        }finally{
			/*
			 * 最後に必ずセーブする.
			 */
            config.save();
        }
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        if(!lightOpacity.equals("")) for(String a : getSet1(lightOpacity))
            Block.getBlockFromName(getSet2(a)[0]).setLightOpacity(Integer.valueOf(getSet2(a)[1]));
        if(!hardness.equals("")) for(String a : getSet1(hardness))
            Block.getBlockFromName(getSet2(a)[0]).setHardness(Integer.valueOf(getSet2(a)[1] + "f").floatValue());
        if(!resistance.equals("")) for(String a : getSet1(resistance))
            Block.getBlockFromName(getSet2(a)[0]).setResistance(Integer.valueOf(getSet2(a)[1] + "f").floatValue());
        if(!lightLevel.equals("")) for(String a : getSet1(lightLevel))
            Block.getBlockFromName(getSet2(a)[0]).setLightLevel(Integer.valueOf(getSet2(a)[1] + "f").floatValue());
        if(!creativeTab.equals("")) for(String a : getSet1(creativeTab))
            Block.getBlockFromName(getSet2(a)[0]).setCreativeTab(getTab(getSet2(a)[1]));
        if(!stepSound.equals("")) for(String a : getSet1(stepSound))
            Block.getBlockFromName(getSet2(a)[0]).setStepSound(getSound(getSet2(a)[1]));
    }

    public CreativeTabs getTab(String s){
        if(s.equals("Block")) return CreativeTabs.tabBlock;
        else if(s.equals("Brewing")) return CreativeTabs.tabBrewing;
        else if(s.equals("Combat")) return CreativeTabs.tabCombat;
        else if(s.equals("Decorations")) return CreativeTabs.tabDecorations;
        else if(s.equals("Food")) return CreativeTabs.tabFood;
        else if(s.equals("Materials")) return CreativeTabs.tabMaterials;
        else if(s.equals("Misc")) return CreativeTabs.tabMisc;
        else if(s.equals("Redstone")) return CreativeTabs.tabRedstone;
        else if(s.equals("Tools")) return CreativeTabs.tabTools;
        else if(s.equals("Transport")) return CreativeTabs.tabTransport;
        else return null;
    }

    public Block.SoundType getSound(String s){
        if(s.equals("Anvil")) return Block.soundTypeAnvil;
        else if(s.equals("Cloth")) return Block.soundTypeCloth;
        else if(s.equals("Glass")) return Block.soundTypeGlass;
        else if(s.equals("Grass")) return Block.soundTypeGrass;
        else if(s.equals("Gravel")) return Block.soundTypeGravel;
        else if(s.equals("Ladder")) return Block.soundTypeLadder;
        else if(s.equals("Metal")) return Block.soundTypeMetal;
        else if(s.equals("Piston")) return Block.soundTypePiston;
        else if(s.equals("Sand")) return Block.soundTypeSand;
        else if(s.equals("Snow")) return Block.soundTypeSnow;
        else if(s.equals("Stone")) return Block.soundTypeStone;
        else if(s.equals("Wood")) return Block.soundTypeWood;
        else return null;
    }

    public String[] getSet1(String s){
        return s.split(";");
    }

    public String[] getSet2(String s){
        return s.split(",");
    }
    /*public String getSet3(String a){
        return getSet2(getSet1(a))[0];
    }
    public String getSet4(String a){
        return getSet2(getSet1(a))[1];
    }*/
    /*public String getMap(Object o,int p){
        Map map=new HashMap();
        switch(p){
            case 1:for(String a : lightOpacity) for(int b : lightOpacityInt) put(map,a, b);break;
            case 2:for(String a : hardness) for(int b : hardnessFloat) put(map,a, b);break;
            case 3:for(String a : resistance) for(int b : resistanceFloat) put(map,a, b);break;
            case 4:for(String a : lightLevel) for(int b : lightLevelFloat) put(map,a, b);break;
            case 5:for(String a : creativeTab) for(String b : creativeTabs) put(map,a, b);break;
            case 6:for(String a : stepSound) for(String b : stepSounds) put(map,a, b);break;
        }
        return (String)map.get(o);
    }
    public void put(Map map,Object a,Object b){
        map.put(a,b);
        map.put(b,a);
    }*/
}
