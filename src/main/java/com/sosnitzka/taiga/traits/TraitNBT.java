package com.sosnitzka.taiga.traits;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.common.Sounds;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;

public class TraitNBT extends AbstractTrait {

    public TraitNBT() {
        super("nbt", 0xffff66);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void onHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, boolean isCritical) {
        if (player.worldObj.isRemote) {
            return;
        }
        NBTTagCompound tag = TinkerUtil.getModifierTag(tool, identifier);
        Data data = Data.read(tag);
        if (data.killcount >= 1) {
            if (attackEntitySecondary(new EntityDamageSource("lightningBolt", player), 0f, target, false, true, false)) {
                data.killcount = 0;
                data.charges += 20.4f;
                NBTTagList tagList = TagUtil.getModifiersTagList(tool);
                int index = TinkerUtil.getIndexInCompoundList(tagList, identifier);
                data.write(tag);
                tagList.set(index, tag);
                TagUtil.setModifiersTagList(tool, tagList);
                TagUtil.setEnchantEffect(tool, false);
            }
        }
    }


    @SubscribeEvent
    public void onEntityKill(LivingDeathEvent e) {
        World w = e.getEntity().getEntityWorld();
        if (!w.isRemote && e.getSource().getEntity() != null) {
            if (e.getSource().getEntity() instanceof EntityPlayer) {
                ItemStack tool = ((EntityPlayer) e.getSource().getEntity()).getHeldItemMainhand();
                xupdate(tool, e.getSource().getEntity());
            }
        }
    }

    @Override
    public void miningSpeed(ItemStack tool, PlayerEvent.BreakSpeed event) {
        NBTTagCompound tag = TinkerUtil.getModifierTag(tool, identifier);
        Data data = Data.read(tag);
        float boost = data.charges;
        event.setNewSpeed(event.getNewSpeed() + event.getOriginalSpeed() * boost);
    }

    @SubscribeEvent
    public void onItemTooltip(ItemTooltipEvent e) {
        ItemStack tool = e.getItemStack();

        NBTTagList tagList = TagUtil.getModifiersTagList(tool);
        int index = TinkerUtil.getIndexInCompoundList(tagList, identifier);
        NBTTagCompound tag = tagList.getCompoundTagAt(index);
        Data data = Data.read(tag);

        if (TinkerUtil.hasTrait(TagUtil.getTagSafe(tool), identifier)) {
            e.getToolTip().add(TextFormatting.YELLOW + "Killcount: " + data.killcount);
            e.getToolTip().add(TextFormatting.BLUE + "Charges: " + data.charges);
        }
    }

    public void xupdate(ItemStack tool, Entity entity) {

        NBTTagList tagList = TagUtil.getModifiersTagList(tool);
        int index = TinkerUtil.getIndexInCompoundList(tagList, identifier);
        NBTTagCompound tag = tagList.getCompoundTagAt(index);
        Data data = Data.read(tag);

        // fully charged
        if (data.killcount >= 1) {
            return;
        }
        data.killcount++;
        if (data.killcount >= 1) {
            TagUtil.setEnchantEffect(tool, true);
            // send only to the player that is charged
            if (entity instanceof EntityPlayerMP) {
                Sounds.PlaySoundForPlayer(entity, Sounds.shocking_charged, 1f, 0.8f + 0.2f * random.nextFloat());
            }
        }

        data.write(tag);
        tagList.set(index, tag);
        TagUtil.setModifiersTagList(tool, tagList);
    }

    public static class Data {

        int killcount;
        float charges;

        public static Data read(NBTTagCompound tag) {
            Data data = new Data();
            data.killcount = tag.getInteger("killcount");
            data.charges = tag.getFloat("charges");
            return data;
        }

        public void write(NBTTagCompound tag) {
            tag.setInteger("killcount", killcount);
            tag.setFloat("charges", charges);
        }
    }
}
