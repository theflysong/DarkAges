package flysong.darkages.proxy;

import flysong.darkages.Modlog;
import flysong.darkages.init.EntityRenderLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Client extends Common{
    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        Modlog.logger.info("PreInit in Client");
        super.preInit(event);
        new EntityRenderLoader();
    }
    @Override
    public void init(FMLInitializationEvent event)
    {
        Modlog.logger.info("Init in Client");
        super.init(event);
    }
    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
        Modlog.logger.info("PostInit in Client");
        super.postInit(event);
    }
}
