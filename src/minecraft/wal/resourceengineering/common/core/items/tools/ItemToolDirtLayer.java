package resourceengineering.common.core.items.tools;

import java.util.ArrayList;
import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import resourceengineering.common.ResourceEngineeringMain;

public class ItemToolDirtLayer extends ItemTool
{
	private int targetBlockID = 3;
	public static final Block[] blocksEffectiveAgainst = Block.blocksList;
	public ItemToolDirtLayer(int ID, EnumToolMaterial m, int tex, String name)
	{
		super(ID, 1, m, blocksEffectiveAgainst);
		setTextureFile("/walgfx/Items.png");
		setIconIndex(tex);
		setItemName(name);
		this.setCreativeTab(ResourceEngineeringMain.reTab);
	}

	public boolean canHarvestBlock(Block par1Block)
	{
		return false;
	}
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
	{
		return 0.0F;
	}
	boolean isBlockReplaceable(int id)
	{
		switch(id)
		{
		case 0:
		case 8:
		case 9:
		case 10:
		case 11:
		case 31:
		case 37:
		case 38:
		case 39:
		case 40:
		case 50:
		case 51:
		case 78:
			return true;
		default:
			return false;
		}
	}
	private void dropItems(World world,int i,int y,int j,int x,int z)
	{
		if (!world.isRemote && world.getGameRules().getGameRuleBooleanValue("doTileDrops"))
	    {
			ArrayList list = Block.blocksList[world.getBlockId(i,y,j)].getBlockDropped(world,i,y,j,world.getBlockMetadata(i,y,j),0);
	    	if(list!=null)
	    	{
	    		for(int a=0;a<list.size();a++)
	    		{
	    			
	    			ItemStack temp = (ItemStack)list.get(a);
	    			EntityItem dropItem = new EntityItem(world,(double)(x),(double)(y),(double)(z),temp);
	    			dropItem.delayBeforeCanPickup=0;
	    			world.spawnEntityInWorld(dropItem);
	    		}
	    	}
	    	else
	    	{
	    		ItemStack dropStack = new ItemStack(Block.blocksList[world.getBlockId(i,y,j)].idDropped(world.getBlockMetadata(i,y,j), world.rand, 0),1,world.getBlockMetadata(i,y,j));
	    		EntityItem itemDrop = new EntityItem(world, (double)(x), (double)(y), (double)(z), dropStack);
	            itemDrop.delayBeforeCanPickup = 0;
	            world.spawnEntityInWorld(itemDrop);
	        }
	    }
    }
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int yIn, int z, int blockFace, float par8, float par9, float par10)
    {
		FMLLog.log(Level.INFO,"BlockFace: %s",blockFace);
		int offset = 2;//offset of 2 makes a 5x5 square
		int xStart,xEnd,yStart,yEnd,zStart,zEnd;
		boolean isSneaking = player.isSneaking();
		boolean isReplaceable = isBlockReplaceable(world.getBlockId(x,yIn,z));
		FMLLog.log(Level.INFO, "Sneaking: %s\nReplaceable: %s", isSneaking,isReplaceable);
		switch(blockFace)
		{
		case 0://Bottom of Block
			if(!isReplaceable && !isSneaking)
			{
				yIn-=2;
			}
		case 1://Top of Block
			if(!isReplaceable && !isSneaking)
			{
				yIn+=1;
			}
			xStart = x-offset;
			xEnd = x+offset;
			yStart = yIn;
			yEnd = yIn;
			zStart = z-offset;
			zEnd = z+offset;
			break;
		case 2://Z Sides
			if(!isReplaceable && !isSneaking)
			{
				z-=2;
			}
		case 3:
			if(!isReplaceable && !isSneaking)
			{
				z+=1;
			}
			xStart=x-offset;
			xEnd = x+offset;
			yStart=yIn-offset;
			yEnd=yIn+offset;
			zStart=z;
			zEnd = z;
			break;
		case 4://X Sides
			if(!isReplaceable && !isSneaking)
			{
				x-=2;
			}
		case 5:
			if(!isReplaceable && !isSneaking)
			{
				x+=1;
			}
		default:
			xStart = x;
			xEnd = x;
			yStart = yIn-offset;
			yEnd = yIn+offset;
			zStart = z-offset;
			zEnd = z+offset;
			break;
		}
		
		if(player.inventory.hasItem(3))
		{
			for(int i=xStart;i<=xEnd;i++)
			{
				for(int j=zStart;j<=zEnd;j++)
				{
					for(int y=yStart;y<=yEnd;y++)
					{
						if(world.isAirBlock(i, y, j))
						{
							if(player.inventory.consumeInventoryItem(3))
							{
								world.setBlock(i, y, j, 3);
							}
							else
							{
								return true;
							}
						}
						if(isBlockReplaceable(world.getBlockId(i,y,j)))
						{
							if(player.inventory.consumeInventoryItem(3))
							{
								dropItems(world,i,y,j,x,z);
								world.setBlock(i, y, j, 3);
							}
							else
							{
								return true;
							}
						}
					}
				}
			}
			return true;
		}
		else
		{
			return false;
		}
		
	}
	@Override
	public boolean onBlockDestroyed(ItemStack itemStack,World world,int id,int x,int y,int z,EntityLiving entityLiving)
	{
		return false;
	}
}
