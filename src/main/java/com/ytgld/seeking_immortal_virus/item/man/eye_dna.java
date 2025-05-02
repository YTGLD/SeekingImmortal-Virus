package com.ytgld.seeking_immortal_virus.item.man;

import com.ytgld.seeking_immortal_virus.contents.ManBundleContents;
import com.ytgld.seeking_immortal_virus.init.items.Drugs;
import com.ytgld.seeking_immortal_virus.init.moonstoneitem.DataReg;
import com.ytgld.seeking_immortal_virus.item.ManDNA;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.SlotContext;

import java.util.List;

public class eye_dna extends ManDNA {

    public eye_dna() {
        super(new Properties().stacksTo(1).rarity(Rarity.RARE).component(DataReg.man, ManBundleContents.EMPTY));
    }

    @Override
    public int getSize() {
        return 2;
    }
    @Override
    public @Nullable List<Item> getDrug() {
        return List.of(
                Drugs.eye_system.get()
        );
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        super.curioTick(slotContext, stack);
        ManBundleContents manBundleContents = stack.get(DataReg.man);
        if (manBundleContents != null) {
            manBundleContents.items().forEach((itemStack -> {
                if (itemStack.is(Drugs.eye_system)) {
                    slotContext.entity().addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION,1200,0,false,false));
                }
            }));
        }

    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        pTooltipComponents.add(Component.translatable("item.eye_dna.tool.string").withStyle(ChatFormatting.GOLD));

        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
