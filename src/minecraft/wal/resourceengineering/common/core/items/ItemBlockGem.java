package resourceengineering.common.core.items;

import java.util.List;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

import cpw.mods.fml.relauncher.*;

import resourceengineering.common.ResourceEngineeringMain;
import resourceengineering.common.blocks.BlockGem;

public class ItemBlockGem extends ItemBlock
{
	public static final String[] gemBlockNames = new String[] {"turquoise","onyx","amethyst","citrine","emerald","ruby","sapphire","mixedgem"};
	public ItemBlockGem(int id)
	{
		super(id);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1)
	{
		return ResourceEngineeringMain.gemBlock.getIcon(2,par1);
	}
	public int getMetadata(int par1)
	{
		return par1;
	}
	public String getItemNameIS(ItemStack is)
	{
		//TODO: Add gem blocks here
		String[] types = {"Turquoise","Onyx","Amethyst","Citrine","Emerald","Ruby","Sapphire","MixedGem"};
		return "wal_Block"+types[is.getItemDamage()];
	}
	public String getUnlocalizedName(ItemStack item)
    {
        return super.getUnlocalizedName() + "." + gemBlockNames[item.getItemDamage()];
    }
}
