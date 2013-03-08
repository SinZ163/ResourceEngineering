package resourceengineering.common.core.handlers;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
import resourceengineering.common.ResourceEngineeringMain;

public class WorldGenHandler implements IWorldGenerator
{
	@Override
	public void generate(Random random,int chunkX,int chunkZ,World world,IChunkProvider chunkGenerator,IChunkProvider chunkProvider)
	{
		if(world.provider.isSurfaceWorld())
		{
			generateSurface(random,chunkX*16,chunkZ*16,world);
		}
	}
	
	public void generateSurface(Random random, int x, int z,World w)
	{
		int countPerChunk=20;
		int oreMaxY=40;
		int oreCount=2;
		int maxVeinSize = 16;
		for(int i=0;i<oreCount;i++)
		{
			for(int ii=0;ii<countPerChunk;ii++)
			{
				int posX = x+random.nextInt(16);
				int posY = random.nextInt(oreMaxY);
				int posZ = z+random.nextInt(16);
				new WorldGenMinable(ResourceEngineeringMain.oreBlock.blockID,i,random.nextInt(maxVeinSize+1)).generate(w, random, posX, posY, posZ);
			}
		}
	}
}
