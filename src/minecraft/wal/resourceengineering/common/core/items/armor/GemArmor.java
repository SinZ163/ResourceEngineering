package resourceengineering.common.core.items.armor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.IArmorTextureProvider;

import resourceengineering.common.ResourceEngineeringMain;

public class GemArmor extends ItemArmor implements IArmorTextureProvider
{
	public GemArmor(int itemID,EnumArmorMaterial armorMaterial,int renderIndex,int armorType,String name,int iconIndex)
	{
		super(itemID,armorMaterial,renderIndex,armorType);
		setCreativeTab(ResourceEngineeringMain.reTab);
		setItemName(name);
		setTextureFile("/walgfx/Items.png");
		setIconIndex(iconIndex);
	}
	
	@Override
	public String getArmorTextureFile(ItemStack itemstack)
	{
		if(itemstack.itemID == ResourceEngineeringMain.turquoiseHelmet.itemID || itemstack.itemID == ResourceEngineeringMain.turquoisePlate.itemID || itemstack.itemID == ResourceEngineeringMain.turquoiseBoots.itemID)
		{
			return "/walgfx/armor/turquoise_1.png";
		}
		else if(itemstack.itemID == ResourceEngineeringMain.turquoiseLeggings.itemID)
		{
			return "/walgfx/armor/turquoise_2.png";
		}
		else if(itemstack.itemID == ResourceEngineeringMain.onyxHelmet.itemID || itemstack.itemID == ResourceEngineeringMain.onyxPlate.itemID || itemstack.itemID == ResourceEngineeringMain.onyxBoots.itemID)
		{
			return "/walgfx/armor/onyx_1.png";
		}
		else if(itemstack.itemID == ResourceEngineeringMain.onyxLeggings.itemID)
		{
			return "/walgfx/armor/onyx_2.png";
		}
		return "/walgfx/Items.png";
	}
}
