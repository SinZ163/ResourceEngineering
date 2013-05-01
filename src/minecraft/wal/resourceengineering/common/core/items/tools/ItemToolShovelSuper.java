package resourceengineering.common.core.items.tools;

import java.util.ArrayList;
import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSnow;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import resourceengineering.common.ResourceEngineeringMain;

public class ItemToolShovelSuper extends ItemTool
{
	public static final Block[] blocksEffectiveAgainst = new Block[] {Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium};
	public ItemToolShovelSuper(int ID, EnumToolMaterial m, int tex, String name)
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
		if(id == Block.slowSand.blockID || id == Block.sand.blockID || id == Block.dirt.blockID ||id == Block.gravel.blockID || id == Block.blockClay.blockID || id == Block.grass.blockID || id == Block.mycelium.blockID || id==Block.blockSnow.blockID || id == Block.snow.blockID)
		{
			mineVein(x,y,z,id,world.getBlockMetadata(x,y,z),world,x,y,z,0,entityLiving,itemStack);
		}
		return true;
	}
	public boolean mineVein(int x,int y,int z,int id,int meta, World world,int xS,int yS,int zS,int recurCount,EntityLiving entityLiving,ItemStack itemStack)
	{
		if(recurCount>=7)
		{
			return false;
		}
		for(int i=-1;i<=1;i++)
		{
			for(int j=-1;j<=1;j++)
			{
				for(int k=-1;k<=1;k++)
				{
					if(world.getBlockId(x+i, y+j, z+k)==id)
					{
						//10 percent chance to not take durability hit per item mined
						if(world.rand.nextInt(100)>10)
						{
							itemStack.damageItem(1,entityLiving);
						}
						//drop block/item
						if (!world.isRemote && world.getGameRules().getGameRuleBooleanValue("doTileDrops"))
				        {
							ArrayList list = Block.blocksList[world.getBlockId(x+i,y+j,z+k)].getBlockDropped(world,x+i,y+j,z+k,meta,0);
			            	if(list!=null)
			            	{
			            		for(int a=0;a<list.size();a++)
			            		{
			            			
			            			ItemStack temp = (ItemStack)list.get(a);
			            			EntityItem dropItem = new EntityItem(world,(double)(xS),(double)(yS),(double)(zS),temp);
			            			dropItem.delayBeforeCanPickup=0;
			            			world.spawnEntityInWorld(dropItem);
			            		}
			            	}
			            	else
			            	{
			            		ItemStack dropStack = new ItemStack(Block.blocksList[world.getBlockId(x+i, y+j, z+k)].idDropped(world.getBlockMetadata(x+i,y+j,z+k), world.rand, 0),1,world.getBlockMetadata(x+i, y+j, z+k));
			            		EntityItem itemDrop = new EntityItem(world, (double)(xS), (double)(yS), (double)(zS), dropStack);
					            itemDrop.delayBeforeCanPickup = 0;
					            world.spawnEntityInWorld(itemDrop);
					        }
				        }
						world.setBlockWithNotify((x+i),(y+j), (z+k), 0);
						mineVein((x+i),(y+j),(z+k),id,meta,world,xS,yS,zS,recurCount+1,entityLiving,itemStack);
					}
				}
			}
		}
		return true;
	}
}
