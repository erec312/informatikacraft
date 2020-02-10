package com.github.erce312.informatikacraft.world;

import com.github.erce312.informatikacraft.init.InformatikacraftBiomes;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.provider.SingleBiomeProvider;
import net.minecraft.world.biome.provider.SingleBiomeProviderSettings;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.OverworldChunkGenerator;
import net.minecraft.world.gen.OverworldGenSettings;

public class MuggyWorldType extends WorldType
{

	public MuggyWorldType() 
	{
		super("MuggyType");
	}
	
	@Override
	public ChunkGenerator<?> createChunkGenerator(World world) 
	{
		OverworldGenSettings settings = new OverworldGenSettings();
		SingleBiomeProviderSettings single = new SingleBiomeProviderSettings();
		single.setBiome(InformatikacraftBiomes.muggy_forest_biome);
		return new OverworldChunkGenerator(world, new SingleBiomeProvider(single), settings);
	}
}
