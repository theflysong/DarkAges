package flysong.darkages.init;

import flysong.darkages.DarkAges;
import flysong.darkages.capability.CapabilityPlayerEnergy;
import flysong.darkages.capability.IPlayerEnergy;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityLoader {
    public CapabilityLoader()
    {

    }

    @CapabilityInject(IPlayerEnergy.class)
    public static Capability<IPlayerEnergy> playerEnergy;

    @SubscribeEvent
    public void registerCapability()
    {
        CapabilityManager.INSTANCE.register(IPlayerEnergy.class, new CapabilityPlayerEnergy.Storage(), CapabilityPlayerEnergy.PlayerEnergy.class);
    }

    @SubscribeEvent
    public void onAttachCapabilitiesEntity(AttachCapabilitiesEvent<Entity> event)
    {
        if (event.getObject() instanceof EntityPlayer)
        {
            event.addCapability(new ResourceLocation(DarkAges.MODID + ":" + "PlayerEnergy"), new CapabilityPlayerEnergy.ProviderPlayer());
        }
    }
}
