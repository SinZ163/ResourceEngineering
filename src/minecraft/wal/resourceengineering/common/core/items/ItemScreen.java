package resourceengineering.common.core.items;

import resourceengineering.common.ResourceEngineeringMain;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.Item;

public class ItemScreen extends Item
{
	public ItemScreen(int id,String name)
	{
		super(id);
		setCreativeTab(ResourceEngineeringMain.reTab);
		setMaxDamage(0);
		setTextureFile("/walgfx/Items.png");
		setItemName("wal_ItemScreen");
	}
	@SideOnly(Side.CLIENT)
	public int getIconFromDamage(int i)
	{
		switch(i)
		{
		case 0: return 10;//ItemScreen
		}
		return 0;
	}
}
