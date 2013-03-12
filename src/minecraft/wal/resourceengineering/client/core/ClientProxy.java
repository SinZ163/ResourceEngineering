package resourceengineering.client.core;

import cpw.mods.fml.client.registry.RenderingRegistry;
import resourceengineering.common.core.CommonProxy;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy
{
	public void registerRenderInformation()
	{
		MinecraftForgeClient.preloadTexture("/walgfx/Items.png");
		MinecraftForgeClient.preloadTexture("/walgfx/Blocks.png");
	}
	public int addArmor(String armor)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
}
