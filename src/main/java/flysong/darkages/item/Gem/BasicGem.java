package flysong.darkages.item.Gem;

import flysong.darkages.init.CapabilityLoader;
import flysong.darkages.utils.BasicItem;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import java.util.List;

public abstract class BasicGem extends BasicItem {
    public BasicGem(String unlocalizedName, String registryName, CreativeTabs Tabs)
    {
        super(registryName, unlocalizedName, Tabs);
        this.setMaxStackSize(1);
    }


    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        addEnergy(attacker,1);
        return super.hitEntity(stack,target,attacker);
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
