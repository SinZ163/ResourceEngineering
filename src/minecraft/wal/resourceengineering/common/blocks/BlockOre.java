package resourceengineering.common.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import resourceengineering.common.ResourceEngineeringMain;

public class BlockOre extends Block
{
	public static final String[] oreNames = new String[] {"turquoise","onyx","amethyst","citrine","emerald","ruby","sapphire","loadeddirt","loadedsand","loadedgravel"};
	private Icon icons[];
	public BlockOre(int id)
	{
		super(id,Material.rock);
		setHardness(2.0F);
		setResistance(5.0F);
		setCreativeTab(ResourceEngineeringMain.reTab);
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		makeIcons(iconRegister);
	}
	public void makeIcons(IconRegister iconRegister)
	{
		icons = new Icon[10];
		icons[0] = iconRegister.registerIcon("resourceengineering:blockOreTurquoise");
		icons[1] = iconRegister.registerIcon("resourceengineering:blockOreOnyx");
		icons[2] = iconRegister.registerIcon("resourceengineering:blockOreAmethyst");
		icons[3] = iconRegister.registerIcon("resourceengineering:blockOreCitrine");
		icons[4] = iconRegister.registerIcon("resourceengineering:blockOreEmerald");
		icons[5] = iconRegister.registerIcon("resourceengineering:blockOreRuby");
		icons[6] = iconRegister.registerIcon("resourceengineering:blockOreSapphire");
		icons[7] = iconRegister.registerIcon("resourceengineering:blockLoadedDirt");
		icons[8] = iconRegister.registerIcon("resourceengineering:blockLoadedSand");
		icons[9] = iconRegister.registerIcon("resourceengineering:blockLoadedGravel");
	}
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int i, int j)
    {
        if(j>=icons.length)
        {
        	return null;
        }
        else
        	return icons[j];
    }
	
	public int damageDropped(int i)
	{
		return i;
	}
	public int idDropped(int meta,Random  random,int zero)
	{
		if(meta<7)
		{
			return ResourceEngineeringMain.gem.itemID;
		}
		else
		{
			return ResourceEngineeringMain.oreBlock.blockID;
		}
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
		l.add(new ItemStack(i,1,7));
		l.add(new ItemStack(i,1,8));
		l.add(new ItemStack(i,1,9));
	}
	public ArrayList<ItemStack> getBlockDropped(World w,int x, int y, int z, int meta, int fortune)
	{
		ArrayList<ItemStack> list = new ArrayList<ItemStack>();
		if(meta<7)
		{
			list.add(new ItemStack(ResourceEngineeringMain.gem,2,meta));
			for(int i=0;i<2+fortune;i++)
			{
				if(w.rand.nextInt(101)>49)
				{
					list.add(new ItemStack(ResourceEngineeringMain.gem,1,meta));
				}
			}
		}
		else
		{
			list.add(new ItemStack(ResourceEngineeringMain.oreBlock,1,meta));
		}
		return list;
	}
	public boolean canSilkHarvest()
	{
		return true;
	}
	public String getUnlocalizedName(ItemStack item)
    {
        return super.getUnlocalizedName() + "." + oreNames[item.getItemDamage()];
    }
}
