package flysong.darkages.creativetab;

import flysong.darkages.init.ItemLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CTDarkAgesMater extends CreativeTabs {
    public CTDarkAgesMater()
    {
        super("darkAges:Material");
    }

    @Override
    public ItemStack getTabIconItem()
    {
        return new ItemStack(ItemLoader.Crystal);
    }
}
