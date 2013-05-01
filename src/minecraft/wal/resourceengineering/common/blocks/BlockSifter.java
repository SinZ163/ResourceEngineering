package resourceengineering.common.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import resourceengineering.common.ResourceEngineeringMain;
import resourceengineering.common.core.tileentity.SifterTileEntity;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSifter extends BlockContainer
{
	public BlockSifter(int id)
	{
		super(id,Material.iron);
		setCreativeTab(ResourceEngineeringMain.reTab);setTextureFile("/walgfx/Blocks.png");
		setBlockName("wal_BlockSifter");
		setHardness(2.0F);
		setResistance(10.0F);
	}
	public int getBlockTextureFromSideAndMetadata(int i,int j)
	{
		switch(i)
		{
		case 0: return 50;
		case 1: return 48;
		case 2: return 49;
		case 3: return 49;
		case 4: return 49;
		case 5: return 49;
		default: return 0;
		}
	}
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,EntityPlayer player, int i, float f, float g, float t)
	{
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
		if (tile_entity == null || player.isSneaking())
		{
			return false;
		}
		player.openGui(ResourceEngineeringMain.instance, 1, world, x, y, z);
		// Returns true to force an update
		return true;
	}
	@Override
	public void breakBlock(World world, int x, int y, int z, int i, int j)
	{
		dropItems(world, x, y, z);
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
		return new SifterTileEntity();
	}
}
