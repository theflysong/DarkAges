package flysong.darkages.creativetab;

import flysong.darkages.init.ItemLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CTDarkAgesToolAndWeapon extends CreativeTabs {
    public CTDarkAgesToolAndWeapon()
    {
        super("darkAges:ToolAndWeapon");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ItemLoader.EnergyAxe);
    }
}
