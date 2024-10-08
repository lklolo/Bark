package net.luckshark.item.custom;

import com.google.common.collect.ImmutableMap;
import net.luckshark.item.ModArmorMaterials;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;

import java.util.Map;

public class ModArmorItem extends ArmorItem {

    private static final Map<ArmorMaterial, StatusEffectInstance> MAP =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>())
                    .put(ModArmorMaterials.OAK_BARK.value(), new StatusEffectInstance(
                            StatusEffects.SATURATION , 10, 1, false, false, false
                    ))//饱和
                    .put(ModArmorMaterials.SPRUCE_BARK.value(), new StatusEffectInstance(
                            StatusEffects.RESISTANCE , 10, 1, false, false, false
                    ))//抗性提升
                    .put(ModArmorMaterials.BIRCH_BARK.value(), new StatusEffectInstance(
                            StatusEffects.LUCK, 1, 10, false, false, false
                    ))//幸运，在俄罗斯许多文艺作品中，白桦树都作为爱情的象征出现，被视为忠贞、执著的化身。
                    .put(ModArmorMaterials.JUNGLE_BARK.value(), new StatusEffectInstance(
                            StatusEffects.NIGHT_VISION, 10, 1, false, false, false
                    ))//夜视
                    .put(ModArmorMaterials.ACACIA_BARK.value(), new StatusEffectInstance(
                          StatusEffects.INSTANT_HEALTH, 10, 1, false, false, false
                    ))//金合欢具有抗菌消炎、消肿止痛、治疗腰膝酸软的作用，多用于治疗风湿等疾病。
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

    public ModArmorItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
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

        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : MAP.entrySet()) {
            ArmorMaterial material = entry.getKey();
            StatusEffectInstance effect = entry.getValue();

            if (hasCorrectArmorSet(player, material)) {
                addStatusEffectForMaterial(player, effect);
            }
        }

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
}
