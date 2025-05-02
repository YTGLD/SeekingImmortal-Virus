package com.ytgld.seeking_immortal_virus.init.moonstoneitem;


import com.mojang.serialization.MapCodec;
import com.ytgld.seeking_immortal_virus.MoonStoneMod;
import com.ytgld.seeking_immortal_virus.event.loot.DungeonLoot;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class LootReg {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> REGISTRY = DeferredRegister.create(NeoForgeRegistries.GLOBAL_LOOT_MODIFIER_SERIALIZERS, MoonStoneMod.MODID);
    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, ?> TD = REGISTRY.register("dungeon",()->{
        return DungeonLoot.CODEC.get();
    });
}
