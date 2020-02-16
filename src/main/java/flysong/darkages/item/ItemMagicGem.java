package flysong.darkages.item;

import flysong.darkages.init.CTLoader;
import flysong.darkages.init.ItemLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

import java.util.List;

public class ItemMagicGem extends BasicGem {
    public ItemMagicGem()
    {
        super("magicGem","Magic_Gem", CTLoader.DarkAgesGem);
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(I18n.format(this.getUnlocalizedName() + ".message.1"));
        OutEnergy(stack,worldIn,tooltip,flagIn);
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        super.hitEntity(stack,target,attacker);
        if(Keyboard.isKeyDown(Keyboard.KEY_LCONTROL)){
            if(getEnergy(stack)>=20){
                target.setHealth(target.getHealth()-target.getHealth()*0.9F);
                if(target.isDead)
                {
                    target.onDeath(DamageSource.MAGIC);
                }
                return true;
            }
            Minecraft.getMinecraft().player.sendMessage(new TextComponentString(I18n.format("energy.message.2")));
        }
        AddEnergy(stack,1);
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
        if(getEnergy(stack)>=20)
        {
            playerIn.inventory.addItemStackToInventory(new ItemStack(ItemLoader.UnfiredCrystal,1));
            if (!playerIn.capabilities.isCreativeMode){
                SubEnergy(stack,20);
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
