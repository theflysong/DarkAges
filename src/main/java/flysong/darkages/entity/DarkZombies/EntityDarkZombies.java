package flysong.darkages.entity.DarkZombies;

import flysong.darkages.DarkAges;
import flysong.darkages.init.ItemLoader;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityDarkZombies extends EntityZombie {
    public EntityDarkZombies(World worldIn)
    {
        super(worldIn);
        this.setSize(0.6F*1.2F,1.95F*1.2F);
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
            if(this.getHealth()<=1.0F)
            {
                this.dropItem(ItemLoader.DarkDust,this.rand.nextInt(3)+1);
                this.setHealth(0.0F);
                this.onDeath(DamageSource.IN_FIRE);
            }
        }
        super.onLivingUpdate();
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();

        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(32.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(4.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(4.0D);
        this.getEntityAttribute(EntityZombie.SPAWN_REINFORCEMENTS_CHANCE).setBaseValue(0.3D);
    }
}
