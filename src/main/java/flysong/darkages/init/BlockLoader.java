package flysong.darkages.init;

import flysong.darkages.DarkAges;
import flysong.darkages.Modlog;
import flysong.darkages.block.*;
import flysong.darkages.block.tileEntity.TileEntityEnergyAlternator;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static flysong.darkages.DarkAges.MODID;

@Mod.EventBusSubscriber(modid = MODID)
public class BlockLoader {

    public static final Block CrystalOre = new BlockCrystalOre();
    public static final Block CoreAltar = new BlockCoreAltar();
    public static final Block EnergyBlock = new BasicBlock(Material.ROCK,SoundType.STONE,"energyBlock","Energy_block").setDigLevel("pickaxe",3).setCreativeTab(CTLoader.DarkAgesBlock).setHardness(12.0F);

    public static final Block EnergyOre = new BasicBlock(Material.ROCK,SoundType.STONE,"energyOre","Energy_Ore").setDigLevel("pickaxe",3).setCreativeTab(CTLoader.DarkAgesBlock).setHardness(20.5F);

    public BlockLoader(){
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void Loader(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(CrystalOre,CoreAltar,EnergyBlock,EnergyOre);

        GameRegistry.registerTileEntity(TileEntityEnergyAlternator.class, new ResourceLocation(MODID+":"+"Energy_Alternator"));
        Modlog.logger.info("Block is reg.");
    }
}
