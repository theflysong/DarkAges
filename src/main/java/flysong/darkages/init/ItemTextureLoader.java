package flysong.darkages.init;

import flysong.darkages.Modlog;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static flysong.darkages.init.ItemLoader.*;

public class ItemTextureLoader {
    public ItemTextureLoader(){
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void registerItemModels(ModelRegistryEvent event) {
        registerItemModelAll(Crystal,DarkGem,UnfiredCrystal,DarkCore,DeadGem, DeadCore,LifeCore,LifeGem,MagicCore,MagicGem,
                EnergyIngot,EnergyNugget,EnergyAxe,EnergySword,EnergyHoe, EnergyShovel,EnergyPickaxe,EnergyBoots,EnergyLeggings,
                EnergyChestplate,EnergyHelmet);
        Modlog.logger.info("Item Texture is Load.");
    }

    private void registerItemModelAll(Item ... items) {
        for(Item item : items)
        {
            ModelResourceLocation model = new ModelResourceLocation(item.getRegistryName(), "inventory");
            ModelLoader.setCustomModelResourceLocation(item, 0, model);
        }
    }
}
