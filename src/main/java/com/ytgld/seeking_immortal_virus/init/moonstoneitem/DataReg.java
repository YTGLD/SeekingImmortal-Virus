package com.ytgld.seeking_immortal_virus.init.moonstoneitem;

import com.ytgld.seeking_immortal_virus.MoonStoneMod;
import com.ytgld.seeking_immortal_virus.contents.BundleContents;
import com.ytgld.seeking_immortal_virus.contents.BundleContentsDNA;
import com.ytgld.seeking_immortal_virus.contents.ManBundleContents;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DataReg {
    public static final DeferredRegister<DataComponentType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.DATA_COMPONENT_TYPE, MoonStoneMod.MODID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<CompoundTag>> tag =
            REGISTRY.register("tag",()-> DataComponentType.<CompoundTag>builder().persistent(CompoundTag.CODEC).build());
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<BundleContents>> BUNDLE_CONTENTS =
            REGISTRY.register("bundle",()-> DataComponentType.<BundleContents>builder().persistent(BundleContents.CODEC).build());

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<BundleContentsDNA>> SUPER_BAG =
            REGISTRY.register("dna",()-> DataComponentType.<BundleContentsDNA>builder().persistent(BundleContentsDNA.CODEC).build());
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<ManBundleContents>> man =
            REGISTRY.register("man",()-> DataComponentType.<ManBundleContents>builder().persistent(ManBundleContents.CODEC).build());



}


