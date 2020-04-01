package flysong.darkages.init;

import flysong.darkages.DarkAges;
import flysong.darkages.entity.DarkZombies.*;
import flysong.darkages.entity.entityRenderFactory;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
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
        registryEntity(event, EntityDarkZombies.class,"darkZombie",0x000000,0x7f5a80,20,2
                ,5,EnumCreatureType.MONSTER, Biome.getBiome(1),Biome.getBiome(4),Biome.getBiome(12),Biome.getBiome(13),
                Biome.getBiome(3),Biome.getBiome(8),Biome.getBiome(18),Biome.getBiome(17),Biome.getBiome(5),Biome.getBiome(19),
                Biome.getBiome(20),Biome.getBiome(21),Biome.getBiome(23),Biome.getBiome(27),Biome.getBiome(28),Biome.getBiome(29),
                Biome.getBiome(30),Biome.getBiome(31),Biome.getBiome(32),Biome.getBiome(33),Biome.getBiome(34),Biome.getBiome(35),
                Biome.getBiome(36),Biome.getBiome(37),Biome.getBiome(38),Biome.getBiome(39));
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

    private void registryEntity (RegistryEvent.Register<EntityEntry> event, @Nonnull final Class<? extends Entity> entity, String name,int color1,int color2,int spawnWeight, int min, int max, EnumCreatureType type, Biome... biomes)
    {
        event.getRegistry().register(EntityEntryBuilder.create()
                .entity(entity).id(new ResourceLocation(DarkAges.MODID, name), ID++).name(name)
                .tracker(64, 3, true).egg(color1,color2).spawn(type,spawnWeight,min,max,biomes).build());
    }
}
