package accieo.midas.hunger;

import accieo.midas.hunger.loot.MidasLootModifiers;
import accieo.midas.hunger.registry.BlockRegistry;
import accieo.midas.hunger.registry.ItemRegistry;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(MidasHunger.MODID)
public class MidasHunger {
    public static final String MODID = "midashunger";
    private static final Logger LOGGER = LogUtils.getLogger();

    public MidasHunger() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        ItemRegistry.ITEMS.register(modEventBus);
        BlockRegistry.BLOCKS.register(modEventBus);
        MidasLootModifiers.LOOT_MODIFIER_SERIALIZERS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(ItemRegistry::addCreative);
        modEventBus.addListener(BlockRegistry::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        //
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        //
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            //
        }
    }
}
