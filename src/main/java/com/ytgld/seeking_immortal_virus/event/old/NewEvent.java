package com.ytgld.seeking_immortal_virus.event.old;

import com.ytgld.seeking_immortal_virus.MoonStoneMod;
import com.ytgld.seeking_immortal_virus.event.loot.DungeonLoot;
import com.ytgld.seeking_immortal_virus.init.items.DNAItems;
import com.ytgld.seeking_immortal_virus.init.moonstoneitem.AttReg;
import com.ytgld.seeking_immortal_virus.init.moonstoneitem.DataReg;
import com.ytgld.seeking_immortal_virus.init.moonstoneitem.Effects;
import com.ytgld.seeking_immortal_virus.init.moonstoneitem.i.IBattery;
import com.ytgld.seeking_immortal_virus.item.decorated.deceased_contract;
import com.ytgld.seeking_immortal_virus.item.man.*;
import com.ytgld.seeking_immortal_virus.item.plague.ALL.dna;
import com.ytgld.seeking_immortal_virus.item.plague.BloodVirus.dna.bat_cell;
import com.ytgld.seeking_immortal_virus.item.plague.TheNecora.bnabush.giant_boom_cell;
import com.ytgld.seeking_immortal_virus.item.plague.TheNecora.god.GodAmbush;
import com.ytgld.seeking_immortal_virus.item.plague.TheNecora.god.GodPutrefactive;
import com.ytgld.seeking_immortal_virus.item.ytgld_virus;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.*;
import net.neoforged.neoforge.event.entity.player.CriticalHitEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.inventory.ICurioStacksHandler;
import top.theillusivec4.curios.api.type.inventory.IDynamicStackHandler;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class NewEvent {
    public static final String lootTable = "god_loot";
    public static final String meet = "the_meet";
    public static final String die = "the_die";
    public static final String doctor = "the_doctor";
    public static final String cell_cell = "the_cell";
    public static final String chromosome = "the_chromosome";
    public static final String bone = "the_bone";
    public static final String die_body = "the_die_body";

    @SubscribeEvent
    public void LivingIncomingDamageEvent(LivingIncomingDamageEvent event){
        GodAmbush.LivingIncomingDamageEvent(event);
    }
    @SubscribeEvent
    public void th_dna(LivingIncomingDamageEvent event){
        if ((event.getSource().getEntity() instanceof Player player)){
            CuriosApi.getCuriosInventory(player).ifPresent(handler -> {
                Map<String, ICurioStacksHandler> curios = handler.getCurios();
                for (Map.Entry<String, ICurioStacksHandler> entry : curios.entrySet()) {
                    ICurioStacksHandler stacksHandler = entry.getValue();
                    IDynamicStackHandler stackHandler = stacksHandler.getStacks();
                    for (int i = 0; i < stacksHandler.getSlots(); i++) {
                        ItemStack stack = stackHandler.getStackInSlot(i);
                        if (stack.get(DataReg.tag)!=null){
                            if (stack.get(DataReg.tag).getBoolean(EquippedEvt.isGod)){
                                event.setAmount(event.getAmount()+0.33f);
                            }
                        }
                    }
                }
            });
        }
    }
    @SubscribeEvent
    public  void FinishLivingEntityUseItemEvent(LivingEntityUseItemEvent.Finish event){
        GodPutrefactive.eat(event);
    }
    @SubscribeEvent
    public  void doBreak(LivingEntityUseItemEvent.Start event){
        dna.doBreak(event);
    }
    @SubscribeEvent
    public  void Finish(LivingEntityUseItemEvent.Finish event){
        dna.eat(event);
    }
    @SubscribeEvent
    public void LivingHealEvent(LivingHealEvent event) {
        DungeonLoot.heal(event);
        health_dna.lymphatic(event);
        copy_dna.formative_cell(event);
        health_dna.stem_cell_proliferation(event);
        if (event.getEntity() instanceof LivingEntity living){
            if (living.getAttribute(AttReg.heal)!=null){
                float attack = (float) living.getAttribute(AttReg.heal).getValue();
                event.setAmount(event.getAmount()*(attack));
            }
        }
    }

    @SubscribeEvent
    public void LivingHealEvent(LivingDeathEvent event) {

        deceased_contract.Did(event);
        dna.dieD(event);
        ytgld_virus.ytgld_virusLivingDeathEvent(event);
        neuron_dna.memory(event);
    }
    public void addV(ItemStack stack,Item Dhis,ItemTooltipEvent event,String string){
        if (stack.is(Dhis)) {
            event.getToolTip().add(1,Component.translatable(string).withStyle(ChatFormatting.RED));
        }
    }
    @SubscribeEvent
    public   void neuron_dna_main(LivingDropsEvent event){
        neuron_dna.neuron_dna_main(event);
    }

    @SubscribeEvent
    public void Fin(LivingEntityUseItemEvent.Finish event){
        ytgld_virus.Finish(event);
    }
    @SubscribeEvent
    public void LivingHurtEvent(LivingIncomingDamageEvent event){
        bat_cell.Bat(event);
        giant_boom_cell.Boom(event);
        deceased_contract.attack(event);
        dna.hur(event);
        DungeonLoot.attack(event);
        run_dna.phosphorylationDamage(event);
        run_dna.cp_energy(event);
        run_dna.hydrolysisDamage(event);
        run_dna.run(event);
        copy_dna.connective_tissue(event);
        attack_dna.abnormal_muscles(event);
        attack_dna.reverse_correction(event);
        skin_dna.hurt_of_skin_dna(event);
        bone_dna.hollow(event);
        bone_dna.bone_spur(event);
        ytgld_virus.LivingHurt(event);
        if (event.getEntity().hasEffect(Effects.dead) && event.getEntity().getEffect(Effects.dead)!=null){
            float lvl = event.getEntity().getEffect(Effects.dead).getAmplifier();
            lvl *= 0.2f;
            event.setAmount(event.getAmount()*(1+lvl));

        }
        if (event.getAmount()>Integer.MAX_VALUE){
            event.setAmount(Integer.MAX_VALUE);
        }
        CuriosApi.getCuriosInventory(event.getEntity()).ifPresent(handler -> {
            Map<String, ICurioStacksHandler> curios = handler.getCurios();
            for (Map.Entry<String, ICurioStacksHandler> entry : curios.entrySet()) {
                ICurioStacksHandler stacksHandler = entry.getValue();
                IDynamicStackHandler stackHandler = stacksHandler.getStacks();
                for (int i = 0; i < stacksHandler.getSlots(); i++) {
                    ItemStack stack = stackHandler.getStackInSlot(i);
                    if (BuiltInRegistries.ITEM.getKey(stack.getItem()).getNamespace().equals(MoonStoneMod.MODID)){

                        float s = event.getAmount();
                        if (s>Integer.MAX_VALUE){
                            event.setAmount(Integer.MAX_VALUE);
                        }
                    }
                }
            }
        });
        if (event.getEntity().hasEffect(Effects.fear)&&event.getEntity().getEffect(Effects.fear)!=null){
            event.setAmount(event.getAmount()*(1+(event.getEntity().getEffect(Effects.fear).getAmplifier()*0.33f)));
        }
        if (event.getSource().getEntity() instanceof LivingEntity living){
            if (living.getAttribute(AttReg.alL_attack)!=null){
                float attack = (float) living.getAttribute(AttReg.alL_attack).getValue();
                event.setAmount(event.getAmount()*(attack));
            }
        }

    }

    @SubscribeEvent
    public void soulbattery(CriticalHitEvent event) {
        DungeonLoot.cit(event);
        attack_dna.self_correction(event);

       if (event.getEntity() instanceof Player living){
            if (living.getAttribute(AttReg.cit)!=null){
                float attack = (float) living.getAttribute(AttReg.cit).getValue();
                event.setDamageMultiplier(event.getDamageMultiplier()*(attack));
            }
        }

    }
    @SubscribeEvent
    public void soulbattery(PlayerEvent.BreakSpeed event) {
        if (event.getEntity() instanceof Player living){
            if (living.getAttribute(AttReg.dig)!=null){

                float dig = (float) living.getAttribute(AttReg.dig).getValue();

                event.setNewSpeed(event.getNewSpeed()*(dig));
            }
        }
    }

    @SubscribeEvent
    public void hurt(LivingIncomingDamageEvent event) {
        if (event.getEntity() instanceof Player living){
            if (living.getAttribute(AttReg.hurt)!=null){
                float hurt = (float) living.getAttribute(AttReg.hurt).getValue();
                event.setAmount(event.getAmount()*(hurt));
            }
        }

    }
    @SubscribeEvent
    public  void SwordEventLivingEntityUseItemEvent(LivingEntityUseItemEvent.Stop event){


    }
    @SubscribeEvent
    public void heal(PlayerEvent.BreakSpeed event){
        DungeonLoot.heal(event);
    }
    @SubscribeEvent
    public void EffectTick(EntityTickEvent.Post event) {
        if (event.getEntity() instanceof LivingEntity living){
            if (living.hasEffect(Effects.blood)&&living.getEffect(Effects.blood)!=null) {
                if (!living.level().isClientSide){
                    if (living.tickCount%20==0){
                        living.hurt(living.damageSources().magic(),living.getEffect(Effects.blood).getAmplifier());
                        living.invulnerableTime = 0;
                    }
                }
            }
            if (living.hasEffect(Effects.rage)&&living.getEffect(Effects.rage)!=null) {
                if (!living.level().isClientSide){
                    if (living.tickCount%10==0){
                        living.hurt(living.damageSources().magic(),living.getEffect(Effects.rage).getAmplifier()+0.5f);
                        living.invulnerableTime = 0;
                    }
                }
            }
        }
    }

    public static Entity getPlayerLookTarget(Level level, LivingEntity living) {
        Entity pointedEntity = null;
        double range = 20.0D;
        Vec3 srcVec = living.getEyePosition();
        Vec3 lookVec = living.getViewVector(1.0F);
        Vec3 destVec = srcVec.add(lookVec.x() * range, lookVec.y() * range, lookVec.z() * range);
        float var9 = 1.0F;
        List<Entity> possibleList = level.getEntities(living, living.getBoundingBox().expandTowards(lookVec.x() * range, lookVec.y() * range, lookVec.z() * range).inflate(var9, var9, var9));
        double hitDist = 0;

        for (Entity possibleEntity : possibleList) {

            if (possibleEntity.isPickable()) {
                float borderSize = possibleEntity.getPickRadius();
                AABB collisionBB = possibleEntity.getBoundingBox().inflate(borderSize, borderSize, borderSize);
                Optional<Vec3> interceptPos = collisionBB.clip(srcVec, destVec);

                if (collisionBB.contains(srcVec)) {
                    if (0.0D < hitDist || hitDist == 0.0D) {
                        pointedEntity = possibleEntity;
                        hitDist = 0.0D;
                    }
                } else if (interceptPos.isPresent()) {
                    double possibleDist = srcVec.distanceTo(interceptPos.get());

                    if (possibleDist < hitDist || hitDist == 0.0D) {
                        pointedEntity = possibleEntity;
                        hitDist = possibleDist;
                    }
                }
            }
        }
        return pointedEntity;
    }
    @SubscribeEvent
    public void BatteryName(ItemTooltipEvent event){
        ItemStack stack = event.getItemStack();
        Player player = event.getEntity();
        addV(stack,DNAItems.cell_disorder.get(),event,"item.seeking_immortal_virus.cell_disorder.tool");
        addV(stack,DNAItems.cell_god.get(),event,"item.seeking_immortal_virus.cell_god.tool");
        addV(stack, DNAItems.cell_inheritance.get(),event,"item.seeking_immortal_virus.cell_inheritance.tool");
        addV(stack,DNAItems.cell_big_boom.get(),event,"item.seeking_immortal_virus.cell_big_boom.tool");
        addV(stack,DNAItems.cell_darwin.get(),event,"item.seeking_immortal_virus.cell_darwin.tool");
        addV(stack,DNAItems.speed_metabolism.get(),event,"item.seeking_immortal_virus.speed_metabolism.tool");
        addV(stack,DNAItems.cell_acid.get(),event,"item.seeking_immortal_virus.cell_acid.tool");
        addV(stack,DNAItems.cell_eyes.get(),event,"item.seeking_immortal_virus.cell_eyes.tool");
        addV(stack,DNAItems.cell_digestion.get(),event,"item.seeking_immortal_virus.cell_digestion.tool");
        addV(stack,DNAItems.cell_cranial.get(),event,"item.seeking_immortal_virus.cell_cranial.tool");
        addV(stack,DNAItems.cell_compress.get(),event,"item.seeking_immortal_virus.cell_compress.tool");
        addV(stack,DNAItems.cell_flu.get(),event,"item.seeking_immortal_virus.cell_flu.tool");
        addV(stack,DNAItems.cell_constant.get(),event,"item.seeking_immortal_virus.cell_constant.tool");




        if (stack.get(DataReg.tag) !=null){
            if (stack.get(DataReg.tag).getBoolean("ALLBattery")){
                event.getToolTip().add(Component.translatable("item.seeking_immortal_virus.battery").withStyle(ChatFormatting.GOLD));
            }
        }

        if (stack.getItem() instanceof IBattery){
            event.getToolTip().add(Component.translatable("item.seeking_immortal_virus.tooltip.battery").withStyle(ChatFormatting.GOLD));
        }
        if (stack.get(DataReg.tag) !=null) {
            if (stack.get(DataReg.tag).getBoolean(Difficulty.PEACEFUL.getKey())) {

                event.getToolTip().add(1,Component.translatable("seeking_immortal_virus.difficulty.name.peaceful").withStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFCD853F)))
                        .append(Component.translatable("seeking_immortal_virus.difficulty.name.all").withStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDEB887)))));

            }
            if (stack.get(DataReg.tag).getBoolean(Difficulty.EASY.getKey())) {

                event.getToolTip().add(1,Component.translatable("seeking_immortal_virus.difficulty.name.easy").withStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFCD853F)))
                        .append(Component.translatable("seeking_immortal_virus.difficulty.name.all").withStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDEB887)))));

            }
            if (stack.get(DataReg.tag).getBoolean(Difficulty.NORMAL.getKey())) {
                event.getToolTip().add(1,Component.translatable("seeking_immortal_virus.difficulty.name.normal").withStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFCD853F)))
                        .append(Component.translatable("seeking_immortal_virus.difficulty.name.all").withStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDEB887)))));

            }
            if (stack.get(DataReg.tag).getBoolean(Difficulty.HARD.getKey())) {
                event.getToolTip().add(1,Component.translatable("seeking_immortal_virus.difficulty.name.hard").withStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFCD853F)))
                        .append(Component.translatable("seeking_immortal_virus.difficulty.name.all").withStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDEB887)))));
            }
            if (stack.get(DataReg.tag).getBoolean(lootTable)) {
                event.getToolTip().add(1,Component.translatable("seeking_immortal_virus.difficulty.name.god").withStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFCD853F)))
                        .append(Component.translatable("seeking_immortal_virus.difficulty.name.all").withStyle(Style.EMPTY.withColor(TextColor.fromRgb(0XFFDEB887)))));
            }

        }

    }
}
