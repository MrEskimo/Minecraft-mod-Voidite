package net.eskimo.voiditemod;

import com.mojang.logging.LogUtils;
import net.eskimo.voiditemod.Block.ModBlocks;
import net.eskimo.voiditemod.items.ModCreativeTabs;
import net.eskimo.voiditemod.items.ModItems;
import net.eskimo.voiditemod.worldgen.biome.ModBiomes;
import net.eskimo.voiditemod.worldgen.biome.ModTerrablender;
import net.eskimo.voiditemod.worldgen.biome.surface.ModSurfaceRules;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import terrablender.api.SurfaceRuleManager;

// Very important Comment
// The value here should match an entry in the META-INF/mods.toml file
@Mod(VoiditeMod.MOD_ID)
public class VoiditeMod {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "voiditemod";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public VoiditeMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        ModCreativeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModTerrablender.registerBiomes();

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)  {
        event.enqueueWork(()-> {
            VoiditeMod.setupTerraBlender();
            ComposterBlock.COMPOSTABLES.put(ModItems.SINCEHE_POTATO.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ModItems.SINCEHE_POTATO_SEEDS.get(), 0.1f);

            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, ModSurfaceRules.makeRules());
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.END, MOD_ID, ModSurfaceRules.makeRules());
        });
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.SMILE);
        }

        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.END_SLUDGE);
            event.accept(ModBlocks.PACKED_END_SLUDGE);
            event.accept(ModBlocks.END_SLUDGE_BRICKS);
        }

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
    public static void setupTerraBlender()
    {
        ModBiomes.setupTerraBlender();
    }
}
