package flysong.darkages.init;

import flysong.darkages.DarkAges;
import flysong.darkages.capability.CapabilityPlayerEnergy;
import flysong.darkages.interfaces.IEnergyBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class CapabilityLoader {
    public CapabilityLoader()
    {
        MinecraftForge.EVENT_BUS.register(this);
        registerCapability();
    }

    @CapabilityInject(IEnergyBase.class)
    public static Capability<IEnergyBase> playerEnergy;

    public void registerCapability()
    {
        CapabilityManager.INSTANCE.register(IEnergyBase.class, new CapabilityPlayerEnergy.Storage(), CapabilityPlayerEnergy.PlayerEnergy.class);
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
