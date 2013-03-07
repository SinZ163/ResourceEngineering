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
	
	//Tools
	
	//Blocks
	
	//Armor
	
	//Other
	
	public static void loadConfig(FMLPreInitializationEvent e)
	{
		Configuration config = new Configuration(e.getSuggestedConfigurationFile());
		config.load();
		itemFlakeID = config.getItem("Metal Flake", 21000).getInt();
		itemGoldenPotatoID = config.getItem("Golden Potato", 21001).getInt();
		itemNuggetID = config.getItem("Metal Nugget", 21002).getInt();
		
		config.save();
	}
	
	
}
