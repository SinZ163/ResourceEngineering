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
		generateOre(oreBlockID,6,8,16,4,random,x,z,w);
		
		//Loaded Dirt gen
		generateResource(oreBlockID,7,50,128,64,random,x,z,w,0);
		
		//Loaded Gravel gen
		generateResource(oreBlockID,9,40,128,64,random,x,z,w,0);
		
		switch(w.provider.getBiomeGenForCoords(x, z).biomeID)
		{
		case 0://Ocean
		case 1:break;//Plains
		case 2://Desert
			generateResource(oreBlockID,8,60,128,90,random,x,z,w,40);
			break;
		case 3://Extreme Hills
		case 4://Forest
		case 5://Taiga
		case 6://Swampland
		case 7://River
		case 8://Hell
		case 9://Sky
		case 10://FrozenOcean
		case 11://FrozenRiver
		case 12://Ice Plains
		case 13://Ice Mountains
		case 14://MushroomIsland
		case 15://MushroomIslandsShore
			break;
		case 16://Beach
			generateResource(oreBlockID,8,30,80,30,random,x,z,w,40);
			break;
		case 17://Desert Hills
			generateResource(oreBlockID,8,60,128,90,random,x,z,w,40);
			break;
		case 18://ForestHills
		case 19://TaigaHills
		case 20://Extreme Hills Edge
		case 21://Jungle
		case 22://JungleHills
			break;
		default: break;
		}
		
		
	}
	private void generateResource(int oreID,int meta,int chancePerChunk,int maxSpawnY,int maxVeinSize,Random random,int x,int z,World world,int minSpawnY)
	{
		if(random.nextInt(100)<=chancePerChunk)
		{
			int posX=x+random.nextInt(16);
			int posY=random.nextInt(maxSpawnY-minSpawnY)+minSpawnY;
			int posZ=z+random.nextInt(16);
			new WorldGenMinable(oreID, meta, random.nextInt(maxVeinSize-10)+10, 1).generate(world,random,posX,posY,posZ);
		}
	}
	private void generateOre(int oreID,int meta,int veinsPerChunk,int maxSpawnY,int maxVeinSize,Random random,int x,int z,World world)
	{
		for(int i=0;i<veinsPerChunk;i++)
		{
			int posX = x+random.nextInt(16);
			int posY = random.nextInt(maxSpawnY);
			int posZ = z+random.nextInt(16);
			new WorldGenMinable(oreID, meta, random.nextInt(maxVeinSize+1), 1).generate(world,random,posX,posY,posZ);
		}
	}
}
