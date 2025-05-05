package com.ytgld.seeking_immortal_virus.crafting.models;

import com.ytgld.seeking_immortal_virus.init.items.BookItems;
import com.ytgld.seeking_immortal_virus.init.items.DNAItems;
import com.ytgld.seeking_immortal_virus.init.items.Items;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ItemModelGen extends ItemModelProvider {

    public ItemModelGen(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }


    public void run() {
        this.basicItem(Items.ectoplasmball.get());
        this.basicItem(Items.ectoplasmapple.get());
        this.basicItem(Items.ectoplasmcloub.get());
        this.basicItem(Items.ectoplasmcube.get());
        this.basicItem(Items.ectoplasmhorseshoe.get());
        this.basicItem(Items.ectoplasmprism.get());
        this.basicItem(Items.ectoplasmbattery.get());
        this.basicItem(Items.ectoplasmshild.get());
        this.basicItem(Items.bloodvirus.get());
        this.basicItem(Items.necora.get());
        this.basicItem(Items.dna_box.get());
        this.basicItem(Items.crafting_box.get());
        this.basicItem(Items.deceased_contract.get());
        this.basicItem(Items.ytgld_virus.get());
        this.basicItem(Items.run_dna.get());
        this.basicItem(Items.health_dna.get());
        this.basicItem(Items.neuron_dna.get());
        this.basicItem(Items.eye_dna.get());
        this.basicItem(Items.skin_dna.get());
        this.basicItem(Items.muscle_conversion.get());
        this.basicItem(Items.phosphate_bond.get());
        this.basicItem(Items.chemical_compound.get());
        this.basicItem(Items.skin_glucose_fermentation.get());
        this.basicItem(Items.white_blood_cells_are_abruptly_reduced.get());
        this.basicItem(Items.copy_dna.get());
        this.basicItem(Items.attack_dna.get());
        this.basicItem(Items.greed_dna.get());
        this.basicItem(Items.eye_lava_dna.get());
        this.basicItem(Items.bone_dna.get());


        this.basicItem(BookItems.weak.get());
        this.basicItem(BookItems.spore_outbreak.get());
        this.basicItem(BookItems.plague_book.get());
        this.basicItem(BookItems.exercise_reinforcement.get());
        this.basicItem(BookItems.detect.get());
        this.basicItem(BookItems.bloodstain.get());
        this.basicItem(BookItems.blood_stasis.get());
        this.basicItem(BookItems.bone_structure.get());
        this.basicItem(BookItems.mummification.get());
        this.basicItem(BookItems.tumour.get());
        this.basicItem(BookItems.organizational_regeneration.get());


        this.basicItem(DNAItems.cell_compress.get());
        this.basicItem(DNAItems.cell_preferential.get());
        this.basicItem(DNAItems.cell_flu.get());
        this.basicItem(DNAItems.cell_constant.get());
        this.basicItem(DNAItems.cell_chromosome.get());
        this.basicItem(DNAItems.cell_necrosis.get());
        this.basicItem(DNAItems.cell_digestion.get());
        this.basicItem(DNAItems.cell_acid.get());
        this.basicItem(DNAItems.cell_eyes.get());
        this.basicItem(DNAItems.cell_bone_add.get());
        this.basicItem(DNAItems.cell_sense.get());
        this.basicItem(DNAItems.cell_cranial.get());
        this.basicItem(DNAItems.cell_dna_suppression.get());
        this.basicItem(DNAItems.cell_putrefactive.get());
        this.basicItem(DNAItems.cell_synthesis.get());
        this.basicItem(DNAItems.atp_height.get());
        this.basicItem(DNAItems.cell_god.get());
        this.basicItem(DNAItems.cell_ground.get());
        this.basicItem(DNAItems.cell_inheritance.get());
        this.basicItem(DNAItems.cell_oxygen.get());
        this.basicItem(DNAItems.cell_big_boom.get());
        this.basicItem(DNAItems.cell_break_down_water.get());
        this.basicItem(DNAItems.cell_darwin.get());
        this.basicItem(DNAItems.cell_disorder.get());
        this.basicItem(DNAItems.cell_in_air.get());
        this.basicItem(DNAItems.cell_in_water.get());
        this.basicItem(DNAItems.cell_off_on.get());
        this.basicItem(DNAItems.speed_metabolism.get());


        this.basicItem(Items.dna.get());
        this.basicItem(Items.fungus.get());
        this.basicItem(Items.germ.get());
        this.basicItem(Items.parasite.get());
        this.basicItem(Items.virus.get());
        this.basicItem(Items.cell.get());
        this.basicItem(Items.adrenaline.get());
        this.basicItem(Items.cell_mummy.get());
        this.basicItem(Items.cell_boom.get());
        this.basicItem(Items.cell_calcification.get());
        this.basicItem(Items.cell_blood.get());
        this.basicItem(Items.air.get());
        this.basicItem(Items.motor.get());
        this.basicItem(Items.watergen.get());
        this.basicItem(Items.giant.get());
        this.basicItem(Items.giant_nightmare.get());
        this.basicItem(Items.giant_boom_cell.get());
        this.basicItem(Items.anaerobic_cell.get());
        this.basicItem(Items.disgusting_cells.get());
        this.basicItem(Items.bone_cell.get());
        this.basicItem(Items.mother_cell.get());
        this.basicItem(Items.parasitic_cell.get());
        this.basicItem(Items.subspace_cell.get());
        this.basicItem(Items.botton.get());
        this.basicItem(Items.catalyzer.get());
        this.basicItem(Items.batskill.get());
        this.basicItem(Items.batgene.get());
        this.basicItem(Items.bloodgene.get());
        this.basicItem(Items.flygene.get());
        this.basicItem(Items.heathgene.get());
        this.basicItem(Items.ragegene.get());
        this.basicItem(Items.sleepgene.get());
        this.basicItem(Items.apple.get());
        this.basicItem(Items.medicinebox.get());
        this.basicItem(Items.calcification.get());
        this.basicItem(Items.masticatory.get());
        this.basicItem(Items.polyphagia.get());
        this.basicItem(Items.quadriceps.get());
        this.basicItem(Items.reanimation.get());
        this.basicItem(Items.god_ambush.get());
        this.basicItem(Items.god_atpoverdose.get());
        this.basicItem(Items.god_putrefactive.get());
        this.basicItem(Items.god_fermentation.get());
        this.basicItem(Items.god_autolytic.get());
        this.basicItem(Items.god_regenerative.get());
        this.basicItem(Items.ambush.get());
        this.basicItem(Items.atpoverdose.get());
        this.basicItem(Items.autolytic.get());
        this.basicItem(Items.fermentation.get());
        this.basicItem(Items.putrefactive.get());
        this.basicItem(Items.regenerative.get());
        this.basicItem(Items.bat_cell.get());
        this.basicItem(Items.cell_blood_attack.get());
        this.basicItem(Items.cell_desecrate.get());
        this.basicItem(Items.cell_doctor.get());
        this.basicItem(Items.cell_fear.get());
        this.basicItem(Items.cell_harvest.get());
        this.basicItem(Items.cell_immortal.get());
        this.basicItem(Items.cell_not_do.get());
        this.basicItem(Items.cell_rage.get());
        this.basicItem(Items.cell_scientist.get());


    }


    @Override
    protected void registerModels() {
        run();
    }
}
