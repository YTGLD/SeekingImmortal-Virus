package com.ytgld.seeking_immortal_virus.event.old;

import com.ytgld.seeking_immortal_virus.Config;
import com.ytgld.seeking_immortal_virus.init.items.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.LootTableLoadEvent;

public class LootTableEvent {

    @SubscribeEvent
    public void ItemTooltipEventASD(LootTableLoadEvent event){

        LootTable table = event.getTable();
        int bc = 2;

        if (event.getName().toString().contains("chests/")){

            if (event.getName().toString().contains("ancien")){
                table.addPool(LootPool.lootPool().name("ancien_moon")


                        .add(LootItem.lootTableItem(Items.ectoplasmball.get()).setWeight((int) (bc*30* Config.SERVER.common.get())))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))






                        .build());
            }

            if (event.getName().toString().contains("treasure")){
                table.addPool(LootPool.lootPool().name("treasures")
                        .add(LootItem.lootTableItem(Items.ectoplasmball.get()).setWeight((int) (bc*20* Config.SERVER.common.get())))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))


                        .add(LootItem.lootTableItem(Items.apple.get()).setWeight(1))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))



                        .add(LootItem.lootTableItem(Items.run_dna.get()).setWeight(1)).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                        .add(LootItem.lootTableItem(Items.health_dna.get()).setWeight(1)).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                        .add(LootItem.lootTableItem(Items.neuron_dna.get()).setWeight(1)).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                        .add(LootItem.lootTableItem(Items.eye_dna.get()).setWeight(1)).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                        .add(LootItem.lootTableItem(Items.skin_dna.get()).setWeight(1)).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))

                        .build());

                table.addPool(LootPool.lootPool().name("treasures_moons")
                        .add(LootItem.lootTableItem(Items.ectoplasmball.get()).setWeight((int) (bc*40* Config.SERVER.common.get())))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                        .build());
            }

            if (event.getName().toString().contains("dungeon") ||event.getName().toString().contains("mineshaft")){
                table.addPool(LootPool.lootPool().name("dungeon_or_mineshaft")
                        .add(LootItem.lootTableItem(Items.ectoplasmball.get()).setWeight((int) (bc*40* Config.SERVER.common.get())))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))

                        .add(LootItem.lootTableItem(Items.ectoplasmhorseshoe.get()).setWeight(1))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))

                        .build());





            }
        }
    }

}
