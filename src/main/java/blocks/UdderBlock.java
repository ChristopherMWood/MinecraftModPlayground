package blocks;

import javax.annotation.Nullable;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.sound.SoundEvent;

public class UdderBlock extends ModBlock
{
    public UdderBlock()
    {
        super(Material.CAKE, "udder_block");
        
		setCreativeTab(CreativeTabs.MATERIALS);
    }
    
    public boolean onBlockActivated(World worldIn,
            BlockPos pos,
            IBlockState state,
            EntityPlayer playerIn,
            EnumHand hand,
            @Nullable ItemStack heldItem,
            EnumFacing side,
            float hitX,
            float hitY,
            float hitZ)
    {
    	playerIn.jump();
    	playerIn.performHurtAnimation();
		return true;
    }
}
