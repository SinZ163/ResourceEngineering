package resourceengineering.common.core.container.slot;

import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;
import resourceengineering.common.ResourceEngineeringMain;
import resourceengineering.common.core.tileentity.PressureCookerTileEntity;
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
		return PressureCookerTileEntity.canBeSmelted(itemstack.itemID);
	}

	@Override
	public int getSlotStackLimit()
	{
		return 64;
	}
}