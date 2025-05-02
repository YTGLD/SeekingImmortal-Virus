package com.ytgld.seeking_immortal_virus.item.man;

import com.ytgld.seeking_immortal_virus.Handler;
import com.ytgld.seeking_immortal_virus.contents.ManBundleContents;
import com.ytgld.seeking_immortal_virus.entity.extend.MoonTamableAnimal;
import com.ytgld.seeking_immortal_virus.init.items.Items;
import com.ytgld.seeking_immortal_virus.init.moonstoneitem.DataReg;
import com.ytgld.seeking_immortal_virus.init.moonstoneitem.i.Iplague;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.living.LivingHealEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 *高能磷酸键断裂：
 * 		召唤的僵尸死亡后回复玩家10%最大生命值
 * 		召唤的僵尸最少能承受5次伤害
 */
public class phosphate_bond extends ManDNA implements Iplague {
    public phosphate_bond() {
        super(new Properties().stacksTo(1).rarity(Rarity.RARE).component(DataReg.man,
                ManBundleContents.EMPTY));
    }
    @Override
    public @Nullable List<Item> getDrug() {
        return List.of();
    }
    public static void dieZombie(LivingDeathEvent event, int heal){
        if (event.getEntity() instanceof MoonTamableAnimal moonTamableAnimal){
            if (moonTamableAnimal.getOwner() instanceof Player player){
                if (Handler.hascurio(player, Items.phosphate_bond.get())){
                    float a = heal / 100f;

                    player.heal(player.getMaxHealth()*a);
                }
            }
        }
    }
    public static void healZombie(LivingHealEvent event){
        if (event.getEntity() instanceof MoonTamableAnimal moonTamableAnimal){
            if (moonTamableAnimal.getOwner() instanceof Player player){
                if (Handler.hascurio(player, Items.phosphate_bond.get())){
                    event.setAmount(0);

                }
            }
        }
    }

    public static void damage5(LivingIncomingDamageEvent event,int size){
        if (event.getEntity() instanceof MoonTamableAnimal moonTamableAnimal){
            if (moonTamableAnimal.getOwner() instanceof Player player){
                if (Handler.hascurio(player, Items.phosphate_bond.get())){

                    if (event.getAmount()>moonTamableAnimal.getMaxHealth()/size){
                        event.setAmount(moonTamableAnimal.getMaxHealth()/size);
                    }
                }
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("item.phosphate_bond.tool.string").withStyle(ChatFormatting.GOLD));
        tooltipComponents.add(Component.translatable("item.phosphate_bond.tool.string.1").withStyle(ChatFormatting.GOLD));
        tooltipComponents.add(Component.translatable("item.phosphate_bond.tool.string.2").withStyle(ChatFormatting.GOLD));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}

