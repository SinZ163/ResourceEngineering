package resourceengineering.common.core.items.tools;

import resourceengineering.common.ResourceEngineeringMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;

public class ItemToolAxe extends ItemTool
{
	public static final Block[] blocksEffectiveAgainst = new Block[] {Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.pumpkin, Block.pumpkinLantern};
	public ItemToolAxe(int ID, EnumToolMaterial m, int tex, String name)
	{
	         super(ID, 1, m, blocksEffectiveAgainst);
	         this.setCreativeTab(ResourceEngineeringMain.reTab);
	         setTextureFile("/walgfx/Items.png");
	         setIconIndex(tex);
	         setItemName(name);
	}

	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
	{
	         return par2Block != null && (par2Block.blockMaterial == Material.wood || par2Block.blockMaterial == Material.plants || par2Block.blockMaterial == Material.vine) ? this.efficiencyOnProperMaterial : super.getStrVsBlock(par1ItemStack, par2Block);
	}
}
