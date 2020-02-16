package flysong.darkages.init;

import flysong.darkages.Modlog;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static flysong.darkages.init.BlockLoader.*;

public class BlockTextureLoader {
    public BlockTextureLoader() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void registerItemModels(ModelRegistryEvent event) {
        registerBlockModelAll(CrystalOre,CoreAltar,EnergyBlock,EnergyOre);
        Modlog.logger.info("Block Texture is load.");
    }

    public static void registerBlockModelAll(Block ... blocks) {
        for(Block block : blocks)
        {
            ModelResourceLocation model = new ModelResourceLocation(block.getRegistryName(), "inventory");
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, model);
        }
    }
}
