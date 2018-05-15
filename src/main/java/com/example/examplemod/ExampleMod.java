package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = ExampleMod.MODID, name = ExampleMod.NAME, version = ExampleMod.VERSION)
public class ExampleMod
{
    @SidedProxy(serverSide = "com.example.examplemod.CommonProxy", clientSide = "com.example.examplemod.ClientProxy")
    public static CommonProxy proxy;
    public static final String MODID = "examplemod";
    public static final String NAME = "Example Mod";
    public static final String VERSION = "1.0";

	@Mod.Instance(MODID)
	public static ExampleMod instance;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{
		System.out.println(NAME + " is loading!");
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) 
	{
		
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) 
	{

	}
	
	@Mod.EventBusSubscriber
	public static class RegistrationHandler 
	{
		public static UdderBlock udderBlock = new UdderBlock().setCreativeTab(CreativeTabs.MATERIALS);
		
		@SubscribeEvent
		public static void registerBlocks(RegistryEvent.Register<Block> event) 
		{
			event.getRegistry().registerAll
			(
				udderBlock
			);
		}
		
		@SubscribeEvent
		public static void registerModels(ModelRegistryEvent event) 
		{
			udderBlock.registerItemModel(Item.getItemFromBlock(udderBlock));
		}
	}
}
