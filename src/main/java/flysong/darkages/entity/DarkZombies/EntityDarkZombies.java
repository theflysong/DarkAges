package flysong.darkages.entity.DarkZombies;

import flysong.darkages.DarkAges;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityDarkZombies extends EntityZombie {
    public EntityDarkZombies(World worldIn)
    {
        super(worldIn);
        this.setSize(0.9F,2.925F);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return new ResourceLocation(DarkAges.MODID, "entities/darkzombies");
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
