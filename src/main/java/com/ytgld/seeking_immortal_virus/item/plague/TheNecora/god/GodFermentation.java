package com.ytgld.seeking_immortal_virus.item.plague.TheNecora.god;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.ytgld.seeking_immortal_virus.init.items.Items;
import com.ytgld.seeking_immortal_virus.init.moonstoneitem.AttReg;
import com.ytgld.seeking_immortal_virus.init.moonstoneitem.i.GodDNA;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import top.theillusivec4.curios.api.SlotContext;

import java.util.List;

public class GodFermentation  extends GodDNA {


    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(SlotContext slotContext, ResourceLocation id, ItemStack stack) {
        Multimap<Holder<Attribute>, AttributeModifier>modifierMultimap = HashMultimap.create();
        modifierMultimap.put(AttReg.cit, new AttributeModifier(id, 0.25f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        modifierMultimap.put(AttReg.alL_attack, new AttributeModifier(id, 0.1f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        return modifierMultimap;
    }


    @Override
    public Item getNotEquippedItem() {
        return Items.fermentation.get();
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
        pTooltipComponents.add(Component.literal(""));
        pTooltipComponents.add(Component.translatable("item.fermentation.seeking_immortal_virus.tool.string").withStyle(ChatFormatting.RED));
        pTooltipComponents.add(Component.translatable("item.fermentation.seeking_immortal_virus.tool.string.1").withStyle(ChatFormatting.RED));
        pTooltipComponents.add(Component.translatable("item.fermentation.seeking_immortal_virus.tool.string.2").withStyle(ChatFormatting.RED));
        pTooltipComponents.add(Component.literal(""));
    }
}


