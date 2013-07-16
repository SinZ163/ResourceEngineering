package resourceengineering.common.core.tileentity;

import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;
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
public class PressureCookerTileEntity extends TileEntity implements IInventory {
	// Then create a ItemStack array (I.E. ItemStack[])
	private ItemStack[] inventory;

	public int burnTime;
	public int itemBurnTime;
	public int cookTime;
	private boolean isActive;
	private static int blazeRod=1800;
	private static int blazePowder = 200;

	// Then create a super constructor and give the inventory the amount of
	// ItemStacks you want (Slots),
	// I.E. (for 1 slot: inventory = new ItemStack[1];, for 5 slots: inventory =
	// new ItemStack[5];)
	public PressureCookerTileEntity() {
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
		return "PressureCookerInventory";
	}

	public static boolean isItemFuel(ItemStack par0ItemStack) {
		return getItemBurnTime(par0ItemStack) > 0;
	}

	public static int getItemBurnTime(ItemStack par1ItemStack) {
		if (par1ItemStack == null) {
			return 0;
		}

		int i = par1ItemStack.getItem().itemID;

		if (i == Item.blazeRod.itemID)
		{
			return blazeRod;
		}
		else if(i==Item.blazePowder.itemID)
		{
			return blazePowder;
		}
		else
		{
			return 0;
		}
	}

	public void updateEntity() {
		boolean var1 = this.burnTime > 0;
		boolean var2 = false;
		if (this.burnTime > 0 && this.canSmelt()) {
			--this.burnTime;
		}
		if (!this.worldObj.isRemote) {
			if (this.burnTime == 0 && this.canSmelt()) {
				this.itemBurnTime = this.burnTime = getItemBurnTime(this.inventory[1]);
				if (this.burnTime > 0) {
					var2 = true;
					if (this.inventory[1] != null) {
						--this.inventory[1].stackSize;
						if (this.inventory[1].stackSize == 0) {
							Item var3 = this.inventory[1].getItem()
									.getContainerItem();
							this.inventory[1] = var3 == null ? null
									: new ItemStack(var3);
						}
					}
				}
			}
			if (this.isBurning() && this.canSmelt()) {
				++this.cookTime;
				if (this.cookTime == 200) {
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
	         return (cookTime * par1) / 200;
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
	        	 itemBurnTime = blazeRod;
	         }

	         return (burnTime * par1) / itemBurnTime;
	}
	public static boolean canBeSmelted(int id)
	{
		if(id == ResourceEngineeringMain.flakeGold.itemID)
		{
			return true;
		}
		if(id == ResourceEngineeringMain.flakeIron.itemID)
		{
			return true;
		}
		if(id == ResourceEngineeringMain.diamondChip.itemID)
		{
			return true;
		}
		switch(id)
		{
		case 256://Iron Shovel
		case 257://Iron Pickaxe
		case 258://Iron Axe
		case 267://Iron Sword
		case 292://Iron Hoe
		case 306://Iron Helmet
		case 307://Iron Chestplate
		case 308://Iron Leggings
		case 309://Iron Boots
			return true;
		case 272://Stone Sword
		case 273://Stone Shovel
		case 274://Stone Pickaxe
		case 275://Stone Axe
		case 291://Stone Hoe
			return true;
		case 276://Diamond Sword
		case 277://Diamond Shovel
		case 278://Diamond Pickaxe
		case 279://Diamond Axe
		case 293://Diamond Hoe
		case 310://Diamond Hemlet
		case 311://Diamond Chestplate
		case 312://Diamond Leggings
		case 313://Diamond Boots
			return true;
		case 283://Gold Sword
		case 284://Gold Shovel
		case 285://Gold Pickaxe
		case 286://Gold Axe
		case 294://Gold Hoe
		case 314://Gold Helmet
		case 315://Gold Chestplate
		case 316://Gold Leggings
		case 317://Gold Boots
			return true;
		}
		return false;
	}
	private boolean isResultItem(int currentItem,int id)
	{
		if(id == ResourceEngineeringMain.flakeGold.itemID)
		{
			return currentItem == Item.goldNugget.itemID;
		}
		if(id == ResourceEngineeringMain.flakeIron.itemID)
		{
			return currentItem == ResourceEngineeringMain.nugget.itemID;
		}
		if(id == ResourceEngineeringMain.diamondChip.itemID)
		{
			return currentItem == Item.diamond.itemID;
		}
		switch(id)
		{
		case 256://Iron Shovel
		case 257://Iron Pickaxe
		case 258://Iron Axe
		case 267://Iron Sword
		case 292://Iron Hoe
		case 306://Iron Helmet
		case 307://Iron Chestplate
		case 308://Iron Leggings
		case 309://Iron Boots
			return currentItem == Item.ingotIron.itemID;
		case 272://Stone Sword
		case 273://Stone Shovel
		case 274://Stone Pickaxe
		case 275://Stone Axe
		case 291://Stone Hoe
			return currentItem == Block.stone.blockID;
		case 276://Diamond Sword
		case 277://Diamond Shovel
		case 278://Diamond Pickaxe
		case 279://Diamond Axe
		case 293://Diamond Hoe
		case 310://Diamond Hemlet
		case 311://Diamond Chestplate
		case 312://Diamond Leggings
		case 313://Diamond Boots
			return currentItem == Item.diamond.itemID;
		case 283://Gold Sword
		case 284://Gold Shovel
		case 285://Gold Pickaxe
		case 286://Gold Axe
		case 294://Gold Hoe
		case 295://Gold Helmet
		case 296://Gold Chestplate
		case 297://Gold Leggings
		case 298://Gold Boots
			return currentItem == Item.ingotGold.itemID;
		}
		return false;
	}
	private boolean canSmelt() {
		if (inventory[0] == null) {
			return false;
		}
		
		if (!canBeSmelted(inventory[0].getItem().itemID)) {
			return false;
		}
		if(inventory[0].getItem().itemID == ResourceEngineeringMain.flakeGold.itemID ||
				inventory[0].getItem().itemID == ResourceEngineeringMain.flakeIron.itemID ||
				inventory[0].getItem().itemID == ResourceEngineeringMain.diamondChip.itemID)
		{
			if(inventory[0].stackSize<9)
			{
				return false;
			}
		}
		if (inventory[2] == null) {
			return true;
		}

		if (!isResultItem(inventory[2].getItem().itemID,inventory[0].getItem().itemID)) {
			return false;
		}
		ItemStack res = getResultItem(inventory[0].getItem().itemID,inventory[0].getItemDamage());
		int stackSize = 1;
		if(res!=null)
		{
			stackSize = res.stackSize;
		}
		else{
			stackSize = 0;
		}
		if (inventory[2].stackSize < getInventoryStackLimit())
		{
			if(inventory[2].stackSize+stackSize <= inventory[2].getMaxStackSize())
			{
				return true;
			}
			else
			{
				return false;
			}
		}

		return inventory[2].stackSize < 64;
	}
	private int shovel(int maxDamage,int damage)
	{
		if(damage == 0 || damage<maxDamage/2)
		{
			return 1;
		}
		else return 0;
	}
	private int resultCount(int maxDamage, int damage, int bars)
	{
		if(damage==0)
		{
			return bars;
		}
		for(int i=1;i<bars;i++)
		{
			if(damage<(maxDamage/bars)*i)
			{
				return bars-i;
			}
		}
		return 0;
	}
	
	private ItemStack getResultItem(int id,int damage)
	{
		ItemStack res = null;
		switch(id)
		{
		case 256://Iron Shovel
			res = new ItemStack(Item.ingotIron,shovel(Item.shovelIron.getMaxDamage(),damage));
			break;
		case 257://Iron Pickaxe
			res = new ItemStack(Item.ingotIron,resultCount(Item.pickaxeIron.getMaxDamage(),damage,3));
			break;
		case 258://Iron Axe
			res = new ItemStack(Item.ingotIron,resultCount(Item.axeIron.getMaxDamage(),damage,3));
			break;
		case 267://Iron Sword
			res = new ItemStack(Item.ingotIron,resultCount(Item.swordIron.getMaxDamage(),damage,2));
			break;
		case 292://Iron Hoe
			res = new ItemStack(Item.ingotIron,resultCount(Item.hoeIron.getMaxDamage(),damage,2));
			break;
		case 306://Iron Helmet
			res = new ItemStack(Item.ingotIron,resultCount(Item.helmetIron.getMaxDamage(),damage,5));
			break;
		case 307://Iron Chestplate
			res = new ItemStack(Item.ingotIron,resultCount(Item.plateIron.getMaxDamage(),damage,8));
			break;
		case 308://Iron Leggings
			res = new ItemStack(Item.ingotIron,resultCount(Item.legsIron.getMaxDamage(),damage,7));
			break;
		case 309://Iron Boots
			res = new ItemStack(Item.ingotIron,resultCount(Item.bootsIron.getMaxDamage(),damage,4));
			break;
		case 272://Stone Sword
			res = new ItemStack(Block.stone,resultCount(Item.swordStone.getMaxDamage(),damage,2));
			break;
		case 273://Stone Shovel
			res = new ItemStack(Block.stone,shovel(Item.shovelStone.getMaxDamage(),damage));
			break;
		case 274://Stone Pickaxe
			res = new ItemStack(Block.stone,resultCount(Item.pickaxeStone.getMaxDamage(),damage,3));
			break;
		case 275://Stone Axe
			res = new ItemStack(Block.stone,resultCount(Item.axeStone.getMaxDamage(),damage,3));
			break;
		case 291://Stone Hoe
			res = new ItemStack(Block.stone,resultCount(Item.hoeStone.getMaxDamage(),damage,2));
			break;
		case 276://Diamond Sword
			res = new ItemStack(Item.diamond,resultCount(Item.swordDiamond.getMaxDamage(),damage,2));
			break;
		case 277://Diamond Shovel
			res = new ItemStack(Item.diamond,shovel(Item.shovelDiamond.getMaxDamage(),damage));
			break;
		case 278://Diamond Pickaxe
			res = new ItemStack(Item.diamond,resultCount(Item.pickaxeDiamond.getMaxDamage(),damage,3));
			break;
		case 279://Diamond Axe
			res = new ItemStack(Item.diamond,resultCount(Item.axeDiamond.getMaxDamage(),damage,3));
			break;
		case 293://Diamond Hoe
			res = new ItemStack(Item.diamond,resultCount(Item.hoeDiamond.getMaxDamage(),damage,2));
			break;
		case 310://Diamond Helmet
			res = new ItemStack(Item.diamond,resultCount(Item.helmetDiamond.getMaxDamage(),damage,5));
			break;
		case 311://Diamond Chestplate
			res = new ItemStack(Item.diamond,resultCount(Item.plateDiamond.getMaxDamage(),damage,8));
			break;
		case 312://Diamond Leggings
			res = new ItemStack(Item.diamond,resultCount(Item.legsDiamond.getMaxDamage(),damage,7));
			break;
		case 313://Diamond Boots
			res = new ItemStack(Item.diamond,resultCount(Item.bootsDiamond.getMaxDamage(),damage,4));
			break;
		case 283://Gold Sword
			res = new ItemStack(Item.ingotGold,resultCount(Item.swordGold.getMaxDamage(),damage,2));
			break;
		case 284://Gold Shovel
			res = new ItemStack(Item.ingotGold,shovel(Item.shovelGold.getMaxDamage(),damage));
			break;
		case 285://Gold Pickaxe
			res = new ItemStack(Item.ingotGold,resultCount(Item.pickaxeGold.getMaxDamage(),damage,3));
			break;
		case 286://Gold Axe
			res = new ItemStack(Item.ingotGold,resultCount(Item.axeGold.getMaxDamage(),damage,3));
			break;
		case 294://Gold Hoe
			res = new ItemStack(Item.ingotGold,resultCount(Item.hoeGold.getMaxDamage(),damage,2));
			break;
		case 295://Gold Helmet
			res = new ItemStack(Item.ingotGold,resultCount(Item.helmetGold.getMaxDamage(),damage,5));
			break;
		case 296://Gold Chestplate
			res = new ItemStack(Item.ingotGold,resultCount(Item.plateGold.getMaxDamage(),damage,8));
			break;
		case 297://Gold Leggings
			res = new ItemStack(Item.ingotGold,resultCount(Item.legsGold.getMaxDamage(),damage,7));
			break;
		case 298://Gold Boots
			res = new ItemStack(Item.ingotGold,resultCount(Item.bootsGold.getMaxDamage(),damage,4));
			break;
		}
		return res;
	}
	public void smeltItem() {
		if (this.canSmelt())
		{
			ItemStack var1;// = RecipesPressureCooker.smelting().getSmeltingResult(this.inventory[0].getItem().itemID);
			if(this.inventory[0].getItem().itemID == ResourceEngineeringMain.flakeGold.itemID)
			{
				var1 = new ItemStack(Item.goldNugget,1);
				if(this.inventory[0].stackSize==9)
				{
					this.inventory[0]=null;
				}
				else
				{
					this.inventory[0].stackSize-=9;
				}
				
			}
			else if(this.inventory[0].getItem().itemID == ResourceEngineeringMain.flakeIron.itemID)
			{
				var1 = new ItemStack(ResourceEngineeringMain.nugget,1);
				if(this.inventory[0].stackSize==9)
				{
					this.inventory[0]=null;
				}
				else
				{
					this.inventory[0].stackSize-=9;
				}
			}
			else if(this.inventory[0].getItem().itemID == ResourceEngineeringMain.diamondChip.itemID)
			{
				var1 = new ItemStack(Item.diamond,1);
				if(this.inventory[0].stackSize==9)
				{
					this.inventory[0]=null;
				}
				else
				{
					this.inventory[0].stackSize-=9;
				}
			}
			else
			{
				var1 = getResultItem(this.inventory[0].getItem().itemID,this.inventory[0].getItemDamage());
				this.inventory[0] = null;
				if(var1==null)
				{
					return;
				}
				
			}
			if (this.inventory[2] == null)
			{
				this.inventory[2] = var1.copy();
			} 
			else if (this.inventory[2].itemID == var1.itemID)
			{
				this.inventory[2].stackSize+=var1.stackSize;
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
		case 0:
			return canBeSmelted(itemstack.itemID);
		case 1:
			return isItemFuel(itemstack);
		default:
			return false;
		}
	}
}