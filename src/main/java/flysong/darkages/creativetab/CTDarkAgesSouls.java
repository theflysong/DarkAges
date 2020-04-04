package flysong.darkages.creativetab;

import flysong.darkages.init.ItemLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CTDarkAgesSouls extends CreativeTabs {
    public CTDarkAgesSouls()
    {
        super("darkAges:Souls");
    }

    @Override
    public ItemStack getTabIconItem()
    {
        return new ItemStack(ItemLoader.DarkGem);
    }
}
