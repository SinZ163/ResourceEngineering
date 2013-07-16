package resourceengineering.common.core.items;

import resourceengineering.common.ResourceEngineeringMain;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;

public class ItemScreen extends Item
{
	private Icon icon;
	private String n;
	public ItemScreen(int id,String name)
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
