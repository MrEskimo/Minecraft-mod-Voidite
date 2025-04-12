package net.eskimo.endmod.datagen;

import net.eskimo.endmod.Block.ModBlocks;
import net.eskimo.endmod.Block.custom.SincehePotatoCropBlock;
import net.eskimo.endmod.items.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
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
        //dropSelf(ModBlocks.GLOWING_VOID_BERRY_BUSH.get());

        this.add(ModBlocks.VOID_GRASS.get(),
                createShearsOnlyDrop(ModBlocks.VOID_GRASS.get()));

        this.add(ModBlocks.CHORUS_TURF.get(),
                createSilkTouchOnlyTable(ModBlocks.CHORUS_TURF.get()));



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

        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        this.add(ModBlocks.GLOWING_VOID_BERRY_BUSH.get(), block -> this.applyExplosionDecay(
                block,LootTable.lootTable().withPool(LootPool.lootPool().when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.GLOWING_VOID_BERRY_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 3))
                                ).add(LootItem.lootTableItem(ModItems.GLOWING_VOID_BERRIES.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                ).withPool(LootPool.lootPool().when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.GLOWING_VOID_BERRY_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))
                                ).add(LootItem.lootTableItem(ModItems.GLOWING_VOID_BERRIES.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )));

        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.SINCEHE_POTATO_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SincehePotatoCropBlock.AGE, SincehePotatoCropBlock.MAX_AGE));

        this.add(ModBlocks.SINCEHE_POTATO_CROP.get(), this.createCropDrops(ModBlocks.SINCEHE_POTATO_CROP.get(),
                ModItems.SINCEHE_POTATO.get(), ModItems.SINCEHE_POTATO_SEEDS.get(), lootItemConditionBuilder));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
