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
		//TODO: Add the rest of the gems here
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gem,1,0),"Turquoise");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gem,1,1),"Onyx");
		
		//Ores
		//TODO: Add the rest of the ores here
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.oreBlock,1,0),"Turquoise Ore");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.oreBlock,1,1),"Onyx Ore");
		
		//Gem Blocks:
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gemBlock,1,0), "Turquoise Block");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gemBlock,1,1), "Onyx Block");
	}
	public void addRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(Item.goldNugget,1),"XXX","XXX","XXX",Character.valueOf('X'),new ItemStack(ResourceEngineeringMain.flake,1,1));//gold nugget from 9 gold flakes
		GameRegistry.addRecipe(new ItemStack(ResourceEngineeringMain.nugget,1,0),"XXX","XXX","XXX",Character.valueOf('X'),new ItemStack(ResourceEngineeringMain.flake,1,0));//iron nugget from 9 iron flakes
		GameRegistry.addRecipe(new ItemStack(Item.ingotIron,1),"XXX","XXX","XXX",Character.valueOf('X'),new ItemStack(ResourceEngineeringMain.nugget,1,0));//iron ingot from 9 iron nuggets
		
		GameRegistry.addRecipe(new ItemStack(ResourceEngineeringMain.goldenPotato,1,0),"XXX","XAX","XXX",Character.valueOf('X'),new ItemStack(ResourceEngineeringMain.flake,1,1),Character.valueOf('A'),Item.poisonousPotato);
		
		//Gem Block Recipes
		GameRegistry.addRecipe(new ItemStack(ResourceEngineeringMain.gemBlock,1,0),"XXX","XXX","XXX",Character.valueOf('X'),new ItemStack(ResourceEngineeringMain.gem,1,0));//Turquoise block from Turquoise Gems
		GameRegistry.addRecipe(new ItemStack(ResourceEngineeringMain.gemBlock,1,1),"XXX","XXX","XXX",Character.valueOf('X'),new ItemStack(ResourceEngineeringMain.gem,1,1));//Onyx block from Onyx Gems
		
		//Gem from Block Recipes
		GameRegistry.addShapelessRecipe(new ItemStack(ResourceEngineeringMain.gem,9,0),new ItemStack(ResourceEngineeringMain.gemBlock,1,0));
		GameRegistry.addShapelessRecipe(new ItemStack(ResourceEngineeringMain.gem,9,1),new ItemStack(ResourceEngineeringMain.gemBlock,1,1));
	}
}
