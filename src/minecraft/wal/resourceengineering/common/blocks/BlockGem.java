package resourceengineering.common.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import resourceengineering.common.ResourceEngineeringMain;

public class BlockGem extends Block
{
	public BlockGem(int id)
	{
		super(id,Material.rock);
		setTextureFile("/walgfx/Blocks.png");
		setBlockName("wal_BlockGem");
		setHardness(2.0F);
		setResistance(10.0F);
		//setLightValue(10.0F);
		setCreativeTab(ResourceEngineeringMain.reTab);
	}
	
	public int getBlockTextureFromSideAndMetadata(int i,int j)
	{
		switch(j)
		{
		case 0: return 16;//Turquoise Gem Block
		case 1: return 17;//Onyx Gem Block
		case 2: return 18;//Amethyst Gem Block
		case 3: return 19;//Citrine Gem Block
		case 4: return 20;//Emerald Gem Block
		case 5: return 21;//Ruby Gem Block
		case 6: return 22;//Sapphire Gem Block
		default: return 0;
		}
	}
	public int damageDropped(int i)
	{
		return i;
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for(int i=0;i<7;i++)
		{
			par3List.add(new ItemStack(par1, 1, i));
		}
	}
}
