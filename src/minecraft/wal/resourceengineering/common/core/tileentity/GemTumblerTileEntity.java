package resourceengineering.common.core.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import resourceengineering.common.ResourceEngineeringMain;
import resourceengineering.common.core.RecipesPressureCooker;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

//Basically this is where your TileEntity comes from
//Create a class and extend TileEntity and implement IInventory
public class GemTumblerTileEntity extends TileEntity implements IInventory {
	// Then create a ItemStack array (I.E. ItemStack[])
	private ItemStack[] inventory;

	public int burnTime;
	public int itemBurnTime;
	public int cookTime;
	private boolean isActive;

	// Then create a super constructor and give the inventory the amount of
	// ItemStacks you want (Slots),
	// I.E. (for 1 slot: inventory = new ItemStack[1];, for 5 slots: inventory =
	// new ItemStack[5];)
	public GemTumblerTileEntity() {
		inventory = new ItemStack[3];
	}

	// This returns the inventory size
	@Override
	public int getSizeInventory() {
		return inventory.length;
	}

	// This returns the stack that is in the slot you picked
	// This has 1 param
	// @param int slotIndex is just the index you selected
	@Override
	public ItemStack getStackInSlot(int slotIndex) {
		return inventory[slotIndex];
	}

	// This sets the slots contents, it has 2 params
	// @param int slot, this is the slots number
	// @param ItemStack stack, this is the stack you want to add
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

	// This decreases the stack size
	// It has 2 params
	// @param int slotIndex, this is the slot number
	// @param int amount, this is the amount you want to decreases by
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

	// This returns the stack in the slot you chose
	// It has 1 param
	// @param int slotIndex this is the slot number you choose to get
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

	// This gets the inventory's stack limit
	// This is normally 64 but on some conditions it is something lower
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	// Basically this makes sure the player is not to far away to activate the
	// block and, makes sure its the Entity you are
	// Selecting
	@Override
	public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) {
		if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this) {
			return false;
		}

		return par1EntityPlayer.getDistanceSq((double) xCoord + 0.5D,
				(double) yCoord + 0.5D, (double) zCoord + 0.5D) <= 64D;
	}

	// A dummy, mostly un-used method, for a check to do something when you open
	// the Gui
	@Override
	public void openChest() {
	}

	// Another dummy, mostly un-used method, for a check to do something when
	// you close the Gui
	@Override
	public void closeChest() {
	}

	// This is a really hard method to understand and requires Knowledge of
	// minecrafts NBTTag System, and
	// All you really need to do is copy it because its pretty much the same for
	// every entity
	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);

		this.burnTime = tagCompound.getShort("BurnTime");
		this.cookTime = tagCompound.getShort("CookTime");

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

		tagCompound.setShort("BurnTime",(short)this.burnTime);
		tagCompound.setShort("CookTime", (short)this.cookTime);

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

	// This returns the inventory's name
	@Override
	public String getInvName() {
		return "GemTumblerTileEntity";
	}

	public static boolean isItemFuel(ItemStack par0ItemStack) {
		return getItemBurnTime(par0ItemStack) > 0;
	}

	public static int getItemBurnTime(ItemStack par1ItemStack)
	{
		if (par1ItemStack == null)
		{
			return 0;
		}

		int i = par1ItemStack.getItem().itemID;

		if (i == Block.gravel.blockID)
		{
			return 800;
		}
		else if(i==Block.sand.blockID)
		{
			return 800;
		}
		else
		{
			return 0;
		}
	}

	public void updateEntity()
	{
		boolean var1 = this.burnTime > 0;
		boolean var2 = false;
		if (this.burnTime > 0 && this.canSmelt())
		{
			--this.burnTime;
		}
		if (!this.worldObj.isRemote)
		{
			if (this.burnTime == 0 && this.canSmelt())
			{
				this.itemBurnTime = this.burnTime = getItemBurnTime(this.inventory[1]);
				if (this.burnTime > 0)
				{
					var2 = true;
					if (this.inventory[1] != null)
					{
						--this.inventory[1].stackSize;
						if (this.inventory[1].stackSize == 0)
						{
							Item var3 = this.inventory[1].getItem().getContainerItem();
							this.inventory[1] = var3 == null ? null: new ItemStack(var3);
						}
					}
				}
			}
			if (this.isBurning() && this.canSmelt())
			{
				++this.cookTime;
				if (this.cookTime == 50)
				{
					this.cookTime = 0;
					this.smeltItem();
					var2 = true;
				}
			} else {
				this.cookTime = 0;
			}
			if (var1 != this.burnTime > 0) {
				var2 = true;
				this.validate();
			}
		}
		boolean check = isActive;
		isActive = isBurning();
		if (isActive != check) {
			this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord,
					this.zCoord);
		}
		if (var2) {
			this.onInventoryChanged();
		}
	}

	public boolean isBurning() {
		return burnTime > 0;
	}
	@SideOnly(Side.CLIENT)
	public int getCookProgressScaled(int par1)
	{
		return (cookTime * par1) / 50;
	}

	/**
	 * Returns an integer between 0 and the passed value representing how much burn time is left on the current fuel
	 * item, where 0 means that the item is exhausted and the passed value means that the item is fresh
	 */
	@SideOnly(Side.CLIENT)
	public int getBurnTimeRemainingScaled(int par1)
	{
		if (itemBurnTime == 0)
		{
			itemBurnTime = 800;
		}

		return (burnTime * par1) / itemBurnTime;
	}
	private boolean canSmelt() {
		boolean ret=false;
		if (inventory[0] == null) {
			return false;
		}

		if(inventory[0].stackSize<1)
		{
			return false;
		}
		if(getStackInSlot(0).itemID != ResourceEngineeringMain.gem.itemID)
		{
			return false;
		}
		if(inventory[2]!=null)
		{
			if(inventory[0].getItemDamage()!=(inventory[2].getItemDamage()-7))
			{
				return false;
			}
			if (inventory[2].stackSize < getInventoryStackLimit()
					&& inventory[2].stackSize < inventory[2].getMaxStackSize()) {
				ret = true;
			}
		}
		if (inventory[2] == null) {
			ret=true;
		}		
		if(inventory[0].getItemDamage()>=7)
		{
			return false;
		}
		return ret;
	}

	public void smeltItem()
	{
		if (this.canSmelt())
		{
			if(this.inventory[2] == null)
			{
				if(this.inventory[0].itemID == ResourceEngineeringMain.gem.itemID)
				{
					this.inventory[2] = new ItemStack(ResourceEngineeringMain.gem,1,(getStackInSlot(0).getItemDamage()+7));
				}
			}else if(this.inventory[2].getItemDamage()==this.inventory[0].getItemDamage()+7)
			{
				this.inventory[2].stackSize++;
			}
			else
			{
				return;
			}
			this.inventory[0].stackSize-=1;
			if (this.inventory[0].stackSize == 0)
			{
				Item var2 = this.inventory[0].getItem().getContainerItem();
				this.inventory[0] = var2 == null ? null : new ItemStack(var2);
			}
		}
	}

//	@Override
//	public int getStartInventorySide(ForgeDirection side) {
//		switch(side)
//		{
//		case DOWN:
//			return 1;
//		case EAST:
//		case NORTH:
//		case SOUTH:
//		case WEST:
//			return 2;
//		case UP:
//			return 0;
//		case UNKNOWN:
//		default:
//			return 0;
//		}
//	}
//
//	@Override
//	public int getSizeInventorySide(ForgeDirection side)
//	{
//		switch(side)
//		{
//		case DOWN:
//			return 1;
//		case EAST:
//		case NORTH:
//		case SOUTH:
//		case WEST:
//			return 1;
//		case UP:
//			return 1;
//		case UNKNOWN:
//		default:
//			return 0;
//		
//		}
//	}

	@Override
	public boolean isInvNameLocalized() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack)
	{
		switch(i)
		{
		case 0://Input
			if(itemstack.itemID == ResourceEngineeringMain.gem.itemID)
			{
				if(itemstack.getItemDamage() <7)
				{
					return true;
				}
			}
			return false;
		case 1://Fuel
			if(itemstack.itemID == Block.gravel.blockID)
			{
				return true;
			}
			if(itemstack.itemID == Block.sand.blockID)
			{
				return true;
			}
			return false;
		case 2://Output
		default:
			return false;
		}
	}
}