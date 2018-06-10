package com.example.examplemod;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class UdderBlock extends ModBlock
{
    public UdderBlock()
    {
        super(Material.CAKE, "udder_block");
		
		this.setCreativeTab(CreativeTabs.MATERIALS);
    }
}
