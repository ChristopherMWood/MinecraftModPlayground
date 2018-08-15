package items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CheeseItem extends ModItem {

	public CheeseItem() {
		super("cheese_item");
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		player.heal(4);
		ItemStack currentItem = player.getHeldItem(hand);
		player.inventory.deleteStack(currentItem);
		
	    return EnumActionResult.SUCCESS;
	}
}
