package flysong.darkages.utils;

import net.minecraft.item.Item;

public class BasicItem extends Item {
    public BasicItem()
    {
        super();
        Registry.ItemRegistryList.add(this);
    }
}
