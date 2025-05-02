package com.ytgld.seeking_immortal_virus.event.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.ytgld.seeking_immortal_virus.Config;
import com.ytgld.seeking_immortal_virus.Handler;
import com.ytgld.seeking_immortal_virus.event.old.NewEvent;
import com.ytgld.seeking_immortal_virus.init.items.BookItems;
import com.ytgld.seeking_immortal_virus.init.items.Items;
import com.ytgld.seeking_immortal_virus.init.moonstoneitem.DataReg;
import com.ytgld.seeking_immortal_virus.init.moonstoneitem.LootReg;
import com.ytgld.seeking_immortal_virus.init.moonstoneitem.i.Iplague;
import com.ytgld.seeking_immortal_virus.item.ManDNA;
import com.ytgld.seeking_immortal_virus.item.man.greed_dna;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import net.neoforged.neoforge.event.entity.living.LivingHealEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.entity.player.CriticalHitEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.inventory.ICurioStacksHandler;
import top.theillusivec4.curios.api.type.inventory.IDynamicStackHandler;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;

public class DungeonLoot extends LootModifier {
    public static final Supplier<MapCodec<DungeonLoot>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.mapCodec(inst -> codecStart(inst).apply(inst, DungeonLoot::new)));

    protected DungeonLoot(LootItemCondition[] conditionsIn) {
        super(conditionsIn);

    }
    @Override
    public @NotNull MapCodec<? extends IGlobalLootModifier> codec() {
        return LootReg.TD.get();
    }
    private void addLoot(ObjectArrayList<ItemStack> generatedLoot,
                         Random random ,
                         Item mustHas ,
                         Entity entity ,
                         List<Item> itemList,
                         int gLvl){
        if (entity instanceof Player player ){
            if (Handler.hascurio(player,mustHas)){
                int i = random.nextInt(itemList.size());
                if (gLvl >= 100){
                    gLvl = 100;
                }
                if (Mth.nextInt(net.minecraft.util.RandomSource.create(), 1, 100) <= gLvl) {
                    generatedLoot.add(new ItemStack(itemList.get(i)));
                }
            }
        }
    }
    private void addLootHasB(ObjectArrayList<ItemStack> generatedLoot,
                             Random random ,
                             boolean a,
                             List<Item> itemList,
                             int gLvl) {
        if (a) {
            int i = random.nextInt(itemList.size());
            if (gLvl >= 100) {
                gLvl = 100;
            }
            if (Mth.nextInt(net.minecraft.util.RandomSource.create(), 1, 100) <= gLvl) {
                generatedLoot.add(new ItemStack(itemList.get(i)));
            }
        }
    }
    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        ResourceLocation s = context.getQueriedLootTableId();
        String idSting = String.valueOf(s);
        Entity entity = context.getParamOrNull(LootContextParams.THIS_ENTITY);
        Random random = new Random();



        if (idSting.contains("chests/")) {
            greed_dna.iris_brain_off_brain_enhance(generatedLoot,entity);
            if (idSting.contains("treasure")){
                addLoot(generatedLoot, random, Items.bat_cell.get(), entity, List.of(
                        Items.cell_blood_attack.get(),
                        Items.cell_desecrate.get(),
                        Items.cell_doctor.get(),
                        Items.cell_fear.get(),
                        Items.cell_harvest.get(),
                        Items.cell_immortal.get(),
                        Items.cell_not_do.get(),
                        Items.cell_rage.get(),
                        Items.cell_scientist.get()
                ), Config.SERVER.bat.get());
            }

            if (idSting.contains("dungeon") || idSting.contains("mineshaft") || idSting.contains("city")||idSting.contains("treasure")) {
                ManDNA.addLoot(generatedLoot,entity,Config.SERVER.lootMan.get());

                addLoot(generatedLoot, random, Items.deceased_contract.get(), entity, List.of(

                        BookItems.bone_structure.get(),
                        BookItems.tumour.get(),
                        BookItems.organizational_regeneration.get(),
                        BookItems.mummification.get(),
                        BookItems.blood_stasis.get(),
                        BookItems.weak.get(),
                        BookItems.spore_outbreak.get(),
                        BookItems.plague_book.get(),
                        BookItems.exercise_reinforcement.get(),
                        BookItems.detect.get(),
                        BookItems.bloodstain.get()

                        ),  Config.SERVER.necora.get());

                addLoot(generatedLoot, random, Items.bloodvirus.get(), entity, List.of(
                        Items.batgene.get(),
                        Items.batskill.get(),
                        Items.bloodgene.get(),
                        Items.botton.get(),
                        Items.catalyzer.get(),
                        Items.flygene.get(),
                        Items.heathgene.get(),
                        Items.ragegene.get(),
                        Items.sleepgene.get()
                ), Config.SERVER.bat.get());

                addLoot(generatedLoot, random, Items.necora.get(), entity, List.of(
                        Items.ambush.get(),
                        Items.atpoverdose.get(),
                        Items.autolytic.get(),
                        Items.fermentation.get(),
                        Items.putrefactive.get(),
                        Items.regenerative.get(),
                        Items.air.get(),
                        Items.motor.get(),
                        Items.watergen.get()

                ), Config.SERVER.necora.get());

            }
        }
        if (idSting.contains("chests/")) {
            if (entity instanceof Player player) {
                if (idSting.contains("treasure")) {

                    boolean ab = !Handler.hascurio(player, Items.cell.get())
                            && !Handler.hascurio(player, Items.giant.get())
                            && Handler.hascurio(player, Items.necora.get());

                    addLootHasB(generatedLoot, random, ab, List.of(
                            Items.cell.get()
                    ), 100);


                    boolean cellBat = !Handler.hascurio(player,Items.bat_cell.get())
                            && Handler.hascurio(player, Items.bloodvirus.get());

                    addLootHasB(generatedLoot, random, cellBat, List.of(
                            Items.bat_cell.get()
                    ), 100);

                    if (Handler.hascurio(player, Items.necora.get())) {

                        boolean cellGiant = Handler.hascurio(player, Items.giant.get());

                        addLootHasB(generatedLoot, random, cellGiant, List.of(
                                Items.bone_cell.get(),
                                Items.parasitic_cell.get(),
                                Items.mother_cell.get(),
                                Items.disgusting_cells.get()
                        ), Config.SERVER.necora.get());

                        boolean cellGiantNig = Handler.hascurio(player, Items.giant_nightmare.get());

                        addLootHasB(generatedLoot, random, cellGiantNig, List.of(
                                Items.giant_boom_cell.get(),
                                Items.anaerobic_cell.get(),
                                Items.subspace_cell.get()
                        ), Config.SERVER.necora.get());

                        boolean cell = Handler.hascurio(player, Items.cell.get())
                                && !Handler.hascurio(player,Items.giant.get());

                        addLootHasB(generatedLoot, random, cell, List.of(
                                Items.adrenaline.get(),
                                Items.cell_mummy.get(),
                                Items.cell_boom.get(),
                                Items.cell_calcification.get(),
                                Items.cell_blood.get()
                        ), Config.SERVER.necora.get());
                    }
                }
            }
        }

        if (idSting.contains("chests/")) {
            if (idSting.contains("treasure")){
                if (entity instanceof Player player) {
                    if (Handler.hascurio(player, Items.bloodvirus.get())){
                        if (!Handler.hascurio(player,Items.bat_cell.get())) {
                            generatedLoot.add(new ItemStack(Items.bat_cell.get()));
                        }
                    }
                    if (Handler.hascurio(player, Items.necora.get())){
                        if (!Handler.hascurio(player,Items.giant.get())) {
                            if (Mth.nextInt(RandomSource.create(),1,10) == 1) {
                                generatedLoot.add(new ItemStack(Items.giant.get()));
                            }
                        }
                    }
                }
            }
        }



        for (ItemStack itemStack : generatedLoot){
            ServerLevel serverLevel= context.getLevel();


            if (itemStack.getItem() instanceof Iplague){
                if (itemStack.get(DataReg.tag) == null) {
                    itemStack.set(DataReg.tag, new CompoundTag());
                }
                if (serverLevel.getDifficulty()==(Difficulty.PEACEFUL)) {
                    if (itemStack.get(DataReg.tag) != null) {
                        itemStack.get(DataReg.tag).putBoolean(Difficulty.PEACEFUL.getKey(), true);
                    }
                }
                if (serverLevel.getDifficulty()==(Difficulty.EASY)) {
                    if (itemStack.get(DataReg.tag) != null) {
                        itemStack.get(DataReg.tag).putBoolean(Difficulty.EASY.getKey(), true);
                    }
                }
                if (serverLevel.getDifficulty()==(Difficulty.NORMAL)) {
                    if (itemStack.get(DataReg.tag) != null) {
                        itemStack.get(DataReg.tag).putBoolean(Difficulty.NORMAL.getKey(), true);
                    }
                }
                if (serverLevel.getDifficulty()==(Difficulty.HARD)) {
                    int lv = Mth.nextInt(RandomSource.create(),1,2);

                    if (lv == 1) {
                        if (itemStack.get(DataReg.tag) != null) {
                            itemStack.get(DataReg.tag).putBoolean(Difficulty.HARD.getKey(), true);
                        }
                    } else if (lv == 2){
                        if (itemStack.get(DataReg.tag) != null) {
                            itemStack.get(DataReg.tag).putBoolean(NewEvent.lootTable, true);
                        }
                    }
                }
            }
        }
        return generatedLoot;
    }

    public static void heal(LivingHealEvent event){
        if (event.getEntity() instanceof Player player){
            CuriosApi.getCuriosInventory(player).ifPresent(handler -> {
                Map<String, ICurioStacksHandler> curios = handler.getCurios();
                for (Map.Entry<String, ICurioStacksHandler> entry : curios.entrySet()) {
                    ICurioStacksHandler stacksHandler = entry.getValue();
                    IDynamicStackHandler stackHandler = stacksHandler.getStacks();
                    for (int i = 0; i < stacksHandler.getSlots(); i++) {
                        ItemStack stack = stackHandler.getStackInSlot(i);
                        if (stack.get(DataReg.tag)!=null){
                            float h = stack.get(DataReg.tag).getFloat(NewEvent.doctor);//20
                            if (h!=0) {
                                event.setAmount(event.getAmount() + h);
                            }
                        }
                    }
                }
            });
        }
    }
    public static void heal(PlayerEvent.BreakSpeed event){
        if (event.getEntity() instanceof Player player){
            CuriosApi.getCuriosInventory(player).ifPresent(handler -> {
                Map<String, ICurioStacksHandler> curios = handler.getCurios();
                for (Map.Entry<String, ICurioStacksHandler> entry : curios.entrySet()) {
                    ICurioStacksHandler stacksHandler = entry.getValue();
                    IDynamicStackHandler stackHandler = stacksHandler.getStacks();
                    for (int i = 0; i < stacksHandler.getSlots(); i++) {
                        ItemStack stack = stackHandler.getStackInSlot(i);
                        if (stack.get(DataReg.tag)!=null){
                            float h = stack.get(DataReg.tag).getFloat(NewEvent.chromosome);
                            if (h!=0) {
                                event.setNewSpeed(event.getNewSpeed()  + h);
                            }
                        }
                    }
                }
            });
        }
    }
    public static void cit(CriticalHitEvent event){
        if (event.getEntity() instanceof Player player){
            CuriosApi.getCuriosInventory(player).ifPresent(handler -> {
                Map<String, ICurioStacksHandler> curios = handler.getCurios();
                for (Map.Entry<String, ICurioStacksHandler> entry : curios.entrySet()) {
                    ICurioStacksHandler stacksHandler = entry.getValue();
                    IDynamicStackHandler stackHandler = stacksHandler.getStacks();
                    for (int i = 0; i < stacksHandler.getSlots(); i++) {
                        ItemStack stack = stackHandler.getStackInSlot(i);
                        if (stack.get(DataReg.tag)!=null){
                            float h = stack.get(DataReg.tag).getFloat(NewEvent.cell_cell);//20
                            if (h!=0) {
                                event.setDamageMultiplier(event.getDamageMultiplier()+ h);
                            }
                        }
                    }
                }
            });
        }
    }

    public static void attack(LivingIncomingDamageEvent event){
        if (event.getSource().getEntity() instanceof Player player){
            CuriosApi.getCuriosInventory(player).ifPresent(handler -> {
                Map<String, ICurioStacksHandler> curios = handler.getCurios();
                for (Map.Entry<String, ICurioStacksHandler> entry : curios.entrySet()) {
                    ICurioStacksHandler stacksHandler = entry.getValue();
                    IDynamicStackHandler stackHandler = stacksHandler.getStacks();
                    for (int i = 0; i < stacksHandler.getSlots(); i++) {
                        ItemStack stack = stackHandler.getStackInSlot(i);
                        if (stack.get(DataReg.tag)!=null){
                            float h = stack.get(DataReg.tag).getFloat(NewEvent.die);//5
                            if (h!=0) {
                                event.setAmount(event.getAmount() + h);
                            }
                        }
                    }
                }
            });
        }
    }

}
