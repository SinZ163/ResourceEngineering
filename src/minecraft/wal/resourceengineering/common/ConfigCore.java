package resourceengineering.common;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ConfigCore 
{
	//Items
	public static int itemFlakeID;
	public static int itemGoldenPotatoID;
	public static int itemNuggetID;
	public static int itemGemID;
	
	//Tools
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
	
	public static int itemToolShovelTurquoiseID;
	public static int itemToolShovelOnyxID;
	public static int itemToolShovelAmethystID;
	public static int itemToolShovelCitrineID;
	public static int itemToolShovelEmeraldID;
	public static int itemToolShovelRubyID;
	public static int itemToolShovelSapphireID;
	
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
	
	//Armor
	
	//Other
	
	public static void loadConfig(FMLPreInitializationEvent e)
	{
		Configuration config = new Configuration(e.getSuggestedConfigurationFile());
		config.load();
		itemFlakeID = config.getItem("MetalFlake", 21000).getInt();
		itemGoldenPotatoID = config.getItem("GoldenPotato", 21001).getInt();
		itemNuggetID = config.getItem("MetalNugget", 21002).getInt();
		itemGemID = config.getItem("Gem",21003).getInt();
		itemToolSwordTurquoiseID = config.getItem("TurquoiseSword", 21004).getInt();
		itemToolSwordOnyxID = config.getItem("OnyxSword",21005).getInt();
		itemToolSwordAmethystID = config.getItem("AmethystSword",21006).getInt();
		itemToolSwordCitrineID = config.getItem("CitrineSword",21007).getInt();
		itemToolSwordEmeraldID = config.getItem("EmeraldSword", 21008).getInt();
		itemToolSwordRubyID = config.getItem("RubySword",21009).getInt();
		itemToolSwordSapphireID = config.getItem("SapphireSword",21010).getInt();
		
		itemToolPickaxeTurquoiseID = config.getItem("TurquoisePickaxe",21011).getInt();
		itemToolPickaxeOnyxID = config.getItem("OnyxPickaxe", 21012).getInt();
		itemToolPickaxeAmethystID = config.getItem("AmethystPickaxe", 21013).getInt();
		itemToolPickaxeCitrineID = config.getItem("CitrinePickaxe", 21014).getInt();
		itemToolPickaxeEmeraldID = config.getItem("EmeraldPickaxe", 21015).getInt();
		itemToolPickaxeRubyID = config.getItem("RubyPickaxe", 21016).getInt();
		itemToolPickaxeSapphireID = config.getItem("SapphirePickaxe",21017).getInt();
		
		itemToolShovelTurquoiseID = config.getItem("TurquoiseShovel", 21018).getInt();
		itemToolShovelOnyxID = config.getItem("OnyxShovel",21019).getInt();
		itemToolShovelAmethystID = config.getItem("AmethystShovel",21020).getInt();
		itemToolShovelCitrineID = config.getItem("CitrineShovel",21021).getInt();
		itemToolShovelEmeraldID = config.getItem("EmeraldShovel",21022).getInt();
		itemToolShovelRubyID = config.getItem("RubyShovel",21023).getInt();
		itemToolShovelSapphireID = config.getItem("SapphireShovel",21024).getInt();
		
		itemToolAxeTurquoiseID = config.getItem("TurquoiseAxe", 21025).getInt();
		itemToolAxeOnyxID = config.getItem("OnyxAxe",21026).getInt();
		itemToolAxeAmethystID = config.getItem("AmethystAxe",21027).getInt();
		itemToolAxeCitrineID = config.getItem("CitrineAxe",21028).getInt();
		itemToolAxeEmeraldID = config.getItem("EmeraldAxe",21029).getInt();
		itemToolAxeRubyID = config.getItem("RubyAxe",21030).getInt();
		itemToolAxeSapphireID = config.getItem("SapphireAxe",21031).getInt();
		
		itemToolHoeTurquoiseID = config.getItem("TurquoiseHoe", 21032).getInt();
		itemToolHoeOnyxID = config.getItem("OnyxHoe", 21033).getInt();
		itemToolHoeAmethystID = config.getItem("AmethystHoe", 21034).getInt();
		itemToolHoeCitrineID = config.getItem("CitrienHoe",21035).getInt();
		itemToolHoeEmeraldID = config.getItem("EmeraldHoe", 21036).getInt();
		itemToolHoeRubyID = config.getItem("RubyHoe", 21037).getInt();
		itemToolHoeSapphireID = config.getItem("SapphireHoe",21038).getInt();
		
		
		itemArmorHelmetTurquoiseID = config.getItem("TurquoiseHelmet",21039).getInt();
		itemArmorPlateTurquoiseID = config.getItem("TurquoisePlate",21040).getInt();
		itemArmorLeggingsTurquoiseID = config.getItem("TurquoiseLeggings",21041).getInt();
		itemArmorBootsTurquoiseID = config.getItem("TurquoiseBoots",21042).getInt();
		
		itemArmorHelmetOnyxID = config.getItem("OnyxHelmet",21043).getInt();
		itemArmorPlateOnyxID = config.getItem("OnyxPlate",21044).getInt();
		itemArmorLeggingsOnyxID = config.getItem("OnyxLeggings",21045).getInt();
		itemArmorBootsOnyxID = config.getItem("OnyxBoots",21046).getInt();
		
		itemArmorHelmetAmethystID = config.getItem("AmethystHelmet",21047).getInt();
		itemArmorPlateAmethystID = config.getItem("AmethystPlate",21048).getInt();
		itemArmorLeggingsAmethystID = config.getItem("AmethystLeggings",21049).getInt();
		itemArmorBootsAmethystID = config.getItem("AmethystBoots",21050).getInt();
		
		itemArmorHelmetCitrineID = config.getItem("CitrineHelmet",21051).getInt();
		itemArmorPlateCitrineID = config.getItem("CitrinePlate",21052).getInt();
		itemArmorLeggingsCitrineID = config.getItem("CitrineLeggings",21053).getInt();
		itemArmorBootsCitrineID = config.getItem("CitrineBoots",21054).getInt();
		
		itemArmorHelmetEmeraldID = config.getItem("EmeraldHelmet",21055).getInt();
		itemArmorPlateEmeraldID = config.getItem("EmeraldPlate",21056).getInt();
		itemArmorLeggingsEmeraldID = config.getItem("EmeraldLeggings",21057).getInt();
		itemArmorBootsEmeraldID = config.getItem("EmeraldBoots",21058).getInt();
		
		itemArmorHelmetRubyID = config.getItem("RubyHelmet",21059).getInt();
		itemArmorPlateRubyID = config.getItem("RubyPlate",21060).getInt();
		itemArmorLeggingsRubyID = config.getItem("RubyLeggings",21061).getInt();
		itemArmorBootsRubyID = config.getItem("RubyBoots",21062).getInt();
		
		itemArmorHelmetSapphireID = config.getItem("SapphireHelmet",21063).getInt();
		itemArmorPlateSapphireID = config.getItem("SapphirePlate",21064).getInt();
		itemArmorLeggingsSapphireID = config.getItem("SapphireLeggings",21065).getInt();
		itemArmorBootsSapphireID = config.getItem("SapphireBoots",21066).getInt();
		
		oreBlockID = config.getBlock("Ore",250).getInt();
		gemBlockID = config.getBlock("GemBlock",251).getInt();
		
		config.save();
	}
	
	
}
