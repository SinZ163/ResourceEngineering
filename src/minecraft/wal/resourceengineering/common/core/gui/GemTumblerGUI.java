package resourceengineering.common.core.gui;

import org.lwjgl.opengl.GL11;

import resourceengineering.common.core.tileentity.GemTumblerTileEntity;
import resourceengineering.common.core.container.*;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

//Create a class and extend GuiContainer
public class GemTumblerGUI extends GuiContainer {
	private GemTumblerTileEntity gemTumbler;

	public GemTumblerGUI(InventoryPlayer player_inventory,
			GemTumblerTileEntity tile_entity) {
		// just supers the a new ContainerTutorial
		super(new ContainerGemTumbler(tile_entity, player_inventory));
		gemTumbler = tile_entity;
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
		fontRenderer.drawString("Gem Tumbler", 6, 6, 0xffffff);
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
		
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.renderEngine.func_110577_a(new ResourceLocation("resourceengineering", "textures/gui/gemTumblerGUI.png"));
		//this.mc.renderEngine.bindTexture("/mods/resourceengineering/textures/gui/gemTumblerGUI.png");
		// This is the x value of the picture, it will be used later
		int x = (width - xSize) / 2;
		// This is the y value of the picture, it will be used later
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		
		if (gemTumbler.isBurning())
		{
			int burn = gemTumbler.getBurnTimeRemainingScaled(12);
			drawTexturedModalRect(x + 52, y + 39 + 12 - burn, 177, 30 - burn, 14, burn + 2);
			//drawTexturedModalRect(x + 52, y + 39, 177, 18, 14, burn);
		}
		int update = gemTumbler.getCookProgressScaled(18);
		drawTexturedModalRect(x + 76, y + 36, 177, 0, update, 18);
	}
}