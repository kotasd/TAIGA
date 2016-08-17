package com.sosnitzka.taiga;


import com.sosnitzka.taiga.traits.*;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class MaterialTraits {

    // new hardness levels
    public static final int ETERNITE = 5;
    public static final int TITANITE = 6;
    public static final int KARMESINE = 7;
    public static final int PALLADIUM = 8;
    public static final int VIBRANIUM = 9;

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

    public static Material materialTiberium = new Material("tiberium", 0xff7ac14d);
    public static Material materialAurodium = new Material("aurodium", 0xffff7c7c);
    public static Material materialPrometheum = new Material("prometheum", 0xff29304a);
    public static Material materialArcanite = new Material("arcanite", 0xff8e3e84);

    public static Material materialTitanite = new Material("titanite", 0xffefefef);
    public static Material materialMythril = new Material("mythril", 0xffd1eed3);
    public static Material materialUru = new Material("uru", 0xff303030);
    public static Material materialVibranium = new Material("vibranium", 0xffc8e3f3);

    public static Material materialEternite = new Material("eternite", 0xffded9a3);
    public static Material materialFractoryte = new Material("fractoryte", 0xff752d2d);
    public static Material materialPalladium = new Material("palladium", 0xfff89708);
    public static Material materialIgnitite = new Material("ignitite", 0xffbf1616);

    public static Material materialBismuth = new Material("bismuth", 0xffbfbfbf);
    public static Material materialJauxite = new Material("jauxite", 0xff74d8ff);
    public static Material materialViolium = new Material("violium", 0xff8781ee);
    public static Material materialKarmesine = new Material("karmesine", 0xffff2e2e);

    public static Material materialDyonite = new Material("dyonite", 0xFFFFFFFF);
    public static Material materialCryptogen = new Material("cryptogen", 0xffFFFFFF);
    public static Material materialProxideum = new Material("proxideum", 0xffFFFFFF);
    public static Material materialNecrodermite = new Material("necrodermite", 0xffFFFFFF);
    public static Material materialNoctune = new Material("noctune", 0xffFFFFFF);
    public static Material materialTerramite = new Material("terramite", 0xffFFFFFF);
    public static Material materialNiobine = new Material("niobine", 0xffFFFFFF);
    public static Material materialImperomite = new Material("imperomite", 0xffFFFFFF);
    public static Material materialDysprosanium = new Material("dysprosanium", 0xffFFFFFF);
    public static Material materialSolarium = new Material("solarium", 0xffFFFFFF);
    public static Material materialNihilite = new Material("nihilite", 0xffFFFFFF);
    public static Material materialAdamantite = new Material("adamantite", 0xffFFFFFF);
    public static Material materialInvalite = new Material("invalite", 0xffFFFFFF);
    public static Material materialBysmuid = new Material("bysmudid", 0xffFFFFFF);
    public static Material materialSeismodium = new Material("seismodium", 0xffFFFFFF);
    public static Material materialSeismolite = new Material("seismolite", 0xffFFFFFF);
    public static Material materialNucleum = new Material("nucleum", 0xffFFFFFF);
    public static Material materialLumixyl = new Material("lumixyl", 0xffFFFFFF);
    public static Material materialBluenitronite = new Material("bluenitronite", 0xffFFFFFF);
    public static Material materialRednitronite = new Material("rednitronite", 0xffFFFFFF);
    public static Material materialRadiocite = new Material("radiocite", 0xffFFFFFF);
    public static Material materialTurbidium = new Material("turbidium", 0xffFFFFFF);
    public static Material materialUltranite = new Material("ultranite", 0xffFFFFFF);
    public static Material materialAstrium = new Material("astrium", 0xffFFFFFF);


}
