package com.sosnitzka.taiga.traits;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;

import java.lang.reflect.Constructor;


public class TraitCatcher extends AbstractTrait {

    public static int chance = 1000;

    public TraitCatcher() {
        super(TraitCatcher.class.getSimpleName().toLowerCase().substring(5), TextFormatting.RED);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void onHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, boolean isCritical) {
        World w = player.worldObj;
        if (!w.isRemote && random.nextInt((int) target.getMaxHealth()) <= chance && target instanceof EntityCreature) {
            NBTTagCompound tag = TagUtil.getExtraTag(tool);
            Data data = Data.read(tag);
            try {
                Class<?> c = Class.forName(target.getName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Constructor<?> constructor = c.getConstructor()[0]
            String name = target.getClass().toString();
            System.out.println(name);
            if (data.isMob) {
                return;
            }
            data.write(tag);
            TagUtil.setEnchantEffect(tool, true);
            TagUtil.setExtraTag(tool, tag);
            player.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1.0F, 1.0F);
            target.setDropItemsWhenDead(false);
            target.setDead();
        }
    }

    @SubscribeEvent
    public void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
        World w = event.getWorld();
        BlockPos pos = event.getEntityPlayer().getPosition();
        ItemStack tool = event.getEntityPlayer().getHeldItemMainhand();
        if (!w.isRemote && TinkerUtil.hasTrait(TagUtil.getTagSafe(tool), identifier)) {
            NBTTagCompound tag = TagUtil.getExtraTag(tool);
            Data data = Data.read(tag);
            if (data.isMob) {
                data.isMob = false;
                Entity ent
                System.out.println("");
                assert ent != null;
                ent.setPosition(pos.getX(), pos.getY(), pos.getZ());
                w.spawnEntityInWorld(ent);
                event.getEntityPlayer().playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1.0F, 1.0F);
                data.write(tag);
                TagUtil.setExtraTag(tool, tag);
                TagUtil.setEnchantEffect(tool, false);
            }
        }
    }


    @SubscribeEvent
    public void onItemTooltip(ItemTooltipEvent e) {
        ItemStack tool = e.getItemStack();
        if (TinkerUtil.hasTrait(TagUtil.getTagSafe(tool), identifier)) {
            String name;
            NBTTagCompound tag = TagUtil.getExtraTag(tool);
            Data data = Data.read(tag);
            if (!data.isMob) name = "";
            else name = data.mob;
            e.getToolTip().add(TextFormatting.DARK_PURPLE + "Captured: " + TextFormatting.LIGHT_PURPLE + name);
        }
    }

    public static class Data {
        String mob;
        Boolean isMob;

        public static Data read(NBTTagCompound tag) {
            Data data = new Data();
            data.mob = tag.getString("mob");
            data.isMob = tag.getBoolean("isMob");
            return data;
        }

        public void write(NBTTagCompound tag) {
            tag.setString("mob", mob);
            tag.setBoolean("isMob", isMob);
        }
    }
}



