package flysong.darkages;

import flysong.darkages.proxy.Common;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import static flysong.darkages.Modlog.*;

@Mod(modid = DarkAges.MODID,name = DarkAges.NAME,version = DarkAges.VERSION,acceptedMinecraftVersions = "1.12.2")

public class DarkAges {
    public static final String MODID = "darkages";
    public static final String NAME = "Dark Ages";
    public static final String VERSION = "1.0.0";

    @Mod.Instance(DarkAges.MODID)
    public static DarkAges instance;

    @SidedProxy(serverSide = "flysong.darkages.proxy.Common",
            clientSide = "flysong.darkages.proxy.Client")
    public static Common proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        logger.info("PreInit in DarkAges");
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        Modlog.logger.info("Init in DarkAges");
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        Modlog.logger.info("PostInit in DarkAges");
        proxy.postInit(event);
    }
}
