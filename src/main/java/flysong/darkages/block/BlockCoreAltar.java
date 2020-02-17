package flysong.darkages.block;

import flysong.darkages.init.CTLoader;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import static flysong.darkages.init.ItemLoader.*;

public class BlockCoreAltar extends Block {
    public BlockCoreAltar()
    {
        super(Material.ROCK, MapColor.STONE);
        this.setSoundType(SoundType.STONE);
        this.setHardness(50.5F);
        this.setHarvestLevel("pickaxe", 3);
        this.setUnlocalizedName("coreAltar");
        this.setRegistryName("Core_Altar");
        this.setCreativeTab(CTLoader.DarkAgesBlock);
        this.setLightLevel(1.0F);
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        ItemStack stack = playerIn.getHeldItem(hand);
        if(stack.getItem()== DarkGem)
        {
            if(stack.getTagCompound().getInteger("EnergySave")>=100)
            {
                playerIn.inventory.addItemStackToInventory(new ItemStack(DarkCore,1));
                if (!playerIn.capabilities.isCreativeMode)
                {
                    stack.setCount(stack.getCount()-1);
                }
                playerIn.setHeldItem(hand,stack);
                return true;
            }
            Minecraft.getMinecraft().player.sendMessage(new TextComponentString(I18n.format("energy.message.2")));
        }
        else if(stack.getItem()== DeadGem)
        {
            if(stack.getTagCompound().getInteger("EnergySave")>=100)
            {
                playerIn.inventory.addItemStackToInventory(new ItemStack(DeadCore,1));
                if (!playerIn.capabilities.isCreativeMode)
                {
                    stack.setCount(stack.getCount()-1);
                }
                playerIn.setHeldItem(hand,stack);
                return true;
            }
            Minecraft.getMinecraft().player.sendMessage(new TextComponentString(I18n.format("energy.message.2")));
        }
        else if(stack.getItem()== LifeGem)
        {
            if(stack.getTagCompound().getInteger("EnergySave")>=100)
            {
                playerIn.inventory.addItemStackToInventory(new ItemStack(LifeCore,1));
                if (!playerIn.capabilities.isCreativeMode)
                {
                    stack.setCount(stack.getCount()-1);
                }
                playerIn.setHeldItem(hand,stack);
                return true;
            }
            Minecraft.getMinecraft().player.sendMessage(new TextComponentString(I18n.format("energy.message.2")));
        }
        else if(stack.getItem()== MagicGem)
        {
            if(stack.getTagCompound().getInteger("EnergySave")>=100)
            {
                playerIn.inventory.addItemStackToInventory(new ItemStack(MagicCore,1));
                if (!playerIn.capabilities.isCreativeMode)
                {
                    stack.setCount(stack.getCount()-1);
                }
                playerIn.setHeldItem(hand,stack);
                return true;
            }
            Minecraft.getMinecraft().player.sendMessage(new TextComponentString(I18n.format("energy.message.2")));
        }
        playerIn.setHeldItem(hand,stack);

        return true;
    }
}
