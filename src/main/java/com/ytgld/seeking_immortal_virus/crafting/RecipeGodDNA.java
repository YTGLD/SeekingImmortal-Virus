package com.ytgld.seeking_immortal_virus.crafting;

import com.ytgld.seeking_immortal_virus.event.old.EquippedEvt;
import com.ytgld.seeking_immortal_virus.event.old.NewEvent;
import com.ytgld.seeking_immortal_virus.init.moonstoneitem.DataReg;
import com.ytgld.seeking_immortal_virus.item.plague.TheNecora.CanNot;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RecipeGodDNA  extends CustomRecipe {
    private final CraftingBookCategory category;


    public RecipeGodDNA(CraftingBookCategory category) {
        super(category);
        this.category = category;
    }
    @Override
    public @NotNull CraftingBookCategory category() {
        return category;
    }


    @Override
    public boolean matches(CraftingInput craftingInput, @NotNull Level level) {
        int count = 0;
        List<Item> arrayList = new ArrayList<>();

        for (int i = 0; i < craftingInput.size(); ++i) {
            ItemStack currentStack = craftingInput.getItem(i);
            arrayList.add(currentStack.getItem());
            if (!(currentStack.getItem() instanceof CanNot)) {
                if (currentStack.get(DataReg.tag) != null && currentStack.get(DataReg.tag).getBoolean(NewEvent.lootTable)) {
                    count++;
                    if (count > 2) {
                        return false;
                    }
                }
            }
        }
        if (arrayList.size()>2){
            return false;
        }
        return count == 2;
    }




    @Override
    public @NotNull ItemStack assemble(CraftingInput craftingInput, HolderLookup.Provider provider) {
        int count = 0;
        for (int i = 0; i < craftingInput.size(); ++i) {
            ItemStack currentStack = craftingInput.getItem(i);
            if (currentStack.get(DataReg.tag) != null && currentStack.get(DataReg.tag).getBoolean(NewEvent.lootTable)) {
                count++;
                if (count == 2) {
                    ItemStack stack = currentStack.copy();
                    CompoundTag compoundTag = new CompoundTag();
                    compoundTag.putBoolean(EquippedEvt.isGod, true);
                    stack.set(DataReg.tag, compoundTag);
                    return stack;
                }
            }
        }
        return ItemStack.EMPTY;
    }


    @Override

    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= 2;
    }


    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return AllCrafting.DNA.get();
    }
}


