package flysong.darkages.capability;

import flysong.darkages.init.CapabilityLoader;
import flysong.darkages.interfaces.IEnergyBase;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class CapabilityPlayerEnergy {
    public static class Storage implements Capability.IStorage<IEnergyBase> {
        @Override
        public NBTBase writeNBT(Capability<IEnergyBase> capability, IEnergyBase instance, EnumFacing side) {
            return new NBTTagInt(instance.getEnergy());
        }

        @Override
        public void readNBT(Capability<IEnergyBase> capability, IEnergyBase instance, EnumFacing side, NBTBase nbt) {
            instance.setEnergy(((NBTTagInt)nbt).getInt());
        }
    }

    public static class PlayerEnergy implements IEnergyBase
    {
        private int energy=0;

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

    public static class ProviderPlayer implements ICapabilitySerializable<NBTTagCompound>
    {
        private IEnergyBase Energy = new PlayerEnergy();
        private Capability.IStorage<IEnergyBase> storage = CapabilityLoader.playerEnergy.getStorage();

        @Override
        public boolean hasCapability(Capability<?> capability, EnumFacing facing)
        {
            return CapabilityLoader.playerEnergy.equals(capability);
        }

        @Override
        public <T> T getCapability(Capability<T> capability, EnumFacing facing)
        {
            if (CapabilityLoader.playerEnergy.equals(capability))
            {
                @SuppressWarnings("unchecked")
                T result = (T) Energy;
                return result;
            }
            return null;
        }

        @Override
        public NBTTagCompound serializeNBT()
        {
            NBTTagCompound compound = new NBTTagCompound();
            compound.setTag("energy", storage.writeNBT(CapabilityLoader.playerEnergy, Energy, null));
            return compound;
        }

        @Override
        public void deserializeNBT(NBTTagCompound compound)
        {
            NBTBase energy = compound.getTag("energy");
            storage.readNBT(CapabilityLoader.playerEnergy, Energy, null, energy);
        }
    }
}