package com.accieo.midashunger.fabric;

import com.accieo.midashunger.blocks.MidasBlocks;
import com.accieo.midashunger.items.MidasItems;
import com.accieo.midashunger.loottables.MidasLootTables;
import com.accieo.midashunger.trades.MidasVillagerTrades;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;

public final class MidasHungerFabric implements ModInitializer {
  @Override
  public void onInitialize() {
    MidasBlocks.register((id, block) -> Registry.register(BuiltInRegistries.BLOCK, id, block));
    MidasItems.register((id, item) -> Registry.register(BuiltInRegistries.ITEM, id, item));

    MidasItems.TAB_ENTRIES.forEach(entry ->
        ItemGroupEvents.modifyEntriesEvent(entry.tab())
            .register(entries -> entries.accept(entry.item())));
    MidasItems.compostables().forEach(CompostingChanceRegistry.INSTANCE::add);
    FuelRegistry.INSTANCE.add(MidasBlocks.DRIED_GOLDEN_KELP_BLOCK, 5000);

    TradeOfferHelper.registerVillagerOffers(
        MidasVillagerTrades.PROFESSION, MidasVillagerTrades.LEVEL, MidasVillagerTrades::addTrades);

    LootTableEvents.MODIFY.register((key, builder, source, registries) -> {
      if (MidasLootTables.TARGETS.contains(key)) {
        builder.withPool(MidasLootTables.createPool());
      }
    });
  }
}
