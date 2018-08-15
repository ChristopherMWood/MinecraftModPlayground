package blocks;

import items.CheeseItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CheeseBlock extends ModBlock {
	//public static final PropertyEnum TYPE = PropertyEnum.create("type", );
	//public static final PropertyDirection FACING = PropertyDirection.create("facing");
    public static final PropertyBool MOLDY = PropertyBool.create("moldy");
    private boolean moldy = false;
	
    public CheeseBlock()
    {
        super(Material.CLAY, "cheese_block");
		setCreativeTab(CreativeTabs.MATERIALS);
		
		this.setDefaultState(this.blockState.getBaseState().withProperty(MOLDY, Boolean.valueOf(false)));
    }
   
    @Override
    public void onBlockDestroyedByPlayer(World world, BlockPos position, IBlockState state)
    {
    	CheeseItem cheese = new CheeseItem();
    	ItemStack cheeseStack = new ItemStack(cheese, 1);
    	EntityItem item = new EntityItem(world, position.getX(), position.getY(), position.getZ(), cheeseStack);
    	world.spawnEntity(item);
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
    	moldy = true;
    	
		return true;
    }
    
    @Override
    protected BlockStateContainer createBlockState()
    {
    	return new BlockStateContainer(this, new IProperty[] { MOLDY });
    }
    
    @Override
    public int getMetaFromState(IBlockState state)
    {
    	return 0;
    }
    
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
    	return getDefaultState().withProperty(MOLDY, moldy);
    }
}
