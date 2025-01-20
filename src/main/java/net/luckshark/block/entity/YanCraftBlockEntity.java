package net.luckshark.block.entity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.luckshark.data.YanCraftData;
import net.luckshark.recipe.YanCraftRecipe;
import net.luckshark.recipe.input.SimpleTwoStackRecipeInput;
import net.luckshark.screen.YanCraftScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Optional;
import java.util.Random;

public class YanCraftBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory<YanCraftData>, ImplementedInventory {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);
    private final int INPUT_SLOT = 0;
    private final int INPUT_SLOT2 = 1;
    private final int OUTPUT_SLOT = 2;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;

    public YanCraftBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.YAN_CRAFT_BLOCK_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {

            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> YanCraftBlockEntity.this.progress;
                    case 1 -> YanCraftBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> YanCraftBlockEntity.this.progress = value;
                    case 1 -> YanCraftBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 3;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("container.yan_craft");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new YanCraftScreenHandler(syncId, playerInventory, this.propertyDelegate, this);
    }

    @Override
    public YanCraftData getScreenOpeningData(ServerPlayerEntity player) {
        return new YanCraftData(pos);
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, this.inventory, false, registryLookup);
        nbt.putInt("yan_craft", this.progress);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, this.inventory, registryLookup);
        this.progress = nbt.getInt("yan_craft");
    }

    @Override
    public int getMaxCountPerStack() {
        return 64;
    }
    public void tick(World world, BlockPos pos, BlockState state) {
        if (world.isClient()) {
            return;
        }
        if (!isOutputSlotAvailable()) {
            resetProgress();
            markDirty(world, pos, state);
            return;
        }
        if (!hasRecipe()) {
            resetProgress();
            return;
        }
        increaseCraftProgress();
        markDirty(world, pos, state);
        if (hasCraftingFinished()) {
            craftItem();
            resetProgress();
        }
    }
    private void resetProgress() {
        this.progress = 0;
    }

    private void craftItem() {
        Optional<RecipeEntry<YanCraftRecipe>> recipe = getCurrentRecipe();
        if (isCraftSucceed(YanCraftRecipe.getSuccessRate()) && recipe.isPresent()) {
            this.setStack(OUTPUT_SLOT, new ItemStack(recipe.get().value().getResult(null).getItem(),
                    getStack(OUTPUT_SLOT).getCount() + recipe.get().value().getResult(null).getCount()));
        }
        this.removeStack(INPUT_SLOT, 1);
        this.makeDamage(getStack(INPUT_SLOT2));
    }

    public static boolean isCraftSucceed(double rate) {
        if (rate < 0.0 || rate > 1.0) {
            throw new IllegalArgumentException("Probability must be between 0.0 and 1.0");
        }
        Random random = new Random();
        return random.nextDouble() < rate;
    }

    private void makeDamage(ItemStack stack) {
        int damage = new Random().nextInt(1,3);
        if (stack.getDamage() + damage < stack.getMaxDamage()) {
            stack.setDamage(stack.getDamage() + damage);
            return;
        }
        removeStack(INPUT_SLOT2, 1);
    }

    private Optional<RecipeEntry<YanCraftRecipe>> getCurrentRecipe() {
        SimpleInventory inventory = new SimpleInventory(this.size());

        for (int i = 0; i < this.size(); i++) {
            inventory.setStack(i, this.getStack(i));
        }

        SimpleTwoStackRecipeInput recipeInput = new SimpleTwoStackRecipeInput(
                inventory.getStack(INPUT_SLOT),
                inventory.getStack(INPUT_SLOT2)
        );

        return Objects.requireNonNull(getWorld()).getRecipeManager().getFirstMatch(
                YanCraftRecipe.Type.INSTANCE,
                recipeInput,
                getWorld());
    }


    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftProgress() {
        this.progress++;
    }

    private boolean hasRecipe() {
        Optional<RecipeEntry<YanCraftRecipe>> recipe = getCurrentRecipe();
        if (recipe.isEmpty()) {
            return false;
        }
        if (!canInsertAmountIntoOutputSlot(recipe.get().value().getResult(null))) {
            return false;
        }
        return canInsertIntoOutputSlot(recipe.get().value().getResult(null).getItem());
    }


    private boolean canInsertIntoOutputSlot(Item item) {
        return this.getStack(OUTPUT_SLOT).isEmpty() ||
                this.getStack(OUTPUT_SLOT).getItem() == item;
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
        return this.getStack(OUTPUT_SLOT).getCount() + result.getCount() <= this.getMaxCountPerStack();
    }

    private boolean isOutputSlotAvailable() {
        return this.getStack(OUTPUT_SLOT).isEmpty() ||
                this.getStack(OUTPUT_SLOT).getCount() <= this.getMaxCountPerStack();
    }
}
