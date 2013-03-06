package resourceengineering.common;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.SidedProxy;

import resourceengineering.client.core.ClientProxy;
import resourceengineering.common.core.CommonProxy;
import resourceengineering.client.core.handlers.ClientPacketHandler;
import resourceengineering.common.core.handlers.ServerPacketHandler;
@NetworkMod(clientSideRequired=true,serverSideRequired=false,
clientPacketHandlerSpec=@SidedPacketHandler(channels={"WAL_RE"},packetHandler=ClientPacketHandler.class),
serverPacketHandlerSpec=@SidedPacketHandler(channels = {}, packetHandler = ServerPacketHandler.class))
@Mod(modid="walResourceEngineering",name="Resource Engineering",version="0.0.1")
public class ResourceEngineeringMain
{
	@Instance("Wal_ResourceEngineering")
	public static ResourceEngineeringMain instance = new ResourceEngineeringMain();
	
	@SidedProxy(clientSide = "resourceengineering.client.core.ClientProxy",serverSide = "resourceengineering.common.core.CommonProxy")
	public static CommonProxy proxy;

	@PreInit()
	public void PreInitialization(FMLPreInitializationEvent e)
	{
		
	}
	@Init
	public void Initialization(FMLInitializationEvent event)
	{
		NetworkRegistry.instance().registerGuiHandler(this,proxy);
		proxy.registerBlocks();
		proxy.registerRenderInformation();
		proxy.addNames();
		proxy.addRecipes();
	}
		
}
