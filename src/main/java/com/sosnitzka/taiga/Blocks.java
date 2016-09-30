package com.sosnitzka.taiga;

import com.google.common.base.Joiner;
import com.sosnitzka.taiga.blocks.BlockLignite;
import com.sosnitzka.taiga.blocks.BlockMetal;
import com.sosnitzka.taiga.blocks.BlockOre;
import com.sosnitzka.taiga.blocks.BlockTiberium;
import com.sosnitzka.taiga.generic.BasicBlock;
import com.sosnitzka.taiga.generic.BasicBlockGround;
import com.sosnitzka.taiga.util.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Arrays;

import static com.sosnitzka.taiga.MaterialTraits.*;
import static com.sosnitzka.taiga.util.Utils.PREFIX_BLOCK;
import static com.sosnitzka.taiga.util.Utils.PREFIX_ORE;
import static slimeknights.tconstruct.library.utils.HarvestLevels.*;

public class Blocks {

    public static BlockOre blockOre;
    public static BlockMetal blockMetal;

    public static ItemStack oreTiberium;
    public static ItemStack oreAurodium;
    public static ItemStack orePrometheum;
    public static ItemStack oreArcanite;

    public static ItemStack blockTiberium;
    public static ItemStack blockAurodium;
    public static ItemStack blockPrometheum;
    public static ItemStack blockArcanite;



    /// /regular Ores / Blocks without extra abilites
    public static Block basalt = new BasicBlock("basalt", Material.ROCK, 45.0f, 35.0f, OBSIDIAN);
    public static Block rottenGround = new BasicBlockGround("rotten_ground", Material.GROUND, 2.0f, 2.0f, STONE);
    public static Block ligniteOre = new BlockLignite();
    // will be optional / config
    public static Block slagironOre = new BasicBlock("slagiron_ore", Material.ROCK, 3.0f, 5.0f, IRON);
    public static Block slaggoldOre = new BasicBlock("slaggold_ore", Material.ROCK, 3.0f, 5.0f, IRON);

    // Ores
    // Group: Arcane
    public static Block tiberiumOre = new BlockTiberium();
    public static Block aurodiumOre = new BasicBlock("aurodium_ore", Material.ROCK, 13.0f, 12f, TITANITE, PREFIX_ORE);
    public static Block prometheumOre = new BasicBlock("prometheum_ore", Material.ROCK, 35.0f, 12f, COBALT, 0.4f, PREFIX_ORE);
    public static Block arcaniteOre = new BasicBlock("arcanite_ore", Material.ROCK, 23.0f, 12f, TITANITE, PREFIX_ORE);
    // Group: Solide
    public static Block titaniteOre = new BasicBlock("titanite_ore", Material.ROCK, 55.0f, 40f, TITANITE, PREFIX_ORE);
    public static Block mythrilOre = new BasicBlock("mytrhil_ore", Material.ROCK, 80.0f, 70f, VIBRANIUM, PREFIX_ORE);
    public static Block uruOre = new BasicBlock("uru_ore", Material.ROCK, 60.0f, 50f, TITANITE, PREFIX_ORE);
    public static Block vibraniumOre = new BasicBlock("vibranium_ore", Material.ROCK, 70.0f, 60f, VIBRANIUM, PREFIX_ORE);
    // Group: Etheri
    public static Block eterniteOre = new BasicBlock("eternite_ore", Material.ROCK, 24.0f, 15f, COBALT, PREFIX_ORE);
    public static Block fractoryteOre = new BasicBlock("fractoryte_ore", Material.ROCK, 25.0f, 15f, TITANITE, PREFIX_ORE);
    public static Block palladiumOre = new BasicBlock("palladium_ore", Material.ROCK, 25.0f, 15f, TITANITE, 0.4f, PREFIX_ORE);
    public static Block ignititeOre = new BasicBlock("ignitite_ore", Material.ROCK, 23.0f, 15f, VIBRANIUM, PREFIX_ORE);
    // Group: Ratio
    public static Block violiumOre = new BasicBlock("violium_ore", Material.ROCK, 13.0f, 10f, COBALT, PREFIX_ORE);
    public static Block bismuthOre = new BasicBlock("bismuth_ore", Material.ROCK, 8.0f, 5f, OBSIDIAN, PREFIX_ORE);
    public static Block mindoriteOre = new BasicBlock("mindorite_ore", Material.ROCK, 12.0f, 10f, TITANITE, PREFIX_ORE);
    public static Block karmesineOre = new BasicBlock("karmesine_ore", Material.ROCK, 13.0f, 10f, TITANITE, PREFIX_ORE);


    public static Block tiberiumBlock = new BasicBlock("tiberium_block", Material.ROCK, 30.0f, 15f, COBALT, 0.7f, PREFIX_BLOCK);
    public static Block aurodiumBlock = new BasicBlock("aurodium_block", Material.ROCK, 13.0f, 15f, ETERNITE, PREFIX_BLOCK);
    public static Block prometheumBlock = new BasicBlock("prometheum_block", Material.ROCK, 35.0f, 15f, TITANITE, 0.5f, PREFIX_BLOCK);
    public static Block arcaniteBlock = new BasicBlock("arcanite_block", Material.ROCK, 23.0f, 15f, KARMESINE, PREFIX_BLOCK);

    public static Block titaniteBlock = new BasicBlock("titanite_block", Material.ROCK, 55.0f, 50f, TITANITE, PREFIX_BLOCK);
    public static Block mythrilBlock = new BasicBlock("mythril_block", Material.ROCK, 70.0f, 70f, KARMESINE, PREFIX_BLOCK);
    public static Block uruBlock = new BasicBlock("uru_block", Material.ROCK, 60.0f, 60f, PALLADIUM, PREFIX_BLOCK);
    public static Block vibraniumBlock = new BasicBlock("vibranium_block", Material.ROCK, 80.0f, 80f, VIBRANIUM, PREFIX_BLOCK);

    public static Block eterniteBlock = new BasicBlock("eternite_block", Material.ROCK, 24.0f, 20f, ETERNITE, PREFIX_BLOCK);
    public static Block fractoryteBlock = new BasicBlock("fractoryte_block", Material.ROCK, 25.0f, 20f, TITANITE, PREFIX_BLOCK);
    public static Block palladiumBlock = new BasicBlock("palladium_block", Material.ROCK, 25.0f, 20f, PALLADIUM, 0.5f, PREFIX_BLOCK);
    public static Block ignititeBlock = new BasicBlock("ignitite_block", Material.ROCK, 23.0f, 20f, VIBRANIUM, PREFIX_BLOCK);

    public static Block bismuthBlock = new BasicBlock("bismuth_block", Material.ROCK, 13.0f, 12f, COBALT, PREFIX_BLOCK);
    public static Block jauxiteBlock = new BasicBlock("jauxite_block", Material.ROCK, 8.0f, 10f, ETERNITE, PREFIX_BLOCK);
    public static Block violiumBlock = new BasicBlock("violium_block", Material.ROCK, 12.0f, 12f, TITANITE, PREFIX_BLOCK);
    public static Block karmesineBlock = new BasicBlock("karmesine_block", Material.ROCK, 13.0f, 12f, KARMESINE, PREFIX_BLOCK);

    public static Block dyoniteBlock = new BasicBlock("dyonite_block", Material.ROCK, 13.0f, 12f, ETERNITE, PREFIX_BLOCK);
    public static Block cryptogenBlock = new BasicBlock("cryptogen_block", Material.ROCK, 13.0f, 12f, OBSIDIAN, PREFIX_BLOCK);
    public static Block proxideumBlock = new BasicBlock("proxideum_block", Material.ROCK, 13.0f, 12f, ETERNITE, PREFIX_BLOCK);
    public static Block necrodermiteBlock = new BasicBlock("necrodermite_block", Material.ROCK, 13.0f, 12f, TITANITE, PREFIX_BLOCK);
    public static Block noctuneBlock = new BasicBlock("noctune_block", Material.ROCK, 13.0f, 12f, KARMESINE, PREFIX_BLOCK);
    public static Block niobineBlock = new BasicBlock("niobine_block", Material.ROCK, 13.0f, 12f, TITANITE, PREFIX_BLOCK);
    public static Block terramiteBlock = new BasicBlock("terramite_block", Material.ROCK, 13.0f, 12f, ETERNITE, PREFIX_BLOCK);
    public static Block imperomiteBlock = new BasicBlock("imperomite_block", Material.ROCK, 13.0f, 12f, PALLADIUM, PREFIX_BLOCK);
    public static Block dysprosaniumBlock = new BasicBlock("dysprosanium_block", Material.ROCK, 13.0f, 12f, TITANITE, PREFIX_BLOCK);
    public static Block solariumBlock = new BasicBlock("solarium_block", Material.ROCK, 13.0f, 12f, VIBRANIUM, PREFIX_BLOCK);
    public static Block nihiliteBlock = new BasicBlock("nihilite_block", Material.ROCK, 13.0f, 12f, KARMESINE, PREFIX_BLOCK);
    public static Block adamantiteBlock = new BasicBlock("adamantite_block", Material.ROCK, 13.0f, 12f, VIBRANIUM, PREFIX_BLOCK);
    public static Block invaliteBlock = new BasicBlock("invalite_block", Material.ROCK, 13.0f, 12f, KARMESINE, PREFIX_BLOCK);
    public static Block bysmuidBlock = new BasicBlock("bysmuid_block", Material.ROCK, 13.0f, 12f, ETERNITE, PREFIX_BLOCK);
    public static Block seismodiumBlock = new BasicBlock("seismodium_block", Material.ROCK, 13.0f, 12f, KARMESINE, PREFIX_BLOCK);
    public static Block seismoliteBlock = new BasicBlock("seismolite_block", Material.ROCK, 13.0f, 12f, ETERNITE, PREFIX_BLOCK);
    public static Block nucleumBlock = new BasicBlock("nucleum_block", Material.ROCK, 13.0f, 12f, PALLADIUM, PREFIX_BLOCK);
    public static Block lumixylBlock = new BasicBlock("lumixyl_block", Material.ROCK, 13.0f, 12f, PALLADIUM, PREFIX_BLOCK);
    public static Block bluenitroniteBlock = new BasicBlock("bluenitronite_block", Material.ROCK, 13.0f, 12f, COBALT, PREFIX_BLOCK);
    public static Block rednitroniteBlock = new BasicBlock("rednitronite_block", Material.ROCK, 13.0f, 12f, COBALT, PREFIX_BLOCK);
    public static Block radiociteBlock = new BasicBlock("radiocite_block", Material.ROCK, 13.0f, 12f, TITANITE, PREFIX_BLOCK);
    public static Block turbidiumBlock = new BasicBlock("turbidium_block", Material.ROCK, 13.0f, 12f, COBALT, PREFIX_BLOCK);
    public static Block ultraniteBlock = new BasicBlock("ultranite_block", Material.ROCK, 13.0f, 12f, TITANITE, PREFIX_BLOCK);
    public static Block astriumBlock = new BasicBlock("astrium_block", Material.ROCK, 13.0f, 12f, KARMESINE, PREFIX_BLOCK);


    public static void preInit() {
        oreTiberium = new ItemStack(blockOre, 1, BlockOre.OreTypes.TIBERIUM.getMeta());
        oreAurodium = new ItemStack(blockOre, 1, BlockOre.OreTypes.AURODIUM.getMeta());
        orePrometheum = new ItemStack(blockOre, 1, BlockOre.OreTypes.PROMETHEUM.getMeta());
        oreArcanite = new ItemStack(blockOre, 1, BlockOre.OreTypes.ARCANITE.getMeta());

        blockTiberium = new ItemStack(blockMetal, 1, BlockMetal.MetalTypes.TIBERIUM.getMeta());
        blockAurodium = new ItemStack(blockMetal, 1, BlockMetal.MetalTypes.AURODIUM.getMeta());
        blockPrometheum = new ItemStack(blockMetal, 1, BlockMetal.MetalTypes.PROMETHEUM.getMeta());
        blockArcanite = new ItemStack(blockMetal, 1, BlockMetal.MetalTypes.ARCANITE.getMeta());

    }

    /**
     * Registers all materials' ingots and nuggets <br>
     * Detailed summary: <br>
     * Gets the ingots declared in the class (fields and reflection) and iterates through them: <br>
     * Checks that the field is static, registers the field (item), and adds an oreDict entry if needed
     */
    public static void register() {
        Field[] declaredFields = Blocks.class.getDeclaredFields(); // Gets the fields (ingots) declared above
        for (Field field : declaredFields) { // Iterates through the fields declared above
            if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) { // Checks that the fields are static
                Class<?> targetType = field.getType();
                try {
                    Block block = (Block) field.get(targetType); // Gets the field as a BasicBlock which is then casted to an Block
                    block.setCreativeTab(CreativeTab.tabTaigaBlock);
                    Utils.registerBlockWithItem(block); // Registers block and its item
                    if (block instanceof BasicBlock) { // Checks that the block is a BasicBlock
                        if (((BasicBlock) block).isOreDict()) { // Checks that the block has an oreDict entry
                            String oreDictName;
                            String[] nameParts = block.getUnlocalizedName().replace("tile.", "").split("_");

                            if (nameParts.length > 2) {
                                oreDictName = Joiner.on("_").join(Arrays.copyOfRange(nameParts, 0, nameParts.length - 1));
                            } else {
                                oreDictName = nameParts[0];
                            }
                            OreDictionary.registerOre(((BasicBlock) block).getOreDictPrefix() + StringUtils.capitalize(oreDictName), block); // Registers the block's oreDict
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
