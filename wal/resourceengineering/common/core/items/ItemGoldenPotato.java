package resourceengineering.common.core.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

import resourceengineering.common.ResourceEngineeringMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ItemGoldenPotato extends ItemFood
{
	public ItemGoldenPotato(int par1, int par2, float par3, boolean par4)
	{
		super(par1, par2, par3, par4);
		setTextureFile("/walgfx/Items.png");
		setItemName("wal_ItemGoldenPotato");
		setCreativeTab(ResourceEngineeringMain.reTab);
		setHasSubtypes(true);
		setMaxDamage(0);
	}
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	public int getIconFromDamage(int i)
	{
		switch(i)
		{
		case 0: return 2;//Golden Potato
		}
		return 0;
	}
	
	@SideOnly(Side.CLIENT)
	/**
	 * Return an item rarity from EnumRarity
	 */
	public EnumRarity getRarity(ItemStack par1ItemStack)
	{
		return par1ItemStack.getItemDamage() == 0 ? EnumRarity.rare : EnumRarity.epic;
	}

	protected void func_77849_c(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 600, 3));
		par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.resistance.id, 6000, 0));
		par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 6000, 0));

	}

	public String getItemNameIS(ItemStack is)
	{
		switch(is.getItemDamage())
		{
		case 0: return "wal_ItemGoldenPotato";
		}
		return "itemUnknown";
	}
	@SideOnly(Side.CLIENT)
	public void getSubItems(int itemID, CreativeTabs tab, List itemList)
	{
		for(int i=0;i<1;i++)
		{
			itemList.add(new ItemStack(itemID,1,i));
		}
	}

}
