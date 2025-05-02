package com.ytgld.seeking_immortal_virus.mixin;

import com.ytgld.seeking_immortal_virus.Config;
import com.ytgld.seeking_immortal_virus.Handler;
import com.ytgld.seeking_immortal_virus.event.old.EquippedEvt;
import com.ytgld.seeking_immortal_virus.event.old.NewEvent;
import com.ytgld.seeking_immortal_virus.init.items.Items;
import com.ytgld.seeking_immortal_virus.init.moonstoneitem.DataReg;
import com.ytgld.seeking_immortal_virus.item.man.run_dna;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.inventory.ICurioStacksHandler;
import top.theillusivec4.curios.api.type.inventory.IDynamicStackHandler;

import java.util.Map;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    public LivingEntityMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }
//
//    @Unique
//    private static final EntityDataAccessor<Integer> INTEGER_ENTITY_DATA_ACCESSOR =
//            SynchedEntityData.defineId(LivingEntity.class, EntityDataSerializers.INT);
//
//
//    @Override
//    public int getSize() {
//        return entityData.get(INTEGER_ENTITY_DATA_ACCESSOR);
//    }
//
//
//    @Inject(at = @At("RETURN"), method = "hurt")
//    public void hurt(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir){
//        if (entityData.get(INTEGER_ENTITY_DATA_ACCESSOR) < 10) {
//            entityData.set(INTEGER_ENTITY_DATA_ACCESSOR,entityData.get(INTEGER_ENTITY_DATA_ACCESSOR)+1);
//        }
//    }
//    @Inject(at = @At("RETURN"), method = "defineSynchedData")
//    public void defineSynchedData(SynchedEntityData.Builder builder, CallbackInfo ci){
//        builder.define(INTEGER_ENTITY_DATA_ACCESSOR, 0);
//
//    }
//    @Inject(at = @At("RETURN"), method = "tick")
//    public void tick(CallbackInfo ci){
//        if (entityData.get(INTEGER_ENTITY_DATA_ACCESSOR) > 0) {
//            if (tickCount%200==1) {
//                entityData.set(INTEGER_ENTITY_DATA_ACCESSOR, entityData.get(INTEGER_ENTITY_DATA_ACCESSOR) - 1);
//            }
//        }
//    }
    @Shadow public abstract ItemStack getItemInHand(InteractionHand p_21121_);

    @Shadow protected abstract void setLivingEntityFlag(int p_21156_, boolean p_21157_);
    @Inject(at = @At("RETURN"), method = "getArmorValue", cancellable = true)
    public void getArmorValue(CallbackInfoReturnable<Integer> cir){

        if ((LivingEntity) (Object) this instanceof Player player) {
            CuriosApi.getCuriosInventory(player).ifPresent(handler -> {
                Map<String, ICurioStacksHandler> curios = handler.getCurios();
                for (Map.Entry<String, ICurioStacksHandler> entry : curios.entrySet()) {
                    ICurioStacksHandler stacksHandler = entry.getValue();
                    IDynamicStackHandler stackHandler = stacksHandler.getStacks();
                    for (int i = 0; i < stacksHandler.getSlots(); i++) {
                        ItemStack stack = stackHandler.getStackInSlot(i);
                        if (stack.get(DataReg.tag) != null) {

                            float h = stack.get(DataReg.tag).getFloat(NewEvent.die_body);//1
                            if (h != 0) {
                                cir.setReturnValue((int) (cir.getReturnValue() + (h)));
                            }

                        }
                    }
                }
            });
        }
    }
    @Inject(at = @At("RETURN"), method = "getMaxHealth", cancellable = true)
    public void getMaxHealth(CallbackInfoReturnable<Float> cir) {
        if ((LivingEntity) (Object) this instanceof Player player){


            CuriosApi.getCuriosInventory(player).ifPresent(handler -> {
                Map<String, ICurioStacksHandler> curios = handler.getCurios();
                for (Map.Entry<String, ICurioStacksHandler> entry : curios.entrySet()) {
                    ICurioStacksHandler stacksHandler = entry.getValue();
                    IDynamicStackHandler stackHandler = stacksHandler.getStacks();
                    for (int i = 0; i < stacksHandler.getSlots(); i++) {
                        ItemStack stack = stackHandler.getStackInSlot(i);
                        if (stack.get(DataReg.tag)!=null){

                            float h = stack.get(DataReg.tag).getFloat(NewEvent.meet);//1
                            if (h!=0) {
                                cir.setReturnValue(cir.getReturnValue() + (h));
                            }


                            if (stack.get(DataReg.tag).getBoolean(Difficulty.EASY.getKey())){
                                cir.setReturnValue(cir.getReturnValue()+0.175f);
                            }
                            if (stack.get(DataReg.tag).getBoolean(Difficulty.NORMAL.getKey())){
                                cir.setReturnValue(cir.getReturnValue()+0.33f);
                            }
                            if (stack.get(DataReg.tag).getBoolean(Difficulty.HARD.getKey())){
                                cir.setReturnValue(cir.getReturnValue()+0.5f);
                            }
                            if (stack.get(DataReg.tag).getBoolean(NewEvent.lootTable)){
                                cir.setReturnValue(cir.getReturnValue()+0.66f);
                            }
                            if (stack.get(DataReg.tag).getBoolean(EquippedEvt.isGod)){
                                cir.setReturnValue(cir.getReturnValue()+1.0f);
                            }
                        }
                    }
                }
            });
        }
    }

    @Inject(at = @At("RETURN"), method = "travel")
    public void moonstone$travel(Vec3 p_21280_, CallbackInfo ci) {
        LivingEntity living = (LivingEntity) (Object) this;
        if (living instanceof Player player) {

            if (player.isSprinting()) {
                if (Handler.hascurio(player, Items.flygene.get())) {
                    player.moveRelative((float) (player.getSpeed() * Config.SERVER.flygene_speed.get()), p_21280_);
                    if (!player.onGround()) {
                        player.moveRelative((float) (player.getSpeed() * Config.SERVER.flygene_speed.get()), p_21280_);
                    }
                }
                if (Handler.hascurio(player, Items.bloodvirus.get())) {
                    player.moveRelative((float) (player.getSpeed() * Config.SERVER.bloodvirus_speed.get()), p_21280_);
                }
                if (Handler.hascurio(player, Items.motor.get())) {
                    player.moveRelative((float) (player.getSpeed() * Config.SERVER.motor_speed.get()), p_21280_);
                }

            }
        }
    }
    @Inject(at = @At("RETURN"), method = "getJumpPower", cancellable = true)
    public void getJumpPower(CallbackInfoReturnable<Float> cir) {



        LivingEntity living = (LivingEntity) (Object) this;
        if (living instanceof Player player) {

            run_dna.hydrolysis(cir,player);
            if (Handler.hascurio(player, Items.quadriceps.get())) {
                cir.setReturnValue(cir.getReturnValue() * 1.5f);
            }
        }
    }
}
