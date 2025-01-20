package net.luckshark.item;

import com.google.common.collect.ImmutableMap;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.Map;

public class ModFoodComponents {

    public static final FoodComponent OAK_BARK = new FoodComponent.Builder().nutrition(1).saturationModifier(1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 600), 0.2F)
            .build();
    public static final FoodComponent SPRUCE_BARK = barkFood(StatusEffects.RESISTANCE);
    public static final FoodComponent BIRCH_BARK = barkFood(StatusEffects.LUCK);
    public static final FoodComponent JUNGLE_BARK = barkFood(StatusEffects.NIGHT_VISION);
    public static final FoodComponent ACACIA_BARK = barkFood(StatusEffects.INSTANT_HEALTH);
    public static final FoodComponent DARK_OAK_BARK = barkFood(StatusEffects.STRENGTH);
    public static final FoodComponent MANGROVE_BARK = barkFood(StatusEffects.WATER_BREATHING);
    public static final FoodComponent CHERRY_BARK = barkFood(StatusEffects.JUMP_BOOST);
    public static final FoodComponent CRIMSON_BARK = new FoodComponent.Builder().nutrition(2).saturationModifier(0.2F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 600), 0.1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600), 2.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 300), 3.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300),  1.0f)
            .build();
    public static final FoodComponent WARPED_BARK = new FoodComponent.Builder().nutrition(2).saturationModifier(0.2F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 600), 0.1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600), 2.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 300), 3.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300),  1.0f)
            .build();
    public static final FoodComponent BAMBOO_BARK = barkFood(StatusEffects.SLOW_FALLING);

    public static FoodComponent barkFood(RegistryEntry<StatusEffect> effect) {
        return new FoodComponent.Builder().nutrition(1).saturationModifier(0.08F)
                .statusEffect(new StatusEffectInstance(effect, 600), 0.1F)
                .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600), 5.0f)
                .build();
    }

    public static final Map<String, FoodComponent> MAP =
            (new ImmutableMap.Builder<String, FoodComponent>())
                    .put("oak_bark", OAK_BARK)
                    .put("spruce_bark", SPRUCE_BARK)
                    .put("birch_bark", BIRCH_BARK)
                    .put("jungle_bark", JUNGLE_BARK)
                    .put("acacia_bark", ACACIA_BARK)
                    .put("dark_oak_bark", DARK_OAK_BARK)
                    .put("mangrove_bark", MANGROVE_BARK)
                    .put("cherry_bark", CHERRY_BARK)
                    .put("crimson_bark", CRIMSON_BARK)
                    .put("warped_bark", WARPED_BARK)
                    .put("bamboo_bark", BAMBOO_BARK)
                    .build();
}
