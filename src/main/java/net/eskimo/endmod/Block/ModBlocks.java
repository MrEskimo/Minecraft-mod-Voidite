package net.eskimo.endmod.Block;

import net.eskimo.endmod.Block.custom.ChorusTurf;
import net.eskimo.endmod.EndMod;
import net.eskimo.endmod.items.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, EndMod.MOD_ID);

    public static final RegistryObject<Block> BLOCK_OF_SMILE = registerBlock("block_of_smile",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1f).requiresCorrectToolForDrops().sound(SoundType.BASALT)));
    //try to make end sludge emissive or work like mud
    public static final RegistryObject<Block> END_SLUDGE = registerBlock("end_sludge",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.5f).requiresCorrectToolForDrops().sound(SoundType.MUD)));
    public static final RegistryObject<Block> PACKED_END_SLUDGE = registerBlock("packed_end_sludge",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1f).requiresCorrectToolForDrops().sound(SoundType.PACKED_MUD)));
    public static final RegistryObject<Block> END_SLUDGE_BRICKS = registerBlock("end_sludge_bricks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.MUD_BRICKS)));

    public static final RegistryObject<StairBlock> END_SLUDGE_BRICKS_STAIRS = registerBlock("end_sludge_bricks_stairs",
            () -> new StairBlock(ModBlocks.END_SLUDGE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2).requiresCorrectToolForDrops().sound(SoundType.MUD_BRICKS)));
    public static final RegistryObject<SlabBlock> END_SLUDGE_BRICKS_SLAB = registerBlock("end_sludge_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2).requiresCorrectToolForDrops().sound(SoundType.MUD_BRICKS)));
    public static final RegistryObject<WallBlock> END_SLUDGE_BRICKS_WALL = registerBlock("end_sludge_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(2).requiresCorrectToolForDrops().sound(SoundType.MUD_BRICKS)));

    public static final RegistryObject<StairBlock> PACKED_END_SLUDGE_STAIRS = registerBlock("packed_end_sludge_stairs",
            () -> new StairBlock(ModBlocks.PACKED_END_SLUDGE.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2).requiresCorrectToolForDrops().sound(SoundType.PACKED_MUD)));
    public static final RegistryObject<SlabBlock> PACKED_END_SLUDGE_SLAB = registerBlock("packed_end_sludge_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2).requiresCorrectToolForDrops().sound(SoundType.PACKED_MUD)));
    public static final RegistryObject<WallBlock> PACKED_END_SLUDGE_WALL = registerBlock("packed_end_sludge_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(2).requiresCorrectToolForDrops().sound(SoundType.PACKED_MUD)));

    public static final RegistryObject<GrassBlock> CHORUS_TURF = registerBlock("chorus_turf",
            ()-> new GrassBlock(BlockBehaviour.Properties.of()
                    .strength(0.5F)
                    //.emissiveRendering((state, world, pos) -> true)
                    .friction(0.65F)
                    .requiresCorrectToolForDrops()));
                    //.lightLevel(state -> 7)));

    public static final RegistryObject<TallGrassBlock> VOID_GRASS = registerBlock("void_grass",
            ()-> new TallGrassBlock((BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS))));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}