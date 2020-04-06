package flysong.darkages.item.Soul;

import flysong.darkages.init.CTLoader;
import flysong.darkages.init.CapabilityLoader;
import flysong.darkages.utils.BasicItem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;

public abstract class BasicSoul extends BasicItem {
    public BasicSoul(String registryName,String unlocalizedName)
    {
        super(registryName,unlocalizedName,CTLoader.DarkAgesSouls);
    }

    public int getEnergy(EntityLivingBase player)
    {
        if(player.hasCapability(CapabilityLoader.playerEnergy, EnumFacing.EAST))
        {
            return player.getCapability(CapabilityLoader.playerEnergy, EnumFacing.EAST).getEnergy();
        }
        return 0;
    }

    public boolean setEnergy(EntityLivingBase player,int value)
    {
        if(player.hasCapability(CapabilityLoader.playerEnergy, EnumFacing.EAST))
        {
            player.getCapability(CapabilityLoader.playerEnergy, EnumFacing.EAST).setEnergy(value);
            return true;
        }
        return false;
    }

    public boolean addEnergy(EntityLivingBase player,int value)
    {
        if(player.hasCapability(CapabilityLoader.playerEnergy, EnumFacing.EAST))
        {
            player.getCapability(CapabilityLoader.playerEnergy, EnumFacing.EAST).addEnergy(value);
            return true;
        }
        return false;
    }

    public boolean subEnergy(EntityLivingBase player,int value)
    {
        if(player.hasCapability(CapabilityLoader.playerEnergy, EnumFacing.EAST))
        {
            player.getCapability(CapabilityLoader.playerEnergy, EnumFacing.EAST).subEnergy(value);
            return true;
        }
        return false;
    }
}
