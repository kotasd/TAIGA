package com.sosnitzka.taiga;


import com.google.common.base.Joiner;
import com.sosnitzka.taiga.generic.BasicItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Arrays;

import static com.sosnitzka.taiga.util.Utils.PREFIX_DUST;
import static com.sosnitzka.taiga.util.Utils.PREFIX_INGOT;
import static com.sosnitzka.taiga.util.Utils.PREFIX_NUGGET;

public class Items {

    public static Item lignite = new BasicItem("lignite", null, "lignite");
    public static Item ironNugget = new BasicItem("iron_nugget", PREFIX_NUGGET);
    public static Item slaggoldIngot = new BasicItem("slaggold_ingot");
    public static Item slagironIngot = new BasicItem("slagiron_ingot");
    public static Item fuelBrick = new BasicItem("fuel_brick");

    //Nuggets
    public static Item tiberiumNugget = new BasicItem("tiberium_nugget", PREFIX_NUGGET);
    public static Item aurodiumNugget = new BasicItem("aurodium_nugget", PREFIX_NUGGET);
    public static Item prometheumNugget = new BasicItem("prometheum_nugget", PREFIX_NUGGET);
    public static Item arcaniteNugget = new BasicItem("arcanite_nugget", PREFIX_NUGGET);

    public static Item titaniteNugget = new BasicItem("titanite_nugget", PREFIX_NUGGET);
    public static Item mythrilNugget = new BasicItem("mythril_nugget", PREFIX_NUGGET);
    public static Item uruNugget = new BasicItem("uru_nugget", PREFIX_NUGGET);
    public static Item vibraniumNugget = new BasicItem("vibranium_nugget", PREFIX_NUGGET);

    public static Item eterniteNugget = new BasicItem("eternite_nugget", PREFIX_NUGGET);
    public static Item fractoryteNugget = new BasicItem("fractoryte_nugget", PREFIX_NUGGET);
    public static Item palladiumNugget = new BasicItem("palladium_nugget", PREFIX_NUGGET);
    public static Item ignititeNugget = new BasicItem("ignitite_nugget", PREFIX_NUGGET);

    public static Item bismuthNugget = new BasicItem("bismuth_nugget", PREFIX_NUGGET);
    public static Item jauxiteNugget = new BasicItem("jauxite_nugget", PREFIX_NUGGET);
    public static Item violiumNugget = new BasicItem("violium_nugget", PREFIX_NUGGET);
    public static Item karmesineNugget = new BasicItem("karmesine_nugget", PREFIX_NUGGET);

    public static Item dyoniteNugget = new BasicItem("dyonite_nugget", PREFIX_NUGGET);
    public static Item cryptogenNugget = new BasicItem("cryptogen_nugget", PREFIX_NUGGET);
    public static Item proxideumNugget = new BasicItem("proxideum_nugget", PREFIX_NUGGET);
    public static Item necrodermiteNugget = new BasicItem("necrodermite_nugget", PREFIX_NUGGET);
    public static Item noctuneNugget = new BasicItem("noctune_nugget", PREFIX_NUGGET);
    public static Item niobineNugget = new BasicItem("niobine_nugget", PREFIX_NUGGET);
    public static Item terramiteNugget = new BasicItem("terramite_nugget", PREFIX_NUGGET);
    public static Item imperomiteNugget = new BasicItem("imperomite_nugget", PREFIX_NUGGET);
    public static Item dysprosaniumNugget = new BasicItem("dysprosanium_nugget", PREFIX_NUGGET);
    public static Item solariumNugget = new BasicItem("solarium_nugget", PREFIX_NUGGET);
    public static Item nihiliteNugget = new BasicItem("nihilite_nugget", PREFIX_NUGGET);
    public static Item adamantiteNugget = new BasicItem("adamantite_nugget", PREFIX_NUGGET);
    public static Item invaliteNugget = new BasicItem("invalite_nugget", PREFIX_NUGGET);
    public static Item bysmuidNugget = new BasicItem("bysmuid_nugget", PREFIX_NUGGET);
    public static Item seismodiumNugget = new BasicItem("seismodium_nugget", PREFIX_NUGGET);
    public static Item seismoliteNugget = new BasicItem("seismolite_nugget", PREFIX_NUGGET);
    public static Item nucleumNugget = new BasicItem("nucleum_nugget", PREFIX_NUGGET);
    public static Item lumixylNugget = new BasicItem("lumixyl_nugget", PREFIX_NUGGET);
    public static Item bluenitroniteNugget = new BasicItem("bluenitronite_nugget", PREFIX_NUGGET);
    public static Item rednitroniteNugget = new BasicItem("rednitronite_nugget", PREFIX_NUGGET);
    public static Item radiociteNugget = new BasicItem("radiocite_nugget", PREFIX_NUGGET);
    public static Item turbidiumNugget = new BasicItem("turbidium_nugget", PREFIX_NUGGET);
    public static Item ultraniteNugget = new BasicItem("ultranite_nugget", PREFIX_NUGGET);
    public static Item astriumNugget = new BasicItem("astrium_nugget", PREFIX_NUGGET);

    public static Item glimmercoal = new BasicItem("glimmercoal");
    public static Item radiantPearl = new BasicItem("radiant_pearl");
    public static Item glimmerPearl = new BasicItem("glimmer_pearl");
    public static Item energyPearl = new BasicItem("energy_pearl");
    public static Item glimmerstoneDust = new BasicItem("glimmerstone_dust", PREFIX_DUST);
    public static Item luminarDust = new BasicItem("luminar_dust", PREFIX_DUST);
    public static Item spectrumDust = new BasicItem("spectrum_dust", PREFIX_DUST);
    public static Item anthraciteDust = new BasicItem("anthracite_dust", PREFIX_DUST);
    public static Item nitroBrick = new BasicItem("nitro_brick");

    public static Item tiberiumIngot = new BasicItem("tiberium_ingot", PREFIX_INGOT);
    public static Item aurodiumIngot = new BasicItem("aurodium_ingot", PREFIX_INGOT);
    public static Item prometheumIngot = new BasicItem("prometheum_ingot", PREFIX_INGOT);
    public static Item arcaniteIngot = new BasicItem("arcanite_ingot", PREFIX_INGOT);

    public static Item titaniteIngot = new BasicItem("titanite_ingot", PREFIX_INGOT);
    public static Item mythrilIngot = new BasicItem("mythril_ingot", PREFIX_INGOT);
    public static Item uruIngot = new BasicItem("uru_ingot", PREFIX_INGOT);
    public static Item vibraniumIngot = new BasicItem("vibranium_ingot", PREFIX_INGOT);

    public static Item eterniteIngot = new BasicItem("eternite_ingot", PREFIX_INGOT);
    public static Item fractoryteIngot = new BasicItem("fractoryte_ingot", PREFIX_INGOT);
    public static Item palladiumIngot = new BasicItem("palladium_ingot", PREFIX_INGOT);
    public static Item ignititeIngot = new BasicItem("ignitite_ingot", PREFIX_INGOT);

    public static Item bismuthIngot = new BasicItem("bismuth_ingot", PREFIX_INGOT);
    public static Item jauxiteIngot = new BasicItem("jauxite_ingot", PREFIX_INGOT);
    public static Item violiumIngot = new BasicItem("violium_ingot", PREFIX_INGOT);
    public static Item karmesineIngot = new BasicItem("karmesine_ingot", PREFIX_INGOT);

    public static Item dyoniteIngot = new BasicItem("dyonite_ingot", PREFIX_INGOT);
    public static Item cryptogenIngot = new BasicItem("cryptogen_ingot", PREFIX_INGOT);
    public static Item proxideumIngot = new BasicItem("proxideum_ingot", PREFIX_INGOT);
    public static Item necrodermiteIngot = new BasicItem("necrodermite_ingot", PREFIX_INGOT);
    public static Item noctuneIngot = new BasicItem("noctune_ingot", PREFIX_INGOT);
    public static Item niobineIngot = new BasicItem("niobine_ingot", PREFIX_INGOT);
    public static Item terramiteIngot = new BasicItem("terramite_ingot", PREFIX_INGOT);
    public static Item imperomiteIngot = new BasicItem("imperomite_ingot", PREFIX_INGOT);
    public static Item dysprosaniumIngot = new BasicItem("dysprosanium_ingot", PREFIX_INGOT);
    public static Item solariumIngot = new BasicItem("solarium_ingot", PREFIX_INGOT);
    public static Item nihiliteIngot = new BasicItem("nihilite_ingot", PREFIX_INGOT);
    public static Item adamantiteIngot = new BasicItem("adamantite_ingot", PREFIX_INGOT);
    public static Item invaliteIngot = new BasicItem("invalite_ingot", PREFIX_INGOT);
    public static Item bysmuidIngot = new BasicItem("bysmuid_ingot", PREFIX_INGOT);
    public static Item seismodiumIngot = new BasicItem("seismodium_ingot", PREFIX_INGOT);
    public static Item seismoliteIngot = new BasicItem("seismolite_ingot", PREFIX_INGOT);
    public static Item nucleumIngot = new BasicItem("nucleum_ingot", PREFIX_INGOT);
    public static Item lumixylIngot = new BasicItem("lumixyl_ingot", PREFIX_INGOT);
    public static Item bluenitroniteIngot = new BasicItem("bluenitronite_ingot", PREFIX_INGOT);
    public static Item rednitroniteIngot = new BasicItem("rednitronite_ingot", PREFIX_INGOT);
    public static Item radiociteIngot = new BasicItem("radiocite_ingot", PREFIX_INGOT);
    public static Item turbidiumIngot = new BasicItem("turbidium_ingot", PREFIX_INGOT);
    public static Item ultraniteIngot = new BasicItem("ultranite_ingot", PREFIX_INGOT);
    public static Item astriumIngot = new BasicItem("astrium_ingot", PREFIX_INGOT);

    public static Item tiberiumShardInstable = new BasicItem("tiberium_shard_instable");

    /**
     * Registers all materials' ingots and nuggets <br>
     * Detailed summary: <br>
     * Gets the ingots declared in the class (fields and reflection) and iterates through them: <br>
     * Checks that the field is static, registers the field (item), and adds an oreDict entry if needed
     */
    public static void register() {
        Field[] declaredFields = Items.class.getDeclaredFields(); // Gets the fields (ingots) declared above
        for (Field field : declaredFields) { // Iterates through the fields declared above
            if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) { // Checks that the fields are static
                Class<?> targetType = field.getType();
                try {
                    Item item = (Item) field.get(targetType); // Gets the field as a BasicItem which is then casted to an Item
                    if (item.equals(ironNugget) && OreDictionary.doesOreNameExist("nuggetIron")) {
                        System.out.println("TAIGA: Skipped registration of nuggetIron which already exists.");
                        continue;
                    }
                    item.setCreativeTab(CreativeTab.tabTaigaItem);
                    GameRegistry.register(item); // Registers the item into the game
                    if (item instanceof BasicItem) {  // Checks that the item is a BasicItem
                        if (((BasicItem) item).isOreDict()) { // Checks if this item should be registered into the oreDict and registers it
                            String oreDictName;
                            String[] nameParts = item.getUnlocalizedName().replace("item.", "").split("_");

                            if (nameParts.length > 2) {
                                oreDictName = Joiner.on("_").join(Arrays.copyOfRange(nameParts, 0, nameParts.length - 1));
                            } else {
                                oreDictName = nameParts[0];
                            }

                            OreDictionary.registerOre(((BasicItem) item).getOreDictPrefix() + StringUtils.capitalize(oreDictName), item); // Registers into oreDict
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
