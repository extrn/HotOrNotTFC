package com.buuz135.hotornot;

import com.buuz135.hotornot.config.HotConfig;
import com.buuz135.hotornot.config.HotLists;
import gregtech.api.util.GTUtility;
import gregtech.common.items.MetaItems;
import net.dries007.tfc.api.capability.heat.CapabilityItemHeat;
import net.dries007.tfc.api.capability.heat.IItemHeat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import speeedcraft.tfgmod.gregtech.items.TFGModMetaItem;

@Mod.EventBusSubscriber
public class CommonEventHandler {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        EntityPlayer entityPlayer = event.player;
        World world = entityPlayer.getEntityWorld();

        if (!entityPlayer.isBurning() && !entityPlayer.isCreative() && entityPlayer.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null))
        {
            IItemHandler handler = entityPlayer.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
            for (int i = 0; i < handler.getSlots(); i++)
            {
                ItemStack stack = handler.getStackInSlot(i);

                // Fluids
                if (!stack.isEmpty() && stack.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null) && !HotLists.isRemoved(stack))
                {
                    IFluidHandlerItem fluidHandlerItem = stack.getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null);
                    FluidStack fluidStack = fluidHandlerItem.drain(1000, false);
                    if (fluidStack != null)
                    {
                        for (FluidEffect effect : FluidEffect.values())
                        {
                            if (effect.isValid.test(fluidStack))
                            {
                                ItemStack offHand = entityPlayer.getHeldItemOffhand();
                                if (offHand.getItem().equals(TFGModMetaItem.TONGS.getStackForm().getItem()))
                                {
                                    GTUtility.doDamageItem(offHand, 1, false);
                                }
                                else if (world.getTotalWorldTime() % 20 == 0)
                                {
                                    effect.interactPlayer.accept(entityPlayer);

                                    if (HotConfig.YEET)
                                    {
                                        entityPlayer.inventory.deleteStack(stack);
                                        entityPlayer.dropItem(stack, false, true);
                                        return;
                                    }
                                }
                            }

                        }
                    }
                }
                // Items
                else if (HotConfig.HOT_ITEMS && !stack.isEmpty() && !HotLists.isRemoved(stack))
                {
                    // TFC Heat Capability
                    if (stack.hasCapability(CapabilityItemHeat.ITEM_HEAT_CAPABILITY, null))
                    {
                        IItemHeat heatHandlerItem = stack.getCapability(CapabilityItemHeat.ITEM_HEAT_CAPABILITY, null);
                        if (heatHandlerItem != null && heatHandlerItem.getTemperature() >= HotConfig.HOT_ITEM)
                        {
                            ItemStack offHand = entityPlayer.getHeldItemOffhand();
                            if (offHand.getItem().equals(TFGModMetaItem.TONGS.getStackForm().getItem()))
                            {
                                GTUtility.doDamageItem(offHand, 1, false);
                            }
                            else if (world.getTotalWorldTime() % 10 == 0)
                            {
                                entityPlayer.setFire(1);

                                if (HotConfig.YEET)
                                {
                                    entityPlayer.inventory.deleteStack(stack);
                                    entityPlayer.dropItem(stack, false, true);
                                    return;
                                }
                            }
                        }
                    }
                    // Items from config
                    // Hot
                    else if (HotLists.isHot(stack))
                    {
                        ItemStack offHand = entityPlayer.getHeldItemOffhand();
                        if (offHand.getItem().equals(TFGModMetaItem.TONGS.getStackForm().getItem()))
                        {
                            GTUtility.doDamageItem(offHand, 1, false);
                        }
                        else if (world.getTotalWorldTime() % 10 == 0)
                        {
                            entityPlayer.setFire(1);
                            if (HotConfig.YEET)
                            {
                                entityPlayer.inventory.deleteStack(stack);
                                entityPlayer.dropItem(stack, false, true);
                                return;
                            }
                        }
                    }
                    // Cold
                    else if (HotLists.isCold(stack))
                    {
                        ItemStack offHand = entityPlayer.getHeldItemOffhand();
                        if (offHand.getItem().equals(MetaItems.AXE.getStackForm().getItem()))
                        {
                            GTUtility.doDamageItem(offHand, 1, false);
                        }
                        else if (world.getTotalWorldTime() % 10 == 0)
                        {
                            entityPlayer.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 21, 1));
                            entityPlayer.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 21, 1));
                        }
                    }
                    // Gaseous
                    else if (HotLists.isGaseous(stack))
                    {
                        if (world.getTotalWorldTime() % 10 == 0)
                        {
                            entityPlayer.addPotionEffect(new PotionEffect(MobEffects.LEVITATION, 21, 1));
                        }
                    }

                }
            }
        }
    }
}
