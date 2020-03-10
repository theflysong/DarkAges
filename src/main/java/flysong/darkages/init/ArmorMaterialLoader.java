package flysong.darkages.init;

import flysong.darkages.DarkAges;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ArmorMaterialLoader {
    public static ItemArmor.ArmorMaterial ENERGY = EnumHelper.addArmorMaterial("ENERGY", DarkAges.MODID+":"+"energy",3072
            ,new int[]{4,10,8,5},14, SoundEvents.ITEM_ARMOR_EQUIP_IRON,3.0F);
}
