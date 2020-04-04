package flysong.darkages.utils;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;

public class BasicBlock extends Block {
    public BasicBlock(Material blockMaterialIn, MapColor blockMapColorIn) {
        super(blockMaterialIn, blockMapColorIn);
        Registry.BlockRegistryList.add(this);
        Registry.ItemBlockRegistryList.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    public BasicBlock(Material blockMaterialIn) {
        super(blockMaterialIn);
    }
}
