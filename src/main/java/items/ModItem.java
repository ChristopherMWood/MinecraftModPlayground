package items;

import com.example.examplemod.ExampleMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModItem extends Item
{
	protected String name;

	public ModItem(String name) 
	{
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
	}
	
	public void registerItemModel() 
	{
		ExampleMod.proxy.registerItemRenderer(this, 0, name);
	}
	
	@Override
	public ModItem setCreativeTab(CreativeTabs tab) 
	{
		super.setCreativeTab(tab);
		return this;
	}
}
