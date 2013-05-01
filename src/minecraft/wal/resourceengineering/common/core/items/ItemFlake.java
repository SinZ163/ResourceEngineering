package resourceengineering.common.core.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.relauncher.*;
import resourceengineering.common.ResourceEngineeringMain;

public class ItemFlake extends Item
{
	private int iconIndex;
	private String itemName;
	public ItemFlake(int id,String name,int icon)
	{
		super(id);
		setTextureFile("/walgfx/Items.png");
		setItemName(name);
		setCreativeTab(ResourceEngineeringMain.reTab);
		setMaxDamage(0);
		iconIndex = icon;
		itemName = name;
	}
	
	@SideOnly(Side.CLIENT)
	public int getIconFromDamage(int i)
	{
		return iconIndex;
	}
}
