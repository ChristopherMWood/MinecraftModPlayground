package registrators;

import items.ModItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ItemRegistrator
{
	public static ModItem ingotCopper = new ModItem("ingot_copper").setCreativeTab(CreativeTabs.MATERIALS); 
	
	public static void register(IForgeRegistry<Item> registry) 
	{
		registry.registerAll(ingotCopper);
	}
	
	public static void registerModels() 
	{
		ingotCopper.registerItemModel();
	}
}