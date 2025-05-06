package com.ytgld.seeking_immortal_virus.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.ytgld.seeking_immortal_virus.ConfigClient;
import com.ytgld.seeking_immortal_virus.Handler;
import com.ytgld.seeking_immortal_virus.SeekingImmortalVirus;
import com.ytgld.seeking_immortal_virus.client.renderer.MRender;
import com.ytgld.seeking_immortal_virus.client.renderer.MoonPost;
import com.ytgld.seeking_immortal_virus.entity.nightmare.NEmissiveLay;
import com.ytgld.seeking_immortal_virus.entity.nightmare.NModel;
import com.ytgld.seeking_immortal_virus.entity.ytgld;
import com.ytgld.seeking_immortal_virus.entity.zombie.cell_giant;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class YtgldRender  extends MobRenderer<ytgld, NModel<ytgld>> {
    private static final ResourceLocation TEXTURE =  ResourceLocation.fromNamespaceAndPath(SeekingImmortalVirus.MODID,"textures/entity/ytgld.png");

    public YtgldRender(EntityRendererProvider.Context p_234787_) {
        super(p_234787_, new NModel<>(p_234787_.bakeLayer(ModelLayers.WARDEN)), 0.9F);


        this.addLayer(new NEmissiveLay<>(this, TEXTURE, (p_234797_, p_234798_, p_234799_) -> {
            return p_234797_.getTendrilAnimation(p_234798_);
        }, NModel::getTendrilsLayerModelParts));

    }
    @Override
    public void render(ytgld nightmareGiant, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        super.render(nightmareGiant, entityYaw, partialTicks, poseStack, buffer, packedLight);
        if (ConfigClient.Client.Shader.get()) {
            MoonPost.renderEffectForNextTick(SeekingImmortalVirus.POST);
        }
        Vec3 playerPos = nightmareGiant.position();
        float range =16;
        List<cell_giant> entities =
                nightmareGiant.level().getEntitiesOfClass(cell_giant.class,
                        new AABB(playerPos.x - range,
                                playerPos.y - range,
                                playerPos.z - range,
                                playerPos.x + range,
                                playerPos.y + range,
                                playerPos.z + range));

        for (cell_giant entity : entities) {
            Vec3 entityPos = nightmareGiant.position();
            Vec3 nearbyEntityPos = entity.position();

            Vec3 end = nearbyEntityPos.subtract(entityPos);

            Handler.renderLine(poseStack, buffer, new Vec3(0,2,0), end,1, MRender.Snake(),0.001f);
        }
    }


    @Override
    protected void scale(ytgld livingEntity, PoseStack poseStack, float partialTickTime) {
        poseStack.scale(2,2,2);
    }

    public ResourceLocation getTextureLocation(ytgld p_234791_) {
        return TEXTURE;
    }
}

