package resourceengineering.common.core.items.armor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.Icon;
import resourceengineering.common.ResourceEngineeringMain;

public class GemArmor extends ItemArmor
{
	private Icon icon;
	private String n;
	public GemArmor(int itemID,EnumArmorMaterial armorMaterial,int renderIndex,int armorType,String name)
	{
		super(itemID,armorMaterial,renderIndex,armorType);
		setCreativeTab(ResourceEngineeringMain.reTab);
		setUnlocalizedName(name);
		n=name;
	}
	public void registerIcons(IconRegister iconRegister)
	{
		makeIcons(iconRegister);
	}
	public void makeIcons(IconRegister iconRegister)
	{
		icon = iconRegister.registerIcon("resourceengineering:"+n);
	}
    @SideOnly(Side.CLIENT)
    @Override
    public Icon getIconFromDamage(int i)
    {
        return icon;
    }
    public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, int layer)
    {
		if(itemstack.itemID == ResourceEngineeringMain.turquoiseHelmet.itemID || itemstack.itemID == ResourceEngineeringMain.turquoisePlate.itemID || itemstack.itemID == ResourceEngineeringMain.turquoiseBoots.itemID)
		{
			return "resourceengineering:textures/armor/turquoise_1.png";
		}
		else if(itemstack.itemID == ResourceEngineeringMain.turquoiseLeggings.itemID)
		{
			return "resourceengineering:textures/armor/turquoise_2.png";
		}
		else if(itemstack.itemID == ResourceEngineeringMain.onyxHelmet.itemID || itemstack.itemID == ResourceEngineeringMain.onyxPlate.itemID || itemstack.itemID == ResourceEngineeringMain.onyxBoots.itemID)
		{
			return "resourceengineering:textures/armor/onyx_1.png";
		}
		else if(itemstack.itemID == ResourceEngineeringMain.onyxLeggings.itemID)
		{
			return "resourceengineering:textures/armor/onyx_2.png";
		}
		else if(itemstack.itemID == ResourceEngineeringMain.amethystHelmet.itemID || itemstack.itemID == ResourceEngineeringMain.amethystPlate.itemID || itemstack.itemID == ResourceEngineeringMain.amethystBoots.itemID)
		{
			return "resourceengineering:textures/armor/amethyst_1.png";
		}
		else if(itemstack.itemID == ResourceEngineeringMain.amethystLeggings.itemID)
		{
			return "resourceengineering:textures/armor/amethyst_2.png";
		}
		else if(itemstack.itemID == ResourceEngineeringMain.citrineHelmet.itemID || itemstack.itemID == ResourceEngineeringMain.citrinePlate.itemID || itemstack.itemID == ResourceEngineeringMain.citrineBoots.itemID)
		{
			return "resourceengineering:textures/armor/citrine_1.png";
		}
		else if(itemstack.itemID == ResourceEngineeringMain.citrineLeggings.itemID)
		{
			return "resourceengineering:textures/armor/citrine_2.png";
		}
		else if(itemstack.itemID == ResourceEngineeringMain.emeraldHelmet.itemID || itemstack.itemID == ResourceEngineeringMain.emeraldPlate.itemID || itemstack.itemID == ResourceEngineeringMain.emeraldBoots.itemID)
		{
			return "resourceengineering:textures/armor/emerald_1.png";
		}
		else if(itemstack.itemID == ResourceEngineeringMain.emeraldLeggings.itemID)
		{
			return "resourceengineering:textures/armor/emerald_2.png";
		}
		else if(itemstack.itemID == ResourceEngineeringMain.rubyHelmet.itemID || itemstack.itemID == ResourceEngineeringMain.rubyPlate.itemID || itemstack.itemID == ResourceEngineeringMain.rubyBoots.itemID)
		{
			return "resourceengineering:textures/armor/ruby_1.png";
		}
		else if(itemstack.itemID == ResourceEngineeringMain.rubyLeggings.itemID)
		{
			return "resourceengineering:textures/armor/ruby_2.png";
		}
		else if(itemstack.itemID == ResourceEngineeringMain.sapphireHelmet.itemID || itemstack.itemID == ResourceEngineeringMain.sapphirePlate.itemID || itemstack.itemID == ResourceEngineeringMain.sapphireBoots.itemID)
		{
			return "resourceengineering:textures/armor/sapphire_1.png";
		}
		else if(itemstack.itemID == ResourceEngineeringMain.sapphireLeggings.itemID)
		{
			return "resourceengineering:textures/armor/sapphire_2.png";
		}
		return "resourceengineering:textures/sapphire_2.png";
	}
}
