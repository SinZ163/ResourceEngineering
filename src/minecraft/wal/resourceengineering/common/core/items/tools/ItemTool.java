package resourceengineering.common.core.items.tools;

import cpw.mods.fml.relauncher.*;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

import resourceengineering.common.ResourceEngineeringMain;

public class ItemTool extends Item
{
	private Block[] blocksEffectiveAgainst;
	public float efficiencyOnProperMaterial = 4.0F;
	public int damageVsEntity;
	protected EnumToolMaterial toolMaterial;
	protected ItemTool(int ID,int Damage,EnumToolMaterial m,Block[] ea)
	{
		super(ID);
		toolMaterial = m;
		blocksEffectiveAgainst = ea;
		maxStackSize = 1;
		setMaxDamage(m.getMaxUses());
		efficiencyOnProperMaterial = m.getEfficiencyOnProperMaterial();
		damageVsEntity = Damage + m.getDamageVsEntity();
		setCreativeTab(ResourceEngineeringMain.reTab);
	}
	public float getStrVsBlock(ItemStack itemStack,Block block)
	{
		for(int i=0;i<this.blocksEffectiveAgainst.length;++i)
		{
			if(this.blocksEffectiveAgainst[i] == block)
			{
				return this.efficiencyOnProperMaterial;
			}
		}
		return 1.0F;
	}
	public boolean hitEntity(ItemStack itemStack,EntityLiving entityLiving,EntityLiving entityLiving2)
	{
		itemStack.damageItem(2,entityLiving2);
		return true;
	}
	public boolean onBlockDestroyed(ItemStack itemStack,World world,int par3,int x,int y,int z,EntityLiving entityLiving)
	{
		if((double)Block.blocksList[par3].getBlockHardness(world,x,y,z)!=0.0D)
		{
			itemStack.damageItem(1,entityLiving);
		}
		return true;
	}
	public int getDamageVsEntity(Entity entity)
	{
		return this.damageVsEntity;
	}
	@SideOnly(Side.CLIENT)
	public boolean isFull3D()
	{
		return true;
	}
	public int getItemEnchantability()
	{
		return this.toolMaterial.getEnchantability();
	}
	public String getToolMaterialName()
	{
		return this.toolMaterial.toString();
	}
	public boolean getIsRepairable(ItemStack itemStack,ItemStack itemStack2)
	{
		return this.toolMaterial.getToolCraftingMaterial() == itemStack2.itemID?true:super.getIsRepairable(itemStack,itemStack2);
	}
	@Override
	public float getStrVsBlock(ItemStack stack,Block block, int meta)
	{
		if(ForgeHooks.isToolEffective(stack, block, meta))
		{
			return efficiencyOnProperMaterial;
		}
		return getStrVsBlock(stack, block);
	}
}
