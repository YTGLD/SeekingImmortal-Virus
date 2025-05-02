package com.ytgld.seeking_immortal_virus.entity.nightmare;

import com.google.common.collect.ImmutableMap;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;

public class Emerging<E extends nightmare_giant> extends Behavior<E> {
    public Emerging(int pDuration) {
        super(
                ImmutableMap.of(
                        MemoryModuleType.IS_EMERGING,
                        MemoryStatus.VALUE_PRESENT,
                        MemoryModuleType.WALK_TARGET,
                        MemoryStatus.VALUE_ABSENT,
                        MemoryModuleType.LOOK_TARGET,
                        MemoryStatus.REGISTERED
                ),
                pDuration
        );
    }

    protected boolean canStillUse(ServerLevel pLevel, E pEntity, long pGameTime) {
        return true;
    }

    protected void start(ServerLevel pLevel, E pEntity, long pGameTime) {
        pEntity.setPose(Pose.EMERGING);
        pEntity.playSound(SoundEvents.WARDEN_EMERGE, 5.0F, 1.0F);
    }

    protected void stop(ServerLevel pLevel, E pEntity, long pGameTime) {
        if (pEntity.hasPose(Pose.EMERGING)) {
            pEntity.setPose(Pose.STANDING);
        }
    }
}
