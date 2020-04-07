package flysong.darkages.block;

import flysong.darkages.init.CTLoader;
import flysong.darkages.init.ItemLoader;
import flysong.darkages.utils.BasicBlock;
import net.minecraft.block.BlockRedstoneComparator;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;



public class BlockCrystalOre extends BasicBlock {
    public BlockCrystalOre()
    {
        super(Material.ROCK, "Crystal_Ore","crystalOre",CTLoader.DarkAgesBlock,SoundType.STONE,"pickaxe",2,10.5f);
        addIt();
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return ItemLoader.UnfiredCrystal;
    }

    @Override
    public int quantityDropped(Random random) {
        return 1;
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random random) {
        if(fortune>0)
        {
            return this.quantityDropped(random)*(random.nextInt(fortune)+fortune+1);
        }
        else
        {
            return this.quantityDropped(random);
        }
    }

    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
        Random random = world instanceof World ? ((World) world).rand : new Random();
        int num1=random.nextInt(7)+3;
        int num2=random.nextInt(19)+8;
        return random.nextInt(num1+num2)+7;
    }
}
