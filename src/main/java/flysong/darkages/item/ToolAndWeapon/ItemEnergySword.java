package flysong.darkages.item.ToolAndWeapon;

import flysong.darkages.init.CTLoader;
import flysong.darkages.init.ToolMaterialLoader;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemEnergySword extends ItemSword {
    public ItemEnergySword()
    {
        super(ToolMaterialLoader.ENERGY);
        this.setUnlocalizedName("energySword");
        this.setRegistryName("Energy_Sword");
        this.setCreativeTab(CTLoader.DarkAgesToolAndWeapon);
    }

    private int AddDamageNum = 7;

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if(AddDamageNum<=0)
        {
            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
        }
        stack.setItemDamage(stack.getMaxDamage());
        playerIn.addPotionEffect(new PotionEffect(MobEffects.STRENGTH,120));
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
