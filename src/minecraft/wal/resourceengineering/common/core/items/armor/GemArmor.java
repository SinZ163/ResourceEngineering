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
		else if(itemstack.itemID == ResourceEngineeringMain.amethystHelmet.itemID || itemstack.itemID == ResourceEngineeringMain.amethystPlate.itemID || itemstack.itemID == ResourceEngineeringMain.amethystBoots.itemID)
		{
			return "/walgfx/armor/amethyst_1.png";
		}
		else if(itemstack.itemID == ResourceEngineeringMain.amethystLeggings.itemID)
		{
			return "/walgfx/armor/amethyst_2.png";
		}
		else if(itemstack.itemID == ResourceEngineeringMain.citrineHelmet.itemID || itemstack.itemID == ResourceEngineeringMain.citrinePlate.itemID || itemstack.itemID == ResourceEngineeringMain.citrineBoots.itemID)
		{
			return "/walgfx/armor/citrine_1.png";
		}
		else if(itemstack.itemID == ResourceEngineeringMain.citrineLeggings.itemID)
		{
			return "/walgfx/armor/citrine_2.png";
		}
		else if(itemstack.itemID == ResourceEngineeringMain.emeraldHelmet.itemID || itemstack.itemID == ResourceEngineeringMain.emeraldPlate.itemID || itemstack.itemID == ResourceEngineeringMain.emeraldBoots.itemID)
		{
			return "/walgfx/armor/emerald_1.png";
		}
		else if(itemstack.itemID == ResourceEngineeringMain.emeraldLeggings.itemID)
		{
			return "/walgfx/armor/emerald_2.png";
		}
		else if(itemstack.itemID == ResourceEngineeringMain.rubyHelmet.itemID || itemstack.itemID == ResourceEngineeringMain.rubyPlate.itemID || itemstack.itemID == ResourceEngineeringMain.rubyBoots.itemID)
		{
			return "/walgfx/armor/ruby_1.png";
		}
		else if(itemstack.itemID == ResourceEngineeringMain.rubyLeggings.itemID)
		{
			return "/walgfx/armor/ruby_2.png";
		}
		else if(itemstack.itemID == ResourceEngineeringMain.sapphireHelmet.itemID || itemstack.itemID == ResourceEngineeringMain.sapphirePlate.itemID || itemstack.itemID == ResourceEngineeringMain.sapphireBoots.itemID)
		{
			return "/walgfx/armor/sapphire_1.png";
		}
		else if(itemstack.itemID == ResourceEngineeringMain.sapphireLeggings.itemID)
		{
			return "/walgfx/armor/sapphire_2.png";
		}
		return "/walgfx/Items.png";
	}
}
