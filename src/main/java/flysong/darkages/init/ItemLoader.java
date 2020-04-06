package flysong.darkages.init;

import flysong.darkages.item.Gem.*;
import flysong.darkages.item.ItemEnergyIngot;
import flysong.darkages.item.ToolAndWeapon.*;
import flysong.darkages.utils.BasicItem;
import net.minecraft.item.Item;

import static flysong.darkages.init.CTLoader.*;

public class ItemLoader {
    public static final Item Crystal = new BasicItem("Crystal","crystal",DarkAgesMater).addIt();
    public static final Item UnfiredCrystal = new BasicItem("Unfired_Crystal","unfiredCrystal",DarkAgesMater).addIt();
    public static final Item DarkCore = new BasicItem("Dark_Core","darkCore",DarkAgesGem).addIt();
    public static final Item DeadCore = new BasicItem("Dead_Core","deadCore",DarkAgesGem).addIt();
    public static final Item MagicCore = new BasicItem("Magic_Core","magicCore",DarkAgesGem).addIt();
    public static final Item LifeCore = new BasicItem("Life_Core","lifeCore",DarkAgesGem).addIt();
    public static final Item EnergyNugget = new BasicItem("Energy_Nugget","energyNugget",DarkAgesMater).addIt();
    public static final Item DarkDust = new BasicItem("Dark_Dust","darkDust",DarkAgesMater).addIt();
    public static final Item DarkPower = new BasicItem("Dark_Power","darkPower",DarkAgesMater).addIt();
    public static final Item ChaosPower = new BasicItem("Chaos_Power","chaosPower",DarkAgesMater).addIt();
    public static final Item Entropy = new BasicItem("Entropy","entropy",DarkAgesMater).addIt();

    public static final Item EnergyIngot = new ItemEnergyIngot();
    public static final Item DarkGem = new ItemDarkGem();
    public static final Item DeadGem = new ItemDeadGem();
    public static final Item MagicGem = new ItemMagicGem();
    public static final Item LifeGem = new ItemLifeGem();

    public static final Item EnergyAxe = new ItemEnergyAxe();
    public static final Item EnergySword = new ItemEnergySword();
    public static final Item EnergyPickaxe = new ItemEnergyPickaxe();
    public static final Item EnergyShovel = new ItemEnergyShovel();
    public static final Item EnergyHoe = new ItemEnergyHoe();
    public static final Item EnergyBoots = new ItemEnergyArmor.Boots();
    public static final Item EnergyLeggings = new ItemEnergyArmor.Leggings();
    public static final Item EnergyChestplate = new ItemEnergyArmor.Chestplate();
    public static final Item EnergyHelmet = new ItemEnergyArmor.Helmet();
    public static final Item EnergyLooker = new ItemEnergyLooker();
}
