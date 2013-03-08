package resourceengineering.common.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import resourceengineering.common.ResourceEngineeringMain;

public class BlockOre extends Block
{
	public BlockOre(int id)
	{
		super(id,Material.rock);
		setTextureFile("/walgfx/Blocks.png");
		setBlockName("wal_BlockOre");
		setHardness(2.0F);
		setResistance(5.0F);
		setCreativeTab(ResourceEngineeringMain.reTab);
	}
	
	public int getBlockTextureFromSideAndMetadata(int i,int j)
	{
		switch(j)
		{//TODO: Add the rest of the ores here
		case 0: return 0;//Turqoise Ore
		case 1: return 1;//Onyx Ore
		case 2: return 2;//Amethyst Ore
		case 3: return 3;//Citrine Ore
		case 4: return 4;//Emerald Ore
		case 5: return 5;//Ruby Ore
		case 6: return 6;//Sapphire Ore
		default: return 0;
		}
	}
	
	public int damageDropped(int i)
	{
		return i;
	}
	public void getSubBlocks(int i, CreativeTabs tab, List l)
	{//TODO: Add the rest of the ores here
		l.add(new ItemStack(i,1,0));
		l.add(new ItemStack(i,1,1));
		l.add(new ItemStack(i,1,2));
		l.add(new ItemStack(i,1,3));
		l.add(new ItemStack(i,1,4));
		l.add(new ItemStack(i,1,5));
		l.add(new ItemStack(i,1,6));
	}
	public ArrayList<ItemStack> getBlockDropped(World w,int x, int y, int z, int meta, int fortune)
	{
		ArrayList<ItemStack> list = new ArrayList<ItemStack>();
		list.add(new ItemStack(ResourceEngineeringMain.gem,2,meta));
		for(int i=0;i<2+fortune;i++)
		{
			if(w.rand.nextInt(101)>49)
			{
				list.add(new ItemStack(ResourceEngineeringMain.gem,1,meta));
			}
		}
		return list;
	}
	public boolean canSilkHarvest()
	{
		return true;
	}
}
