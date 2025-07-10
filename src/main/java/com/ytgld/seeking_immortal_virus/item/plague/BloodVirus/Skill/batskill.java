package com.ytgld.seeking_immortal_virus.item.plague.BloodVirus.Skill;

import com.ytgld.seeking_immortal_virus.init.moonstoneitem.extend.BloodViru;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class batskill extends BloodViru {
    public static String batskill = "batskill" ;
    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
        if (Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.translatable("item.batskill.seeking_immortal_virus.tool.string").withStyle(ChatFormatting.RED));
            pTooltipComponents.add(Component.translatable("item.batskill.seeking_immortal_virus.tool.string.1").withStyle(ChatFormatting.RED));
            pTooltipComponents.add(Component.translatable("item.batskill.seeking_immortal_virus.tool.string.2").withStyle(ChatFormatting.RED));
            pTooltipComponents.add(Component.translatable("item.batskill.seeking_immortal_virus.tool.string.3").withStyle(ChatFormatting.RED));
            pTooltipComponents.add(Component.translatable(""));
            pTooltipComponents.add(Component.translatable("item.batskill.seeking_immortal_virus.tool.string.4").withStyle(ChatFormatting.RED));


        } else {
            pTooltipComponents.add(Component.translatable("Shift").withStyle(ChatFormatting.DARK_RED));
        }
        pTooltipComponents.add(Component.translatable(""));
        pTooltipComponents.add(Component.translatable("item.batskill.seeking_immortal_virus.tool.string.5").withStyle(ChatFormatting.DARK_PURPLE));
    }
}
