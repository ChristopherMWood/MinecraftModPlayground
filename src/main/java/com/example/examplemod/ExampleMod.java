package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import proxies.CommonProxy;
import registrators.BlockRegistrator;
import registrators.ItemRegistrator;

@Mod(modid = ExampleMod.modId, name = ExampleMod.name, version = ExampleMod.version)
public class ExampleMod 
{
	public static final String modId = "examplemod";
	public static final String name = "Example Mod";
	public static final String version = "1.0.0";
	
	@SidedProxy(serverSide = "proxies.CommonProxy", clientSide = "proxies.ClientProxy")
	public static CommonProxy proxy;

	@Mod.Instance(modId)
	public static ExampleMod instance;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println(name + " is loading!");
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}

	@Mod.EventBusSubscriber
	public static class RegistrationHandler 
	{
		@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> event)
		{
			ItemRegistrator.register(event.getRegistry());
		}
		
		@SubscribeEvent
		public static void registerBlocks(RegistryEvent.Register<Block> event)
		{
			BlockRegistrator.register(event.getRegistry());
		}
		
		@SubscribeEvent
		public static void registerModels(ModelRegistryEvent event) {
			ItemRegistrator.registerModels();
			BlockRegistrator.registerModels();
		}
	}
}
