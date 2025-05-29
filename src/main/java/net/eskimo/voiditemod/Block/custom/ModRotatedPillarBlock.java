package net.eskimo.voiditemod.Block.custom;

import net.eskimo.voiditemod.Block.ModBlocks;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

public class ModRotatedPillarBlock extends RotatedPillarBlock {
    public ModRotatedPillarBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if (context.getItemInHand().getItem() instanceof AxeItem) {
            if (state.is(ModBlocks.SUNCROWN_OAK_LOG.get())) {
                return ModBlocks.STRIPPED_SUNCROWN_OAK_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }

        if (state.is(ModBlocks.SUNCROWN_OAK_WOOD.get())) {
                return ModBlocks.STRIPPED_SUNCROWN_OAK_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }


        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
