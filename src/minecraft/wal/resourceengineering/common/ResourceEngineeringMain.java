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
import resourceengineering.common.core.handlers.WorldGenHandler;

import resourceengineering.common.tabs.ResourceEngineeringTab;
import resourceengineering.common.ConfigCore;

//Item Imports
import resourceengineering.common.core.items.ItemFlake;
import resourceengineering.common.core.items.ItemNugget;
import resourceengineering.common.core.items.ItemGoldenPotato;
import resourceengineering.common.core.items.ItemGem;

//Tool Imports
import resourceengineering.common.core.items.tools.ItemToolSwordTurquoise;
import resourceengineering.common.core.items.tools.ItemToolSwordOnyx;
import resourceengineering.common.core.items.tools.ItemToolSwordAmethyst;
import resourceengineering.common.core.items.tools.ItemToolSwordCitrine;

//Block Imports
import resourceengineering.common.blocks.BlockOre;
import resourceengineering.common.blocks.BlockGem;

@NetworkMod(clientSideRequired=true,serverSideRequired=false,
clientPacketHandlerSpec=@SidedPacketHandler(channels={"WAL_RE"},packetHandler=ClientPacketHandler.class),
serverPacketHandlerSpec=@SidedPacketHandler(channels = {}, packetHandler = ServerPacketHandler.class))
@Mod(modid="walResourceEngineering",name="Resource Engineering",version="0.0.21")
public class ResourceEngineeringMain
{
	@Instance("Wal_ResourceEngineering")
	public static ResourceEngineeringMain instance = new ResourceEngineeringMain();
	
	@SidedProxy(clientSide = "resourceengineering.client.core.ClientProxy",serverSide = "resourceengineering.common.core.CommonProxy")
	public static CommonProxy proxy;
	
	//Items
	public static Item flake;
	public static Item nugget;
	public static Item goldenPotato;
	public static Item gem;
	
	//Tools
	public static Item turquoiseSword;
	public static Item onyxSword;
	public static Item amethystSword;
	public static Item citrineSword;
	
	//Blocks
	public static Block oreBlock;
	public static Block gemBlock;

	public static CreativeTabs reTab = new ResourceEngineeringTab(CreativeTabs.getNextID(),"wal_ResouceEngineeringTab");
	
	//Gem Materials
	public static EnumToolMaterial turquoiseMaterial = EnumHelper.addToolMaterial("Turquoise",1,64,50.0F,1,30);
	public static EnumToolMaterial onyxMaterial = EnumHelper.addToolMaterial("Onyx",1,128,75.0F,2,22);
	public static EnumToolMaterial amethystMaterial = EnumHelper.addToolMaterial("Amethyst",2,256,100.0F,3,15);
	public static EnumToolMaterial citrineMaterial = EnumHelper.addToolMaterial("Citrine", 2, 512, 125.0F, 4, 12);
	public static EnumToolMaterial emeraldMaterial = EnumHelper.addToolMaterial("Emerald", 3, 1024, 150.0F, 5, 8);
	public static EnumToolMaterial rubyMaterial = EnumHelper.addToolMaterial("Ruby", 3, 2048, 200.0F, 6, 5);
	public static EnumToolMaterial sapphireMaterial = EnumHelper.addToolMaterial("Sapphire", 3, 4096, 250.0F, 7, 1);
	
	
	@PreInit()
	public void PreInitialization(FMLPreInitializationEvent e)
	{
		ConfigCore cc = new ConfigCore();
		ConfigCore.loadConfig(e);
		
		flake = new ItemFlake(cc.itemFlakeID);
		nugget = new ItemNugget(cc.itemNuggetID);
		goldenPotato = new ItemGoldenPotato(cc.itemGoldenPotatoID,5,6,false);
		gem = new ItemGem(cc.itemGemID);
		turquoiseSword = new ItemToolSwordTurquoise(cc.itemToolSwordTurquoiseID,turquoiseMaterial,83,"wal_itemToolSwordTurquoise");
		onyxSword = new ItemToolSwordOnyx(cc.itemToolSwordOnyxID,onyxMaterial,84,"wal_itemToolSwordOnyx");
		amethystSword = new ItemToolSwordAmethyst(cc.itemToolSwordAmethystID,amethystMaterial,85,"wal_itemToolSwordAmethyst");
		citrineSword = new ItemToolSwordCitrine(cc.itemToolSwordCitrineID,citrineMaterial,86,"wal_itemToolSwordCitrine");
		
		oreBlock = new BlockOre(cc.oreBlockID);
		gemBlock = new BlockGem(cc.gemBlockID);
	}
	@Init
	public void Initialization(FMLInitializationEvent event)
	{
		NetworkRegistry.instance().registerGuiHandler(this,proxy);
		GameRegistry.registerWorldGenerator(new WorldGenHandler());
		proxy.registerOre();
		proxy.registerBlocks();
		proxy.registerRenderInformation();
		proxy.addNames();
		proxy.addRecipes();
	}
		
}
