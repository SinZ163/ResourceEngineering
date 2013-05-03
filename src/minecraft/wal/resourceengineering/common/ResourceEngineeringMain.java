package resourceengineering.common;

import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.FMLLog;
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
import resourceengineering.common.core.handlers.GuiHandler;
import resourceengineering.common.core.handlers.ServerPacketHandler;
import resourceengineering.common.core.handlers.WorldGenHandler;

import resourceengineering.common.tabs.ResourceEngineeringTab;
import resourceengineering.common.ConfigCore;

//Item Imports
import resourceengineering.common.core.items.ItemFlake;
import resourceengineering.common.core.items.ItemNugget;
import resourceengineering.common.core.items.ItemGoldenPotato;
import resourceengineering.common.core.items.ItemGem;
import resourceengineering.common.core.items.ItemScreen;
import resourceengineering.common.core.items.ItemStick;

import resourceengineering.common.core.items.tools.ItemToolPickaxeSuper;
import resourceengineering.common.core.items.tools.ItemToolShovelSuper;
import resourceengineering.common.core.items.tools.ItemToolHammer;
import resourceengineering.common.core.items.tools.ItemToolChunkHammer;
import resourceengineering.common.core.items.tools.ItemToolDirtLayer;
//Tool Imports
import resourceengineering.common.core.items.tools.ItemToolSword;
import resourceengineering.common.core.items.tools.ItemToolPickaxe;
import resourceengineering.common.core.items.tools.ItemToolShovel;
import resourceengineering.common.core.items.tools.ItemToolAxe;
import resourceengineering.common.core.items.tools.ItemToolHoe;

//Armor Import
import resourceengineering.common.core.items.armor.GemArmor;

import resourceengineering.common.blocks.BlockGemTumbler;
//Block Imports
import resourceengineering.common.blocks.BlockOre;
import resourceengineering.common.blocks.BlockGem;
import resourceengineering.common.blocks.BlockPressureVessel;
import resourceengineering.common.blocks.BlockSifter;

@NetworkMod(clientSideRequired=true,serverSideRequired=false,
clientPacketHandlerSpec=@SidedPacketHandler(channels={"WAL_RE"},packetHandler=ClientPacketHandler.class),
serverPacketHandlerSpec=@SidedPacketHandler(channels = {"WAL_RE"}, packetHandler = ServerPacketHandler.class))
@Mod(modid="mod_walResourceEngineering",name="Resource Engineering",version="0.0.110")
public class ResourceEngineeringMain
{
	@Instance("Wal_ResourceEngineering")
	public static ResourceEngineeringMain instance = new ResourceEngineeringMain();
	
	@SidedProxy(clientSide = "resourceengineering.client.core.ClientProxy",serverSide = "resourceengineering.common.core.CommonProxy")
	public static CommonProxy proxy;
	
	public static Vector oreList;
	public static int[] oreWhiteList;
	
	//Items
	public static Item flakeIron;
	public static Item flakeGold;
	public static Item diamondChip;
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
	public static Item superPickaxe;
	public static Item hammer;
	//Shovels
	public static Item turquoiseShovel;
	public static Item onyxShovel;
	public static Item amethystShovel;
	public static Item citrineShovel;
	public static Item emeraldShovel;
	public static Item rubyShovel;
	public static Item sapphireShovel;
	public static Item superShovel;
	//Axes
	public static Item turquoiseAxe;
	public static Item onyxAxe;
	public static Item amethystAxe;
	public static Item citrineAxe;
	public static Item emeraldAxe;
	public static Item rubyAxe;
	public static Item sapphireAxe;
	//Hoe
	public static Item turquoiseHoe;
	public static Item onyxHoe;
	public static Item amethystHoe;
	public static Item citrineHoe;
	public static Item emeraldHoe;
	public static Item rubyHoe;
	public static Item sapphireHoe;
	//Other Tools
	public static Item dirtLayer;
	
	/*
	 * ======================================================
	 * ------------------------ARMOR-------------------------
	 * ======================================================
	 */
	//Turquoise Armor
	public static Item turquoiseHelmet;
	public static Item turquoisePlate;
	public static Item turquoiseLeggings;
	public static Item turquoiseBoots;
	
	//Onyx Armor
	public static Item onyxHelmet;
	public static Item onyxPlate;
	public static Item onyxLeggings;
	public static Item onyxBoots;
	
	//Amethyst Armor
	public static Item amethystHelmet;
	public static Item amethystPlate;
	public static Item amethystLeggings;
	public static Item amethystBoots;
	
	//Citrine Armor
	public static Item citrineHelmet;
	public static Item citrinePlate;
	public static Item citrineLeggings;
	public static Item citrineBoots;
	
	//Emerald Armor
	public static Item emeraldHelmet;
	public static Item emeraldPlate;
	public static Item emeraldLeggings;
	public static Item emeraldBoots;
	
	//Ruby Armor
	public static Item rubyHelmet;
	public static Item rubyPlate;
	public static Item rubyLeggings;
	public static Item rubyBoots;
	
	//Sapphire Armor
	public static Item sapphireHelmet;
	public static Item sapphirePlate;
	public static Item sapphireLeggings;
	public static Item sapphireBoots;
	
	
	/*
	 * ======================================================
	 * -----------------------BLOCKS-------------------------
	 * ======================================================
	 */
	public static Block oreBlock;
	public static Block gemBlock;

	public static CreativeTabs reTab = new ResourceEngineeringTab(CreativeTabs.getNextID(),"wal_ResouceEngineeringTab");
	
	/*
	 * ======================================================
	 * ---------------------CRAFTSTUFF-----------------------
	 * ======================================================
	 */
	public static Item stick;
	public static Item screen;
	
	
	/*
	 * ======================================================
	 * ----------------------MATERIALS-----------------------
	 * ======================================================
	 */
	//Gem Materials
	public static EnumToolMaterial turquoiseMaterial = EnumHelper.addToolMaterial("Turquoise",1,64,2.0F,1,30);
	public static EnumToolMaterial onyxMaterial = EnumHelper.addToolMaterial("Onyx",1,128,3.0F,2,22);
	public static EnumToolMaterial amethystMaterial = EnumHelper.addToolMaterial("Amethyst",2,256,6.0F,3,15);
	public static EnumToolMaterial citrineMaterial = EnumHelper.addToolMaterial("Citrine", 2, 512, 10.0F, 4, 12);
	public static EnumToolMaterial emeraldMaterial = EnumHelper.addToolMaterial("Emerald", 3, 1024, 12.0F, 5, 8);
	public static EnumToolMaterial rubyMaterial = EnumHelper.addToolMaterial("Ruby", 3, 2048, 16.0F, 6, 5);
	public static EnumToolMaterial sapphireMaterial = EnumHelper.addToolMaterial("Sapphire", 3, 4096, 20.0F, 7, 1);
	public static EnumToolMaterial superMaterial = EnumHelper.addToolMaterial("Super",3,2048,17.0F,1,0);
	
	//Armor Materials
	public static EnumArmorMaterial turquoiseArmorMaterial = EnumHelper.addArmorMaterial("TURQUOISE_ARMOR", 5, new int[] {1, 3, 2, 1}, 30);
	public static EnumArmorMaterial onyxArmorMaterial = EnumHelper.addArmorMaterial("ONYX_ARMOR", 7, new int[] {2,  3, 2, 2},22);
	public static EnumArmorMaterial amethystArmorMaterial = EnumHelper.addArmorMaterial("AMETHYST_ARMOR",10,new int[] {3, 4, 3, 2},15);
	public static EnumArmorMaterial citrineArmorMaterial = EnumHelper.addArmorMaterial("CITRINE_ARMOR",14,new int[] {3, 5, 3, 3},12);
	public static EnumArmorMaterial emeraldArmorMaterial = EnumHelper.addArmorMaterial("EMERALD_ARMOR",19,new int[] {4, 6, 4, 4},8);
	public static EnumArmorMaterial rubyArmorMaterial = EnumHelper.addArmorMaterial("RUBY_ARMOR",26,new int[] {5, 7, 5, 4},5);
	public static EnumArmorMaterial sapphireArmorMaterial = EnumHelper.addArmorMaterial("SAPPHIRE_ARMOR",40,new int[] {6, 8, 6, 5},1);
	
	/*CLOTH(5, new int[]{1, 3, 2, 1}, 15),
    CHAIN(15, new int[]{2, 5, 4, 1}, 12),
    IRON(15, new int[]{2, 6, 5, 2}, 9),
    GOLD(7, new int[]{2, 5, 3, 1}, 25),
    DIAMOND(33, new int[]{3, 8, 6, 3}, 10);
    */
	
	/*
	 * ======================================================
	 * ----------------------MACHINES------------------------
	 * ======================================================
	 */
	public static Block blockPressureVessel;
	public static Block sifter;
	public static Block tumbler;
	public static Item ThorsHammer;
	
	private GuiHandler guiHandler = new GuiHandler();
	
	@PreInit()
	public void PreInitialization(FMLPreInitializationEvent e)
	{
		ConfigCore cc = new ConfigCore();
		ConfigCore.loadConfig(e);
		
		flakeIron = new ItemFlake(cc.itemFlakeIronID,"wal_ItemIronFlake",0);
		flakeGold = new ItemFlake(cc.itemFlakeGoldID,"wal_ItemGoldFlake",16);
		diamondChip = new ItemFlake(cc.itemFlakeDiamondID,"wal_ItemDiamondChip",32);
		nugget = new ItemNugget(cc.itemNuggetID);
		goldenPotato = new ItemGoldenPotato(cc.itemGoldenPotatoID,5,6,false);
		gem = new ItemGem(cc.itemGemID);
		screen = new ItemScreen(cc.itemScreenID,"itemScreen");
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
		citrinePickaxe = new ItemToolPickaxe(cc.itemToolPickaxeCitrineID,citrineMaterial,118,"wal_itemToolPickaxeCitrine");
		emeraldPickaxe = new ItemToolPickaxe(cc.itemToolPickaxeEmeraldID,emeraldMaterial,119,"wal_itemToolPickaxeEmerald");
		rubyPickaxe = new ItemToolPickaxe(cc.itemToolPickaxeRubyID,rubyMaterial,120,"wal_itemToolPickaxeRuby");
		sapphirePickaxe = new ItemToolPickaxe(cc.itemToolPickaxeSapphireID,sapphireMaterial,121,"wal_itemToolPickaxeSapphire");
		
		hammer = new ItemToolHammer(cc.itemToolHammerID,superMaterial,138,"wal_itemToolHammer");
		superPickaxe =  new ItemToolPickaxeSuper(cc.itemToolPickaxeSuperID,superMaterial,122,"wal_itemToolPickaxeSuper");
		
		//Shovels
		turquoiseShovel = new ItemToolShovel(cc.itemToolShovelTurquoiseID,turquoiseMaterial,99,"wal_itemToolShovelTurquoise");
		onyxShovel = new ItemToolShovel(cc.itemToolShovelOnyxID,onyxMaterial,100,"wal_itemToolShovelOnyx");
		amethystShovel = new ItemToolShovel(cc.itemToolShovelAmethystID,amethystMaterial,101,"wal_itemToolShovelAmethyst");
		citrineShovel = new ItemToolShovel(cc.itemToolShovelCitrineID,citrineMaterial,102,"wal_itemToolShovelCitrine");
		emeraldShovel = new ItemToolShovel(cc.itemToolShovelEmeraldID,emeraldMaterial,103,"wal_itemToolShovelEmerald");
		rubyShovel = new ItemToolShovel(cc.itemToolShovelRubyID,rubyMaterial,104,"wal_itemToolShovelRuby");
		sapphireShovel = new ItemToolShovel(cc.itemToolShovelSapphireID,sapphireMaterial,105,"wal_itemToolShovelSapphire");
		
		superShovel = new ItemToolShovelSuper(cc.itemToolShovelSuperID,superMaterial,106,"wal_itemToolShovelSuper");
		
		//Axes
		turquoiseAxe = new ItemToolAxe(cc.itemToolAxeTurquoiseID,turquoiseMaterial,131,"wal_itemToolAxeTurquoise");
		onyxAxe = new ItemToolAxe(cc.itemToolAxeOnyxID,onyxMaterial,132,"wal_itemToolAxeOnyx");
		amethystAxe = new ItemToolAxe(cc.itemToolAxeAmethystID,amethystMaterial,133,"wal_itemToolAxeAmethyst");
		citrineAxe = new ItemToolAxe(cc.itemToolAxeCitrineID,citrineMaterial,134,"wal_itemToolAxeCitrine");
		emeraldAxe = new ItemToolAxe(cc.itemToolAxeEmeraldID,emeraldMaterial,135,"wal_itemToolAxeEmerald");
		rubyAxe = new ItemToolAxe(cc.itemToolAxeRubyID,rubyMaterial,136,"wal_itemToolAxeRuby");
		sapphireAxe = new ItemToolAxe(cc.itemToolAxeSapphireID,sapphireMaterial,137,"wal_itemToolAxeSapphire");
		
		//Hoe
		turquoiseHoe = new ItemToolHoe(cc.itemToolHoeTurquoiseID,turquoiseMaterial,147,"wal_itemToolHoeTurquoise");
		onyxHoe = new ItemToolHoe(cc.itemToolHoeOnyxID,onyxMaterial,148,"wal_itemToolHoeOnyx");
		amethystHoe = new ItemToolHoe(cc.itemToolHoeAmethystID,amethystMaterial,149,"wal_itemToolHoeAmethyst");
		citrineHoe = new ItemToolHoe(cc.itemToolHoeCitrineID,citrineMaterial,150,"wal_itemToolHoeCitrine");
		emeraldHoe = new ItemToolHoe(cc.itemToolHoeEmeraldID,emeraldMaterial,151,"wal_itemToolHoeEmerald");
		rubyHoe = new ItemToolHoe(cc.itemToolHoeRubyID,rubyMaterial,152,"wal_itemToolHoeRuby");
		sapphireHoe = new ItemToolHoe(cc.itemToolHoeSapphireID,sapphireMaterial,153,"wal_itemToolHoeSapphire");
		
		
		//Armor
		turquoiseHelmet = new GemArmor(cc.itemArmorHelmetTurquoiseID,turquoiseArmorMaterial,proxy.addArmor("TurquoiseArmor"),0,"wal_itemArmorTurquoiseHelmet",19);
		turquoisePlate = new GemArmor(cc.itemArmorPlateTurquoiseID,turquoiseArmorMaterial,proxy.addArmor("TurquoiseArmor"),1,"wal_itemArmorTurquiosePlate",35);
		turquoiseLeggings = new GemArmor(cc.itemArmorLeggingsTurquoiseID,turquoiseArmorMaterial,proxy.addArmor("TurquoiseArmor"),2,"wal_itemArmorTurquoiseLeggings",51);
		turquoiseBoots = new GemArmor(cc.itemArmorBootsTurquoiseID,turquoiseArmorMaterial,proxy.addArmor("TurquoiseArmor"),3,"wal_itemArmorTurquoiseBoots",67);
		
		onyxHelmet = new GemArmor(cc.itemArmorHelmetOnyxID,onyxArmorMaterial,proxy.addArmor("OnyxArmor"),0,"wal_itemArmorOnyxHelmet",20);
		onyxPlate = new GemArmor(cc.itemArmorPlateOnyxID,onyxArmorMaterial,proxy.addArmor("OnyxArmor"),1,"wal_itemArmorOnyxPlate",36);
		onyxLeggings = new GemArmor(cc.itemArmorLeggingsOnyxID,onyxArmorMaterial,proxy.addArmor("OnyxArmor"),2,"wal_itemArmorOnyxLeggings",52);
		onyxBoots = new GemArmor(cc.itemArmorBootsOnyxID,onyxArmorMaterial,proxy.addArmor("OnyxArmor"),3,"wal_itemArmorOnyxBoots",68);
		
		amethystHelmet = new GemArmor(cc.itemArmorHelmetAmethystID,amethystArmorMaterial,proxy.addArmor("AmethystArmor"),0,"wal_itemArmorAmethystHelmet",21);
		amethystPlate = new GemArmor(cc.itemArmorPlateAmethystID,amethystArmorMaterial,proxy.addArmor("AmethystArmor"),1,"wal_itemArmorAmethystPlate",37);
		amethystLeggings = new GemArmor(cc.itemArmorLeggingsAmethystID,amethystArmorMaterial,proxy.addArmor("AmethystArmor"),2,"wal_itemArmorAmethystLeggings",53);
		amethystBoots = new GemArmor(cc.itemArmorBootsAmethystID,amethystArmorMaterial,proxy.addArmor("AmethystArmor"),3,"wal_itemArmorAmethystBoots",69);
		
		citrineHelmet = new GemArmor(cc.itemArmorHelmetCitrineID,citrineArmorMaterial,proxy.addArmor("CitrineArmor"),0,"wal_itemArmorCitrineHelmet",22);
		citrinePlate =  new GemArmor(cc.itemArmorPlateCitrineID,citrineArmorMaterial,proxy.addArmor("CitrineArmor"),1,"wal_itemArmorCitrinePlate",38);
		citrineLeggings = new GemArmor(cc.itemArmorLeggingsCitrineID,citrineArmorMaterial,proxy.addArmor("CitrineArmor"),2,"wal_itemArmorCitrineLeggings",54);
		citrineBoots = new GemArmor(cc.itemArmorBootsCitrineID,citrineArmorMaterial,proxy.addArmor("CitrineArmor"),3,"wal_itemArmorCitrineBoots",70);
		
		emeraldHelmet = new GemArmor(cc.itemArmorHelmetEmeraldID,emeraldArmorMaterial,proxy.addArmor("EmeraldArmor"),0,"wal_itemArmorEmeraldHelmet",23);
		emeraldPlate = new GemArmor(cc.itemArmorPlateEmeraldID,emeraldArmorMaterial,proxy.addArmor("EmeraldArmor"),1,"wal_itemArmorEmeraldPlate",39);
		emeraldLeggings = new GemArmor(cc.itemArmorLeggingsEmeraldID,emeraldArmorMaterial,proxy.addArmor("EmeraldArmor"),2,"wal_itemArmorEmeraldLeggings",55);
		emeraldBoots = new GemArmor(cc.itemArmorBootsEmeraldID,emeraldArmorMaterial,proxy.addArmor("EmeraldArmor"),3,"wal_itemArmorEmeraldBoots",71);
		
		rubyHelmet = new GemArmor(cc.itemArmorHelmetRubyID,rubyArmorMaterial,proxy.addArmor("RubyArmor"),0,"wal_itemArmorRubyHelmet",24);
		rubyPlate =  new GemArmor(cc.itemArmorPlateRubyID,rubyArmorMaterial,proxy.addArmor("RubyArmor"),1,"wal_itemArmorRubyPlate",40);
		rubyLeggings = new GemArmor(cc.itemArmorLeggingsRubyID,rubyArmorMaterial,proxy.addArmor("RubyArmor"),2,"wal_itemArmorRubyLeggings",56);
		rubyBoots = new GemArmor(cc.itemArmorBootsRubyID,rubyArmorMaterial,proxy.addArmor("RubyArmor"),3,"wal_itemArmorRubyBoots",72);
		
		sapphireHelmet = new GemArmor(cc.itemArmorHelmetSapphireID,sapphireArmorMaterial,proxy.addArmor("SapphireArmor"),0,"wal_itemArmorSapphireHelmet",25);
		sapphirePlate = new GemArmor(cc.itemArmorPlateSapphireID,sapphireArmorMaterial,proxy.addArmor("SapphireArmor"),1,"wal_itemArmorSapphirePlate",41);
		sapphireLeggings = new GemArmor(cc.itemArmorLeggingsSapphireID,sapphireArmorMaterial,proxy.addArmor("SapphireArmor"),2,"wal_itemArmorSapphireLeggings",57);
		sapphireBoots = new GemArmor(cc.itemArmorBootsSapphireID,sapphireArmorMaterial,proxy.addArmor("SapphireArmor"),3,"wal_itemArmorSapphiredBoots",73);
		
		oreBlock = new BlockOre(cc.oreBlockID);
		gemBlock = new BlockGem(cc.gemBlockID);
		
		blockPressureVessel = new BlockPressureVessel(cc.pressureVesselID);
		sifter = new BlockSifter(cc.sifterID);
		tumbler = new BlockGemTumbler(cc.tumblerID);
		
		stick = new ItemStick(cc.itemStickID);
		ThorsHammer = new ItemToolChunkHammer(cc.thorsHammerID,superMaterial,154,"wal_itemThorHammer");
		dirtLayer = new ItemToolDirtLayer(cc.dirtLayerID,superMaterial,154,"wal_itemDirtLayer");
		
		oreWhiteList = cc.oreWhiteList;
	}
	@Init
	public void Initialization(FMLInitializationEvent event)
	{
		NetworkRegistry.instance().registerGuiHandler(this,guiHandler);
		instance = this;
		GameRegistry.registerWorldGenerator(new WorldGenHandler());
		proxy.registerTileEntities();
		proxy.registerOre();
		proxy.registerBlocks();
		proxy.registerRenderInformation();
		proxy.addNames();
		proxy.addRecipes();
	}
	public static void scanModOres()
	{
		oreList = new Vector();
		for(int i=0;i<oreWhiteList.length;i++)
		{
			if(Block.blocksList[oreWhiteList[i]]!=null)
			{
				FMLLog.log(Level.INFO, "Found whitelisted ore block ID: %s", oreWhiteList[i]);
				oreList.add(Block.blocksList[oreWhiteList[i]]);
			}
			else
			{
				FMLLog.log(Level.INFO, "Whitelisted ore not found ID: %s",oreWhiteList[i]);
			}
		}
	}	
}
