package net.eskimo.endmod.datagen;

import net.eskimo.endmod.Block.ModBlocks;
import net.eskimo.endmod.items.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.END_SLUDGE.get());
        dropSelf(ModBlocks.END_SLUDGE_BRICKS.get());
        dropSelf(ModBlocks.PACKED_END_SLUDGE.get());
        dropSelf(ModBlocks.END_SLUDGE_BRICKS_WALL.get());
        dropSelf(ModBlocks.PACKED_END_SLUDGE_WALL.get());
        dropSelf(ModBlocks.END_STONE_BRICK_PILLAR.get());
        dropSelf(ModBlocks.CHISELED_END_STONE_BRICK_PILLAR.get());
        dropSelf(ModBlocks.PURPUR_LIGHT.get());
        dropSelf(ModBlocks.BLOCK_OF_VOIDITE.get());

        this.add(ModBlocks.VOID_GRASS.get(),
                createShearsOnlyDrop(ModBlocks.VOID_GRASS.get()));

        this.add(ModBlocks.CHORUS_TURF.get(),
                createSilkTouchOnlyTable(ModBlocks.CHORUS_TURF.get()));


        //ores
        this.add(ModBlocks.BLOCK_OF_SMILE.get(),
              block -> createOreDrop(ModBlocks.BLOCK_OF_SMILE.get(), ModItems.SMILE.get()));
        this.add(ModBlocks.VOIDITE_ORE.get(),
              block -> createOreDrop(ModBlocks.VOIDITE_ORE.get(), ModItems.RAW_VOIDITE.get()));

        dropSelf(ModBlocks.END_SLUDGE_BRICKS_STAIRS.get());
        this.add(ModBlocks.END_SLUDGE_BRICKS_SLAB.get(),
                 block -> createSlabItemTable(ModBlocks.END_SLUDGE_BRICKS_SLAB.get()));

        dropSelf(ModBlocks.PACKED_END_SLUDGE_STAIRS.get());
        this.add(ModBlocks.PACKED_END_SLUDGE_SLAB.get(),
                 block -> createSlabItemTable(ModBlocks.PACKED_END_SLUDGE_SLAB.get()));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
