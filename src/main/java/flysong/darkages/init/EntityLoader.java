package flysong.darkages.init;

import flysong.darkages.DarkAges;
import flysong.darkages.entity.DarkZombies.*;
import flysong.darkages.entity.entityRenderFactory;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = DarkAges.MODID)
public class EntityLoader {
    private int ID=0;
    public EntityLoader()
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void registerEntity(RegistryEvent.Register<EntityEntry> event)
    {
        registryEntity(event, EntityDarkZombies.class,"darkZombie",0x000000,0x7f5a80);
    }

    private void registryEntity (RegistryEvent.Register<EntityEntry> event, @Nonnull final Class<? extends Entity> entity, String name)
    {
        event.getRegistry().register(EntityEntryBuilder.create()
                .entity(entity).id(new ResourceLocation(DarkAges.MODID, name), ID++).name(name)
                .tracker(64, 3, true).build());
    }

    public static void registerRenders()
    {
        registerEntityRender(EntityDarkZombies.class, EntityDarkZombieRender.class);
    }

    private static <T extends Entity> void registerEntityRender(Class<T> entityClass, Class<? extends Render<T>> render)
    {
        RenderingRegistry.registerEntityRenderingHandler(entityClass, new entityRenderFactory<T>(render));
    }

    private void registryEntity (RegistryEvent.Register<EntityEntry> event, @Nonnull final Class<? extends Entity> entity, String name,int color1,int color2)
    {
        event.getRegistry().register(EntityEntryBuilder.create()
                .entity(entity).id(new ResourceLocation(DarkAges.MODID, name), ID++).name(name)
                .tracker(64, 3, true).egg(color1,color2).build());
    }
}
