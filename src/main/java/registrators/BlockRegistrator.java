package registrators;

import blocks.PrankBlock;
import blocks.UdderBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class BlockRegistrator 
{
	public static UdderBlock udderBlock = new UdderBlock();
	public static PrankBlock prankBlock = new PrankBlock();
	
	public static void register(IForgeRegistry<Block> registry) 
	{
		registry.registerAll(udderBlock, prankBlock);
	}
	
	public static void registerItemBlocks(IForgeRegistry<Item> registry) 
	{
		registry.registerAll(
			udderBlock.createItemBlock(),
			prankBlock.createItemBlock()
		);
	}
	
	public static void registerModels() 
	{
		udderBlock.registerItemModel(Item.getItemFromBlock(udderBlock));
		prankBlock.registerItemModel(Item.getItemFromBlock(prankBlock));
	}

}
