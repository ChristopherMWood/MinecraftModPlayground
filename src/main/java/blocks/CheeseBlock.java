package blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CheeseBlock extends ModBlock {
	//public static final PropertyEnum TYPE = PropertyEnum.create("type", );
	//public static final PropertyDirection FACING = PropertyDirection.create("facing");
    public static final PropertyBool MOLDY = PropertyBool.create("moldy");
	
    public CheeseBlock()
    {
        super(Material.CLAY, "cheese_block");
		setCreativeTab(CreativeTabs.MATERIALS);
		
		//This is the default state that any block will begin with when rendered
		this.setDefaultState(this.blockState.getBaseState().withProperty(MOLDY, Boolean.valueOf(false)));
    }
    
    @Override
    protected BlockStateContainer createBlockState()
    {
    	return new BlockStateContainer(this, new IProperty[] { MOLDY });
    }
   
    @Override
    public void onBlockDestroyedByPlayer(World world, BlockPos position, IBlockState state)
    {
    	//EntityItem cheese = new EntityItem(world, position.getX(), position.getY(), position.getZ());
    	//world.spawnEntity
    }
    
    @Override
    public int getMetaFromState(IBlockState state)
    {
    	if (state.getValue(MOLDY))
    		return 1;
    	else
    		return 0;
    }
    
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
    	if (meta == 1)
    		return getDefaultState().withProperty(MOLDY, true);
    	else
    		return getDefaultState().withProperty(MOLDY, false);
    }
    
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
    	world.setBlockState(pos, state.withProperty(MOLDY, Boolean.valueOf(true)));
    	
		return false;
    }
}
