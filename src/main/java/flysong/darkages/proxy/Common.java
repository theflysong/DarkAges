package flysong.darkages.proxy;

import flysong.darkages.Modlog;
import flysong.darkages.init.BlockLoader;
import flysong.darkages.init.CTLoader;
import flysong.darkages.init.ItemLoader;
import flysong.darkages.init.MeltingLoader;
import flysong.darkages.worldgen.orespawn.oreSpawnLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Common {
    public void preInit(FMLPreInitializationEvent event)
    {
        Modlog.logger.info("PreInit in Common");
        new CTLoader(event);
        new BlockLoader();
        new ItemLoader();
    }

    public void init(FMLInitializationEvent event)
    {
        new MeltingLoader();
        new oreSpawnLoader();
        Modlog.logger.info("Init in Common");
    }

    public void postInit(FMLPostInitializationEvent event)
    {
        Modlog.logger.info("PostInit in Common");
    }
}
