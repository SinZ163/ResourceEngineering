package resourceengineering.common.core.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import resourceengineering.common.ResourceEngineeringMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemStick extends Item
{
	public ItemStick(int id)
	{
		super(id);
		setTextureFile("/walgfx/Items.png");
		setItemName("wal_itemStick");
		setCreativeTab(ResourceEngineeringMain.reTab);
		setMaxDamage(0);
	}
	@SideOnly(Side.CLIENT)
	public int getIconFromDamage(int i)
	{
		switch(i)
		{
		case 0: return 18;
		case 1: return 34;
		default: return 0;
		}
	}
	public String getItemNameIS(ItemStack is)
	{
		switch(is.getItemDamage())
		{
		case 0: return "wal_ItemStickDiamond";
		case 1: return "wal_ItemStickSapphire";
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
