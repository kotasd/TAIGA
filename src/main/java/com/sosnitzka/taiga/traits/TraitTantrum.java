package com.sosnitzka.taiga.traits;

import com.sosnitzka.taiga.util.Utils;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.common.Sounds;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;

import static com.sosnitzka.taiga.Blocks.tiberiumOre;

public class TraitTantrum extends AbstractTrait {

    /*
     *  Collects tiberium, to release it for a small explosion
     */

    public static float max_charges = 12f;
    public static float max_power = 4;

    public TraitTantrum() {
        super("tantrum", TextFormatting.RED);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onItemTooltip(ItemTooltipEvent e) {
        ItemStack tool = e.getItemStack();
        if (TinkerUtil.hasTrait(TagUtil.getTagSafe(tool), identifier)) {
            NBTTagList tagList = TagUtil.getModifiersTagList(tool);
            int index = TinkerUtil.getIndexInCompoundList(tagList, identifier);
            NBTTagCompound tag = tagList.getCompoundTagAt(index);
            Data data = Data.read(tag);
            e.getToolTip().add(TextFormatting.RED + "Charge: " + data.amount);
        }
    }

    @Override
    public void blockHarvestDrops(ItemStack tool, BlockEvent.HarvestDropsEvent event) {
        World w = event.getWorld();
        if (!w.isRemote) {
            if (event.getState().getBlock().equals(tiberiumOre)) {
                event.getDrops().clear();
                NBTTagList tagList = TagUtil.getModifiersTagList(tool);
                int index = TinkerUtil.getIndexInCompoundList(tagList, identifier);
                NBTTagCompound tag = tagList.getCompoundTagAt(index);
                Data data = Data.read(tag);
                if (data.amount >= max_charges) {
                    return;
                }
                data.amount += (0.25f + Utils.round2(random.nextDouble() / 4));
                if (data.amount >= 12f) {
                    TagUtil.setEnchantEffect(tool, true);
                    if (event.getHarvester() instanceof EntityPlayerMP) {
                        Sounds.PlaySoundForPlayer(event.getHarvester(), Sounds.shocking_discharge, 1f, 0.8f + .2f * random.nextFloat());
                    }
                }
                data.write(tag);
                tagList.set(index, tag);
                TagUtil.setModifiersTagList(tool, tagList);
            }
        }
    }

    @SubscribeEvent
    public void RightClickItem(PlayerInteractEvent.RightClickItem event) {
        World w = event.getWorld();
        BlockPos pos = event.getPos();
        ItemStack tool = event.getEntityPlayer().getHeldItemMainhand();
        if (!w.isRemote && TinkerUtil.hasTrait(TagUtil.getTagSafe(tool), identifier)) {
            NBTTagCompound tag = TinkerUtil.getModifierTag(tool, identifier);
            Data data = Data.read(tag);
            if (data.amount > 1f) {
                double d = Math.min(Utils.round2(random.nextDouble() * data.amount), max_power);
                w.newExplosion(event.getEntityPlayer(), pos.getX(), pos.getY(), pos.getZ(), (float) Math.pow((double) 1.2f, d), random.nextBoolean(), true);
                data.amount -= d;
                NBTTagList tagList = TagUtil.getModifiersTagList(tool);
                int index = TinkerUtil.getIndexInCompoundList(tagList, identifier);
                data.write(tag);
                tagList.set(index, tag);
                TagUtil.setModifiersTagList(tool, tagList);
                TagUtil.setEnchantEffect(tool, false);
            }
        }
    }


    public static class Data {

        float amount;

        public static Data read(NBTTagCompound tag) {
            Data data = new Data();
            data.amount = tag.getFloat("amount");
            return data;
        }

        public void write(NBTTagCompound tag) {
            tag.setFloat("amount", amount);
        }
    }


}
