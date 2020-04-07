package flysong.darkages.item.Gem;

import flysong.darkages.init.CTLoader;
import flysong.darkages.init.ItemLoader;
import flysong.darkages.utils.Registry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

import java.util.List;

public class ItemDarkGem extends BasicGem{
    public ItemDarkGem()
    {
        super("darkGem","Dark_Gem", CTLoader.DarkAgesGem);
        addIt();

    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(I18n.format(this.getUnlocalizedName() + ".message.1"));
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {

        super.hitEntity(stack,target,attacker);
        if(Keyboard.isKeyDown(Keyboard.KEY_LCONTROL)){
            if(getEnergy(attacker)>=20){
                if(target.getHealth()<target.getMaxHealth()/10)
                {
                    target.setHealth(target.getHealth()-12);
                }
                else
                {
                    target.setHealth(target.getHealth()/1.5F);
                }
                if(target.isDead)
                {
                    target.onDeath(DamageSource.MAGIC);
                }
                return true;
            }
            Minecraft.getMinecraft().player.sendMessage(new TextComponentString(I18n.format("energy.message.2")));
            subEnergy(attacker,1);
        }
        return true;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if (worldIn.isRemote)
        {
            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
        }
        if(getEnergy(playerIn)>=10)
        {
            playerIn.inventory.addItemStackToInventory(new ItemStack(Items.COAL,1));
            if (!playerIn.capabilities.isCreativeMode){
                subEnergy(playerIn,10);
            }
            Minecraft.getMinecraft().player.sendMessage(new TextComponentString(I18n.format(this.getUnlocalizedName()+".message.2")));

        }
        else
        {
            Minecraft.getMinecraft().player.sendMessage(new TextComponentString(I18n.format("energy.message.2")));
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
    }
}
