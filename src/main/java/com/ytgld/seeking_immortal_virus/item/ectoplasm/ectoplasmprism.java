package com.ytgld.seeking_immortal_virus.item.ectoplasm;

import com.ytgld.seeking_immortal_virus.init.moonstoneitem.i.IEctoplasm;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class ectoplasmprism extends Item implements IEctoplasm {
    public ectoplasmprism() {
        super(new Properties().stacksTo(64).rarity(Rarity.EPIC));
    }
}

