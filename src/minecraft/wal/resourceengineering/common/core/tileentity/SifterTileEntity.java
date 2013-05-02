package resourceengineering.common.core.tileentity;

import cpw.mods.fml.common.FMLLog;
import resourceengineering.common.ResourceEngineeringMain;
import resourceengineering.common.core.RecipesPressureCooker;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ISidedInventory;

public class SifterTileEntity extends TileEntity implements ISidedInventory
{
	private ItemStack[] inventory;
	public int processTime;
	boolean isActive;
	public SifterTileEntity()
	{
		inventory = new ItemStack[17];
		isActive = false;
	}
	@Override
	public int getSizeInventory()
	{
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int i)
	{
		return inventory[i];
	}

	@Override
	public ItemStack decrStackSize(int slotIndex, int amount) {
		// This gets the stack with the slot number you want
		ItemStack stack = getStackInSlot(slotIndex);

		// Then it checks to make sure it has something in it
		if (stack != null) {
			// Then it checks to make sure that it has something that is equal
			// or lesser than the amount you want to add
			if (stack.stackSize <= amount) {
				setInventorySlotContents(slotIndex, null);
			} else {
				stack = stack.splitStack(amount);
				if (stack.stackSize == 0) {
					setInventorySlotContents(slotIndex, null);
				}
			}
		}

		// Then it returns the stack
		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slotIndex) {
		// This gets the stack in the slot you chose
		ItemStack stack = getStackInSlot(slotIndex);

		// This checks to make sure it has something in it
		if (stack != null) {
			setInventorySlotContents(slotIndex, null);
		}

		// Then it returns the stack
		return stack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		inventory[slot] = stack;
		// This checks to make sure the stack is not nothing, and then makes
		// sure the stack is not going over the limit
		// Of the stack
		if (stack != null && stack.stackSize > getInventoryStackLimit()) {
			stack.stackSize = getInventoryStackLimit();
		}
	}

	@Override
	public String getInvName() {
		return "SifterTileEntity";
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer)
	{
		if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this) {
			return false;
		}

		return entityplayer.getDistanceSq((double) xCoord + 0.5D,
				(double) yCoord + 0.5D, (double) zCoord + 0.5D) <= 64D;
	}

	@Override
	public void openChest()
	{
		
	}

	@Override
	public void closeChest()
	{
		
	}

	
	public boolean isStackValidForSlot(int i, ItemStack itemstack)
	{
		
		if(i==0)
		{
			if(itemstack.itemID == Block.gravel.blockID)
			{
				return true;
			}
			if(itemstack.itemID == Block.sand.blockID)
			{
				return true;
			}
			if(itemstack.itemID == Block.dirt.blockID)
			{
				return true;
			}
			if(itemstack.itemID==ResourceEngineeringMain.oreBlock.blockID && itemstack.getItemDamage()>6)
			{
				return true;
			}
			return false;
		}
		else
		{
			return false;
		}
	}
	public int getSiftProgressScaled(int i)
	{
		return (processTime * i) / 60;
	}
	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);
		
		this.processTime = tagCompound.getShort("ProcessTime");

		NBTTagList tagList = tagCompound.getTagList("Inventory");

		for (int i = 0; i < tagList.tagCount(); i++) {
			NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);

			byte slot = tag.getByte("Slot");

			if (slot >= 0 && slot < inventory.length) {
				inventory[slot] = ItemStack.loadItemStackFromNBT(tag);
			}
		}
	}

	// Same as the later
	@Override
	public void writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);

		NBTTagList itemList = new NBTTagList();
		
		tagCompound.setShort("ProcessTime",(short)this.processTime);
		
		for (int i = 0; i < inventory.length; i++) {
			ItemStack stack = inventory[i];

			if (stack != null) {
				NBTTagCompound tag = new NBTTagCompound();

				tag.setByte("Slot", (byte) i);
				stack.writeToNBT(tag);
				itemList.appendTag(tag);
			}
		}
		tagCompound.setTag("Inventory", itemList);
	}
	public boolean canSift()
	{
		ItemStack itemstack = getStackInSlot(0);
		if(itemstack!=null)
		{
			if(itemstack.itemID == Block.gravel.blockID)
			{
				return true;
			}
			if(itemstack.itemID == Block.sand.blockID)
			{
				return true;
			}
			if(itemstack.itemID == Block.dirt.blockID)
			{
				return true;
			}
			if(itemstack.itemID==ResourceEngineeringMain.oreBlock.blockID && itemstack.getItemDamage()>6)
			{
				return true;
			}
			return false;
		}
		return false;
	}
	public boolean isSifting()
	{
		if(processTime>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean findMatchingSlotAndAddItem(ItemStack item,boolean isRecurring)
	{
		int stackSize = getInventoryStackLimit();
		for(int i=1;i<inventory.length;i++)
		{
			if(this.inventory[i]!=null)
			{
				if(this.inventory[i].itemID == item.itemID)
				{
					if(this.inventory[i].stackSize+item.stackSize <= stackSize)
					{
						this.inventory[i].stackSize+=item.stackSize;
						return true;
					}
					else
					{
						int diff = (this.inventory[i].stackSize+item.stackSize) - stackSize;
						this.inventory[i].stackSize = stackSize;
						item.stackSize = diff;
						if(isRecurring)
						{
							continue;
						}
						else
						{
							if(findMatchingSlotAndAddItem(item,true))
							{
								return true;
							}
							else
							{
								for(int a=1;a<inventory.length;a++)
								{
									if(this.inventory[a]==null)
									{
										this.inventory[a] = item;
										return true;
									}
								}
								return false;
							}
						}
					}
				}
			}
		}
		for(int i=1;i<inventory.length;i++)
		{
			if(this.inventory[i]==null)
			{
				this.inventory[i]=item;
				return true;
			}
		}
		return false;
	}
	public int getChance()
	{
		return this.worldObj.rand.nextInt(10000);
	}
	public void siftItem()
	{
		if (this.canSift())
		{
			//Sifting Dirt
			if(getStackInSlot(0).itemID == Block.dirt.blockID)
			{
				//Iron Flake
				if(getChance()<800)
				{
					findMatchingSlotAndAddItem(new ItemStack(ResourceEngineeringMain.flakeIron, 1),false);
				}
				//Gold Flake
				if(getChance()<500)
				{
					findMatchingSlotAndAddItem(new ItemStack(ResourceEngineeringMain.flakeGold,1), false);
				}
				//Diamond Chip
				if(getChance()<50)
				{
					findMatchingSlotAndAddItem(new ItemStack(ResourceEngineeringMain.diamondChip,1), false);
				}
				//Iron Nugget
				if(getChance()<80)
				{
					findMatchingSlotAndAddItem(new ItemStack(ResourceEngineeringMain.nugget,1,0), false);
				}
				//Gold Nugget
				if(getChance()<100)
				{
					findMatchingSlotAndAddItem(new ItemStack(Item.goldNugget,1), false);
				}
				//Sifted Dirt(sand for now)
				findMatchingSlotAndAddItem(new ItemStack(Block.sand,1), false);
			}
			//Sifting Sand
			else if(getStackInSlot(0).itemID == Block.sand.blockID)
			{
				//Iron Flake
				if(getChance()<800)
				{
					findMatchingSlotAndAddItem(new ItemStack(ResourceEngineeringMain.flakeIron, 1),false);
				}
				//Gold Flake
				if(getChance()<500)
				{
					findMatchingSlotAndAddItem(new ItemStack(ResourceEngineeringMain.flakeGold,1), false);
				}
				//Diamond Chip
				if(getChance()<50)
				{
					findMatchingSlotAndAddItem(new ItemStack(ResourceEngineeringMain.diamondChip,1), false);
				}
				//Iron Nugget
				if(getChance()<100)
				{
					findMatchingSlotAndAddItem(new ItemStack(ResourceEngineeringMain.nugget,1,0), false);
				}
				//Gold Nugget
				if(getChance()<500)
				{
					findMatchingSlotAndAddItem(new ItemStack(Item.goldNugget,1), false);
				}
			}
			//Sifting Gravel
			else if(getStackInSlot(0).itemID == Block.gravel.blockID)
			{
				//Iron Flake
				if(getChance()<800)
				{
					findMatchingSlotAndAddItem(new ItemStack(ResourceEngineeringMain.flakeIron, 1),false);
				}
				//Gold Flake
				if(getChance()<500)
				{
					findMatchingSlotAndAddItem(new ItemStack(ResourceEngineeringMain.flakeGold,1), false);
				}
				//Diamond Chip
				if(getChance()<80)
				{
					findMatchingSlotAndAddItem(new ItemStack(ResourceEngineeringMain.diamondChip,1), false);
				}
				//Iron Nugget
				if(getChance()<50)
				{
					findMatchingSlotAndAddItem(new ItemStack(ResourceEngineeringMain.nugget,1,0), false);
				}
				//Gold Nugget
				if(getChance()<30)
				{
					findMatchingSlotAndAddItem(new ItemStack(Item.goldNugget,1), false);
				}
				//Diamond
				if(getChance()<5)
				{
					findMatchingSlotAndAddItem(new ItemStack(Item.diamond, 1),false);
				}
				//Flint
				if(getChance()<2000)
				{
					findMatchingSlotAndAddItem(new ItemStack(Item.flint,1), false);
				}
				//Dirt or sand
				if(getChance()%2==1)
				{
					findMatchingSlotAndAddItem(new ItemStack(Block.dirt,1),false);
				}
				else
				{
					findMatchingSlotAndAddItem(new ItemStack(Block.sand,1), false);
				}
			}
			//Loaded Dirt
			else if(getStackInSlot(0).itemID==ResourceEngineeringMain.oreBlock.blockID && getStackInSlot(0).getItemDamage()==7)
			{
				//Iron Flake
				if(getChance()<5000)
				{
					findMatchingSlotAndAddItem(new ItemStack(ResourceEngineeringMain.flakeIron, 1),false);
				}
				//Gold Flake
				if(getChance()<3000)
				{
					findMatchingSlotAndAddItem(new ItemStack(ResourceEngineeringMain.flakeGold,1), false);
				}
				//Diamond Chip
				if(getChance()<900)
				{
					findMatchingSlotAndAddItem(new ItemStack(ResourceEngineeringMain.diamondChip,1), false);
				}
				//Iron Nugget
				if(getChance()<1000)
				{
					findMatchingSlotAndAddItem(new ItemStack(ResourceEngineeringMain.nugget,1,0), false);
				}
				//Gold Nugget
				if(getChance()<900)
				{
					findMatchingSlotAndAddItem(new ItemStack(Item.goldNugget,1), false);
				}
				//Sifted Dirt(sand for now)
				findMatchingSlotAndAddItem(new ItemStack(Block.sand,1), false);
			}
			//Loaded Sand
			else if(getStackInSlot(0).itemID==ResourceEngineeringMain.oreBlock.blockID && getStackInSlot(0).getItemDamage()==8)
			{
				//Iron Flake
				if(getChance()<4000)
				{
					findMatchingSlotAndAddItem(new ItemStack(ResourceEngineeringMain.flakeIron, 1),false);
				}
				//Gold Flake
				if(getChance()<8000)
				{
					findMatchingSlotAndAddItem(new ItemStack(ResourceEngineeringMain.flakeGold,1), false);
				}
				//Diamond Chip
				if(getChance()<800)
				{
					findMatchingSlotAndAddItem(new ItemStack(ResourceEngineeringMain.diamondChip,1), false);
				}
				//Iron Nugget
				if(getChance()<1000)
				{
					findMatchingSlotAndAddItem(new ItemStack(ResourceEngineeringMain.nugget,1,0), false);
				}
				//Gold Nugget
				if(getChance()<2000)
				{
					findMatchingSlotAndAddItem(new ItemStack(Item.goldNugget,1), false);
				}
			}
			//Loaded Gravel
			else if(getStackInSlot(0).itemID==ResourceEngineeringMain.oreBlock.blockID && getStackInSlot(0).getItemDamage()==9)
			{
				//Iron Flake
				if(getChance()<5000)
				{
					findMatchingSlotAndAddItem(new ItemStack(ResourceEngineeringMain.flakeIron, 1),false);
				}
				//Gold Flake
				if(getChance()<4500)
				{
					findMatchingSlotAndAddItem(new ItemStack(ResourceEngineeringMain.flakeGold,1), false);
				}
				//Diamond Chip
				if(getChance()<1000)
				{
					findMatchingSlotAndAddItem(new ItemStack(ResourceEngineeringMain.diamondChip,1), false);
				}
				//Iron Nugget
				if(getChance()<800)
				{
					findMatchingSlotAndAddItem(new ItemStack(ResourceEngineeringMain.nugget,1,0), false);
				}
				//Gold Nugget
				if(getChance()<500)
				{
					findMatchingSlotAndAddItem(new ItemStack(Item.goldNugget,1), false);
				}
				//Diamond
				if(getChance()<300)
				{
					findMatchingSlotAndAddItem(new ItemStack(Item.diamond, 1),false);
				}
				//Flint
				if(getChance()<2000)
				{
					findMatchingSlotAndAddItem(new ItemStack(Item.flint,1), false);
				}
				//Dirt or sand
				if(getChance()%2==1)
				{
					findMatchingSlotAndAddItem(new ItemStack(Block.dirt,1),false);
				}
				else
				{
					findMatchingSlotAndAddItem(new ItemStack(Block.sand,1), false);
				}
			}

			this.inventory[0].stackSize--;
			if (this.inventory[0].stackSize == 0)
			{
				Item var2 = this.inventory[0].getItem().getContainerItem();
				this.inventory[0] = var2 == null ? null : new ItemStack(var2);
			}
		}
	}
	public void updateEntity()
	{
		boolean var1 = processTime>0;
		boolean var2 = false;
		if (!this.worldObj.isRemote)
		{
			if (this.processTime == 0 && this.canSift())
			{
				//System.out.println("ProcessTime == 0 and canSift == true");
				var2 = true;
				processTime++;
			}
			else if (this.isSifting() && this.canSift())
			{
				++this.processTime;
				if (this.processTime == 60)
				{
					this.processTime = 0;
					this.siftItem();
					var2 = true;
				}
			}
			else
			{
				this.processTime = 0;
			}
			if (var1 != this.processTime > 0)
			{
				var2 = true;
				this.validate();
			}
		}
		boolean check = isActive;
		isActive = isSifting();
		if (isActive != check)
		{
			this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord,this.zCoord);
		}
		if (var2)
		{
			this.onInventoryChanged();
		}
	}
	@Override
	public int getStartInventorySide(ForgeDirection side) {
		switch(side)
		{
		case DOWN:
		case EAST:
		case NORTH:
		case SOUTH:
		case WEST:
			return 1;
		case UP:
			return 0;
		case UNKNOWN:
		default:
			return 0;
		}
	}

	@Override
	public int getSizeInventorySide(ForgeDirection side)
	{
		switch(side)
		{
		case DOWN:
		case EAST:
		case NORTH:
		case SOUTH:
		case WEST:
			return 16;
		case UP:
			return 1;
		case UNKNOWN:
		default:
			return 0;
		
		}
	}
}
