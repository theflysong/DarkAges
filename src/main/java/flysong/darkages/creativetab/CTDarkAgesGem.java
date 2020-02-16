package flysong.darkages.creativetab;

import flysong.darkages.init.ItemLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CTDarkAgesGem extends CreativeTabs {
    public CTDarkAgesGem()
    {
        super("darkAges:Gem");
    }

    @Override
    public ItemStack getTabIconItem()
    {
        return new ItemStack(ItemLoader.DarkGem);
    }
}
