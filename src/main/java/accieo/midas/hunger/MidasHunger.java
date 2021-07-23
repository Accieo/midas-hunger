package accieo.midas.hunger;

import net.fabricmc.api.ModInitializer;

public class MidasHunger implements ModInitializer {

	

	@Override
	public void onInitialize() {

		MidasItems.registerItems();
		MidasBlocks.registerBlocks();
		MidasVillagerTrades.registerTrades();

	}
}
