package com.ytgld.seeking_immortal_virus.item.man;

import com.ytgld.seeking_immortal_virus.Handler;
import com.ytgld.seeking_immortal_virus.contents.ManBundleContents;
import com.ytgld.seeking_immortal_virus.entity.extend.MoonTamableAnimal;
import com.ytgld.seeking_immortal_virus.init.items.Items;
import com.ytgld.seeking_immortal_virus.init.moonstoneitem.DataReg;
import com.ytgld.seeking_immortal_virus.init.moonstoneitem.i.Iplague;
import com.ytgld.seeking_immortal_virus.item.ManDNA;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.event.entity.living.LivingHealEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 *
 * 肌糖原酵解
 * <p>
 * 召唤的僵尸被杀死时
 * <p>
 * 攻击者会受到基于僵尸50%最大生命值和护甲总和的伤害
 */


public class white_blood_cells_are_abruptly_reduced extends ManDNA implements Iplague {
    public white_blood_cells_are_abruptly_reduced() {
        super(new Properties().stacksTo(1).rarity(Rarity.RARE).component(DataReg.man,
                ManBundleContents.EMPTY));
    }
    @Override
    public int getSize() {
        return 2;
    }
    @Override
    public @Nullable List<Item> getDrug() {
        return List.of();
    }
    public static void dieZombie(LivingHealEvent event, int size){
        if (event.getEntity() instanceof MoonTamableAnimal moonTamableAnimal){
            if (moonTamableAnimal.getOwner() instanceof Player player){
                if (Handler.hascurio(player, Items.white_blood_cells_are_abruptly_reduced.get())){
                    float a = size / 100f;
                    player.heal(event.getAmount()*a);
                    event.setAmount(0);
                }
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("item.white_blood_cells_are_abruptly_reduced.tool.string").withStyle(ChatFormatting.GOLD));
        tooltipComponents.add(Component.translatable("item.white_blood_cells_are_abruptly_reduced.tool.string.1").withStyle(ChatFormatting.GOLD));

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}

