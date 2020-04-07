package flysong.darkages.utils;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;

public class BasicBlock extends Block {
    public BasicBlock(Material blockMaterialIn, MapColor blockMapColorIn, String registryName, String unlocalizedName, CreativeTabs tab, SoundType soundType, String toolClass, int level, IBlockState state,float lightLevel,float hardness) {
        super(blockMaterialIn, blockMapColorIn);
        this.setRegistryName(registryName);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(tab);
        this.setSoundType(soundType);
        this.setHardness(hardness);
        this.setHarvestLevel(toolClass,level,state);
        this.setLightLevel(lightLevel);
    }

    public BasicBlock(Material blockMaterialIn, MapColor blockMapColorIn, String registryName, String unlocalizedName, CreativeTabs tab, SoundType soundType, String toolClass, int level,float lightLevel,float hardness) {
        super(blockMaterialIn, blockMapColorIn);
        this.setRegistryName(registryName);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(tab);
        this.setSoundType(soundType);
        this.setHardness(hardness);
        this.setHarvestLevel(toolClass,level);
        this.setLightLevel(lightLevel);
    }

    public BasicBlock(Material blockMaterialIn, String registryName, String unlocalizedName, CreativeTabs tab, SoundType soundType, String toolClass, int level, IBlockState state,float lightLevel,float hardness) {
        this(blockMaterialIn, blockMaterialIn.getMaterialMapColor(),registryName,unlocalizedName,tab,soundType,toolClass,level,state,lightLevel,hardness);
    }

    public BasicBlock(Material blockMaterialIn, String registryName, String unlocalizedName, CreativeTabs tab, SoundType soundType, String toolClass, int level,float lightLevel,float hardness) {
        this(blockMaterialIn, blockMaterialIn.getMaterialMapColor(),registryName,unlocalizedName,tab,soundType,toolClass,level,lightLevel,hardness);
    }

    public BasicBlock(Material blockMaterialIn, String registryName, String unlocalizedName, CreativeTabs tab, SoundType soundType, String toolClass, int level,float hardness) {
        this(blockMaterialIn, blockMaterialIn.getMaterialMapColor(),registryName,unlocalizedName,tab,soundType,toolClass,level,0,hardness);
    }

    public BasicBlock(Material blockMaterialIn, String registryName, String unlocalizedName, CreativeTabs tab, SoundType soundType, float lightLevel,float hardness) {
        this(blockMaterialIn, registryName,unlocalizedName,tab,soundType,"",-1,lightLevel,hardness);
    }

    public BasicBlock(Material blockMaterialIn, String registryName, String unlocalizedName, CreativeTabs tab, SoundType soundType, float lightLevel) {
        this(blockMaterialIn, registryName,unlocalizedName,tab,soundType,lightLevel,5.0f);
    }

    public BasicBlock(Material blockMaterialIn, String registryName, String unlocalizedName, CreativeTabs tab, SoundType soundType) {
        this(blockMaterialIn, registryName,unlocalizedName,tab,soundType,0.0f);
    }

    public BasicBlock(Material blockMaterialIn, String registryName, String unlocalizedName, CreativeTabs tab) {
        this(blockMaterialIn, registryName,unlocalizedName,tab,SoundType.STONE);
    }

    public BasicBlock(Material blockMaterialIn) {
        super(blockMaterialIn);
    }

    public BasicBlock(Material blockMaterialIn,MapColor blockMapColorIn) {
        super(blockMaterialIn,blockMapColorIn);
    }

    public BasicBlock addIt()
    {
        Registry.BlockRegistryList.add(this);
        Registry.ItemBlockRegistryList.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
        return this;
    }
}
