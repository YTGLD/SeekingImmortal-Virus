package com.ytgld.seeking_immortal_virus.init.moonstoneitem.extend;

import com.ytgld.seeking_immortal_virus.init.moonstoneitem.i.IDoom;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class Perhaps extends Item implements ICurioItem, IDoom {
    public Perhaps() {
        super(new Properties().stacksTo(1).rarity(Rarity.RARE));
    }

}
