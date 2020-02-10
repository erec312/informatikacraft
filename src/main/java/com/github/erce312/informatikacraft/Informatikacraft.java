package com.github.erce312.informatikacraft;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.erce312.informatikacraft.client.renders.InformatikacraftRenderRegistry;
import com.github.erce312.informatikacraft.config.Config;
import com.github.erce312.informatikacraft.init.InformatikacraftArmorMaterials;
import com.github.erce312.informatikacraft.init.InformatikacraftBiomes;
import com.github.erce312.informatikacraft.init.InformatikacraftBlocks;
import com.github.erce312.informatikacraft.init.InformatikacraftEntities;
import com.github.erce312.informatikacraft.init.InformatikacraftItems;
import com.github.erce312.informatikacraft.init.InformatikacraftToolMaterials;
import com.github.erce312.informatikacraft.itmes.CustomAxeItem;
import com.github.erce312.informatikacraft.itmes.CustomBowItem;
import com.github.erce312.informatikacraft.itmes.CustomPickaxeItem;
import com.github.erce312.informatikacraft.world.MuggyWorldType;
import com.github.erce312.informatikacraft.world.OreGeneration;
import com.github.erce312.informatikacraft.world.biomes.InformatikacraftBiome;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod("informatikacraft")
public class Informatikacraft 
{
	public static Informatikacraft instance;
	public static final String MODID = "informatikacraft";
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	public static final WorldType MUGGY_TYPE = new MuggyWorldType();

	public Informatikacraft() 
	{
		instance = this;
		
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER, "informatikacraft-server.toml");
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT, "informatikacraft-client.toml");

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		Config.loadConfig(Config.CLIENT, FMLPaths.CONFIGDIR.get().resolve("informatikacraft-client.toml").toString());
		Config.loadConfig(Config.SERVER, FMLPaths.CONFIGDIR.get().resolve("informatikacraft-server.toml").toString());
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event)
	{
		OreGeneration.setupOreGeneration();
		
		LOGGER.info("Setup method registered.");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event)
	{
		InformatikacraftRenderRegistry.registryEntityRenders();
		LOGGER.info("clientRegistries method registered.");
	}
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents 
	{
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) 
		{
			event.getRegistry().registerAll
			(
				//ITEMS
				InformatikacraftItems.amethyst = new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(location("amethyst")),
				//TOOLS
				InformatikacraftItems.amethyst_axe = new CustomAxeItem(InformatikacraftToolMaterials.amethyst, 5.0f, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("amethyst_axe")),
				InformatikacraftItems.amethyst_pickaxe = new CustomPickaxeItem(InformatikacraftToolMaterials.amethyst, 1, -2.8f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("amethyst_pickaxe")),
				InformatikacraftItems.amethyst_hoe = new HoeItem(InformatikacraftToolMaterials.amethyst, 0.0f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("amethyst_hoe")),
				InformatikacraftItems.amethyst_shovel = new ShovelItem(InformatikacraftToolMaterials.amethyst, 1.5f, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("amethyst_shovel")),
				InformatikacraftItems.amethyst_sword = new SwordItem(InformatikacraftToolMaterials.amethyst, 3, -2.4f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("amethyst_sword")),
				InformatikacraftItems.amethyst_bow = new CustomBowItem(new Item.Properties().defaultMaxDamage(1000).group(ItemGroup.TOOLS)).setRegistryName(location("amethyst_bow")),
				//ARMOUR
				InformatikacraftItems.amethyst_helmet = new ArmorItem(InformatikacraftArmorMaterials.amethyst, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("amethyst_helmet")),
				InformatikacraftItems.amethyst_chestplate = new ArmorItem(InformatikacraftArmorMaterials.amethyst, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("amethyst_chestplate")),
				InformatikacraftItems.amethyst_leggings = new ArmorItem(InformatikacraftArmorMaterials.amethyst, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("amethyst_leggings")),
				InformatikacraftItems.amethyst_boots = new ArmorItem(InformatikacraftArmorMaterials.amethyst, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("amethyst_boots")),
				//BLOCKS
				InformatikacraftItems.amethyst_block = new BlockItem(InformatikacraftBlocks.amethyst_block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(location("amethyst_block")),
				InformatikacraftItems.amethyst_ore = new BlockItem(InformatikacraftBlocks.amethyst_ore, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(location("amethyst_ore"))
			);
			
			InformatikacraftEntities.registerEntitySpawnEggs(event);
			
			LOGGER.info("Itmes registered");
		}
		

		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) 
		{
			event.getRegistry().registerAll
			(
				InformatikacraftBlocks.amethyst_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 10.0f).sound(SoundType.STONE)).setRegistryName(location("amethyst_ore")),
				InformatikacraftBlocks.amethyst_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 10.0f).sound(SoundType.METAL)).setRegistryName(location("amethyst_block"))
			);
			LOGGER.info("Blocks registered");
		}
		
		@SubscribeEvent
		public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) 
		{
			event.getRegistry().registerAll
			(
					InformatikacraftEntities.REAPER
			);
			
			InformatikacraftEntities.registerEntityWorldSpawns();
		}
		
		@SubscribeEvent
		public static void registerBiomes(final RegistryEvent.Register<Biome> event) 
		{
			event.getRegistry().registerAll
			(
					InformatikacraftBiomes.muggy_forest_biome = new InformatikacraftBiome()
			);
			InformatikacraftBiomes.registerBiomes();
		}

		
		public static ResourceLocation location(String name) 
		{
			return new ResourceLocation(MODID, name);
		}
		
	}

}



