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
		int oreBlockID = ResourceEngineeringMain.oreBlock.blockID;
		//Turquoise Ore Gen
		generateOre(oreBlockID,0,60,128,8,random,x,z,w);
				
		//Onyx Ore Gen
		generateOre(oreBlockID,1,50,80,8,random,x,z,w);
		
		//Amethyst Ore Gen
		generateOre(oreBlockID,2,40,60,8,random,x,z,w);
		
		//Citrine Ore Gen
		generateOre(oreBlockID,3,30,50,8,random,x,z,w);
		
		//Emerald Ore Gen
		generateOre(oreBlockID,4,20,40,8,random,x,z,w);
		
		//Ruby Ore Gen
		generateOre(oreBlockID,5,10,30,8,random,x,z,w);
				
		//Sapphire Ore Gen
		generateOre(oreBlockID,6,5,16,4,random,x,z,w);
	}
	private void generateOre(int oreID,int meta,int veinsPerChunk,int maxSpawnY,int maxVeinSize,Random random,int x,int z,World world)
	{
		for(int i=0;i<veinsPerChunk;i++)
		{
			int posX = x+random.nextInt(16);
			int posY = random.nextInt(maxSpawnY);
			int posZ = z+random.nextInt(16);
			new WorldGenMinable(oreID,meta,random.nextInt(maxVeinSize+1)).generate(world,random,posX,posY,posZ);
		}
	}
}
