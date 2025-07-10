package com.ytgld.seeking_immortal_virus.init.items;

import com.ytgld.seeking_immortal_virus.SeekingImmortalVirus;
import com.ytgld.seeking_immortal_virus.item.ManDNA;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class Drugs {
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(BuiltInRegistries.ITEM, SeekingImmortalVirus.MODID);
    public static final DeferredHolder<Item, ?> protein = REGISTRY.register("protein", ()->new ManDNA.Drug(List.of("item.protein.seeking_immortal_virus.tool.string")));
    public static final DeferredHolder<Item, ?> hydrolysis = REGISTRY.register("hydrolysis", ()->new ManDNA.Drug(List.of("item.hydrolysis.seeking_immortal_virus.tool.string")));
    public static final DeferredHolder<Item, ?> cp_energy = REGISTRY.register("cp_energy", ()->new ManDNA.Drug(List.of("item.cp_energy.seeking_immortal_virus.tool.string")));
    public static final DeferredHolder<Item, ?> phosphorylation = REGISTRY.register("phosphorylation", ()->new ManDNA.Drug(List.of("item.phosphorylation.seeking_immortal_virus.tool.string")));

    public static final DeferredHolder<Item, ?> stem_cell_proliferation = REGISTRY.register("stem_cell_proliferation", ()->new ManDNA.Drug(List.of("item.stem_cell_proliferation.seeking_immortal_virus.tool.string")));
    public static final DeferredHolder<Item, ?> lymphatic = REGISTRY.register("lymphatic", ()->new ManDNA.Drug(List.of("item.lymphatic.seeking_immortal_virus.tool.string")));
    public static final DeferredHolder<Item, ?> abnormal = REGISTRY.register("abnormal", ()->new ManDNA.Drug(List.of("item.abnormal.seeking_immortal_virus.tool.string")));
    public static final DeferredHolder<Item, ?> catalyst_for_life = REGISTRY.register("catalyst_for_life", ()->new ManDNA.Drug(List.of("item.catalyst_for_life.seeking_immortal_virus.tool.string")));



    public static final DeferredHolder<Item, ?> lymphadenopathy = REGISTRY.register("lymphadenopathy", ()->new ManDNA.Drug(List.of("item.lymphadenopathy.seeking_immortal_virus.tool.string")));
    public static final DeferredHolder<Item, ?> connective_tissue = REGISTRY.register("connective_tissue", ()->new ManDNA.Drug(List.of("item.connective_tissue.seeking_immortal_virus.tool.string")));
    public static final DeferredHolder<Item, ?> paralysis = REGISTRY.register("paralysis", ()->new ManDNA.Drug(List.of("item.paralysis.seeking_immortal_virus.tool.string")));
    public static final DeferredHolder<Item, ?> formative_cell = REGISTRY.register("formative_cell", ()->new ManDNA.Drug(List.of("item.formative_cell.seeking_immortal_virus.tool.string")));




    public static final DeferredHolder<Item, ?> reverse_correction = REGISTRY.register("reverse_correction", ()->new ManDNA.Drug(List.of("item.reverse_correction.seeking_immortal_virus.tool.string")));
    public static final DeferredHolder<Item, ?> self_correction = REGISTRY.register("self_correction", ()->new ManDNA.Drug(List.of("item.self_correction.seeking_immortal_virus.tool.string")));
    public static final DeferredHolder<Item, ?> abnormal_muscles = REGISTRY.register("abnormal_muscles", ()->new ManDNA.Drug(List.of("item.abnormal_muscles.seeking_immortal_virus.tool.string")));
    public static final DeferredHolder<Item, ?> abnormal_endurance = REGISTRY.register("abnormal_endurance", ()->new ManDNA.Drug(List.of("item.abnormal_endurance.seeking_immortal_virus.tool.string")));


    public static final DeferredHolder<Item, ?> iris = REGISTRY.register("iris", ()->new ManDNA.Drug(List.of("item.iris.seeking_immortal_virus.tool.string","item.iris.seeking_immortal_virus.tool.string.1")));
    public static final DeferredHolder<Item, ?> brain_off = REGISTRY.register("brain_off", ()->new ManDNA.Drug(List.of("item.brain_off.seeking_immortal_virus.tool.string","item.brain_off.seeking_immortal_virus.tool.string.1")));
    public static final DeferredHolder<Item, ?> brain_enhance = REGISTRY.register("brain_enhance", ()->new ManDNA.Drug(List.of("item.brain_enhance.seeking_immortal_virus.tool.string")));




    public static final DeferredHolder<Item, ?> system_paralysis = REGISTRY.register("system_paralysis", ()->new ManDNA.Drug(List.of("item.system_paralysis.seeking_immortal_virus.tool.string","item.system_paralysis.seeking_immortal_virus.tool.string.1")));
    public static final DeferredHolder<Item, ?> memory = REGISTRY.register("memory", ()->new ManDNA.Drug(List.of("item.memory.seeking_immortal_virus.tool.string","item.memory.seeking_immortal_virus.tool.string.1")));
    public static final DeferredHolder<Item, ?> tissue_atrophy = REGISTRY.register("tissue_atrophy", ()->new ManDNA.Drug(List.of("item.tissue_atrophy.seeking_immortal_virus.tool.string","item.tissue_atrophy.seeking_immortal_virus.tool.string.1")));







    public static final DeferredHolder<Item, ?> eye_system = REGISTRY.register("eye_system", ()->new ManDNA.Drug(List.of("item.eye_system.seeking_immortal_virus.tool.string")));




    public static final DeferredHolder<Item, ?> scale = REGISTRY.register("scale", ()->new ManDNA.Drug(List.of("item.scale.seeking_immortal_virus.tool.string")));
    public static final DeferredHolder<Item, ?> stone_skin = REGISTRY.register("stone_skin", ()->new ManDNA.Drug(List.of("item.stone_skin.seeking_immortal_virus.tool.string")));
    public static final DeferredHolder<Item, ?> molt = REGISTRY.register("molt", ()->new ManDNA.Drug(List.of("item.molt.seeking_immortal_virus.tool.string")));




    public static final DeferredHolder<Item, ?> bone_spur = REGISTRY.register("bone_spur", ()->new ManDNA.Drug(List.of("item.bone_spur.seeking_immortal_virus.tool.string")));
    public static final DeferredHolder<Item, ?> hollow = REGISTRY.register("hollow", ()->new ManDNA.Drug(List.of("item.hollow.seeking_immortal_virus.tool.string")));
    public static final DeferredHolder<Item, ?> proliferative_bone = REGISTRY.register("proliferative_bone", ()->new ManDNA.Drug(List.of("item.proliferative_bone.seeking_immortal_virus.tool.string")));

}
