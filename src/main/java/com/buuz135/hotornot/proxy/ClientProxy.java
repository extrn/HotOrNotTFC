package com.buuz135.hotornot.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy
{
    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        super.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
        super.postInit(event);
    }

    @Override
    public void modelRegistryEvent(ModelRegistryEvent event)
    {
        ModelLoader.setCustomModelResourceLocation(WOODEN_TONGS, 0, new ModelResourceLocation(WOODEN_TONGS.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(MITTS, 0, new ModelResourceLocation(MITTS.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(COPPER_TONGS, 0, new ModelResourceLocation(COPPER_TONGS.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(BRONZE_TONGS, 0, new ModelResourceLocation(BRONZE_TONGS.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(BISMUTH_BRONZE_TONGS, 0, new ModelResourceLocation(BISMUTH_BRONZE_TONGS.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(BLACK_BRONZE_TONGS, 0, new ModelResourceLocation(BLACK_BRONZE_TONGS.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(WROUGHT_IRON_TONGS, 0, new ModelResourceLocation(WROUGHT_IRON_TONGS.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(STEEL_TONGS, 0, new ModelResourceLocation(STEEL_TONGS.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(BLACK_STEEL_TONGS, 0, new ModelResourceLocation(BLACK_STEEL_TONGS.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(RED_STEEL_TONGS, 0, new ModelResourceLocation(RED_STEEL_TONGS.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(BLUE_STEEL_TONGS, 0, new ModelResourceLocation(BLUE_STEEL_TONGS.getRegistryName(), "inventory"));
    }
}