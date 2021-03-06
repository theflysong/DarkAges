package flysong.darkages.item.ToolAndWeapon;

import flysong.darkages.init.CTLoader;
import flysong.darkages.init.CapabilityLoader;
import flysong.darkages.utils.Registry;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemEnergyLooker extends Item {
    public ItemEnergyLooker()
    {
        super();
        this.setUnlocalizedName("energyLooker");
        this.setRegistryName("Energy_Looker");
        this.setCreativeTab(CTLoader.DarkAgesToolAndWeapon);
        Registry.ItemRegistryList.add(this);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if (worldIn.isRemote)
        {
            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
        }
        if(playerIn.hasCapability(CapabilityLoader.playerEnergy, EnumFacing.EAST))
        {
            playerIn.getCapability(CapabilityLoader.playerEnergy, EnumFacing.EAST).subEnergy(1);
            playerIn.sendMessage(new TextComponentString(I18n.format("EnergyLooker.message.1")+playerIn.getCapability(CapabilityLoader.playerEnergy, EnumFacing.EAST).getEnergy()));
        }
        return new ActionResult<ItemStack>(EnumActionResult.FAIL, playerIn.getHeldItem(handIn));
    }
}
