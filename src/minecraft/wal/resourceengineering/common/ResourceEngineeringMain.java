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
import resourceengineering.common.core.items.tools.ItemToolSword;
import resourceengineering.common.core.items.tools.ItemToolPickaxe;
import resourceengineering.common.core.items.tools.ItemToolShovel;

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
	
	/*
	 * ======================================================
	 * ------------------------TOOLS-------------------------
	 * ======================================================
	 */
	//Swords
	public static Item turquoiseSword;
	public static Item onyxSword;
	public static Item amethystSword;
	public static Item citrineSword;
	public static Item emeraldSword;
	public static Item rubySword;
	public static Item sapphireSword;
	//Pickaxes
	public static Item turquoisePickaxe;
	public static Item onyxPickaxe;
	public static Item amethystPickaxe;
	public static Item citrinePickaxe;
	public static Item emeraldPickaxe;
	public static Item rubyPickaxe;
	public static Item sapphirePickaxe;
	//Shovels
	public static Item turquoiseShovel;
	public static Item onyxShovel;
	public static Item amethystShovel;
	public static Item citrineShovel;
	public static Item emeraldShovel;
	public static Item rubyShovel;
	public static Item sapphireShovel;
	
	//Blocks
	public static Block oreBlock;
	public static Block gemBlock;

	public static CreativeTabs reTab = new ResourceEngineeringTab(CreativeTabs.getNextID(),"wal_ResouceEngineeringTab");
	
	//Gem Materials
	public static EnumToolMaterial turquoiseMaterial = EnumHelper.addToolMaterial("Turquoise",1,64,2.0F,1,30);
	public static EnumToolMaterial onyxMaterial = EnumHelper.addToolMaterial("Onyx",1,128,3.0F,2,22);
	public static EnumToolMaterial amethystMaterial = EnumHelper.addToolMaterial("Amethyst",2,256,6.0F,3,15);
	public static EnumToolMaterial citrineMaterial = EnumHelper.addToolMaterial("Citrine", 2, 512, 10.0F, 4, 12);
	public static EnumToolMaterial emeraldMaterial = EnumHelper.addToolMaterial("Emerald", 3, 1024, 12.0F, 5, 8);
	public static EnumToolMaterial rubyMaterial = EnumHelper.addToolMaterial("Ruby", 3, 2048, 16.0F, 6, 5);
	public static EnumToolMaterial sapphireMaterial = EnumHelper.addToolMaterial("Sapphire", 3, 4096, 20.0F, 7, 1);
	
	
	@PreInit()
	public void PreInitialization(FMLPreInitializationEvent e)
	{
		ConfigCore cc = new ConfigCore();
		ConfigCore.loadConfig(e);
		
		flake = new ItemFlake(cc.itemFlakeID);
		nugget = new ItemNugget(cc.itemNuggetID);
		goldenPotato = new ItemGoldenPotato(cc.itemGoldenPotatoID,5,6,false);
		gem = new ItemGem(cc.itemGemID);
		//Swords
		turquoiseSword = new ItemToolSword(cc.itemToolSwordTurquoiseID,turquoiseMaterial,83,"wal_itemToolSwordTurquoise");
		onyxSword = new ItemToolSword(cc.itemToolSwordOnyxID,onyxMaterial,84,"wal_itemToolSwordOnyx");
		amethystSword = new ItemToolSword(cc.itemToolSwordAmethystID,amethystMaterial,85,"wal_itemToolSwordAmethyst");
		citrineSword = new ItemToolSword(cc.itemToolSwordCitrineID,citrineMaterial,86,"wal_itemToolSwordCitrine");
		emeraldSword = new ItemToolSword(cc.itemToolSwordEmeraldID,emeraldMaterial,87,"wal_itemToolSwordEmerald");
		rubySword = new ItemToolSword(cc.itemToolSwordRubyID,rubyMaterial,88,"wal_itemToolSwordRuby");
		sapphireSword = new ItemToolSword(cc.itemToolSwordSapphireID,sapphireMaterial,89,"wal_itemToolSwordSapphire");
		
		//Pickaxes
		turquoisePickaxe = new ItemToolPickaxe(cc.itemToolPickaxeTurquoiseID,turquoiseMaterial,115,"wal_itemToolPickaxeTurquoise");
		onyxPickaxe = new ItemToolPickaxe(cc.itemToolPickaxeOnyxID,onyxMaterial,116,"wal_itemToolPickaxeOnyx");
		amethystPickaxe = new ItemToolPickaxe(cc.itemToolPickaxeAmethystID,amethystMaterial,117,"wal_itemToolPickaxeAmethyst");
		citrinePickaxe = new ItemToolPickaxe(cc.itemToolPickaxeCitrineID,citrineMaterial,118,"wal_itemToolPickaxeAmethyst");
		emeraldPickaxe = new ItemToolPickaxe(cc.itemToolPickaxeEmeraldID,emeraldMaterial,119,"wal_itemToolPickaxeEmerald");
		rubyPickaxe = new ItemToolPickaxe(cc.itemToolPickaxeRubyID,rubyMaterial,120,"wal_itemToolPickaxeRuby");
		sapphirePickaxe = new ItemToolPickaxe(cc.itemToolPickaxeSapphireID,sapphireMaterial,121,"wal_itemToolPickaxeSapphire");
		
		//Shovels
		turquoiseShovel = new ItemToolShovel(cc.itemToolShovelTurquoiseID,turquoiseMaterial,99,"wal_itemToolShovelTurquoise");
		onyxShovel = new ItemToolShovel(cc.itemToolShovelOnyxID,onyxMaterial,100,"wal_itemToolShovelOnyx");
		amethystShovel = new ItemToolShovel(cc.itemToolShovelAmethystID,amethystMaterial,101,"wal_itemToolShovelAmethyst");
		citrineShovel = new ItemToolShovel(cc.itemToolShovelCitrineID,citrineMaterial,102,"wal_itemToolShovelCitrine");
		emeraldShovel = new ItemToolShovel(cc.itemToolShovelEmeraldID,emeraldMaterial,103,"wal_itemToolShovelEmerald");
		rubyShovel = new ItemToolShovel(cc.itemToolShovelRubyID,rubyMaterial,104,"wal_itemToolShovelRuby");
		sapphireShovel = new ItemToolShovel(cc.itemToolShovelSapphireID,sapphireMaterial,105,"wal_itemToolShovelSapphire");
		
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
