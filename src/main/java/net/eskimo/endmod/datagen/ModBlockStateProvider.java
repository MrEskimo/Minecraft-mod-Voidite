package net.eskimo.endmod.datagen;

import net.eskimo.endmod.Block.ModBlocks;
import net.eskimo.endmod.EndMod;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, EndMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.BLOCK_OF_SMILE);
        blockWithItem(ModBlocks.AMOGUS);

        blockWithItem(ModBlocks.END_SLUDGE);
        blockWithItem(ModBlocks.END_SLUDGE_BRICKS);
        blockWithItem(ModBlocks.PACKED_END_SLUDGE);
        blockWithItem(ModBlocks.PURPUR_LIGHT);


        stairsBlock(ModBlocks.END_SLUDGE_BRICKS_STAIRS.get(), blockTexture(ModBlocks.END_SLUDGE_BRICKS.get()));
        wallBlock(ModBlocks.END_SLUDGE_BRICKS_WALL.get(), blockTexture(ModBlocks.END_SLUDGE_BRICKS.get()));
        slabBlock(ModBlocks.END_SLUDGE_BRICKS_SLAB.get(), blockTexture(ModBlocks.END_SLUDGE_BRICKS.get()), blockTexture(ModBlocks.END_SLUDGE_BRICKS.get()));

        blockItem(ModBlocks.END_SLUDGE_BRICKS_STAIRS);
        blockItem(ModBlocks.END_SLUDGE_BRICKS_SLAB);
        stairsBlock(ModBlocks.PACKED_END_SLUDGE_STAIRS.get(), blockTexture(ModBlocks.PACKED_END_SLUDGE.get()));
        wallBlock(ModBlocks.PACKED_END_SLUDGE_WALL.get(), blockTexture(ModBlocks.PACKED_END_SLUDGE.get()));
        slabBlock(ModBlocks.PACKED_END_SLUDGE_SLAB.get(), blockTexture(ModBlocks.PACKED_END_SLUDGE.get()), blockTexture(ModBlocks.PACKED_END_SLUDGE.get()));

        blockItem(ModBlocks.PACKED_END_SLUDGE_STAIRS);
        blockItem(ModBlocks.PACKED_END_SLUDGE_SLAB);

        simpleBlockWithItem(ModBlocks.CHORUS_TURF.get(), models().cubeBottomTop(
                "chorus_turf",
                modLoc("block/chorus_turf"),
                modLoc("block/chorus_turf_bottom"),
                modLoc("block/chorus_turf_top")
        ));

        simpleBlockWithItem(ModBlocks.VOID_GRASS.get(), models().cross(
                "void_grass",
                modLoc("block/void_grass")
        ));

        simpleBlockWithItem(ModBlocks.END_STONE_BRICK_PILLAR.get(), models().cubeColumn(
                "end_stone_brick_pillar",
                modLoc("block/end_stone_brick_pillar_side"),
                modLoc("block/end_stone_brick_pillar_end")
        ));

        simpleBlockWithItem(ModBlocks.CHISELED_END_STONE_BRICK_PILLAR.get(), models().cubeColumn(
                "chiseled_end_stone_brick_pillar",
                modLoc("block/chiseled_end_stone_brick_pillar"),
                modLoc("block/end_stone_brick_pillar_end")
        ));

    }


    private void blockWithItem(RegistryObject<Block>blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }


    private void blockItem(RegistryObject<? extends Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("endmod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("endmod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }

}
