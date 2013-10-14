package com.khorn.terraincontrol.bukkit;

import com.khorn.terraincontrol.DefaultBiome;
import com.khorn.terraincontrol.LocalBiome;
import com.khorn.terraincontrol.configuration.BiomeConfig;
import net.minecraft.server.v1_6_R3.BiomeBase;

/**
 * The BukkitBiome is basically a wrapper for the BiomeBase.
 * If you look at the constructor and the method you will see that this is the case.
 */
public class BukkitBiome implements LocalBiome
{
    private BiomeBase biomeBase;
    private boolean isCustom;
    private int customID;

    private float temperature;
    private float humidity;

    public BukkitBiome(BiomeBase biome)
    {
        this.biomeBase = biome;
        if(biomeBase instanceof BiomeBaseExtended)
        {
        	customID = ((BiomeBaseExtended)biomeBase).id;
        }
        else
        {
        	customID = biomeBase.id;
        }
        if (DefaultBiome.getBiome(customID) == null)
        {
            this.isCustom = true;
        }

        this.temperature = biome.temperature;
        this.humidity = biome.humidity;
    }

    @Override
    public boolean isCustom()
    {
        return this.isCustom;
    }

    @Override
    public int getCustomId()
    {
        return customID;
    }

    public void setCustomID(int id)
    {
        customID = id;
    }

    public BiomeBase getHandle()
    {
        return biomeBase;
    }

    @Override
    public void setEffects(BiomeConfig config)
    {
        ((CustomBiome) this.biomeBase).setEffects(config);
    }

    @Override
    public String getName()
    {
        if(biomeBase instanceof BiomeBaseExtended)
        {
        	return ((BiomeBaseExtended)biomeBase).y;
        }
        else
        {
        	return biomeBase.y;
        }
    }

    @Override
    public int getId()
    {
        if(biomeBase instanceof BiomeBaseExtended)
        {
        	return ((BiomeBaseExtended)biomeBase).id;
        }
        else
        {
        	return biomeBase.id;
        }
    }

    @Override
    public float getTemperature()
    {
        return this.temperature;
    }

    @Override
    public float getWetness()
    {
        return this.humidity;
    }

    @Override
    public float getSurfaceHeight()
    {
        if(biomeBase instanceof BiomeBaseExtended)
        {
        	return ((BiomeBaseExtended)biomeBase).D;
        }
        else
        {
        	return biomeBase.D;
        }
    }

    @Override
    public float getSurfaceVolatility()
    {
        if(biomeBase instanceof BiomeBaseExtended)
        {
        	return ((BiomeBaseExtended)biomeBase).E;
        }
        else
        {
        	return biomeBase.E;
        }
    }

    @Override
    public byte getSurfaceBlock()
    {
        if(biomeBase instanceof BiomeBaseExtended)
        {
        	return ((BiomeBaseExtended)biomeBase).A;
        }
        else
        {
        	return biomeBase.A;
        }
    }

    @Override
    public byte getGroundBlock()
    {
        if(biomeBase instanceof BiomeBaseExtended)
        {
        	return ((BiomeBaseExtended)biomeBase).B;
        }
        else
        {
        	return biomeBase.B;
        }
    }
}