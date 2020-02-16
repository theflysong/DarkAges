package flysong.darkages.worldgen.orespawn;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.Random;

public class WorldOreSpawn extends WorldGenerator {
    private int MaxY;
    private int SpawnNumber;
    private WorldGenMinable Generator;

    public WorldOreSpawn(int MaxY, int SpawnNumber, WorldGenMinable Generator)
    {
        this.MaxY=MaxY;
        this.SpawnNumber=SpawnNumber;
        this.Generator=Generator;
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        if (TerrainGen.generateOre(worldIn, rand, this, position, OreGenEvent.GenerateMinable.EventType.CUSTOM))
        {
            if(SpawnNumber>=0)
            {
                for (int i = 0; i < SpawnNumber; ++i)
                {
                    int posX = position.getX() + rand.nextInt(16);
                    int posY = rand.nextInt(MaxY-4)+4;
                    int posZ = position.getZ() + rand.nextInt(16);
                    BlockPos blockpos = new BlockPos(posX, posY, posZ);
                    Generator.generate(worldIn, rand, blockpos);
                }
            }
            else
            {
                if(rand.nextInt(-SpawnNumber)==0)
                {
                    int posX = position.getX() + rand.nextInt(16);
                    int posY = rand.nextInt(MaxY-4)+4;
                    int posZ = position.getZ() + rand.nextInt(16);
                    BlockPos blockpos = new BlockPos(posX, posY, posZ);
                    Generator.generate(worldIn, rand, blockpos);
                }
            }
        }
        return true;
    }
}
