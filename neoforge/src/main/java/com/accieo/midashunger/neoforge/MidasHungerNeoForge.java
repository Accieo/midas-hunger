package com.accieo.midashunger.neoforge;

import com.accieo.midashunger.MidasHunger;
import com.accieo.midashunger.blocks.MidasBlocks;
import com.accieo.midashunger.items.MidasItems;
import com.accieo.midashunger.loottables.MidasLootTables;
import com.accieo.midashunger.trades.MidasVillagerTrades;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.LootTableLoadEvent;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

// Fuel and compost values live in data/neoforge/data_maps/item/*.json.
@Mod(MidasHunger.MOD_ID)
public final class MidasHungerNeoForge {
  public MidasHungerNeoForge(IEventBus modBus) {
    modBus.addListener(MidasHungerNeoForge::register);
    modBus.addListener(MidasHungerNeoForge::buildCreativeTabs);
    NeoForge.EVENT_BUS.addListener(MidasHungerNeoForge::addTrades);
    NeoForge.EVENT_BUS.addListener(MidasHungerNeoForge::modifyLootTables);
  }

  private static void register(RegisterEvent event) {
    // Blocks always fire before items.
    event.register(Registries.BLOCK, helper -> MidasBlocks.register(helper::register));
    event.register(Registries.ITEM, helper -> MidasItems.register(helper::register));
  }

  private static void buildCreativeTabs(BuildCreativeModeTabContentsEvent event) {
    MidasItems.TAB_ENTRIES.stream()
        .filter(entry -> entry.tab().equals(event.getTabKey()))
        .forEach(entry -> event.accept(entry.item()));
  }

  private static void addTrades(VillagerTradesEvent event) {
    if (event.getType() == MidasVillagerTrades.PROFESSION) {
      MidasVillagerTrades.addTrades(event.getTrades().get(MidasVillagerTrades.LEVEL));
    }
  }

  private static void modifyLootTables(LootTableLoadEvent event) {
    if (MidasLootTables.TARGETS.contains(
        ResourceKey.create(Registries.LOOT_TABLE, event.getName()))) {
      event.getTable().addPool(MidasLootTables.createPool().build());
    }
  }
}
