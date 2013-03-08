package resourceengineering.common.tabs;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.*;
import resourceengineering.common.ResourceEngineeringMain;

public class ResourceEngineeringTab extends CreativeTabs
{
	public ResourceEngineeringTab(int position, String tabID)
	{
		super(position, tabID);
	}
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return ResourceEngineeringMain.flake.itemID;
	}
	public String getTranslatedTabLabel()
	{
		return "Resource Engineering";
	}
}
