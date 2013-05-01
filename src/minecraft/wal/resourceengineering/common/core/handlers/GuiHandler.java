package resourceengineering.common.core.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import resourceengineering.common.core.container.*;
import resourceengineering.common.core.gui.*;
import resourceengineering.common.core.tileentity.*;
import cpw.mods.fml.common.network.IGuiHandler;

//Create a class and implement IGuiHandler
public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world,int x, int y, int z)
	{
		// This gets the TileEntity the player is currently activating
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
		// This checks if the TileEntity is the TileTutorial
		if (tile_entity instanceof PressureCookerTileEntity)
		{
			// If it is it returns a new ContainerTutorial instance
			return new ContainerPressureCooker((PressureCookerTileEntity) tile_entity,player.inventory);
		}
		else if(tile_entity instanceof SifterTileEntity)
		{
			return new ContainerSifter((SifterTileEntity)tile_entity,player.inventory);
		}
		else if(tile_entity instanceof GemTumblerTileEntity)
		{
			return new ContainerGemTumbler((GemTumblerTileEntity)tile_entity,player.inventory);
		}
		// Returns null if not
		return null;
	}

	// This is another required method to open the Gui and has 6 params
	// @param int id, this is the Gui Id
	// @param EntityPlayer, this is the player declaration
	// @param World, this is the world declaration,
	// @param int x, y, z this is the players current x, y, z coords
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world,
			int x, int y, int z) {
		// This gets the TIleEntity the player is currently activating
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

		// This checks if the TileEntity is the PressureCooker
		if (tile_entity instanceof PressureCookerTileEntity) {
			// If it is it returns a new PressureCookerGUI instance
			return new PressureCookerGUI(player.inventory,
					(PressureCookerTileEntity) tile_entity);
		}
		else if(tile_entity instanceof SifterTileEntity)
		{
			return new SifterGUI(player.inventory,(SifterTileEntity)tile_entity);
		}
		else if(tile_entity instanceof GemTumblerTileEntity)
		{
			return new GemTumblerGUI(player.inventory,(GemTumblerTileEntity)tile_entity);
		}
		// Returns null if not
		return null;
	}
}