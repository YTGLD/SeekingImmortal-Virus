package com.ytgld.seeking_immortal_virus.init;


import com.ytgld.seeking_immortal_virus.MoonStoneMod;
import com.ytgld.seeking_immortal_virus.init.items.BookItems;
import com.ytgld.seeking_immortal_virus.init.items.DNAItems;
import com.ytgld.seeking_immortal_virus.init.items.Drugs;
import com.ytgld.seeking_immortal_virus.init.items.Items;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


public class Tab {

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MoonStoneMod.MODID);
    public static final DeferredHolder<CreativeModeTab,?> DNA = TABS.register("seeking_immortal_virus_item_dna",()->CreativeModeTab.builder()
            .icon(()->new ItemStack(Items.necora.get()))
            .title(Component.translatable("itemGroup.tabseeking_immortal_virus"))
            .displayItems((a,b)->{

                b.accept(new ItemStack(Items.ectoplasmball.get()));
                b.accept(new ItemStack(Items.ectoplasmapple.get()));
                b.accept(new ItemStack(Items.ectoplasmcloub.get()));
                b.accept(new ItemStack(Items.ectoplasmcube.get()));
                b.accept(new ItemStack(Items.ectoplasmhorseshoe.get()));
                b.accept(new ItemStack(Items.ectoplasmprism.get()));
                b.accept(new ItemStack(Items.ectoplasmbattery.get()));
                b.accept(new ItemStack(Items.ectoplasmshild.get()));

                b.accept(new ItemStack(Items.bloodvirus.get()));
                b.accept(new ItemStack(Items.necora.get()));
                b.accept(new ItemStack(Items.dna_box.get()));
                b.accept(new ItemStack(Items.crafting_box.get()));
                b.accept(new ItemStack(Items.deceased_contract.get()));
                b.accept(new ItemStack(Items.ytgld_virus.get()));
                b.accept(new ItemStack(Items.run_dna.get()));
                b.accept(new ItemStack(Items.health_dna.get()));
                b.accept(new ItemStack(Items.neuron_dna.get()));
                b.accept(new ItemStack(Items.eye_dna.get()));
                b.accept(new ItemStack(Items.skin_dna.get()));
                b.accept(new ItemStack(Items.muscle_conversion.get()));
                b.accept(new ItemStack(Items.phosphate_bond.get()));
                b.accept(new ItemStack(Items.chemical_compound.get()));
                b.accept(new ItemStack(Items.skin_glucose_fermentation.get()));
                b.accept(new ItemStack(Items.white_blood_cells_are_abruptly_reduced.get()));

                b.accept(new ItemStack(Items.copy_dna.get()));
                b.accept(new ItemStack(Items.attack_dna.get()));
                b.accept(new ItemStack(Items.greed_dna.get()));
                b.accept(new ItemStack(Items.eye_lava_dna.get()));
                b.accept(new ItemStack(Items.bone_dna.get()));


                b.accept(new ItemStack(BookItems.weak.get()));
                b.accept(new ItemStack(BookItems.spore_outbreak.get()));
                b.accept(new ItemStack(BookItems.plague_book.get()));
                b.accept(new ItemStack(BookItems.exercise_reinforcement.get()));
                b.accept(new ItemStack(BookItems.detect.get()));
                b.accept(new ItemStack(BookItems.bloodstain.get()));
                b.accept(new ItemStack(BookItems.blood_stasis.get()));
                b.accept(new ItemStack(BookItems.bone_structure.get()));
                b.accept(new ItemStack(BookItems.mummification.get()));
                b.accept(new ItemStack(BookItems.tumour.get()));
                b.accept(new ItemStack(BookItems.organizational_regeneration.get()));

                b.accept(new ItemStack(DNAItems.cell_compress.get()));
                b.accept(new ItemStack(DNAItems.cell_preferential.get()));
                b.accept(new ItemStack(DNAItems.cell_flu.get()));
                b.accept(new ItemStack(DNAItems.cell_constant.get()));
                b.accept(new ItemStack(DNAItems.cell_chromosome.get()));

                b.accept(new ItemStack(DNAItems.cell_necrosis.get()));
                b.accept(new ItemStack(DNAItems.cell_digestion.get()));
                b.accept(new ItemStack(DNAItems.cell_acid.get()));
                b.accept(new ItemStack(DNAItems.cell_eyes.get()));
                b.accept(new ItemStack(DNAItems.cell_bone_add.get()));
                b.accept(new ItemStack(DNAItems.cell_sense.get()));
                b.accept(new ItemStack(DNAItems.cell_cranial.get()));
                b.accept(new ItemStack(DNAItems.cell_dna_suppression.get()));
                b.accept(new ItemStack(DNAItems.cell_putrefactive.get()));
                b.accept(new ItemStack(DNAItems.cell_synthesis.get()));


                b.accept(new ItemStack(DNAItems.atp_height.get()));
                b.accept(new ItemStack(DNAItems.cell_god.get()));
                b.accept(new ItemStack(DNAItems.cell_ground.get()));
                b.accept(new ItemStack(DNAItems.cell_inheritance.get()));
                b.accept(new ItemStack(DNAItems.cell_oxygen.get()));
                b.accept(new ItemStack(DNAItems.cell_big_boom.get()));
                b.accept(new ItemStack(DNAItems.cell_break_down_water.get()));
                b.accept(new ItemStack(DNAItems.cell_darwin.get()));
                b.accept(new ItemStack(DNAItems.cell_disorder.get()));
                b.accept(new ItemStack(DNAItems.cell_in_air.get()));
                b.accept(new ItemStack(DNAItems.cell_in_water.get()));
                b.accept(new ItemStack(DNAItems.cell_off_on.get()));
                b.accept(new ItemStack(DNAItems.speed_metabolism.get()));









                b.accept(new ItemStack(Items.dna.get()));
                b.accept(new ItemStack(Items.fungus.get()));
                b.accept(new ItemStack(Items.germ.get()));
                b.accept(new ItemStack(Items.parasite.get()));
                b.accept(new ItemStack(Items.virus.get()));
                b.accept(new ItemStack(Items.cell.get()));
                b.accept(new ItemStack(Items.adrenaline.get()));
                b.accept(new ItemStack(Items.cell_mummy.get()));
                b.accept(new ItemStack(Items.cell_boom.get()));
                b.accept(new ItemStack(Items.cell_calcification.get()));
                b.accept(new ItemStack(Items.cell_blood.get()));
                b.accept(new ItemStack(Items.air.get()));
                b.accept(new ItemStack(Items.motor.get()));
                b.accept(new ItemStack(Items.watergen.get()));
                b.accept(new ItemStack(Items.giant.get()));
                b.accept(new ItemStack(Items.giant_nightmare.get()));

                b.accept(new ItemStack(Items.giant_boom_cell.get()));
                b.accept(new ItemStack(Items.anaerobic_cell.get()));
                b.accept(new ItemStack(Items.disgusting_cells.get()));
                b.accept(new ItemStack(Items.bone_cell.get()));
                b.accept(new ItemStack(Items.mother_cell.get()));
                b.accept(new ItemStack(Items.parasitic_cell.get()));
                b.accept(new ItemStack(Items.subspace_cell.get()));

                b.accept(new ItemStack(Items.botton.get()));
                b.accept(new ItemStack(Items.catalyzer.get()));


                b.accept(new ItemStack(Items.batskill.get()));


                b.accept(new ItemStack(Items.batgene.get()));
                b.accept(new ItemStack(Items.bloodgene.get()));
                b.accept(new ItemStack(Items.flygene.get()));
                b.accept(new ItemStack(Items.heathgene.get()));
                b.accept(new ItemStack(Items.ragegene.get()));
                b.accept(new ItemStack(Items.sleepgene.get()));


                b.accept(new ItemStack(Items.apple.get()));
                b.accept(new ItemStack(Items.medicinebox.get()));


                b.accept(new ItemStack(Items.calcification.get()));
                b.accept(new ItemStack(Items.masticatory.get()));
                b.accept(new ItemStack(Items.polyphagia.get()));
                b.accept(new ItemStack(Items.quadriceps.get()));
                b.accept(new ItemStack(Items.reanimation.get()));
                b.accept(new ItemStack(Items.god_ambush.get()));
                b.accept(new ItemStack(Items.god_atpoverdose.get()));
                b.accept(new ItemStack(Items.god_putrefactive.get()));
                b.accept(new ItemStack(Items.god_fermentation.get()));
                b.accept(new ItemStack(Items.god_autolytic.get()));
                b.accept(new ItemStack(Items.god_regenerative.get()));


                b.accept(new ItemStack(Items.ambush.get()));
                b.accept(new ItemStack(Items.atpoverdose.get()));
                b.accept(new ItemStack(Items.autolytic.get()));
                b.accept(new ItemStack(Items.fermentation.get()));
                b.accept(new ItemStack(Items.putrefactive.get()));
                b.accept(new ItemStack(Items.regenerative.get()));
                b.accept(new ItemStack(Items.bat_cell.get()));
                b.accept(new ItemStack(Items.cell_blood_attack.get()));
                b.accept(new ItemStack(Items.cell_desecrate.get()));
                b.accept(new ItemStack(Items.cell_doctor.get()));
                b.accept(new ItemStack(Items.cell_fear.get()));
                b.accept(new ItemStack(Items.cell_harvest.get()));
                b.accept(new ItemStack(Items.cell_immortal.get()));
                b.accept(new ItemStack(Items.cell_not_do.get()));
                b.accept(new ItemStack(Items.cell_rage.get()));
                b.accept(new ItemStack(Items.cell_scientist.get()));

                b.accept(new ItemStack(Drugs.protein.get()));
                b.accept(new ItemStack(Drugs.hydrolysis.get()));
                b.accept(new ItemStack(Drugs.cp_energy.get()));
                b.accept(new ItemStack(Drugs.phosphorylation.get()));
                b.accept(new ItemStack(Drugs.stem_cell_proliferation.get()));
                b.accept(new ItemStack(Drugs.lymphatic.get()));
                b.accept(new ItemStack(Drugs.abnormal.get()));
                b.accept(new ItemStack(Drugs.catalyst_for_life.get()));
                b.accept(new ItemStack(Drugs.lymphadenopathy.get()));
                b.accept(new ItemStack(Drugs.connective_tissue.get()));
                b.accept(new ItemStack(Drugs.paralysis.get()));
                b.accept(new ItemStack(Drugs.formative_cell.get()));
                b.accept(new ItemStack(Drugs.reverse_correction.get()));
                b.accept(new ItemStack(Drugs.self_correction.get()));
                b.accept(new ItemStack(Drugs.abnormal_muscles.get()));
                b.accept(new ItemStack(Drugs.abnormal_endurance.get()));
                b.accept(new ItemStack(Drugs.iris.get()));
                b.accept(new ItemStack(Drugs.brain_off.get()));
                b.accept(new ItemStack(Drugs.brain_enhance.get()));

                b.accept(new ItemStack(Drugs.system_paralysis.get()));
                b.accept(new ItemStack(Drugs.memory.get()));
                b.accept(new ItemStack(Drugs.tissue_atrophy.get()));


                b.accept(new ItemStack(Drugs.scale.get()));
                b.accept(new ItemStack(Drugs.stone_skin.get()));
                b.accept(new ItemStack(Drugs.molt.get()));


                b.accept(new ItemStack(Drugs.bone_spur.get()));
                b.accept(new ItemStack(Drugs.hollow.get()));
                b.accept(new ItemStack(Drugs.proliferative_bone.get()));


            })
            .build()
    );
}


