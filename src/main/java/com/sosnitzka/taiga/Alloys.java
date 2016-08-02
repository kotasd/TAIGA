package com.sosnitzka.taiga;


import net.minecraftforge.fluids.FluidRegistry;

import static com.sosnitzka.taiga.Fluids.*;
import static com.sosnitzka.taiga.util.Utils.registerTinkerAlloys;

public class Alloys {

    /**
     * Registers alloying in the smeltery
     */
    static void register() {
        registerTinkerAlloys(molten_nitronite, 2, molten_tiberium, 4, molten_vibranium, 3, molten_nitro, 3);
        registerTinkerAlloys(molten_bysmuid, 1, molten_rubium, 3, molten_bismuth, 2, molten_anthracite, 3);
        registerTinkerAlloys(molten_ultranite, 1, molten_prometheum, 3, molten_adamantite, 2, radiant_enderium, 3);
        registerTinkerAlloys(molten_astrium, 1, molten_arcanite, 3, molten_karmesine, 2, energy_enderium, 3);

        registerTinkerAlloys(molten_imperomite, 2, molten_titanite, 3, molten_palladium, 3, FluidRegistry.LAVA, 3);
        registerTinkerAlloys(molten_dyonite, 1, molten_meteorite, 3, molten_tiberium, 2, molten_spectrum, 3);
        registerTinkerAlloys(molten_solarium, 2, molten_vibranium, 4, molten_ignitite, 4, molten_nitro, 3);
        registerTinkerAlloys(molten_fractoryte, 2, molten_adamantite, 4, molten_rubium, 2, FluidRegistry.LAVA, 3);

        registerTinkerAlloys(molten_aegisalt, 1, molten_eternite, 3, molten_mindorite, 3, molten_glimmercoal, 3);
        registerTinkerAlloys(molten_noctunyx, 1, molten_mythril, 4, molten_titanite, 2, molten_spectrum, 3);
        registerTinkerAlloys(molten_nucleum, 1, molten_palladium, 3, molten_violum, 3, radiant_enderium, 3);
        registerTinkerAlloys(molten_seismodium, 2, molten_ignitite, 5, molten_meteorite, 3, glimming_enderium, 3);

        registerTinkerAlloys(molten_lumixyl, 1, molten_bismuth, 3, molten_prometheum, 2, glimming_enderium, 6);
        registerTinkerAlloys(molten_terramite, 2, molten_violum, 4, molten_eternite, 2, energy_enderium, 3);
        registerTinkerAlloys(molten_cryptogen, 1, molten_mindorite, 4, molten_arcanite, 2, molten_anthracite, 3);
        registerTinkerAlloys(molten_proxideum, 1, molten_karmesine, 3, molten_mythril, 2, molten_glimmercoal, 3);
    }
}
