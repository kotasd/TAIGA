package com.sosnitzka.taiga.traits;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.world.BlockEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitOrganizing extends AbstractTrait {

    private static final float chance = .9f;

    public TraitOrganizing() {
        super("organizing", TextFormatting.GREEN);
    }

    @Override
    public void blockHarvestDrops(ItemStack tool, BlockEvent.HarvestDropsEvent event) {
        float r = random.nextFloat();
        Block b = event.getWorld().getBlockState(event.getPos()).getBlock();
        if (r <= chance && (b.equals(Blocks.STONE) || b.equals(Blocks.COBBLESTONE))) {
            event.getWorld().setBlockState(event.getPos(), Blocks.LOG.getDefaultState());
            ToolHelper.healTool(tool, random.nextInt(5), event.getHarvester());
        }
    }

}