package com.ytgld.seeking_immortal_virus.item.man;

import com.ytgld.seeking_immortal_virus.Handler;
import com.ytgld.seeking_immortal_virus.contents.ManBundleContents;
import com.ytgld.seeking_immortal_virus.entity.extend.MoonTamableAnimal;
import com.ytgld.seeking_immortal_virus.entity.zombie.cell_giant;
import com.ytgld.seeking_immortal_virus.entity.zombie.cell_zombie;
import com.ytgld.seeking_immortal_virus.init.items.Items;
import com.ytgld.seeking_immortal_virus.init.moonstoneitem.DataReg;
import com.ytgld.seeking_immortal_virus.init.moonstoneitem.i.Iplague;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.entity.living.LivingHealEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * 化合物合成：
 * <p>
 * 		每存在一只细胞僵尸，治疗增加15%
 * 		<p>
 * 		每存在一只巨型细胞僵尸，伤害提高10%
 * 		<p>
 * 		僵尸受伤有5%的概率使主人受到50%的当量伤害
 * <p>
 *      主人的攻击不会触发
 */
public class chemical_compound extends ManDNA implements Iplague {
    public chemical_compound() {
        super(new Properties().stacksTo(1).rarity(Rarity.RARE).component(DataReg.man,
                ManBundleContents.EMPTY));
    }
    public static void zombieDie(LivingIncomingDamageEvent event , int lv){
        if (Mth.nextInt(RandomSource.create(),0,100) < lv) {
            if (event.getEntity() instanceof MoonTamableAnimal moonTamableAnimal) {
                if (moonTamableAnimal.getOwner() instanceof Player player) {
                    if (event.getSource().getEntity() instanceof Player player1){
                        if (player1 == player){
                            return;
                        }
                    }

                    if (Handler.hascurio(player, Items.chemical_compound.get())) {
                        player.hurt(player.damageSources().dryOut(),event.getAmount()/5f);
                    }
                }
            }
        }
    }
    public static void healZombie(LivingHealEvent event , int heal,int range){
        if (event.getEntity() instanceof Player player){
            if (Handler.hascurio(player, Items.chemical_compound.get())) {

                Vec3 playerPos = player.position();

                List<cell_zombie> entities =
                        player.level().getEntitiesOfClass(cell_zombie.class,
                                new AABB(playerPos.x - range,
                                        playerPos.y - range,
                                        playerPos.z - range,
                                        playerPos.x + range,
                                        playerPos.y + range,
                                        playerPos.z + range));

                float s = heal / 100f;

                List<Integer> integers = new ArrayList<>();
                for (cell_zombie ignored : entities){
                    integers.add(1);
                }
                int size = 0;
                for (int ignored : integers){
                    size++;
                }
                event.setAmount(event.getAmount()*(1+(size*s)));
            }
        }
    }
    public static void healDamage(LivingIncomingDamageEvent event , int damage, int range){
        if (event.getSource().getEntity() instanceof Player player){
            if (Handler.hascurio(player, Items.chemical_compound.get())) {

                Vec3 playerPos = player.position();

                List<cell_giant> entities =
                        player.level().getEntitiesOfClass(cell_giant.class,
                                new AABB(playerPos.x - range,
                                        playerPos.y - range,
                                        playerPos.z - range,
                                        playerPos.x + range,
                                        playerPos.y + range,
                                        playerPos.z + range));

                float s = damage / 100f;

                List<Integer> integers = new ArrayList<>();
                for (cell_giant ignored : entities){
                    integers.add(1);
                }
                int size = 0;
                for (int ignored : integers){
                    size++;
                }
                event.setAmount(event.getAmount()*(1+(size*s)));
            }
        }
    }
    @Override
    public @Nullable List<Item> getDrug() {
        return List.of();
    }


    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("item.chemical_compound.tool.string").withStyle(ChatFormatting.GOLD));
        tooltipComponents.add(Component.translatable("item.chemical_compound.tool.string.1").withStyle(ChatFormatting.GOLD));
        tooltipComponents.add(Component.translatable("item.chemical_compound.tool.string.2").withStyle(ChatFormatting.GOLD));
        tooltipComponents.add(Component.translatable("item.chemical_compound.tool.string.3").withStyle(ChatFormatting.GOLD));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);

    }
}

