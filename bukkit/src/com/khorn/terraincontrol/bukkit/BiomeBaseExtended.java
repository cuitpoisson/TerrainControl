//package net.minecraft.server.v1_6_R3;
package com.khorn.terraincontrol.bukkit;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.avaje.ebean.enhance.asm.commons.Method;

import net.minecraft.server.v1_6_R3.*;

public class BiomeBaseExtended extends BiomeBase
{
    /** An array of all the biomes, indexed by biome id. */
    public static final BiomeBase[] biomes = new BiomeBase[512];
    public static final BiomeBase OCEAN;// = (new BiomeOcean(0)).b(112).a("Ocean").b(-1.0F, 0.4F);
    public static final BiomeBase PLAINS;// = (new BiomePlains(1)).b(9286496).a("Plains").a(0.8F, 0.4F);
    public static final BiomeBase DESERT;// = (new BiomeDesert(2)).b(16421912).a("Desert").m().a(2.0F, 0.0F).b(0.1F, 0.2F);
    public static final BiomeBase EXTREME_HILLS;// = (new BiomeBigHills(3)).b(6316128).a("Extreme Hills").b(0.3F, 1.5F).a(0.2F, 0.3F);
    public static final BiomeBase FOREST;// = (new BiomeForest(4)).b(353825).a("Forest").a(5159473).a(0.7F, 0.8F);
    public static final BiomeBase TAIGA;// = (new BiomeTaiga(5)).b(747097).a("Taiga").a(5159473).b().a(0.05F, 0.8F).b(0.1F, 0.4F);
    public static final BiomeBase SWAMPLAND;// = (new BiomeSwamp(6)).b(522674).a("Swampland").a(9154376).b(-0.2F, 0.1F).a(0.8F, 0.9F);
    public static final BiomeBase RIVER;// = (new BiomeRiver(7)).b(255).a("River").b(-0.5F, 0.0F);
    public static final BiomeBase HELL;// = (new BiomeHell(8)).b(16711680).a("Hell").m().a(2.0F, 0.0F);

    /** Is the biome used for sky world. */
    public static final BiomeBase SKY;// = (new BiomeTheEnd(9)).b(8421631).a("Sky").m();
    public static final BiomeBase FROZEN_OCEAN;// = (new BiomeOcean(10)).b(9474208).a("FrozenOcean").b().b(-1.0F, 0.5F).a(0.0F, 0.5F);
    public static final BiomeBase FROZEN_RIVER;// = (new BiomeRiver(11)).b(10526975).a("FrozenRiver").b().b(-0.5F, 0.0F).a(0.0F, 0.5F);
    public static final BiomeBase ICE_PLAINS;// = (new BiomeIcePlains(12)).b(16777215).a("Ice Plains").b().a(0.0F, 0.5F);
    public static final BiomeBase ICE_MOUNTAINS;// = (new BiomeIcePlains(13)).b(10526880).a("Ice Mountains").b().b(0.3F, 1.3F).a(0.0F, 0.5F);
    public static final BiomeBase MUSHROOM_ISLAND;// = (new BiomeMushrooms(14)).b(16711935).a("MushroomIsland").a(0.9F, 1.0F).b(0.2F, 1.0F);
    public static final BiomeBase MUSHROOM_SHORE;// = (new BiomeMushrooms(15)).b(10486015).a("MushroomIslandShore").a(0.9F, 1.0F).b(-1.0F, 0.1F);

    /** Beach biome. */
    public static final BiomeBase BEACH;// = (new BiomeBeach(16)).b(16440917).a("Beach").a(0.8F, 0.4F).b(0.0F, 0.1F);

    /** Desert Hills biome. */
    public static final BiomeBase DESERT_HILLS;// = (new BiomeDesert(17)).b(13786898).a("DesertHills").m().a(2.0F, 0.0F).b(0.3F, 0.8F);

    /** Forest Hills biome. */
    public static final BiomeBase FOREST_HILLS;// = (new BiomeForest(18)).b(2250012).a("ForestHills").a(5159473).a(0.7F, 0.8F).b(0.3F, 0.7F);

    /** Taiga Hills biome. */
    public static final BiomeBase TAIGA_HILLS;// = (new BiomeTaiga(19)).b(1456435).a("TaigaHills").b().a(5159473).a(0.05F, 0.8F).b(0.3F, 0.8F);

    /** Extreme Hills Edge biome. */
    public static final BiomeBase SMALL_MOUNTAINS;// = (new BiomeBigHills(20)).b(7501978).a("Extreme Hills Edge").b(0.2F, 0.8F).a(0.2F, 0.3F);

    /** Jungle biome identifier */
    public static final BiomeBase JUNGLE;// = (new BiomeJungle(21)).b(5470985).a("Jungle").a(5470985).a(1.2F, 0.9F).b(0.2F, 0.4F);
    public static final BiomeBase JUNGLE_HILLS;// = (new BiomeJungle(22)).b(2900485).a("JungleHills").a(5470985).a(1.2F, 0.9F).b(1.8F, 0.5F);
    
    static
    {
	    //OCEAN = (new BiomeOcean(0)).b(112).a("Ocean").b(-1.0F, 0.4F);
//
//	    OCEAN = (new BiomeOcean(0));//
//        Class[] cArg = new Class[1];
//        cArg[0] = Integer.class;
//	    java.lang.reflect.Method privateMethod = BiomeOcean.class.getDeclaredMethod("b",cArg);
//		privateMethod.setAccessible(true);
//		privateMethod.invoke(OCEAN, 112);
//	    //OCEAN.b(112);//.a("Ocean").b(-1.0F, 0.4F);
//	    PLAINS = (new BiomePlains(1)).b(9286496).a("Plains").a(0.8F, 0.4F);
////	    OCEAN = (new BiomeOcean(0));//
//        Class[] arg_int = new Class[1];
//        arg_int[0] = Integer.class;
//	    java.lang.reflect.Method privateMethod = BiomeOcean.class.getDeclaredMethod("b",arg_int);
//	    privateMethod.setAccessible(true);
//	    privateMethod.invoke(OCEAN,112);
//	    //OCEAN.b(112);//.a("Ocean").b(-1.0F, 0.4F);
//	    Constructor<BiomePlains> constructor;
//        constructor = BiomePlains.class.getDeclaredConstructor(arg_int);
//        constructor.setAccessible(true);
//	    PLAINS = constructor.newInstance(1);//(new BiomePlains(1)).b(9286496).a("Plains").a(0.8F, 0.4F);
//	    
//	    DESERT = (new BiomeDesert(2)).b(16421912).a("Desert").m().a(2.0F, 0.0F).b(0.1F, 0.2F);
//	    EXTREME_HILLS = (new BiomeBigHills(3)).b(6316128).a("Extreme Hills").b(0.3F, 1.5F).a(0.2F, 0.3F);
//	    FOREST = (new BiomeForest(4)).b(353825).a("Forest").a(5159473).a(0.7F, 0.8F);
//	    TAIGA = (new BiomeTaiga(5)).b(747097).a("Taiga").a(5159473).b().a(0.05F, 0.8F).b(0.1F, 0.4F);
//	    SWAMPLAND = (new BiomeSwamp(6)).b(522674).a("Swampland").a(9154376).b(-0.2F, 0.1F).a(0.8F, 0.9F);
//	    RIVER = (new BiomeRiver(7)).b(255).a("River").b(-0.5F, 0.0F);
//	    HELL = (new BiomeHell(8)).b(16711680).a("Hell").m().a(2.0F, 0.0F);
//
//	    /** Is the biome used for sky world. */
//	    SKY = (new BiomeTheEnd(9)).b(8421631).a("Sky").m();
//	    FROZEN_OCEAN = (new BiomeOcean(10)).b(9474208).a("FrozenOcean").b().b(-1.0F, 0.5F).a(0.0F, 0.5F);
//	    BiomeBase FROZEN_RIVER = (new BiomeRiver(11)).b(10526975).a("FrozenRiver").b().b(-0.5F, 0.0F).a(0.0F, 0.5F);
//	    ICE_PLAINS = (new BiomeIcePlains(12)).b(16777215).a("Ice Plains").b().a(0.0F, 0.5F);
//	    ICE_MOUNTAINS = (new BiomeIcePlains(13)).b(10526880).a("Ice Mountains").b().b(0.3F, 1.3F).a(0.0F, 0.5F);
//	    MUSHROOM_ISLAND = (new BiomeMushrooms(14)).b(16711935).a("MushroomIsland").a(0.9F, 1.0F).b(0.2F, 1.0F);
//	    MUSHROOM_SHORE = (new BiomeMushrooms(15)).b(10486015).a("MushroomIslandShore").a(0.9F, 1.0F).b(-1.0F, 0.1F);
//
//	    /** Beach biome. */
//	    BEACH = (new BiomeBeach(16)).b(16440917).a("Beach").a(0.8F, 0.4F).b(0.0F, 0.1F);
//
//	    /** Desert Hills biome. */
//	    DESERT_HILLS = (new BiomeDesert(17)).b(13786898).a("DesertHills").m().a(2.0F, 0.0F).b(0.3F, 0.8F);
//
//	    /** Forest Hills biome. */
//	    FOREST_HILLS = (new BiomeForest(18)).b(2250012).a("ForestHills").a(5159473).a(0.7F, 0.8F).b(0.3F, 0.7F);
//
//	    /** Taiga Hills biome. */
//	    TAIGA_HILLS = (new BiomeTaiga(19)).b(1456435).a("TaigaHills").b().a(5159473).a(0.05F, 0.8F).b(0.3F, 0.8F);
//
//	    /** Extreme Hills Edge biome. */
//	    SMALL_MOUNTAINS = (new BiomeBigHills(20)).b(7501978).a("Extreme Hills Edge").b(0.2F, 0.8F).a(0.2F, 0.3F);
//
//	    /** Jungle biome identifier */
//	    JUNGLE = (new BiomeJungle(21)).b(5470985).a("Jungle").a(5470985).a(1.2F, 0.9F).b(0.2F, 0.4F);
//	    JUNGLE_HILLS = (new BiomeJungle(22)).b(2900485).a("JungleHills").a(5470985).a(1.2F, 0.9F).b(1.8F, 0.5F);
//*/	 	    OCEAN = (new BiomeOcean(0));//
        Class[] arg_int = new Class[1];
        arg_int[0] = int.class;
	    java.lang.reflect.Method privateMethod;
	    Constructor<BiomePlains> constructorBP;
	    Constructor<BiomeBigHills> constructorBH;
	    Constructor<BiomeSwamp> constructorSL;
	    OCEAN = (new BiomeOcean(0));
	    DESERT = (new BiomeDesert(2));//.b(16421912).a("Desert").m().a(2.0F, 0.0F).b(0.1F, 0.2F);
	    FOREST = (new BiomeForest(4));//.b(353825).a("Forest").a(5159473).a(0.7F, 0.8F);
	    TAIGA = (new BiomeTaiga(5));//.b(747097).a("Taiga").a(5159473).b().a(0.05F, 0.8F).b(0.1F, 0.4F);
	    RIVER = (new BiomeRiver(7));//.b(255).a("River").b(-0.5F, 0.0F);
	    HELL = (new BiomeHell(8));//.b(16711680).a("Hell").m().a(2.0F, 0.0F);
	    /** Is the biome used for sky world. */
	    SKY = (new BiomeTheEnd(9));//.b(8421631).a("Sky").m();
	    FROZEN_OCEAN = (new BiomeOcean(10));//.b(9474208).a("FrozenOcean").b().b(-1.0F, 0.5F).a(0.0F, 0.5F);
	    FROZEN_RIVER = (new BiomeRiver(11));//.b(10526975).a("FrozenRiver").b().b(-0.5F, 0.0F).a(0.0F, 0.5F);
	    ICE_PLAINS = (new BiomeIcePlains(12));//.b(16777215).a("Ice Plains").b().a(0.0F, 0.5F);
	    ICE_MOUNTAINS = (new BiomeIcePlains(13));//.b(10526880).a("Ice Mountains").b().b(0.3F, 1.3F).a(0.0F, 0.5F);
	    MUSHROOM_ISLAND = (new BiomeMushrooms(14));//.b(16711935).a("MushroomIsland").a(0.9F, 1.0F).b(0.2F, 1.0F);
	    MUSHROOM_SHORE = (new BiomeMushrooms(15));//.b(10486015).a("MushroomIslandShore").a(0.9F, 1.0F).b(-1.0F, 0.1F);

	    /** Beach biome. */
	    BEACH = (new BiomeBeach(16));//.b(16440917).a("Beach").a(0.8F, 0.4F).b(0.0F, 0.1F);

	    /** Desert Hills biome. */
	    DESERT_HILLS = (new BiomeDesert(17));//.b(13786898).a("DesertHills").m().a(2.0F, 0.0F).b(0.3F, 0.8F);

	    /** Forest Hills biome. */
	    FOREST_HILLS = (new BiomeForest(18));//.b(2250012).a("ForestHills").a(5159473).a(0.7F, 0.8F).b(0.3F, 0.7F);

	    /** Taiga Hills biome. */
	    TAIGA_HILLS = (new BiomeTaiga(19));//.b(1456435).a("TaigaHills").b().a(5159473).a(0.05F, 0.8F).b(0.3F, 0.8F);
		
	    /** Jungle biome identifier */
	    JUNGLE = (new BiomeJungle(21));//.b(5470985).a("Jungle").a(5470985).a(1.2F, 0.9F).b(0.2F, 0.4F);
	    JUNGLE_HILLS = (new BiomeJungle(22));//.b(2900485).a("JungleHills").a(5470985).a(1.2F, 0.9F).b(1.8F, 0.5F);
		try {
			privateMethod = BiomeBase.class.getDeclaredMethod("b",arg_int);
		    privateMethod.setAccessible(true);
		    privateMethod.invoke(OCEAN,112);
		    //OCEAN.b(112);//.a("Ocean").b(-1.0F, 0.4F);	
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BiomeBase tempBiome;
        try {
			constructorBP = BiomePlains.class.getDeclaredConstructor(arg_int);
			constructorBP.setAccessible(true);
			tempBiome = constructorBP.newInstance(1);//(new BiomePlains(1)).b(9286496).a("Plains").a(0.8F, 0.4F);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tempBiome = new BiomeOcean(1);
		} 
        PLAINS = tempBiome;
        try {
	        constructorBH = BiomeBigHills.class.getDeclaredConstructor(arg_int);
	        constructorBH.setAccessible(true);
	        tempBiome = constructorBH.newInstance(3);//(new BiomeBigHills(3)).b(6316128).a("Extreme Hills").b(0.3F, 1.5F).a(0.2F, 0.3F);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tempBiome = new BiomeOcean(1);
		} 
        EXTREME_HILLS = tempBiome;
        try {
	        constructorSL = BiomeSwamp.class.getDeclaredConstructor(arg_int);
	        constructorSL.setAccessible(true);
	        tempBiome = constructorSL.newInstance(6);//.b(522674).a("Swampland").a(9154376).b(-0.2F, 0.1F).a(0.8F, 0.9F);
		   // SWAMPLAND = (new BiomeSwamp(6)).b(522674).a("Swampland").a(9154376).b(-0.2F, 0.1F).a(0.8F, 0.9F);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tempBiome = new BiomeOcean(1);
		} 
        SWAMPLAND = tempBiome;
        try {
	        constructorBH = BiomeBigHills.class.getDeclaredConstructor(arg_int);
	        constructorBH.setAccessible(true);
		    /** Extreme Hills Edge biome. */
        	tempBiome = constructorBH.newInstance(20);//.b(7501978).a("Extreme Hills Edge").b(0.2F, 0.8F).a(0.2F, 0.3F);
		    //SMALL_MOUNTAINS = (new BiomeBigHills(20)).b(7501978).a("Extreme Hills Edge").b(0.2F, 0.8F).a(0.2F, 0.3F);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tempBiome = new BiomeOcean(1);
		} 
        SMALL_MOUNTAINS = tempBiome;
    }
    public String y;
    public int z;

    /** The block expected to be on the top of this biome */
    public byte A;

    /** The block to fill spots in when not on the top */
    public byte B;
    public int C;

    /** The minimum height of this biome. Default 0.1. */
    public float D;

    /** The maximum height of this biome. Default 0.3. */
    public float E;

    /** The temperature of this biome. */
    public float temperature;

    /** The rainfall in this biome. */
    public float humidity;

    /** Color tint applied to water depending on biome */
    public int H;

    /** The biome decorator. */
    public BiomeDecorator I;

    /**
     * Holds the classes of IMobs (hostile mobs) that can be spawned in the biome.
     */
    protected List J;

    /**
     * Holds the classes of any creature that can be spawned in the biome as friendly creature.
     */
    protected List K;

    /**
     * Holds the classes of any aquatic creature that can be spawned in the water of the biome.
     */
    protected List L;
    protected List M;

    /** Set to true if snow is enabled for this biome. */
    private boolean S;

    /**
     * Is true (default) if the biome support rain (desert and nether can't have rain)
     */
    private boolean T;

    /** The id number to this biome, and its index in the biomeList array. */
    public final int id;

    /** The tree generator. */
    protected WorldGenTrees O;

    /** The big tree generator. */
    protected WorldGenBigTree P;

    /** The forest generator. */
    protected WorldGenForest Q;

    /** The swamp tree generator. */
    protected WorldGenSwampTree R;

    protected BiomeBaseExtended(int par1)
    {
    	super(0);	//Set it to 0 on its super class so everything overlaps, therefore if we don't see overlap, we are good (it's looking up the correct id)
        this.A = (byte)Block.GRASS.id;//GRASS.blockID;
        this.B = (byte)Block.DIRT.id;
        this.C = 5169201;
        this.D = 0.1F;
        this.E = 0.3F;
        this.temperature = 0.5F;
        this.humidity = 0.5F;
        this.H = 16777215;
        this.J = new ArrayList();
        this.K = new ArrayList();
        this.L = new ArrayList();
        this.M = new ArrayList();
        this.T = true;
        this.O = new WorldGenTrees(false);
        this.P = new WorldGenBigTree(false);
        this.Q = new WorldGenForest(false);
        this.R = new WorldGenSwampTree();
        this.id = par1;
        biomes[par1] = this;
        this.I = this.a();
        this.K.add(new BiomeMeta(EntitySheep.class, 12, 4, 4));
        this.K.add(new BiomeMeta(EntityPig.class, 10, 4, 4));
        this.K.add(new BiomeMeta(EntityChicken.class, 10, 4, 4));
        this.K.add(new BiomeMeta(EntityCow.class, 8, 4, 4));
        this.J.add(new BiomeMeta(EntitySpider.class, 10, 4, 4));
        this.J.add(new BiomeMeta(EntityZombie.class, 10, 4, 4));
        this.J.add(new BiomeMeta(EntitySkeleton.class, 10, 4, 4));
        this.J.add(new BiomeMeta(EntityCreeper.class, 10, 4, 4));
        this.J.add(new BiomeMeta(EntitySlime.class, 10, 4, 4));
        this.J.add(new BiomeMeta(EntityEnderman.class, 1, 1, 4));
        this.L.add(new BiomeMeta(EntitySquid.class, 10, 4, 4));
        this.M.add(new BiomeMeta(EntityBat.class, 10, 8, 8));
    }


    /**
     * Allocate a new BiomeDecorator for this BiomeBaseExtended
     */
    protected BiomeDecorator a()
    {
        return new BiomeDecorator(this);
    }

    /**
     * Sets the temperature and rainfall of this biome.
     */
    private BiomeBaseExtended a(float par1, float par2)
    {
        if (par1 > 0.1F && par1 < 0.2F)
        {
            throw new IllegalArgumentException("Please avoid temperatures in the range 0.1 - 0.2 because of snow");
        }
        else
        {
            this.temperature = par1;
            this.humidity = par2;
            return this;
        }
    }

    /**
     * Sets the minimum and maximum height of this biome. Seems to go from -2.0 to 2.0.
     */
    private BiomeBaseExtended b(float par1, float par2)
    {
        this.D = par1;
        this.E = par2;
        return this;
    }

    /**
     * Disable the rain for the biome.
     */
    private BiomeBaseExtended m()
    {
        this.T = false;
        return this;
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator a(Random par1Random)
    {
        return (WorldGenerator)(par1Random.nextInt(10) == 0 ? this.P : this.O);
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator b(Random par1Random)
    {
        return new WorldGenGrass(Block.GRASS.id, 1);
    }

    /**
     * sets enableSnow to true during biome initialization. returns BiomeBaseExtended.
     */
    protected BiomeBaseExtended b()
    {
        this.S = true;
        return this;
    }

    protected BiomeBaseExtended a(String par1Str)
    {
        this.y = par1Str;
        return this;
    }

    protected BiomeBaseExtended a(int par1)
    {
        this.C = par1;
        return this;
    }

    protected BiomeBaseExtended b(int par1)
    {
        this.z = par1;
        return this;
    }

    /**
     * Returns the correspondent list of the EnumCreatureType informed.
     */
    public List getMobs(EnumCreatureType par1EnumCreatureType)
    {
        return par1EnumCreatureType == EnumCreatureType.MONSTER ? this.J : (par1EnumCreatureType == EnumCreatureType.CREATURE ? this.K : (par1EnumCreatureType == EnumCreatureType.WATER_CREATURE ? this.L : (par1EnumCreatureType == EnumCreatureType.AMBIENT ? this.M : null)));
    }

    /**
     * Returns true if the biome have snowfall instead a normal rain.
     */
    public boolean c()
    {
        return this.S;
    }

    /**
     * Return true if the biome supports lightning bolt spawn, either by have the bolts enabled and have rain enabled.
     */
    public boolean d()
    {
        return this.S ? false : this.T;
    }

    /**
     * Checks to see if the rainfall level of the biome is extremely high
     */
    public boolean e()
    {
        return this.humidity > 0.85F;
    }

    /**
     * returns the chance a creature has to spawn.
     */
    public float f()
    {
        return 0.1F;
    }


    public void a(World par1World, Random par2Random, int par3, int par4)
    {
        this.I.a(par1World, par2Random, par3, par4);
    }
}
