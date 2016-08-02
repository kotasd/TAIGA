package com.sosnitzka.taiga;


import com.sosnitzka.taiga.traits.*;
import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class MaterialTraits {

    // new hardness levels
    public static final int TITANITE = 5;
    public static final int METEORITE = 6;
    public static final int VIBRANIUM = 7;
    public static final int ADAMANTITE = 8;

    // Init of new traits
    public static final AbstractTrait instable = new TraitInstable();
    public static final AbstractTrait naturebound = new TraitNatureBound();
    public static final AbstractTrait uncertain = new TraitUncertain();
    public static final AbstractTrait softy = new TraitSofty();
    public static final AbstractTrait curvature = new TraitCurvature();
    public static final AbstractTrait resonance = new TraitResonance();
    public static final AbstractTrait fracture = new TraitFracture();
    public static final AbstractTrait glimmer = new TraitGlimmer();
    public static final AbstractTrait garishly = new TraitGarishly();
    public static final AbstractTrait pulverizing = new TraitPulverizing();
    public static final AbstractTrait analysing = new TraitAnalysing();
    public static final AbstractTrait cascade = new TraitCascade();
    public static final AbstractTrait blind = new TraitBlind();
    public static final AbstractTrait dark = new TraitDark();
    public static final AbstractTrait bright = new TraitBright();
    public static final AbstractTrait slaughtering = new TraitSlaughtering();
    public static final AbstractTrait haunted = new TraitHaunted();
    public static final AbstractTrait fragile = new TraitFragile();
    public static final AbstractTrait dissolving = new TraitDissolving();
    public static final AbstractTrait organizing = new TraitOrganizing();
    public static final AbstractTrait arcane = new TraitArcane();
    public static final AbstractTrait heroic = new TraitHeroic();
    public static final AbstractTrait hollow = new TraitHollow();
    public static final AbstractTrait diffuse = new TraitDiffuse();
    public static final AbstractTrait randomize = new TraitRandomize();
    public static final AbstractTrait reviving = new TraitReviving();
    public static final AbstractTrait melting = new TraitMelting();
    public static final AbstractTrait traditional = new TraitTraditional();
    public static final AbstractTrait tantrum = new TraitTantrum();
    public static final AbstractTrait catcher = new TraitCatcher();
    public static final AbstractTrait congenial = new TraitCongenial();
    public static final AbstractTrait souleater = new TraitSoulEater();

    /**
     * Assign traits to related materials. <br>
     * <p>
     * <p> Example:
     * .addTrait(x, HandleMaterialStats.TYPE).addTrait(y, HeadMaterialStats.TYPE)
     * .addTrait(z)
     */

    public static Material arcanite = new Material("arcanite", TextFormatting.LIGHT_PURPLE).addTrait(souleater);
    public static Material tiberium = new Material("tiberium", TextFormatting.GREEN);
    public static Material prometheum = new Material("prometheum", TextFormatting.DARK_PURPLE);
    public static Material rubium = new Material("rubium", TextFormatting.RED);
    public static Material violium = new Material("violium", TextFormatting.DARK_GREEN);
    public static Material bismuth = new Material("bismuth", TextFormatting.GREEN);
    public static Material karmesine = new Material("karmesine", TextFormatting.DARK_RED);
    public static Material mindorite = new Material("mindorite", TextFormatting.AQUA);
    public static Material titanite = new Material("titanite", TextFormatting.GRAY);
    public static Material meteorite = new Material("meteorite", TextFormatting.GRAY);
    public static Material adamantite = new Material("adamantite", TextFormatting.GRAY);
    public static Material vibranium = new Material("vibranium", TextFormatting.GRAY);
    public static Material ignitite = new Material("ignitite", TextFormatting.RED);
    public static Material palladium = new Material("palladium", TextFormatting.DARK_GRAY);
    public static Material eternite = new Material("eternite", TextFormatting.AQUA);
    public static Material mythril = new Material("mythril", TextFormatting.GRAY);
    public static Material imperomite = new Material("imperomite", TextFormatting.DARK_RED);
    public static Material fractoryte = new Material("fractoryte", TextFormatting.DARK_RED);
    public static Material noctunyx = new Material("noctunyx", TextFormatting.LIGHT_PURPLE);
    public static Material nitronite = new Material("nitronite", TextFormatting.YELLOW);
    public static Material cryptogen = new Material("cryptogen", TextFormatting.DARK_GREEN);
    public static Material seismodium = new Material("seismodium", TextFormatting.WHITE);
    public static Material aegisalt = new Material("aegisalt", TextFormatting.AQUA);
    public static Material ultranite = new Material("ultranite", TextFormatting.AQUA);
    public static Material bysmuid = new Material("bysmuid", TextFormatting.AQUA);
    public static Material nucleum = new Material("nucleum", TextFormatting.AQUA);
    public static Material lumixyl = new Material("lumixyl", TextFormatting.YELLOW);
    public static Material dyonite = new Material("dyonite", TextFormatting.GRAY);
    public static Material terramite = new Material("terramite", TextFormatting.GRAY);
    public static Material solarium = new Material("solarium", TextFormatting.RED);
    public static Material astrium = new Material("astrium", TextFormatting.DARK_PURPLE);
    public static Material proxideum = new Material("proxideum", TextFormatting.LIGHT_PURPLE);
}
