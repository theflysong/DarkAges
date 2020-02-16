package flysong.darkages.init;

import flysong.darkages.DarkAges;
import flysong.darkages.Modlog;
import flysong.darkages.item.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static flysong.darkages.init.CTLoader.*;

@Mod.EventBusSubscriber(modid = DarkAges.MODID)
public class ItemLoader {
    public static final Item Crystal = new Item().setUnlocalizedName("crystal").setRegistryName("Crystal").setCreativeTab(DarkAgesMater);
    public static final Item UnfiredCrystal = new Item().setUnlocalizedName("unfiredCrystal").setRegistryName("Unfired_Crystal").setCreativeTab(DarkAgesMater);
    public static final Item DarkCore = new Item().setUnlocalizedName("darkCore").setRegistryName("Dark_Core").setCreativeTab(DarkAgesGem);
    public static final Item DeadCore = new Item().setUnlocalizedName("deadCore").setRegistryName("Dead_Core").setCreativeTab(DarkAgesGem);
    public static final Item MagicCore = new Item().setUnlocalizedName("magicCore").setRegistryName("Magic_Core").setCreativeTab(DarkAgesGem);
    public static final Item LifeCore = new Item().setUnlocalizedName("lifeCore").setRegistryName("Life_Core").setCreativeTab(DarkAgesGem);
    public static final Item EnergyIngot = new Item().setUnlocalizedName("energyIngot").setRegistryName("Energy_Ingot").setCreativeTab(DarkAgesMater);
    public static final Item EnergyNugget = new Item().setUnlocalizedName("energyNugget").setRegistryName("Energy_Nugget").setCreativeTab(DarkAgesMater);

    public static final Item DarkGem = new ItemDarkGem();
    public static final Item DeadGem = new ItemDeadGem();
    public static final Item MagicGem = new ItemMagicGem();
    public static final Item LifeGem = new ItemLifeGem();

    public static final Item ItemCrystalOre = new ItemBlock(BlockLoader.CrystalOre).setRegistryName(BlockLoader.CrystalOre.getRegistryName());
    public static final Item ItemCoreAltar = new ItemBlock(BlockLoader.CoreAltar).setRegistryName(BlockLoader.CoreAltar.getRegistryName());
    public static final Item ItemEnergyBlock = new ItemBlock(BlockLoader.EnergyBlock).setRegistryName(BlockLoader.EnergyBlock.getRegistryName());
    public static final Item ItemEnergyOre = new ItemBlock(BlockLoader.EnergyOre).setRegistryName(BlockLoader.EnergyOre.getRegistryName());

    public ItemLoader(){
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void Loader(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(Crystal,UnfiredCrystal,DarkGem,DarkCore,DeadGem,DeadCore,LifeGem,LifeCore,MagicGem,
                MagicCore,ItemCrystalOre,ItemCoreAltar,EnergyIngot,EnergyNugget,ItemEnergyBlock,ItemEnergyOre);
        Modlog.logger.info("Item is reg");
    }
}
