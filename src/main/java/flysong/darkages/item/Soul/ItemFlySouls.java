package flysong.darkages.item.Soul;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
public class ItemFlySouls extends BasicSoul {
    public ItemFlySouls() {
        super("Fly_Soul", "flySoul");
        addIt();
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        playerIn.capabilities.allowFlying=true;
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}