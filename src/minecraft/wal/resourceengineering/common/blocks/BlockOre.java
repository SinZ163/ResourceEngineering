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
	}
	public ArrayList<ItemStack> getBlockDropped(World w,int x, int y, int z, int meta, int fortune)
	{
		ArrayList<ItemStack> list = new ArrayList<ItemStack>();
		list.add(new ItemStack(ResourceEngineeringMain.gem,1,meta));
		for(int i=0;i<2+fortune;i++)
		{
			if(w.rand.nextInt(101)>49)
			{
				list.add(new ItemStack(ResourceEngineeringMain.gem,1,meta));
			}
		}
		return list;
	}
}