package accieo.midas.hunger.event;

import accieo.midas.hunger.MidasHunger;
import accieo.midas.hunger.registry.ItemRegistry;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = MidasHunger.MODID)
public class ModEvents {

    @SubscribeEvent
    public static void addMidasTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.FARMER) {
            int villagerLevel = 5;
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack goldenBeetroot = new ItemStack(ItemRegistry.GOLDEN_BEETROOT.get(), 3);
            ItemStack driedGoldenKelp = new ItemStack(ItemRegistry.DRIED_GOLDEN_KELP.get(), 3);
            ItemStack cookedGoldenCod = new ItemStack(ItemRegistry.COOKED_GOLDEN_COD.get(), 3);
            ItemStack poisonousGoldenPotato = new ItemStack(ItemRegistry.POISONOUS_GOLDEN_POTATO.get(), 2);
            ItemStack cookedGoldenChicken = new ItemStack(ItemRegistry.COOKED_GOLDEN_CHICKEN.get(), 3);
            ItemStack bakedGoldenPotato = new ItemStack(ItemRegistry.BAKED_GOLDEN_POTATO.get(), 3);
            ItemStack cookedGoldenMutton = new ItemStack(ItemRegistry.COOKED_GOLDEN_MUTTON.get(), 3);
            ItemStack cookedGoldenPorkchop = new ItemStack(ItemRegistry.COOKED_GOLDEN_PORKCHOP.get(), 3);
            ItemStack cookedGoldenRabbit = new ItemStack(ItemRegistry.COOKED_GOLDEN_RABBIT.get(), 3);
            ItemStack cookedGoldenBeef = new ItemStack(ItemRegistry.COOKED_GOLDEN_BEEF.get(), 3);

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), goldenBeetroot, 3, 0, 0.15F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 2), driedGoldenKelp,  3, 0, 0.15F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), cookedGoldenCod, 3, 0, 0.15F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), poisonousGoldenPotato, 2, 0, 0.15F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), cookedGoldenChicken, 10, 0, 0.15F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), bakedGoldenPotato, 12, 0, 0.15F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), cookedGoldenMutton, 10, 0, 0.15F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), cookedGoldenPorkchop, 10, 0, 0.15F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), cookedGoldenRabbit, 10, 0, 0.15F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), cookedGoldenBeef, 10, 0, 0.15F));
        }
    }

}
