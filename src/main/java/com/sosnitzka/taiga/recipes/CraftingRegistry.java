package com.sosnitzka.taiga.recipes;


import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

import static com.sosnitzka.taiga.Blocks.*;
import static com.sosnitzka.taiga.Items.*;
import static slimeknights.tconstruct.shared.TinkerCommons.matNecroticBone;

public class CraftingRegistry {
    public static void register() {
        GameRegistry.addShapelessRecipe(new ItemStack(fuelBrick), Items.COAL, Items.COAL, Items.COAL, lignite, lignite, lignite);

        GameRegistry.addShapelessRecipe(new ItemStack(luminarDust), Items.REDSTONE, Items.GLOWSTONE_DUST);
        GameRegistry.addShapelessRecipe(new ItemStack(glimmerstoneDust), luminarDust, Items.BLAZE_POWDER);
        GameRegistry.addShapelessRecipe(new ItemStack(glimmerstoneDust), Items.REDSTONE, Items.GLOWSTONE_DUST, Items.BLAZE_POWDER);

        GameRegistry.addShapelessRecipe(new ItemStack(glimmercoal), Items.COAL, glimmerstoneDust);
        GameRegistry.addShapelessRecipe(new ItemStack(glimmercoal), lignite, glimmerstoneDust);

        GameRegistry.addShapelessRecipe(new ItemStack(radiantPearl), Items.ENDER_PEARL, luminarDust, new ItemStack(Items.DYE, 1, 4));
        GameRegistry.addShapelessRecipe(new ItemStack(glimmerPearl), Items.ENDER_PEARL, glimmerstoneDust);
        GameRegistry.addShapelessRecipe(new ItemStack(energyPearl), Items.ENDER_PEARL, luminarDust, Items.GUNPOWDER);

        GameRegistry.addShapelessRecipe(new ItemStack(nitroBrick), fuelBrick, Items.GUNPOWDER, Items.BLAZE_POWDER);
        GameRegistry.addShapelessRecipe(new ItemStack(anthraciteDust), matNecroticBone, Items.COAL, Items.GUNPOWDER);
        GameRegistry.addShapelessRecipe(new ItemStack(spectrumDust), matNecroticBone, glimmerstoneDust);

        registerMetalRecipes(tiberiumIngot, tiberiumNugget, tiberiumBlock);
        registerMetalRecipes(aurodiumIngot, aurodiumNugget, aurodiumBlock);
        registerMetalRecipes(prometheumIngot, prometheumNugget, prometheumBlock);
        registerMetalRecipes(arcaniteIngot, arcaniteNugget, arcaniteBlock);
        registerMetalRecipes(titaniteIngot, titaniteNugget, titaniteBlock);
        registerMetalRecipes(mythrilIngot, mythrilNugget, mythrilBlock);
        registerMetalRecipes(uruIngot, uruNugget, uruBlock);
        registerMetalRecipes(vibraniumIngot, vibraniumNugget, vibraniumBlock);
        registerMetalRecipes(eterniteIngot, eterniteNugget, eterniteBlock);
        registerMetalRecipes(fractoryteIngot, fractoryteNugget, fractoryteBlock);
        registerMetalRecipes(palladiumIngot, palladiumNugget, palladiumBlock);
        registerMetalRecipes(ignititeIngot, ignititeNugget, ignititeBlock);
        registerMetalRecipes(bismuthIngot, bismuthNugget, bismuthBlock);
        registerMetalRecipes(jauxiteIngot, jauxiteNugget, jauxiteBlock);
        registerMetalRecipes(violiumIngot, violiumNugget, violiumBlock);
        registerMetalRecipes(karmesineIngot, karmesineNugget, karmesineBlock);
        registerMetalRecipes(dyoniteIngot, dyoniteNugget, dyoniteBlock);
        registerMetalRecipes(cryptogenIngot, cryptogenNugget, cryptogenBlock);
        registerMetalRecipes(proxideumIngot, proxideumNugget, proxideumBlock);
        registerMetalRecipes(necrodermiteIngot, necrodermiteNugget, necrodermiteBlock);
        registerMetalRecipes(noctuneIngot, noctuneNugget, noctuneBlock);
        registerMetalRecipes(niobineIngot, niobineNugget, niobineBlock);
        registerMetalRecipes(terramiteIngot, terramiteNugget, terramiteBlock);
        registerMetalRecipes(imperomiteIngot, imperomiteNugget, imperomiteBlock);
        registerMetalRecipes(dysprosaniumIngot, dysprosaniumNugget, dysprosaniumBlock);
        registerMetalRecipes(solariumIngot, solariumNugget, solariumBlock);
        registerMetalRecipes(nihiliteIngot, nihiliteNugget, nihiliteBlock);
        registerMetalRecipes(adamantiteIngot, adamantiteNugget, adamantiteBlock);
        registerMetalRecipes(invaliteIngot, invaliteNugget, invaliteBlock);
        registerMetalRecipes(bysmuidIngot, bysmuidNugget, bysmuidBlock);
        registerMetalRecipes(seismodiumIngot, seismodiumNugget, seismodiumBlock);
        registerMetalRecipes(seismoliteIngot, seismoliteNugget, seismoliteBlock);
        registerMetalRecipes(nucleumIngot, nucleumNugget, nucleumBlock);
        registerMetalRecipes(lumixylIngot, lumixylNugget, lumixylBlock);
        registerMetalRecipes(bluenitroniteIngot, bluenitroniteNugget, bluenitroniteBlock);
        registerMetalRecipes(rednitroniteIngot, rednitroniteNugget, rednitroniteBlock);
        registerMetalRecipes(radiociteIngot, radiociteNugget, radiociteBlock);
        registerMetalRecipes(turbidiumIngot, turbidiumNugget, turbidiumBlock);
        registerMetalRecipes(ultraniteIngot, ultraniteNugget, ultraniteBlock);
        registerMetalRecipes(astriumIngot, astriumNugget, astriumBlock);

    }


    private static void registerMetalRecipes(Item ingot, Item nugget, Block block) {

        GameRegistry.addShapelessRecipe(new ItemStack(nugget, 9), new ItemStack(ingot));
        GameRegistry.addShapelessRecipe(new ItemStack(ingot, 9), new ItemStack(block));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(block), "###", "###", "###", '#', new ItemStack(ingot)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ingot), "###", "###", "###", '#', new ItemStack(nugget)));
    }
}
