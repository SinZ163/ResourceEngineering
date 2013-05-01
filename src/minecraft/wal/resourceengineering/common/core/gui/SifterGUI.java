package resourceengineering.common.core.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.entity.player.InventoryPlayer;
import resourceengineering.common.core.container.*;
import resourceengineering.common.core.tileentity.SifterTileEntity;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

public class SifterGUI extends GuiContainer
{
		private SifterTileEntity sifter;

		public SifterGUI(InventoryPlayer player_inventory,SifterTileEntity tile_entity)
		{
			super(new ContainerSifter(tile_entity, player_inventory));
			sifter = tile_entity;
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
			fontRenderer.drawString("Sifter", 6, 6, 0xffffff);
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
			int picture = mc.renderEngine.getTexture("/walgfx/gui/sifterGUI.png");
			GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
			this.mc.renderEngine.bindTexture(picture);
			// This is the x value of the picture, it will be used later
			int x = (width - xSize) / 2;
			// This is the y value of the picture, it will be used later
			int y = (height - ySize) / 2;
			this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

			int update = sifter.getSiftProgressScaled(55);
			drawTexturedModalRect(x + 43, y + 8, 177, 0, update, 72);
		}
	}