package resourceengineering.common.core.items.tools;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import resourceengineering.common.ResourceEngineeringMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemToolAxe extends ItemTool
{
	private Icon icon;
	private String n;
	public static final Block[] blocksEffectiveAgainst = new Block[] {Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.pumpkin, Block.pumpkinLantern};
	public ItemToolAxe(int ID, EnumToolMaterial m, int tex, String name)
	{
	         super(ID, 1, m, blocksEffectiveAgainst);
	         this.setCreativeTab(ResourceEngineeringMain.reTab);
	         setUnlocalizedName(name);
	         n = name;
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
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
	{
	         return par2Block != null && (par2Block.blockMaterial == Material.wood || par2Block.blockMaterial == Material.plants || par2Block.blockMaterial == Material.vine) ? this.efficiencyOnProperMaterial : super.getStrVsBlock(par1ItemStack, par2Block);
	}
}
