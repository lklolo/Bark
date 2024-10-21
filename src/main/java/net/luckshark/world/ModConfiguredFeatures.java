package net.luckshark.world;

import net.luckshark.Bark;
import net.luckshark.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;


public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> QUILMOR_KEY = of("quilmor");

    public static void bootstrap(Registerable<ConfiguredFeature<?,?>> featureRegisterable) {
        register(featureRegisterable, QUILMOR_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(1, 1, 0,
                PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.QUILMOR)))));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> of(String id) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Bark.MOD_ID, id));
    }
    public static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> registerable, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
        registerable.register(key, new ConfiguredFeature<FC, F>(feature, config));
    }
}
