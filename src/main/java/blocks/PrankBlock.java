package blocks;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class PrankBlock extends ModBlock 
{
	public PrankBlock() 
	{
		super(Material.ROCK, "prank_block");
		setUnlocalizedName("Prank Block");
		
		this.setCreativeTab(CreativeTabs.MATERIALS);
	}
}
