package com.ytgld.seeking_immortal_virus.entity.client.blood;

import com.mojang.blaze3d.vertex.PoseStack;
import com.ytgld.seeking_immortal_virus.entity.bloodvruis.blood_bat;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BloodBatRenderer extends MobRenderer<blood_bat, BloodBatModel> {
    private static final ResourceLocation BAT_LOCATION = ResourceLocation.withDefaultNamespace("textures/entity/bat.png");

    public BloodBatRenderer(EntityRendererProvider.Context p_173929_) {
        super(p_173929_, new BloodBatModel(p_173929_.bakeLayer(ModelLayers.BAT)), 0.25F);
    }

    public ResourceLocation getTextureLocation(blood_bat p_113876_) {
        return BAT_LOCATION;
    }

    protected void scale(blood_bat p_113878_, PoseStack p_113879_, float p_113880_) {
        p_113879_.scale(1.4f, 1.4f, 1.4f);
    }

}
