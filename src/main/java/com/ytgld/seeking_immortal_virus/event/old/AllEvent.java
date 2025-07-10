package com.ytgld.seeking_immortal_virus.event.old;

import com.ytgld.seeking_immortal_virus.Handler;
import com.ytgld.seeking_immortal_virus.entity.zombie.cell_zombie;
import com.ytgld.seeking_immortal_virus.init.items.Items;
import com.ytgld.seeking_immortal_virus.init.moonstoneitem.DataReg;
import com.ytgld.seeking_immortal_virus.init.moonstoneitem.EntityTs;
import com.ytgld.seeking_immortal_virus.init.moonstoneitem.extend.MLS;
import com.ytgld.seeking_immortal_virus.init.moonstoneitem.extend.Perhaps;
import com.ytgld.seeking_immortal_virus.init.moonstoneitem.i.*;
import com.ytgld.seeking_immortal_virus.item.ManDNA;
import com.ytgld.seeking_immortal_virus.item.plague.ALL.dna;
import com.ytgld.seeking_immortal_virus.item.plague.BloodVirus.Skill.batskill;
import com.ytgld.seeking_immortal_virus.item.plague.TheNecora.bnabush.cell_blood;
import com.ytgld.seeking_immortal_virus.item.plague.TheNecora.bnabush.cell_boom;
import com.ytgld.seeking_immortal_virus.item.plague.TheNecora.bnabush.cell_calcification;
import com.ytgld.seeking_immortal_virus.item.plague.TheNecora.bnabush.cell_mummy;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.SpawnUtil;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.animal.MushroomCow;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RenderTooltipEvent;
import net.neoforged.neoforge.event.entity.living.*;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.inventory.ICurioStacksHandler;
import top.theillusivec4.curios.api.type.inventory.IDynamicStackHandler;

import java.util.List;
import java.util.Map;

public class AllEvent {
    private final int shield = 1;
    private final int Kidney = 100;
     private final float clientSideAttackTime = 0;

     public static final String cod = "cod";
     public static final String SALMON = "SALMON";
     public static final String CHICKEN = "CHICKEN";
     public static final String BEEF = "BEEF";
     public static final String RABBIT = "RABBIT";
     public static final String MUTTON = "MUTTON";
     public static final String PORKCHOP = "PORKCHOP";
     public static final String TROPICAL_FISH = "TROPICAL_FISH";
     public static final String give = "GiveItem";
     public static final String fungus = "GiveFungus";
     public static final String virus = "virus";
    public static float aFloat = 0;
    public static final String lvl= "germString";
    public static final String lvlSize= "germStringLvlSize";
    public static String lvl_parasite = "lvl";
    public static String sizeLevel = "sizeLevel";
    public static String blood = "bloodgene";
    public static String rage = "ragegene";
    public static String FlyEye = "FlyNecoraorb";
    public static String FlySword = "FlySword";

    public static final String DamageCell = "DamageCell";
    public static final  String muMMY = cell_mummy.Mummy;
    public static final  String boom = cell_boom.cb;
    public static final  String calcification = cell_calcification.cc;
    public static final  String cb_blood = cell_blood.c_blood;
    public static final String Gorillas ="Gorillas";
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
                            if (stack.get(DataReg.tag).getBoolean(Difficulty.EASY.getKey())){
                                event.setAmount(event.getAmount()+0);
                            }
                            if (stack.get(DataReg.tag).getBoolean(Difficulty.NORMAL.getKey())){
                                event.setAmount(event.getAmount()+0.08f);
                            }
                            if (stack.get(DataReg.tag).getBoolean(Difficulty.HARD.getKey())){
                                event.setAmount(event.getAmount()+0.17f);
                            }
                            if (stack.get(DataReg.tag).getBoolean(NewEvent.lootTable)){
                                event.setAmount(event.getAmount()+0.25f);
                            }

                        }
                    }
                }
            });
        }
    }
    @SubscribeEvent
    public void fermentation(LivingIncomingDamageEvent event) {
        if (event.getSource().getEntity() instanceof Player player){
            if (Handler.hascurio(player, Items.fermentation.get())){
                if (player.getCooldowns().isOnCooldown(Items.fermentation.get())){
                    event.setAmount(event.getAmount() * 0.3f);
                }else {
                    event.setAmount(event.getAmount() * 4);
                    player.getCooldowns().addCooldown(Items.fermentation.get(), 200);
                }
            }
        }
    }
    @SubscribeEvent
    public  void parasite(LivingIncomingDamageEvent event) {
        if (event.getSource().getEntity() instanceof Player player){
            CuriosApi.getCuriosInventory(player).ifPresent(handler -> {
                Map<String, ICurioStacksHandler> curios = handler.getCurios();
                for (Map.Entry<String, ICurioStacksHandler> entry : curios.entrySet()) {
                    ICurioStacksHandler stacksHandler = entry.getValue();
                    IDynamicStackHandler stackHandler = stacksHandler.getStacks();
                    for (int i = 0; i < stacksHandler.getSlots(); i++) {
                        ItemStack stack = stackHandler.getStackInSlot(i);
                        if (stack.is(Items.parasite.get())) {
                            if (Handler.hascurio(player, Items.parasite.get())) {
                                if (stack.get(DataReg.tag)!=null) {
                                    if (stack.get(DataReg.tag).getInt(sizeLevel) > 900) {
                                        if (player.getFoodData().getFoodLevel() > 12) {
                                            event.setAmount(event.getAmount() * 1.4f);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    @SubscribeEvent
    public void Boom(LivingIncomingDamageEvent event){
        if ((event.getEntity() instanceof Player player)) {
            if (Handler.hascurio(player,Items.cell_boom.get())){
                if (event.getSource().is(DamageTypes.EXPLOSION)){
                    event.setAmount(0);
                }
            }
        }
    }
    @SubscribeEvent
    public void gen(LivingIncomingDamageEvent event) {
        if ((event.getEntity() instanceof Player player)) {
            if (Handler.hascurio(player, Items.air.get())) {
                if (!player.onGround()) {
                    event.setAmount(event.getAmount() * 0.8f);
                }
                if (!player.isInWater()) {
                    event.setAmount(event.getAmount() * 0.85f);
                }
            }
        }
    }

    @SubscribeEvent
    public void evil(LivingDeathEvent event){
        if ((event.getEntity() instanceof Player player)) {
            if (Handler.hascurio(player,Items.cell_boom.get())){
                player.level().explode(null,player.getX(),player.getY(),player.getZ(),5.5f,true , Level.ExplosionInteraction.NONE);
            }
        }

        if (event.getSource().getDirectEntity() instanceof Player player){
            if (Handler.hascurio(player, Items.giant.get())){

                if (!Handler.hascurio(player,Items.giant_nightmare.get())) {
                    if (!player.getCooldowns().isOnCooldown(Items.giant.get())) {
                        if (player.level() instanceof ServerLevel p_222881_) {
                            if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {

                                Handler.trySpawnMob(player, EntityTs.cell_giant.get(), MobSpawnType.TRIGGERED, p_222881_, new BlockPos((int) event.getEntity().getX(), (int) event.getEntity().getY(), (int) event.getEntity().getZ()), 10, 2, 3, SpawnUtil.Strategy.ON_TOP_OF_COLLIDER,Items.giant.get(), 600);
                                player.level().playSound(null, player.blockPosition(), SoundEvents.WARDEN_EMERGE, SoundSource.NEUTRAL, 1.0F, 1.0F);

                                if (Handler.hascurio(player, Items.mother_cell.get())) {
                                    if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
                                        Handler.trySpawnMob(player, EntityTs.cell_giant.get(), MobSpawnType.TRIGGERED, p_222881_, new BlockPos((int) event.getEntity().getX(), (int) event.getEntity().getY(), (int) event.getEntity().getZ()), 10, 2, 3, SpawnUtil.Strategy.ON_TOP_OF_COLLIDER,Items.giant.get(), 600);
                                    }
                                    for (int i = 0; i < 2; i++) {
                                        cell_zombie cell_zombie = new cell_zombie(EntityTs.cell_zombie.get(), player.level());
                                        cell_zombie.setOwnerUUID(player.getUUID());
                                        cell_zombie.setPos(player.position());
                                        player.level().addFreshEntity(cell_zombie);
                                    }
                                }
                                player.getCooldowns().addCooldown(Items.giant.get(), 600);
                            }
                        }
                    }
                }else {
                    if (!player.getCooldowns().isOnCooldown(Items.giant.get())) {
                        if (player.level() instanceof ServerLevel p_222881_) {
                            if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
                                Handler.trySpawnMob(player, EntityTs.nightmare_giant_to.get(), MobSpawnType.TRIGGERED, p_222881_, new BlockPos((int) event.getEntity().getX(), (int) event.getEntity().getY(), (int) event.getEntity().getZ()), 10, 2, 3, SpawnUtil.Strategy.ON_TOP_OF_COLLIDER,Items.giant.get(), 600);

                                player.hurt(player.damageSources().dryOut(), player.getHealth() /2);
                                player.level().playSound(null, player.blockPosition(), SoundEvents.WARDEN_EMERGE, SoundSource.NEUTRAL, 1.0F, 1.0F);

                                if (Handler.hascurio(player, Items.subspace_cell.get())) {
                                    for (int i = 0; i < 3; i++) {
                                        Handler.trySpawnMob(player, EntityTs.cell_giant.get(), MobSpawnType.TRIGGERED, p_222881_, new BlockPos((int) event.getEntity().getX(), (int) event.getEntity().getY(), (int) event.getEntity().getZ()), 10, 2, 3, SpawnUtil.Strategy.ON_TOP_OF_COLLIDER,Items.giant.get(), 600);
                                    }
                                }


                                player.getCooldowns().addCooldown(Items.giant.get(), 1200);

                            }
                        }
                    }
                }
            }
            if (Handler.hascurio(player, Items.cell.get())){
                if (Mth.nextInt(RandomSource.create(),1, 2) ==1 ){
                    cell_zombie z = new cell_zombie(EntityTs.cell_zombie.get(), player.level());
                    z.teleportTo(event.getEntity().getX(),event.getEntity().getY(), event.getEntity().getZ());
                    z.setOwnerUUID(player.getUUID());

                    if (Handler.hascurio(player,Items.adrenaline.get())){
                        z.addTag(DamageCell);
                    }
                    if (Handler.hascurio(player,Items.cell_mummy.get())){
                        z.addTag(muMMY);
                    }
                    if (Handler.hascurio(player,Items.cell_boom.get())){
                        z.addTag(boom);
                    }
                    if (Handler.hascurio(player,Items.cell_calcification.get())){
                        z.addTag(calcification);
                    }
                    if (Handler.hascurio(player,Items.cell_blood.get())){
                        z.addTag(cb_blood);
                    }
                    player.level().addFreshEntity(z);
                }
            }
        }
    }
    @SubscribeEvent
    public void necora(LivingDropsEvent event) {
        if (event.getSource().getEntity() instanceof Player player){
            if (Handler.hascurio(player, Items.necora.get())){
                if (Mth.nextInt(RandomSource.create(), 1, 3) == 1){
                    event.getDrops().add(new ItemEntity(event.getEntity().level() , event.getEntity().getX(), event.getEntity().getY(),event.getEntity().getZ(), new ItemStack(net.minecraft.world.item.Items.ROTTEN_FLESH)));
                }
            }
        }
    }

    @SubscribeEvent
    public void necora(LivingIncomingDamageEvent event) {
        if (event.getSource()!= null&&event.getSource().getEntity() instanceof Player player){
            if (Handler.hascurio(player, Items.necora.get())) {
                event.setAmount(event.getAmount() * 0.9f);

                if (event.getEntity() instanceof Mob mob) {
                    if (mob.isInvertedHealAndHarm()){
                        event.setAmount(event.getAmount() * 0.8f);
                    }
                }

            }
        }
        if (event.getEntity() instanceof Player player){
            if (Handler.hascurio(player,  Items.necora.get())) {
                if (event.getSource() != null && event.getSource().getEntity() instanceof Mob mob) {
                    if (mob.isInvertedHealAndHarm()){
                        event.setAmount(event.getAmount() / 2);
                    }
                }

                if (event.getSource().is(DamageTypes.MAGIC)) {
                    event.setAmount(event.getAmount() * 0.3f);
                }
            }
        }
    }

    @SubscribeEvent
    public void necora(PlayerInteractEvent.RightClickItem event){
        Player player = event.getEntity();
        if (Handler.hascurio(player, Items.necora.get())){
            if (event.getItemStack().is(net.minecraft.world.item.Items.ROTTEN_FLESH)){
                player.startUsingItem(event.getHand());
            }
        }
    }

    @SubscribeEvent
    public void necora(LivingEntityUseItemEvent.Finish event) {
        if (event.getEntity() instanceof Player player){
            if (Handler.hascurio(player,Items.polyphagia.get())){
                if (event.getItem().getUseAnimation() == UseAnim.EAT){
                    player.heal(player.getMaxHealth() / 15);
                }
            }

            CuriosApi.getCuriosInventory(player).ifPresent(handler -> {
                Map<String, ICurioStacksHandler> curios = handler.getCurios();
                for (Map.Entry<String, ICurioStacksHandler> entry : curios.entrySet()) {
                    ICurioStacksHandler stacksHandler = entry.getValue();
                    IDynamicStackHandler stackHandler = stacksHandler.getStacks();
                    for (int i = 0; i < stacksHandler.getSlots(); i++) {
                        ItemStack stack = stackHandler.getStackInSlot(i);
                        if (!stack.isEmpty()){
                            if (stack.is(Items.necora.get())&&event.getItem().getUseAnimation() == UseAnim.EAT){
                                if (event.getItem().is(net.minecraft.world.item.Items.ROTTEN_FLESH)){
                                    player.heal(player.getMaxHealth() / 20);
                                    player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0));
                                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 0));
                                }
                                if (Handler.hascurio(player, Items.putrefactive.get())) {
                                    player.heal(player.getMaxHealth() / 10);
                                    player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0));
                                }
                            }
                        }
                    }
                }
            });

        }
    }

    @SubscribeEvent
    public void batskill(LivingIncomingDamageEvent event) {
        if (event.getSource()!= null&&event.getSource().getEntity() instanceof Player player){
            CuriosApi.getCuriosInventory(player).ifPresent(handler -> {
                Map<String, ICurioStacksHandler> curios = handler.getCurios();
                for (Map.Entry<String, ICurioStacksHandler> entry : curios.entrySet()) {
                    ICurioStacksHandler stacksHandler = entry.getValue();
                    IDynamicStackHandler stackHandler = stacksHandler.getStacks();
                    for (int i = 0; i < stacksHandler.getSlots(); i++) {
                        ItemStack stack = stackHandler.getStackInSlot(i);
                        if (!stack.isEmpty()) {
                            if (stack.is( Items.bloodvirus.get())) {
                                CompoundTag tag = stack.get(DataReg.tag);
                                if (tag != null) {
                                    if (tag.getBoolean(batskill.batskill)){
                                        Bat b1 = new Bat(EntityType.BAT, player.level());
                                        b1.setPos(event.getEntity().position());
                                        Bat b12 = new Bat(EntityType.BAT, player.level());
                                        b12.setPos(event.getEntity().position());
                                        Bat b13 = new Bat(EntityType.BAT, player.level());
                                        b13.setPos(event.getEntity().position());
                                        if (Mth.nextInt(RandomSource.create(), 1, 7) == 1){
                                            player.level().addFreshEntity(b1);
                                            player.level().addFreshEntity(b12);
                                            player.level().addFreshEntity(b13);
                                        }
                                    }
                                }else {
                                    stack.set(DataReg.tag,new CompoundTag());
                                }
                            }
                        }
                    }
                }
            });
        }
        if (event.getEntity() instanceof Player player){
            CuriosApi.getCuriosInventory(player).ifPresent(handler -> {
                Map<String, ICurioStacksHandler> curios = handler.getCurios();
                for (Map.Entry<String, ICurioStacksHandler> entry : curios.entrySet()) {
                    ICurioStacksHandler stacksHandler = entry.getValue();
                    IDynamicStackHandler stackHandler = stacksHandler.getStacks();
                    for (int i = 0; i < stacksHandler.getSlots(); i++) {
                        ItemStack stack = stackHandler.getStackInSlot(i);
                        if (!stack.isEmpty()) {
                            if (stack.is( Items.bloodvirus.get())) {
                                CompoundTag tag = stack.get(DataReg.tag);
                                if (tag != null) {
                                    if (tag.getBoolean(batskill.batskill)){
                                        Vec3 playerPos = player.position();
                                        int range = 12;
                                        List<LivingEntity> entities = player.level().getEntitiesOfClass(LivingEntity.class, new AABB(playerPos.x - range, playerPos.y - range, playerPos.z - range, playerPos.x + range, playerPos.y + range, playerPos.z + range));
                                        int integers = 0;
                                        for (LivingEntity living : entities) {
                                            if (living instanceof Bat){
                                                integers++;
                                            }
                                        }
                                        float integer = integers;
                                        integer /= 20;
                                        if (integer > 0.8){
                                            integer = 0.8f;
                                        }
                                        event.setAmount(event.getAmount()*(1-integer));
                                    }
                                }else {
                                    stack.set(DataReg.tag,new CompoundTag());
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    @SubscribeEvent
    public void bloodvirusLiving(LivingKnockBackEvent event) {
        if (event.getEntity() instanceof Player player){
            if (Handler.hascurio(player,  Items.bloodvirus.get())){
                event.setStrength(event.getStrength() * 2);
            }
        }

    }
    @SubscribeEvent
    public void bloodvirusLiving(LivingHealEvent event) {
        if (event.getEntity() instanceof Player player){
            if (Handler.hascurio(player,  Items.bloodvirus.get())){
                event.setAmount(event.getAmount() * 0.7f);
            }
        }

    }
    @SubscribeEvent
    public void bloodvirusLiving(LivingIncomingDamageEvent event) {
        if (event.getSource()!= null) {
            if (event.getSource().getEntity() instanceof Player player) {
                if (Handler.hascurio(player, Items.bloodvirus.get())) {
                    if (player.level().isDay()) {
                        if (player.level().canSeeSkyFromBelowWater(new BlockPos(player.getBlockX(), player.getBlockY(), player.getBlockZ()))) {
                            event.setAmount(event.getAmount() * 0.25f);
                        }
                    }


                    if (player.level() instanceof ServerLevel serverLevel) {
                        serverLevel.sendParticles(ParticleTypes.SOUL, event.getEntity().getX(), event.getEntity().getY()+1, event.getEntity().getZ(), 2, 0.33, 0.33, 0.33, 0);
                        serverLevel.sendParticles(ParticleTypes.SCULK_SOUL, event.getEntity().getX(), event.getEntity().getY()+1, event.getEntity().getZ(), 2, 0.33, 0.33, 0.33, 0);
                    }
                    if (Handler.hascurio(player,  Items.bloodvirus.get())) {
                        float j = event.getAmount() * 0.1f;
                        if (j>5){
                            j=5;
                        }
                        player.heal(j);
                        if (event.getEntity() instanceof Mob mob) {
                            if (!mob.isInvertedHealAndHarm()) {
                                event.setAmount(event.getAmount() * 1.25f);
                            }
                        }
                        if (Mth.nextInt(RandomSource.create(), 1, 10) == 1) {
                            float s = event.getAmount() * 0.2f;
                            if (s>5){
                                s=5;
                            }
                            player.heal(s);
                            event.getEntity().hurt(event.getSource(), 8);
                        }
                    }
                }
            }
        }
    }


    @SubscribeEvent
    public  void reanimation(LivingIncomingDamageEvent event) {
        if (event.getEntity() instanceof Player player){
            if (Handler.hascurio(player, Items.reanimation.get())){
                if (!player.getCooldowns().isOnCooldown(Items.reanimation.get())) {
                    if (event.getAmount() > player.getHealth()) {
                        player.heal(player.getMaxHealth() / 2);
                        player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 600, 4));
                        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 1));
                        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 600, 1));
                        player.level().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.WARDEN_DEATH, SoundSource.NEUTRAL, 0.8F, 0.8F);

                        player.getCooldowns().addCooldown(Items.reanimation.get(), 3000);
                    }
                }
            }
        }
    }
    @SubscribeEvent
    public  void masticatory(LivingEntityUseItemEvent.Start event) {
        if (event.getEntity() instanceof Player player){
            if (Handler.hascurio(player, Items.masticatory.get())){
                if (event.getItem().getUseAnimation() == UseAnim.EAT){
                    event.setDuration(event.getDuration() / 2);
                }
            }
        }

    }
    @SubscribeEvent
    public void calcification(LivingIncomingDamageEvent event) {
        if (event.getEntity() instanceof Player player){
            if (Handler.hascurio(player, Items.calcification.get())){
                event.setAmount(event.getAmount() * 0.89f);
            }
        }

    }
    @SubscribeEvent
    public  void die_KILL(LivingDeathEvent event) {
        if (event.getSource().getEntity() instanceof Player player) {
            CuriosApi.getCuriosInventory(player).ifPresent(handler -> {
                Map<String, ICurioStacksHandler> curios = handler.getCurios();
                for (Map.Entry<String, ICurioStacksHandler> entry : curios.entrySet()) {
                    ICurioStacksHandler stacksHandler = entry.getValue();
                    IDynamicStackHandler stackHandler = stacksHandler.getStacks();
                    for (int i = 0; i < stacksHandler.getSlots(); i++) {
                        ItemStack stack = stackHandler.getStackInSlot(i);
                        if (!stack.isEmpty()) {
                            if (stack.is(Items.medicinebox.get())) {
                                CompoundTag tag = stack.get(DataReg.tag);
                                if (tag != null) {
                                    if (event.getEntity() instanceof EnderDragon) {
                                        if (tag.getBoolean(blood_eat) &&
                                                tag.getBoolean(blood_hurt) &&
                                                tag.getBoolean(blood_jump) &&
                                                tag.getBoolean(blood_spawn) &&
                                                tag.getBoolean(blood_enchant)) {
                                            player.addItem(new ItemStack(Items.catalyzer.get()));
                                        }
                                    }
                                }else {
                                    stack.set(DataReg.tag,new CompoundTag());
                                }
                            }
                        }
                    }
                }
            });
        }
    }
    public static String jump_size = "jump_size";
    public static String hurt_size ="hurt_size";
    public static String apple = "apple";

    public static String spawn= "spawn";
    public static String enchant= "enchant";

    public static final String blood_hurt = "blood_hurt";
    public static  final String blood_jump = "blood_jump";
    public static  final String blood_eat = "blood_eat";
    public static  final String blood_spawn = "blood_spawn";
    public static  final String blood_enchant = "blood_enchant";

    @SubscribeEvent
    public  void die(PlayerEvent.PlayerRespawnEvent event) {
        Player player = event.getEntity();
        CuriosApi.getCuriosInventory(player).ifPresent(handler -> {
            Map<String, ICurioStacksHandler> curios = handler.getCurios();
            for (Map.Entry<String, ICurioStacksHandler> entry : curios.entrySet()) {
                ICurioStacksHandler stacksHandler = entry.getValue();
                IDynamicStackHandler stackHandler = stacksHandler.getStacks();
                for (int i = 0; i < stacksHandler.getSlots(); i++) {
                    ItemStack stack = stackHandler.getStackInSlot(i);
                    if (!stack.isEmpty()) {
                        if (stack.is(Items.medicinebox.get())) {
                            CompoundTag tag = stack.get(DataReg.tag);
                            if (tag != null) {
                                if (!tag.getBoolean(spawn)) {
                                    player.addItem(new ItemStack(Items.reanimation.get()));
                                    tag.putBoolean(spawn, true);
                                    tag.putBoolean(blood_spawn, true);
                                }
                            }else {
                                stack.set(DataReg.tag,new CompoundTag());
                            }
                        }
                    }
                }
            }
        });

    }
    @SubscribeEvent
    public  void apple(LivingEntityUseItemEvent.Finish event) {
        LivingEntity livingEntity = event.getEntity();
        if (livingEntity instanceof Player player){
            CuriosApi.getCuriosInventory(player).ifPresent(handler -> {
                Map<String, ICurioStacksHandler> curios = handler.getCurios();
                for (Map.Entry<String, ICurioStacksHandler> entry : curios.entrySet()) {
                    ICurioStacksHandler stacksHandler = entry.getValue();
                    IDynamicStackHandler stackHandler = stacksHandler.getStacks();
                    for (int i = 0; i < stacksHandler.getSlots(); i++) {
                        ItemStack stack = stackHandler.getStackInSlot(i);
                        if (!stack.isEmpty()) {
                            if (stack.is(Items.medicinebox.get())) {
                                ItemStack a = event.getItem();
                                CompoundTag tag = stack.get(DataReg.tag);
                                if (tag != null) {
                                    if (a.is(net.minecraft.world.item.Items.GOLDEN_APPLE)) {

                                        if (tag.getInt(apple) < 9) {
                                            tag.putInt(apple, tag.getInt(apple) + 1);
                                        }
                                        if (tag.getInt(apple) == 8) {
                                            player.addItem(new ItemStack(Items.masticatory.get()));
                                            tag.putBoolean(blood_eat, true);
                                        }

                                    }
                                }else {
                                    stack.set(DataReg.tag,new CompoundTag());
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    @SubscribeEvent
    public  void medicinebox(LivingIncomingDamageEvent event) {
        LivingEntity livingEntity = event.getEntity();
        if (livingEntity instanceof Player player){
            CuriosApi.getCuriosInventory(player).ifPresent(handler -> {
                Map<String, ICurioStacksHandler> curios = handler.getCurios();
                for (Map.Entry<String, ICurioStacksHandler> entry : curios.entrySet()) {
                    ICurioStacksHandler stacksHandler = entry.getValue();
                    IDynamicStackHandler stackHandler = stacksHandler.getStacks();
                    for (int i = 0; i < stacksHandler.getSlots(); i++) {
                        ItemStack stack = stackHandler.getStackInSlot(i);
                        if (!stack.isEmpty()) {
                            if (stack.is(Items.medicinebox.get())) {
                                CompoundTag tag = stack.get(DataReg.tag);
                                if (tag != null) {
                                    if (tag != null && tag.getInt(hurt_size) < 351) {
                                        tag.putInt(hurt_size, tag.getInt(hurt_size) + 1);
                                    }
                                    if (tag != null && tag.getInt(hurt_size) == 350) {
                                        player.addItem(new ItemStack(Items.calcification.get()));
                                        tag.putBoolean(blood_hurt, true);
                                    }
                                }else {
                                    stack.set(DataReg.tag,new CompoundTag());
                                }
                            }
                        }
                    }
                }
            });
        }
    }
    @SubscribeEvent
    public  void medicinebox(LivingEvent.LivingJumpEvent event) {
        LivingEntity livingEntity = event.getEntity();
        if (livingEntity instanceof Player player){
            CuriosApi.getCuriosInventory(player).ifPresent(handler -> {
                Map<String, ICurioStacksHandler> curios = handler.getCurios();
                for (Map.Entry<String, ICurioStacksHandler> entry : curios.entrySet()) {
                    ICurioStacksHandler stacksHandler = entry.getValue();
                    IDynamicStackHandler stackHandler = stacksHandler.getStacks();
                    for (int i = 0; i < stacksHandler.getSlots(); i++) {
                        ItemStack stack = stackHandler.getStackInSlot(i);
                        if (!stack.isEmpty()) {
                            if (stack.is(Items.medicinebox.get())) {
                                CompoundTag tag = stack.get(DataReg.tag);
                                if (tag != null) {
                                    if (tag != null && tag.getInt(jump_size) < 501) {
                                        tag.putInt(jump_size, tag.getInt(jump_size) + 1);

                                    }
                                    if (tag != null && tag.getInt(jump_size) == 500) {
                                        player.addItem(new ItemStack(Items.quadriceps.get()));
                                        tag.putBoolean(blood_jump, true);

                                    }
                                }else {
                                    stack.set(DataReg.tag,new CompoundTag());
                                }
                            }
                        }
                    }
                }
            });
        }
    }
    @SubscribeEvent
    public  void medicinebox(LivingEntityUseItemEvent.Finish event) {

        LivingEntity livingEntity = event.getEntity();
        if (livingEntity instanceof Player player){
            CuriosApi.getCuriosInventory(player).ifPresent(handler -> {
                Map<String, ICurioStacksHandler> curios = handler.getCurios();
                for (Map.Entry<String, ICurioStacksHandler> entry : curios.entrySet()) {
                    ICurioStacksHandler stacksHandler = entry.getValue();
                    IDynamicStackHandler stackHandler = stacksHandler.getStacks();
                    for (int i = 0; i < stacksHandler.getSlots(); i++) {
                        ItemStack stack = stackHandler.getStackInSlot(i);
                        if (!stack.isEmpty()) {
                            if (stack.is(Items.medicinebox.get())) {
                                ItemStack a = event.getItem();
                                if (a.is(net.minecraft.world.item.Items.ENCHANTED_GOLDEN_APPLE)) {
                                    CompoundTag tag = stack.get(DataReg.tag);
                                    if (tag != null) {
                                        if (!tag.getBoolean(enchant)) {
                                            player.addItem(new ItemStack(Items.polyphagia.get()));
                                            tag.putBoolean(enchant, true);
                                            tag.putBoolean(blood_enchant, true);

                                        }
                                    }else {
                                        stack.set(DataReg.tag,new CompoundTag());
                                    }
                                }
                            }
                        }
                    }
                }
            });
        }
    }
    @SubscribeEvent
    public  void hurt(LivingIncomingDamageEvent event) {
        if (event.getSource().getEntity() instanceof Player player){
            CuriosApi.getCuriosInventory(player).ifPresent(handler -> {
                Map<String, ICurioStacksHandler> curios = handler.getCurios();
                for (Map.Entry<String, ICurioStacksHandler> entry : curios.entrySet()) {
                    ICurioStacksHandler stacksHandler = entry.getValue();
                    IDynamicStackHandler stackHandler = stacksHandler.getStacks();
                    for (int i = 0; i < stacksHandler.getSlots(); i++) {
                        ItemStack stack = stackHandler.getStackInSlot(i);
                        if (!stack.isEmpty()) {
                            if (stack.is(Items.ragegene.get())) {
                                CompoundTag tag = stack.get(DataReg.tag);
                                if (tag != null) {
                                    if (player.getAttackStrengthScale(1) == 1) {
                                        if (tag != null && tag.getInt(rage) < 100) {
                                            tag.putFloat(rage, tag.getInt(rage) + 5);
                                        }
                                    }
                                }else {
                                    stack.set(DataReg.tag,new CompoundTag());
                                }
                            }
                        }
                    }
                }
            });
        }
        if (event.getEntity() instanceof Player player){
            CuriosApi.getCuriosInventory(player).ifPresent(handler -> {
                Map<String, ICurioStacksHandler> curios = handler.getCurios();
                for (Map.Entry<String, ICurioStacksHandler> entry : curios.entrySet()) {
                    ICurioStacksHandler stacksHandler = entry.getValue();
                    IDynamicStackHandler stackHandler = stacksHandler.getStacks();
                    for (int i = 0; i < stacksHandler.getSlots(); i++) {
                        ItemStack stack = stackHandler.getStackInSlot(i);
                        if (!stack.isEmpty()) {
                            if (stack.is(Items.ragegene.get())) {

                                CompoundTag tag = stack.get(DataReg.tag);
                                if (tag != null) {
                                    tag.putFloat(rage,0);
                                }else {
                                    stack.set(DataReg.tag,new CompoundTag());
                                }
                            }
                        }
                    }
                }
            });
        }
    }
    @SubscribeEvent
    public void bloodgene(LivingIncomingDamageEvent event) {
        LivingEntity livingEntity = event.getEntity();
        if (livingEntity instanceof Player player){
            CuriosApi.getCuriosInventory(player).ifPresent(handler -> {
                Map<String, ICurioStacksHandler> curios = handler.getCurios();
                for (Map.Entry<String, ICurioStacksHandler> entry : curios.entrySet()) {
                    ICurioStacksHandler stacksHandler = entry.getValue();
                    IDynamicStackHandler stackHandler = stacksHandler.getStacks();
                    for (int i = 0; i < stacksHandler.getSlots(); i++) {
                        ItemStack stack = stackHandler.getStackInSlot(i);
                        if (!stack.isEmpty()) {
                            if (stack.is(Items.bloodgene.get())) {
                                event.setAmount(event.getAmount() * 1.1f);
                                CompoundTag tag = stack.get(DataReg.tag);
                                if (tag != null) {
                                    if (tag != null && tag.getInt(blood) < 150) {
                                        tag.putFloat(blood, tag.getInt(blood) + 5);
                                    }
                                }else {
                                    stack.set(DataReg.tag,new CompoundTag());
                                }
                            }
                        }
                    }
                }
            });
        }
    }
    @SubscribeEvent
    public void bloodgene(LivingHealEvent event) {
        LivingEntity livingEntity = event.getEntity();
        if (livingEntity instanceof Player player){
            CuriosApi.getCuriosInventory(player).ifPresent(handler -> {
                Map<String, ICurioStacksHandler> curios = handler.getCurios();
                for (Map.Entry<String, ICurioStacksHandler> entry : curios.entrySet()) {
                    ICurioStacksHandler stacksHandler = entry.getValue();
                    IDynamicStackHandler stackHandler = stacksHandler.getStacks();
                    for (int i = 0; i < stacksHandler.getSlots(); i++) {
                        ItemStack stack = stackHandler.getStackInSlot(i);
                        if (!stack.isEmpty()) {
                            if (stack.is(Items.bloodgene.get())) {
                                CompoundTag tag = stack.get(DataReg.tag);
                                if (tag != null) {
                                    if (tag != null && tag.getInt(blood) > 0) {
                                        tag.putFloat(blood, tag.getInt(blood) - 1);
                                    }
                                }else {
                                    stack.set(DataReg.tag,new CompoundTag());
                                }
                            }
                        }
                    }
                }
            });
        }
    }
    @SubscribeEvent
    public  void virus(LivingIncomingDamageEvent event) {
        if (event.getSource().getEntity() instanceof Player player){
            if (Handler.hascurio(player, Items.virus.get())) {
                CuriosApi.getCuriosInventory(player).ifPresent(handler -> {
                    Map<String, ICurioStacksHandler> curios = handler.getCurios();
                    for (Map.Entry<String, ICurioStacksHandler> entry : curios.entrySet()) {
                        ICurioStacksHandler stacksHandler = entry.getValue();
                        IDynamicStackHandler stackHandler = stacksHandler.getStacks();
                        for (int i = 0; i < stacksHandler.getSlots(); i++) {
                            ItemStack stack = stackHandler.getStackInSlot(i);
                            if (stack.getItem() instanceof com.ytgld.seeking_immortal_virus.item.plague.ALL.virus) {
                                CompoundTag tag = stack.get(DataReg.tag);
                                if (tag != null) {
                                    String name = event.getEntity().getEncodeId();
                                    if (name != null) {
                                        int size = tag.getInt(name);
                                        float Do = (float) size / 400;
                                        event.setAmount(event.getAmount() * (1 + Do));
                                    }
                                }else {
                                    stack.set(DataReg.tag,new CompoundTag());
                                }
                            }

                        }
                    }
                });
            }

        }
    }
    @SubscribeEvent
    public  void virus(LivingDeathEvent event) {
        if (event.getSource().getEntity() instanceof Player player){
            if (Handler.hascurio(player, Items.virus.get())) {
                CuriosApi.getCuriosInventory(player).ifPresent(handler -> {
                    Map<String, ICurioStacksHandler> curios = handler.getCurios();
                    for (Map.Entry<String, ICurioStacksHandler> entry : curios.entrySet()) {
                        ICurioStacksHandler stacksHandler = entry.getValue();
                        IDynamicStackHandler stackHandler = stacksHandler.getStacks();
                        for (int i = 0; i < stacksHandler.getSlots(); i++) {
                            ItemStack stack = stackHandler.getStackInSlot(i);
                            if (stack.is(Items.virus.get())) {
                                CompoundTag tag = stack.get(DataReg.tag);
                                if (tag != null) {
                                    String name = event.getEntity().getEncodeId();
                                    if (name != null) {
                                        if (tag.getInt(name) < 400) {
                                            tag.putInt(name, tag.getInt(name) + 1);

                                            if (!player.level().isClientSide) {
                                                player.displayClientMessage(Component.translatable("allevent.moonstone.virus").append(name).withStyle(ChatFormatting.RED), true);
                                            }
                                        }
                                    }
                                }else {
                                    stack.set(DataReg.tag,new CompoundTag());
                                }
                            }

                        }
                    }
                });
            }

        }

    }
    @SubscribeEvent
    public  void parasite(LivingEntityUseItemEvent.Finish event) {
        if (event.getEntity() instanceof Player player){
            CuriosApi.getCuriosInventory(player).ifPresent(handler -> {
                Map<String, ICurioStacksHandler> curios = handler.getCurios();
                for (Map.Entry<String, ICurioStacksHandler> entry : curios.entrySet()) {
                    ICurioStacksHandler stacksHandler = entry.getValue();
                    IDynamicStackHandler stackHandler = stacksHandler.getStacks();
                    for (int i = 0; i < stacksHandler.getSlots(); i++) {
                        ItemStack stack = stackHandler.getStackInSlot(i);
                        if (stack.is(Items.parasite.get())) {
                            CompoundTag tag = stack.get(DataReg.tag);
                            if (tag != null) {
                                if (Handler.hascurio(player, Items.parasite.get())) {
                                    if (Handler.hascurio(player, Items.parasite.get())) {
                                        if (event.getItem().getUseAnimation() == UseAnim.EAT) {
                                            if (event.getItem().getFoodProperties(player) != null) {
                                                int siz = (int) (event.getItem().getFoodProperties(player).nutrition() + event.getItem().getFoodProperties(player).saturation());
                                                if (tag.getInt(lvl_parasite) <= 1) {
                                                    siz /= 2;
                                                    tag.putInt(sizeLevel, tag.getInt(sizeLevel) + siz);

                                                    if (player.getFoodData().getFoodLevel() < 19) {
                                                        player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() - 1);
                                                    }
                                                }
                                                if (tag.getInt(lvl_parasite) <= 2 && tag.getInt(lvl_parasite) > 1) {
                                                    siz /= 3;
                                                    tag.putInt(sizeLevel, tag.getInt(sizeLevel) + siz);
                                                    if (player.getFoodData().getFoodLevel() < 19) {
                                                        player.getFoodData().setSaturation(player.getFoodData().getSaturationLevel() - 1);
                                                    }
                                                }
                                                if (tag.getInt(lvl_parasite) <= 3 && tag.getInt(lvl_parasite) > 2) {
                                                    siz /= 4;
                                                    tag.putInt(sizeLevel, tag.getInt(sizeLevel) + siz);
                                                    if (player.getFoodData().getFoodLevel() < 19) {
                                                        player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() - 1);
                                                        player.getFoodData().setSaturation(player.getFoodData().getSaturationLevel() - 1);
                                                    }
                                                }
                                                if (!player.level().isClientSide) {
                                                    player.displayClientMessage(Component.translatable("寄生虫增长了" + (siz) + "克").withStyle(ChatFormatting.RED), true);
                                                }
                                            }
                                        }
                                    }
                                }
                            }else {
                                stack.set(DataReg.tag,new CompoundTag());
                            }
                        }
                    }
                }
            });
        }
    }
    @SubscribeEvent
    public  void germ(BlockEvent.BreakEvent event) {

        Player player = event.getPlayer();
        if (Handler.hascurio(player, Items.germ.get())) {
            CuriosApi.getCuriosInventory(player).ifPresent(handler -> {
                Map<String, ICurioStacksHandler> curios = handler.getCurios();
                for (Map.Entry<String, ICurioStacksHandler> entry : curios.entrySet()) {
                    ICurioStacksHandler stacksHandler = entry.getValue();
                    IDynamicStackHandler stackHandler = stacksHandler.getStacks();
                    for (int i = 0; i < stacksHandler.getSlots(); i++) {
                        ItemStack stack = stackHandler.getStackInSlot(i);
                        {
                            CompoundTag tag = stack.get(DataReg.tag);
                            if (tag != null) {

                                int s = 250;
                                tag.putInt(lvlSize,  tag.getInt(lvlSize)+1);
                                if (tag.getInt(lvlSize) > s && tag.getInt(lvlSize) < s*2){
                                    if (tag.getInt(lvl)!= 1) {
                                        tag.putInt(lvl, 1);
                                    }
                                }
                                if (tag.getInt(lvlSize) >  s*2 && tag.getInt(lvlSize) <  s*3){
                                    if (tag.getInt(lvl)!= 2) {
                                        tag.putInt(lvl, 2);
                                    }
                                }
                                if (tag.getInt(lvlSize) >  s*3){
                                    if (tag.getInt(lvl)!= 3) {
                                        tag.putInt(lvl, 3);
                                    }
                                }
                            }else {
                                stack.set(DataReg.tag,new CompoundTag());
                            }
                        }
                    }
                }
            });
        }
    }
    @SubscribeEvent
    public  void fungus(LivingHealEvent event){
        if (event.getEntity() instanceof Player player){
            if (Handler.hascurio(player, Items.fungus.get())){
                Vec3 playerPos = player.position().add(0, 0.75, 0);
                int range = 10;
                List<LivingEntity> entities = player.level().getEntitiesOfClass(LivingEntity.class, new AABB(playerPos.x - range, playerPos.y - range, playerPos.z - range, playerPos.x + range, playerPos.y + range, playerPos.z + range));
                int integers = 0;
                for (LivingEntity living : entities) {
                    if (fungus_boolean(living,player)){
                        integers++;
                    }
                }
                float integer = integers;
                integer /= 10;
                integer *= 2.5f;
                if (integer > 1.5f){
                    integer = 1.5f;
                }
                aFloat = integer;
                event.setAmount(event.getAmount() *(1+integer));

            }
        }
    }
    @SubscribeEvent
    public  void fungus(LivingDeathEvent event) {
        if (event.getSource().getEntity() instanceof Player player){
            if (Handler.hascurio(player, Items.fungus.get())){
                LivingEntity living =event.getEntity();
                BlockState state = living.level().getBlockState(new BlockPos(living.getBlockX(), living.getBlockY() - 1, living.getBlockZ()));
                if (state.is(Blocks.GRASS_BLOCK)) {
                    living.level().setBlock(new BlockPos(living.getBlockX(), living.getBlockY() - 1, living.getBlockZ()), Blocks.MYCELIUM.defaultBlockState(), 3);
                }
                BlockState MYC = living.level().getBlockState(new BlockPos(living.getBlockX(), living.getBlockY(), living.getBlockZ()));


                if (!player.getCooldowns().isOnCooldown(Items.fungus.get())) {
                    player.getCooldowns().addCooldown(Items.fungus.get(),200);
                }

                if (MYC.is(Blocks.AIR)) {
                    if (living.level().getBlockState(new BlockPos(living.getBlockX(), living.getBlockY()-1, living.getBlockZ())).is(Blocks.MYCELIUM)) {
                        if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
                            living.level().setBlock(new BlockPos(living.getBlockX(), living.getBlockY(), living.getBlockZ()), Blocks.RED_MUSHROOM.defaultBlockState(), 3);
                        } else {
                            living.level().setBlock(new BlockPos(living.getBlockX(), living.getBlockY(), living.getBlockZ()), Blocks.BROWN_MUSHROOM.defaultBlockState(), 3);
                        }
                    }
                }

            }
        }

    }

    @SubscribeEvent
    public void dna(LivingDeathEvent event) {
        if (event.getSource().getEntity() instanceof Player player){
            if (Handler.hascurio(player,  Items.dna.get())) {
                if (event.getEntity() instanceof MushroomCow) {
                    CuriosApi.getCuriosInventory(player).ifPresent(handler -> {
                        Map<String, ICurioStacksHandler> curios = handler.getCurios();
                        for (Map.Entry<String, ICurioStacksHandler> entry : curios.entrySet()) {
                            ICurioStacksHandler stacksHandler = entry.getValue();
                            IDynamicStackHandler stackHandler = stacksHandler.getStacks();
                            for (int i = 0; i < stacksHandler.getSlots(); i++) {
                                ItemStack stack = stackHandler.getStackInSlot(i);
                                if (stack.getItem() instanceof dna) {
                                    if (player.hasEffect(MobEffects.WEAKNESS)) {
                                        CompoundTag tag = stack.get(DataReg.tag);
                                        if (tag != null) {
                                            if (Mth.nextInt(RandomSource.create(), 1, 10) == 1) {
                                                if (tag != null && !tag.getBoolean(fungus)) {
                                                    player.addItem(new ItemStack(Items.fungus.get()));
                                                    tag.putBoolean(fungus, true);
                                                }
                                            }
                                        }else {
                                            stack.set(DataReg.tag,new CompoundTag());
                                        }
                                    }
                                }
                            }
                        }
                    });

                }
            }
        }
    }
    @SubscribeEvent
    public void LivingEntityUseItemEvent(LivingEntityUseItemEvent.Finish event) {
        if (event.getEntity() instanceof Player player) {
            if (Handler.hascurio(player, Items.dna.get())&&!Handler.hascurio(player, Items.parasite.get())) {
                CuriosApi.getCuriosInventory(player).ifPresent(handler -> {
                    Map<String, ICurioStacksHandler> curios = handler.getCurios();
                    for (Map.Entry<String, ICurioStacksHandler> entry : curios.entrySet()) {
                        ICurioStacksHandler stacksHandler = entry.getValue();
                        IDynamicStackHandler stackHandler = stacksHandler.getStacks();
                        for (int i = 0; i < stacksHandler.getSlots(); i++) {
                            ItemStack stack = stackHandler.getStackInSlot(i);

                            CompoundTag tag = stack.get(DataReg.tag);
                            if (tag != null) {
                                if (tag.getBoolean(cod)&&
                                        tag.getBoolean(SALMON)&&
                                        tag.getBoolean(CHICKEN)&&
                                        tag.getBoolean(BEEF)&&
                                        tag.getBoolean(RABBIT)&&
                                        tag.getBoolean(MUTTON)&&
                                        tag.getBoolean(PORKCHOP)&&
                                        tag.getBoolean(TROPICAL_FISH))
                                {
                                    if (!tag.getBoolean(give)){
                                        player.addItem(new ItemStack(Items.parasite.get()));
                                        tag.putBoolean(give, true);
                                    }
                                }
                                if (tag.getBoolean(give)){
                                    return;
                                }
                                if (event.getItem().is(net.minecraft.world.item.Items.COD)){
                                    tag.putBoolean(cod, true);
                                }

                                if (event.getItem().is(net.minecraft.world.item.Items.SALMON)){
                                    tag.putBoolean(SALMON, true);
                                }
                                if (event.getItem().is(net.minecraft.world.item.Items.CHICKEN)){
                                    tag.putBoolean(CHICKEN, true);
                                }
                                if (event.getItem().is(net.minecraft.world.item.Items.BEEF)){
                                    tag.putBoolean(BEEF, true);
                                }
                                if (event.getItem().is(net.minecraft.world.item.Items.RABBIT)){
                                    tag.putBoolean(RABBIT, true);
                                }
                                if (event.getItem().is(net.minecraft.world.item.Items.MUTTON)){
                                    tag.putBoolean(MUTTON, true);
                                }

                                if (event.getItem().is(net.minecraft.world.item.Items.PORKCHOP)){
                                    tag.putBoolean(PORKCHOP, true);
                                }
                                if (event.getItem().is(net.minecraft.world.item.Items.TROPICAL_FISH)){
                                    tag.putBoolean(TROPICAL_FISH, true);
                                }
                            }else {
                                stack.set(DataReg.tag,new CompoundTag());
                            }
                        }
                    }
                });
            }
        }
    }
    @SubscribeEvent
    public  void LivingIncomingDamageEvent_DNA(LivingIncomingDamageEvent event) {
        if (event.getEntity() instanceof Player player){
            if (event.getSource()!= null && event.getSource().getEntity() instanceof WitherSkeleton){
                if (Handler.hascurio(player, Items.dna.get())){
                    CuriosApi.getCuriosInventory(player).ifPresent(handler -> {
                        Map<String, ICurioStacksHandler> curios = handler.getCurios();
                        for (Map.Entry<String, ICurioStacksHandler> entry : curios.entrySet()) {
                            ICurioStacksHandler stacksHandler = entry.getValue();
                            IDynamicStackHandler stackHandler = stacksHandler.getStacks();
                            for (int i = 0; i < stacksHandler.getSlots(); i++) {
                                ItemStack stack = stackHandler.getStackInSlot(i);
                                if (stack.getItem() instanceof dna) {
                                    if (player.hasEffect(MobEffects.WEAKNESS)) {
                                        if (Mth.nextInt(RandomSource.create(), 1, 10) == 1) {
                                            CompoundTag tag = stack.get(DataReg.tag);
                                            if (tag != null) {
                                                if (tag != null && tag.getString(virus).isEmpty()) {
                                                    player.addItem(new ItemStack(Items.virus.get()));
                                                    tag.putString(virus, virus);
                                                }
                                            }else {
                                                stack.set(DataReg.tag,new CompoundTag());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    });
                }
            }
        }
    }


    @SubscribeEvent
    public  void PlayerLoggedInEvent(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        if (!player.getTags().contains("welcome_to_moonstone")) {
            int a = Mth.nextInt(RandomSource.create(), 1, 5);
            if (a == 1) {
                player.addItem(Items.run_dna.get().getDefaultInstance());
            }
            if (a == 2) {
                player.addItem(Items.health_dna.get().getDefaultInstance());
            }
            if (a == 3) {
                player.addItem(Items.neuron_dna.get().getDefaultInstance());
            }
            if (a == 4) {
                player.addItem(Items.eye_dna.get().getDefaultInstance());
            }
            if (a == 5) {
                player.addItem(Items.skin_dna.get().getDefaultInstance());
            }
            player.addItem(Items.deceased_contract.get().getDefaultInstance());
            player.addTag("welcome_to_moonstone");
        }
    }







    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public void RenderTooltipEven4t(RenderTooltipEvent.Color tooltipEvent){
        ItemStack stack = tooltipEvent.getItemStack();
        if (stack.getItem() instanceof IEctoplasm) {
            tooltipEvent.setBorderStart(0xFF87CEFA);
            tooltipEvent.setBorderEnd(0xFFF8F8FF);
        }
        if (stack.getItem() instanceof MLS) {
            tooltipEvent.setBorderStart(0xFF006400);
            tooltipEvent.setBorderEnd(0xFF006400);
        }
        if (stack.getItem() instanceof INightmare) {
            tooltipEvent.setBorderStart(0xFF800000);
            tooltipEvent.setBorderEnd(0xFF800080);

            tooltipEvent.setBackgroundStart(0x00000000);
            tooltipEvent.setBackgroundEnd(0x00000000);
        }
        if (stack.getItem() instanceof IDoom ||stack.getItem() instanceof Perhaps) {
            tooltipEvent.setBorderStart(0xFF83DEFC);
            tooltipEvent.setBorderEnd(0xFF0296FE);

            tooltipEvent.setBackgroundStart(0x00000000);
            tooltipEvent.setBackgroundEnd(0x00000000);

        }

        if (stack.getItem() instanceof Die) {
            tooltipEvent.setBorderStart(0x0ff9C9C9C);
            tooltipEvent.setBorderEnd(0x0ff9C9C9C);
            tooltipEvent.setBackgroundStart(0xFF000000);
            tooltipEvent.setBackgroundEnd(0xFF000000);
        }

        if (stack.getItem() instanceof ManDNA) {
            tooltipEvent.setBorderStart(0xFF800000);
            tooltipEvent.setBorderEnd(0x0ff800000);
            tooltipEvent.setBackgroundStart(0x00000000);
            tooltipEvent.setBackgroundEnd(0x00000000);
        }

        if (stack.getItem() instanceof Iplague) {
            tooltipEvent.setBorderStart(0xFF800000);
            tooltipEvent.setBorderEnd(0x0ff800000);
            tooltipEvent.setBackgroundStart(0x00000000);
            tooltipEvent.setBackgroundEnd(0x00000000);
        }
    }
    public static boolean fungus_boolean(LivingEntity living,Player player){
        if (!living.is(player)) {
            if (living.isAlliedTo(player)) {
                return true;
            }
        }
        if (living instanceof OwnableEntity ownableEntity){
            return ownableEntity.getOwner() != null && ownableEntity.getOwner().is(player);
        }
        return false;
    }


}

