package com.ytgld.seeking_immortal_virus.init.moonstoneitem.extend;

import com.ytgld.seeking_immortal_virus.init.moonstoneitem.i.IEctoplasm;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import org.jetbrains.annotations.NotNull;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class ectoplasm extends Item implements ICurioItem, IEctoplasm {
    public ectoplasm() {
        super(new Properties().stacksTo(1).rarity(Rarity.RARE).food(
                new FoodProperties.Builder().alwaysEdible().nutrition(8).saturationModifier(1.0f).build()));
    }

     @NotNull
    @Override
    public ICurio.DropRule getDropRule(SlotContext slotContext, DamageSource source, int lootingLevel, boolean recentlyHit, ItemStack stack) {
        return ICurio.DropRule.ALWAYS_KEEP;
    }

     /*
    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        if (slotContext.entity() instanceof Player player) {
            if (Handler.hascurio(player, stack.getItem())){
                return false;
            }
        }
        return true;
    }

     */
}
