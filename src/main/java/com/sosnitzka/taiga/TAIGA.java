package com.sosnitzka.taiga;

import com.google.common.collect.Lists;
import com.sosnitzka.taiga.proxy.CommonProxy;
import com.sosnitzka.taiga.recipes.CraftingRegistry;
import com.sosnitzka.taiga.recipes.SmeltingRegistry;
import com.sosnitzka.taiga.util.FuelHandler;
import com.sosnitzka.taiga.world.ZWorldGen;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.commons.lang3.StringUtils;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;

import java.lang.reflect.Field;
import java.util.List;

import static com.sosnitzka.taiga.Fluids.*;
import static com.sosnitzka.taiga.MaterialTraits.*;
import static com.sosnitzka.taiga.MaterialTraits.material_titanite;
import static com.sosnitzka.taiga.TAIGAConfiguration.*;
import static slimeknights.tconstruct.library.utils.HarvestLevels.*;

@Mod(modid = TAIGA.MODID, version = TAIGA.VERSION, guiFactory = TAIGA.GUIFACTORY, dependencies = "required-after:tconstruct@[1.10-2.3.3,);" + "required-after:mantle@[1.10-0.10.3,)")
public class TAIGA {

    public static final String MODID = "taiga";
    public static final String VERSION = "${version}";
    public static final String GUIFACTORY = "com.sosnitzka.taiga.TAIGAGuiFactory";

    @SidedProxy(clientSide = "com.sosnitzka.taiga.proxy.ClientProxy", serverSide = "com.sosnitzka.taiga.proxy.CommonProxy")
    public static CommonProxy proxy;

    private List<MaterialIntegration> integrateList = Lists.newArrayList(); // List of materials needed to be integrated

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        proxy.initConfig();

        Items.register(); // Registers items and its oreDict
        Blocks.register(); // Registers blocks and its items form a long with its oreDict
        Fluids.register(); // Registers all fluids and its buckets
        Fluids.registerfromItem(); // Registers some special smeltery recipes (not alloying)
        Alloys.register(); // Registers alloying recipes

        registerTinkerMaterials(); // Registers materials and associated fluids and stats into tconstruct
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.registerModels(); // Registers models on the client side
        GameRegistry.registerWorldGenerator(new ZWorldGen(), 100); // Generates ores
        GameRegistry.registerFuelHandler(new FuelHandler()); // Registeres fuels' burn times
        SmeltingRegistry.register(); // Registers smelting recipes
        CraftingRegistry.register(); // Registers crafting recipes

        // Adds new harvest levels' names
        harvestLevelNames.put(ETERNITE, material_eternite.getTextColor() + "Eternite");
        harvestLevelNames.put(TITANITE, material_titanite.getTextColor() + "Titanite");
        harvestLevelNames.put(KARMESINE, material_karmesine.getTextColor() + "Karmesine");
        harvestLevelNames.put(PALLADIUM, material_palladium.getTextColor() + "Palladium");
        harvestLevelNames.put(VIBRANIUM, material_vibranium.getTextColor() + "Vibranium");

        for (MaterialIntegration m : integrateList) {
            m.integrateRecipes();
        }
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {

    }

    /**
     * @param oreSuffix  Suffix in the oreDict, also the name. ex) the "Iron" in "ingotIron"
     * @param material   TConstruct material
     * @param fluid      material's fluid
     * @param headDura   Durability (head)
     * @param headSpeed  Mining speed (head)
     * @param headAttack Attack speed (head)
     * @param handleMod  Durability multiplier (handle)
     * @param handleDura Extra durability (handle)
     * @param extra      Extra durability (binding and more)
     * @param headLevel  Mining level (head)
     * @param craft      Can craft parts in part builder
     * @param cast       Can craft parts by casting with fluid (smeltery)
     */
    private void registerTinkerMaterial(String oreSuffix, Material material, Fluid fluid, int headDura, float headSpeed, float headAttack, float handleMod, int handleDura, int extra, int headLevel, boolean craft, boolean cast) {
        TinkerRegistry.addMaterialStats(material, new HeadMaterialStats(headDura, headSpeed, headAttack, headLevel));
        TinkerRegistry.addMaterialStats(material, new HandleMaterialStats(handleMod, handleDura));
        TinkerRegistry.addMaterialStats(material, new ExtraMaterialStats(extra));

        Item item = null;
        Field[] items = Items.class.getDeclaredFields();
        for (Field i : items) {
            if (i.getName().equals(StringUtils.uncapitalize(oreSuffix) + "Ingot")) {
                Item r = null;
                try {
                    r = (Item) i.get(i.getType());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                item = r;
            }
        }
        material.setFluid(fluid).setCraftable(craft).setCastable(cast).addItem(item, 1, Material.VALUE_Ingot);
        material.setRepresentativeItem(item);

        proxy.setRenderInfo(material);
        MaterialIntegration integration = new MaterialIntegration(material, fluid, oreSuffix);
        integration.integrate();
        integrateList.add(integration);
    }


    /**
     * Registers materials and associated fluids and stats into tconstruct
     */
    private void registerTinkerMaterials() {

        double d = durabilityFactorGeneral;
        System.out.println("DURABILITY FACTOR" + d);
        float s = (float) speedFactorGeneral;
        System.out.println("SPEED FACTOR" + s);
        float a = (float) attackFactorGeneral;
        System.out.println("ATTACK FACTOR" + a);

        // ARCANE ORES
        registerTinkerMaterial("Tiberium", material_tiberium, molten_tiberium, (int) (223 * d), 6.2f * s, 8.35f * a, 0.63f, 50, 50, COBALT, false, true);
        registerTinkerMaterial("Aurodium", material_aurodium, molten_aurodium, (int) (351 * d), 5.15f * s, 7.00f * a, 1.05f, -100, 250, ETERNITE, false, true);
        registerTinkerMaterial("Prometheum", material_prometheum, molten_prometheum, (int) (539 * d), 3.6f * s, 6.60f, 0.90f, 0, 150, TITANITE, false, true);
        registerTinkerMaterial("Arcanite", material_arcanite, molten_arcanite, (int) (698 * d), 4.3f * s, 7.88f * a, 0.85f, -50, 150, KARMESINE, false, true);
        // SOLIDE ORES
        registerTinkerMaterial("Titanite", material_titanite, molten_titanite, (int) (811 * d), 4.8f * s, 6.40f * a, 1.00f, -50, 150, TITANITE, false, true);
        registerTinkerMaterial("Mythril", material_mythril, molten_mythril, (int) (552 * d), 8.75f * s, 2.87f * a, 0.98f, -100, 200, KARMESINE, false, true);
        registerTinkerMaterial("Uru", material_uru, molten_uru, (int) (823 * d), 6.1f * s, 6.83f * a, 1.20f, -50, 200, PALLADIUM, false, true);
        registerTinkerMaterial("Vibranium", material_vibranium, molten_vibranium, (int) (917 * d), 7.45f * s, 7.17f * a, 1.15f, 50, 150, VIBRANIUM, false, true);
        // ETHERE ORES
        registerTinkerMaterial("Eternite", material_eternite, molten_eternite, (int) (592 * d), 7.35f * s, 1.95f * a, 1.10f, 150, 150, ETERNITE, false, true);
        registerTinkerMaterial("Fractoryte", material_fractoryte, molten_fractoryte, (int) (1071 * d), 7.65f * s, 7.75f * a, 1.15f, -250, 283, TITANITE, false, true);
        registerTinkerMaterial("Palladium", material_palladium, molten_palladium, (int) (578 * d), 10.4f * s, 3.13f * a, 1.09f, 0, 100, PALLADIUM, false, true);
        registerTinkerMaterial("Ignitite", material_ignitite, molten_ignitite, (int) (673 * d), 12.1f * s, 4.10f * a, 1.15f, -50, 150, VIBRANIUM, false, true);
        // RATIO ORES
        registerTinkerMaterial("Bismuth", material_bismuth, molten_bismuth, (int) (235 * d), 5.33f * s, 3.80f * a, 1.15f, 17, 117, COBALT, false, true);
        registerTinkerMaterial("Jauxite", material_jauxite, molten_jauxite, (int) (458 * d), 6.41f * s, 4.40f * a, 0.90f, 83, 100, ETERNITE, false, true);
        registerTinkerMaterial("Violium", material_violium, molten_violum, (int) (427 * d), 4.2f * s, 3.30f * a, 1.00f, 133, 150, TITANITE, false, true);
        registerTinkerMaterial("Karmesine", material_karmesine, molten_karmesine, (int) (627 * d), 6.75f * s, 5.10f * a, 0.99f, 0, 200, KARMESINE, false, true);
        // Material from alloys


        registerTinkerMaterial("Dyonite", material_dyonite, molten_dyonite, (int) (733 * d), 6.14f * s, 7.69f * a, 0.97f, -15, 140, KARMESINE, false, true);
        registerTinkerMaterial("Cryptogen", material_cryptogen, molten_cryptogen, (int) (538 * d), 5.71f * s, 6.93f * a, 0.88f, 58, 117, KARMESINE, false, true);
        registerTinkerMaterial("Proxideum", material_proxideum, molten_proxideum, (int) (597 * d), 10.55f * s, 4.21f * a, 0.99f, -60, 200, KARMESINE, false, true);
        registerTinkerMaterial("Necrodermite", material_necrodermite, molten_necrodermite, (int) (355 * d), 8.88f * s, 3.18f * a, 1.00f, 175, 125, KARMESINE, false, true);
        registerTinkerMaterial("Noctune", material_noctune, molten_noctune, (int) (713 * d), 10.43f * s, 3.25f * a, 0.99f, -125, 183, KARMESINE, false, true);
        registerTinkerMaterial("Terramite", material_terramite, molten_terramite, (int) (482 * d), 7.25f * s, 2.85f * a, 1.03f, 208, 150, KARMESINE, false, true);
        registerTinkerMaterial("Niobine", material_niobine, molten_niobine, (int) (981 * d), 8.9f * s, 9.11f * a, 1.20f, -200, 300, KARMESINE, false, true);
        registerTinkerMaterial("Imperomite", material_imperomite, molten_imperomite, (int) (770 * d), 11.60f * s, 3.57f * a, 1.05f, -38, 125, KARMESINE, false, true);
        registerTinkerMaterial("Dysprosanium", material_dysprosanium, molten_dysprosanium, (int) (770 * d), 11.60f * s, 3.57f * a, 1.05f, -38, 125, KARMESINE, false, true);
        registerTinkerMaterial("Solarium", material_solarium, molten_solarium, (int) (1020 * d), 13.78f * s, 4.64f * a, 1.15f, 0, 150, KARMESINE, false, true);
        registerTinkerMaterial("Nihilite", material_nihilite, molten_nihilite, (int) (1020 * d), 13.78f * s, 4.64f * a, 1.15f, 0, 150, KARMESINE, false, true);
        registerTinkerMaterial("Adamantite", material_adamantite, molten_adamantite, (int) (981 * d), 8.9f * s, 9.11f * a, 1.20f, -200, 300, KARMESINE, false, true);
        registerTinkerMaterial("Invalite", material_invalite, molten_invalite, (int) (981 * d), 8.9f * s, 9.11f * a, 1.20f, -200, 300, KARMESINE, false, true);
        registerTinkerMaterial("Bysmuid", material_bysmuid, molten_bysmuid, (int) (305 * d), 5.22f * s, 6.47f * a, 1.09f, -80, 197, KARMESINE, false, true);
        registerTinkerMaterial("Seismodium", material_seismodium, molten_seismodium, (int) (879 * d), 13.85f * s, 4.19f * a, 1.17f, -75, 169, KARMESINE, false, true);
        registerTinkerMaterial("Seismolite", material_seismolite, molten_seismolite, (int) (879 * d), 13.85f * s, 4.19f * a, 1.17f, -75, 169, KARMESINE, false, true);
        registerTinkerMaterial("Nucleum", material_nucleum, molten_nucleum, (int) (503 * d), 11.30f * s, 3.22f * a, 1.05f, 100, 125, KARMESINE, false, true);
        registerTinkerMaterial("Lumixyl", material_lumixyl, molten_lumixyl, (int) (357 * d), 4.64f * s, 5.92f * a, 1.05f, 15, 130, KARMESINE, false, true);
        registerTinkerMaterial("BlueNitronite", material_bluenitronite, molten_bluenitronite, (int) (745 * d), 6.74f * s, 8.74f * a, 0.85f, 75, 93, KARMESINE, false, true);
        registerTinkerMaterial("RedNitronite", material_rednitronite, molten_rednitronite, (int) (745 * d), 6.74f * s, 8.74f * a, 0.85f, 75, 93, KARMESINE, false, true);
        registerTinkerMaterial("Radiocite", material_radiocite, molten_radiocite, (int) (745 * d), 6.74f * s, 8.74f * a, 0.85f, 75, 93, KARMESINE, false, true);
        registerTinkerMaterial("Turbidium", material_turbidium, molten_turbidium, (int) (745 * d), 6.74f * s, 8.74f * a, 0.85f, 75, 93, KARMESINE, false, true);
        registerTinkerMaterial("Ultranite", material_ultranite, molten_ultranite, (int) (1016 * d), 5.72f * s, 6.76f * a, 1.02f, -120, 210, KARMESINE, false, true);
        registerTinkerMaterial("Astrium", material_astrium, molten_astrium, (int) (670 * d), 5.28f * s, 9.14f * a, 0.91f, -45, 170, KARMESINE, false, true);





    }
}