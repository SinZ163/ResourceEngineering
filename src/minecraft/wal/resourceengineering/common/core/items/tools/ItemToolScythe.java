package resourceengineering.common.core.items.tools;

import java.util.ArrayList;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import resourceengineering.common.ResourceEngineeringMain;

public class ItemToolScythe extends ItemTool
{
	private Icon icon;
	private String n;
	public static final Block[] blocksEffectiveAgainst = Block.blocksList;
	public ItemToolScythe(int ID, EnumToolMaterial m, String name)
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
		return isPlant(par1Block.blockID);
	}
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
	{
		return 1.0F;
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
	private boolean isPlant(int id)
	{
		if(ResourceEngineeringMain.plantList == null)
		{
			ResourceEngineeringMain.scanModPlants();
		}
		for(int i=0;i<ResourceEngineeringMain.plantList.size();i++)
		{
			Block plantBlock = (Block)ResourceEngineeringMain.plantList.elementAt(i);
			if(id == plantBlock.blockID)
			{
				return true;
			}
		}
		return false;
		
	}
	@Override
	public boolean onBlockDestroyed(ItemStack itemStack,World world,int id,int xIn,int yIn,int zIn,EntityLiving entityLiving)
	{
		if(isPlant(world.getBlockId(xIn, yIn, zIn)))
		{
			for(int x=xIn-3;x<xIn+3;x++)
			{
				for(int z=zIn-3;z<zIn+3;z++)
				{
					if(isPlant(world.getBlockId(x,yIn,z)))
					{
						if(world.rand.nextInt(3)==1)
						{
							itemStack.damageItem(1,entityLiving);
						}
						dropItems(world,x,yIn,z,xIn,zIn);
						world.setBlockToAir(x,yIn,z);
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
}
