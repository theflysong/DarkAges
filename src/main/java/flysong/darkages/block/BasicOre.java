package flysong.darkages.block;

import flysong.darkages.init.ItemLoader;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BasicOre extends BasicBlock {
    private Item ItemDropped;
    private int num;
    private int ExpMin;
    private int ExpMax;

    public BasicOre(Material material,SoundType soundType)
    {
        super(material,soundType);
    }

    public BasicOre setItemDropped(Item ItemDropped,int num,int ExpMin,int ExpMax)
    {
        this.ItemDropped=ItemDropped;
        this.num=num;
        this.ExpMax=ExpMax;
        this.ExpMin=ExpMin;
        return this;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return ItemDropped;
    }

    @Override
    public int quantityDropped(Random random) {
        return num;
    }

    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
        Random random = world instanceof World ? ((World) world).rand : new Random();
        return MathHelper.getInt(random, ExpMin, ExpMax);
    }
}
