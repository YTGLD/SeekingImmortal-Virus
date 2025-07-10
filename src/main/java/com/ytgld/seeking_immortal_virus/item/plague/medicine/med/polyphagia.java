package com.ytgld.seeking_immortal_virus.item.plague.medicine.med;

import com.ytgld.seeking_immortal_virus.init.moonstoneitem.extend.medIC;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class polyphagia extends medIC {
    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
        pTooltipComponents.add(Component.translatable("item.polyphagia.seeking_immortal_virus.tool.string").withStyle(ChatFormatting.DARK_RED).withStyle(ChatFormatting.BOLD));
        if (Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.translatable("item.polyphagia.seeking_immortal_virus.tool.string.1").withStyle(ChatFormatting.RED));
        } else {
            pTooltipComponents.add(Component.translatable(""));
            pTooltipComponents.add(Component.literal("SHIFT").withStyle(ChatFormatting.DARK_RED).withStyle(ChatFormatting.BOLD));
        }
    }

}

