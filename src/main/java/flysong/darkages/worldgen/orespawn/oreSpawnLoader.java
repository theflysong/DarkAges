package flysong.darkages.worldgen.orespawn;

import flysong.darkages.init.BlockLoader;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class oreSpawnLoader {

    public static final WorldGenerator crystal = new WorldOreSpawn(40,-2,new WorldGenMinable(BlockLoader.CrystalOre.getDefaultState(), 6));

    public oreSpawnLoader()
    {
        MinecraftForge.ORE_GEN_BUS.register(this);
    }

    @SubscribeEvent
    public void onOreGenPost(OreGenEvent.Pre event)
    {
        crystal.generate(event.getWorld(),event.getRand(),event.getPos());
    }
}
