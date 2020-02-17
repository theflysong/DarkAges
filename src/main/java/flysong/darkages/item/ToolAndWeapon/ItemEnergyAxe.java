package flysong.darkages.item.ToolAndWeapon;

import flysong.darkages.init.CTLoader;
import net.minecraft.item.ItemAxe;

import flysong.darkages.init.ToolMaterialLoader;

public class ItemEnergyAxe extends ItemAxe {
    public ItemEnergyAxe()
    {
        super(ToolMaterialLoader.ENERGY);
        this.setUnlocalizedName("energyAxe");
        this.setCreativeTab(CTLoader.DarkAgesToolAndWeapon);
    }
}
