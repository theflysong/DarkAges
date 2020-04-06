package flysong.darkages.item;

import flysong.darkages.block.tileEntity.TileEntityEnergyMachine;
import flysong.darkages.utils.BasicItem;

import static flysong.darkages.init.CTLoader.DarkAgesMater;

public class ItemEnergyIngot extends BasicItem {
    public ItemEnergyIngot()
    {
        super("Energy_Ingot","energyIngot",DarkAgesMater);
        TileEntityEnergyMachine.ItemEnergy.put(this.getRegistryName().getResourcePath(),20);
        addIt();
    }
}
