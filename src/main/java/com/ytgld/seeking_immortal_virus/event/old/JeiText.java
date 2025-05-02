package com.ytgld.seeking_immortal_virus.event.old;

import com.ytgld.seeking_immortal_virus.MoonStoneMod;
import com.ytgld.seeking_immortal_virus.init.items.BookItems;
import com.ytgld.seeking_immortal_virus.init.items.Items;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;


@JeiPlugin
public class JeiText implements IModPlugin {
    private static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(MoonStoneMod.MODID, "jei_plugin");
    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return UID;
    }



    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        {

            registration.addIngredientInfo(new ItemStack(Items.cell.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.cell").append(Component.translatable("seeking_immortal_virus.jei.cell")));
            registration.addIngredientInfo(new ItemStack(Items.giant.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.giant").append(Component.translatable("seeking_immortal_virus.jei.giant")));
            registration.addIngredientInfo(new ItemStack(Items.giant_nightmare.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.giant_nightmare").append(Component.translatable("seeking_immortal_virus.jei.giant_nightmare")));

            registration.addIngredientInfo(new ItemStack(Items.ambush.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.ambush").append(Component.translatable("seeking_immortal_virus.jei.necora.all")));
            registration.addIngredientInfo(new ItemStack(Items.atpoverdose.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.atpoverdose").append(Component.translatable("seeking_immortal_virus.jei.necora.all")));
            registration.addIngredientInfo(new ItemStack(Items.autolytic.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.autolytic").append(Component.translatable("seeking_immortal_virus.jei.necora.all")));
            registration.addIngredientInfo(new ItemStack(Items.fermentation.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.fermentation").append(Component.translatable("seeking_immortal_virus.jei.necora.all")));
            registration.addIngredientInfo(new ItemStack(Items.putrefactive.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.putrefactive").append(Component.translatable("seeking_immortal_virus.jei.necora.all")));
            registration.addIngredientInfo(new ItemStack(Items.regenerative.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.regenerative").append(Component.translatable("seeking_immortal_virus.jei.necora.all")));

            registration.addIngredientInfo(new ItemStack(Items.air.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.air").append(Component.translatable("seeking_immortal_virus.jei.necora.treasure.all")));
            registration.addIngredientInfo(new ItemStack(Items.motor.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.motor").append(Component.translatable("seeking_immortal_virus.jei.necora.treasure.all")));
            registration.addIngredientInfo(new ItemStack(Items.watergen.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.watergen").append(Component.translatable("seeking_immortal_virus.jei.necora.treasure.all")));


            registration.addIngredientInfo(new ItemStack(Items.anaerobic_cell.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.anaerobic_cell").append(Component.translatable("seeking_immortal_virus.jei.necora.giant_nightmare.all")));
            registration.addIngredientInfo(new ItemStack(Items.giant_boom_cell.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.giant_boom_cell").append(Component.translatable("seeking_immortal_virus.jei.necora.giant_nightmare.all")));
            registration.addIngredientInfo(new ItemStack(Items.subspace_cell.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.subspace_cell").append(Component.translatable("seeking_immortal_virus.jei.necora.giant_nightmare.all")));

            registration.addIngredientInfo(new ItemStack(Items.cell_mummy.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.adrenaline").append(Component.translatable("seeking_immortal_virus.jei.cell.all")));
            registration.addIngredientInfo(new ItemStack(Items.cell_boom.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.cell_mummy").append(Component.translatable("seeking_immortal_virus.jei.cell.all")));
            registration.addIngredientInfo(new ItemStack(Items.cell_calcification.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.cell_boom").append(Component.translatable("seeking_immortal_virus.jei.cell.all")));
            registration.addIngredientInfo(new ItemStack(Items.cell_blood.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.cell_blood").append(Component.translatable("seeking_immortal_virus.jei.cell.all")));
            registration.addIngredientInfo(new ItemStack(Items.adrenaline.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.cell_calcification").append(Component.translatable("seeking_immortal_virus.jei.cell.all")));


            registration.addIngredientInfo(new ItemStack(Items.blood.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.blood").append(Component.literal(" : ")).append(Component.translatable("seeking_immortal_virus.jei.blood")));

            registration.addIngredientInfo(new ItemStack(Items.bloodvirus.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.bloodvirus").append(Component.literal(" : ")).append(Component.translatable("seeking_immortal_virus.jei.bloodvirus")));


            registration.addIngredientInfo(new ItemStack(Items.batgene.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.batgene").append(Component.literal(" : ")).append(Component.translatable("seeking_immortal_virus.jei.bloodvirus.all")));
            registration.addIngredientInfo(new ItemStack(Items.batskill.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.batskill").append(Component.literal(" : ")).append(Component.translatable("seeking_immortal_virus.jei.bloodvirus.all")));
            registration.addIngredientInfo(new ItemStack(Items.bloodgene.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.bloodgene").append(Component.literal(" : ")).append(Component.translatable("seeking_immortal_virus.jei.bloodvirus.all")));
            registration.addIngredientInfo(new ItemStack(Items.botton.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.botton").append(Component.literal(" : ")).append(Component.translatable("seeking_immortal_virus.jei.bloodvirus.all")));
            registration.addIngredientInfo(new ItemStack(Items.catalyzer.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.catalyzer").append(Component.literal(" : ")).append(Component.translatable("seeking_immortal_virus.jei.bloodvirus.all")));
            registration.addIngredientInfo(new ItemStack(Items.flygene.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.flygene").append(Component.literal(" : ")).append(Component.translatable("seeking_immortal_virus.jei.bloodvirus.all")));
            registration.addIngredientInfo(new ItemStack(Items.heathgene.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.heathgene").append(Component.literal(" : ")).append(Component.translatable("seeking_immortal_virus.jei.bloodvirus.all")));
            registration.addIngredientInfo(new ItemStack(Items.ragegene.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.ragegene").append(Component.literal(" : ")).append(Component.translatable("seeking_immortal_virus.jei.bloodvirus.all")));
            registration.addIngredientInfo(new ItemStack(Items.sleepgene.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.sleepgene").append(Component.literal(" : ")).append(Component.translatable("seeking_immortal_virus.jei.bloodvirus.all")));

            registration.addIngredientInfo(new ItemStack(Items.bat_cell.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.bat_cell").append(Component.literal(" : ")).append(Component.translatable("seeking_immortal_virus.jei.bloodvirus.treasure.all")));
            registration.addIngredientInfo(new ItemStack(Items.cell_blood_attack.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.cell_blood_attack").append(Component.literal(" : ")).append(Component.translatable("seeking_immortal_virus.jei.bloodvirus.treasure.all")));
            registration.addIngredientInfo(new ItemStack(Items.cell_desecrate.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.cell_desecrate").append(Component.literal(" : ")).append(Component.translatable("seeking_immortal_virus.jei.bloodvirus.treasure.all")));
            registration.addIngredientInfo(new ItemStack(Items.cell_doctor.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.cell_doctor").append(Component.literal(" : ")).append(Component.translatable("seeking_immortal_virus.jei.bloodvirus.treasure.all")));
            registration.addIngredientInfo(new ItemStack(Items.cell_fear.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.cell_fear").append(Component.literal(" : ")).append(Component.translatable("seeking_immortal_virus.jei.bloodvirus.treasure.all")));
            registration.addIngredientInfo(new ItemStack(Items.cell_harvest.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.cell_harvest").append(Component.literal(" : ")).append(Component.translatable("seeking_immortal_virus.jei.bloodvirus.treasure.all")));
            registration.addIngredientInfo(new ItemStack(Items.cell_immortal.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.cell_immortal").append(Component.literal(" : ")).append(Component.translatable("seeking_immortal_virus.jei.bloodvirus.treasure.all")));
            registration.addIngredientInfo(new ItemStack(Items.cell_not_do.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.cell_not_do").append(Component.literal(" : ")).append(Component.translatable("seeking_immortal_virus.jei.bloodvirus.treasure.all")));
            registration.addIngredientInfo(new ItemStack(Items.cell_rage.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.cell_rage").append(Component.literal(" : ")).append(Component.translatable("seeking_immortal_virus.jei.bloodvirus.treasure.all")));
            registration.addIngredientInfo(new ItemStack(Items.cell_scientist.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.cell_scientist").append(Component.literal(" : ")).append(Component.translatable("seeking_immortal_virus.jei.bloodvirus.treasure.all")));



            registration.addIngredientInfo(new ItemStack(Items.calcification.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.calcification").append(Component.literal(" : ")).append(Component.translatable("seeking_immortal_virus.jei.calcification")));
            registration.addIngredientInfo(new ItemStack(Items.masticatory.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.masticatory").append(Component.literal(" : ")).append(Component.translatable("seeking_immortal_virus.jei.masticatory")));
            registration.addIngredientInfo(new ItemStack(Items.polyphagia.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.polyphagia").append(Component.literal(" : ")).append(Component.translatable("seeking_immortal_virus.jei.polyphagia")));
            registration.addIngredientInfo(new ItemStack(Items.quadriceps.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.quadriceps").append(Component.literal(" : ")).append(Component.translatable("seeking_immortal_virus.jei.quadriceps")));
            registration.addIngredientInfo(new ItemStack(Items.reanimation.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.reanimation").append(Component.literal(" : ")).append(Component.translatable("seeking_immortal_virus.jei.reanimation")));

            registration.addIngredientInfo(Items.deceased_contract.get().getDefaultInstance(), VanillaTypes.ITEM_STACK, Component.translatable("seeking_immortal_virus.jei.deceased_contract"));


            registration.addIngredientInfo(new ItemStack(BookItems.weak.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.weak").append(Component.translatable("seeking_immortal_virus.jei.deceased_contract.all")));
            registration.addIngredientInfo(new ItemStack(BookItems.spore_outbreak.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.spore_outbreak").append(Component.translatable("seeking_immortal_virus.jei.deceased_contract.all")));
            registration.addIngredientInfo(new ItemStack(BookItems.plague_book.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.plague_book").append(Component.translatable("seeking_immortal_virus.jei.deceased_contract.all")));
            registration.addIngredientInfo(new ItemStack(BookItems.exercise_reinforcement.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.exercise_reinforcement").append(Component.translatable("seeking_immortal_virus.jei.deceased_contract.all")));
            registration.addIngredientInfo(new ItemStack(BookItems.detect.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.detect").append(Component.translatable("seeking_immortal_virus.jei.deceased_contract.all")));
            registration.addIngredientInfo(new ItemStack(BookItems.bloodstain.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.bloodstain").append(Component.translatable("seeking_immortal_virus.jei.deceased_contract.all")));
            registration.addIngredientInfo(new ItemStack(BookItems.blood_stasis.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.blood_stasis").append(Component.translatable("seeking_immortal_virus.jei.deceased_contract.all")));
            registration.addIngredientInfo(new ItemStack(BookItems.bone_structure.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.bone_structure").append(Component.translatable("seeking_immortal_virus.jei.deceased_contract.all")));
            registration.addIngredientInfo(new ItemStack(BookItems.mummification.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.mummification").append(Component.translatable("seeking_immortal_virus.jei.deceased_contract.all")));
            registration.addIngredientInfo(new ItemStack(BookItems.tumour.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.tumour").append(Component.translatable("seeking_immortal_virus.jei.deceased_contract.all")));
            registration.addIngredientInfo(new ItemStack(BookItems.organizational_regeneration.get()), VanillaTypes.ITEM_STACK, Component.translatable("item.seeking_immortal_virus.organizational_regeneration").append(Component.translatable("seeking_immortal_virus.jei.deceased_contract.all")));


            registration.addIngredientInfo(new ItemStack(Items.necora.get()), VanillaTypes.ITEM_STACK, Component.translatable("seeking_immortal_virus.jei.necora"));
            registration.addIngredientInfo(new ItemStack(Items.crafting_box.get()), VanillaTypes.ITEM_STACK, Component.translatable("seeking_immortal_virus.jei.crafting_box"));
            registration.addIngredientInfo(new ItemStack(Items.giant.get()), VanillaTypes.ITEM_STACK, Component.translatable("seeking_immortal_virus.jei.giant"));
            registration.addIngredientInfo(new ItemStack(Items.cell.get()), VanillaTypes.ITEM_STACK, Component.translatable("seeking_immortal_virus.jei.cell"));
            registration.addIngredientInfo(new ItemStack(Items.giant_nightmare.get()), VanillaTypes.ITEM_STACK, Component.translatable("seeking_immortal_virus.jei.giant_nightmare"));

        }
    }
}
