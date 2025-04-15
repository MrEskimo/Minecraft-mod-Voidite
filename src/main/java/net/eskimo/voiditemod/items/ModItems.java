package net.eskimo.voiditemod.items;

import net.eskimo.voiditemod.Block.ModBlocks;
import net.eskimo.voiditemod.VoiditeMod;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, VoiditeMod.MOD_ID);

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

    public static final RegistryObject<Item> FORGE_SCALES = ITEMS.register("forge_scales",
            () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> VOIDITE_PLATE = ITEMS.register("voidite_plate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ANNEALED_VOIDITE_INGOT = ITEMS.register("annealed_voidite_ingot",
            () -> new Item(new Item.Properties().durability(800)));
    public static final RegistryObject<Item> ANNEALED_VOIDITE_PLATE = ITEMS.register("annealed_voidite_plate",
            () -> new Item(new Item.Properties().durability(1000)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
