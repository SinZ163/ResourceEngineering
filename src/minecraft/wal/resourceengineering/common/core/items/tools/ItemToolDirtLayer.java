package resourceengineering.common.core.items.tools;

import java.util.ArrayList;
import java.util.logging.Level;

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
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int blockFace, float par8, float par9, float par10)
    {
		if(isBlockReplaceable(world.getBlockId(x,y,z)))
		{
			y-=1;
		}
		if(player.inventory.hasItem(3))
		{
			for(int i=(x-2);i<=(x+2);i++)
			{
				for(int j=(z-2);j<=(z+2);j++)
				{
					if(world.isAirBlock(i, y+1, j))
					{
						if(player.inventory.consumeInventoryItem(3))
						{
							world.setBlock(i, y+1, j, 3);
						}
						else
						{
							return true;
						}
					}
					if(isBlockReplaceable(world.getBlockId(i,y+1,j)))
					{
						if(player.inventory.consumeInventoryItem(3))
						{
							if (!world.isRemote && world.getGameRules().getGameRuleBooleanValue("doTileDrops"))
					        {
								ArrayList list = Block.blocksList[world.getBlockId(i,y+1,j)].getBlockDropped(world,i,y+1,j,world.getBlockMetadata(i,y+1,j),0);
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
				            		ItemStack dropStack = new ItemStack(Block.blocksList[world.getBlockId(i,y+1,j)].idDropped(world.getBlockMetadata(i,y+1,j), world.rand, 0),1,world.getBlockMetadata(i,y+1,j));
				            		EntityItem itemDrop = new EntityItem(world, (double)(x), (double)(y), (double)(z), dropStack);
						            itemDrop.delayBeforeCanPickup = 0;
						            world.spawnEntityInWorld(itemDrop);
						        }
					        }
							world.setBlock(i, y+1, j, 3);
						}
						else
						{
							return true;
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