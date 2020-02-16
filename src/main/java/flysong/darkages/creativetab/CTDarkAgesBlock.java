package flysong.darkages.creativetab;

import flysong.darkages.init.BlockLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CTDarkAgesBlock extends CreativeTabs {
    public CTDarkAgesBlock()
    {
        super("darkAges:Block");
    }

    @Override
    public ItemStack getTabIconItem()
    {
        return new ItemStack(BlockLoader.CrystalOre);
    }
}
