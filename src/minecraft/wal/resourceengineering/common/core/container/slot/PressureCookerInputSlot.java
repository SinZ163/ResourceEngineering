package resourceengineering.common.core.container.slot;

import resourceengineering.common.ResourceEngineeringMain;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class PressureCookerInputSlot extends Slot
{
	public PressureCookerInputSlot(IInventory inventory, int par2, int par3, int par4)
	{
		super(inventory, par2, par3, par4);
	}

	@Override
	public boolean isItemValid(ItemStack itemstack)
	{
		if(itemstack.itemID == ResourceEngineeringMain.flakeGold.itemID || itemstack.itemID == ResourceEngineeringMain.flakeIron.itemID || itemstack.itemID == ResourceEngineeringMain.diamondChip.itemID)
		{
			return true;
		}
		return false;
	}

	@Override
	public int getSlotStackLimit()
	{
		return 64;
	}
}