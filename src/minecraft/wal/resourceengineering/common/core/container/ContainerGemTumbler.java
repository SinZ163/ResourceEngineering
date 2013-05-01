package resourceengineering.common.core.container;

import resourceengineering.common.ResourceEngineeringMain;
import resourceengineering.common.core.tileentity.GemTumblerTileEntity;
import resourceengineering.common.core.container.slot.*;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

//Create a class and extend Container
public class ContainerGemTumbler extends Container {
	// This is a declaration of the TileTutorial Class
	protected GemTumblerTileEntity tile_entity;
	private int lastCookTime = 0;
	private int lastBurnTime = 0;
	private int lastItemBurnTime = 0;
	// This is the super constructor and has 2 params
	// @param TileTutorial, this is the TileTutorial declaration
	// @param InventoryPlayer, this is the players inventory
	public ContainerGemTumbler(GemTumblerTileEntity tile_entity,InventoryPlayer player_inventory)
	{
		this.tile_entity = tile_entity;
		// The more stacks you have the more slots you need
		// This has 1 param
		// @param slot, this is the slot declaration, and you can declare a new
		addSlotToContainer(new GemSlot(tile_entity, 0, 50, 20));
		addSlotToContainer(new TumblerFuelSlot(tile_entity, 1, 50, 53));
		addSlotToContainer(new OutputSlot(tile_entity, 2, 107,37));
		// This is a method you will create later in the code and binds the
		// players inventory, to the Gui, in slot form
		bindPlayerInventory(player_inventory);
	}
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return tile_entity.isUseableByPlayer(player);
	}

	protected void bindPlayerInventory(InventoryPlayer player_inventory) {
		for (int i = 0; i < 3; i++)
		{
			for (int k = 0; k < 9; k++)
			{
				addSlotToContainer(new Slot(player_inventory, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
			}
		}

		for (int i = 0; i < 9; i++)
		{
			addSlotToContainer(new Slot(player_inventory, i, 8 + i * 18, 142));
		}
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotnumber)
	{
		ItemStack itemstack = null;
		Slot slot = (Slot)inventorySlots.get(slotnumber);

		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (slotnumber == 2)
			{
				if (!mergeItemStack(itemstack1, 3, 39, true))
				{
					return null;
				}

				slot.onSlotChange(itemstack1, itemstack);
			}
			else if (slotnumber == 1 || slotnumber == 0)
			{
				if (!mergeItemStack(itemstack1, 3, 39, false))
				{
					return null;
				}
			}
			else if (GemTumblerTileEntity.isItemFuel(itemstack1))
			{
				if (!mergeItemStack(itemstack1, 1, 2, false))
				{
					return null;
				}
			}
			else if (slotnumber >= 3 && slotnumber < 30)
			{
				if(itemstack1.itemID==ResourceEngineeringMain.gem.itemID)
				{
					if(itemstack1.getItemDamage()<7)
					{
						if (!mergeItemStack(itemstack1, 0, 1, false))
						{
							return null;
						}
					}
				}
			}
			else if (slotnumber >= 30 && slotnumber < 39 && !mergeItemStack(itemstack1, 3, 30, false))
			{
				return null;
			}

			if (itemstack1.stackSize == 0)
			{
				slot.putStack(null);
			}
			else
			{
				slot.onSlotChanged();
			}

			if (itemstack1.stackSize == itemstack.stackSize)
			{
				return null;
			}

			slot.onPickupFromSlot(player, itemstack);
		}

		return itemstack;
	}
	public void addCraftingToCrafters(ICrafting par1ICrafting)
	{
		super.addCraftingToCrafters(par1ICrafting);
		par1ICrafting.sendProgressBarUpdate(this, 0, this.tile_entity.cookTime);
		par1ICrafting.sendProgressBarUpdate(this, 1, this.tile_entity.burnTime);
		par1ICrafting.sendProgressBarUpdate(this, 2, this.tile_entity.itemBurnTime);
	}

	/**
	 * Looks for changes made in the container, sends them to every listener.
	 */
	 public void detectAndSendChanges()
	{
		 super.detectAndSendChanges();

		 for (int i = 0; i < this.crafters.size(); ++i)
		 {
			 ICrafting icrafting = (ICrafting)this.crafters.get(i);

			 if (this.lastCookTime != this.tile_entity.cookTime)
			 {
				 icrafting.sendProgressBarUpdate(this, 0, this.tile_entity.cookTime);
			 }

			 if (this.lastBurnTime != this.tile_entity.burnTime)
			 {
				 icrafting.sendProgressBarUpdate(this, 1, this.tile_entity.burnTime);
			 }

			 if (this.lastItemBurnTime != this.tile_entity.itemBurnTime)
			 {
				 icrafting.sendProgressBarUpdate(this, 2, this.tile_entity.itemBurnTime);
			 }
		 }

		 this.lastCookTime = this.tile_entity.cookTime;
		 this.lastBurnTime = this.tile_entity.burnTime;
		 this.lastItemBurnTime = this.tile_entity.itemBurnTime;
	}

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2)
	{
		if (par1 == 0)
		{
			this.tile_entity.cookTime = par2;
		}

		if (par1 == 1)
		{
			this.tile_entity.burnTime = par2;
		}

		if (par1 == 2)
		{
			this.tile_entity.itemBurnTime = par2;
		}
	}
}