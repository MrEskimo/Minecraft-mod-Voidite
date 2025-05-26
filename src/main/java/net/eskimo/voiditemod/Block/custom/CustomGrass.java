package net.eskimo.voiditemod.Block.custom;

import net.eskimo.voiditemod.Block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.IPlantable;

public class CustomGrass extends GrassBlock {
    public CustomGrass(Properties properties) {
        super(properties);
    }
        //List<ItemLike> CHORUS_TURF_GROWABLE = List.of(ModBlocks.VOID_GRASS.get(),
        //        ModBlocks.GLOWING_VOID_BERRY_BUSH.get());

    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
        BlockState plant = plantable.getPlant(world, pos.relative(facing));
        if (plant.getBlock() == ModBlocks.GLOWING_VOID_BERRY_BUSH.get())
            return state.is(ModBlocks.CHORUS_TURF.get());
        if (plant.getBlock() == ModBlocks.VOID_GRASS.get())
            return state.is(ModBlocks.CHORUS_TURF.get());
        if (plant.getBlock() == Blocks.TORCHFLOWER)
            return state.is(ModBlocks.CHORUS_TURF.get());
        if (plant.getBlock() == ModBlocks.SINCEHE_POTATO_CROP.get())
            return state.is(ModBlocks.CHORUS_TURF.get());
        if (plant.getBlock() == Blocks.CHORUS_PLANT)
            return state.is(ModBlocks.CHORUS_TURF.get());
        if (plant.getBlock() == Blocks.CHORUS_FLOWER)
            return state.is(ModBlocks.CHORUS_TURF.get());

        return false;
    }
}

