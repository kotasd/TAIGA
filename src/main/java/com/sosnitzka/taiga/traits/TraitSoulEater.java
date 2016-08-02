package com.sosnitzka.taiga.traits;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;


public class TraitSoulEater extends AbstractTrait {

    private static int chance = 60 * 600;

    public TraitSoulEater() {
        super(TraitSoulEater.class.getSimpleName().toLowerCase().substring(5), TextFormatting.RED);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onTargetKilled(LivingDeathEvent event) {
        if (event.getSource().getEntity() instanceof EntityPlayer && event.getEntity() instanceof EntityLiving) {
            World w = event.getSource().getEntity().worldObj;
            ItemStack tool = ((EntityPlayer) event.getSource().getEntity()).getHeldItemMainhand();
            if (!w.isRemote && TinkerUtil.hasTrait(TagUtil.getTagSafe(tool), identifier)) {
                NBTTagCompound tag = TagUtil.getExtraTag(tool);
                Data data = Data.read(tag);
                float health = ((EntityLiving) event.getEntity()).getMaxHealth();
                data.killCount += 111;
                System.out.println(data.killCount);
                data.bonus += random.nextFloat() * health;
                data.write(tag);
                TagUtil.setExtraTag(tool, tag);
            }
        }
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {

        NBTTagCompound tag = TagUtil.getExtraTag(tool);
        Data data = Data.read(tag);
        EntityPlayer player = (EntityPlayer) entity;
        if (random.nextInt((int) ((chance + data.killCount) / (data.killCount + 1))) == 1) {
            entity.attackEntityFrom(new DamageSource("Soul Eater"), random.nextFloat() * ((EntityPlayer) entity).getHealth() / 2);
        }
        if (isSelected) {
            //((EntityPlayer) entity).getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5d);
        }
    }

    @SubscribeEvent
    public void onItemTooltip(ItemTooltipEvent e) {
        ItemStack tool = e.getItemStack();
        if (TinkerUtil.hasTrait(TagUtil.getTagSafe(tool), identifier)) {
            NBTTagCompound tag = TagUtil.getExtraTag(tool);
            Data data = Data.read(tag);
            if (data.killCount != 0) {
                e.getToolTip().add(TextFormatting.WHITE + "Killed: " + TextFormatting.WHITE + data.killCount);
            }
        }
    }


    public static class Data {
        float bonus;
        int killCount;

        public static Data read(NBTTagCompound tag) {
            Data data = new Data();
            data.bonus = tag.getFloat("bonus");
            data.killCount = tag.getInteger("killCount");
            return data;
        }

        public void write(NBTTagCompound tag) {
            tag.setFloat("bonus", bonus);
            tag.setInteger("killCount", killCount);
        }
    }


}
