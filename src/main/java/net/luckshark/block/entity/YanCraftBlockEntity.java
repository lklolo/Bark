package net.luckshark.block.entity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.luckshark.data.YanCraftData;
import net.luckshark.recipe.YanCraftRecipe;
import net.luckshark.screen.YanCraftScreenHandler;
import net.luckshark.tag.ModItemTags;
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
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class YanCraftBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory<YanCraftData>, ImplementedInventory {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);
    private final int INPUT_SLOT = 0;
    private final int OUTPUT_SLOT = 1;
    private final int INPUT_SLOT2 = 2;

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
        /*
        ItemStack result = new ItemStack(ModItems.OAK_BARK_ESSENCE);
        this.setStack(OUTPUT_SLOT, new ItemStack(result.getItem(), getStack(OUTPUT_SLOT).getCount() + result.getCount()));
         */
        Optional<RecipeEntry<YanCraftRecipe>> recipe = getCurrentRecipe();
        this.setStack(OUTPUT_SLOT, new ItemStack(recipe.get().value().getResult(null).getItem(),
                getStack(OUTPUT_SLOT).getCount() + recipe.get().value().getResult(null).getCount()));

        this.removeStack(INPUT_SLOT, 1);
        //this.getStack(INPUT_SLOT2).setDamage(getStack(INPUT_SLOT2).getDamage() + 1);
        this.makeDamage(getStack(INPUT_SLOT2));
    }
    private void makeDamage(ItemStack stack) {
        if (stack.getDamage() < stack.getMaxDamage() - 1) {
            stack.setDamage(stack.getDamage() + 1);
            return;
        }
        removeStack(INPUT_SLOT2, 1);
    }

    private Optional<RecipeEntry<YanCraftRecipe>> getCurrentRecipe() {
        SimpleInventory inventory = new SimpleInventory(this.size());
        for (int i = 0; i < this.size(); i++) {
            inventory.setStack(i, this.getStack(i));
        }
        return getWorld().getRecipeManager().getFirstMatch(YanCraftRecipe.Type.INSTANCE,
                new SingleStackRecipeInput(inventory.getStack(INPUT_SLOT)), getWorld());
    }

    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftProgress() {
        this.progress++;
    }

    private boolean hasRecipe() {
        /*
        ItemStack result = new ItemStack(ModItems.OAK_BARK_ESSENCE);
        boolean hasInput = getStack(INPUT_SLOT).getItem() == ModItems.OAK_BARK;
        boolean hasCatalyst = getStack(INPUT_SLOT2).getItem() == ModItems.QUILMOR;
        return hasInput && hasCatalyst && canInsertAmountIntoOutputSlot(result) && canInsertIntoOutputSlot(result.getItem());
        */
        boolean hasCatalyst = getStack(INPUT_SLOT2).isIn(ModItemTags.YAN_CRAFT_CATALYST);
        Optional<RecipeEntry<YanCraftRecipe>> recipe = getCurrentRecipe();
        return hasCatalyst && recipe.isPresent() && canInsertAmountIntoOutputSlot(recipe.get().value().getResult(null)) &&
                canInsertIntoOutputSlot(recipe.get().value().getResult(null).getItem());
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