package flysong.darkages.utils;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BasicItem extends Item {
    public BasicItem(String registryName, String unlocalizedName, CreativeTabs tab)
    {
        super();
        this.setRegistryName(registryName);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(tab);
    }

    public BasicItem()
    {
        super();
    }

    public BasicItem addIt()
    {
        Registry.ItemRegistryList.add(this);
        return this;
    }
}
