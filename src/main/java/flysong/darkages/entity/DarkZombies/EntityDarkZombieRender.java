package flysong.darkages.entity.DarkZombies;

import flysong.darkages.DarkAges;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class EntityDarkZombieRender extends RenderLiving<EntityDarkZombies> {
    private static final ResourceLocation GOLDEN_CHICKEN_TEXTURE = new ResourceLocation(
            DarkAges.MODID + ":textures/entity/darkzombie.png");
    public EntityDarkZombieRender(RenderManager renderManager)
    {
        super(renderManager, new ModelZombie(), 0.5F);
    }

    @Override
    protected void preRenderCallback(EntityDarkZombies entity, float partialTickTime)
    {
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityDarkZombies entity)
    {
        return GOLDEN_CHICKEN_TEXTURE;
    }

    @Override
    public void doRender(EntityDarkZombies entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
}