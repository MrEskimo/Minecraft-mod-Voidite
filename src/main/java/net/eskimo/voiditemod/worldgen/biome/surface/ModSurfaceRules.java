package net.eskimo.voiditemod.worldgen.biome.surface;

import net.eskimo.voiditemod.Block.ModBlocks;
import net.eskimo.voiditemod.worldgen.biome.ModBiomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class ModSurfaceRules {
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource VOIDITE = makeStateRule(ModBlocks.BLOCK_OF_VOIDITE.get());
    private static final SurfaceRules.RuleSource RAW_VOIDITE = makeStateRule(ModBlocks.VOIDITE_ORE.get());
    private static final SurfaceRules.RuleSource CHORUS_TURF = makeStateRule(ModBlocks.CHORUS_TURF.get());
    private static final SurfaceRules.RuleSource END_STONE = makeStateRule(Blocks.END_STONE);


    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);

        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        return SurfaceRules.sequence(
                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.CHORUS_PLAINS),
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, CHORUS_TURF)),
                        SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, END_STONE)),


                // Default to a end stone surface
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, END_STONE)
        );

      // return SurfaceRules.sequence(
      //         SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.TEST_BIOME),
      //                         SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, RAW_VOIDITE)),
      //                 SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, VOIDITE)),


      //         // Default to a grass and dirt surface
      //         SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, grassSurface)
      // );
    }


    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}