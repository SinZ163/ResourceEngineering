package resourceengineering.common.blocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import resourceengineering.common.ResourceEngineeringMain;
import resourceengineering.common.core.tileentity.GemTumblerTileEntity;
import resourceengineering.common.core.tileentity.PressureCookerTileEntity;

public class BlockGemTumbler extends BlockContainer
{
	public BlockGemTumbler(int blockId) {
		// Create the super constructer and give it the parms that it needs, I.E
		// if you want a texture
		// Give it a super(blockId, textureSpot, Material);
		super(blockId, Material.iron);
		setTextureFile("/walgfx/Blocks.png");
		// This part is optional and is required at some point, if you don't put
		// it here you will have to put it after you
		// Declare the block I.E public static final Block tutorialBlock = new
		// BlockTutorial(255).setBlockName("blockTutorial");
		setBlockName("blockTumbler");
		setCreativeTab(ResourceEngineeringMain.reTab);
		setHardness(1.0F);
		
	}
	public int getBlockTextureFromSideAndMetadata(int i,int j)
	{//j is meta, i is side
		switch(i)
		{
		case 0: return 65;//bottom
		case 1: return 64;//top
		case 2: return 65;//north
		case 3: return 65;//south
		case 4: return 65;//west
		case 5: return 65;//east
		default: return 240;
		}
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
