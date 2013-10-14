package com.khorn.terraincontrol.bukkit;

import com.khorn.terraincontrol.MobAlternativeNames;
import com.khorn.terraincontrol.TerrainControl;
import com.khorn.terraincontrol.configuration.BiomeConfig;
import com.khorn.terraincontrol.configuration.WeightedMobSpawnGroup;

import net.minecraft.server.v1_6_R3.*;

import org.bukkit.block.Biome;
import org.bukkit.craftbukkit.v1_6_R3.block.CraftBlock;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

public class CustomBiome extends BiomeBaseExtended
{
    //public static final BiomeBase[] biomes = new BiomeBase[512];
    //public final int id;
    @SuppressWarnings("MismatchedReadAndWriteOfArray")
    public CustomBiome(int id, String name)
    {
        super(id);

//		try {
//			Field biomeField = BiomeBase.class.getDeclaredField("biomes");
//			if(biomes.length < 512)
//			{
//				//biomes 
//				biomeField.setAccessible(true);
//				biomeField.set
//				biomeField.set(this, (BiomeBase[])Array.newInstance(BiomeBase.class,512));
//				//biomes = (BiomeBase[])Array.newInstance(BiomeBase.class, 512);//biomeField.set(this, new BiomeBase[512]);
//				biomes[id] = this;
//			}
//		} catch (SecurityException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (NoSuchFieldException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NegativeArraySizeException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        //protected BiomeBase(int i) {
//            this.A = (byte) Block.GRASS.id;
//            this.B = (byte) Block.DIRT.id;
//            this.C = 5169201;
//            this.D = 0.1F;
//            this.E = 0.3F;
//            this.temperature = 0.5F;
//            this.humidity = 0.5F;
//            this.H = 16777215;
//            this.J = new ArrayList();
//            this.K = new ArrayList();
//            this.L = new ArrayList();
//            this.M = new ArrayList();
//            //this.T = true;
//            this.O = new WorldGenTrees(false);
//            this.P = new WorldGenBigTree(false);
//            this.Q = new WorldGenForest(false);
//            this.R = new WorldGenSwampTree();
//            this.id = id;
           // biomes[id] = this;
            //this.id = id;
//            this.I = this.a();
//            this.K.add(new BiomeMeta(EntitySheep.class, 12, 4, 4));
//            this.K.add(new BiomeMeta(EntityPig.class, 10, 4, 4));
//            this.K.add(new BiomeMeta(EntityChicken.class, 10, 4, 4));
//            this.K.add(new BiomeMeta(EntityCow.class, 8, 4, 4));
//            this.J.add(new BiomeMeta(EntitySpider.class, 10, 4, 4));
//            this.J.add(new BiomeMeta(EntityZombie.class, 10, 4, 4));
//            this.J.add(new BiomeMeta(EntitySkeleton.class, 10, 4, 4));
//            this.J.add(new BiomeMeta(EntityCreeper.class, 10, 4, 4));
//            this.J.add(new BiomeMeta(EntitySlime.class, 10, 4, 4));
//            this.J.add(new BiomeMeta(EntityEnderman.class, 1, 1, 4));
//            this.L.add(new BiomeMeta(EntitySquid.class, 10, 4, 4));
//            this.M.add(new BiomeMeta(EntityBat.class, 10, 8, 8));
//        //}
        this.a(name);
    	//this.biomes = new BiomeBase[512];

        // Insert the biome in CraftBukkit's biome mapping
        try
        {
            Field biomeMapping = CraftBlock.class.getDeclaredField("BIOME_MAPPING");
            biomeMapping.setAccessible(true);
            Biome[] mappingArray = (Biome[]) biomeMapping.get(null);

            if(id >= 256)
            	mappingArray[255] = Biome.OCEAN;
            else
            	mappingArray[id] = Biome.OCEAN;

        } catch (Exception e)
        {
            TerrainControl.log(Level.SEVERE, "Couldn't update Bukkit's biome mappings!");
            TerrainControl.log(Level.SEVERE, e.getStackTrace().toString());
        }
    }

    @SuppressWarnings("unchecked")
    public void setEffects(BiomeConfig config)
    {
        this.D = config.BiomeHeight;
        this.E = config.BiomeVolatility;
        this.A = (byte) config.SurfaceBlock;
        this.B = (byte) config.GroundBlock;
        this.temperature = config.BiomeTemperature;
        this.humidity = config.BiomeWetness;
        if (this.humidity == 0)
        {
            this.b(); // this.disableRain()
        }

        // Mob spawning
        addMobs(this.J, config.spawnMonstersAddDefaults, config.spawnMonsters);
        addMobs(this.K, config.spawnCreaturesAddDefaults, config.spawnCreatures);
        addMobs(this.L, config.spawnWaterCreaturesAddDefaults, config.spawnWaterCreatures);
        addMobs(this.M, config.spawnAmbientCreaturesAddDefaults, config.spawnAmbientCreatures);
    }

    // Adds the mobs to the internal list. Displays a warning for each mob type it doesn't understand
    protected void addMobs(List<BiomeMeta> internalList, boolean addDefaults, List<WeightedMobSpawnGroup> configList)
    {
        if (!addDefaults)
        {
            internalList.clear();
        }
        for (WeightedMobSpawnGroup mobGroup : configList)
        {
            Class<? extends Entity> entityClass = getEntityClass(mobGroup);
            if (entityClass != null)
            {
                internalList.add(new BiomeMeta(entityClass, mobGroup.getWeight(), mobGroup.getMin(), mobGroup.getMax()));
            } else
            {
                // The .toLowerCase() is just a safeguard so that we get notified if this.y is no longer the biome name
                TerrainControl.log(Level.WARNING, "Mob type {0} not found in {1}", new Object[]{mobGroup.getMobName(), this.y.toLowerCase()});
            }
        }
    }

    // Gets the class of the entity.
    @SuppressWarnings("unchecked")
    protected Class<? extends Entity> getEntityClass(WeightedMobSpawnGroup mobGroup)
    {
        String mobName = MobAlternativeNames.getInternalMinecraftName(mobGroup.getMobName());
        try
        {
            Field entitiesField = EntityTypes.class.getDeclaredField("b");
            entitiesField.setAccessible(true);
            Map<String, Class<? extends Entity>> entitiesList = (Map<String, Class<? extends Entity>>) entitiesField.get(null);
            return entitiesList.get(mobName);
        } catch (Exception e)
        {
            TerrainControl.log(Level.SEVERE, "Someone forgot to update the mob spawning code! Please report!");
            TerrainControl.log(Level.SEVERE, e.getStackTrace().toString());
            return null;
        }
    }
}
