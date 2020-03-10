package flysong.darkages.entity.DarkZombies;

//Made with Blockbench
//Paste this code into your mod.

import org.lwjgl.opengl.GL11;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

/*
not enabled.
Reason: the texture is changed according to Zombie's texture,
don't need to use this class, but may use it in the future
*/


public class EntityDarkZombiesModelBase extends ModelBase {
    private final ModelRenderer bone;

    public EntityDarkZombiesModelBase () {
        textureWidth = 16;
        textureHeight = 16;

        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 23.0F, 0.0F);
        bone.cubeList.add(new ModelBox(bone, 0, 0, -2.0F, -7.0F, -0.5F, 2, 2, 2, 0.0F, true));
        bone.cubeList.add(new ModelBox(bone, 0, 4, -1.0F, -2.0F, 0.0F, 1, 3, 1, 0.0F, true));
        bone.cubeList.add(new ModelBox(bone, 4, 4, -2.0F, -5.0F, 0.0F, 2, 3, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 10, 4, -3.0F, -5.0F, 0.0F, 1, 3, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 10, 4, 0.0F, -5.0F, 0.0F, 1, 3, 1, 0.0F, true));
        bone.cubeList.add(new ModelBox(bone, 0, 4, -2.0F, -2.0F, 0.0F, 1, 3, 1, 0.0F, false));
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        bone.render(f5);
    }
    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
