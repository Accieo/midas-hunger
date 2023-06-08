package accieo.midas.hunger;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import static net.minecraft.server.command.CommandManager.literal;
import accieo.midas.hunger.items.MidasItems;

import java.util.function.Supplier;

public class MidasVillagerTrades {
    public static void registerTrades(){
    TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 5, factories -> {
            factories.add(new SimpleTradeFactory(new TradeOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(MidasItems.GOLDEN_BEETROOT, 3), 3, 0, 0.15F)));
            factories.add(new SimpleTradeFactory(new TradeOffer(new ItemStack(Items.EMERALD, 2), new ItemStack(MidasItems.DRIED_GOLDEN_KELP, 3), 3, 0, 0.15F)));
            factories.add(new SimpleTradeFactory(new TradeOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(MidasItems.COOKED_GOLDEN_COD, 3), 3, 0, 0.15F)));
            factories.add(new SimpleTradeFactory(new TradeOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(MidasItems.POISONOUS_GOLDEN_POTATO, 2), 2, 0, 0.15F)));
            factories.add(new SimpleTradeFactory(new TradeOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(MidasItems.COOKED_GOLDEN_CHICKEN, 3), 10, 0, 0.15F)));
            factories.add(new SimpleTradeFactory(new TradeOffer(new ItemStack(Items.EMERALD, 3), new ItemStack(MidasItems.BAKED_GOLDEN_POTATO, 3), 12, 0, 0.15F)));
            factories.add(new SimpleTradeFactory(new TradeOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(MidasItems.COOKED_GOLDEN_MUTTON, 3), 10, 0, 0.15F)));
            factories.add(new SimpleTradeFactory(new TradeOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(MidasItems.COOKED_GOLDEN_PORKCHOP, 3), 10, 0, 0.15F)));
            factories.add(new SimpleTradeFactory(new TradeOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(MidasItems.COOKED_GOLDEN_RABBIT, 3), 10, 0, 0.15F)));
            factories.add(new SimpleTradeFactory(new TradeOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(MidasItems.COOKED_GOLDEN_BEEF, 3), 10, 0, 0.15F)));
    });
    
    CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
        if (environment.dedicated) {
            dispatcher.register(literal("fabric_refreshtrades").executes(context -> {
                context.getSource().sendFeedback((Supplier<Text>) Text.of("Refreshed trades"), false);
                return 1;
            }));
        }
    });
    }
}