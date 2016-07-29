package com.sosnitzka.taiga.traits;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;

import static com.sosnitzka.taiga.Blocks.rottenGround;


public class TraitNatureBound extends AbstractTrait {

    public TraitNatureBound() {
        super("naturebound", TextFormatting.GREEN);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public int onToolHeal(ItemStack tool, int amount, int newAmount, EntityLivingBase entity) {
        // 5% less durability repaired!
        return newAmount - amount * 10 / 100;
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        // *20 because 20 ticks in a second
        int chance = 20;
        Block b = world.getBlockState(entity.getPosition().down()).getBlock();
        if (!world.isRemote && entity instanceof EntityLivingBase && random.nextInt(20 * chance) == 0) {
            if (b.equals(Blocks.GRASS) || b.equals(Blocks.LOG) || b.equals(Blocks.LOG2) || b.equals(rottenGround) || b.equals(Blocks.LEAVES) || b.equals(Blocks.LEAVES2)) {
                ToolHelper.healTool(tool, random.nextInt(3) + 1, (EntityLivingBase) entity);
            } else ToolHelper.damageTool(tool, 1, (EntityLivingBase) entity);
        }
    }
}
