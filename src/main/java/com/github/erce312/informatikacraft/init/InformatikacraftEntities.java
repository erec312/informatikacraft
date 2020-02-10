package com.github.erce312.informatikacraft.init;

import com.github.erce312.informatikacraft.Informatikacraft;
import com.github.erce312.informatikacraft.Informatikacraft.RegistryEvents;
import com.github.erce312.informatikacraft.entities.Reaper;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.event.RegistryEvent;

public class InformatikacraftEntities 
{
	public static EntityType<?> REAPER = EntityType.Builder.create(Reaper::new, EntityClassification.MONSTER).build(Informatikacraft.MODID + ":reaper").setRegistryName(RegistryEvents.location("reaper"));
	
	public static void registerEntitySpawnEggs(final RegistryEvent.Register<Item> event) 
	{
		event.getRegistry().registerAll
		(
				InformatikacraftItems.reaper_egg = registerEntitySpawnEgg(REAPER, 0x000000, 0xfdff8c, "reaper_egg")
		);
	}
	
	public static void registerEntityWorldSpawns()
	{
		registerEntityWorldSpawn(REAPER, Biomes.PLAINS, InformatikacraftBiomes.muggy_forest_biome);
	}
	
	public static Item registerEntitySpawnEgg(EntityType<?> type, int color1, int color2, String name) 
	{
		SpawnEggItem item = new SpawnEggItem(type, color1, color2, new Item.Properties().group(ItemGroup.MISC));
		item.setRegistryName(RegistryEvents.location(name));
		return item;
	}
	
	public static void registerEntityWorldSpawn(EntityType<?> entity, Biome...biomes) 
	{
		for(Biome biome : biomes)
		{
			if(biome != null) 
			{
				biome.getSpawns(entity.getClassification()).add(new SpawnListEntry(entity, 10, 1, 3));
			}
		}
	}

}

