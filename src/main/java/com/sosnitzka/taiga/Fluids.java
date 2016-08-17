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
import static com.sosnitzka.taiga.MaterialTraits.*;
import static com.sosnitzka.taiga.util.Utils.registerFluid;
import static slimeknights.tconstruct.library.TinkerRegistry.registerMelting;

public class Fluids {

    public static BasicTinkerFluid moltenTiberium = new BasicTinkerFluid("tiberium", materialTiberium.materialTextColor, 352, 10, 1553);
    public static BasicTinkerFluid moltenAurodium = new BasicTinkerFluid("aurodium", materialAurodium.materialTextColor, 200, 600, 1653);
    public static BasicTinkerFluid moltenPrometheum = new BasicTinkerFluid("prometheum", materialPrometheum.materialTextColor, 786, 2, 2256);
    public static BasicTinkerFluid moltenArcanite = new BasicTinkerFluid("arcanite", materialArcanite.materialTextColor, 538, 8, 3768);

    public static BasicTinkerFluid moltenTitanite = new BasicTinkerFluid("titanite", materialTitanite.materialTextColor, 942, 7, 1858);
    public static BasicTinkerFluid moltenMythril = new BasicTinkerFluid("mythril", materialMythril.materialTextColor, 841, 10, 1579);
    public static BasicTinkerFluid moltenUru = new BasicTinkerFluid("uru", materialUru.materialTextColor, 942, 10, 2588);
    public static BasicTinkerFluid moltenVibranium = new BasicTinkerFluid("vibranium", materialVibranium.materialTextColor, 1050, 9, 3402);

    public static BasicTinkerFluid moltenEternite = new BasicTinkerFluid("eternite", materialEternite.materialTextColor, 542, 10, 3980);
    public static BasicTinkerFluid moltenFractoryte = new BasicTinkerFluid("fractoryte", materialFractoryte.materialTextColor, 670, 8, 3805);
    public static BasicTinkerFluid moltenPalladium = new BasicTinkerFluid("palladium", materialPalladium.materialTextColor, 786, 10, 3302);
    public static BasicTinkerFluid moltenIgnitite = new BasicTinkerFluid("ignitite", materialIgnitite.materialTextColor, 422, 9, 3787);

    public static BasicTinkerFluid moltenBismuth = new BasicTinkerFluid("bismuth", materialBismuth.materialTextColor, 612, 9, 2552);
    public static BasicTinkerFluid moltenJauxite = new BasicTinkerFluid("jauxite", materialJauxite.materialTextColor, 671, 8, 2956);
    public static BasicTinkerFluid moltenViolum = new BasicTinkerFluid("violium", materialViolium.materialTextColor, 875, 10, 3970);
    public static BasicTinkerFluid moltenKarmesine = new BasicTinkerFluid("karmesine", materialKarmesine.materialTextColor, 499, 7, 3978);


    public static BasicTinkerFluid moltenDyonite = new BasicTinkerFluid("dyonite", materialVibranium.materialTextColor, 486, 8, 3269);
    public static BasicTinkerFluid moltenCryptogen = new BasicTinkerFluid("cryptogen", materialCryptogen.materialTextColor, 560, 10, 3243);
    public static BasicTinkerFluid moltenProxideum = new BasicTinkerFluid("proxideum", materialProxideum.materialTextColor, 700, 9, 3859);
    public static BasicTinkerFluid moltenNecrodermite = new BasicTinkerFluid("necrotermite", materialNecrodermite.materialTextColor, 712, 8, 3983);
    public static BasicTinkerFluid moltenNoctune = new BasicTinkerFluid("noctune", materialNoctune.materialTextColor, 712, 8, 3983);
    public static BasicTinkerFluid moltenNiobine = new BasicTinkerFluid("niobine", materialNiobine.materialTextColor, 687, 10, 2121);
    public static BasicTinkerFluid moltenTerramite = new BasicTinkerFluid("terramite", materialTerramite.materialTextColor, 687, 10, 2121);
    public static BasicTinkerFluid moltenImperomite = new BasicTinkerFluid("imperomite", materialImperomite.materialTextColor, 510, 10, 2353);
    public static BasicTinkerFluid moltenDysprosanium = new BasicTinkerFluid("dysprosanium", materialDysprosanium.materialTextColor, 510, 10, 2353);
    public static BasicTinkerFluid moltenSolarium = new BasicTinkerFluid("solarium", materialSolarium.materialTextColor, 482, 8, 3232);
    public static BasicTinkerFluid moltenNihilite = new BasicTinkerFluid("nihilite", materialNihilite.materialTextColor, 680, 10, 2185);
    public static BasicTinkerFluid moltenAdamantite = new BasicTinkerFluid("adamantite", materialAdamantite.materialTextColor, 1100, 10, 3597);
    public static BasicTinkerFluid moltenInvalite = new BasicTinkerFluid("invalite", materialInvalite.materialTextColor, 680, 10, 2185);
    public static BasicTinkerFluid moltenBysmuid = new BasicTinkerFluid("bysmuid", materialBysmuid.materialTextColor, 560, 8, 2674);
    public static BasicTinkerFluid moltenSeismodium = new BasicTinkerFluid("seismodium", materialSeismodium.materialTextColor, 831, 10, 1837);
    public static BasicTinkerFluid moltenSeismolite = new BasicTinkerFluid("seismolite", materialSeismolite.materialTextColor, 831, 10, 1837);
    public static BasicTinkerFluid moltenNucleum = new BasicTinkerFluid("nucleum", materialNucleum.materialTextColor, 813, 10, 2355);
    public static BasicTinkerFluid moltenLumixyl = new BasicTinkerFluid("lumixyl", materialLumixyl.materialTextColor, 548, 10, 2165);
    public static BasicTinkerFluid moltenRednitronite = new BasicTinkerFluid("rednitronite", materialRednitronite.materialTextColor, 680, 10, 2185);
    public static BasicTinkerFluid moltenBluenitronite = new BasicTinkerFluid("bluenitronite", materialBluenitronite.materialTextColor, 680, 10, 2185);
    public static BasicTinkerFluid moltenRadiocite = new BasicTinkerFluid("radiocite", materialRadiocite.materialTextColor, 810, 10, 1525);
    public static BasicTinkerFluid moltenTurbidium = new BasicTinkerFluid("turbidium", materialTurbidium.materialTextColor, 810, 10, 1525);
    public static BasicTinkerFluid moltenUltranite = new BasicTinkerFluid("ultranite", materialUltranite.materialTextColor, 941, 9, 1784);
    public static BasicTinkerFluid moltenAstrium = new BasicTinkerFluid("astrium", materialAstrium.materialTextColor, 810, 10, 1525);





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
        registerMelting(radiantPearl, radiant_enderium, 72);
        registerMelting(glimmerPearl, glimming_enderium, 72);
        registerMelting(glimmercoal, molten_glimmercoal, 72);
        registerMelting(anthraciteDust, molten_anthracite, 72);
        registerMelting(spectrumDust, molten_spectrum, 72);
        registerMelting(Blocks.OBSIDIAN, FluidRegistry.LAVA, 432);
        registerMelting(Blocks.NETHERRACK, FluidRegistry.LAVA, 48);
        registerMelting(Blocks.STONE, FluidRegistry.LAVA, 144);
        registerMelting(slagironOre, TinkerFluids.iron, 16);
        registerMelting(slagironIngot, TinkerFluids.iron, 24);
        registerMelting(slaggoldOre, TinkerFluids.gold, 16);
        registerMelting(slaggoldIngot, TinkerFluids.gold, 24);

    }
}
