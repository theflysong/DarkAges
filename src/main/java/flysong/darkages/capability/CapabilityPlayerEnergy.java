package flysong.darkages.capability;

import flysong.darkages.init.CapabilityLoader;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class CapabilityPlayerEnergy {
    public static class Storage implements Capability.IStorage<IPlayerEnergy> {
        @Override
        public NBTBase writeNBT(Capability<IPlayerEnergy> capability, IPlayerEnergy instance, EnumFacing side) {
            return new NBTTagInt(instance.getPlayerEnergy());
        }

        @Override
        public void readNBT(Capability<IPlayerEnergy> capability, IPlayerEnergy instance, EnumFacing side, NBTBase nbt) {
            instance.setPlayerEnergy(((NBTTagInt)nbt).getInt());
        }
    }

    public static class PlayerEnergy implements IPlayerEnergy
    {
        private int energy=0;

        @Override
        public int getPlayerEnergy() {
            return energy;
        }

        @Override
        public void addPlayerEnergy(int num) {
            energy+=num;
        }

        @Override
        public void resetPlayerEnergy() {
            energy=0;
        }

        @Override
        public void subPlayerEnergy(int num) {
            energy-=num;
        }

        @Override
        public void setPlayerEnergy(int num) {
            energy=num;
        }
    }

    public static class ProviderPlayer implements ICapabilitySerializable<NBTTagCompound>
    {
        private IPlayerEnergy Energy = new PlayerEnergy();
        private Capability.IStorage<IPlayerEnergy> storage = CapabilityLoader.playerEnergy.getStorage();

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
            compound.setTag("Energy", storage.writeNBT(CapabilityLoader.playerEnergy, Energy, null));
            return compound;
        }

        @Override
        public void deserializeNBT(NBTTagCompound compound)
        {
            NBTBase energy = compound.getTag("Energy");
            storage.readNBT(CapabilityLoader.playerEnergy, Energy, null, energy);
        }
    }
}