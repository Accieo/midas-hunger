package com.accieo.midashunger.loottables;

import com.accieo.midashunger.items.MidasItems;
import java.util.Set;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

public class MidasLootTables {

  /** Chest loot tables that get an extra enchanted golden carrot pool. */
  public static final Set<ResourceKey<LootTable>> TARGETS =
      Set.of(
          BuiltInLootTables.SIMPLE_DUNGEON,
          BuiltInLootTables.ANCIENT_CITY,
          BuiltInLootTables.DESERT_PYRAMID,
          BuiltInLootTables.WOODLAND_MANSION,
          BuiltInLootTables.RUINED_PORTAL,
          BuiltInLootTables.BASTION_TREASURE);

  public static LootPool.Builder createPool() {
    return LootPool.lootPool()
        .setRolls(ContextIntProviders.binomial(1, 0.1F))
        .add(LootItem.lootTableItem(MidasItems.ENCHANTED_GOLDEN_CARROT).setWeight(1));
  }
}
