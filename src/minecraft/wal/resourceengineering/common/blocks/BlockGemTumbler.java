package resourceengineering.common.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import resourceengineering.common.ResourceEngineeringMain;
import resourceengineering.common.core.tileentity.GemTumblerTileEntity;
import resourceengineering.common.core.tileentity.PressureCookerTileEntity;

public class BlockGemTumbler extends BlockContainer
{
	Icon icons[];
	public BlockGemTumbler(int blockId)
	{
		super(blockId, Material.iron);
		setUnlocalizedName("blockTumbler");
		setCreativeTab(ResourceEngineeringMain.reTab);
		setHardness(1.0F);
		
	}
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		makeIcons(iconRegister);
	}
	public void makeIcons(IconRegister iconRegister)
	{
		icons = new Icon[6];
		icons[0] = iconRegister.registerIcon("resourceengineering:blockGemTumblerSide");//bottom
		icons[1] = iconRegister.registerIcon("resourceengineering:blockGemTumblerTop");//top
		icons[2] = iconRegister.registerIcon("resourceengineering:blockGemTumblerSide");//north
		icons[3] = iconRegister.registerIcon("resourceengineering:blockGemTumblerSide");//south
		icons[4] = iconRegister.registerIcon("resourceengineering:blockGemTumblerSide");//west
		icons[5] = iconRegister.registerIcon("resourceengineering:blockGemTumblerSide");//east
	}
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int i, int j)
    {
        if(i>=icons.length)
        {
        	return null;
        }
        else
        	return icons[i];
	}
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,EntityPlayer player, int i, float f, float g, float t) {
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
		if (tile_entity == null || player.isSneaking())
		{
			return false;
		}
		player.openGui(ResourceEngineeringMain.instance, 0, world, x, y, z);
		// Returns true to force an update
		return true;
	}
	@Override
	public void breakBlock(World world, int x, int y, int z, int i, int j) {
		// Calls a method that will created below, this method can be made up
		// here but it can be sometimes more readable if you do it this way
		dropItems(world, x, y, z);
		// Supering the breakBlock() method, this is so it performs the action
		super.breakBlock(world, x, y, z, i, j);
	}
	private void dropItems(World world, int x, int y, int z)
	{
		Random rand = new Random();

		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

		if (!(tile_entity instanceof IInventory)) {
			return;
		}

		IInventory inventory = (IInventory) tile_entity;

		for (int i = 0; i < inventory.getSizeInventory(); i++) {
			ItemStack item = inventory.getStackInSlot(i);

			if (item != null && item.stackSize > 0) 
			{

				EntityItem entity_item = new EntityItem(world, x, y, z, new ItemStack(item.itemID, item.stackSize, item.getItemDamage()));
				entity_item.delayBeforeCanPickup = 0;
				world.spawnEntityInWorld(entity_item);
				item.stackSize = 0;
			}
		}
	}
	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new GemTumblerTileEntity();
	}
	
}
