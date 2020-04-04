package flysong.darkages.item.Soul;

import flysong.darkages.init.CTLoader;
import flysong.darkages.init.CapabilityLoader;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;

public abstract class BasicSoul extends Item {
    public BasicSoul(String registryName,String unlocalizedName)
    {
        super();
        this.setUnlocalizedName(unlocalizedName);
        this.setRegistryName(registryName);
        this.setCreativeTab(CTLoader.DarkAgesSouls);
    }

    public int getEnergy(EntityLivingBase player)
    {
        if(player.hasCapability(CapabilityLoader.playerEnergy, EnumFacing.EAST))
        {
            return player.getCapability(CapabilityLoader.playerEnergy, EnumFacing.EAST).getPlayerEnergy();
        }
        return 0;
    }

    public boolean setEnergy(EntityLivingBase player,int value)
    {
        if(player.hasCapability(CapabilityLoader.playerEnergy, EnumFacing.EAST))
        {
            player.getCapability(CapabilityLoader.playerEnergy, EnumFacing.EAST).setPlayerEnergy(value);
            return true;
        }
        return false;
    }

    public boolean addEnergy(EntityLivingBase player,int value)
    {
        if(player.hasCapability(CapabilityLoader.playerEnergy, EnumFacing.EAST))
        {
            player.getCapability(CapabilityLoader.playerEnergy, EnumFacing.EAST).addPlayerEnergy(value);
            return true;
        }
        return false;
    }

    public boolean subEnergy(EntityLivingBase player,int value)
    {
        if(player.hasCapability(CapabilityLoader.playerEnergy, EnumFacing.EAST))
        {
            player.getCapability(CapabilityLoader.playerEnergy, EnumFacing.EAST).subPlayerEnergy(value);
            return true;
        }
        return false;
    }
}
