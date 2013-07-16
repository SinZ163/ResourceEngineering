package resourceengineering.common.core.items.tools;

import resourceengineering.common.ResourceEngineeringMain;
import cpw.mods.fml.relauncher.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ItemToolSword extends Item
{
	private Icon icon;
	private String n;
	private int weaponDamage;
	private final EnumToolMaterial toolMaterial;
	public ItemToolSword(int ID,EnumToolMaterial material, int tex, String name)
	{
		super(ID);
		toolMaterial = material;
		maxStackSize = 1;
		setMaxDamage(material.getMaxUses());
		setCreativeTab(ResourceEngineeringMain.reTab);
		weaponDamage=4 + (int)toolMaterial.getDamageVsEntity();
		setUnlocalizedName(name);
        n=name;
	}
	public void registerIcons(IconRegister iconRegister)
	{
		makeIcons(iconRegister);
	}
	public void makeIcons(IconRegister iconRegister)
	{
		icon = iconRegister.registerIcon("resourceengineering:"+n);
	}
    @SideOnly(Side.CLIENT)
    @Override
    public Icon getIconFromDamage(int i)
    {
        return icon;
    }
	public int func_82803_g()
	{
		return (int)this.toolMaterial.getDamageVsEntity();
	}
	public float getStrVsBlock(ItemStack par1ItemStack,Block par2Block)
	{
		if(par2Block.blockID == Block.web.blockID)
		{
			return 15.0F;
		}
		else
		{
			Material var3 = par2Block.blockMaterial;
			return var3 != Material.plants && var3 != Material.vine && var3 != Material.coral && var3 != Material.leaves && var3 != Material.pumpkin ? 1.0F:1.5F;
		}
	}
	public boolean hitEntity(ItemStack par1ItemStack,EntityLiving par2EntityLiving,EntityLiving par3EntityLiving)
	{
		par1ItemStack.damageItem(1,par3EntityLiving);
		return true;
	}
	public boolean onBlockDestroyed(ItemStack itemStack,World world,int par3,int x,int y,int z, int par6, EntityLiving entityLiving)
	{
		if((double)Block.blocksList[par3].getBlockHardness(world, x, y, z)!=0.0D)
		{
			itemStack.damageItem(3,entityLiving);
		}
		return true;
	}
	public int getDamageVsEntity(Entity entity)
	{
		return this.weaponDamage;
	}
	@SideOnly(Side.CLIENT)
	public boolean isFull3D()
	{
		return true;
	}
	public EnumAction getItemUseAction(ItemStack itemStack)
	{
		return EnumAction.block;
	}
	public int getMaxItemUseDuration(ItemStack itemStack)
	{
		return 72000;
	}
	public ItemStack onItemRightClick(ItemStack itemStack,World world,EntityPlayer entityPlayer)
	{
		entityPlayer.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
		return itemStack;
	}
	public boolean canHarvestBlock(Block block)
	{
		return block.blockID == block.web.blockID;
	}
	public int getItemEnchantibility()
	{
		return this.toolMaterial.getEnchantability();
	}
	public String func_77825_f()
	{
		return this.toolMaterial.toString();
	}
	public boolean getIsRepairable(ItemStack itemStack,ItemStack itemStack2)
	{
		return true;
	}
}