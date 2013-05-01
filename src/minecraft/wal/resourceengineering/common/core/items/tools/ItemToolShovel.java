package resourceengineering.common.core.items.tools;

import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;
import resourceengineering.common.ResourceEngineeringMain;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

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
	@Override
	public boolean onBlockDestroyed(ItemStack itemStack,World world,int id,int x,int y,int z,EntityLiving entityLiving)
	{
		//FMLLog.log(Level.INFO, "Shoveling normal ID: ", world.getBlockId(x, y, z));
		super.onBlockDestroyed(itemStack,world,id,x,y,z,entityLiving);
		return true;
	}
}
