package flysong.darkages.entity.DarkZombies;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class EntityDarkZombies extends EntityZombie {
    public EntityDarkZombies(World worldIn)
    {
        super(worldIn);
        this.setSize(0.9F,2.925F);
    }

    @Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        Minecraft.getMinecraft().player.sendMessage(new TextComponentString("TEST"));
        this.dropItem(Items.COAL, 1*(this.rand.nextInt(lootingModifier))+2);
    }

    @Override
    public void onLivingUpdate() {
        if (this.world.isDaytime() && !this.world.isRemote && !this.isChild() && this.shouldBurnInDay())
        {
            this.addPotionEffect(new PotionEffect(MobEffects.WITHER,1,4));
        }
        super.onLivingUpdate();
    }
}
