package resourceengineering.common.core.items;

import java.util.List;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.relauncher.*;

import resourceengineering.common.ResourceEngineeringMain;

public class ItemBlockGem extends ItemBlock
{
	public ItemBlockGem(int id)
	{
		super(id);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}
	@SideOnly(Side.CLIENT)
	public int getIconFromDamage(int par1)
	{
		return ResourceEngineeringMain.gemBlock.getBlockTextureFromSideAndMetadata(2,par1);
	}
	public int getMetadata(int par1)
	{
		return par1;
	}
	public String getItemNameIS(ItemStack is)
	{
		//TODO: Add gem blocks here
		String[] types = {"Turquoise","Onyx","Amethyst","Citrine","Emerald","Ruby","Sapphire"};
		return "wal_Block"+types[is.getItemDamage()];
	}
}
