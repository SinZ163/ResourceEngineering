package resourceengineering.common.core.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import resourceengineering.common.ResourceEngineeringMain;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;

public class ItemStick extends Item
{
	public static final String[] stickNames = new String[] {"stickDiamond","stickSapphire"};
	private Icon[] icons;
	public ItemStick(int id)
	{
		super(id);
		setCreativeTab(ResourceEngineeringMain.reTab);
		setMaxDamage(0);
	}
	public void registerIcons(IconRegister iconRegister)
	{
		makeIcons(iconRegister);
	}
	public void makeIcons(IconRegister iconRegister)
	{
		icons = new Icon[2];
		icons[0] = iconRegister.registerIcon("resourceengineering:itemStickDiamond");
		icons[1] = iconRegister.registerIcon("resourceengineering:itemStickSapphire");
	}
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int i)
	{
		if(i>=icons.length)
		{
			return null;
		}
		else
		{
			return icons[i];
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
	public String getUnlocalizedName(ItemStack item)
    {
        
        return super.getUnlocalizedName() + "." + stickNames[item.getItemDamage()];
    }
}
