package com.ytgld.seeking_immortal_virus.mixin.client;

import com.ytgld.seeking_immortal_virus.Handler;
import com.ytgld.seeking_immortal_virus.SeekingImmortalVirus;
import com.ytgld.seeking_immortal_virus.init.items.Items;
import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.PostChain;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FogType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

@Mixin(GameRenderer.class)
public abstract class GameRendererMixin  {
    @Shadow @Final
    Minecraft minecraft;

    @Inject(at = {@At("RETURN")}, method = {"renderLevel"})
    public void renderLevel(DeltaTracker deltaTracker, CallbackInfo ci) {

    }
}
