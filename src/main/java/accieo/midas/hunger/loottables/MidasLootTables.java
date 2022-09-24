package accieo.midas.hunger.loottables;

import accieo.midas.hunger.items.MidasItems;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.BinomialLootNumberProvider;
import net.minecraft.util.Identifier;

public class MidasLootTables {

    private static void modifyLootTable(Identifier tableId) {
        LootTableLoadingCallback.EVENT.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (tableId.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(BinomialLootNumberProvider.create(1, 0.1F))
                        .withEntry(ItemEntry.builder(MidasItems.ENCHANTED_GOLDEN_CARROT).weight(1).build());
                tableBuilder.withPool(poolBuilder.build());
                System.out.printf("Enchanted golden carrot was added to: %s%n", tableId);
            }
        }));
    }

    public static void init() {
        modifyLootTable(LootTables.SIMPLE_DUNGEON_CHEST);
        modifyLootTable(LootTables.DESERT_PYRAMID_CHEST);
        modifyLootTable(LootTables.WOODLAND_MANSION_CHEST);
        modifyLootTable(LootTables.RUINED_PORTAL_CHEST);
        modifyLootTable(LootTables.BASTION_TREASURE_CHEST);
    }

}