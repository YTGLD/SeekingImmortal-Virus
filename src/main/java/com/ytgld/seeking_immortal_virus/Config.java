package com.ytgld.seeking_immortal_virus;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class Config {
    public static Config SERVER;
    public static ModConfigSpec fc;

    static {
        final Pair<Config, ModConfigSpec> specPair = new ModConfigSpec.Builder().configure(Config::new);
        SERVER = specPair.getLeft();
        fc = specPair.getRight();
    }
    public Config(ModConfigSpec.Builder BUILDER){
        {
            BUILDER.push("一般配置");
            canUnequipMoonstoneItem = BUILDER
                    .comment("可以取下月之石的“不可以取下”的物品")
                    .define("Can", false);
            immortalZombie = BUILDER
                    .comment("玩家无法伤害月之石实体")
                    .define("immortalZombieOfOwner", false);
            BUILDER.pop();
        }




        {
            BUILDER.push("一般物品");
            ytgld_curse = BUILDER
                    .comment("终极湮灭病毒的增值速度，单位：刻，值越大速度越慢")
                    .defineInRange("ytgld_curse", 15, 1, 999999);
            ytgld_research = BUILDER
                    .comment("终极湮灭病毒的研究速度，10点是0.1%")
                    .defineInRange("ytgld_research", 10, 1, 999999);
            off_or_on_ytgld = BUILDER
                    .comment("启用终极湮灭病毒")
                    .define("off_or_on_ytgld", true);

            quadriceps_speed = BUILDER
                    .comment("四头肌强化的速度")
                    .defineInRange("quadriceps", 0.25, 0, 999);
            flygene_speed = BUILDER
                    .comment("夜行蝠突变基因的速度")
                    .defineInRange("flygene", 0.125, 0, 999);
            bloodvirus_speed = BUILDER
                    .comment("暗影瘟疫的速度")
                    .defineInRange("bloodvirus", 0.175, 0, 999);

            motor_speed = BUILDER
                    .comment("运动控制强化的速度")
                    .defineInRange("motor", 0.15, 0, 999);



            BUILDER.pop();
        }
        {
            BUILDER.push("战利品");
            lootMan = BUILDER
                    .comment("人类基因的药物再战利品箱子里出现的几率，值越大，概率越高")
                    .defineInRange("lootMan", 13, 1, 100);
            bat = BUILDER
                    .comment("”暗影瘟疫“的战利品出现几率，值越大，概率越高")
                    .defineInRange("Plague_probability", 10, 1, 100);
            necora = BUILDER
                    .comment("”Necora病毒“的战利品出现几率，值越大，概率越高")
                    .defineInRange("Necora_probability", 10, 1, 100);

            common = BUILDER
                    .comment("注意！这个值影响了普通战利品的出现概率。它的值越大，概率越小！不要改反了")
                    .defineInRange("Common_probability", 1, 0.1, 100);
            BUILDER.pop();
        }
        BUILDER.build();
    }

    public   ModConfigSpec.IntValue lootMan ;


    public ModConfigSpec.DoubleValue quadriceps_speed;

    public ModConfigSpec.DoubleValue flygene_speed;
    public ModConfigSpec.DoubleValue bloodvirus_speed;
    public ModConfigSpec.DoubleValue motor_speed;
    public  ModConfigSpec.IntValue bat ;
    public  ModConfigSpec.IntValue necora ;
    public  ModConfigSpec.DoubleValue common ;
    public ModConfigSpec.BooleanValue canUnequipMoonstoneItem ;
    public ModConfigSpec.BooleanValue immortalZombie ;



    public   ModConfigSpec.IntValue ytgld_research ;
    public   ModConfigSpec.IntValue ytgld_curse ;
    public   ModConfigSpec.BooleanValue off_or_on_ytgld ;










    @SubscribeEvent
    public static void onLoad(final ModConfigEvent.Loading configEvent) {
    }

    @SubscribeEvent
    public static void onFileChange(final ModConfigEvent.Reloading configEvent) {
    }

}
