package accieo.midas.hunger;

import accieo.midas.hunger.blocks.MidasBlocks;
import accieo.midas.hunger.items.MidasItems;
import net.fabricmc.api.ModInitializer;

public class MidasHunger implements ModInitializer {

	public static final String MOD_ID = "midashunger";

	@Override
	public void onInitialize() {

		MidasItems.registerItems();
		MidasBlocks.registerBlocks();
		MidasVillagerTrades.registerTrades();

	}
}
