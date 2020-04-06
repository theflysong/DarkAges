package flysong.darkages.proxy;

import flysong.darkages.Modlog;
import flysong.darkages.init.*;
import flysong.darkages.utils.Registry;
import flysong.darkages.worldgen.orespawn.oreSpawnLoader;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Common {
    public void preInit(FMLPreInitializationEvent event)
    {
        Modlog.logger.info("PreInit in Common");
        new CTLoader(event);
        new ItemLoader();
        new BlockLoader();
        new Registry();
        new EntityLoader();
        new CapabilityLoader();
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
