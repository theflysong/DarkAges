package flysong.darkages.item.ToolAndWeapon;

import flysong.darkages.init.CTLoader;
import flysong.darkages.init.ToolMaterialLoader;
import flysong.darkages.utils.Registry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemEnergyAxe extends ItemAxe {
    public ItemEnergyAxe()
    {
        super(ToolMaterialLoader.ENERGY,ToolMaterialLoader.ENERGY.getAttackDamage()+2,1);
        this.setUnlocalizedName("energyAxe");
        this.setRegistryName("Energy_Axe");
        this.setCreativeTab(CTLoader.DarkAgesToolAndWeapon);
        Registry.ItemRegistryList.add(this);
    }

    private int AddDamageNum = 3;

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if(AddDamageNum<=0)
        {
            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
        }
        stack.setItemDamage(0);
        playerIn.addPotionEffect(new PotionEffect(MobEffects.HASTE,120));
        AddDamageNum--;
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        if(target.isDead)
        {
            AddDamageNum++;
            stack.setItemDamage(stack.getItemDamage()+stack.getMaxDamage()/100);
        }
        return super.hitEntity(stack,target,attacker);
    }
}
