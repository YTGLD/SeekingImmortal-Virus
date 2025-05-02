package com.ytgld.seeking_immortal_virus.init.moonstoneitem.extend;

import com.ytgld.seeking_immortal_virus.init.moonstoneitem.i.Iplague;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import top.theillusivec4.curios.api.CuriosApi;

import java.util.UUID;

public class apple extends Item implements Iplague {
    public apple() {
        super(new Properties().stacksTo(1).rarity(Rarity.UNCOMMON).food(
                new FoodProperties.Builder().alwaysEdible().nutrition(10).saturationModifier(1.0f).build()));
    }


    @Override
    public int getUseDuration(ItemStack pStack, LivingEntity p_344979_) {
        return 32;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack s, Level level, LivingEntity living) {
        ItemStack stack = super.finishUsingItem(s, level, living);
        if (living instanceof Player player){
            if (!player.getTags().contains("add_nec_moonstone")) {
                UUID uuid = UUID.fromString("00000000-0000-300f-95e1-2830b5159532");
                CuriosApi.getCuriosInventory(player).ifPresent(handler -> handler.getStacksHandler("necora").ifPresent(stacks -> {
                    if (!stacks.getModifiers().containsKey(uuid)) {
                        stacks.addPermanentModifier(new AttributeModifier(ResourceLocation.withDefaultNamespace("base_attack_damage"+this.getDescriptionId()),1, AttributeModifier.Operation.ADD_VALUE));
                    }
                }));

                player.addTag("add_nec_moonstone");
            }

            player.addEffect(new MobEffectInstance(MobEffects.HUNGER, 2000, 2));
        }
        return stack;
    }
}

