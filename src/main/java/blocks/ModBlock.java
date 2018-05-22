package blocks;

import javax.annotation.Nullable;

import com.example.examplemod.ExampleMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class ModBlock extends Block {

	protected String name;

	public ModBlock(Material material, String name) {
		super(material);
	
		this.name = name;
	
		setUnlocalizedName(name);
		setRegistryName(name);
	}
	
	@Override
    public boolean onBlockActivated(World worldIn,
            BlockPos pos,
            IBlockState state,
            EntityPlayer playerIn,
            EnumHand hand,
            EnumFacing side,
            float hitX,
            float hitY,
            float hitZ)
    {
    	playerIn.jump();
    	playerIn.performHurtAnimation();
    	Explosion explosion = worldIn.createExplosion(playerIn, playerIn.posX, playerIn.posY, playerIn.posZ, 100.0f, true);
    	explosion.doExplosionA();
		return true;
    }
	
	public void registerItemModel(Item itemBlock) {
		ExampleMod.proxy.registerItemRenderer(itemBlock, 0, name);
	}
	
	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}
	
	@Override
	public ModBlock setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}

}