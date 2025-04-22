package net.eskimo.voiditemod.Block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class ModTallGrassBlock extends TallGrassBlock {
    private final Supplier<Block> block;
    public ModTallGrassBlock(Properties properties, Supplier<Block> block) {
        super(properties);
        this.block = block;
    }


    @Override
    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return pState.is(block.get());
    }
}
