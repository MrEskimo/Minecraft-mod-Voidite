package net.eskimo.voiditemod.util;

import net.eskimo.voiditemod.VoiditeMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> SUNCROWN_OAK_ROOT_REPLACEABLE = createTag("suncrown_oak_root_replaceable");
        public static final TagKey<Block> SUNCROWN_OAK_GROWS_ON = createTag("suncrown_oak_grows_on");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(VoiditeMod.MOD_ID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(VoiditeMod.MOD_ID, name));
        }
    }

}
