package com.sosnitzka.taiga.recipes;


import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import static com.sosnitzka.taiga.Blocks.*;
import static com.sosnitzka.taiga.Items.*;

public class SmeltingRegistry {
    public static void register() {
        GameRegistry.addSmelting(slagironOre, new ItemStack(slagironIngot), 0.5F);
        ItemStack nugget_iron = OreDictionary.getOres("nuggetIron").get(OreDictionary.getOres("nuggetIron").size() - 1);
        GameRegistry.addSmelting(slagironIngot, nugget_iron, 0);
        GameRegistry.addSmelting(slaggoldIngot, new ItemStack(Items.GOLD_NUGGET), 0);
        GameRegistry.addSmelting(slaggoldOre, new ItemStack(slaggoldIngot), 0.8F);
        GameRegistry.addSmelting(tiberiumOre, new ItemStack(tiberiumShardInstable, 6), (1F));
        GameRegistry.addSmelting(tiberiumShardInstable, new ItemStack(tiberiumIngot), (.1F));
    }
}
