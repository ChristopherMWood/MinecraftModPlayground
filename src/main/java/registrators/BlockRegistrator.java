package registrators;

import blocks.UdderBlock;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class BlockRegistrator 
{
	public static UdderBlock udderBlock = new UdderBlock().setCreativeTab(CreativeTabs.MATERIALS);
	
	public static void register(IForgeRegistry<Block> registry) {
		registry.registerAll(
				udderBlock
		);
	}
	
	public static void registerItemBlocks(IForgeRegistry<Item> registry) {
		registry.registerAll(
				udderBlock.createItemBlock()
		);
	}
	
	public static void registerModels() {
		udderBlock.registerItemModel(Item.getItemFromBlock(udderBlock));
	}

}
