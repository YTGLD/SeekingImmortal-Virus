package com.ytgld.seeking_immortal_virus.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.ytgld.seeking_immortal_virus.client.renderer.MRender;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class CircleCubeBoom {

    public CircleCubeBoom(@NotNull PoseStack matrices,
                          @NotNull MultiBufferSource vertexConsumers,
                          int light,
                          @NotNull Entity entity) {



        float alp =100;
        alp -= entity.tickCount;
        if (alp>10){
            alp -= entity.tickCount*2;
        }
        if (alp <0){
            alp = 0;
        }

        alp /= 100;

        {

            matrices.pushPose();
            renderCircle3(matrices, vertexConsumers, light, 0, 0, 0,1+entity.tickCount/33f, alp, entity);
            matrices.popPose();
        }

    }



    public  void renderCircle3(@NotNull PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, float x, float y, float z, float radius,float alp , Entity entity) {
        VertexConsumer vertexConsumer = bufferSource.getBuffer(MRender.lines());
        int verticalSegments = 6; // 垂直段数
        int horizontalSegments = 6; // 水平段数
        poseStack.translate(0 ,1 ,0);
        poseStack.mulPose(Axis.XP.rotationDegrees((float) (-entity.tickCount)));
        poseStack.mulPose(Axis.YP.rotationDegrees((float) (-entity.tickCount)));


        for (int i = 0; i < verticalSegments; i++) {
            float vAngle1 = (float) (Math.PI * i / verticalSegments);
            float vAngle2 = (float) (Math.PI * (i + 1) / verticalSegments);

            for (int j = 0; j < horizontalSegments; j++) {
                float hAngle1 = (float) (2 * Math.PI * j / horizontalSegments);
                float hAngle2 = (float) (2 * Math.PI * (j + 1) / horizontalSegments);

                float x1 = (float) (x + radius * Math.sin(vAngle1) * Math.cos(hAngle1));
                float y1 = (float) (y + radius * Math.cos(vAngle1));
                float z1 = (float) (z + radius * Math.sin(vAngle1) * Math.sin(hAngle1));

                float x2 = (float) (x + radius * Math.sin(vAngle1) * Math.cos(hAngle2));
                float y2 = (float) (y + radius * Math.cos(vAngle1));
                float z2 = (float) (z + radius * Math.sin(vAngle1) * Math.sin(hAngle2));

                float x3 = (float) (x + radius * Math.sin(vAngle2) * Math.cos(hAngle1));
                float y3 = (float) (y + radius * Math.cos(vAngle2));
                float z3 = (float) (z + radius * Math.sin(vAngle2) * Math.sin(hAngle1));

                float x4 = (float) (x + radius * Math.sin(vAngle2) * Math.cos(hAngle2));
                float y4 = (float) (y + radius * Math.cos(vAngle2));
                float z4 = (float) (z + radius * Math.sin(vAngle2) * Math.sin(hAngle2));

                // 绘制两个三角形
                vertexConsumer.addVertex(poseStack.last().pose(), x1, y1, z1).setColor(0, 0, 0, alp).setUv(0, 0).setOverlay(OverlayTexture.NO_OVERLAY).setUv2(packedLight,packedLight).setNormal(1, 0, 0);
                vertexConsumer.addVertex(poseStack.last().pose(), x2, y2, z2).setColor(0, 0, 0, alp).setUv(0, 0).setOverlay(OverlayTexture.NO_OVERLAY).setUv2(packedLight,packedLight).setNormal(1, 0, 0);
                vertexConsumer.addVertex(poseStack.last().pose(), x3, y3, z3).setColor(0, 0, 0, alp).setUv(0, 0).setOverlay(OverlayTexture.NO_OVERLAY).setUv2(packedLight,packedLight).setNormal(1, 0, 0);

                vertexConsumer.addVertex(poseStack.last().pose(), x2, y2, z2).setColor(0, 0, 0, alp).setUv(0, 0).setOverlay(OverlayTexture.NO_OVERLAY).setUv2(packedLight,packedLight).setNormal(1, 0, 0);
                vertexConsumer.addVertex(poseStack.last().pose(), x3, y3, z3).setColor(0, 0, 0, alp).setUv(0, 0).setOverlay(OverlayTexture.NO_OVERLAY).setUv2(packedLight,packedLight).setNormal(1, 0, 0);
                vertexConsumer.addVertex(poseStack.last().pose(), x4, y4, z4).setColor(0, 0, 0, alp).setUv(0, 0).setOverlay(OverlayTexture.NO_OVERLAY).setUv2(packedLight,packedLight).setNormal(1, 0, 0);
            }
        }
    }

}
