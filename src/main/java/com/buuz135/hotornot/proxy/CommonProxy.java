package com.buuz135.hotornot.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.buuz135.hotornot.item.IronTongsItem;
import com.buuz135.hotornot.item.MittsItem;
import com.buuz135.hotornot.item.WoodenTongsItem;

public class CommonProxy
{
    public static WoodenTongsItem WOODEN_TONGS = new WoodenTongsItem();
    public static MittsItem MITTS = new MittsItem();
    public static IronTongsItem IRON_TONGS = new IronTongsItem();

    public void preInit(FMLPreInitializationEvent event)
    {

    }

    public void init(FMLInitializationEvent event)
    {

    }

    public void postInit(FMLPostInitializationEvent event)
    {

    }

    public void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(WOODEN_TONGS);
        event.getRegistry().register(MITTS);
        event.getRegistry().register(IRON_TONGS);
    }

    @SideOnly(Side.CLIENT)
    public void modelRegistryEvent(ModelRegistryEvent event)
    {

    }
}