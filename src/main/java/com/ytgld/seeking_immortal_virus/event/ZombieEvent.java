package com.ytgld.seeking_immortal_virus.event;

import com.ytgld.seeking_immortal_virus.item.man.*;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.living.LivingHealEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

public class ZombieEvent {
    @SubscribeEvent
    public  void LivingIncomingDamageEvent(LivingIncomingDamageEvent event){
        muscle_conversion.zombieAttack(event);
        chemical_compound.zombieDie(event,5);
        phosphate_bond.damage5(event,6);
        chemical_compound.healDamage(event,20,12);
    }
    @SubscribeEvent
    public  void LivingHealEvent(LivingHealEvent event){
        phosphate_bond.healZombie(event);
        chemical_compound.healZombie(event,25,12);
        white_blood_cells_are_abruptly_reduced.dieZombie(event,15);
    }
    @SubscribeEvent
    public  void LivingDeathEvent(LivingDeathEvent event){
        phosphate_bond.dieZombie(event,10);
        skin_glucose_fermentation.dieZombie(event,50);
    }
}
