package com.accieo.midashunger.fabric;

import com.accieo.midashunger.blocks.MidasBlocks;
import com.accieo.midashunger.items.MidasItems;
import com.accieo.midashunger.loottables.MidasLootTables;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;

// Villager trades, compost and fuel values are data/components, so they need no loader code.
public final class MidasHungerFabric implements ModInitializer {
  @Override
  public void onInitialize() {
    MidasBlocks.register((id, block) -> Registry.register(BuiltInRegistries.BLOCK, id, block));
    MidasItems.register((id, item) -> Registry.register(BuiltInRegistries.ITEM, id, item));

    MidasItems.TAB_ENTRIES.forEach(entry ->
        CreativeModeTabEvents.modifyOutputEvent(entry.tab())
            .register(entries -> entries.accept(entry.item())));

    LootTableEvents.MODIFY.register((key, builder, source, registries) -> {
      if (MidasLootTables.TARGETS.contains(key)) {
        builder.withPool(MidasLootTables.createPool());
      }
    });
  }
}
