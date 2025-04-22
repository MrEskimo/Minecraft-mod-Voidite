package net.eskimo.voiditemod.worldgen.biome;

import net.minecraft.resources.ResourceLocation;
import terrablender.api.Region;
import terrablender.api.RegionType;

public class ModEndRegion extends Region {
    public ModEndRegion(ResourceLocation name, int weight) {
        super(name, RegionType.END, weight);
    }
}
