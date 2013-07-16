package resourceengineering.common.core.items;

import java.util.List;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

import cpw.mods.fml.relauncher.*;

import resourceengineering.common.ResourceEngineeringMain;
import resourceengineering.common.blocks.BlockOre;

public class ItemBlockOre extends ItemBlock
{
	public static final String[] oreNames = new String[] {"turquoise","onyx","amethyst","citrine","emerald","ruby","sapphire","loadeddirt","loadedsand","loadedgravel"};
	public ItemBlockOre(int par1)
	{
		super(par1);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1)
	{
		return ResourceEngineeringMain.oreBlock.getIcon(2,par1);
	}
	public int getMetadata(int par1)
	{
		return par1;
	}
	public String getItemNameIS(ItemStack is)
	{
		//TODO: Add ore names as ores are implemented
		String[] types = {"Turquoise","Onyx","Amethyst","Citrine","Emerald","Ruby","Sapphire","LoadedDirt","LoadedSand","LoadedGravel"};
		return "wal_ore"+types[is.getItemDamage()];
	}
	public String getUnlocalizedName(ItemStack item)
    {
        return super.getUnlocalizedName() + "." + oreNames[item.getItemDamage()];
    }
}
