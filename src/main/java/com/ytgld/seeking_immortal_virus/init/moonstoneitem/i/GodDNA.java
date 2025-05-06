package com.ytgld.seeking_immortal_virus.init.moonstoneitem.i;

import com.ytgld.seeking_immortal_virus.init.moonstoneitem.extend.TheNecoraIC;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public abstract class GodDNA  extends TheNecoraIC {
  public  abstract   Item getNotEquippedItem();

  @Override
  public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    if (Screen.hasControlDown()) {
      pTooltipComponents.add(Component.translatable("item.god.tool.string").withStyle(ChatFormatting.RED));
    }else {
      pTooltipComponents.add(Component.translatable("key.keyboard.left.control").withStyle(ChatFormatting.DARK_RED));
    }
  }
}
