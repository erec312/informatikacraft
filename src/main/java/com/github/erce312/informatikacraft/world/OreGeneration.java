
package com.github.erce312.informatikacraft.world;

import com.github.erce312.informatikacraft.config.OregenConfig;
import com.github.erce312.informatikacraft.init.InformatikacraftBlocks;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGeneration 
{
	public static void setupOreGeneration()
	{
			for(Biome biome : ForgeRegistries.BIOMES)
			{				
				biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, InformatikacraftBlocks.amethyst_ore.getDefaultState(), OregenConfig.informatikacraft_chance.get()), Placement.COUNT_RANGE, new CountRangeConfig(8,1,0,16)));
				
			}
		}
	}
