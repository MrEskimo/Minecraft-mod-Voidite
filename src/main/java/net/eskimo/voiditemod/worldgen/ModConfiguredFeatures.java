package net.eskimo.voiditemod.worldgen;

import net.eskimo.voiditemod.Block.ModBlocks;
import net.eskimo.voiditemod.VoiditeMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_VOIDITE_ORE_KEY = registerKey("end_voidite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> VOID_GRASS_PATCH_KEY = registerKey("void_grass_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOWING_VOID_BERRY_BUSH_KEY = registerKey("glowing_void_berry_bush");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_SLUDGE_DISK_KEY = registerKey("end_sludge_disk");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);


        register(context, END_VOIDITE_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables, ModBlocks.VOIDITE_ORE.get().defaultBlockState(), 6));

        register(context, VOID_GRASS_PATCH_KEY, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(ModBlocks.VOID_GRASS.get()), 32));


        register(context, GLOWING_VOID_BERRY_BUSH_KEY, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(
                        Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                                BlockStateProvider.simple(ModBlocks.GLOWING_VOID_BERRY_BUSH.get()
                                        .defaultBlockState().setValue(SweetBerryBushBlock.AGE, 3))
                        ), List.of(Blocks.GRASS_BLOCK, ModBlocks.CHORUS_TURF.get())));

        register(context, END_SLUDGE_DISK_KEY, Feature.DISK,
                new DiskConfiguration(
                        RuleBasedBlockStateProvider.simple(ModBlocks.END_SLUDGE.get()),
                        BlockPredicate.matchesBlocks(List.of(ModBlocks.CHORUS_TURF.get())),
                        UniformInt.of(2, 3),
                        1
                )
        );



    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(VoiditeMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

    private static RandomPatchConfiguration grassPatch(BlockStateProvider pStateProvider, int pTries) {
        return FeatureUtils.simpleRandomPatchConfiguration(pTries, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(pStateProvider)));
    }
}