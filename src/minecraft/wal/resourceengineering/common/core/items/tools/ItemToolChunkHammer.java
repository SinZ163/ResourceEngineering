package resourceengineering.common.core.items.tools;

import java.util.ArrayList;
import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import resourceengineering.common.ResourceEngineeringMain;

public class ItemToolChunkHammer extends ItemTool
{
	private Icon icon;
	private String n;
	public static final Block[] blocksEffectiveAgainst = Block.blocksList;
	public ItemToolChunkHammer(int ID, EnumToolMaterial m, int tex, String name)
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
	         return true;
	}
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
	{
	         return par2Block != null && (par2Block.blockMaterial == Material.iron || par2Block.blockMaterial == Material.anvil || par2Block.blockMaterial == Material.rock) ? this.efficiencyOnProperMaterial : super.getStrVsBlock(par1ItemStack, par2Block);
	}
	int roundDown(int n, int m) {
	    return n >= 0 ? (n / m) * m : ((n - m + 1) / m) * m;
	}
	@Override
	public boolean onBlockDestroyed(ItemStack itemStack,World world,int id,int x,int y,int z,EntityLiving entityLiving)
	{
		if(ResourceEngineeringMain.oreList == null)
		{
			ResourceEngineeringMain.scanModOres();
		}
		int chunkX = roundDown(x,16);
		int chunkZ = roundDown(z,16);
		FMLLog.log(Level.INFO,"ChunkX: %s, ChunkZ: %s",chunkX,chunkZ);
		//loop  over x axis
		for(int i=chunkX;i<=chunkX+16;i++)
		{
			//loop over y axis
			for(int j=1;j<=256;j++)
			{
				//loop over z axis
				for(int k=chunkZ;k<=chunkZ+16;k++)
				{
					//drop block/item
					if (!world.isRemote && world.getGameRules().getGameRuleBooleanValue("doTileDrops"))
			        {
			            //ItemStack dropStack;
		            	//Drop the ore block of whatever type it is since we havent matched it to a specific ore/drop
			            if(world.getBlockId(i,j,k)==Block.bedrock.blockID || world.getBlockId(i,j,k)==0)
			            {
			            	
			            }
			            else if(isInOreList(world.getBlockId(i,j,k)))
			            {
			               	//FMLLog.log(Level.INFO, "Attempting to mine block ID: %s with Meta: %s", world.getBlockId(i,j,k),world.getBlockMetadata(i,j,k));
			            	if(Block.blocksList[world.getBlockId(i,j,k)] != null)
				            {
			            		//FMLLog.log(Level.INFO,"Found block in block list");
			            		ArrayList list = Block.blocksList[world.getBlockId(i,j,k)].getBlockDropped(world,i,j,k,world.getBlockMetadata(i,j,k),0);
				            	if(list!=null)
				            	{
				            		//FMLLog.log(Level.INFO, "ArrayList returned not null for block ID: %s", world.getBlockId(x+i,y+j,z+k));
				            		for(int a=0;a<list.size();a++)
				            		{
				            			
				            			ItemStack temp = (ItemStack)list.get(a);
				            			//FMLLog.log(Level.INFO, "ArrayList index %s returning item stack: %s", a,temp.toString());
				            			EntityItem dropItem = new EntityItem(world,(double)(x),(double)(y),(double)(z),temp);
				            			dropItem.delayBeforeCanPickup=0;
				            			world.spawnEntityInWorld(dropItem);
				            		}
				            	}
				            	else
				            	{
				            		//FMLLog.log(Level.INFO, "ArrayList returned null for block ID: %s, trying idDropped", world.getBlockId(x+i,y+j,z+k));
				            		ItemStack dropStack = new ItemStack(Block.blocksList[world.getBlockId(i,j,k)].idDropped(world.getBlockMetadata(i,j,k), world.rand, 0),1,world.getBlockMetadata(i,j,k));
				            		EntityItem itemDrop = new EntityItem(world, (double)(x), (double)(y), (double)(z), dropStack);
						            itemDrop.delayBeforeCanPickup = 0;
						            world.spawnEntityInWorld(itemDrop);
						        }
					        }
				            else
				            {
				            	ItemStack dropStack = new ItemStack(world.getBlockId(i,j,k),1,world.getBlockMetadata(i,j,k));
				            	EntityItem itemDrop = new EntityItem(world, (double)(x), (double)(y), (double)(z), dropStack);
					            itemDrop.delayBeforeCanPickup = 0;
					            world.spawnEntityInWorld(itemDrop);
					        }
			            	world.setBlockToAir(i, j, k);
			            	if(world.rand.nextInt(10)<3)
							{
								itemStack.damageItem(1,entityLiving);
							}
			            }
			        }
				}
			}
		}
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

}
