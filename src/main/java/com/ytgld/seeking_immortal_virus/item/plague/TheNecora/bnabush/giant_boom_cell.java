package com.ytgld.seeking_immortal_virus.item.plague.TheNecora.bnabush;

import com.ytgld.seeking_immortal_virus.Handler;
import com.ytgld.seeking_immortal_virus.entity.nightmare_giant_to;
import com.ytgld.seeking_immortal_virus.init.items.Items;
import com.ytgld.seeking_immortal_virus.init.moonstoneitem.extend.TheNecoraIC;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

import java.util.List;

public class giant_boom_cell extends TheNecoraIC {
    public static void Boom(LivingIncomingDamageEvent event){
        if (event.getEntity() instanceof Player player){
            if (Handler.hascurio(player, Items.giant_boom_cell.get())){
                if (event.getSource().getEntity() instanceof nightmare_giant_to){
                    event.setAmount(0);
                }
            }
        }
    }
    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
        pTooltipComponents.add(Component.translatable("item.giant_boom_cell.seeking_immortal_virus.tool.string").withStyle(ChatFormatting.DARK_RED));

    }
}


