package com.ytgld.seeking_immortal_virus.mixin.client;

import com.ytgld.seeking_immortal_virus.Handler;
import com.ytgld.seeking_immortal_virus.init.items.Items;
import net.minecraft.client.Camera;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.material.FogType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Camera.class)
public class CameraMixin {
    @Inject(at = {@At("RETURN")}, method = {"getFluidInCamera"}, cancellable = true)
    public void ca$renderItemDecorationsRenderItem(CallbackInfoReturnable<FogType> cir) {
        Camera camera = (Camera) (Object) this;
        if (camera.getEntity() instanceof Player player){
            if (Handler.hascurio(player, Items.eye_dna.get())){
                if (cir.getReturnValue().equals(FogType.WATER)){
                    cir.setReturnValue(FogType.NONE);
                }
            }
            if (Handler.hascurio(player, Items.eye_lava_dna.get())){
                cir.setReturnValue(FogType.NONE);
            }
        }
    }
}
