package com.sosnitzka.taiga.traits;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;


public class TraitMelting extends AbstractTrait {

    public TraitMelting() {
        super("melting", TextFormatting.YELLOW);
    }

    @Override
    public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase player, boolean wasEffective) {
        float r = random.nextFloat();
        Block b = state.getBlock();
        System.out.println("Float " + r);
        System.out.println("Block " + b);
        System.out.println("Block 2 " + Blocks.STONE);
        if (!world.isRemote && r <= 0.901 && (b == Blocks.STONE || b == Blocks.COBBLESTONE || b == Blocks.NETHERRACK)) {
            System.out.println("Sollte es eigentlich tun!??!?! ");
            world.setBlockState(pos.down(), Blocks.MAGMA.getDefaultState());
            world.setBlockState(pos.up(), Blocks.GLASS.getDefaultState());
        }
    }
}



