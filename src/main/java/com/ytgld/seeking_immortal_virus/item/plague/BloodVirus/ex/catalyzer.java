package com.ytgld.seeking_immortal_virus.item.plague.BloodVirus.ex;

import com.ytgld.seeking_immortal_virus.init.moonstoneitem.extend.BloodViru;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class catalyzer extends BloodViru {
    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
        pTooltipComponents.add(Component.translatable("item.catalyzer.seeking_immortal_virus.tool.string").withStyle(ChatFormatting.DARK_PURPLE));
    }
}
