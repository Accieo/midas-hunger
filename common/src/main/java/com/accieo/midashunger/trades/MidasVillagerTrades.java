package com.accieo.midashunger.trades;

import com.accieo.midashunger.items.MidasItems;
import java.util.List;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;

public class MidasVillagerTrades {
  public static final VillagerProfession PROFESSION = VillagerProfession.FARMER;
  public static final int LEVEL = 5;

  /** Adds the farmer level 5 trades. Called by each platform's trade event. */
  public static void addTrades(List<VillagerTrades.ItemListing> factories) {
    factories.add(trade(4, MidasItems.GOLDEN_BEETROOT, 3, 3));
    factories.add(trade(2, MidasItems.DRIED_GOLDEN_KELP, 3, 3));
    factories.add(trade(4, MidasItems.COOKED_GOLDEN_COD, 3, 3));
    factories.add(trade(4, MidasItems.POISONOUS_GOLDEN_POTATO, 2, 2));
    factories.add(trade(4, MidasItems.COOKED_GOLDEN_CHICKEN, 3, 10));
    factories.add(trade(3, MidasItems.BAKED_GOLDEN_POTATO, 3, 12));
    factories.add(trade(4, MidasItems.COOKED_GOLDEN_MUTTON, 3, 10));
    factories.add(trade(4, MidasItems.COOKED_GOLDEN_PORKCHOP, 3, 10));
    factories.add(trade(4, MidasItems.COOKED_GOLDEN_RABBIT, 3, 10));
    factories.add(trade(4, MidasItems.COOKED_GOLDEN_BEEF, 3, 10));
  }

  /** Builds a fresh offer for every villager, so each one tracks its own uses. */
  private static VillagerTrades.ItemListing trade(int emeralds, Item item, int count, int maxUses) {
    return (entity, random) ->
        new MerchantOffer(
            new ItemCost(Items.EMERALD, emeralds), new ItemStack(item, count), maxUses, 0, 0.15F);
  }
}
