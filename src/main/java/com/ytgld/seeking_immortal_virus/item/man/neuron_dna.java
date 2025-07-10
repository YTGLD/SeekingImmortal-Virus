package com.ytgld.seeking_immortal_virus.item.man;

import com.ytgld.seeking_immortal_virus.contents.ManBundleContents;
import com.ytgld.seeking_immortal_virus.init.items.Drugs;
import com.ytgld.seeking_immortal_virus.init.moonstoneitem.DataReg;
import com.ytgld.seeking_immortal_virus.item.ManDNA;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.LootContext;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.living.LivingDropsEvent;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.inventory.ICurioStacksHandler;
import top.theillusivec4.curios.api.type.inventory.IDynamicStackHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class neuron_dna  extends ManDNA {

    /*
        神经元强化基因：（栏位：人类基因槽）
        减少1级时运和抢夺
	    增加5%掠夺暴击率
	    杀死生物根据此暴击率触发掠夺暴击并使掉落战利品数量翻倍
     */
    public neuron_dna() {
        super(new Properties().stacksTo(1).rarity(Rarity.RARE).component(DataReg.man, ManBundleContents.EMPTY));
    }

    @Override
    public int getSize() {
        return 2;
    }
    public static final String name = "Name";
    public static final String lootL = "LootLvl";

    @Override
    public @Nullable List<Item> getDrug() {
        return List.of(
                Drugs.system_paralysis.get(),//神经系统瘫痪：抢夺等级减少1级,每级抢夺提供2%的掠夺暴击率
                Drugs.memory.get(),//记忆重构：杀死生物提供1%的掠夺暴击率，触发发掠夺暴击后概率清零
                Drugs.tissue_atrophy.get()//组织萎缩：增加3级时运和抢夺，战利品暴击率始终为0%
        );
    }
    public  static void memory(LivingDeathEvent event){
        if (event.getSource().getEntity() instanceof Player player) {
            CuriosApi.getCuriosInventory(player).ifPresent(handler -> {
                Map<String, ICurioStacksHandler> curios = handler.getCurios();
                for (Map.Entry<String, ICurioStacksHandler> entry : curios.entrySet()) {
                    ICurioStacksHandler stacksHandler = entry.getValue();
                    IDynamicStackHandler stackHandler = stacksHandler.getStacks();
                    for (int i = 0; i < stacksHandler.getSlots(); i++) {
                        ItemStack stack = stackHandler.getStackInSlot(i);
                        if (stack.getItem() instanceof neuron_dna) {
                            ManBundleContents manBundleContents = stack.get(DataReg.man);
                            if (manBundleContents != null) {
                                manBundleContents.items().forEach((itemStack -> {
                                    if (itemStack.is(Drugs.memory)) {
                                        if (stack.get(DataReg.tag) != null && stack.get(DataReg.tag).getInt(name) < 100) {
                                            stack.get(DataReg.tag).putInt(name, stack.get(DataReg.tag).getInt(name) + 1);
                                        } else {
                                            stack.set(DataReg.tag, new CompoundTag());
                                        }
                                    }
                                }));
                            }
                        }
                    }
                }
            });
        }
    }

    public  static void neuron_dna_main(LivingDropsEvent event){
        if (event.getSource().getEntity() instanceof Player player) {
            CuriosApi.getCuriosInventory(player).ifPresent(handler -> {
                Map<String, ICurioStacksHandler> curios = handler.getCurios();
                for (Map.Entry<String, ICurioStacksHandler> entry : curios.entrySet()) {
                    ICurioStacksHandler stacksHandler = entry.getValue();
                    IDynamicStackHandler stackHandler = stacksHandler.getStacks();
                    for (int i = 0; i < stacksHandler.getSlots(); i++) {
                        ItemStack stack = stackHandler.getStackInSlot(i);
                        if (stack.getItem() instanceof neuron_dna) {
                            if (stack.get(DataReg.tag) != null) {
                                ManBundleContents manBundleContents = stack.get(DataReg.man);
                                if (manBundleContents != null) {
                                    Holder.Reference<Enchantment> lootHolder = player.level().registryAccess()
                                            .registryOrThrow(Registries.ENCHANTMENT)
                                            .getHolderOrThrow(Enchantments.LOOTING);

                                    int loot = 0;
                                    loot += handler.getLootingLevel(null);
                                    int lv = 5;
                                    if (stack.get(DataReg.tag).getBoolean("system_paralysis")) {
                                        lv += ((player.getMainHandItem().getEnchantmentLevel(lootHolder) + loot) * 2);
                                    }
                                    if (stack.get(DataReg.tag).getBoolean("memory")) {
                                        lv += stack.get(DataReg.tag).getInt(name);
                                    }
                                    if (stack.get(DataReg.tag).getBoolean("tissue_atrophy")) {
                                        lv = 0;
                                    }
                                    if (new Random().nextInt(100) < lv) {
                                        List<ItemEntity> list = new ArrayList<>();
                                        for (ItemEntity entity : event.getDrops()) {
                                            ItemEntity item = entity.copy();
                                            list.add(item);
                                        }
                                        event.getDrops().addAll(list);
                                        if (stack.get(DataReg.tag) != null) {
                                            stack.get(DataReg.tag).remove(name);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            });
        }
    }
    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        super.curioTick(slotContext, stack);
        if (stack.get(DataReg.tag)!=null) {
            ManBundleContents manBundleContents = stack.get(DataReg.man);
            if (manBundleContents != null) {
                manBundleContents.items().forEach((itemStack -> {
                    stack.get(DataReg.tag).putBoolean("system_paralysis", itemStack.is(Drugs.system_paralysis));
                }));
            }
            if (manBundleContents != null) {
                manBundleContents.items().forEach((itemStack -> {
                    stack.get(DataReg.tag).putBoolean("memory", itemStack.is(Drugs.memory));
                }));
            }
            if (manBundleContents != null) {
                manBundleContents.items().forEach((itemStack -> {
                    stack.get(DataReg.tag).putBoolean("tissue_atrophy", itemStack.is(Drugs.tissue_atrophy));
                }));
            }
        }
    }
    @Override
    public int getLootingLevel(SlotContext slotContext, @Nullable LootContext lootContext, ItemStack stack) {
        int f = -1;
        if (stack.get(DataReg.tag)!=null) {
            if (stack.get(DataReg.tag).getBoolean("system_paralysis")) {
                f -= 1;
            }
            if (stack.get(DataReg.tag).getBoolean("tissue_atrophy")) {
                f += 2;
            }
        }
        return f;
    }

    @Override
    public int getFortuneLevel(SlotContext slotContext, LootContext lootContext, ItemStack stack) {
        int f = -1;
        if (stack.get(DataReg.tag)!=null) {
            if (stack.get(DataReg.tag).getBoolean("system_paralysis")) {
                f -= 1;
            }
            if (stack.get(DataReg.tag).getBoolean("tissue_atrophy")) {
                f += 2;
            }
        }
        return f;
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        pTooltipComponents.add(Component.translatable("item.neuron_dna.seeking_immortal_virus.tool.string").withStyle(ChatFormatting.GOLD));
        pTooltipComponents.add(Component.translatable("item.neuron_dna.seeking_immortal_virus.tool.string.1").withStyle(ChatFormatting.GOLD));
        pTooltipComponents.add(Component.translatable("item.neuron_dna.seeking_immortal_virus.tool.string.2").withStyle(ChatFormatting.GOLD));
        pTooltipComponents.add(Component.literal(""));
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
