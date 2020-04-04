package flysong.darkages.utils;

import flysong.darkages.DarkAges;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

@Mod.EventBusSubscriber(modid = DarkAges.MODID)
public class Registry {
    public static List<Item> ItemRegistryList;
    public static List<Item> ItemBlockRegistryList;
    public static List<Block> BlockRegistryList;

    @SubscribeEvent
    public static void ItemRegistry(RegistryEvent.Register<Item> event)
    {
        for(Item item :ItemRegistryList)
        {
            event.getRegistry().register(item);
        }
    }

    @SubscribeEvent
    public static void ItemBlockRegistry(RegistryEvent.Register<Item> event)
    {
        for(Item item : ItemBlockRegistryList)
        {
            event.getRegistry().register(item);
        }
    }

    @SubscribeEvent
    public static void BlockRegistry(RegistryEvent.Register<Block> event)
    {
        for(Block block : BlockRegistryList)
        {
            event.getRegistry().register(block);
        }
    }

    @SubscribeEvent
    public static void ItemModelRegister(ModelRegistryEvent event) {
        for(Item item : ItemRegistryList)
        {
            ModelResourceLocation model = new ModelResourceLocation(item.getRegistryName(), "inventory");
            ModelLoader.setCustomModelResourceLocation(item, 0, model);
        }
    }

    @SubscribeEvent
    public static void registerBlockModelAll(ModelRegistryEvent event) {
        for(Block block : BlockRegistryList)
        {
            ModelResourceLocation model = new ModelResourceLocation(block.getRegistryName(), "inventory");
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, model);
        }
    }
}
