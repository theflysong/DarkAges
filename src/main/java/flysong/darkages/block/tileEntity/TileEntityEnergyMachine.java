package flysong.darkages.block.tileEntity;

import flysong.darkages.interfaces.IEnergyBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import java.util.HashMap;

public class TileEntityEnergyMachine extends TileEntity implements IEnergyBase {
    public static HashMap<String, Integer> ItemEnergy = new HashMap();
    private int energy;

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setInteger("energy",energy);
        return super.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        energy = compound.getInteger("energy");
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public void addEnergy(int num) {
        energy+=num;
    }

    @Override
    public void resetEnergy() {
        energy=0;
    }

    @Override
    public void subEnergy(int num) {
        energy-=num;
    }

    @Override
    public void setEnergy(int num) {
        energy=num;
    }
}
