package resourceengineering.common.core.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

import cpw.mods.fml.relauncher.*;
import resourceengineering.common.ResourceEngineeringMain;

public class ItemNugget extends Item
{
	private Icon icons;
	public ItemNugget(int id)
	{
		super(id);
		setUnlocalizedName("wal_ItemNugget");
		setCreativeTab(ResourceEngineeringMain.reTab);
		setHasSubtypes(true);
		setMaxDamage(0);
	}
	public void registerIcons(IconRegister iconRegister)
	{
		makeIcons(iconRegister);
	}
	public void makeIcons(IconRegister iconRegister)
	{
		icons = iconRegister.registerIcon("resourceengineering:itemIronNugget");
	}
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int i)
	{
		return icons;
	}
	public String getItemNameIS(ItemStack is)
	{
		switch(is.getItemDamage())
		{
		case 0: return "wal_ItemIronNugget";
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
