package com.ytgld.seeking_immortal_virus.init.items;

import com.ytgld.seeking_immortal_virus.SeekingImmortalVirus;
import com.ytgld.seeking_immortal_virus.init.moonstoneitem.extend.apple;
import com.ytgld.seeking_immortal_virus.init.moonstoneitem.extend.medicinebox;
import com.ytgld.seeking_immortal_virus.item.bloodvirus;
import com.ytgld.seeking_immortal_virus.item.decorated.*;
import com.ytgld.seeking_immortal_virus.item.ectoplasm.*;
import com.ytgld.seeking_immortal_virus.item.man.*;
import com.ytgld.seeking_immortal_virus.item.necora;
import com.ytgld.seeking_immortal_virus.item.plague.ALL.*;
import com.ytgld.seeking_immortal_virus.item.plague.BloodVirus.Skill.batskill;
import com.ytgld.seeking_immortal_virus.item.plague.BloodVirus.*;
import com.ytgld.seeking_immortal_virus.item.plague.BloodVirus.dna.*;
import com.ytgld.seeking_immortal_virus.item.plague.BloodVirus.ex.botton;
import com.ytgld.seeking_immortal_virus.item.plague.BloodVirus.ex.catalyzer;
import com.ytgld.seeking_immortal_virus.item.plague.TheNecora.*;
import com.ytgld.seeking_immortal_virus.item.plague.TheNecora.bnabush.*;
import com.ytgld.seeking_immortal_virus.item.plague.TheNecora.bnabush.me.air;
import com.ytgld.seeking_immortal_virus.item.plague.TheNecora.bnabush.me.motor;
import com.ytgld.seeking_immortal_virus.item.plague.TheNecora.bnabush.me.watergen;
import com.ytgld.seeking_immortal_virus.item.plague.TheNecora.god.*;
import com.ytgld.seeking_immortal_virus.item.plague.crafting_box;
import com.ytgld.seeking_immortal_virus.item.plague.medicine.med.*;
import com.ytgld.seeking_immortal_virus.item.ytgld_virus;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Items {
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(BuiltInRegistries.ITEM, SeekingImmortalVirus.MODID);
    public static final DeferredHolder<Item,?> ectoplasmapple  =REGISTRY.register("ectoplasmapple", ectoplasmapple::new);
    public static final DeferredHolder<Item,?> ectoplasmball  =REGISTRY.register("ectoplasmball", ectoplasmball::new);
    public static final DeferredHolder<Item,?> ectoplasmbattery  =REGISTRY.register("ectoplasmbattery", ectoplasmbattery::new);
    public static final DeferredHolder<Item,?> ectoplasmcloub  =REGISTRY.register("ectoplasmcloub", ectoplasmcloub::new);
    public static final DeferredHolder<Item,?> ectoplasmcube  =REGISTRY.register("ectoplasmcube", ectoplasmcube::new);
    public static final DeferredHolder<Item,?> ectoplasmhorseshoe  =REGISTRY.register("ectoplasmhorseshoe", ectoplasmhorseshoe::new);
    public static final DeferredHolder<Item,?> ectoplasmprism  =REGISTRY.register("ectoplasmprism", ectoplasmprism::new);
    public static final DeferredHolder<Item,?> ectoplasmshild  =REGISTRY.register("ectoplasmshild", ectoplasmshild::new);

    public static final DeferredHolder<Item,?>  dna =REGISTRY.register("dna",dna::new);
    public static final DeferredHolder<Item,?>  fungus =REGISTRY.register("fungus",fungus::new);
    public static final DeferredHolder<Item,?>  germ =REGISTRY.register("germ",germ::new);
    public static final DeferredHolder<Item,?>  parasite =REGISTRY.register("parasite",parasite::new);
    public static final DeferredHolder<Item,?>  virus =REGISTRY.register("virus",virus::new);
    public static final DeferredHolder<Item,?>  botton =REGISTRY.register("botton",botton::new);
    public static final DeferredHolder<Item,?>  catalyzer =REGISTRY.register("catalyzer",catalyzer::new);


    public static final DeferredHolder<Item,?>  calcification =REGISTRY.register("calcification",calcification::new);
    public static final DeferredHolder<Item,?>  masticatory =REGISTRY.register("masticatory",masticatory::new);
    public static final DeferredHolder<Item,?>  polyphagia =REGISTRY.register("polyphagia",polyphagia::new);
    public static final DeferredHolder<Item,?>  quadriceps =REGISTRY.register("quadriceps",quadriceps::new);
    public static final DeferredHolder<Item,?>  reanimation =REGISTRY.register("reanimation",reanimation::new);
    public static final DeferredHolder<Item,?>  batskill =REGISTRY.register("batskill",batskill::new);




    public static final DeferredHolder<Item,?> batgene =REGISTRY.register("batgene",batgene::new);
    public static final DeferredHolder<Item,?> bloodgene =REGISTRY.register("bloodgene",bloodgene::new);
    public static final DeferredHolder<Item,?> flygene =REGISTRY.register("flygene",flygene::new);
    public static final DeferredHolder<Item,?> heathgene =REGISTRY.register("heathgene",heathgene::new);
    public static final DeferredHolder<Item,?> ragegene =REGISTRY.register("ragegene",ragegene::new);
    public static final DeferredHolder<Item,?> sleepgene =REGISTRY.register("sleepgene",sleepgene::new);
    public static final DeferredHolder<Item,?> medicinebox =REGISTRY.register("medicinebox",medicinebox::new);
    public static final DeferredHolder<Item,?> apple =REGISTRY.register("apple",apple::new);




    public static final DeferredHolder<Item,?> ambush =REGISTRY.register("ambush", ambush::new);
    public static final DeferredHolder<Item,?> atpoverdose =REGISTRY.register("atpoverdose", atpoverdose::new);
    public static final DeferredHolder<Item,?> autolytic =REGISTRY.register("autolytic", autolytic::new);
    public static final DeferredHolder<Item,?> fermentation =REGISTRY.register("fermentation", fermentation::new);
    public static final DeferredHolder<Item,?> putrefactive =REGISTRY.register("putrefactive", putrefactive::new);
    public static final DeferredHolder<Item,?> regenerative =REGISTRY.register("regenerative", regenerative::new);


    public static final DeferredHolder<Item,?> bloodvirus =REGISTRY.register("bloodvirus",bloodvirus::new);
    public static final DeferredHolder<Item,?> necora =REGISTRY.register("necora",necora::new);
    public static final DeferredHolder<Item,?> cell =REGISTRY.register("cell", cell::new);
    public static final DeferredHolder<Item,?> adrenaline =REGISTRY.register("adrenaline", adrenaline::new);
    public static final DeferredHolder<Item,?> cell_mummy =REGISTRY.register("cell_mummy", cell_mummy::new);
    public static final DeferredHolder<Item,?> cell_boom =REGISTRY.register("cell_boom", cell_boom::new);
    public static final DeferredHolder<Item,?> cell_calcification =REGISTRY.register("cell_calcification", cell_calcification::new);
    public static final DeferredHolder<Item,?> cell_blood =REGISTRY.register("cell_blood", cell_blood::new);
    public static final DeferredHolder<Item,?> motor =REGISTRY.register("motor", motor::new);
    public static final DeferredHolder<Item,?> watergen =REGISTRY.register("watergen", watergen::new);
    public static final DeferredHolder<Item,?> air =REGISTRY.register("air", air::new);
    public static final DeferredHolder<Item,?> giant =REGISTRY.register("giant", giant::new);


    public static final DeferredHolder<Item,?> bat_cell =REGISTRY.register("bat_cell", bat_cell::new);
    public static final DeferredHolder<Item,?> cell_doctor =REGISTRY.register("cell_doctor", cell_doctor::new);
    public static final DeferredHolder<Item,?> cell_desecrate =REGISTRY.register("cell_desecrate", cell_desecrate::new);
    public static final DeferredHolder<Item,?> cell_harvest =REGISTRY.register("cell_harvest", cell_harvest::new);

    public static final DeferredHolder<Item,?> cell_scientist =REGISTRY.register("cell_scientist", cell_scientist::new);
    public static final DeferredHolder<Item,?> cell_immortal =REGISTRY.register("cell_immortal", cell_immortal::new);
    public static final DeferredHolder<Item,?> cell_rage =REGISTRY.register("cell_rage", cell_rage::new);
    public static final DeferredHolder<Item,?> cell_blood_attack =REGISTRY.register("cell_blood_attack", cell_blood_attack::new);
    public static final DeferredHolder<Item,?> cell_fear =REGISTRY.register("cell_fear", cell_fear::new);
    public static final DeferredHolder<Item,?> cell_not_do =REGISTRY.register("cell_not_do", cell_not_do::new);

    public static final DeferredHolder<Item,?> blood =REGISTRY.register("blood", ()-> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));
    public static final DeferredHolder<Item,?> deceased_contract =REGISTRY.register("deceased_contract", com.ytgld.seeking_immortal_virus.item.decorated.deceased_contract::new);


    public static final DeferredHolder<Item,?> anaerobic_cell =REGISTRY.register("anaerobic_cell", anaerobic_cell::new);
    public static final DeferredHolder<Item,?> giant_boom_cell =REGISTRY.register("giant_boom_cell", giant_boom_cell::new);
    public static final DeferredHolder<Item,?> subspace_cell =REGISTRY.register("subspace_cell", subspace_cell::new);
    public static final DeferredHolder<Item,?> bone_cell =REGISTRY.register("bone_cell", bone_cell::new);
    public static final DeferredHolder<Item,?> parasitic_cell =REGISTRY.register("parasitic_cell", parasitic_cell::new);
    public static final DeferredHolder<Item,?> mother_cell =REGISTRY.register("mother_cell", mother_cell::new);
    public static final DeferredHolder<Item,?> disgusting_cells =REGISTRY.register("disgusting_cells", disgusting_cells::new);

     public static final DeferredHolder<Item,?> dna_box =REGISTRY.register("dna_box", com.ytgld.seeking_immortal_virus.item.plague.dna.dna_box::new);

    public static final DeferredHolder<Item,?> crafting_box =REGISTRY.register("crafting_box", crafting_box::new);
    public static final DeferredHolder<Item,?> giant_nightmare =REGISTRY.register("giant_nightmare", giant_nightmare::new);



    public static final DeferredHolder<Item,?> god_ambush =REGISTRY.register("god_ambush", GodAmbush::new );
    public static final DeferredHolder<Item,?> god_atpoverdose =REGISTRY.register("god_atpoverdose", GodAtpoverdose::new );
    public static final DeferredHolder<Item,?> god_putrefactive =REGISTRY.register("god_putrefactive", GodPutrefactive::new );
    public static final DeferredHolder<Item,?> god_fermentation =REGISTRY.register("god_fermentation", GodFermentation::new );
    public static final DeferredHolder<Item,?> god_autolytic =REGISTRY.register("god_autolytic", GodAutolytic::new );
    public static final DeferredHolder<Item,?> god_regenerative =REGISTRY.register("god_regenerative", GodRegenerative::new );
    public static final DeferredHolder<Item,?> run_dna =REGISTRY.register("run_dna", run_dna::new );
    public static final DeferredHolder<Item,?> health_dna =REGISTRY.register("health_dna", health_dna::new );
    public static final DeferredHolder<Item,?> copy_dna =REGISTRY.register("copy_dna", copy_dna::new );
    public static final DeferredHolder<Item,?> attack_dna =REGISTRY.register("attack_dna", attack_dna::new );
    public static final DeferredHolder<Item,?> greed_dna =REGISTRY.register("greed_dna", greed_dna::new );
    public static final DeferredHolder<Item,?> neuron_dna =REGISTRY.register("neuron_dna", neuron_dna::new );
    public static final DeferredHolder<Item,?> eye_dna =REGISTRY.register("eye_dna", eye_dna::new );
    public static final DeferredHolder<Item,?> eye_lava_dna =REGISTRY.register("eye_lava_dna", eye_lava_dna::new );
    public static final DeferredHolder<Item,?> skin_dna =REGISTRY.register("skin_dna", skin_dna::new );
    public static final DeferredHolder<Item,?> bone_dna =REGISTRY.register("bone_dna", bone_dna::new );
    public static final DeferredHolder<Item,?> muscle_conversion =REGISTRY.register("muscle_conversion", com.ytgld.seeking_immortal_virus.item.decorated.muscle_conversion::new );
    public static final DeferredHolder<Item,?> phosphate_bond =REGISTRY.register("phosphate_bond", com.ytgld.seeking_immortal_virus.item.decorated.phosphate_bond::new );
    public static final DeferredHolder<Item,?> chemical_compound =REGISTRY.register("chemical_compound", com.ytgld.seeking_immortal_virus.item.decorated.chemical_compound::new );
    public static final DeferredHolder<Item,?> white_blood_cells_are_abruptly_reduced =REGISTRY.register("white_blood_cells_are_abruptly_reduced", white_blood_cells_are_abruptly_reduced::new );
    public static final DeferredHolder<Item,?> skin_glucose_fermentation =REGISTRY.register("skin_glucose_fermentation", com.ytgld.seeking_immortal_virus.item.decorated.skin_glucose_fermentation::new );

    public static final DeferredHolder<Item,?>  ytgld_virus =REGISTRY.register("ytgld_virus", ytgld_virus::new );
    public static final DeferredHolder<Item,?>  dehydration_condensation =REGISTRY.register("dehydration_condensation", dehydration_condensation::new );

    public static final DeferredHolder<Item,?> the_heart_image =REGISTRY.register("the_heart_image", ()-> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));
    public static final DeferredHolder<Item,?> medicinebox_ui =REGISTRY.register("medicinebox_ui", ()-> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));

}
