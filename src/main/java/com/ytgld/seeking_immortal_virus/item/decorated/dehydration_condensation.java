package com.ytgld.seeking_immortal_virus.item.decorated;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.ytgld.seeking_immortal_virus.Handler;
import com.ytgld.seeking_immortal_virus.entity.zombie.cell_zombie;
import com.ytgld.seeking_immortal_virus.init.moonstoneitem.DataReg;
import com.ytgld.seeking_immortal_virus.init.moonstoneitem.extend.TheNecoraIC;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.UUID;

/**
 *召唤的细胞僵尸会相互融合
 * <p>
 *  融合后根据融合前僵尸属性来增加
 * <p>
 *  融合时额外获得10%最大生命值和体积
 */
public class dehydration_condensation extends TheNecoraIC {

    public static Multimap<Holder<Attribute>, AttributeModifier> modifiers (double amout, Holder<Attribute> attribute,AttributeModifier.Operation Operation){
        Multimap<Holder<Attribute>, AttributeModifier> modifierMultimap = HashMultimap.create();
        modifierMultimap.put(attribute, new AttributeModifier(
                ResourceLocation.parse(UUID.randomUUID().toString()),
                amout,
                Operation
        ));

        return modifierMultimap;
    }
    public static void addBigZombie(cell_zombie cellZombie, Item must, Player owner){
        if (Handler.hascurio(owner, must)) {
            if (cellZombie.tickCount%20==1) {
                Vec3 playerPos = cellZombie.position().add(0, 0.75, 0);
                float range = 2;
                List<cell_zombie> zombies =
                        cellZombie.level().getEntitiesOfClass(cell_zombie.class,
                                new AABB(playerPos.x - range,
                                        playerPos.y - range,
                                        playerPos.z - range,
                                        playerPos.x + range,
                                        playerPos.y + range,
                                        playerPos.z + range));
                for (cell_zombie zombie : zombies) {
                    if (!zombie.is(cellZombie)) {
                        double health = zombie.getAttributeValue(Attributes.MAX_HEALTH)*0.1f;
                        double armor = zombie.getAttributeValue(Attributes.ARMOR)*0.1f;
                        double damage = zombie.getAttributeValue(Attributes.ATTACK_DAMAGE)*0.1f;

                        zombie.getAttributes().addTransientAttributeModifiers(modifiers(health,Attributes.MAX_HEALTH, AttributeModifier.Operation.ADD_VALUE));
                        zombie.getAttributes().addTransientAttributeModifiers(modifiers(damage,Attributes.ATTACK_DAMAGE, AttributeModifier.Operation.ADD_VALUE));
                        zombie.getAttributes().addTransientAttributeModifiers(modifiers(armor,Attributes.ARMOR, AttributeModifier.Operation.ADD_VALUE));

                        zombie.getAttributes().addTransientAttributeModifiers(modifiers(0.1,Attributes.MAX_HEALTH, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
                        zombie.getAttributes().addTransientAttributeModifiers(modifiers(0.1,Attributes.SCALE, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
                        zombie.getAttributes().addTransientAttributeModifiers(modifiers(0.1,Attributes.ENTITY_INTERACTION_RANGE, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
                        zombie.getAttributes().addTransientAttributeModifiers(modifiers(0.1,Attributes.BLOCK_INTERACTION_RANGE, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));

                        zombie.time = 0;

                        zombie.heal(zombie.getMaxHealth());

                        cellZombie.level().levelEvent(2001, new BlockPos((int) cellZombie.getX(), (int) (cellZombie.getY() + 1), (int) cellZombie.getZ()), Block.getId(Blocks.SLIME_BLOCK.defaultBlockState()));
                        cellZombie.discard();


                    }
                }
            }
        }
    }
    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        if (Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("item.dehydration_condensation.tool.string.0").withStyle(ChatFormatting.DARK_RED));
            tooltipComponents.add(Component.translatable("item.dehydration_condensation.tool.string.1").withStyle(ChatFormatting.DARK_RED));
            tooltipComponents.add(Component.translatable("item.dehydration_condensation.tool.string.2").withStyle(ChatFormatting.DARK_RED));
            tooltipComponents.add(Component.literal(""));
        }else {
            tooltipComponents.add(Component.translatable("key.keyboard.left.shift").withStyle(ChatFormatting.RED));
        }
    }

}
