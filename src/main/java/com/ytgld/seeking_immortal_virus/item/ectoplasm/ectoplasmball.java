package com.ytgld.seeking_immortal_virus.item.ectoplasm;

import com.ytgld.seeking_immortal_virus.init.moonstoneitem.i.IEctoplasm;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class ectoplasmball extends Item implements IEctoplasm {
    public ectoplasmball() {
        super(new Properties().stacksTo(64).rarity(Rarity.RARE).food(
                new FoodProperties.Builder().alwaysEdible().nutrition(4).saturationModifier(0.6f).build()));
    }

}
