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
		
		oreBlockID = config.getBlock("Ore",250).getInt();
		gemBlockID = config.getBlock("GemBlock",251).getInt();
		
		config.save();
	}
	
	
}
