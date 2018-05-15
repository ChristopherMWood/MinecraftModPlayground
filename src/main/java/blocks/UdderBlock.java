package blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class UdderBlock extends ModBlock
{
    public UdderBlock()
    {
        super(Material.CAKE, "utterblock");
        
        this.setSoundType(SoundType.CLOTH);
		setHardness(300000f);
		setResistance(500000f);
    }
    
	@Override
	public UdderBlock setCreativeTab(CreativeTabs tab) 
	{
		super.setCreativeTab(tab);
		return this;
	}
}
