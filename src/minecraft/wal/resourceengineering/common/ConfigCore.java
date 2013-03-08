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
	
	//Blocks
	public static int oreBlockID;
	public static int gemBlockID;
	
	//Armor
	
	//Other
	
	public static void loadConfig(FMLPreInitializationEvent e)
	{
		Configuration config = new Configuration(e.getSuggestedConfigurationFile());
		config.load();
		itemFlakeID = config.getItem("Metal Flake", 21000).getInt();
		itemGoldenPotatoID = config.getItem("Golden Potato", 21001).getInt();
		itemNuggetID = config.getItem("Metal Nugget", 21002).getInt();
		itemGemID = config.getItem("Gem",21003).getInt();
		itemToolSwordTurquoiseID = config.getItem("Turquoise Sword", 21004).getInt();
		
		oreBlockID = config.getBlock("Ore",250).getInt();
		gemBlockID = config.getBlock("GemBlock",251).getInt();
		
		config.save();
	}
	
	
}
