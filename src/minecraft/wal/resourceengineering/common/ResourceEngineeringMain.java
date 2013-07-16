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
import resourceengineering.common.core.items.ItemMachinePanel;
import resourceengineering.common.core.items.ItemNugget;
import resourceengineering.common.core.items.ItemGoldenPotato;
import resourceengineering.common.core.items.ItemGem;
import resourceengineering.common.core.items.ItemScreen;
import resourceengineering.common.core.items.ItemStick;

import resourceengineering.common.core.items.tools.ItemToolPickaxeSuper;
import resourceengineering.common.core.items.tools.ItemToolScythe;
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
@Mod(modid="resourceengineering",name="Resource Engineering",version="0.6.1")
public class ResourceEngineeringMain
{
	@Instance("resourceengineering")
	public static ResourceEngineeringMain instance = new ResourceEngineeringMain();
	
	@SidedProxy(clientSide = "resourceengineering.client.core.ClientProxy",serverSide = "resourceengineering.common.core.CommonProxy")
	public static CommonProxy proxy;
	
	public static Vector oreList;
	public static Vector plantList;

	public static int[] oreWhiteList;
	public static int[] plantWhiteList;
	
	//Items
	public static Item flakeIron;
	public static Item flakeGold;
	public static Item diamondChip;
	public static Item nugget;
	public static Item goldenPotato;
	public static Item gem;
	public static Item machinePanel;
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
	
	public static Item scytheTurquoise;
	public static Item scytheOnyx;
	public static Item scytheAmethyst;
	public static Item scytheCitrine;
	public static Item scytheEmerald;
	public static Item scytheRuby;
	public static Item scytheSapphire;
	
	public static Item scytheWood;
	public static Item scytheStone;
	public static Item scytheIron;
	public static Item scytheGold;
	public static Item scytheDiamond;
	
	
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
	public static EnumToolMaterial infiniteMaterial = EnumHelper.addToolMaterial("Infinite", 4, 2000000000, 50.0F, 1, 0);
	
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
	public static Item InfiniteHammer;
	
	private GuiHandler guiHandler = new GuiHandler();
	
	@PreInit()
	public void PreInitialization(FMLPreInitializationEvent e)
	{
		ConfigCore cc = new ConfigCore();
		ConfigCore.loadConfig(e);
		scytheTurquoise = new ItemToolScythe(cc.scytheTurquoiseID,turquoiseMaterial,"itemScytheTurquoise");
		scytheOnyx = new ItemToolScythe(cc.scytheOnyxID,onyxMaterial,"itemScytheOnyx");
		scytheAmethyst = new ItemToolScythe(cc.scytheAmethystID,amethystMaterial,"itemScytheAmethyst");
		scytheCitrine = new ItemToolScythe(cc.scytheCitrineID, citrineMaterial,"itemScytheCitrine");
		scytheEmerald = new ItemToolScythe(cc.scytheEmeraldID,emeraldMaterial,"itemScytheEmerald");
		scytheRuby = new ItemToolScythe(cc.scytheRubyID,rubyMaterial,"itemScytheRuby");
		scytheSapphire = new ItemToolScythe(cc.scytheSapphireID,sapphireMaterial,"itemScytheSapphire");
		
		scytheWood = new ItemToolScythe(cc.scytheWoodID,EnumToolMaterial.WOOD,"itemScytheWood");
		scytheStone = new ItemToolScythe(cc.scytheStoneID,EnumToolMaterial.STONE,"itemScytheStone");
		scytheIron = new ItemToolScythe(cc.scytheIronID,EnumToolMaterial.IRON,"itemScytheIron");
		scytheGold = new ItemToolScythe(cc.scytheGoldID,EnumToolMaterial.GOLD,"itemScytheGold");
		scytheDiamond = new ItemToolScythe(cc.scytheDiamondID,EnumToolMaterial.EMERALD,"itemScytheDiamond");
		
		flakeIron = new ItemFlake(cc.itemFlakeIronID,"itemFlakeIron");
		flakeGold = new ItemFlake(cc.itemFlakeGoldID,"itemFlakeGold");
		diamondChip = new ItemFlake(cc.itemFlakeDiamondID,"itemDiamondChip");
		nugget = new ItemNugget(cc.itemNuggetID);
		goldenPotato = new ItemGoldenPotato(cc.itemGoldenPotatoID,5,6,false);
		gem = new ItemGem(cc.itemGemID);
		screen = new ItemScreen(cc.itemScreenID,"itemScreen");
		//Swords
		turquoiseSword = new ItemToolSword(cc.itemToolSwordTurquoiseID,turquoiseMaterial,83,"itemToolSwordTurquoise");
		onyxSword = new ItemToolSword(cc.itemToolSwordOnyxID,onyxMaterial,84,"itemToolSwordOnyx");
		amethystSword = new ItemToolSword(cc.itemToolSwordAmethystID,amethystMaterial,85,"itemToolSwordAmethyst");
		citrineSword = new ItemToolSword(cc.itemToolSwordCitrineID,citrineMaterial,86,"itemToolSwordCitrine");
		emeraldSword = new ItemToolSword(cc.itemToolSwordEmeraldID,emeraldMaterial,87,"itemToolSwordEmerald");
		rubySword = new ItemToolSword(cc.itemToolSwordRubyID,rubyMaterial,88,"itemToolSwordRuby");
		sapphireSword = new ItemToolSword(cc.itemToolSwordSapphireID,sapphireMaterial,89,"itemToolSwordSapphire");
		
		//Pickaxes
		turquoisePickaxe = new ItemToolPickaxe(cc.itemToolPickaxeTurquoiseID,turquoiseMaterial,115,"itemToolPickaxeTurquoise");
		onyxPickaxe = new ItemToolPickaxe(cc.itemToolPickaxeOnyxID,onyxMaterial,116,"itemToolPickaxeOnyx");
		amethystPickaxe = new ItemToolPickaxe(cc.itemToolPickaxeAmethystID,amethystMaterial,117,"itemToolPickaxeAmethyst");
		citrinePickaxe = new ItemToolPickaxe(cc.itemToolPickaxeCitrineID,citrineMaterial,118,"itemToolPickaxeCitrine");
		emeraldPickaxe = new ItemToolPickaxe(cc.itemToolPickaxeEmeraldID,emeraldMaterial,119,"itemToolPickaxeEmerald");
		rubyPickaxe = new ItemToolPickaxe(cc.itemToolPickaxeRubyID,rubyMaterial,120,"itemToolPickaxeRuby");
		sapphirePickaxe = new ItemToolPickaxe(cc.itemToolPickaxeSapphireID,sapphireMaterial,121,"itemToolPickaxeSapphire");
		
		hammer = new ItemToolHammer(cc.itemToolHammerID,superMaterial,138,"itemToolHammer");
		InfiniteHammer = new ItemToolHammer(cc.itemToolInfiniteHammerID,infiniteMaterial,138,"itemToolInfiniteHammer");
		superPickaxe =  new ItemToolPickaxeSuper(cc.itemToolPickaxeSuperID,superMaterial,122,"itemToolPickaxeSuper");
		
		//Shovels
		turquoiseShovel = new ItemToolShovel(cc.itemToolShovelTurquoiseID,turquoiseMaterial,99,"itemToolShovelTurquoise");
		onyxShovel = new ItemToolShovel(cc.itemToolShovelOnyxID,onyxMaterial,100,"itemToolShovelOnyx");
		amethystShovel = new ItemToolShovel(cc.itemToolShovelAmethystID,amethystMaterial,101,"itemToolShovelAmethyst");
		citrineShovel = new ItemToolShovel(cc.itemToolShovelCitrineID,citrineMaterial,102,"itemToolShovelCitrine");
		emeraldShovel = new ItemToolShovel(cc.itemToolShovelEmeraldID,emeraldMaterial,103,"itemToolShovelEmerald");
		rubyShovel = new ItemToolShovel(cc.itemToolShovelRubyID,rubyMaterial,104,"itemToolShovelRuby");
		sapphireShovel = new ItemToolShovel(cc.itemToolShovelSapphireID,sapphireMaterial,105,"itemToolShovelSapphire");
		
		superShovel = new ItemToolShovelSuper(cc.itemToolShovelSuperID,superMaterial,106,"itemToolShovelSuper");
		
		//Axes
		turquoiseAxe = new ItemToolAxe(cc.itemToolAxeTurquoiseID,turquoiseMaterial,131,"itemToolAxeTurquoise");
		onyxAxe = new ItemToolAxe(cc.itemToolAxeOnyxID,onyxMaterial,132,"itemToolAxeOnyx");
		amethystAxe = new ItemToolAxe(cc.itemToolAxeAmethystID,amethystMaterial,133,"itemToolAxeAmethyst");
		citrineAxe = new ItemToolAxe(cc.itemToolAxeCitrineID,citrineMaterial,134,"itemToolAxeCitrine");
		emeraldAxe = new ItemToolAxe(cc.itemToolAxeEmeraldID,emeraldMaterial,135,"itemToolAxeEmerald");
		rubyAxe = new ItemToolAxe(cc.itemToolAxeRubyID,rubyMaterial,136,"itemToolAxeRuby");
		sapphireAxe = new ItemToolAxe(cc.itemToolAxeSapphireID,sapphireMaterial,137,"itemToolAxeSapphire");
		
		//Hoe
		turquoiseHoe = new ItemToolHoe(cc.itemToolHoeTurquoiseID,turquoiseMaterial,147,"itemToolHoeTurquoise");
		onyxHoe = new ItemToolHoe(cc.itemToolHoeOnyxID,onyxMaterial,148,"itemToolHoeOnyx");
		amethystHoe = new ItemToolHoe(cc.itemToolHoeAmethystID,amethystMaterial,149,"itemToolHoeAmethyst");
		citrineHoe = new ItemToolHoe(cc.itemToolHoeCitrineID,citrineMaterial,150,"itemToolHoeCitrine");
		emeraldHoe = new ItemToolHoe(cc.itemToolHoeEmeraldID,emeraldMaterial,151,"itemToolHoeEmerald");
		rubyHoe = new ItemToolHoe(cc.itemToolHoeRubyID,rubyMaterial,152,"itemToolHoeRuby");
		sapphireHoe = new ItemToolHoe(cc.itemToolHoeSapphireID,sapphireMaterial,153,"itemToolHoeSapphire");
		
		
		//Armor
		turquoiseHelmet = new GemArmor(cc.itemArmorHelmetTurquoiseID,turquoiseArmorMaterial,proxy.addArmor("turquoise"),0,"itemArmorTurquoiseHelmet");
		turquoisePlate = new GemArmor(cc.itemArmorPlateTurquoiseID,turquoiseArmorMaterial,proxy.addArmor("turquoise"),1,"itemArmorTurquoisePlate");
		turquoiseLeggings = new GemArmor(cc.itemArmorLeggingsTurquoiseID,turquoiseArmorMaterial,proxy.addArmor("turquoise"),2,"itemArmorTurquoiseLeggings");
		turquoiseBoots = new GemArmor(cc.itemArmorBootsTurquoiseID,turquoiseArmorMaterial,proxy.addArmor("turquoise"),3,"itemArmorTurquoiseBoots");
		
		onyxHelmet = new GemArmor(cc.itemArmorHelmetOnyxID,onyxArmorMaterial,proxy.addArmor("onyx"),0,"itemArmorOnyxHelmet");
		onyxPlate = new GemArmor(cc.itemArmorPlateOnyxID,onyxArmorMaterial,proxy.addArmor("onyx"),1,"itemArmorOnyxPlate");
		onyxLeggings = new GemArmor(cc.itemArmorLeggingsOnyxID,onyxArmorMaterial,proxy.addArmor("onyx"),2,"itemArmorOnyxLeggings");
		onyxBoots = new GemArmor(cc.itemArmorBootsOnyxID,onyxArmorMaterial,proxy.addArmor("onyx"),3,"itemArmorOnyxBoots");
		
		amethystHelmet = new GemArmor(cc.itemArmorHelmetAmethystID,amethystArmorMaterial,proxy.addArmor("amethyst"),0,"itemArmorAmethystHelmet");
		amethystPlate = new GemArmor(cc.itemArmorPlateAmethystID,amethystArmorMaterial,proxy.addArmor("amethyst"),1,"itemArmorAmethystPlate");
		amethystLeggings = new GemArmor(cc.itemArmorLeggingsAmethystID,amethystArmorMaterial,proxy.addArmor("amethyst"),2,"itemArmorAmethystLeggings");
		amethystBoots = new GemArmor(cc.itemArmorBootsAmethystID,amethystArmorMaterial,proxy.addArmor("amethyst"),3,"itemArmorAmethystBoots");
		
		citrineHelmet = new GemArmor(cc.itemArmorHelmetCitrineID,citrineArmorMaterial,proxy.addArmor("citrine"),0,"itemArmorCitrineHelmet");
		citrinePlate =  new GemArmor(cc.itemArmorPlateCitrineID,citrineArmorMaterial,proxy.addArmor("citrine"),1,"itemArmorCitrinePlate");
		citrineLeggings = new GemArmor(cc.itemArmorLeggingsCitrineID,citrineArmorMaterial,proxy.addArmor("citrine"),2,"itemArmorCitrineLeggings");
		citrineBoots = new GemArmor(cc.itemArmorBootsCitrineID,citrineArmorMaterial,proxy.addArmor("citrine"),3,"itemArmorCitrineBoots");
		
		emeraldHelmet = new GemArmor(cc.itemArmorHelmetEmeraldID,emeraldArmorMaterial,proxy.addArmor("emerald"),0,"itemArmorEmeraldHelmet");
		emeraldPlate = new GemArmor(cc.itemArmorPlateEmeraldID,emeraldArmorMaterial,proxy.addArmor("emerald"),1,"itemArmorEmeraldPlate");
		emeraldLeggings = new GemArmor(cc.itemArmorLeggingsEmeraldID,emeraldArmorMaterial,proxy.addArmor("emerald"),2,"itemArmorEmeraldLeggings");
		emeraldBoots = new GemArmor(cc.itemArmorBootsEmeraldID,emeraldArmorMaterial,proxy.addArmor("emerald"),3,"itemArmorEmeraldBoots");
		
		rubyHelmet = new GemArmor(cc.itemArmorHelmetRubyID,rubyArmorMaterial,proxy.addArmor("ruby"),0,"itemArmorRubyHelmet");
		rubyPlate =  new GemArmor(cc.itemArmorPlateRubyID,rubyArmorMaterial,proxy.addArmor("ruby"),1,"itemArmorRubyPlate");
		rubyLeggings = new GemArmor(cc.itemArmorLeggingsRubyID,rubyArmorMaterial,proxy.addArmor("ruby"),2,"itemArmorRubyLeggings");
		rubyBoots = new GemArmor(cc.itemArmorBootsRubyID,rubyArmorMaterial,proxy.addArmor("ruby"),3,"itemArmorRubyBoots");
		
		sapphireHelmet = new GemArmor(cc.itemArmorHelmetSapphireID,sapphireArmorMaterial,proxy.addArmor("sapphire"),0,"itemArmorSapphireHelmet");
		sapphirePlate = new GemArmor(cc.itemArmorPlateSapphireID,sapphireArmorMaterial,proxy.addArmor("sapphire"),1,"itemArmorSapphirePlate");
		sapphireLeggings = new GemArmor(cc.itemArmorLeggingsSapphireID,sapphireArmorMaterial,proxy.addArmor("sapphire"),2,"itemArmorSapphireLeggings");
		sapphireBoots = new GemArmor(cc.itemArmorBootsSapphireID,sapphireArmorMaterial,proxy.addArmor("sapphire"),3,"itemArmorSapphireBoots");
		
		oreBlock = new BlockOre(cc.oreBlockID);
		gemBlock = new BlockGem(cc.gemBlockID);
		
		blockPressureVessel = new BlockPressureVessel(cc.pressureVesselID);
		sifter = new BlockSifter(cc.sifterID);
		tumbler = new BlockGemTumbler(cc.tumblerID);
		
		stick = new ItemStick(cc.itemStickID);
		ThorsHammer = new ItemToolChunkHammer(cc.thorsHammerID,superMaterial,154,"itemThorHammer");
		dirtLayer = new ItemToolDirtLayer(cc.dirtLayerID,superMaterial,154,"itemDirtLayer");
		machinePanel = new ItemMachinePanel(cc.itemMachinePanelID,"itemMachinePanel");
		
		oreWhiteList = cc.oreWhiteList;
		plantWhiteList = cc.plantWhitelist;
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
	public static void scanModPlants()
	{
		plantList = new Vector();
		for(int i=0;i<plantWhiteList.length;i++)
		{
			if(Block.blocksList[plantWhiteList[i]]!=null)
			{
				FMLLog.log(Level.INFO, "Found whitelisted plant block ID: %s", plantWhiteList[i]);
				plantList.add(Block.blocksList[plantWhiteList[i]]);
			}
			else
			{
				FMLLog.log(Level.INFO, "Whitelisted plant not found ID: %s",plantWhiteList[i]);
			}
		}
	}
}
