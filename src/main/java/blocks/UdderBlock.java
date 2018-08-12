package blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class UdderBlock extends ModBlock
{
	//public static final PropertyEnum TYPE = PropertyEnum.create("type", );
	//public static final PropertyDirection FACING = PropertyDirection.create("facing");
    public static final PropertyBool MOSSY = PropertyBool.create("mossy");
	
    public UdderBlock()
    {
        super(Material.CAKE, "udder_block");
        
		setCreativeTab(CreativeTabs.MATERIALS);
		
		//This is the default state that any block will begin with when rendered
		this.setDefaultState(this.blockState.getBaseState().withProperty(MOSSY, Boolean.valueOf(false)));
    }
    
    @Override
    protected BlockStateContainer createBlockState()
    {
    	return new BlockStateContainer(this, new IProperty[] { MOSSY });
    }
   
    
    @Override
    public int getMetaFromState(IBlockState state)
    {
    	if (state.getValue(MOSSY))
    		return 1;
    	else
    		return 0;
    }
    
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
    	if (meta == 1)
    		return getDefaultState().withProperty(MOSSY, true);
    	else
    		return getDefaultState().withProperty(MOSSY, false);
    }
    
//    @Override
//    public void getSubBlocks()
    
    @Override
    public boolean onBlockActivated(World world,
            BlockPos pos,
            IBlockState state,
            EntityPlayer player,
            EnumHand hand,
            EnumFacing side,
            float hitX,
            float hitY,
            float hitZ)
    {
    	world.setBlockState(pos, state.withProperty(MOSSY, Boolean.valueOf(true)));
    	
		return false;
    }
}
