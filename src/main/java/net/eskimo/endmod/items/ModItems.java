package net.eskimo.endmod.items;

import net.eskimo.endmod.EndMod;
import net.minecraft.world.item.Item;
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

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
