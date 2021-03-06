package flysong.darkages.block;

import flysong.darkages.block.tileEntity.TileEntityEnergyAlternator;
import flysong.darkages.block.tileEntity.TileEntityEnergyMachine;
import flysong.darkages.init.CTLoader;
import flysong.darkages.utils.BasicBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockEnergyAlternator extends BasicBlock {
    public BlockEnergyAlternator() {
        super(Material.ROCK,"energyAlternator","Energy_Alternator",CTLoader.DarkAgesBlock,SoundType.STONE);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BURNING, Boolean.FALSE));
        this.setHardness(50.5F);
        this.setHarvestLevel("pickaxe", 3);
        addIt();
    }

    @Override
    public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos) {
        if(state.getProperties().get("burning").equals(Boolean.TRUE))
        {
            return 2;
        }
        return 0;
    }

    public static final PropertyBool BURNING = PropertyBool.create("burning");

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this,BURNING);
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        Boolean burning = Boolean.valueOf((meta & 4) != 0);
        return this.getDefaultState().withProperty(BURNING, burning);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        int burning = state.getValue(BURNING).booleanValue() ? 4 : 0;
        return burning;
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileEntityEnergyAlternator();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(!TileEntityEnergyMachine.ItemEnergy.containsKey(playerIn.getHeldItem(hand).getItem().getRegistryName().getResourcePath()))
        {
            return false;
        }
        TileEntity tileEntity = worldIn.getTileEntity(pos);
        if(tileEntity instanceof TileEntityEnergyAlternator)
        {
            ((TileEntityEnergyAlternator) tileEntity).addFuel(TileEntityEnergyMachine.ItemEnergy.get(playerIn.getHeldItem(hand).getItem().getRegistryName().getResourcePath()));
            return true;
        }
        else
        {
            return false;
        }
    }
}
