package com.ytgld.seeking_immortal_virus.item.plague.TheNecora.bnabush.me;

import com.ytgld.seeking_immortal_virus.init.moonstoneitem.extend.TheNecoraIC;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class air extends TheNecoraIC {
    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
        pTooltipComponents.add(Component.translatable("item.air.seeking_immortal_virus.tool.string").withStyle(ChatFormatting.DARK_RED));
    }
}

