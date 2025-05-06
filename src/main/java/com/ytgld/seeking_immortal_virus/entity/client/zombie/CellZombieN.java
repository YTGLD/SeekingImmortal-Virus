package com.ytgld.seeking_immortal_virus.entity.client.zombie;

import com.mojang.blaze3d.vertex.PoseStack;
import com.ytgld.seeking_immortal_virus.ConfigClient;
import com.ytgld.seeking_immortal_virus.Handler;
import com.ytgld.seeking_immortal_virus.SeekingImmortalVirus;
import com.ytgld.seeking_immortal_virus.client.renderer.MRender;
import com.ytgld.seeking_immortal_virus.client.renderer.MoonPost;
import com.ytgld.seeking_immortal_virus.entity.nightmare.NEmissiveLay;
import com.ytgld.seeking_immortal_virus.entity.nightmare.NModel;
import com.ytgld.seeking_immortal_virus.entity.nightmare.nightmare_giant;
import com.ytgld.seeking_immortal_virus.entity.zombie.cell_zombie;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class CellZombieN extends MobRenderer<nightmare_giant, NModel<nightmare_giant>> {
    private static final ResourceLocation TEXTURE =  ResourceLocation.fromNamespaceAndPath(SeekingImmortalVirus.MODID,"textures/entity/nightmare_giant.png");
    private static final ResourceLocation PULSATING_SPOTS_TEXTURE_1 =  ResourceLocation.fromNamespaceAndPath(SeekingImmortalVirus.MODID,"textures/entity/nig_boot.png");
    private static final ResourceLocation PULSATING_SPOTS_TEXTURE_2 =   ResourceLocation.fromNamespaceAndPath(SeekingImmortalVirus.MODID,"textures/entity/nig_boot_2.png");

    public CellZombieN(EntityRendererProvider.Context p_234787_) {
        super(p_234787_, new NModel<>(p_234787_.bakeLayer(ModelLayers.WARDEN)), 0.9F);

        this.addLayer(new NEmissiveLay<>(this, PULSATING_SPOTS_TEXTURE_1, (p_234805_, p_234806_, p_234807_) -> {
            return Math.max(0.0F, Mth.cos(p_234807_ * 0.045F) * 0.25F);
        }, NModel::getPulsatingSpotsLayerModelParts));

        this.addLayer(new NEmissiveLay<>(this, PULSATING_SPOTS_TEXTURE_2, (p_234801_, p_234802_, p_234803_) -> {
            return Math.max(0.0F, Mth.cos(p_234803_ * 0.045F + (float)Math.PI) * 0.25F);
        }, NModel::getPulsatingSpotsLayerModelParts));

        this.addLayer(new NEmissiveLay<>(this, TEXTURE, (p_234797_, p_234798_, p_234799_) -> {
            return p_234797_.getTendrilAnimation(p_234798_);
        }, NModel::getTendrilsLayerModelParts));

    }

    @Override
    public void render(nightmare_giant nightmareGiant, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        super.render(nightmareGiant, entityYaw, partialTicks, poseStack, buffer, packedLight);
        if (ConfigClient.Client.Shader.get()) {
            MoonPost.renderEffectForNextTick(SeekingImmortalVirus.POST);
        }
        Vec3 playerPos = nightmareGiant.position();
        float range =16;
        List<cell_zombie> entities =
                nightmareGiant.level().getEntitiesOfClass(cell_zombie.class,
                        new AABB(playerPos.x - range,
                                playerPos.y - range,
                                playerPos.z - range,
                                playerPos.x + range,
                                playerPos.y + range,
                                playerPos.z + range));

        for (cell_zombie entity : entities) {
            Vec3 entityPos = nightmareGiant.position();
            Vec3 nearbyEntityPos = entity.position();

            Vec3 end = nearbyEntityPos.subtract(entityPos);

            Handler.renderLine(poseStack, buffer, new Vec3(0,2,0), end,1,MRender.Snake_p_blood,0.01f);
        }
    }


    @Override
    protected void scale(nightmare_giant livingEntity, PoseStack poseStack, float partialTickTime) {
        poseStack.scale(1.35f,1.35f,1.35f);
    }

    public ResourceLocation getTextureLocation(nightmare_giant p_234791_) {
        return TEXTURE;
    }
}
