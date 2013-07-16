package resourceengineering.common.core.items.tools;

import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import resourceengineering.common.ResourceEngineeringMain;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ItemToolShovel extends ItemTool
{
	private Icon icon;
	private String n;
	public static final Block[] blocksEffectiveAgainst = new Block[] {Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium};
	public ItemToolShovel(int ID, EnumToolMaterial m, int tex, String name)
	{
	         super(ID, 1, m, blocksEffectiveAgainst);
	         setUnlocalizedName(name);
	         n=name;
	         this.setCreativeTab(ResourceEngineeringMain.reTab);
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
