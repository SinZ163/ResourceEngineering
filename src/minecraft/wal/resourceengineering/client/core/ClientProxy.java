package resourceengineering.client.core;

import cpw.mods.fml.client.registry.RenderingRegistry;
import resourceengineering.common.core.CommonProxy;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy
{
	public void registerRenderInformation()
	{
		
	}
	public int addArmor(String armor)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
}
