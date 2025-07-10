package com.ytgld.seeking_immortal_virus.item.man;

import com.ytgld.seeking_immortal_virus.init.items.Drugs;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class eye_lava_dna extends eye_dna {
    @Override
    public int getSize() {
        return 3;
    }
    @Override
    public @Nullable List<Item> getDrug() {
        return List.of(
                Drugs.eye_system.get()
        );
    }
    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        pTooltipComponents.add(Component.translatable("item.eye_lava_dna.seeking_immortal_virus.tool.string").withStyle(ChatFormatting.GOLD));

        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}

