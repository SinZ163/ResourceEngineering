package resourceengineering.common.core.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

import cpw.mods.fml.relauncher.*;
import resourceengineering.common.ResourceEngineeringMain;

public class ItemFlake extends Item
{
	private Icon icon;
	private String n;
	public ItemFlake(int id,String name)
	{
		super(id);
		setUnlocalizedName(name);
		setCreativeTab(ResourceEngineeringMain.reTab);
		setMaxDamage(0);
		n= name;
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
}
