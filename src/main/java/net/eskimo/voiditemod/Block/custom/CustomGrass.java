package net.eskimo.voiditemod.Block.custom;

import net.eskimo.voiditemod.Block.ModBlocks;
import net.eskimo.voiditemod.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LightEngine;
import net.minecraftforge.common.IPlantable;

import static net.eskimo.voiditemod.util.ModTags.Blocks.GROWS_ON_SUNCROWN_TURF;
import static net.eskimo.voiditemod.util.ModTags.Blocks.SUNCROWN_OAK_GROWS_ON;

public class CustomGrass extends GrassBlock {
    public CustomGrass(Properties properties) {
        super(properties);
    }
    //List<ItemLike> CHORUS_TURF_GROWABLE = List.of(ModBlocks.CHORUS_GRASS.get(),
    //        ModBlocks.GLOWING_VOID_BERRY_BUSH.get());

    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
        BlockState plant = plantable.getPlant(world, pos.relative(facing));
      if (plant.getBlock() == ModBlocks.GLOWING_VOID_BERRY_BUSH.get())
          return state.is(ModBlocks.SUNCROWN_TURF.get());
      if (plant.getBlock() == ModBlocks.SUNCROWN_GRASS.get())
          return state.is(ModBlocks.SUNCROWN_TURF.get());
      if (plant.getBlock() == Blocks.TORCHFLOWER)
          return state.is(ModBlocks.SUNCROWN_TURF.get());
      if (plant.getBlock() == ModBlocks.SINCEHE_POTATO_CROP.get())
          return state.is(ModBlocks.SUNCROWN_TURF.get());
      if (plant.getBlock() == Blocks.CHORUS_PLANT)
          return state.is(ModBlocks.SUNCROWN_TURF.get());
      if (plant.getBlock() == Blocks.CHORUS_FLOWER)
          return state.is(ModBlocks.SUNCROWN_TURF.get());
      if (plant.getBlock() == ModBlocks.SUNCROWN_OAK_SAPLING.get())
          return state.is(ModBlocks.SUNCROWN_TURF.get());

        return false;
    }

    private static boolean canBeGrass(BlockState pState, LevelReader pLevelReader, BlockPos pPos) {
        BlockPos blockpos = pPos.above();
        BlockState blockstate = pLevelReader.getBlockState(blockpos);
        if (blockstate.is(Blocks.SNOW) && blockstate.getValue(SnowLayerBlock.LAYERS) == 1) {
            return true;
        } else if (blockstate.getFluidState().getAmount() == 8) {
            return false;
        } else {
            int i = LightEngine.getLightBlockInto(pLevelReader, pState, pPos, blockstate, blockpos, Direction.UP, blockstate.getLightBlock(pLevelReader, blockpos));
            return i < pLevelReader.getMaxLightLevel();
        }
    }

    @Override
    protected void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (!canBeGrass(pState, pLevel, pPos)) {
            if (!pLevel.isAreaLoaded(pPos, 1))
                return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
            pLevel.setBlockAndUpdate(pPos, Blocks.END_STONE.defaultBlockState());
        }
    }
}

