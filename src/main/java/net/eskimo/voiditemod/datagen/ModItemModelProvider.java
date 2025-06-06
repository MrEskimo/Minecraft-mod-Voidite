package net.eskimo.voiditemod.datagen;

import net.eskimo.voiditemod.Block.ModBlocks;
import net.eskimo.voiditemod.VoiditeMod;
import net.eskimo.voiditemod.items.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, VoiditeMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.SMILE.get());
        basicItem(ModItems.RAW_VOIDITE.get());
        basicItem(ModItems.VOIDITE_INGOT.get());
        simpleBlockItem(ModBlocks.SUNCROWN_GRASS);
        basicItem(ModItems.GLOWING_VOID_BERRIES.get());
        basicItem(ModItems.SINCEHE_POTATO.get());
        basicItem(ModItems.SINCEHE_POTATO_SEEDS.get());
        basicItem(ModItems.FORGE_SCALES.get());
        basicItem(ModItems.VOIDITE_PLATE.get());
        basicItem(ModItems.ANNEALED_VOIDITE_INGOT.get());
        basicItem(ModItems.ANNEALED_VOIDITE_PLATE.get());

        wallItem(ModBlocks.END_SLUDGE_BRICKS_WALL, ModBlocks.END_SLUDGE_BRICKS);
        wallItem(ModBlocks.PACKED_END_SLUDGE_WALL, ModBlocks.PACKED_END_SLUDGE);

        saplingItem(ModBlocks.SUNCROWN_OAK_SAPLING);

        buttonItem(ModBlocks.SUNCROWN_OAK_BUTTON, ModBlocks.SUNCROWN_OAK_PLANKS);
        fenceItem(ModBlocks.SUNCROWN_OAK_FENCE, ModBlocks.SUNCROWN_OAK_PLANKS);

        simpleBlockItem(ModBlocks.SUNCROWN_OAK_DOOR);

    }



    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(VoiditeMod.MOD_ID,"block/" + item.getId().getPath()));
    }

    public void buttonItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(VoiditeMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void fenceItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(VoiditeMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(VoiditeMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<? extends Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(VoiditeMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}