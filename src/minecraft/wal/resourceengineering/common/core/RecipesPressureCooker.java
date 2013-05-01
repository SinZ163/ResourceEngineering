package resourceengineering.common.core;

import java.util.HashMap;
import java.util.Map;

import resourceengineering.common.ResourceEngineeringMain;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class RecipesPressureCooker 
	{
	private static final RecipesPressureCooker pressureCooker = new RecipesPressureCooker();

	/** The list of smelting results. */
	private Map pressureCookerIDList = new HashMap();
	private Map pressureCookerExperience = new HashMap();

	/**
	* Used to call methods addSmelting and getSmeltingResult.
	*/
	public static final RecipesPressureCooker smelting()
	{
	return pressureCooker;
	}

	private RecipesPressureCooker()
	{
	addSmelting(ResourceEngineeringMain.flakeGold.itemID,new ItemStack(Item.goldNugget,1),1.0F);
	addSmelting(ResourceEngineeringMain.flakeIron.itemID,new ItemStack(ResourceEngineeringMain.nugget,1,0),1.0F);
	addSmelting(ResourceEngineeringMain.diamondChip.itemID,new ItemStack(Item.diamond,1),10.0F);
	}

	/**
	* Adds a smelting recipe.
	*/
	public void addSmelting(int id, ItemStack resultStack, float experience)
	{
		pressureCookerIDList.put(Integer.valueOf(id), resultStack);
		pressureCookerExperience.put(Integer.valueOf(resultStack.itemID), Float.valueOf(experience));
	}

	/**
	* Returns the smelting result of an item.
	*/
	public ItemStack getSmeltingResult(int id)
	{
		return (ItemStack)pressureCookerIDList.get(Integer.valueOf(id));
	}

	public Map getSmeltingList()
	{
	return pressureCookerIDList;
	}
	public float getExperience(int par1)
	{
	return this.pressureCookerExperience.containsKey(Integer.valueOf(par1)) ? ((Float)this.pressureCookerExperience.get(Integer.valueOf(par1))).floatValue() : 0.0F;
	}
	}