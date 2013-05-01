package resourceengineering.common.core.gui;

import org.lwjgl.opengl.GL11;

import resourceengineering.common.core.container.*;
import resourceengineering.common.core.tileentity.PressureCookerTileEntity;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

//Create a class and extend GuiContainer
public class PressureCookerGUI extends GuiContainer {
	private PressureCookerTileEntity pressureCooker;

	public PressureCookerGUI(InventoryPlayer player_inventory,
			PressureCookerTileEntity tile_entity) {
		// just supers the a new ContainerTutorial
		super(new ContainerPressureCooker(tile_entity, player_inventory));
		pressureCooker = tile_entity;
	}

	// This method is required and all it does is draw the foreground
	// and overlays
	protected void drawGuiContainerForegroundLayer() {
		// Draws The title of the Gui like "Furnace" for the furnace,
		// It has 4 params
		// @param "Tutorial Gui" this is the Name in String format
		// @param int 6, this is the xCoord on the screen
		// @param int 6, this is the yCoord on the screen
		// @param 0xffffff, this is the color in hex, 0xffffff, is white,
		// 0x000000 is black BTW
		fontRenderer.drawString("Pressure Vessel", 6, 6, 0xffffff);
		// This draws the caption for the players inventory this is not needed
		// as the above but is sometimes nice
		fontRenderer.drawString(
				StatCollector.translateToLocal("container.inventory"), 6,
				ySize - 96 + 2, 0xffffff);
	}

	// This is another required method and has 3 params
	// @param float f, this is just something that is not required here,
	// something I shouldn't have to go indepth with
	// @param int i, int j, these are just like the later
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		int picture = mc.renderEngine.getTexture("/walgfx/gui/pressureCookerGUI.png");
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.renderEngine.bindTexture(picture);
		// This is the x value of the picture, it will be used later
		int x = (width - xSize) / 2;
		// This is the y value of the picture, it will be used later
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		
		if (pressureCooker.isBurning())
		{
			int burn = pressureCooker.getBurnTimeRemainingScaled(12);
			drawTexturedModalRect(x + 52, y + 39 + 12 - burn, 177, 30 - burn, 14, burn + 2);
			//drawTexturedModalRect(x + 52, y + 39, 177, 18, 14, burn);
		}
		int update = pressureCooker.getCookProgressScaled(18);
		drawTexturedModalRect(x + 76, y + 36, 177, 0, update, 18);
	}
}