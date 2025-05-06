package com.ytgld.seeking_immortal_virus;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.logging.LogUtils;
import com.ytgld.seeking_immortal_virus.client.particle.blood;
import com.ytgld.seeking_immortal_virus.client.particle.blue;
import com.ytgld.seeking_immortal_virus.client.particle.popr;
import com.ytgld.seeking_immortal_virus.client.particle.red;
import com.ytgld.seeking_immortal_virus.client.renderer.MRender;
import com.ytgld.seeking_immortal_virus.crafting.AllCrafting;
import com.ytgld.seeking_immortal_virus.crafting.MoonRecipeProvider;
import com.ytgld.seeking_immortal_virus.crafting.models.ItemModelGen;
import com.ytgld.seeking_immortal_virus.entity.client.NigBoomRender;
import com.ytgld.seeking_immortal_virus.entity.client.YtgldRender;
import com.ytgld.seeking_immortal_virus.entity.client.blood.BloodBatRenderer;
import com.ytgld.seeking_immortal_virus.entity.client.zombie.CellZombieG;
import com.ytgld.seeking_immortal_virus.entity.client.zombie.CellZombieN;
import com.ytgld.seeking_immortal_virus.entity.client.zombie.ZombieRenderer;
import com.ytgld.seeking_immortal_virus.event.ZombieEvent;
import com.ytgld.seeking_immortal_virus.event.old.*;
import com.ytgld.seeking_immortal_virus.init.Tab;
import com.ytgld.seeking_immortal_virus.init.items.BookItems;
import com.ytgld.seeking_immortal_virus.init.items.DNAItems;
import com.ytgld.seeking_immortal_virus.init.items.Drugs;
import com.ytgld.seeking_immortal_virus.init.items.Items;
import com.ytgld.seeking_immortal_virus.init.moonstoneitem.*;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.client.event.RegisterShadersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.slf4j.Logger;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

@Mod(SeekingImmortalVirus.MODID)
public class SeekingImmortalVirus {


    public static final String MODID = "seeking_immortal_virus";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final ResourceLocation POST = ResourceLocation.fromNamespaceAndPath(SeekingImmortalVirus.MODID,
            "shaders/post/entity_outline.json");


    public SeekingImmortalVirus(IEventBus eventBus, ModContainer modContainer){
        NeoForge.EVENT_BUS.register(new AllEvent());
        NeoForge.EVENT_BUS.register(new LootEvent());
        NeoForge.EVENT_BUS.register(new LootTableEvent());
        NeoForge.EVENT_BUS.register(new NewEvent());
        NeoForge.EVENT_BUS.register(new EquippedEvt());
        NeoForge.EVENT_BUS.register(new ZombieEvent());

        Drugs.REGISTRY.register(eventBus);

        BookItems.REGISTRY.register(eventBus);
        AttReg.REGISTRY.register(eventBus);
        DNAItems.REGISTRY.register(eventBus);
        LootReg.REGISTRY.register(eventBus);
        EntityTs.REGISTRY.register(eventBus);
        DataReg.REGISTRY.register(eventBus);
        Effects.REGISTRY.register(eventBus);
        Particles.PARTICLE_TYPES.register(eventBus);
        Items.REGISTRY.register(eventBus);



        AllCrafting.RECIPE_SERIALIZER_REGISTRY.register(eventBus);
        eventBus.addListener(this::gatherData);

        eventBus.register(Config.class);
        Tab.TABS.register(eventBus);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.fc);
        modContainer.registerConfig(ModConfig.Type.CLIENT, ConfigClient.fc);
    }
    public void gatherData(GatherDataEvent event){
        DataGenerator gen = event.getGenerator();
        PackOutput packOutput = gen.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        gen.addProvider(event.includeServer(), new ItemModelGen(packOutput,MODID,event.getExistingFileHelper()));
        gen.addProvider(event.includeServer(), new MoonRecipeProvider(packOutput, lookupProvider));

    }

    @EventBusSubscriber(modid = SeekingImmortalVirus.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
    public static class Client {




        @SubscribeEvent
        public static void registerFactories(RegisterParticleProvidersEvent event) {
            event.registerSpriteSet(Particles.gold.get(), red.Provider::new);
            event.registerSpriteSet(Particles.blue.get(), blue.Provider::new);
            event.registerSpriteSet(Particles.popr.get(), popr.Provider::new);
            event.registerSpriteSet(Particles.blood.get(), blood.Provider::new);
        }
        @SubscribeEvent
        public static void EntityRenderersEvent(EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(EntityTs.cell_zombie.get(), ZombieRenderer::new);
            event.registerEntityRenderer(EntityTs.cell_giant.get(), CellZombieG::new);
            event.registerEntityRenderer(EntityTs.red_entity.get(), com.ytgld.seeking_immortal_virus.entity.client.red.ZombieRenderer::new);
            event.registerEntityRenderer(EntityTs.nightmare_giant.get(), CellZombieN::new);
            event.registerEntityRenderer(EntityTs.nightmare_giant_to.get(), CellZombieN::new);
            event.registerEntityRenderer(EntityTs.test_e.get(), NigBoomRender::new);
            event.registerEntityRenderer(EntityTs.blood_bat.get(), BloodBatRenderer::new);
            event.registerEntityRenderer(EntityTs.test_blood.get(), com.ytgld.seeking_immortal_virus.entity.client.red.ZombieRenderer::new);
            event.registerEntityRenderer(EntityTs.blood_zombie.get(), com.ytgld.seeking_immortal_virus.entity.client.red.ZombieRenderer::new);
            event.registerEntityRenderer(EntityTs.blood_zombie_boom.get(), com.ytgld.seeking_immortal_virus.entity.client.red.ZombieRenderer::new);

            event.registerEntityRenderer(EntityTs.ytgld.get(), YtgldRender::new);
        }
        @SubscribeEvent
        public static void EntityRenderersEvent(RegisterShadersEvent event) {
            try {


                event.registerShader(new ShaderInstance(event.getResourceProvider(),
                        ResourceLocation.fromNamespaceAndPath(MODID,"rendertype_gateway"),
                        DefaultVertexFormat.POSITION_TEX_COLOR),MRender::setShaderInstance_gateway);

                event.registerShader(new ShaderInstance(event.getResourceProvider(),
                        ResourceLocation.fromNamespaceAndPath(MODID,"rendertype_mls"),
                        DefaultVertexFormat.POSITION_TEX_COLOR),MRender::setShaderInstance_mls);

                event.registerShader(new ShaderInstance(event.getResourceProvider(),
                        ResourceLocation.fromNamespaceAndPath(MODID, "rendertype_ging"),
                        DefaultVertexFormat.POSITION_TEX_COLOR),MRender::setShaderInstance_ging);



                event.registerShader(new ShaderInstance(event.getResourceProvider(),
                        ResourceLocation.fromNamespaceAndPath(MODID,"trail"),
                        DefaultVertexFormat.POSITION_TEX_COLOR),MRender::setShaderInstance_trail);

                event.registerShader(new ShaderInstance(event.getResourceProvider(),
                        ResourceLocation.fromNamespaceAndPath(MODID,"eye"),
                        DefaultVertexFormat.POSITION_TEX_COLOR),MRender::setShaderInstance_EYE);

                event.registerShader(new ShaderInstance(event.getResourceProvider(),
                        ResourceLocation.fromNamespaceAndPath(MODID,"snake"),
                        DefaultVertexFormat.POSITION_TEX_COLOR),MRender::setShader_snake);

                event.registerShader(new ShaderInstance(event.getResourceProvider(),
                        ResourceLocation.fromNamespaceAndPath(MODID,"p_blood"),
                        DefaultVertexFormat.POSITION_TEX_COLOR),MRender::setShaderInstance_p_blood);
                
            }catch (IOException exception){
                exception.printStackTrace();
            }
        }
    }

}
