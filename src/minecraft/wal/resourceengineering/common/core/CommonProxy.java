package resourceengineering.common.core;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import resourceengineering.common.ResourceEngineeringMain;
import resourceengineering.common.core.items.ItemBlockOre;
import resourceengineering.common.core.items.ItemBlockGem;
import resourceengineering.common.core.tileentity.GemTumblerTileEntity;
import resourceengineering.common.core.tileentity.PressureCookerTileEntity;
import resourceengineering.common.core.tileentity.SifterTileEntity;

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
	public int addArmor(String armor)
	{
		return 0;
	}
	
	public void registerTileEntities()
	{
		GameRegistry.registerTileEntity(PressureCookerTileEntity.class,"tileEntityPressureCooker");
		GameRegistry.registerTileEntity(SifterTileEntity.class, "tileEntitySifter");
		GameRegistry.registerTileEntity(GemTumblerTileEntity.class,"tileEntityTumbler");
	}
	public void registerOre()
	{
		OreDictionary.registerOre("nuggetIron",new ItemStack(ResourceEngineeringMain.nugget,1,0));
	}
	public void registerBlocks()
	{
		GameRegistry.registerBlock(ResourceEngineeringMain.oreBlock,ItemBlockOre.class,"wal_Ore");
		GameRegistry.registerBlock(ResourceEngineeringMain.gemBlock,ItemBlockGem.class,"wal_GemBlock");
		
		GameRegistry.registerBlock(ResourceEngineeringMain.blockPressureVessel,"wal_pressureVessel");
		GameRegistry.registerBlock(ResourceEngineeringMain.sifter,"wal_sifter");
		GameRegistry.registerBlock(ResourceEngineeringMain.tumbler,"wal_tumbler");
	}
	public void addNames()
	{
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.dirtLayer,1,0),"Dirt Layer");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.ThorsHammer,1,0),"Thors Hammer");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.InfiniteHammer,1,0),"Hammer");
		//Machines
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.blockPressureVessel,1,0),"Pressure Vessel");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.sifter,1,0),"Sifter");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.tumbler,1,0),"Gem Tumbler");
		//Food Items
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.goldenPotato,1,0),"Golden Potato");
		
		//Misc Materials
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.stick,1,0),"Diamond Stick");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.stick,1,1),"Sapphire Stick");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.screen,1),"Screen");
		
		//Metal Flakes
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.flakeIron,1),"Iron Flake");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.flakeGold,1),"Gold Flake");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.diamondChip,1),"Diamond Chip");
		
		//Metal Nuggets
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.nugget,1,0),"Iron Nugget");
		
		//Gems
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gem,1,0),"Raw Turquoise");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gem,1,1),"Raw Onyx");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gem,1,2),"Raw Amethyst");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gem,1,3),"Raw Citrine");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gem,1,4),"Raw Emerald");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gem,1,5),"Raw Ruby");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gem,1,6),"Raw Sapphire");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gem,1,7),"Refined Turquoise");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gem,1,8),"Refined Onyx");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gem,1,9),"Refined Amethyst");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gem,1,10),"Refined Citrine");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gem,1,11),"Refined Emerald");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gem,1,12),"Refined Ruby");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gem,1,13),"Refined Sapphire");
		
		//Ores
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.oreBlock,1,0),"Turquoise Ore");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.oreBlock,1,1),"Onyx Ore");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.oreBlock,1,2),"Amethyst Ore");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.oreBlock,1,3),"Citrine Ore");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.oreBlock,1,4),"Emerald Ore");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.oreBlock,1,5),"Ruby Ore");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.oreBlock,1,6),"Sapphire Ore");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.oreBlock,1,7),"Loaded Dirt");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.oreBlock,1,8),"Loaded Sand");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.oreBlock,1,9),"Loaded Gravel");
		
		//Gem Blocks:
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gemBlock,1,0), "Turquoise Block");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gemBlock,1,1), "Onyx Block");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gemBlock,1,2), "Amethyst Block");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gemBlock,1,3), "Citrine Block");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gemBlock,1,4), "Emerald Block");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gemBlock,1,5), "Ruby Block");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gemBlock,1,6), "Sapphire Block");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.gemBlock,1,7), "Mixed Gem Block");
		
		//Swords
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.turquoiseSword,1,0),"Turquoise Sword");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.onyxSword,1,0),"Onyx Sword");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.amethystSword,1,0),"Amethyst Sword");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.citrineSword,1,0),"Citrine Sword");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.emeraldSword,1,0),"Emerald Sword");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.rubySword,1,0),"Ruby Sword");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.sapphireSword,1,0),"Sapphire Sword");
		
		//Pickaxes
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.turquoisePickaxe,1,0),"Turquoise Pickaxe");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.onyxPickaxe,1,0),"Onyx Pickaxe");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.amethystPickaxe,1,0),"Amethyst Pickaxe");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.citrinePickaxe,1,0),"Citrine Pickaxe");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.emeraldPickaxe,1,0),"Emerald Pickaxe");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.rubyPickaxe,1,0),"Ruby Pickaxe");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.sapphirePickaxe,1,0),"Sapphire Pickaxe");
		
		//Shovels
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.turquoiseShovel,1,0),"Turquoise Shovel");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.onyxShovel,1,0),"Onyx Shovel");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.amethystShovel,1,0),"Amethyst Shovel");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.citrineShovel,1,0),"Citrine Shovel");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.emeraldShovel,1,0),"Emerald Shovel");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.rubyShovel,1,0),"Ruby Shovel");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.sapphireShovel,1,0),"Sapphire Shovel");
		
		//Axes
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.turquoiseAxe,1,0),"Turquoise Axe");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.onyxAxe,1,0),"Onyx Axe");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.amethystAxe,1,0),"Amethyst Axe");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.citrineAxe,1,0),"Citrine Axe");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.emeraldAxe,1,0),"Emerald Axe");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.rubyAxe,1,0),"Ruby Axe");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.sapphireAxe,1,0),"Sapphire Axe");
		
		//Hoes
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.turquoiseHoe,1,0),"Turquoise Hoe");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.onyxHoe,1,0),"Onyx Hoe");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.amethystHoe,1,0),"Amethyst Hoe");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.citrineHoe,1,0),"Citrine Hoe");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.emeraldHoe,1,0), "Emerald Hoe");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.rubyHoe,1,0),"Ruby Hoe");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.sapphireHoe,1,0),"Sapphire");
		
		//Armor
		//Turquoise Armor
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.turquoiseHelmet,1,0),"Turquoise Helmet");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.turquoisePlate,1,0),"Turquoise Plate");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.turquoiseLeggings,1,0),"Turquoise Leggings");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.turquoiseBoots,1,0),"Turquoise Boots");
		
		//Onyx Armor
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.onyxHelmet,1,0),"Onyx Helmet");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.onyxPlate,1,0),"Onyx Plate");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.onyxLeggings,1,0), "Onyx Leggings");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.onyxBoots,1,0),"Onyx Boots");
		
		//Amethyst Armor
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.amethystHelmet,1,0),"Amethyst Helmet");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.amethystPlate,1,0),"Amethyst Plate");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.amethystLeggings,1,0),"Amethyst Leggings");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.amethystBoots,1,0),"Amethyst Boots");
		
		//Citrine Armor
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.citrineHelmet,1,0),"Citrine Helmet");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.citrinePlate,1,0),"Citrine Plate");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.citrineLeggings,1,0),"Citrine Leggings");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.citrineBoots,1,0),"Citrine Boots");
		
		//Emerald Armor
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.emeraldHelmet,1,0),"Emerald Helmet");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.emeraldPlate,1,0),"Emerald Plate");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.emeraldLeggings,1,0),"Emerald Leggings");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.emeraldBoots,1,0),"Emerald Boots");
		
		//Ruby Armor
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.rubyHelmet,1,0),"Ruby Helmet");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.rubyPlate,1,0),"Ruby Plate");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.rubyLeggings,1,0),"Ruby Leggings");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.rubyBoots,1,0),"Ruby Boots");
		
		//Sapphire Armor
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.sapphireHelmet,1,0),"Sapphire Helmet");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.sapphirePlate,1,0),"Sapphire Plate");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.sapphireLeggings,1,0),"Sapphire Leggings");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.sapphireBoots,1,0),"Sapphire Boots");
		
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.superPickaxe,1,0),"Super Pickaxe");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.superShovel,1,0), "Super Shovel");
		LanguageRegistry.addName(new ItemStack(ResourceEngineeringMain.hammer,1,0),"Hammer");
	}
	public void addRecipes()
	{
		//Gem Item Stack Variables
		ItemStack rawTurquoise = new ItemStack(ResourceEngineeringMain.gem,1,0);
		ItemStack rawOnyx = new ItemStack(ResourceEngineeringMain.gem,1,1);
		ItemStack rawAmethyst = new ItemStack(ResourceEngineeringMain.gem,1,2);
		ItemStack rawCitrine = new ItemStack(ResourceEngineeringMain.gem,1,3);
		ItemStack rawEmerald = new ItemStack(ResourceEngineeringMain.gem,1,4);
		ItemStack rawRuby = new ItemStack(ResourceEngineeringMain.gem,1,5);
		ItemStack rawSapphire = new ItemStack(ResourceEngineeringMain.gem,1,6);
		ItemStack turquoiseGem = new ItemStack(ResourceEngineeringMain.gem,1,7);
		ItemStack onyxGem = new ItemStack(ResourceEngineeringMain.gem,1,8);
		ItemStack amethystGem = new ItemStack(ResourceEngineeringMain.gem,1,9);
		ItemStack citrineGem = new ItemStack(ResourceEngineeringMain.gem,1,10);
		ItemStack emeraldGem = new ItemStack(ResourceEngineeringMain.gem,1,11);
		ItemStack rubyGem = new ItemStack(ResourceEngineeringMain.gem,1,12);
		ItemStack sapphireGem = new ItemStack(ResourceEngineeringMain.gem,1,13);
		
		ItemStack diamondChip = new ItemStack(ResourceEngineeringMain.diamondChip,1);
		
		//Misc Item Stack variables
		ItemStack stick = new ItemStack(Item.stick,1,0);
		ItemStack diamondStick = new ItemStack(ResourceEngineeringMain.stick,1,0);
		ItemStack sapphireStick = new ItemStack(ResourceEngineeringMain.stick,1,1);
		
		GameRegistry.addRecipe(new ItemStack(ResourceEngineeringMain.ThorsHammer,1),"HHH","DSD","SDS",Character.valueOf('H'),new ItemStack(ResourceEngineeringMain.gemBlock,1,7),Character.valueOf('D'),diamondStick,Character.valueOf('S'),sapphireStick);
		
		GameRegistry.addRecipe(new ItemStack(ResourceEngineeringMain.screen,1),"SIS","ISI","SIS",Character.valueOf('S'),stick,Character.valueOf('I'),new ItemStack(Item.ingotIron));
		
		GameRegistry.addRecipe(new ItemStack(ResourceEngineeringMain.dirtLayer,1),"G","S","S",Character.valueOf('G'),new ItemStack(ResourceEngineeringMain.gemBlock,1,7),Character.valueOf('S'),diamondStick);
		
		//Machines
		GameRegistry.addRecipe(new ItemStack(ResourceEngineeringMain.tumbler,1),"PWP","WSW","PWP",
				Character.valueOf('P'),new ItemStack(Block.pistonBase,1),
				Character.valueOf('S'),new ItemStack(ResourceEngineeringMain.sifter,1),
				Character.valueOf('W'),new ItemStack(Block.cloth,1,-1));
		GameRegistry.addRecipe(new ItemStack(ResourceEngineeringMain.blockPressureVessel,1),"XXX","PFP","XXX",Character.valueOf('X'),new ItemStack(Block.obsidian),Character.valueOf('P'),new ItemStack(Block.pistonBase),Character.valueOf('F'),new ItemStack(Block.stoneOvenIdle));
		GameRegistry.addRecipe(new ItemStack(ResourceEngineeringMain.sifter,1),"ISI","ISI","ISI",Character.valueOf('I'),new ItemStack(Block.blockSteel),Character.valueOf('S'),new ItemStack(ResourceEngineeringMain.screen,1));
		
		//Sticks
		GameRegistry.addRecipe(new ItemStack(ResourceEngineeringMain.stick,2,0),"A","A","A",Character.valueOf('A'),diamondChip);
		GameRegistry.addRecipe(new ItemStack(ResourceEngineeringMain.stick,2,1),"A","A","A",Character.valueOf('A'),sapphireGem);
		
		//Super Pickaxe Recipe(temp)
		GameRegistry.addRecipe(new ItemStack(ResourceEngineeringMain.superPickaxe,1,0),"DSD"," A "," A ",Character.valueOf('D'),new ItemStack(Item.diamond),Character.valueOf('S'),sapphireGem,Character.valueOf('A'),diamondStick);
		GameRegistry.addRecipe(new ItemStack(ResourceEngineeringMain.superShovel,1,0)," S ","DAD"," A ",Character.valueOf('S'),sapphireGem,Character.valueOf('D'),new ItemStack(Item.diamond),Character.valueOf('A'),diamondStick);
		GameRegistry.addRecipe(new ItemStack(ResourceEngineeringMain.hammer,1,0),"SDS"," A "," A ",Character.valueOf('A'),sapphireStick,Character.valueOf('D'),new ItemStack(Item.diamond),Character.valueOf('S'),new ItemStack(ResourceEngineeringMain.gemBlock,1,5));
		
		//Ingot crafting recipe(s)
		GameRegistry.addRecipe(new ItemStack(Item.ingotIron,1),"XXX","XXX","XXX",Character.valueOf('X'),new ItemStack(ResourceEngineeringMain.nugget,1,0));//iron ingot from 9 iron nuggets
		
		//Golden Potato Recipe
		GameRegistry.addRecipe(new ItemStack(ResourceEngineeringMain.goldenPotato,1,0),"XXX","XAX","XXX",Character.valueOf('X'),new ItemStack(ResourceEngineeringMain.flakeGold,1),Character.valueOf('A'),Item.poisonousPotato);
		
		//Gem Block Recipes
		GameRegistry.addRecipe(new ItemStack(ResourceEngineeringMain.gemBlock,1,0),"XXX","XXX","XXX",Character.valueOf('X'),turquoiseGem);//Turquoise block from Turquoise Gems
		GameRegistry.addRecipe(new ItemStack(ResourceEngineeringMain.gemBlock,1,1),"XXX","XXX","XXX",Character.valueOf('X'),onyxGem);//Onyx block from Onyx Gems
		GameRegistry.addRecipe(new ItemStack(ResourceEngineeringMain.gemBlock,1,2),"XXX","XXX","XXX",Character.valueOf('X'),amethystGem);//Amethyst block from Amethyst Gems
		GameRegistry.addRecipe(new ItemStack(ResourceEngineeringMain.gemBlock,1,3),"XXX","XXX","XXX",Character.valueOf('X'),citrineGem);//Citrine block from Citrine Gems
		GameRegistry.addRecipe(new ItemStack(ResourceEngineeringMain.gemBlock,1,4),"XXX","XXX","XXX",Character.valueOf('X'),emeraldGem);//Emerald block from Emerald Gems
		GameRegistry.addRecipe(new ItemStack(ResourceEngineeringMain.gemBlock,1,5),"XXX","XXX","XXX",Character.valueOf('X'),rubyGem);//Ruby block from Ruby Gems
		GameRegistry.addRecipe(new ItemStack(ResourceEngineeringMain.gemBlock,1,6),"XXX","XXX","XXX",Character.valueOf('X'),sapphireGem);//Sapphire block from Sapphire Gems
		GameRegistry.addRecipe(new ItemStack(ResourceEngineeringMain.gemBlock,1,7),"ACE","ODR","TIS",
				Character.valueOf('A'),new ItemStack(ResourceEngineeringMain.gemBlock,1,2),
				Character.valueOf('C'),new ItemStack(ResourceEngineeringMain.gemBlock,1,3),
				Character.valueOf('E'),new ItemStack(ResourceEngineeringMain.gemBlock,1,4),
				Character.valueOf('O'),new ItemStack(ResourceEngineeringMain.gemBlock,1,1),
				Character.valueOf('D'),new ItemStack(Block.blockDiamond,1),
				Character.valueOf('R'),new ItemStack(ResourceEngineeringMain.gemBlock,1,5),
				Character.valueOf('T'),new ItemStack(ResourceEngineeringMain.gemBlock,1,0),
				Character.valueOf('I'),new ItemStack(Block.blockSteel,1),
				Character.valueOf('S'),new ItemStack(ResourceEngineeringMain.gemBlock,1,6));
		
		//Gem from Block Recipes
		GameRegistry.addShapelessRecipe(new ItemStack(ResourceEngineeringMain.gem,9,7),new ItemStack(ResourceEngineeringMain.gemBlock,1,0));
		GameRegistry.addShapelessRecipe(new ItemStack(ResourceEngineeringMain.gem,9,8),new ItemStack(ResourceEngineeringMain.gemBlock,1,1));
		GameRegistry.addShapelessRecipe(new ItemStack(ResourceEngineeringMain.gem,9,9),new ItemStack(ResourceEngineeringMain.gemBlock,1,2));
		GameRegistry.addShapelessRecipe(new ItemStack(ResourceEngineeringMain.gem,9,10),new ItemStack(ResourceEngineeringMain.gemBlock,1,3));
		GameRegistry.addShapelessRecipe(new ItemStack(ResourceEngineeringMain.gem,9,11),new ItemStack(ResourceEngineeringMain.gemBlock,1,4));
		GameRegistry.addShapelessRecipe(new ItemStack(ResourceEngineeringMain.gem,9,12),new ItemStack(ResourceEngineeringMain.gemBlock,1,5));
		GameRegistry.addShapelessRecipe(new ItemStack(ResourceEngineeringMain.gem,9,13),new ItemStack(ResourceEngineeringMain.gemBlock,1,6));
		
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
		ItemStack turquoiseSword = new ItemStack(ResourceEngineeringMain.turquoiseSword,1,0);
		turquoiseSword.addEnchantment(Enchantment.smite, 1);
		//GameRegistry.addRecipe(turquoiseSword,"X","X","A",Character.valueOf('X'),turquoiseGem,Character.valueOf('A'),stick);
		
		ItemStack rawTurquoiseSword = new ItemStack(ResourceEngineeringMain.turquoiseSword,1,0);
		rawTurquoiseSword.addEnchantment(Enchantment.smite, 1);
		GameRegistry.addRecipe(rawTurquoiseSword,"X","X","A",Character.valueOf('X'),rawTurquoise,Character.valueOf('A'),stick);
		
		ItemStack onyxSword = new ItemStack(ResourceEngineeringMain.onyxSword,1,0);
		onyxSword.addEnchantment(Enchantment.smite,2);
		ItemStack amethystSword = new ItemStack(ResourceEngineeringMain.amethystSword,1,0);
		amethystSword.addEnchantment(Enchantment.smite,3);
		ItemStack citrineSword = new ItemStack(ResourceEngineeringMain.citrineSword,1,0);
		citrineSword.addEnchantment(Enchantment.smite, 4);
		ItemStack emeraldSword = new ItemStack(ResourceEngineeringMain.emeraldSword,1,0);
		emeraldSword.addEnchantment(Enchantment.smite,5);
		ItemStack rubySword = new ItemStack(ResourceEngineeringMain.rubySword,1,0);
		rubySword.addEnchantment(Enchantment.smite, 6);
		ItemStack sapphireSword = new ItemStack(ResourceEngineeringMain.sapphireSword,1,0);
		sapphireSword.addEnchantment(Enchantment.smite, 7);
		GameRegistry.addRecipe(onyxSword,"X","X","A",Character.valueOf('X'),rawOnyx,Character.valueOf('A'),stick);
		GameRegistry.addRecipe(amethystSword,"X","X","A",Character.valueOf('X'),amethystGem,Character.valueOf('A'),stick);
		GameRegistry.addRecipe(citrineSword,"X","X","A",Character.valueOf('X'),citrineGem,Character.valueOf('A'),stick);
		GameRegistry.addRecipe(emeraldSword,"X","X","A",Character.valueOf('X'),emeraldGem,Character.valueOf('A'),stick);
		GameRegistry.addRecipe(rubySword,"X","X","A",Character.valueOf('X'),rubyGem,Character.valueOf('A'),stick);
		GameRegistry.addRecipe(sapphireSword,"X","X","A",Character.valueOf('X'),sapphireGem,Character.valueOf('A'),stick);
		
		//Pickaxe Recipes
		ItemStack turquoisePickaxe = new ItemStack(ResourceEngineeringMain.turquoisePickaxe,1,0);
		turquoisePickaxe.addEnchantment(Enchantment.fortune,1);
		ItemStack onyxPickaxe = new ItemStack(ResourceEngineeringMain.onyxPickaxe,1,0);
		ItemStack amethystPickaxe = new ItemStack(ResourceEngineeringMain.amethystPickaxe,1,0);
		ItemStack citrinePickaxe = new ItemStack(ResourceEngineeringMain.citrinePickaxe,1,0);
		ItemStack emeraldPickaxe = new ItemStack(ResourceEngineeringMain.emeraldPickaxe,1,0);
		ItemStack rubyPickaxe = new ItemStack(ResourceEngineeringMain.rubyPickaxe,1,0);
		ItemStack sapphirePickaxe = new ItemStack(ResourceEngineeringMain.sapphirePickaxe,1,0);	
		
		GameRegistry.addRecipe(turquoisePickaxe,"XXX"," A "," A ",Character.valueOf('X'),rawTurquoise,Character.valueOf('A'),stick);
		GameRegistry.addRecipe(onyxPickaxe,"XXX"," A "," A ",Character.valueOf('X'),rawOnyx,Character.valueOf('A'),stick);
		GameRegistry.addRecipe(amethystPickaxe,"XXX"," A "," A ",Character.valueOf('X'),amethystGem,Character.valueOf('A'),stick);
		GameRegistry.addRecipe(citrinePickaxe,"XXX"," A "," A ",Character.valueOf('X'),citrineGem,Character.valueOf('A'),stick);
		GameRegistry.addRecipe(emeraldPickaxe,"XXX"," A "," A ",Character.valueOf('X'),emeraldGem,Character.valueOf('A'),stick);
		GameRegistry.addRecipe(rubyPickaxe,"XXX"," A "," A ",Character.valueOf('X'),rubyGem,Character.valueOf('A'),stick);
		GameRegistry.addRecipe(sapphirePickaxe,"XXX"," A "," A ",Character.valueOf('X'),sapphireGem,Character.valueOf('A'),stick);
		
		//Shovel Recipes
		ItemStack turquoiseShovel = new ItemStack(ResourceEngineeringMain.turquoiseShovel,1,0);
		ItemStack onyxShovel = new ItemStack(ResourceEngineeringMain.onyxShovel,1,0);
		ItemStack amethystShovel = new ItemStack(ResourceEngineeringMain.amethystShovel,1,0);
		ItemStack citrineShovel = new ItemStack(ResourceEngineeringMain.citrineShovel,1,0);
		ItemStack emeraldShovel = new ItemStack(ResourceEngineeringMain.emeraldShovel,1,0);
		ItemStack rubyShovel = new ItemStack(ResourceEngineeringMain.rubyShovel,1,0);
		ItemStack sapphireShovel = new ItemStack(ResourceEngineeringMain.sapphireShovel,1,0);
		
		GameRegistry.addRecipe(turquoiseShovel,"X","A","A",Character.valueOf('X'),rawTurquoise,Character.valueOf('A'),stick);
		GameRegistry.addRecipe(onyxShovel,"X","A","A",Character.valueOf('X'),rawOnyx,Character.valueOf('A'),stick);
		GameRegistry.addRecipe(amethystShovel,"X","A","A",Character.valueOf('X'),amethystGem,Character.valueOf('A'),stick);
		GameRegistry.addRecipe(citrineShovel,"X","A","A",Character.valueOf('X'),citrineGem,Character.valueOf('A'),stick);
		GameRegistry.addRecipe(emeraldShovel,"X","A","A",Character.valueOf('X'),emeraldGem,Character.valueOf('A'),stick);
		GameRegistry.addRecipe(rubyShovel,"X","A","A",Character.valueOf('X'),rubyGem,Character.valueOf('A'),stick);
		GameRegistry.addRecipe(sapphireShovel,"X","A","A",Character.valueOf('X'),sapphireGem,Character.valueOf('A'),stick);
		
		//Axe Recipes
		ItemStack turquoiseAxe = new ItemStack(ResourceEngineeringMain.turquoiseAxe,1,0);
		ItemStack onyxAxe = new ItemStack(ResourceEngineeringMain.onyxAxe,1,0);
		ItemStack amethystAxe = new ItemStack(ResourceEngineeringMain.amethystAxe,1,0);
		ItemStack citrineAxe = new ItemStack(ResourceEngineeringMain.citrineAxe,1,0);
		ItemStack emeraldAxe = new ItemStack(ResourceEngineeringMain.emeraldAxe,1,0);
		ItemStack rubyAxe = new ItemStack(ResourceEngineeringMain.rubyAxe,1,0);
		ItemStack sapphireAxe = new ItemStack(ResourceEngineeringMain.sapphireAxe,1,0);
		
		//GameRegistry.addRecipe(turquoiseAxe,"XX","XA"," A",Character.valueOf('X'),turquoiseGem,Character.valueOf('A'),stick);
		GameRegistry.addRecipe(turquoiseAxe,"XX","AX","A ",Character.valueOf('X'),rawTurquoise,Character.valueOf('A'),stick);
		//GameRegistry.addRecipe(onyxAxe,"XX","XA"," A",Character.valueOf('X'),onyxGem,Character.valueOf('A'),stick);
		GameRegistry.addRecipe(onyxAxe,"XX","AX","A ",Character.valueOf('X'),rawOnyx,Character.valueOf('A'),stick);
		//GameRegistry.addRecipe(amethystAxe,"XX","XA"," A",Character.valueOf('X'),amethystGem,Character.valueOf('A'),stick);
		GameRegistry.addRecipe(amethystAxe,"XX","AX","A ",Character.valueOf('X'),amethystGem,Character.valueOf('A'),stick);
		//GameRegistry.addRecipe(citrineAxe,"XX","XA"," A",Character.valueOf('X'),citrineGem,Character.valueOf('A'),stick);
		GameRegistry.addRecipe(citrineAxe,"XX","AX","A ",Character.valueOf('X'),citrineGem,Character.valueOf('A'),stick);
		//GameRegistry.addRecipe(emeraldAxe,"XX","XA"," A",Character.valueOf('X'),emeraldGem,Character.valueOf('A'),stick);
		GameRegistry.addRecipe(emeraldAxe,"XX","AX","A ",Character.valueOf('X'),emeraldGem,Character.valueOf('A'),stick);
		//GameRegistry.addRecipe(rubyAxe,"XX","XA"," A",Character.valueOf('X'),rubyGem,Character.valueOf('A'),stick);
		GameRegistry.addRecipe(rubyAxe,"XX","AX","A ",Character.valueOf('X'),rubyGem,Character.valueOf('A'),stick);
		//GameRegistry.addRecipe(sapphireAxe,"XX","XA"," A",Character.valueOf('X'),sapphireGem,Character.valueOf('A'),stick);
		GameRegistry.addRecipe(sapphireAxe,"XX","AX","A ",Character.valueOf('X'),sapphireGem,Character.valueOf('A'),stick);
		
		//Hoe Recipes
		ItemStack turquoiseHoe = new ItemStack(ResourceEngineeringMain.turquoiseHoe,1,0);
		ItemStack onyxHoe = new ItemStack(ResourceEngineeringMain.onyxHoe,1,0);
		ItemStack amethystHoe = new ItemStack(ResourceEngineeringMain.amethystHoe,1,0);
		ItemStack citrineHoe = new ItemStack(ResourceEngineeringMain.citrineHoe,1,0);
		ItemStack emeraldHoe = new ItemStack(ResourceEngineeringMain.emeraldHoe,1,0);
		ItemStack rubyHoe = new ItemStack(ResourceEngineeringMain.rubyHoe,1,0);
		ItemStack sapphireHoe = new ItemStack(ResourceEngineeringMain.sapphireHoe,1,0);
		
		//GameRegistry.addRecipe(turquoiseHoe,"XX","A ","A ",Character.valueOf('X'),turquoiseGem,Character.valueOf('A'),stick);
		GameRegistry.addRecipe(turquoiseHoe,"XX"," A"," A",Character.valueOf('X'),rawTurquoise,Character.valueOf('A'),stick);
		//GameRegistry.addRecipe(onyxHoe,"XX","A ","A",Character.valueOf('X'),onyxGem,Character.valueOf('A'),stick);
		GameRegistry.addRecipe(onyxHoe,"XX"," A"," A",Character.valueOf('X'),rawOnyx,Character.valueOf('A'),stick);
		//GameRegistry.addRecipe(amethystHoe,"XX","A ","A ",Character.valueOf('X'),amethystGem,Character.valueOf('A'),stick);
		GameRegistry.addRecipe(amethystHoe,"XX"," A"," A",Character.valueOf('X'),amethystGem,Character.valueOf('A'),stick);
		//GameRegistry.addRecipe(citrineHoe,"XX","A ","A ",Character.valueOf('X'),citrineGem,Character.valueOf('A'),stick);
		GameRegistry.addRecipe(citrineHoe,"XX"," A"," A",Character.valueOf('X'),citrineGem,Character.valueOf('A'),stick);
		//GameRegistry.addRecipe(emeraldHoe,"XX","A ","A ",Character.valueOf('X'),emeraldGem,Character.valueOf('A'),stick);
		GameRegistry.addRecipe(emeraldHoe,"XX"," A"," A",Character.valueOf('X'),emeraldGem,Character.valueOf('A'),stick);
		//GameRegistry.addRecipe(rubyHoe,"XX","A ","A ",Character.valueOf('X'),rubyGem,Character.valueOf('A'),stick);
		GameRegistry.addRecipe(rubyHoe,"XX"," A"," A",Character.valueOf('X'),rubyGem,Character.valueOf('A'),stick);
		//GameRegistry.addRecipe(sapphireHoe,"XX","A ","A ",Character.valueOf('X'),sapphireGem,Character.valueOf('A'),stick);
		GameRegistry.addRecipe(sapphireHoe,"XX"," A"," A",Character.valueOf('X'),sapphireGem,Character.valueOf('A'),stick);
		
		//Armor Recipes
		//Helmet
		ItemStack turquoiseHelmet = new ItemStack(ResourceEngineeringMain.turquoiseHelmet,1,0);
		ItemStack onyxHelmet = new ItemStack(ResourceEngineeringMain.onyxHelmet,1,0);
		ItemStack amethystHelmet = new ItemStack(ResourceEngineeringMain.amethystHelmet,1,0);
		ItemStack citrineHelmet = new ItemStack(ResourceEngineeringMain.citrineHelmet,1,0);
		ItemStack emeraldHelmet = new ItemStack(ResourceEngineeringMain.emeraldHelmet,1,0);
		ItemStack rubyHelmet = new ItemStack(ResourceEngineeringMain.rubyHelmet,1,0);
		ItemStack sapphireHelmet = new ItemStack(ResourceEngineeringMain.sapphireHelmet,1,0);
		GameRegistry.addRecipe(turquoiseHelmet,"XXX","X X",Character.valueOf('X'),rawTurquoise);
		GameRegistry.addRecipe(onyxHelmet,"XXX","X X",Character.valueOf('X'),rawOnyx);
		GameRegistry.addRecipe(amethystHelmet,"XXX","X X",Character.valueOf('X'),amethystGem);
		GameRegistry.addRecipe(citrineHelmet,"XXX","X X",Character.valueOf('X'),citrineGem);
		GameRegistry.addRecipe(emeraldHelmet,"XXX","X X",Character.valueOf('X'),emeraldGem);
		GameRegistry.addRecipe(rubyHelmet,"XXX","X X",Character.valueOf('X'),rubyGem);
		GameRegistry.addRecipe(sapphireHelmet,"XXX","X X",Character.valueOf('X'),sapphireGem);
		
		//Chest Plate
		ItemStack turquoisePlate = new ItemStack(ResourceEngineeringMain.turquoisePlate,1,0);
		ItemStack onyxPlate = new ItemStack(ResourceEngineeringMain.onyxPlate,1,0);
		ItemStack amethystPlate = new ItemStack(ResourceEngineeringMain.amethystPlate,1,0);
		ItemStack citrinePlate = new ItemStack(ResourceEngineeringMain.citrinePlate,1,0);
		ItemStack emeraldPlate = new ItemStack(ResourceEngineeringMain.emeraldPlate,1,0);
		ItemStack rubyPlate = new ItemStack(ResourceEngineeringMain.rubyPlate,1,0);
		ItemStack sapphirePlate = new ItemStack(ResourceEngineeringMain.sapphirePlate,1,0);
		GameRegistry.addRecipe(turquoisePlate,"X X","XXX","XXX",Character.valueOf('X'),rawTurquoise);
		GameRegistry.addRecipe(onyxPlate,"X X","XXX","XXX",Character.valueOf('X'),rawOnyx);
		GameRegistry.addRecipe(amethystPlate,"X X","XXX","XXX",Character.valueOf('X'),amethystGem);
		GameRegistry.addRecipe(citrinePlate,"X X","XXX","XXX",Character.valueOf('X'),citrineGem);
		GameRegistry.addRecipe(emeraldPlate,"X X","XXX","XXX",Character.valueOf('X'),emeraldGem);
		GameRegistry.addRecipe(rubyPlate,"X X","XXX","XXX",Character.valueOf('X'),rubyGem);
		GameRegistry.addRecipe(sapphirePlate,"X X","XXX","XXX",Character.valueOf('X'),sapphireGem);
		
		//Leggings
		ItemStack turquoiseLeggings = new ItemStack(ResourceEngineeringMain.turquoiseLeggings,1,0);
		ItemStack onyxLeggings = new ItemStack(ResourceEngineeringMain.onyxLeggings,1,0);
		ItemStack amethystLeggings = new ItemStack(ResourceEngineeringMain.amethystLeggings,1,0);
		ItemStack citrineLeggings = new ItemStack(ResourceEngineeringMain.citrineLeggings,1,0);
		ItemStack emeraldLeggings = new ItemStack(ResourceEngineeringMain.emeraldLeggings,1,0);
		ItemStack rubyLeggings = new ItemStack(ResourceEngineeringMain.rubyLeggings,1,0);
		ItemStack sapphireLeggings = new ItemStack(ResourceEngineeringMain.sapphireLeggings,1,0);
		GameRegistry.addRecipe(turquoiseLeggings,"XXX","X X","X X",Character.valueOf('X'),rawTurquoise);
		GameRegistry.addRecipe(onyxLeggings,"XXX","X X","X X",Character.valueOf('X'),rawOnyx);
		GameRegistry.addRecipe(amethystLeggings,"XXX","X X","X X",Character.valueOf('X'),amethystGem);
		GameRegistry.addRecipe(citrineLeggings,"XXX","X X","X X",Character.valueOf('X'),citrineGem);
		GameRegistry.addRecipe(emeraldLeggings,"XXX","X X","X X",Character.valueOf('X'),emeraldGem);
		GameRegistry.addRecipe(rubyLeggings,"XXX","X X","X X",Character.valueOf('X'),rubyGem);
		GameRegistry.addRecipe(sapphireLeggings,"XXX","X X","X X",Character.valueOf('X'),sapphireGem);
		
		ItemStack turquoiseBoots = new ItemStack(ResourceEngineeringMain.turquoiseBoots,1,0);
		ItemStack onyxBoots = new ItemStack(ResourceEngineeringMain.onyxBoots,1,0);
		ItemStack amethystBoots = new ItemStack(ResourceEngineeringMain.amethystBoots,1,0);
		ItemStack citrineBoots = new ItemStack(ResourceEngineeringMain.citrineBoots,1,0);
		ItemStack emeraldBoots = new ItemStack(ResourceEngineeringMain.emeraldBoots,1,0);
		ItemStack rubyBoots = new ItemStack(ResourceEngineeringMain.rubyBoots,1,0);
		ItemStack sapphireBoots = new ItemStack(ResourceEngineeringMain.sapphireBoots,1,0);
		GameRegistry.addRecipe(turquoiseBoots,"X X","X X",Character.valueOf('X'),rawTurquoise);
		GameRegistry.addRecipe(onyxBoots,"X X","X X",Character.valueOf('X'),rawOnyx);
		GameRegistry.addRecipe(amethystBoots,"X X","X X",Character.valueOf('X'),amethystGem);
		GameRegistry.addRecipe(citrineBoots,"X X","X X",Character.valueOf('X'),citrineGem);
		GameRegistry.addRecipe(emeraldBoots,"X X","X X",Character.valueOf('X'),emeraldGem);
		GameRegistry.addRecipe(rubyBoots,"X X","X X",Character.valueOf('X'),rubyGem);
		GameRegistry.addRecipe(sapphireBoots,"X X","X X",Character.valueOf('X'),sapphireGem);
	}
}
