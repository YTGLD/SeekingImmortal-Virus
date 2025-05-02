package com.ytgld.seeking_immortal_virus.item.ectoplasm;

import com.ytgld.seeking_immortal_virus.init.moonstoneitem.i.IEctoplasm;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class ectoplasmcloub extends Item implements IEctoplasm {
    public ectoplasmcloub() {
        super(new Properties().stacksTo(64).rarity(Rarity.RARE).food(
                new FoodProperties.Builder().alwaysEdible().nutrition(8).saturationModifier(0.8f).build()));
    }
}
