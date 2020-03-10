package flysong.darkages.item.ToolAndWeapon;

import flysong.darkages.init.ArmorMaterialLoader;
import flysong.darkages.init.CTLoader;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ItemEnergyArmor extends ItemArmor {
    public ItemEnergyArmor(EntityEquipmentSlot armorType,String UnlocalizedName,String RegistryName)
    {
        super(ArmorMaterialLoader.ENERGY,ArmorMaterialLoader.ENERGY.ordinal(),armorType);
        this.setCreativeTab(CTLoader.DarkAgesToolAndWeapon);
        this.setUnlocalizedName(UnlocalizedName);
        this.setRegistryName(RegistryName);
    }

    public static class Boots extends ItemEnergyArmor{
        public Boots()
        {
            super(EntityEquipmentSlot.FEET,"energyBoots","Energy_Boots");
        }
    }

    public static class Leggings extends ItemEnergyArmor{
        public Leggings()
        {
            super(EntityEquipmentSlot.LEGS,"energyLeggings","Energy_Leggings");
        }
    }

    public static class Chestplate extends ItemEnergyArmor{
        public Chestplate()
        {
            super(EntityEquipmentSlot.CHEST,"energyChestplate","Energy_Chestplate");
        }
    }

    public static class Helmet extends ItemEnergyArmor{
        public Helmet()
        {
            super(EntityEquipmentSlot.HEAD,"energyHelmet","Energy_Helmet");
        }
    }
}