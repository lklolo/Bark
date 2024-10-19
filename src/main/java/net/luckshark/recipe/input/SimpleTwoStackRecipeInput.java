package net.luckshark.recipe.input;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.RecipeInput;

public record SimpleTwoStackRecipeInput(ItemStack input1, ItemStack input2) implements RecipeInput {
    @Override
    public ItemStack getStackInSlot(int slot) {
        return switch (slot) {
            case 0 -> this.input1;
            case 1 -> this.input2;
            default -> throw new IllegalArgumentException("Recipe does not contain slot " + slot);
        };
    }

    @Override
    public int getSize() {
        return 2;
    }

    @Override
    public boolean isEmpty() {
        return this.input1.isEmpty() && this.input2.isEmpty();
    }
}
