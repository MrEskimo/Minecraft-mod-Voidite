package net.eskimo.endmod.datagen;

import net.eskimo.endmod.Block.ModBlocks;
import net.eskimo.endmod.items.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
        protected void buildRecipes(RecipeOutput pRecipeOutput) {
            List<ItemLike> VOIDITE_SMELTABLES = List.of(ModItems.RAW_VOIDITE.get(),
                    ModBlocks.VOIDITE_ORE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLOCK_OF_SMILE.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.SMILE.get())
                .unlockedBy(getHasName(ModItems.SMILE.get()), has(ModItems.SMILE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_END_SLUDGE.get())
                .pattern("BA")
                .pattern("AB")
                .define('A', ModBlocks.END_SLUDGE.get())
                .define('B', Items.WHEAT)
                .unlockedBy(getHasName(ModBlocks.END_SLUDGE.get()), has(ModBlocks.END_SLUDGE.get())).save(pRecipeOutput);

        twoByTwoPacker(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.END_SLUDGE_BRICKS.get(), ModBlocks.PACKED_END_SLUDGE.get());

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SMILE.get(), 9)
                .requires(ModBlocks.BLOCK_OF_SMILE.get())
                .unlockedBy(getHasName(ModBlocks.BLOCK_OF_SMILE.get()), has(ModBlocks.BLOCK_OF_SMILE.get())).save(pRecipeOutput);

        stairBuilder(ModBlocks.END_SLUDGE_BRICKS_STAIRS.get(), Ingredient.of(ModBlocks.END_SLUDGE_BRICKS.get())).group("end_sludge_bricks")
                .unlockedBy(getHasName(ModBlocks.END_SLUDGE_BRICKS.get()), has(ModBlocks.END_SLUDGE_BRICKS.get())).save(pRecipeOutput);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.END_SLUDGE_BRICKS_SLAB.get(), ModBlocks.END_SLUDGE_BRICKS.get());
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.END_SLUDGE_BRICKS_WALL.get(), ModBlocks.END_SLUDGE_BRICKS.get());

        stairBuilder(ModBlocks.PACKED_END_SLUDGE_STAIRS.get(), Ingredient.of(ModBlocks.PACKED_END_SLUDGE.get())).group("packed_end_sludge")
                .unlockedBy(getHasName(ModBlocks.PACKED_END_SLUDGE.get()), has(ModBlocks.PACKED_END_SLUDGE.get())).save(pRecipeOutput);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_END_SLUDGE_SLAB.get(), ModBlocks.PACKED_END_SLUDGE.get());
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_END_SLUDGE_WALL.get(), ModBlocks.PACKED_END_SLUDGE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.END_STONE_BRICK_PILLAR.get())
                .pattern("   ")
                .pattern(" A ")
                .pattern(" A ")
                .define('A', Blocks.END_STONE_BRICK_SLAB)
                .unlockedBy(getHasName(Blocks.END_STONE_BRICK_SLAB), has(Blocks.END_STONE_BRICK_SLAB)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_END_STONE_BRICK_PILLAR.get())
               .pattern("BBB")
               .pattern("BAB")
               .pattern("BBB")
               .define('A', ModBlocks.END_STONE_BRICK_PILLAR.get())
               .define('B', Blocks.QUARTZ_PILLAR)
              .unlockedBy(getHasName(ModBlocks.END_STONE_BRICK_PILLAR.get()), has(ModBlocks.END_STONE_BRICK_PILLAR.get())).save(pRecipeOutput);

        oreSmelting(pRecipeOutput, VOIDITE_SMELTABLES, RecipeCategory.MISC, ModItems.VOIDITE_INGOT.get(), 1f, 300, "voidite");
        oreBlasting(pRecipeOutput, VOIDITE_SMELTABLES, RecipeCategory.MISC, ModItems.VOIDITE_INGOT.get(), 3f, 150, "voidite");
        nineBlockStorageRecipes(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModItems.VOIDITE_INGOT.get(), RecipeCategory.MISC, ModBlocks.BLOCK_OF_VOIDITE.get());

    }
}
