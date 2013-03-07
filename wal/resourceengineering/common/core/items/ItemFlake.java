package resourceengineering.common.core.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.relauncher.*;
import resourceengineering.common.ResourceEngineeringMain;

public class ItemFlake extends Item
{
	public ItemFlake(int id)
	{
		super(id);
		setTextureFile("/walgfx/Items.png");
		setItemName("wal_ItemFlake");
		setCreativeTab(ResourceEngineeringMain.reTab);
		setHasSubtypes(true);
		setMaxDamage(0);
	}
	
	@SideOnly(Side.CLIENT)
	public int getIconFromDamage(int i)
	{
		switch(i)
		{
		case 0: return 0;//iron flake
		case 1: return 16;//gold flake
		}
		return 0;
	}
	public String getItemNameIS(ItemStack is)
	{
		switch(is.getItemDamage())
		{
		case 0: return "wal_ItemIronFlake";
		case 1: return "wal_ItemGoldFlake";
		}
		return "itemUnknown";
	}
	@SideOnly(Side.CLIENT)
	public void getSubItems(int itemID, CreativeTabs tab, List itemList)
	{
		for(int i=0;i<2;i++)
		{
			itemList.add(new ItemStack(itemID,1,i));
		}
	}
}
