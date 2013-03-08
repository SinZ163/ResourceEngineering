package resourceengineering.common.core;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import resourceengineering.common.ResourceEngineeringMain;
import resourceengineering.common.core.items.ItemBlockOre;
import resourceengineering.common.core.items.ItemBlockGem;

public class CommonProxy implements IGuiHandler
{
	public void registerRenderInformation()
	{
		
	}
	@Override
	public Object getServerGuiElement(int ID,EntityPlayer player, World world, int x, int y, int z)
	{
		
		return null;
	}
	@Override
	public Object getClientGuiElement(int ID,EntityPlayer player, World world, int x, int y, int z)
	{
		
		return null;
	}
	public void registerTiles()
	{
		
	}
	public void registerOre()
	{
		OreDictionary.registerOre("nuggetIron",new ItemStack(ResourceEngineeringMain.nugget,1,0));
		OreDictionary.registerOre("gemTurquoise",new ItemStack(ResourceEngineeringMain.gem,1,0));
		OreDictionary.registerOre("gemOnyx",new ItemStack(ResourceEngineeringMain.gem,1,1));
		OreDictionary.registerOre("gemAmethyst", new ItemStack(ResourceEngineeringMain.gem,1,2));
		OreDictionary.registerOre("gemCitrine",new ItemStack(ResourceEngineeringMain.gem,1,3));
		OreDictionary.registerOre("gemEmerald",new ItemStack(ResourceEngineeringMain.gem,1,4));
		OreDictionary.registerOre("gemRuby",new ItemStack(ResourceEngineeringMain.gem,1,5));
		OreDictionary.registerOre("gemSapphire", new ItemStack(ResourceEngineeringMain.gem,1,6));
	}
	public void registerBlocks()
	{
		GameRegistry.registerBlock(ResourceEngineeringMain.oreBlock,ItemBlockOre.class,"wal_Ore");
		GameRegistry.registerBlock(ResourceEngineeringMain.gemBlock,ItemBlockGem.class,"wal_GemBlock");
	}
	public void addNames()
	{
		//Food Items
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.goldenPotato,1,0),"Golden Potato");
		
		//Metal Flakes
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.flake,1,0),"Iron Flake");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.flake,1,1),"Gold Flake");
		
		//Metal Nuggets
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.nugget,1,0),"Iron Nugget");
		
		//Gems
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gem,1,0),"Turquoise");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gem,1,1),"Onyx");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gem,1,2),"Amethyst");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gem,1,3),"Citrine");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gem,1,4),"Emerald");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gem,1,5),"Ruby");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gem,1,6),"Sapphire");
		
		//Ores
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.oreBlock,1,0),"Turquoise Ore");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.oreBlock,1,1),"Onyx Ore");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.oreBlock,1,2),"Amethyst Ore");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.oreBlock,1,3),"Citrine Ore");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.oreBlock,1,4),"Emerald Ore");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.oreBlock,1,5),"Ruby Ore");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.oreBlock,1,6),"Sapphire Ore");
		
		//Gem Blocks:
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gemBlock,1,0), "Turquoise Block");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gemBlock,1,1), "Onyx Block");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gemBlock,1,2), "Amethyst Block");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gemBlock,1,3), "Citrine Block");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gemBlock,1,4), "Emerald Block");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gemBlock,1,5), "Ruby Block");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gemBlock,1,6), "Sapphire Block");
		
		//Swords
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.turquoiseSword,1,0),"Turquoise Sword");
	}
	public void addRecipes()
	{
		//Temp crafting recipes for nuggets from flakes, will eventually be smelting
		GameRegistry.addRecipe(new ItemStack(Item.goldNugget,1),"XXX","XXX","XXX",Character.valueOf('X'),new ItemStack(ResourceEngineeringMain.flake,1,1));//gold nugget from 9 gold flakes
		GameRegistry.addRecipe(new ItemStack(ResourceEngineeringMain.nugget,1,0),"XXX","XXX","XXX",Character.valueOf('X'),new ItemStack(ResourceEngineeringMain.flake,1,0));//iron nugget from 9 iron flakes
		
		//Ingot crafting recipe(s)
		GameRegistry.addRecipe(new ItemStack(Item.ingotIron,1),"XXX","XXX","XXX",Character.valueOf('X'),new ItemStack(ResourceEngineeringMain.nugget,1,0));//iron ingot from 9 iron nuggets
		
		//Golden Potato Recipe
		GameRegistry.addRecipe(new ItemStack(ResourceEngineeringMain.goldenPotato,1,0),"XXX","XAX","XXX",Character.valueOf('X'),new ItemStack(ResourceEngineeringMain.flake,1,1),Character.valueOf('A'),Item.poisonousPotato);
		
		//Gem Block Recipes
		GameRegistry.addRecipe(new ItemStack(ResourceEngineeringMain.gemBlock,1,0),"XXX","XXX","XXX",Character.valueOf('X'),new ItemStack(ResourceEngineeringMain.gem,1,0));//Turquoise block from Turquoise Gems
		GameRegistry.addRecipe(new ItemStack(ResourceEngineeringMain.gemBlock,1,1),"XXX","XXX","XXX",Character.valueOf('X'),new ItemStack(ResourceEngineeringMain.gem,1,1));//Onyx block from Onyx Gems
		GameRegistry.addRecipe(new ItemStack(ResourceEngineeringMain.gemBlock,1,2),"XXX","XXX","XXX",Character.valueOf('X'),new ItemStack(ResourceEngineeringMain.gem,1,2));//Amethyst block from Amethyst Gems
		GameRegistry.addRecipe(new ItemStack(ResourceEngineeringMain.gemBlock,1,3),"XXX","XXX","XXX",Character.valueOf('X'),new ItemStack(ResourceEngineeringMain.gem,1,3));//Citrine block from Citrine Gems
		GameRegistry.addRecipe(new ItemStack(ResourceEngineeringMain.gemBlock,1,4),"XXX","XXX","XXX",Character.valueOf('X'),new ItemStack(ResourceEngineeringMain.gem,1,4));//Emerald block from Emerald Gems
		GameRegistry.addRecipe(new ItemStack(ResourceEngineeringMain.gemBlock,1,5),"XXX","XXX","XXX",Character.valueOf('X'),new ItemStack(ResourceEngineeringMain.gem,1,5));//Ruby block from Ruby Gems
		GameRegistry.addRecipe(new ItemStack(ResourceEngineeringMain.gemBlock,1,6),"XXX","XXX","XXX",Character.valueOf('X'),new ItemStack(ResourceEngineeringMain.gem,1,6));//Sapphire block from Sapphire Gems
		
		//Gem from Block Recipes
		GameRegistry.addShapelessRecipe(new ItemStack(ResourceEngineeringMain.gem,9,0),new ItemStack(ResourceEngineeringMain.gemBlock,1,0));
		GameRegistry.addShapelessRecipe(new ItemStack(ResourceEngineeringMain.gem,9,1),new ItemStack(ResourceEngineeringMain.gemBlock,1,1));
		GameRegistry.addShapelessRecipe(new ItemStack(ResourceEngineeringMain.gem,9,2),new ItemStack(ResourceEngineeringMain.gemBlock,1,2));
		GameRegistry.addShapelessRecipe(new ItemStack(ResourceEngineeringMain.gem,9,3),new ItemStack(ResourceEngineeringMain.gemBlock,1,3));
		GameRegistry.addShapelessRecipe(new ItemStack(ResourceEngineeringMain.gem,9,4),new ItemStack(ResourceEngineeringMain.gemBlock,1,4));
		GameRegistry.addShapelessRecipe(new ItemStack(ResourceEngineeringMain.gem,9,5),new ItemStack(ResourceEngineeringMain.gemBlock,1,5));
		GameRegistry.addShapelessRecipe(new ItemStack(ResourceEngineeringMain.gem,9,6),new ItemStack(ResourceEngineeringMain.gemBlock,1,6));
		
		//Smelting gem ore
		int xpPerSmelt=5;
		FurnaceRecipes.smelting().addSmelting(ResourceEngineeringMain.oreBlock.blockID,0,new ItemStack(ResourceEngineeringMain.gem,5,0),xpPerSmelt);
		FurnaceRecipes.smelting().addSmelting(ResourceEngineeringMain.oreBlock.blockID,1,new ItemStack(ResourceEngineeringMain.gem,5,1),xpPerSmelt);
		FurnaceRecipes.smelting().addSmelting(ResourceEngineeringMain.oreBlock.blockID,2,new ItemStack(ResourceEngineeringMain.gem,5,2),xpPerSmelt);
		FurnaceRecipes.smelting().addSmelting(ResourceEngineeringMain.oreBlock.blockID,3,new ItemStack(ResourceEngineeringMain.gem,5,3),xpPerSmelt);
		FurnaceRecipes.smelting().addSmelting(ResourceEngineeringMain.oreBlock.blockID,4,new ItemStack(ResourceEngineeringMain.gem,5,4),xpPerSmelt);
		FurnaceRecipes.smelting().addSmelting(ResourceEngineeringMain.oreBlock.blockID,5,new ItemStack(ResourceEngineeringMain.gem,5,5),xpPerSmelt);
		FurnaceRecipes.smelting().addSmelting(ResourceEngineeringMain.oreBlock.blockID,6,new ItemStack(ResourceEngineeringMain.gem,5,6),xpPerSmelt);
		
		//Sword Recipes
		GameRegistry.addRecipe(new ItemStack(ResourceEngineeringMain.turquoiseSword,1,0),"X","X","A",Character.valueOf('X'),new ItemStack(ResourceEngineeringMain.gem,1,0),Character.valueOf('A'),new ItemStack(Item.stick,1,0));
	}
}
