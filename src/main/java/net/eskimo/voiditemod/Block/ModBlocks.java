package net.eskimo.voiditemod.Block;

import net.eskimo.voiditemod.Block.custom.*;
import net.eskimo.voiditemod.VoiditeMod;
import net.eskimo.voiditemod.items.ModItems;
import net.eskimo.voiditemod.worldgen.tree.ModTreeGrowers;
import net.minecraft.util.ColorRGBA;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, VoiditeMod.MOD_ID);

    public static final RegistryObject<Block> BLOCK_OF_SMILE = registerBlock("block_of_smile",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1f).requiresCorrectToolForDrops().sound(SoundType.BASALT)));
    public static final RegistryObject<Block> AMOGUS = registerBlock("amogus",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1f).requiresCorrectToolForDrops().sound(SoundType.BASALT).noLootTable()));

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

    public static final RegistryObject<GrassBlock> SUNCROWN_TURF = registerBlock("suncrown_turf",
            ()-> new CustomGrass(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK)
                    .strength(0.5F)
                    .friction(0.65F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<TallGrassBlock> SUNCROWN_GRASS = registerBlock("suncrown_grass",
            ()-> new TallGrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS)));

    public static final RegistryObject<Block> END_STONE_BRICK_PILLAR = registerBlock("end_stone_brick_pillar",
            ()-> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE_BRICKS).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CHISELED_END_STONE_BRICK_PILLAR = registerBlock("chiseled_end_stone_brick_pillar",
            ()-> new ChiseledEndStoneBrickPillarBlock(BlockBehaviour.Properties.of().strength(3f)
                    .lightLevel(state -> state.getValue(ChiseledEndStoneBrickPillarBlock.CLICKED) ? 15 : 0)));

    public static final RegistryObject<Block> PURPUR_LIGHT = registerBlock("purpur_light",
            ()-> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PEARLESCENT_FROGLIGHT).sound(SoundType.STONE)));

    public static final RegistryObject<Block> VOIDITE_ORE = registerBlock("voidite_ore",
            ()-> new Block(BlockBehaviour.Properties.of().strength(5f).requiresCorrectToolForDrops()
                    //.emissiveRendering((state, world, pos) -> true)
                    .lightLevel(state -> 6)));

    public static final RegistryObject<Block> BLOCK_OF_VOIDITE = registerBlock("block_of_voidite",
            ()-> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> GLOWING_VOID_BERRY_BUSH = BLOCKS.register("glowing_void_berry_bush",
            () -> new GlowingVoidBerryBushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH)
                    .emissiveRendering((pState, pLevel, pPos) -> true)
                    .lightLevel(state -> 4), () -> ModBlocks.SUNCROWN_TURF.get()));
    public static final RegistryObject<Block> SINCEHE_POTATO_CROP = BLOCKS.register("sincehe_potato_crop",
            () -> new SincehePotatoCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));

    public static final RegistryObject<RotatedPillarBlock> SUNCROWN_OAK_LOG = registerBlock("suncrown_oak_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_SUNCROWN_OAK_LOG = registerBlock("stripped_suncrown_oak_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<RotatedPillarBlock> SUNCROWN_OAK_WOOD = registerBlock("suncrown_oak_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_SUNCROWN_OAK_WOOD = registerBlock("stripped_suncrown_oak_wood",
                () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> SUNCROWN_OAK_PLANKS = registerBlock("suncrown_oak_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> SUNCROWN_OAK_LEAVES = registerBlock("suncrown_oak_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));

    public static final RegistryObject<Block> SUNCROWN_OAK_SAPLING = registerBlock("suncrown_oak_sapling",
            () -> new SaplingBlock(ModTreeGrowers.SUNCROWN_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<SlabBlock> SUNCROWN_OAK_SLAB = registerBlock("suncrown_oak_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)));
    public static final RegistryObject<StairBlock> SUNCROWN_OAK_STAIRS = registerBlock("suncrown_oak_stairs",
            () -> new StairBlock(ModBlocks.SUNCROWN_OAK_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)));

    public static final RegistryObject<PressurePlateBlock> SUNCROWN_OAK_PRESSURE_PLATE = registerBlock("suncrown_oak_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)));
    public static final RegistryObject<ButtonBlock> SUNCROWN_OAK_BUTTON = registerBlock("suncrown_oak_button",
            () -> new ButtonBlock(BlockSetType.OAK,20, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));

    public static final RegistryObject<FenceBlock> SUNCROWN_OAK_FENCE = registerBlock("suncrown_oak_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final RegistryObject<FenceGateBlock> SUNCROWN_OAK_FENCE_GATE = registerBlock("suncrown_oak_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));

    public static final RegistryObject<DoorBlock> SUNCROWN_OAK_DOOR = registerBlock("suncrown_oak_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
    public static final RegistryObject<TrapDoorBlock> SUNCROWN_OAK_TRAPDOOR = registerBlock("suncrown_oak_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));

    public static final RegistryObject<Block> SUNCROWN_SAND = registerBlock("suncrown_sand",
            () -> new ColoredFallingBlock(new ColorRGBA(11173120),
                    BlockBehaviour.Properties.of().strength(0.25f).sound(SoundType.BASALT)) {
                @Override
                protected int getDelayAfterPlace() {
                    return 40;
                }}
    );









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