package resourceengineering.common.core.container.slot;

import resourceengineering.common.ResourceEngineeringMain;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class GemSlot extends Slot
{

	public GemSlot(IInventory inventory, int par2, int par3, int par4)
	{
		super(inventory, par2, par3, par4);
	}

	@Override
	public boolean isItemValid(ItemStack itemstack)
	{
		if(itemstack.itemID == ResourceEngineeringMain.gem.itemID)
		{
			if(itemstack.getItemDamage() <7)
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public int getSlotStackLimit()
	{
		return 64;
	}
}