package net.luckshark.recipe;

import net.luckshark.Bark;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipeTypes {
    public static void registerRecipeTypes() {
        Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of(Bark.MOD_ID, YanCraftRecipe.Serializer.ID),
                YanCraftRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, Identifier.of(Bark.MOD_ID, YanCraftRecipe.Type.ID),
                YanCraftRecipe.Type.INSTANCE);
    }
}
