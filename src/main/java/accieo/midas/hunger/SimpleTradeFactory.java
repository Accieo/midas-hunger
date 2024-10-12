package accieo.midas.hunger;

import net.minecraft.entity.Entity;
import net.minecraft.village.TradeOffer;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffers;

public class SimpleTradeFactory implements TradeOffers.Factory {
	private final TradeOffer offer;

	SimpleTradeFactory(TradeOffer offer) {
		this.offer = offer;
	}

	@Override
	public TradeOffer create(Entity entity, Random random) {
		return this.offer;
	}
}