package flysong.darkages.item.ToolAndWeapon;

import flysong.darkages.init.CTLoader;
import flysong.darkages.init.ToolMaterialLoader;
import net.minecraft.item.ItemAxe;

public class ItemEnergyAxe extends ItemAxe {

    public ItemEnergyAxe()
    {
        super(ToolMaterialLoader.ENERGY);
        this.setUnlocalizedName("energyAxe");
        this.setRegistryName("Energy_Axe");
        this.setCreativeTab(CTLoader.DarkAgesToolAndWeapon);
    }
}
