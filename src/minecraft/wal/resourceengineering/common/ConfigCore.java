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
		
		oreBlockID = config.getBlock("Ore",250).getInt();
		gemBlockID = config.getBlock("GemBlock",251).getInt();
		
		config.save();
	}
	
	
}
