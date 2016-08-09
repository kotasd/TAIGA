package com.sosnitzka.taiga;


import com.google.common.base.Joiner;
import com.sosnitzka.taiga.generic.BasicItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Arrays;

import static com.sosnitzka.taiga.util.Utils.PREFIX_INGOT;
import static com.sosnitzka.taiga.util.Utils.PREFIX_NUGGET;

public class Items {

    public static Item lignite = new BasicItem("lignite", null, "lignite");
    public static Item iron_nugget = new BasicItem("iron_nugget", PREFIX_NUGGET);
    public static Item slaggoldIngot = new BasicItem("slaggold_ingot");
    public static Item slagironIngot = new BasicItem("slagiron_ingot");
    public static Item fuel_brick = new BasicItem("fuel_brick");

    //Nuggets
    public static Item tiberium_nugget = new BasicItem("tiberium_nugget", PREFIX_NUGGET);
    public static Item aurodium_nugget = new BasicItem("aurodium_nugget", PREFIX_NUGGET);
    public static Item prometheum_nugget = new BasicItem("prometheum_nugget", PREFIX_NUGGET);
    public static Item arcanite_nugget = new BasicItem("arcanite_nugget", PREFIX_NUGGET);

    public static Item titanite_nugget = new BasicItem("titanite_nugget", PREFIX_NUGGET);
    public static Item mythril_nugget = new BasicItem("mythril_nugget", PREFIX_NUGGET);
    public static Item uru_nugget = new BasicItem("uru_nugget", PREFIX_NUGGET);
    public static Item vibranium_nugget = new BasicItem("vibranium_nugget", PREFIX_NUGGET);

    public static Item eternite_nugget = new BasicItem("eternite_nugget", PREFIX_NUGGET);
    public static Item fractoryte_nugget = new BasicItem("fractoryte_nugget", PREFIX_NUGGET);
    public static Item palladium_nugget = new BasicItem("palladium_nugget", PREFIX_NUGGET);
    public static Item ignitite_nugget = new BasicItem("ignitite_nugget", PREFIX_NUGGET);

    public static Item bismuth_nugget = new BasicItem("bismuth_nugget", PREFIX_NUGGET);
    public static Item jauxite_nugget = new BasicItem("jauxite_nugget", PREFIX_NUGGET);
    public static Item violium_nugget = new BasicItem("violium_nugget", PREFIX_NUGGET);
    public static Item karmesine_nugget = new BasicItem("karmesine_nugget", PREFIX_NUGGET);

    public static Item dyonite_nugget = new BasicItem("dyonite_nugget", PREFIX_NUGGET);
    public static Item cryptogen_nugget = new BasicItem("cryptogen_nugget", PREFIX_NUGGET);
    public static Item proxideum_nugget = new BasicItem("proxideum_nugget", PREFIX_NUGGET);
    public static Item necrodermite_nugget = new BasicItem("necrodermite_nugget", PREFIX_NUGGET);
    public static Item noctune_nugget = new BasicItem("noctune_nugget", PREFIX_NUGGET);
    public static Item terramite_nugget = new BasicItem("terramite_nugget", PREFIX_NUGGET);
    public static Item niobine_nugget = new BasicItem("niobine_nugget", PREFIX_NUGGET);
    public static Item imperomite_nugget = new BasicItem("imperomite_nugget", PREFIX_NUGGET);
    public static Item dysprosanium_nugget = new BasicItem("dysprosanium_nugget", PREFIX_NUGGET);
    public static Item solarium_nugget = new BasicItem("solarium_nugget", PREFIX_NUGGET);
    public static Item nihilite_nugget = new BasicItem("nihilite_nugget", PREFIX_NUGGET);
    public static Item adamantite_nugget = new BasicItem("adamantite_nugget", PREFIX_NUGGET);
    public static Item invalite_nugget = new BasicItem("invalite_nugget", PREFIX_NUGGET);
    public static Item bysmuid_nugget = new BasicItem("bysmuid_nugget", PREFIX_NUGGET);
    public static Item seismodium_nugget = new BasicItem("seismodium_nugget", PREFIX_NUGGET);
    public static Item seismolite_nugget = new BasicItem("seismolite_nugget", PREFIX_NUGGET);
    public static Item nucleum_nugget = new BasicItem("nucleum_nugget", PREFIX_NUGGET);
    public static Item lumixyl_nugget = new BasicItem("lumixyl_nugget", PREFIX_NUGGET);
    public static Item bluenitronite_nugget = new BasicItem("bluenitronite_nugget", PREFIX_NUGGET);
    public static Item rednitronite_nugget = new BasicItem("rednitronite_nugget", PREFIX_NUGGET);
    public static Item radiocite_nugget = new BasicItem("radiocite_nugget", PREFIX_NUGGET);
    public static Item turbidium_nugget = new BasicItem("turbidium_nugget", PREFIX_NUGGET);
    public static Item ultranite_nugget = new BasicItem("ultranite_nugget", PREFIX_NUGGET);
    public static Item astrium_nugget = new BasicItem("astrium_nugget", PREFIX_NUGGET);

    public static Item glimmercoal = new BasicItem("glimmercoal");
    public static Item radiant_pearl = new BasicItem("radiant_pearl");
    public static Item glimmer_pearl = new BasicItem("glimmer_pearl");
    public static Item energy_pearl = new BasicItem("energy_pearl");
    public static Item glimmerstone_dust = new BasicItem("glimmerstone_dust");
    public static Item luminar_dust = new BasicItem("luminar_dust");
    public static Item spectrum_dust = new BasicItem("spectrum_dust");
    public static Item anthracite_dust = new BasicItem("anthracite_dust");
    public static Item nitro_brick = new BasicItem("nitro_brick");

    public static Item tiberium_ingot = new BasicItem("tiberium_ingot", PREFIX_INGOT);
    public static Item aurodium_ingot = new BasicItem("aurodium_ingot", PREFIX_INGOT);
    public static Item prometheum_ingot = new BasicItem("prometheum_ingot", PREFIX_INGOT);
    public static Item arcanite_ingot = new BasicItem("arcanite_ingot", PREFIX_INGOT);

    public static Item titanite_ingot = new BasicItem("titanite_ingot", PREFIX_INGOT);
    public static Item mythril_ingot = new BasicItem("mythril_ingot", PREFIX_INGOT);
    public static Item uru_ingot = new BasicItem("uru_ingot", PREFIX_INGOT);
    public static Item vibranium_ingot = new BasicItem("vibranium_ingot", PREFIX_INGOT);

    public static Item eternite_ingot = new BasicItem("eternite_ingot", PREFIX_INGOT);
    public static Item fractoryte_ingot = new BasicItem("fractoryte_ingot", PREFIX_INGOT);
    public static Item palladium_ingot = new BasicItem("palladium_ingot", PREFIX_INGOT);
    public static Item ignitite_ingot = new BasicItem("ignitite_ingot", PREFIX_INGOT);

    public static Item bismuth_ingot = new BasicItem("bismuth_ingot", PREFIX_INGOT);
    public static Item jauxite_ingot = new BasicItem("jauxite_ingot", PREFIX_INGOT);
    public static Item violium_ingot = new BasicItem("violium_ingot", PREFIX_INGOT);
    public static Item karmesine_ingot = new BasicItem("karmesine_ingot", PREFIX_INGOT);

    public static Item dyonite_ingot = new BasicItem("dyonite_ingot", PREFIX_INGOT);
    public static Item cryptogen_ingot = new BasicItem("cryptogen_ingot", PREFIX_INGOT);
    public static Item proxideum_ingot = new BasicItem("proxideum_ingot", PREFIX_INGOT);
    public static Item necrodermite_ingot = new BasicItem("necrodermite_ingot", PREFIX_INGOT);
    public static Item noctune_ingot = new BasicItem("noctune_ingot", PREFIX_INGOT);
    public static Item terramite_ingot = new BasicItem("terramite_ingot", PREFIX_INGOT);
    public static Item niobine_ingot = new BasicItem("niobine_ingot", PREFIX_INGOT);
    public static Item imperomite_ingot = new BasicItem("imperomite_ingot", PREFIX_INGOT);
    public static Item dysprosanium_ingot = new BasicItem("dysprosanium_ingot", PREFIX_INGOT);
    public static Item solarium_ingot = new BasicItem("solarium_ingot", PREFIX_INGOT);
    public static Item nihilite_ingot = new BasicItem("nihilite_ingot", PREFIX_INGOT);
    public static Item adamantite_ingot = new BasicItem("adamantite_ingot", PREFIX_INGOT);
    public static Item invalite_ingot = new BasicItem("invalite_ingot", PREFIX_INGOT);
    public static Item bysmuid_ingot = new BasicItem("bysmuid_ingot", PREFIX_INGOT);
    public static Item seismodium_ingot = new BasicItem("seismodium_ingot", PREFIX_INGOT);
    public static Item seismolite_ingot = new BasicItem("seismolite_ingot", PREFIX_INGOT);
    public static Item nucleum_ingot = new BasicItem("nucleum_ingot", PREFIX_INGOT);
    public static Item lumixyl_ingot = new BasicItem("lumixyl_ingot", PREFIX_INGOT);
    public static Item bluenitronite_ingot = new BasicItem("bluenitronite_ingot", PREFIX_INGOT);
    public static Item rednitronite_ingot = new BasicItem("rednitronite_ingot", PREFIX_INGOT);
    public static Item radiocite_ingot = new BasicItem("radiocite_ingot", PREFIX_INGOT);
    public static Item turbidium_ingot = new BasicItem("turbidium_ingot", PREFIX_INGOT);
    public static Item ultranite_ingot = new BasicItem("ultranite_ingot", PREFIX_INGOT);
    public static Item astrium_ingot = new BasicItem("astrium_ingot", PREFIX_INGOT);

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
                    if (item.equals(iron_nugget) && OreDictionary.doesOreNameExist("nuggetIron")) {
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
