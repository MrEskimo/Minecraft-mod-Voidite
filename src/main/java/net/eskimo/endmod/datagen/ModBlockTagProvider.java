package net.eskimo.endmod.datagen;

import net.eskimo.endmod.Block.ModBlocks;
import net.eskimo.endmod.EndMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, EndMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.END_SLUDGE_BRICKS.get())
                .add(ModBlocks.BLOCK_OF_SMILE.get())
                .add(ModBlocks.END_SLUDGE_BRICKS_STAIRS.get())
                .add(ModBlocks.END_SLUDGE_BRICKS_SLAB.get())
                .add(ModBlocks.PACKED_END_SLUDGE_SLAB.get())
                .add(ModBlocks.PACKED_END_SLUDGE_STAIRS.get())
                .add(ModBlocks.PACKED_END_SLUDGE_WALL.get())
                .add(ModBlocks.PACKED_END_SLUDGE.get())
                .add(ModBlocks.END_STONE_BRICK_PILLAR.get())
                .add(ModBlocks.CHISELED_END_STONE_BRICK_PILLAR.get());

        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.END_SLUDGE.get())
                .add(ModBlocks.CHORUS_TURF.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.END_SLUDGE_BRICKS.get())
                .add(ModBlocks.END_SLUDGE.get())
                .add(ModBlocks.END_SLUDGE_BRICKS_STAIRS.get())
                .add(ModBlocks.END_SLUDGE_BRICKS_SLAB.get())
                .add(ModBlocks.END_SLUDGE_BRICKS_WALL.get())
                .add(ModBlocks.PACKED_END_SLUDGE.get())
                .add(ModBlocks.PACKED_END_SLUDGE_WALL.get())
                .add(ModBlocks.PACKED_END_SLUDGE_SLAB.get())
                .add(ModBlocks.END_STONE_BRICK_PILLAR.get())
                .add(ModBlocks.CHORUS_TURF.get())
                .add(ModBlocks.CHISELED_END_STONE_BRICK_PILLAR.get())
                .add(ModBlocks.PACKED_END_SLUDGE_STAIRS.get());

        tag(BlockTags.WALLS)
                .add(ModBlocks.END_SLUDGE_BRICKS_WALL.get())
                .add(ModBlocks.PACKED_END_SLUDGE_WALL.get());

    }
}
