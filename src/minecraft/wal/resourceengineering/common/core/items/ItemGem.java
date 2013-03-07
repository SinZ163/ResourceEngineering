package resourceengineering.common.core.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.relauncher.*;

import resourceengineering.common.ResourceEngineeringMain;
import tutorial.Tutorial;

public class ItemGem extends Item
{
	public ItemGem(int id)
	{
		super(id);
		setTextureFile("/walgfx/Items.png");
		setItemName("wal_ItemGem");
		setCreativeTab(ResourceEngineeringMain.reTab);
		setHasSubtypes(true);
		setMaxDamage(0);
	}
	@SideOnly(Side.CLIENT)
	public int getIconFromDamage(int i)
	{
		switch(i)
		{
		case 0: return 3;
		}
		return 0;
	}
	public String getItemNameIS(ItemStack is)
	{
		switch(is.getItemDamage())
		{
		case 0: return "wal_ItemTurqoise";
		}
		return "itemUnknown";
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubItems(int itemID, CreativeTabs tab, List itemList)
	{
		for(int i=0;i<1;i++)
		{
			itemList.add(new ItemStack(itemID,1,i));
		}
	}
}
