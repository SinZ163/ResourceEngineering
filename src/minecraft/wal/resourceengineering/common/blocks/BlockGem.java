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

public class BlockGem extends Block
{
	private Icon icons[];
	public BlockGem(int id)
	{
		super(id,Material.rock);
		setUnlocalizedName("wal_BlockGem");
		setHardness(2.0F);
		setResistance(10.0F);
		setCreativeTab(ResourceEngineeringMain.reTab);
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		makeIcons(iconRegister);
	    //     this.field_94336_cN = iconRegister.func_94245_a("resourceengineering:blockGem");
	}
	public void makeIcons(IconRegister iconRegister)
	{
		icons = new Icon[8];
		icons[0] = iconRegister.registerIcon("resourceengineering:blockGemTurquoise");
		icons[1] = iconRegister.registerIcon("resourceengineering:blockGemOnyx");
		icons[2] = iconRegister.registerIcon("resourceengineering:blockGemAmethyst");
		icons[3] = iconRegister.registerIcon("resourceengineering:blockGemCitrine");
		icons[4] = iconRegister.registerIcon("resourceengineering:blockGemEmerald");
		icons[5] = iconRegister.registerIcon("resourceengineering:blockGemRuby");
		icons[6] = iconRegister.registerIcon("resourceengineering:blockGemSapphire");
		icons[7] = iconRegister.registerIcon("resourceengineering:blockGemMixed");
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
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for(int i=0;i<8;i++)
		{
			par3List.add(new ItemStack(par1, 1, i));
		}
	}
}
