package resourceengineering.common;

import java.util.Vector;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ConfigCore 
{
	
	//Items
	public static int itemFlakeIronID;
	public static int itemFlakeGoldID;
	public static int itemFlakeDiamondID;
	public static int itemGoldenPotatoID;
	public static int itemNuggetID;
	public static int itemGemID;
	public static int itemScreenID;
	public static int itemMachinePanelID;
	
	public static int thorsHammerID;
	public static int dirtLayerID;
	public static int itemToolInfiniteHammerID;
	
	//Tools
	public static int scytheTurquoiseID;
	public static int scytheOnyxID;
	public static int scytheAmethystID;
	public static int scytheCitrineID;
	public static int scytheEmeraldID;
	public static int scytheRubyID;
	public static int scytheSapphireID;
	public static int scytheWoodID;
	public static int scytheStoneID;
	public static int scytheIronID;
	public static int scytheGoldID;
	public static int scytheDiamondID;
	
	public static int itemToolSwordTurquoiseID;
	public static int itemToolSwordOnyxID;
	public static int itemToolSwordAmethystID;
	public static int itemToolSwordCitrineID;
	public static int itemToolSwordEmeraldID;
	public static int itemToolSwordRubyID;
	public static int itemToolSwordSapphireID;
	
	public static int itemToolPickaxeTurquoiseID;
	public static int itemToolPickaxeOnyxID;
	public static int itemToolPickaxeAmethystID;
	public static int itemToolPickaxeCitrineID;
	public static int itemToolPickaxeEmeraldID;
	public static int itemToolPickaxeRubyID;
	public static int itemToolPickaxeSapphireID;
	public static int itemToolPickaxeSuperID;
	public static int itemToolHammerID;
	
	public static int itemToolShovelTurquoiseID;
	public static int itemToolShovelOnyxID;
	public static int itemToolShovelAmethystID;
	public static int itemToolShovelCitrineID;
	public static int itemToolShovelEmeraldID;
	public static int itemToolShovelRubyID;
	public static int itemToolShovelSapphireID;
	public static int itemToolShovelSuperID;
	
	public static int itemToolAxeTurquoiseID;
	public static int itemToolAxeOnyxID;
	public static int itemToolAxeAmethystID;
	public static int itemToolAxeCitrineID;
	public static int itemToolAxeEmeraldID;
	public static int itemToolAxeRubyID;
	public static int itemToolAxeSapphireID;
	
	public static int itemToolHoeTurquoiseID;
	public static int itemToolHoeOnyxID;
	public static int itemToolHoeAmethystID;
	public static int itemToolHoeCitrineID;
	public static int itemToolHoeEmeraldID;
	public static int itemToolHoeRubyID;
	public static int itemToolHoeSapphireID;
	
	//Armor
	public static int itemArmorHelmetTurquoiseID;
	public static int itemArmorPlateTurquoiseID;
	public static int itemArmorLeggingsTurquoiseID;
	public static int itemArmorBootsTurquoiseID;
	
	public static int itemArmorHelmetOnyxID;
	public static int itemArmorPlateOnyxID;
	public static int itemArmorLeggingsOnyxID;
	public static int itemArmorBootsOnyxID;
	
	public static int itemArmorHelmetAmethystID;
	public static int itemArmorPlateAmethystID;
	public static int itemArmorLeggingsAmethystID;
	public static int itemArmorBootsAmethystID;
	
	public static int itemArmorHelmetCitrineID;
	public static int itemArmorPlateCitrineID;
	public static int itemArmorLeggingsCitrineID;
	public static int itemArmorBootsCitrineID;
	
	public static int itemArmorHelmetEmeraldID;
	public static int itemArmorPlateEmeraldID;
	public static int itemArmorLeggingsEmeraldID;
	public static int itemArmorBootsEmeraldID;
	
	public static int itemArmorHelmetRubyID;
	public static int itemArmorPlateRubyID;
	public static int itemArmorLeggingsRubyID;
	public static int itemArmorBootsRubyID;
	
	public static int itemArmorHelmetSapphireID;
	public static int itemArmorPlateSapphireID;
	public static int itemArmorLeggingsSapphireID;
	public static int itemArmorBootsSapphireID;
	
	//Blocks
	public static int oreBlockID;
	public static int gemBlockID;
	public static int pressureVesselID;
	public static int sifterID;
	public static int tumblerID;
	
	//Armor
	
	//Other
	public static int[] oreWhiteList;
	public static int[] plantWhitelist;
	public static int itemStickID;
	
	public static void loadConfig(FMLPreInitializationEvent e)
	{
		Configuration config = new Configuration(e.getSuggestedConfigurationFile());
		config.load();
		itemFlakeIronID = config.getItem("IronFlake", 15000).getInt();
		itemFlakeGoldID = config.getItem("GoldFlake",15001).getInt();
		itemFlakeDiamondID = config.getItem("DiamondChip",15002).getInt();
		itemGoldenPotatoID = config.getItem("GoldenPotato", 15003).getInt();
		itemNuggetID = config.getItem("MetalNugget", 15004).getInt();
		itemGemID = config.getItem("Gem",15005).getInt();
		itemToolSwordTurquoiseID = config.getItem("TurquoiseSword", 15006).getInt();
		itemToolSwordOnyxID = config.getItem("OnyxSword",15007).getInt();
		itemToolSwordAmethystID = config.getItem("AmethystSword",15008).getInt();
		itemToolSwordCitrineID = config.getItem("CitrineSword",15009).getInt();
		itemToolSwordEmeraldID = config.getItem("EmeraldSword", 15010).getInt();
		itemToolSwordRubyID = config.getItem("RubySword",15011).getInt();
		itemToolSwordSapphireID = config.getItem("SapphireSword",15012).getInt();
		
		itemToolPickaxeTurquoiseID = config.getItem("TurquoisePickaxe",15013).getInt();
		itemToolPickaxeOnyxID = config.getItem("OnyxPickaxe", 15014).getInt();
		itemToolPickaxeAmethystID = config.getItem("AmethystPickaxe", 15015).getInt();
		itemToolPickaxeCitrineID = config.getItem("CitrinePickaxe", 15016).getInt();
		itemToolPickaxeEmeraldID = config.getItem("EmeraldPickaxe", 15017).getInt();
		itemToolPickaxeRubyID = config.getItem("RubyPickaxe", 15018).getInt();
		itemToolPickaxeSapphireID = config.getItem("SapphirePickaxe",15018).getInt();
		itemToolPickaxeSuperID = config.getItem("SuperPickaxe",15019).getInt();
		itemToolHammerID = config.getItem("Hammer",15019).getInt();
		
		itemToolShovelTurquoiseID = config.getItem("TurquoiseShovel", 15020).getInt();
		itemToolShovelOnyxID = config.getItem("OnyxShovel",15021).getInt();
		itemToolShovelAmethystID = config.getItem("AmethystShovel",15022).getInt();
		itemToolShovelCitrineID = config.getItem("CitrineShovel",15023).getInt();
		itemToolShovelEmeraldID = config.getItem("EmeraldShovel",15024).getInt();
		itemToolShovelRubyID = config.getItem("RubyShovel",15025).getInt();
		itemToolShovelSapphireID = config.getItem("SapphireShovel",15026).getInt();
		itemToolShovelSuperID = config.getItem("SuperShovel",15027).getInt();
		
		itemToolAxeTurquoiseID = config.getItem("TurquoiseAxe", 15028).getInt();
		itemToolAxeOnyxID = config.getItem("OnyxAxe",15029).getInt();
		itemToolAxeAmethystID = config.getItem("AmethystAxe",15030).getInt();
		itemToolAxeCitrineID = config.getItem("CitrineAxe",15031).getInt();
		itemToolAxeEmeraldID = config.getItem("EmeraldAxe",15032).getInt();
		itemToolAxeRubyID = config.getItem("RubyAxe",15033).getInt();
		itemToolAxeSapphireID = config.getItem("SapphireAxe",15034).getInt();
		
		itemToolHoeTurquoiseID = config.getItem("TurquoiseHoe", 15035).getInt();
		itemToolHoeOnyxID = config.getItem("OnyxHoe", 15036).getInt();
		itemToolHoeAmethystID = config.getItem("AmethystHoe", 15037).getInt();
		itemToolHoeCitrineID = config.getItem("CitrienHoe",15038).getInt();
		itemToolHoeEmeraldID = config.getItem("EmeraldHoe", 15039).getInt();
		itemToolHoeRubyID = config.getItem("RubyHoe", 15040).getInt();
		itemToolHoeSapphireID = config.getItem("SapphireHoe",15041).getInt();
		
		
		itemArmorHelmetTurquoiseID = config.getItem("TurquoiseHelmet",15042).getInt();
		itemArmorPlateTurquoiseID = config.getItem("TurquoisePlate",15043).getInt();
		itemArmorLeggingsTurquoiseID = config.getItem("TurquoiseLeggings",15044).getInt();
		itemArmorBootsTurquoiseID = config.getItem("TurquoiseBoots",15045).getInt();
		
		itemArmorHelmetOnyxID = config.getItem("OnyxHelmet",15046).getInt();
		itemArmorPlateOnyxID = config.getItem("OnyxPlate",15047).getInt();
		itemArmorLeggingsOnyxID = config.getItem("OnyxLeggings",15048).getInt();
		itemArmorBootsOnyxID = config.getItem("OnyxBoots",15049).getInt();
		
		itemArmorHelmetAmethystID = config.getItem("AmethystHelmet",15050).getInt();
		itemArmorPlateAmethystID = config.getItem("AmethystPlate",15051).getInt();
		itemArmorLeggingsAmethystID = config.getItem("AmethystLeggings",15052).getInt();
		itemArmorBootsAmethystID = config.getItem("AmethystBoots",15053).getInt();
		
		itemArmorHelmetCitrineID = config.getItem("CitrineHelmet",15054).getInt();
		itemArmorPlateCitrineID = config.getItem("CitrinePlate",15055).getInt();
		itemArmorLeggingsCitrineID = config.getItem("CitrineLeggings",15056).getInt();
		itemArmorBootsCitrineID = config.getItem("CitrineBoots",15057).getInt();
		
		itemArmorHelmetEmeraldID = config.getItem("EmeraldHelmet",15058).getInt();
		itemArmorPlateEmeraldID = config.getItem("EmeraldPlate",15059).getInt();
		itemArmorLeggingsEmeraldID = config.getItem("EmeraldLeggings",15060).getInt();
		itemArmorBootsEmeraldID = config.getItem("EmeraldBoots",15061).getInt();
		
		itemArmorHelmetRubyID = config.getItem("RubyHelmet",15062).getInt();
		itemArmorPlateRubyID = config.getItem("RubyPlate",15063).getInt();
		itemArmorLeggingsRubyID = config.getItem("RubyLeggings",15064).getInt();
		itemArmorBootsRubyID = config.getItem("RubyBoots",15065).getInt();
		
		itemArmorHelmetSapphireID = config.getItem("SapphireHelmet",15066).getInt();
		itemArmorPlateSapphireID = config.getItem("SapphirePlate",15067).getInt();
		itemArmorLeggingsSapphireID = config.getItem("SapphireLeggings",15068).getInt();
		itemArmorBootsSapphireID = config.getItem("SapphireBoots",15069).getInt();
		
		itemStickID = config.getItem("Stick",15070).getInt();
		itemScreenID = config.getItem("Screen",15071).getInt();
		thorsHammerID = config.getItem("ThorsHammer",15072).getInt();
		dirtLayerID = config.getItem("DirtLayer",15073).getInt();
		itemToolInfiniteHammerID = config.getItem("Hammer2",15074).getInt();
		
		scytheTurquoiseID = config.getItem("Turquoise Scythe",15075).getInt();
		scytheOnyxID = config.getItem("Onyx Scythe",15076).getInt();
		scytheAmethystID = config.getItem("Amethyst Scythe",15077).getInt();
		scytheCitrineID = config.getItem("Citrine Scythe",15078).getInt();
		scytheEmeraldID = config.getItem("Emerald Scythe",15079).getInt();
		scytheRubyID = config.getItem("Ruby Scythe",15080).getInt();
		scytheSapphireID = config.getItem("Sapphire Scythe",15081).getInt();
		scytheWoodID = config.getItem("Wooden Scythe", 15082).getInt();
		scytheStoneID = config.getItem("Stone Scythe",15083).getInt();
		scytheIronID = config.getItem("Iron Scythe",15084).getInt();
		scytheGoldID = config.getItem("Gold Scythe",15085).getInt();
		scytheDiamondID = config.getItem("Diamond Scythe", 15086).getInt();
		
		itemMachinePanelID = config.getItem("Machine Panel",15087).getInt();
		
		oreBlockID = config.getBlock("Ore",250).getInt();
		gemBlockID = config.getBlock("GemBlock",251).getInt();
		pressureVesselID = config.getBlock("PressureVessel",252).getInt();
		sifterID = config.getBlock("Sifter",253).getInt();
		tumblerID = config.getBlock("Tumbler",254).getInt();
		Property plantList = config.get("Other","ScytheList","6 18 31 32 37 38 39 40 59 83 106 115 141 142 1301 1302 1307 1308 1309 1310 1505 1506 1510 1513 1610 1806 1812 1813 1814 1817 1819 1820 1835 3258 3259 3270 3281 3282");
		
		String[] splitPlantList = plantList.getString().split(" ");
		Vector<Integer> plantVector = new Vector();
		for(int i=0;i<splitPlantList.length;i++)
		{
			plantVector.add(Integer.parseInt(splitPlantList[i]));
		}
		int count = 0;
		plantWhitelist = new int[plantVector.size()];
		for(int i: plantVector) plantWhitelist[count++] = i;
		
		Property oreList = config.get("Other","OreWhiteList","14 15 16 21 48 49 56 73 89 129 153 200 244 245 246 247 248 249 412 419 425 432 441 444 450 451 668 1366 1398 1440 1442 1485 1486 1488 1801 2001 2320 2321 3347 3880 4080 4084 4085");
		String[] splitList = oreList.getString().split(" ");
		Vector<Integer> oreVector = new Vector();
		for(int i=0;i<splitList.length;i++)
		{
			oreVector.add(Integer.parseInt(splitList[i]));
		}
		count = 0;
		oreWhiteList = new int[oreVector.size()];
		for(int i: oreVector) oreWhiteList[count++] = i;
		config.save();
	}
	
	
}
