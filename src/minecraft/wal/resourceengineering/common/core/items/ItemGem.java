package resourceengineering.common.core.items;

import java.util.List;
import java.util.logging.Level;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.*;

import resourceengineering.common.ResourceEngineeringMain;

public class ItemGem extends Item
{
	public static final String[] gemNames = new String[] {"gemTurquoise","gemOnyx","gemAmethyst","gemCitrine","gemEmerald","gemRuby","gemSapphire","gemRefinedTurquoise","gemRefinedOnyx","gemRefinedAmethyst","gemRefinedCitrine","gemRefinedEmerald","gemRefinedRuby","gemRefinedSapphire"};
	private Icon[] icons;
	public ItemGem(int id)
	{
		super(id);
		setUnlocalizedName("wal_ItemGem");
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
		icons = new Icon[14];
		icons[0] = iconRegister.registerIcon("resourceengineering:itemGemTurquoise");
		icons[1] = iconRegister.registerIcon("resourceengineering:itemGemOnyx");
		icons[2] = iconRegister.registerIcon("resourceengineering:itemGemAmethyst");
		icons[3] = iconRegister.registerIcon("resourceengineering:itemGemCitrine");
		icons[4] = iconRegister.registerIcon("resourceengineering:itemGemEmerald");
		icons[5] = iconRegister.registerIcon("resourceengineering:itemGemRuby");
		icons[6] = iconRegister.registerIcon("resourceengineering:itemGemSapphire");
		icons[7] = iconRegister.registerIcon("resourceengineering:itemGemRefinedTurquoise");
		icons[8] = iconRegister.registerIcon("resourceengineering:itemGemRefinedOnyx");
		icons[9] = iconRegister.registerIcon("resourceengineering:itemGemRefinedAmethyst");
		icons[10] = iconRegister.registerIcon("resourceengineering:itemGemRefinedCitrine");
		icons[11] = iconRegister.registerIcon("resourceengineering:itemGemRefinedEmerald");
		icons[12] = iconRegister.registerIcon("resourceengineering:itemGemRefinedRuby");
		icons[13] = iconRegister.registerIcon("resourceengineering:itemGemRefinedSapphire");
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
		{//TODO: Add the rest of the gems here
		case 0: return "wal_ItemTurqoise";
		case 1: return "wal_ItemOnyx";
		case 2: return "wal_ItemAmethyst";
		case 3: return "wal_ItemCitrine";
		case 4: return "wal_ItemEmerald";
		case 5: return "wal_ItemRuby";
		case 6: return "wal_ItemSapphire";
		case 7: return "wal_ItemRefinedTurqoise";
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
	public String getUnlocalizedName(ItemStack item)
    {
        return super.getUnlocalizedName() + "." + gemNames[item.getItemDamage()];
    }
    
}
