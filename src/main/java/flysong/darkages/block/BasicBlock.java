package flysong.darkages.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BasicBlock extends Block {
    public BasicBlock(Material material,SoundType soundType)
    {
        super(material);
        this.setSoundType(soundType);
    }

    public BasicBlock setDigLevel(String toolClass,int Level)
    {
        setHarvestLevel(toolClass,Level);
        return this;
    }

    public BasicBlock setDigLevel(String toolClass, int Level, IBlockState state)
    {
        setHarvestLevel(toolClass,Level,state);
        return this;
    }
}
