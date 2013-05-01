package resourceengineering.common.core.container;

import java.util.logging.Level;

import resourceengineering.common.core.RecipesPressureCooker;
import resourceengineering.common.core.tileentity.SifterTileEntity;
import resourceengineering.common.core.container.slot.SifterSlot;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerSifter extends Container
{
	protected SifterTileEntity sifter;
	private int lastProcessTime = 0;
	public ContainerSifter(SifterTileEntity tile_entity,InventoryPlayer player_inventory)
	{
		sifter = tile_entity;
		addSlotToContainer(new SifterSlot(sifter, 0, 26, 33));
		addSlotToContainer(new Slot(sifter, 1, 98, 8));
		addSlotToContainer(new Slot(sifter, 2, 116, 8));
		addSlotToContainer(new Slot(sifter, 3, 134, 8));
		addSlotToContainer(new Slot(sifter, 4, 152, 8));
		addSlotToContainer(new Slot(sifter, 5, 98, 26));
		addSlotToContainer(new Slot(sifter, 6, 116, 26));
		addSlotToContainer(new Slot(sifter, 7, 134, 26));
		addSlotToContainer(new Slot(sifter, 8, 152, 26));
		addSlotToContainer(new Slot(sifter, 9, 98, 44));
		addSlotToContainer(new Slot(sifter, 10, 116, 44));
		addSlotToContainer(new Slot(sifter, 11, 134, 44));
		addSlotToContainer(new Slot(sifter, 12, 152, 44));
		addSlotToContainer(new Slot(sifter, 13, 98, 62));
		addSlotToContainer(new Slot(sifter, 14, 116, 62));
		addSlotToContainer(new Slot(sifter, 15, 134, 62));
		addSlotToContainer(new Slot(sifter, 16, 152, 62));

		bindPlayerInventory(player_inventory);

	}
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return sifter.isUseableByPlayer(player);
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
			//move from the output slots
			if (slotnumber >=1 && slotnumber<=16)
			{
				if (!mergeItemStack(itemstack1, 17, 52, true))
				{
					return null;
				}
				slot.onSlotChange(itemstack1, itemstack);
			}
			//move out of the input slot
			else if (slotnumber == 0)
			{
				if (!mergeItemStack(itemstack1, 17, 52, false))
				{
					return null;
				}
			}
			else if (slotnumber > 16 && slotnumber <= 52)
			{
				Slot target = (Slot)inventorySlots.get(0);
				if(target.isItemValid(itemstack1))
				{
					if (!mergeItemStack(itemstack1, 0, 1, false))
					{
						return null;
					}
				}
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
	public void addCraftingToCrafters(ICrafting crafting)
	{
		super.addCraftingToCrafters(crafting);
		crafting.sendProgressBarUpdate(this, 0, this.sifter.processTime);
	}
	/*
	 * Looks for changes made in the container, sends them to every listener.
	 */
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();
		for (int i = 0; i < this.crafters.size(); ++i)
		{
			ICrafting icrafting = (ICrafting)this.crafters.get(i);

			if (this.lastProcessTime != this.sifter.processTime)
			{
				icrafting.sendProgressBarUpdate(this, 0, this.sifter.processTime);
			}
		}

		this.lastProcessTime = this.sifter.processTime;
	}

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int newVal)
	{
		if (par1 == 0)
		{
			this.sifter.processTime = newVal;
		}
	}
}
