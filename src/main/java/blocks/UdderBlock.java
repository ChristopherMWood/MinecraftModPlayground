package blocks;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class UdderBlock extends ModBlock
{
    public UdderBlock()
    {
        super(Material.CAKE, "utterblock");
        
		setCreativeTab(CreativeTabs.MATERIALS);
    }
}
