package com.ytgld.seeking_immortal_virus.init.moonstoneitem;

import com.ytgld.seeking_immortal_virus.SeekingImmortalVirus;
import com.ytgld.seeking_immortal_virus.effects.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Effects {
    public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, SeekingImmortalVirus.MODID);
    public static final DeferredHolder<MobEffect,?> rage  =REGISTRY.register("rage",()->new rage());
    public static final DeferredHolder<MobEffect,?> blood  =REGISTRY.register("blood",()->new blood());
    public static final DeferredHolder<MobEffect,?> fear  =REGISTRY.register("fear",()->new fear());
    public static final DeferredHolder<MobEffect,?> pain  =REGISTRY.register("pain",()->new pain());
    public static final DeferredHolder<MobEffect,?> nightmare  =REGISTRY.register("nightmare",()->new nightmare());
    public static final DeferredHolder<MobEffect,?> dead  =REGISTRY.register("dead",()->new dead());

}
