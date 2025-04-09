package net.eskimo.endmod.items;


import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties SMILE = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400), 0.20f).build();



}
