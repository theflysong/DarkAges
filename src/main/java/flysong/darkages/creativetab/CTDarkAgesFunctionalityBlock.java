package flysong.darkages.creativetab;

import flysong.darkages.init.BlockLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CTDarkAgesFunctionalityBlock extends CreativeTabs {
    public CTDarkAgesFunctionalityBlock()
    {
        super("darkAges:FunctionalityBlock");
    }

    @Override
    public ItemStack getTabIconItem()
    {
        return new ItemStack(BlockLoader.CoreAltar);
    }
}

