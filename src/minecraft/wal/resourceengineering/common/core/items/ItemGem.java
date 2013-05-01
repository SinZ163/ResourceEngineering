package resourceengineering.common.core.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.relauncher.*;

import resourceengineering.common.ResourceEngineeringMain;

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
		{//TODO: Add the rest of the gems here
		case 0: return 3;//Turquoise Gem
		case 1: return 4;//Onyx Gem
		case 2: return 5;//Amethyst Gem
		case 3: return 6;//Citrine Gem
		case 4: return 7;//Emerald Gem
		case 5: return 8;//Ruby Gem
		case 6: return 9;//Sapphire Gem
		case 7: return 163;//Refined Turquoise
		case 8: return 164;//Refined Onyx
		case 9: return 165;//Refined Amethyst
		case 10: return 166;//Refined Citrine
		case 11: return 167;//Refined Emerald
		case 12: return 168;//Refined Ruby
		case 13: return 169;//Refined Sapphire
		}
		return 0;
	}
	public String getItemNameIS(ItemStack is)
	{
		switch(is.getItemDamage())
		{//TODO: Add the rest of the gems here
		case 0: return "wal_ItemTurqoise";
		case 1: return "wal_ItemOnyx";
		case 2: return "wal_ItemAmethyst";
		case 3: return "wal_ItemCitrine";
		case 4: return "wal_ItemEmerald";
		case 5: return "wal_ItemRuby";
		case 6: return "wal_ItemSapphire";
		case 7: return "wal_ItemRefinedTurquoise";
		case 8: return "wal_ItemRefinedOnyx";
		case 9: return "wal_ItemRefinedAmethyst";
		case 10: return "wal_ItemRefinedCitrine";
		case 11: return "wal_ItemRefinedEmerald";
		case 12: return "wal_ItemRefinedRuby";
		case 13: return "wal_ItemRefinedSapphire";
		}
		return "itemUnknown";
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubItems(int itemID, CreativeTabs tab, List itemList)
	{//TODO: Add the rest of the gems here
		for(int i=0;i<14;i++)
		{
			itemList.add(new ItemStack(itemID,1,i));
		}
	}
}
