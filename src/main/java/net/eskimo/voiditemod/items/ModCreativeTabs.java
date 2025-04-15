package net.eskimo.voiditemod.items;

import net.eskimo.voiditemod.Block.ModBlocks;
import net.eskimo.voiditemod.VoiditeMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, VoiditeMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> END_STUFF = CREATIVE_MODE_TABS.register("end_stuff",
            ()-> CreativeModeTab.builder().icon(()-> new ItemStack(ModBlocks.END_SLUDGE.get()))
                    .title(Component.translatable("creativetab.voiditemod.end_stuff"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.END_SLUDGE.get());

                        output.accept(ModBlocks.PACKED_END_SLUDGE.get());
                        output.accept(ModBlocks.PACKED_END_SLUDGE_STAIRS.get());
                        output.accept(ModBlocks.PACKED_END_SLUDGE_SLAB.get());
                        output.accept(ModBlocks.PACKED_END_SLUDGE_WALL.get());

                        output.accept(ModBlocks.END_SLUDGE_BRICKS.get());
                        output.accept(ModBlocks.END_SLUDGE_BRICKS_STAIRS.get());
                        output.accept(ModBlocks.END_SLUDGE_BRICKS_SLAB.get());
                        output.accept(ModBlocks.END_SLUDGE_BRICKS_WALL.get());

                        output.accept(ModBlocks.CHORUS_TURF.get());
                        output.accept(ModBlocks.VOID_GRASS.get());

                        output.accept(ModBlocks.END_STONE_BRICK_PILLAR.get());
                        output.accept(ModBlocks.CHISELED_END_STONE_BRICK_PILLAR.get());

                        output.accept(ModBlocks.VOIDITE_ORE.get());
                        output.accept(ModItems.RAW_VOIDITE.get());
                        output.accept(ModItems.VOIDITE_INGOT.get());
                        output.accept(ModBlocks.BLOCK_OF_VOIDITE.get());
                        output.accept(ModItems.VOIDITE_PLATE.get());

                        output.accept(ModBlocks.PURPUR_LIGHT.get());

                        output.accept(ModItems.GLOWING_VOID_BERRIES.get());

                        output.accept(ModItems.SINCEHE_POTATO.get());
                        output.accept(ModItems.SINCEHE_POTATO_SEEDS.get());

                        output.accept(ModItems.FORGE_SCALES.get());

                        output.accept(ModItems.ANNEALED_VOIDITE_INGOT.get());
                        output.accept(ModItems.ANNEALED_VOIDITE_PLATE.get());


                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
