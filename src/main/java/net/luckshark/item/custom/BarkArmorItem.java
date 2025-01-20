package net.luckshark.item.custom;

import com.google.common.collect.ImmutableMap;
import net.luckshark.item.ModArmorMaterials;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.trim.ArmorTrim;
import net.minecraft.item.trim.ArmorTrimMaterial;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class BarkArmorItem extends ArmorItem {

    private static final Map<ArmorMaterial, StatusEffectInstance> ARMOR_MATERIALS_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>())
                    .put(ModArmorMaterials.OAK_BARK.value(), new StatusEffectInstance(
                            StatusEffects.SATURATION , 10, 1, false, false, false
                    ))//饱和
                    .put(ModArmorMaterials.SPRUCE_BARK.value(), new StatusEffectInstance(
                            StatusEffects.RESISTANCE , 10, 1, false, false, false
                    ))//抗性提升
                    .put(ModArmorMaterials.BIRCH_BARK.value(), new StatusEffectInstance(
                            StatusEffects.LUCK, 1, 10, false, false, false
                    ))//幸运
                    .put(ModArmorMaterials.JUNGLE_BARK.value(), new StatusEffectInstance(
                            StatusEffects.NIGHT_VISION, 10, 1, false, false, false
                    ))//夜视
                    .put(ModArmorMaterials.ACACIA_BARK.value(), new StatusEffectInstance(
                          StatusEffects.INSTANT_HEALTH, 10, 1, false, false, false
                    ))//治疗
                    .put(ModArmorMaterials.DARK_OAK_BARK.value(), new StatusEffectInstance(
                            StatusEffects.STRENGTH, 10, 1, false, false, false
                    ))//力量
                    .put(ModArmorMaterials.MANGROVE_BARK.value(),new StatusEffectInstance(
                            StatusEffects.WATER_BREATHING, 10, 1, false, false, false
                    ))//水下呼吸
                    .put(ModArmorMaterials.CHERRY_BARK.value(), new StatusEffectInstance(
                            StatusEffects.JUMP_BOOST, 10, 1, false, false, false
                    ))//跳跃提升
                    .put(ModArmorMaterials.CRIMSON_BARK.value(), new StatusEffectInstance(
                            StatusEffects.FIRE_RESISTANCE, 10, 1, false, false, false
                    ))//火焰抗性
                    .put(ModArmorMaterials.WARPED_BARK.value(), new StatusEffectInstance(
                            StatusEffects.SPEED, 10, 1, false, false, false
                    ))//速度
                    .put(ModArmorMaterials.BAMBOO_BARK.value(), new StatusEffectInstance(
                            StatusEffects.SLOW_FALLING, 10, 1, false, false, false
                    ))//缓降
                    .build();

    private static final Map<String, ArmorMaterial> TRIM_MATERIALS_MAP =
            (new ImmutableMap.Builder<String, ArmorMaterial>())
                    .put("oak_bark_essence", ModArmorMaterials.OAK_BARK.value())
                    .put("spruce_bark_essence", ModArmorMaterials.SPRUCE_BARK.value())
                    .put("birch_bark_essence", ModArmorMaterials.BIRCH_BARK.value())
                    .put("jungle_bark_essence", ModArmorMaterials.JUNGLE_BARK.value())
                    .put("acacia_bark_essence", ModArmorMaterials.ACACIA_BARK.value())
                    .put("dark_oak_bark_essence", ModArmorMaterials.DARK_OAK_BARK.value())
                    .put("mangrove_bark_essence", ModArmorMaterials.MANGROVE_BARK.value())
                    .put("cherry_bark_essence", ModArmorMaterials.CHERRY_BARK.value())
                    .put("crimson_bark_essence", ModArmorMaterials.CRIMSON_BARK.value())
                    .put("warped_bark_essence", ModArmorMaterials.WARPED_BARK.value())
                    .put("bamboo_bark_essence", ModArmorMaterials.BAMBOO_BARK.value())
                    .build();

    public BarkArmorItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

        if (!world.isClient() && entity instanceof PlayerEntity player && hasFullSuitOfArmor(player)){
            evaluateArmorEffects(player);
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        ArmorTrimMaterial trimMaterial = getArmorTrimMaterial(player);
        if (trimMaterial != null) {
            StatusEffectInstance effect = ARMOR_MATERIALS_MAP.get(TRIM_MATERIALS_MAP.get(trimMaterial.assetName()));
            if (effect != null) {
                addStatusEffectForMaterial(player, effect);
            }
        }
        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : ARMOR_MATERIALS_MAP.entrySet()) {
            ArmorMaterial armorMaterial = entry.getKey();
            StatusEffectInstance effect = entry.getValue();
            if (hasCorrectArmorSet(player, armorMaterial)) {
                addStatusEffectForMaterial(player, effect);
            }
        }

    }

    private ArmorTrimMaterial getArmorTrimMaterial(PlayerEntity player) {
        ArmorTrimMaterial material = null;
        for (ItemStack armorStack : player.getArmorItems()) {
            ArmorTrim trim = getTrim(armorStack);
            if (trim == null) {
                return null;
            }

            ArmorTrimMaterial currentMaterial = trim.getMaterial().value();
            if (material == null) {
                material = currentMaterial;
            } else if (!material.equals(currentMaterial)) {
                return null;
            }
        }

        return material;
    }

    private boolean hasCorrectArmorSet(PlayerEntity player, ArmorMaterial material) {
        for (ItemStack stack : player.getInventory().armor) {
            if (!(stack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }
        ArmorItem helmet = (ArmorItem) player.getInventory().getArmorStack(3).getItem();
        ArmorItem chestplate = (ArmorItem) player.getInventory().getArmorStack(2).getItem();
        ArmorItem leggings = (ArmorItem) player.getInventory().getArmorStack(1).getItem();
        ArmorItem boots = (ArmorItem) player.getInventory().getArmorStack(0).getItem();

        return helmet.getMaterial().value() == material &&
                chestplate.getMaterial().value() == material &&
                leggings.getMaterial().value() == material &&
                boots.getMaterial().value() == material;

    }

    private void addStatusEffectForMaterial(PlayerEntity player, StatusEffectInstance effect) {

        if (!player.hasStatusEffect(effect.getEffectType())) {
            player.addStatusEffect(new StatusEffectInstance(effect));
        }

    }

    private boolean hasFullSuitOfArmor(PlayerEntity player) {

        ItemStack helmet = player.getInventory().getArmorStack(3);
        ItemStack chestplate = player.getInventory().getArmorStack(2);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack boots = player.getInventory().getArmorStack(0);

        return !helmet.isEmpty() && !chestplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
    }

    public static @Nullable ArmorTrim getTrim(@NotNull ItemStack stack) {
        return stack.get(DataComponentTypes.TRIM);
    }
}
