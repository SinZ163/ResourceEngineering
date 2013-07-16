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

public class ItemToolPickaxeSuper extends ItemTool{
	private Icon icon;
	private String n;
	public static final Block[] blocksEffectiveAgainst = new Block[] {Block.cobblestone, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.blockIron, Block.oreCoal, Block.blockGold, Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis, Block.oreRedstone, Block.oreRedstoneGlowing, Block.rail, Block.railDetector, Block.railPowered};
	public ItemToolPickaxeSuper(int ID, EnumToolMaterial m, int tex, String name)
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
	         return par1Block == Block.obsidian ? this.toolMaterial.getHarvestLevel() == 3 : (par1Block != Block.blockDiamond && par1Block != Block.oreDiamond ? (par1Block != Block.oreEmerald && par1Block != Block.blockEmerald ? (par1Block != Block.blockGold && par1Block != Block.oreGold ? (par1Block != Block.blockIron && par1Block != Block.oreIron ? (par1Block != Block.blockLapis && par1Block != Block.oreLapis ? (par1Block != Block.oreRedstone && par1Block != Block.oreRedstoneGlowing ? (par1Block.blockMaterial == Material.rock ? true : (par1Block.blockMaterial == Material.iron ? true : par1Block.blockMaterial == Material.anvil)) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2);
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
		if(id == ResourceEngineeringMain.oreBlock.blockID)
		{
			//Starting by mining this mods ores by vein, will expand later
			//damage the pickaxe
			//itemStack.damageItem(1,entityLiving);
			//Loop over adjacent blocks recursively until vein is mined
			mineVein(x,y,z,id,world.getBlockMetadata(x,y,z),world,x,y,z,0,entityLiving,itemStack);
		}
		else if(id == Block.oreRedstone.blockID || id == Block.oreRedstoneGlowing.blockID)
		{
			mineVeinRedstone(x,y,z,world,x,y,z,0,entityLiving,itemStack);
		}
		else
		{
					
			for(int i=0;i<ResourceEngineeringMain.oreList.size();i++)
			{
				Block oreBlock = (Block)ResourceEngineeringMain.oreList.elementAt(i);
				if(id == oreBlock.blockID)
				{
					mineVein(x,y,z,id,world.getBlockMetadata(x,y,z),world,x,y,z,0,entityLiving,itemStack);
				}
			}
		}
		return true;
	}
	public boolean mineVeinRedstone(int x,int y,int z,World world,int xS,int yS,int zS,int recurCount,EntityLiving entityLiving,ItemStack itemStack)
	{
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
					if(world.getBlockId(x+i, y+j, z+k)==Block.oreRedstone.blockID || world.getBlockId(x+i,y+j,z+k) == Block.oreRedstoneGlowing.blockID)
					{
						//10 percent chance to not take durability hit per item mined
						if(world.rand.nextInt(100)>10)
						{
							itemStack.damageItem(1,entityLiving);
						}
						//drop block/item
						if (!world.isRemote && world.getGameRules().getGameRuleBooleanValue("doTileDrops"))
				        {
				            ItemStack dropStack;
				            dropStack = new ItemStack(Item.redstone,5);
				           
				            EntityItem itemDrop = new EntityItem(world, (double)(xS), (double)(yS), (double)(zS), dropStack);
				            itemDrop.delayBeforeCanPickup = 10;
				            world.spawnEntityInWorld(itemDrop);
				        }
						world.setBlockToAir((x+i),(y+j), (z+k));
						mineVeinRedstone((x+i),(y+j),(z+k),world,xS,yS,zS,recurCount+1,entityLiving,itemStack);
					}
				}
			}
		}
		return true;
	}
	public boolean mineVein(int x,int y,int z,int id,int meta, World world,int xS,int yS,int zS,int recurCount,EntityLiving entityLiving,ItemStack itemStack)
	{
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
					            	if(world.rand.nextInt(100)<=5)
					            	{
					            		EntityItem itemDrop = new EntityItem(world,(double)(xS),(double)(yS),(double)(zS),new ItemStack(ResourceEngineeringMain.flakeIron,1));
					            		itemDrop.delayBeforeCanPickup=0;
					            		world.spawnEntityInWorld(itemDrop);
					            	}
					            }
					            else if(id == Block.oreGold.blockID)
					            {
					            	if(world.rand.nextInt(100)<=5)
					            	{
					            		EntityItem itemDrop = new EntityItem(world,(double)(xS),(double)(yS),(double)(zS),new ItemStack(ResourceEngineeringMain.flakeGold,1));
					            		itemDrop.delayBeforeCanPickup=0;
					            		world.spawnEntityInWorld(itemDrop);
					            	}
					            }
					            else if(id == Block.oreDiamond.blockID)
					            {
					            	if(world.rand.nextInt(100)<=10)
					            	{
					            		EntityItem itemDrop = new EntityItem(world,(double)(xS),(double)(yS),(double)(zS),new ItemStack(ResourceEngineeringMain.diamondChip,1));
					            		itemDrop.delayBeforeCanPickup=0;
					            		world.spawnEntityInWorld(itemDrop);
					            	}
					            }
					            
					        }
							world.setBlockToAir((x+i),(y+j), (z+k));
							mineVein((x+i),(y+j),(z+k),id,meta,world,xS,yS,zS,recurCount+1,entityLiving,itemStack);
						}
					}
				}
			}
		}
		
		return true;
	}
}
