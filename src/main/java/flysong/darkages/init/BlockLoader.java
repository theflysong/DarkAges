package flysong.darkages.init;

import flysong.darkages.block.*;
import flysong.darkages.utils.BasicBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockLoader {
    public static final Block CrystalOre = new BlockCrystalOre();
    public static final Block CoreAltar = new BlockCoreAltar();
    public static final Block EnergyOre = new BasicBlock(Material.ROCK,"Energy_Ore","energyOre",CTLoader.DarkAgesBlock, SoundType.STONE,"pickaxe",3,10.5f).addIt();
    public static final Block EnergyBlock = new BasicBlock(Material.ROCK,"Energy_Block","energyBlock",CTLoader.DarkAgesBlock,SoundType.STONE,"pickaxe",3,50.5f).addIt();
}
