package com.ytgld.seeking_immortal_virus.item.plague.BloodVirus.dna;

import com.ytgld.seeking_immortal_virus.init.moonstoneitem.extend.BloodViru;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class cell_fear  extends BloodViru {
    @Override
    public void appendHoverText(ItemStack stack, TooltipContext pContext, List<Component> tooltip, TooltipFlag flags) {
        super.appendHoverText(stack, pContext, tooltip, flags);
        tooltip.add(Component.translatable("item.cell_fear.seeking_immortal_virus.tool.string").withStyle(ChatFormatting.RED));
    }
}

