package com.sosnitzka.taiga.traits;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;


public class TraitSoulbound extends AbstractTrait {


    public TraitSoulbound() {
        super(TraitSoulbound.class.getSimpleName().toLowerCase().substring(5), TextFormatting.RED);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onEntityKill(LivingDeathEvent e) {
        if (e.getSource().getEntity() instanceof EntityPlayer && e.getEntity() instanceof EntityCreature) {
            EntityPlayer p = (EntityPlayer) e.getSource().getEntity();
            if (TinkerUtil.hasTrait(TagUtil.getTagSafe(((EntityPlayer) e.getSource().getEntity()).getHeldItemMainhand()), identifier)) {
                ItemStack tool = ((EntityPlayer) e.getSource().getEntity()).getHeldItemMainhand();
                String name = e.getEntity().getName();
                NBTTagList tagList = TagUtil.getModifiersTagList(tool);
                int index = TinkerUtil.getIndexInCompoundList(tagList, identifier);
                NBTTagCompound tag = tagList.getCompoundTagAt(index);
                Data data = Data.read(tag);
                if (data.killed) {
                    return;
                }
                data.mobname = name;
                data.killed = true;
                data.write(tag);
                tagList.set(index, tag);
                TagUtil.setModifiersTagList(tool, tagList);
            }
        }
    }

    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
        World w = player.getEntityWorld();
        if (!w.isRemote) {
            NBTTagCompound tag = TinkerUtil.getModifierTag(tool, identifier);
            Data data = Data.read(tag);
            if (!data.killed) {
                return damage;
            }
            if (!data.mobname.equals(target.getName())) {
                return damage / (random.nextInt(11) + 10);
            }
            float x = (1 + random.nextFloat() * 4);
            return damage * x;
        }
        System.out.println("Standard " + damage);
        return damage;
    }


    @SubscribeEvent
    public void onItemTooltip(ItemTooltipEvent e) {
        ItemStack tool = e.getItemStack();
        if (TinkerUtil.hasTrait(TagUtil.getTagSafe(tool), identifier)) {
            String name;
            NBTTagList tagList = TagUtil.getModifiersTagList(tool);
            int index = TinkerUtil.getIndexInCompoundList(tagList, identifier);
            NBTTagCompound tag = tagList.getCompoundTagAt(index);
            Data data = Data.read(tag);
            if (data.killed == false) name = "-";
            else name = data.mobname;
            e.getToolTip().add(TextFormatting.DARK_PURPLE + "Bound to: " + TextFormatting.LIGHT_PURPLE + name);
        }
    }


    public static class Data {

        String mobname;
        Boolean killed;

        public static Data read(NBTTagCompound tag) {
            Data data = new Data();
            data.mobname = tag.getString("mobname");
            data.killed = tag.getBoolean("killed");
            return data;
        }

        public void write(NBTTagCompound tag) {
            tag.setString("mobname", mobname);
            tag.setBoolean("killed", killed);
        }
    }

}
