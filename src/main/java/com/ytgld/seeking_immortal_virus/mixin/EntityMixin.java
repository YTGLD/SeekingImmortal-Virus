package com.ytgld.seeking_immortal_virus.mixin;

import com.ytgld.seeking_immortal_virus.Config;
import com.ytgld.seeking_immortal_virus.SeekingImmortalVirus;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class EntityMixin {
    @Shadow
    public abstract Vec3 position();

    @Inject(at = @At("RETURN"), method = "isInvulnerableTo", cancellable = true)
    public void mhead(DamageSource p_20122_, CallbackInfoReturnable<Boolean> cir) {


        if (p_20122_.getEntity() instanceof Player player){
            Entity entity = (Entity) (Object) this;
            if (entity instanceof TamableAnimal tamableAnimal){
                ResourceLocation resourceLocation = BuiltInRegistries.ENTITY_TYPE.getKey(tamableAnimal.getType());
                if (resourceLocation.getNamespace().equals(SeekingImmortalVirus.MODID)){
                    if (tamableAnimal.getOwner()!=null &&tamableAnimal.getOwner().is(player)){
                        if (Config.SERVER.immortalZombie.get()){
                            cir.setReturnValue(true);
                        }
                    }
                }
            }
        }
    }
}
