package resourceengineering.common.core.items.tools;

import java.util.ArrayList;
import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import resourceengineering.common.ResourceEngineeringMain;

public class ItemToolHammer extends ItemTool
{
	public static final Block[] blocksEffectiveAgainst = Block.blocksList;
	public ItemToolHammer(int ID, EnumToolMaterial m, int tex, String name)
	{
	         super(ID, 1, m, blocksEffectiveAgainst);
	         setTextureFile("/walgfx/Items.png");
	         setIconIndex(tex);
	         setItemName(name);
	         this.setCreativeTab(ResourceEngineeringMain.reTab);
	}

	public boolean canHarvestBlock(Block par1Block)
	{
	         return true;
	}
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
	{
	         return par2Block != null && (par2Block.blockMaterial == Material.iron || par2Block.blockMaterial == Material.anvil || par2Block.blockMaterial == Material.rock) ? this.efficiencyOnProperMaterial : super.getStrVsBlock(par1ItemStack, par2Block);
	}
	@Override
	public boolean onBlockDestroyed(ItemStack itemStack,World world,int id,int x,int y,int z,EntityLiving entityLiving)
	{
		if(ResourceEngineeringMain.oreList == null)
		{
			ResourceEngineeringMain.scanModOres();
		}
		mineVein(x,y,z,id,world.getBlockMetadata(x,y,z),world,x,y,z,entityLiving,itemStack);
		return true;
	}
	private boolean isInOreList(int id)
	{
		for(int i=0;i<ResourceEngineeringMain.oreList.size();i++)
		{
			Block oreBlock = (Block)ResourceEngineeringMain.oreList.elementAt(i);
			if(id == oreBlock.blockID)
			{
				//FMLLog.log(Level.INFO,"ID %s was found in the ore list",id);
				return true;
			}
		}
		if(id == ResourceEngineeringMain.oreBlock.blockID || id == Block.oreRedstone.blockID || id == Block.oreRedstoneGlowing.blockID)
		{
			//FMLLog.log(Level.INFO,"ID %s was found in the ore list",id);
			return true;
		}
		return false;
	}
	public boolean mineVein(int x,int y,int z,int id,int meta, World world,int xS,int yS,int zS,EntityLiving entityLiving,ItemStack itemStack)
	{
		//loop  over x axis
		for(int i=-2;i<=2;i++)
		{
			//loop over y axis
			for(int j=-2;j<=2;j++)
			{
				//loop over z axis
				for(int k=-2;k<=2;k++)
				{
					if(world.rand.nextInt(100)<10)
					{
						itemStack.damageItem(1,entityLiving);
					}
					//drop block/item
					if (!world.isRemote && world.getGameRules().getGameRuleBooleanValue("doTileDrops"))
			        {
			            //ItemStack dropStack;
		            	//Drop the ore block of whatever type it is since we havent matched it to a specific ore/drop
			            if(world.getBlockId(x+i,y+j,z+k)==Block.bedrock.blockID || world.getBlockId(x+i,y+j,z+k)==0)
			            {
			            	//FMLLog.log(Level.INFO, "Bedrock hit, not mining");
			            }
			            else if(isInOreList(world.getBlockId(x+i,y+j,z+k)))
			            {
			            	//FMLLog.log(Level.INFO, "Mining a vein at %s X, %s Y, %s Z with ID %s",x+i,y+j,z+k,id);
			            	mineOreVein(x+i,y+j,z+k,world.getBlockId(x+i,y+j,z+k),world.getBlockMetadata(x+i,y+j,z+k),world,xS,yS,zS,entityLiving,itemStack,0);
			            }
			            else
			            {
			            	//FMLLog.log(Level.INFO, "Attempting to mine block ID: %s with Meta: %s", world.getBlockId(x+i,y+j,z+k),world.getBlockMetadata(x+i,y+j,z+k));
			            	if(Block.blocksList[world.getBlockId(x+i, y+j, z+k)] != null)
				            {
			            		//FMLLog.log(Level.INFO,"Found block in block list");
			            		ArrayList list = Block.blocksList[world.getBlockId(x+i,y+j,z+k)].getBlockDropped(world,x+i,y+j,z+k,world.getBlockMetadata(x+i,y+j,z+k),0);
				            	if(list!=null)
				            	{
				            		//FMLLog.log(Level.INFO, "ArrayList returned not null for block ID: %s", world.getBlockId(x+i,y+j,z+k));
				            		for(int a=0;a<list.size();a++)
				            		{
				            			
				            			ItemStack temp = (ItemStack)list.get(a);
				            			//FMLLog.log(Level.INFO, "ArrayList index %s returning item stack: %s", a,temp.toString());
				            			EntityItem dropItem = new EntityItem(world,(double)(xS),(double)(yS),(double)(zS),temp);
				            			dropItem.delayBeforeCanPickup=0;
				            			world.spawnEntityInWorld(dropItem);
				            		}
				            	}
				            	else
				            	{
				            		//FMLLog.log(Level.INFO, "ArrayList returned null for block ID: %s, trying idDropped", world.getBlockId(x+i,y+j,z+k));
				            		ItemStack dropStack = new ItemStack(Block.blocksList[world.getBlockId(x+i, y+j, z+k)].idDropped(world.getBlockMetadata(x+i,y+j,z+k), world.rand, 0),1,world.getBlockMetadata(x+i, y+j, z+k));
				            		EntityItem itemDrop = new EntityItem(world, (double)(xS), (double)(yS), (double)(zS), dropStack);
						            itemDrop.delayBeforeCanPickup = 0;
						            world.spawnEntityInWorld(itemDrop);
						        }
					        }
				            else
				            {
				            	ItemStack dropStack = new ItemStack(world.getBlockId(x+i,y+j,z+k),1,world.getBlockMetadata(x+i,y+j,z+k));
				            	EntityItem itemDrop = new EntityItem(world, (double)(xS), (double)(yS), (double)(zS), dropStack);
					            itemDrop.delayBeforeCanPickup = 0;
					            world.spawnEntityInWorld(itemDrop);
					        }
			            	world.setBlockWithNotify((x+i),(y+j), (z+k), 0);
			            }
			        }
				}
			}
		}
		return true;
	}
	public boolean mineOreVein(int x,int y,int z,int id,int meta, World world,int xS,int yS,int zS,EntityLiving entityLiving,ItemStack itemStack,int recurCount)
	{
		//FMLLog.log(Level.INFO, "Recur Count: %s", recurCount);
		if(recurCount>=10)
		{
			return false;
		}
		//loop  over x axis
		for(int i=-1;i<=1;i++)
		{
			//loop over y axis
			for(int j=-1;j<=1;j++)
			{
				//loop over z axis
				for(int k=-1;k<=1;k++)
				{
					//check if block is the same as the mined block id
					if(world.getBlockId(x+i, y+j, z+k)==id)
					{
						
						//if ids match, check metadata
						if(world.getBlockMetadata(x+i,y+j,z+k)==meta)
						{
							//10 percent chance to not take durability hit per item mined
							if(world.rand.nextInt(100)>10)
							{
								itemStack.damageItem(1,entityLiving);
							}
							
							//drop block/item
							if (!world.isRemote && world.getGameRules().getGameRuleBooleanValue("doTileDrops"))
					        {
					            if(Block.blocksList[world.getBlockId(x+i,y+j,z+k)]!=null)
					            {
					            	ArrayList list = Block.blocksList[world.getBlockId(x+i,y+j,z+k)].getBlockDropped(world,x+i,y+j,z+k,meta,0);
					            	if(list!=null)
					            	{
					            		//FMLLog.log(Level.INFO, "ArrayList returned not null for block ID: %s", world.getBlockId(x+i,y+j,z+k));
					            		for(int a=0;a<list.size();a++)
					            		{
					            			
					            			ItemStack temp = (ItemStack)list.get(a);
					            			//FMLLog.log(Level.INFO, "ArrayList index %s returning item stack: %s", a,temp.toString());
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
					            else
					            {
					            	ItemStack dropStack = new ItemStack(id,1,meta);
					            	EntityItem itemDrop = new EntityItem(world, (double)(xS), (double)(yS), (double)(zS), dropStack);
						            itemDrop.delayBeforeCanPickup = 0;
						            world.spawnEntityInWorld(itemDrop);
					            }
					            if(id == Block.oreIron.blockID)
					            {
					            	if(world.rand.nextInt(100)<=15)
					            	{
					            		EntityItem itemDrop = new EntityItem(world,(double)(xS),(double)(yS),(double)(zS),new ItemStack(ResourceEngineeringMain.flakeIron,1));
					            		itemDrop.delayBeforeCanPickup=0;
					            		world.spawnEntityInWorld(itemDrop);
					            	}
					            }
					            else if(id == Block.oreGold.blockID)
					            {
					            	if(world.rand.nextInt(100)<=13)
					            	{
					            		EntityItem itemDrop = new EntityItem(world,(double)(xS),(double)(yS),(double)(zS),new ItemStack(ResourceEngineeringMain.flakeGold,1));
					            		itemDrop.delayBeforeCanPickup=0;
					            		world.spawnEntityInWorld(itemDrop);
					            	}
					            }
					            else if(id == Block.oreDiamond.blockID)
					            {
					            	if(world.rand.nextInt(100)<=25)
					            	{
					            		EntityItem itemDrop = new EntityItem(world,(double)(xS),(double)(yS),(double)(zS),new ItemStack(ResourceEngineeringMain.diamondChip,1));
					            		itemDrop.delayBeforeCanPickup=0;
					            		world.spawnEntityInWorld(itemDrop);
					            	}
					            }
					            
					        }
							world.setBlockWithNotify((x+i),(y+j), (z+k), 0);
							mineOreVein((x+i),(y+j),(z+k),id,meta,world,xS,yS,zS,entityLiving,itemStack,recurCount+1);
						}
					}
				}
			}
		}
		
		return true;
	}
}
