package flysong.darkages.init;

import flysong.darkages.Modlog;
import flysong.darkages.creativetab.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CTLoader {
    public static CreativeTabs DarkAgesGem;
    public static CreativeTabs DarkAgesMater;
    public static CreativeTabs DarkAgesBlock;
    public static CreativeTabs DarkAgesToolAndWeapon;
    public static CreativeTabs DarkAgesSouls;

    public CTLoader(FMLPreInitializationEvent event) {
        DarkAgesGem = new CTDarkAgesGem();
        DarkAgesMater = new CTDarkAgesMater();
        DarkAgesBlock = new CTDarkAgesBlock();
        DarkAgesToolAndWeapon = new CTDarkAgesToolAndWeapon();
        DarkAgesSouls = new CTDarkAgesSouls();
        Modlog.logger.info("CT is load.");
    }
}
