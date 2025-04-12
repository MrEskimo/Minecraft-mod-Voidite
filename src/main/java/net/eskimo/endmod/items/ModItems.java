package net.eskimo.endmod.items;

import net.eskimo.endmod.Block.ModBlocks;
import net.eskimo.endmod.EndMod;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EndMod.MOD_ID);

    public static final RegistryObject<Item> SMILE = ITEMS.register("smile",
            () -> new Item(new Item.Properties().food(ModFoodProperties.SMILE)));

    public static final RegistryObject<Item> RAW_VOIDITE = ITEMS.register("raw_voidite",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> VOIDITE_INGOT = ITEMS.register("voidite_ingot",
            ()-> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> GLOWING_VOID_BERRIES = ITEMS.register("glowing_void_berries",
            () -> new ItemNameBlockItem(ModBlocks.GLOWING_VOID_BERRY_BUSH.get(), new Item.Properties().food(ModFoodProperties.GLOWING_VOID_BERRY)));

    public static final RegistryObject<Item> SINCEHE_POTATO = ITEMS.register("sincehe_potato",
            () -> new Item(new Item.Properties().food(ModFoodProperties.SINCEHE_POTATO)));
    public static final RegistryObject<Item> SINCEHE_POTATO_SEEDS = ITEMS.register("sincehe_potato_seeds",
            () -> new ItemNameBlockItem(ModBlocks.SINCEHE_POTATO_CROP.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
