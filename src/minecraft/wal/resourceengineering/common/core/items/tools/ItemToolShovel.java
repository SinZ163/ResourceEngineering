package resourceengineering.common.core.items.tools;

import resourceengineering.common.ResourceEngineeringMain;
import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;

public class ItemToolShovel extends ItemTool
{
	public static final Block[] blocksEffectiveAgainst = new Block[] {Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium};
	public ItemToolShovel(int ID, EnumToolMaterial m, int tex, String name)
	{
	         super(ID, 1, m, blocksEffectiveAgainst);
	         setTextureFile("/walgfx/Items.png");
	         this.setCreativeTab(ResourceEngineeringMain.reTab);
	         setIconIndex(tex);
	         setItemName(name);
	}
	public boolean canHarvestBlock(Block par1Block)
	{
	         return par1Block == Block.snow ? true : par1Block == Block.blockSnow;
	}
}
