package com.ytgld.seeking_immortal_virus.event.old;

import com.ytgld.seeking_immortal_virus.Handler;
import com.ytgld.seeking_immortal_virus.init.items.Items;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingDropsEvent;

public class LootEvent {

    @SubscribeEvent
    public void zom(LivingDropsEvent event) {
        if (event.getSource().getEntity() instanceof Player player){
            int a = Mth.nextInt(RandomSource.create(), 1, 10);
            int ng = Mth.nextInt(RandomSource.create(), 1, 5);

            if (Handler.hascurio(player, Items.necora.get())) {
                if (Handler.hascurio(player, Items.giant.get())){
                    if (!Handler.hascurio(player, Items.giant_nightmare.get())){

                        if (event.getEntity() instanceof Warden) {
                            if (ng == 1) {
                                event.getDrops().add(new ItemEntity(event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), new ItemStack(Items.giant_nightmare.get())));
                            }
                        }
                    }
                }


                if (!Handler.hascurio(player, Items.giant.get())) {
                    if (event.getEntity() instanceof Warden elderGuardian) {
                        if (a == 1) {
                            event.getDrops().add(new ItemEntity(elderGuardian.level(), elderGuardian.getX(), elderGuardian.getY(), elderGuardian.getZ(), new ItemStack(Items.giant.get())));
                        }
                    }
                }
            }
        }
    }
}
