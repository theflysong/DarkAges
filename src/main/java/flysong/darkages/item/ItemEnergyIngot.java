package flysong.darkages.item;

import flysong.darkages.block.tileEntity.TileEntityEnergyAlternator;
import net.minecraft.item.Item;

import static flysong.darkages.init.CTLoader.DarkAgesMater;

public class ItemEnergyIngot extends Item {
    public ItemEnergyIngot()
    {
        super();
        this.setUnlocalizedName("energyIngot");
        this.setRegistryName("Energy_Ingot");
        this.setCreativeTab(DarkAgesMater);
        TileEntityEnergyAlternator.ItemTime.put(this.getRegistryName().getResourcePath(),2);
    }
}
