package flysong.darkages.item.Gem;

import flysong.darkages.init.CapabilityLoader;
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

public abstract class BasicGem extends Item {
    public BasicGem(String UnName, String RegName, CreativeTabs Tabs)
    {
        super();
        this.setUnlocalizedName(UnName);
        this.setRegistryName(RegName);
        this.setCreativeTab(Tabs);
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
