package accieo.midas.hunger.loottables;

import accieo.midas.hunger.items.MidasItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.BinomialLootNumberProvider;
import net.minecraft.util.Identifier;

public class MidasLootTables {

    private static void modifyLootTable(Identifier tableId) {
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && tableId.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(BinomialLootNumberProvider.create(1, 0.1F))
                        .with(ItemEntry.builder(MidasItems.ENCHANTED_GOLDEN_CARROT).weight(1).build());
                tableBuilder.pool(poolBuilder);
                System.out.printf("Enchanted golden carrot was added to: %s%n", tableId);
            }
        }));
    }

    public static void init() {
        modifyLootTable(LootTables.SIMPLE_DUNGEON_CHEST);
        modifyLootTable(LootTables.ANCIENT_CITY_CHEST);
        modifyLootTable(LootTables.DESERT_PYRAMID_CHEST);
        modifyLootTable(LootTables.WOODLAND_MANSION_CHEST);
        modifyLootTable(LootTables.RUINED_PORTAL_CHEST);
        modifyLootTable(LootTables.BASTION_TREASURE_CHEST);
    }

}
