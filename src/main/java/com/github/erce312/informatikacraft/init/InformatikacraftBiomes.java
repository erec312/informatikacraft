package com.github.erce312.informatikacraft.init;



import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;

public class InformatikacraftBiomes 
{
	public static Biome muggy_forest_biome;
	
	public static void registerBiomes() 
	{
		registerBiome(muggy_forest_biome, Type.SWAMP);
	}
	
	public static void registerBiome(Biome biome, Type... types) 
	{
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
		
	}
}
