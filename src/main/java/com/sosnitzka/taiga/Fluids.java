package com.sosnitzka.taiga;


import com.sosnitzka.taiga.generic.BasicTinkerFluid;
import com.sosnitzka.taiga.util.Utils;
import net.minecraft.init.Blocks;
import net.minecraftforge.fluids.FluidRegistry;
import slimeknights.tconstruct.shared.TinkerFluids;
import slimeknights.tconstruct.smeltery.block.BlockMolten;

import java.lang.reflect.Field;

import static com.sosnitzka.taiga.Blocks.slaggoldOre;
import static com.sosnitzka.taiga.Blocks.slagironOre;
import static com.sosnitzka.taiga.Items.*;
import static com.sosnitzka.taiga.util.Utils.registerFluid;
import static slimeknights.tconstruct.library.TinkerRegistry.registerMelting;

public class Fluids {

    public static BasicTinkerFluid molten_arcanite = new BasicTinkerFluid("arcanite", 0xFF272354, true, 538, 8, 3768);
    public static BasicTinkerFluid molten_titanite = new BasicTinkerFluid("titanite", 0xFFe0ede7, true, 942, 7, 1858);
    public static BasicTinkerFluid molten_adamantite = new BasicTinkerFluid("adamantite", 0xFFc45c82, true, 1100, 10, 3597);
    public static BasicTinkerFluid molten_violum = new BasicTinkerFluid("violium", 0xFF264c4f, true, 875, 10, 3970);
    public static BasicTinkerFluid molten_bismuth = new BasicTinkerFluid("bismuth", 0xFF555555, true, 612, 9, 2552);
    public static BasicTinkerFluid molten_eternite = new BasicTinkerFluid("eternite", 0xFFfafa98, true, 542, 10, 3980);
    public static BasicTinkerFluid molten_ignitite = new BasicTinkerFluid("ignitite", 0xFFff6642, true, 422, 9, 3787);
    public static BasicTinkerFluid molten_karmesine = new BasicTinkerFluid("karmesine", 0xFFc16d6d, true, 499, 7, 3978);
    public static BasicTinkerFluid molten_meteorite = new BasicTinkerFluid("meteorite", 0xFF6e6a62, true, 942, 10, 2588);
    public static BasicTinkerFluid molten_mindorite = new BasicTinkerFluid("mindorite", 0xFF6bbbff, true, 671, 8, 2956);
    public static BasicTinkerFluid molten_mythril = new BasicTinkerFluid("mythril", 0xFFa8c0ba, true, 841, 10, 1579);
    public static BasicTinkerFluid molten_palladium = new BasicTinkerFluid("palladium", 0xFFfe5c05, true, 786, 10, 3302);
    public static BasicTinkerFluid molten_prometheum = new BasicTinkerFluid("prometheum", 0xFF2b282f, true, 786, 2, 2256);
    public static BasicTinkerFluid molten_tiberium = new BasicTinkerFluid("tiberium", 0xFF5f9e2d, true, 352, 10, 1553);
    public static BasicTinkerFluid molten_vibranium = new BasicTinkerFluid("vibranium", 0xFFc4ddc8, true, 1050, 9, 3402);
    public static BasicTinkerFluid molten_rubium = new BasicTinkerFluid("rubium", 0xFFe371b0, true, 200, 600, 1653);
    public static BasicTinkerFluid molten_astrium = new BasicTinkerFluid("astrium", 0xFF7a3b74, true, 810, 10, 1525);
    public static BasicTinkerFluid molten_nitronite = new BasicTinkerFluid("nitronite", 0xFFdfe553, true, 680, 10, 2185);
    public static BasicTinkerFluid molten_proxideum = new BasicTinkerFluid("proxideum", 0xFF2f7177, true, 700, 9, 3859);
    public static BasicTinkerFluid molten_noctunyx = new BasicTinkerFluid("noctunyx", 0xFF5f5081, true, 712, 8, 3983);
    public static BasicTinkerFluid molten_imperomite = new BasicTinkerFluid("imperomite", 0xFF5cc96b, true, 510, 10, 2353);
    public static BasicTinkerFluid molten_cryptogen = new BasicTinkerFluid("cryptogen", 0xFF9f8a4a, true, 560, 10, 3243);
    public static BasicTinkerFluid molten_fractoryte = new BasicTinkerFluid("fractoryte", 0xFF983f11, true, 670, 8, 3805);
    public static BasicTinkerFluid molten_seismodium = new BasicTinkerFluid("seismodium", 0xFF46131D, true, 831, 10, 1837);
    public static BasicTinkerFluid molten_terramite = new BasicTinkerFluid("terramite", 0xFFa6b27a, true, 687, 10, 2121);
    public static BasicTinkerFluid molten_lumixyl = new BasicTinkerFluid("lumixyl", 0xFFfbe8cb, true, 548, 10, 2165);
    public static BasicTinkerFluid molten_solarium = new BasicTinkerFluid("solarium", 0xFFffc81d, true, 482, 8, 3232);
    public static BasicTinkerFluid molten_dyonite = new BasicTinkerFluid("dyonite", 0xFFff6743, true, 486, 8, 3269);
    public static BasicTinkerFluid molten_ultranite = new BasicTinkerFluid("ultranite", 0xFFf5f294, true, 941, 9, 1784);
    public static BasicTinkerFluid molten_nucleum = new BasicTinkerFluid("nucleum", 0xFFa8ea3b, true, 813, 10, 2355);
    public static BasicTinkerFluid molten_aegisalt = new BasicTinkerFluid("aegisalt", 0xFFb6af74, true, 660, 7, 2089);
    public static BasicTinkerFluid molten_bysmuid = new BasicTinkerFluid("bysmuid", 0xFF7b97b0, true, 560, 8, 2674);


    // Additional fluids to cast alloys
    public static BasicTinkerFluid radiant_enderium = new BasicTinkerFluid("radiant_enderium", 0xFFbcea5d, false, 529, 10, 768);
    public static BasicTinkerFluid glimming_enderium = new BasicTinkerFluid("glimming_enderium", 0xFFfffc98, false, 633, 10, 821);
    public static BasicTinkerFluid energy_enderium = new BasicTinkerFluid("energy_enderium", 0xFFffb498, false, 562, 10, 421);
    public static BasicTinkerFluid molten_glimmercoal = new BasicTinkerFluid("glimmercoal_fluid", 0xFFee7c28, false, 531, 10, 312);
    public static BasicTinkerFluid molten_nitro = new BasicTinkerFluid("nitro_fluid", 0xFF223512, false, 405, 5, 772);
    public static BasicTinkerFluid molten_anthracite = new BasicTinkerFluid("anthracite_fluid", 0xFF111111, false, 500, 0, 632);
    public static BasicTinkerFluid molten_spectrum = new BasicTinkerFluid("spectrum_fluid", 0xFF64748f, false, 600, 0, 512);

    /**
     * Registers all materials' fluids <br>
     * Detailed summary: <br>
     * Gets the fluids declared in the class (fields and reflection) and iterates through them: <br>
     * Checks that the field is static, registers the field (fluids), and registers the models on the client
     */
    static void register() {
        Field[] declaredFields = Fluids.class.getDeclaredFields(); // Gets the blocks and ores declared above
        for (Field field : declaredFields) { // Iterates through the fields declared above
            if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) { // Checks that the fields are static
                Class<?> targetType = field.getType();
                try {
                    BasicTinkerFluid fluid = (BasicTinkerFluid) field.get(targetType); // Gets the field as a BasicTinkerFluid
                    registerFluid(fluid); // Registers the fluid into the game along wit its bucket

                    BlockMolten block = new BlockMolten(fluid);
                    // Sets names
                    block.setUnlocalizedName("molten_" + fluid.getName());
                    block.setRegistryName(TAIGA.MODID, "molten_" + fluid.getName());
                    // Registers the fluid in its block form and its corresponding item (block/fluid as item in inventory)
                    Utils.registerBlockWithItem(block);
                    // Registers the fluid's model but only on the client side
                    TAIGA.proxy.registerFluidModels(fluid);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Registers special smeltery recipes (not alloying)
     */
    static void registerfromItem() {
        registerMelting(radiant_pearl, radiant_enderium, 72);
        registerMelting(glimmer_pearl, glimming_enderium, 72);
        registerMelting(energy_pearl, energy_enderium, 72);
        registerMelting(glimmercoal, molten_glimmercoal, 72);
        registerMelting(nitro_brick, molten_nitro, 72);
        registerMelting(anthracite_dust, molten_anthracite, 72);
        registerMelting(spectrum_dust, molten_spectrum, 72);
        registerMelting(Blocks.OBSIDIAN, FluidRegistry.LAVA, 432);
        registerMelting(Blocks.NETHERRACK, FluidRegistry.LAVA, 48);
        registerMelting(Blocks.STONE, FluidRegistry.LAVA, 144);
        registerMelting(slagironOre, TinkerFluids.iron, 16);
        registerMelting(slagironIngot, TinkerFluids.iron, 24);
        registerMelting(slaggoldOre, TinkerFluids.gold, 16);
        registerMelting(slaggoldIngot, TinkerFluids.gold, 24);

    }
}
