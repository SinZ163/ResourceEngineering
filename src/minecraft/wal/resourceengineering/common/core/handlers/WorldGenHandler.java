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
		int oreCount=7;
		int maxVeinSize = 4;
		
		//Turquoise Ore Gen
		int turquoisePerChunk = 80;
		int turquoiseMaxY = 128;
		int turquoiseVeinSize = 8;
		for(int ii=0;ii<turquoisePerChunk;ii++)
		{
			int posX = x+random.nextInt(16);
			int posY = random.nextInt(turquoiseMaxY);
			int posZ = z+random.nextInt(16);
			new WorldGenMinable(ResourceEngineeringMain.oreBlock.blockID,0,random.nextInt(turquoiseVeinSize+1)).generate(w, random, posX, posY, posZ);
		}
		
		//Onyx Ore Gen
		int onyxPerChunk = 60;
		int onyxMaxY = 80;
		int onyxVeinSize = 8;
		for(int ii=0;ii<onyxPerChunk;ii++)
		{
			int posX = x+random.nextInt(16);
			int posY = random.nextInt(onyxMaxY);
			int posZ = z+random.nextInt(16);
			new WorldGenMinable(ResourceEngineeringMain.oreBlock.blockID,1,random.nextInt(onyxVeinSize+1)).generate(w, random, posX, posY, posZ);
		}
		
		//Amethyst Ore Gen
		int amethystPerChunk = 40;
		int amethystMaxY = 60;
		int amethystVeinSize = 8;
		for(int ii=0;ii<amethystPerChunk;ii++)
		{
			int posX = x+random.nextInt(16);
			int posY = random.nextInt(amethystMaxY);
			int posZ = z+random.nextInt(16);
			new WorldGenMinable(ResourceEngineeringMain.oreBlock.blockID,2,random.nextInt(amethystVeinSize+1)).generate(w, random, posX, posY, posZ);
		}
		
		//Citrine Ore Gen
		int citrinePerChunk = 30;
		int citrineMaxY = 50;
		int citrineVeinSize = 8;
		for(int ii=0;ii<citrinePerChunk;ii++)
		{
			int posX = x+random.nextInt(16);
			int posY = random.nextInt(citrineMaxY);
			int posZ = z+random.nextInt(16);
			new WorldGenMinable(ResourceEngineeringMain.oreBlock.blockID,3,random.nextInt(citrineVeinSize+1)).generate(w, random, posX, posY, posZ);
		}
		
		//Emerald Ore Gen
		int emeraldPerChunk = 20;
		int emeraldMaxY = 40;
		int emeraldVeinSize = 8;
		for(int ii=0;ii<emeraldPerChunk;ii++)
		{
			int posX = x+random.nextInt(16);
			int posY = random.nextInt(emeraldMaxY);
			int posZ = z+random.nextInt(16);
			new WorldGenMinable(ResourceEngineeringMain.oreBlock.blockID,4,random.nextInt(emeraldVeinSize+1)).generate(w, random, posX, posY, posZ);
		}
		
		//Ruby Ore Gen
		int rubyPerChunk = 10;
		int rubyMaxY = 30;
		int rubyVeinSize = 8;
		for(int ii=0;ii<rubyPerChunk;ii++)
		{
			int posX = x+random.nextInt(16);
			int posY = random.nextInt(rubyMaxY);
			int posZ = z+random.nextInt(16);
			new WorldGenMinable(ResourceEngineeringMain.oreBlock.blockID,5,random.nextInt(rubyVeinSize+1)).generate(w, random, posX, posY, posZ);
		}
		
		//Sapphire Ore Gen
		int sapphirePerChunk = 5;
		int sapphireMaxY = 16;
		int sapphireVeinSize = 4;
		for(int ii=0;ii<sapphirePerChunk;ii++)
		{
			int posX = x+random.nextInt(16);
			int posY = random.nextInt(sapphireMaxY);
			int posZ = z+random.nextInt(16);
			new WorldGenMinable(ResourceEngineeringMain.oreBlock.blockID,6,random.nextInt(sapphireVeinSize+1)).generate(w, random, posX, posY, posZ);
		}
	}
}
