package flysong.darkages.item;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
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

    public int getEnergy(ItemStack stack)
    {
        if(stack.getTagCompound()==null)
        {
            stack.setTagCompound(new NBTTagCompound());
            NBTTagCompound nbt = new NBTTagCompound();
            nbt.setInteger("EnergySave", 0);
            stack.getTagCompound().setTag("Energy", nbt);
        }
        NBTTagCompound NBT=stack.getTagCompound();
        return NBT.getInteger("EnergySave");
    }

    public void setEnergy(ItemStack stack,int value)
    {
        if(stack.getTagCompound()==null)
        {
            stack.setTagCompound(new NBTTagCompound());
            NBTTagCompound nbt = new NBTTagCompound();
            nbt.setInteger("EnergySave", 0);
            stack.getTagCompound().setTag("Energy", nbt);
        }
        NBTTagCompound NBT=stack.getTagCompound();
        NBT.setInteger("EnergySave",value);
    }

    public void AddEnergy(ItemStack stack,int value)
    {
        setEnergy(stack,getEnergy(stack)+value);
    }

    public void SubEnergy(ItemStack stack,int value)
    {
        setEnergy(stack,getEnergy(stack)-value);
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        super.hitEntity(stack,target,attacker);
        return true;
    }

    public void OutEnergy(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        tooltip.add(I18n.format("energy.message.1")+getEnergy(stack));
    }
}
