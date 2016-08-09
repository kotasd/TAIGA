package com.sosnitzka.taiga;


import static com.sosnitzka.taiga.Fluids.*;
import static com.sosnitzka.taiga.util.Utils.registerTinkerAlloys;

public class Alloys {

    /**
     * Registers alloying in the smeltery
     */
    static void register() {
        registerTinkerAlloys(molten_rednitronite, molten_tiberium, molten_vibranium, molten_nitro);
    }
}
