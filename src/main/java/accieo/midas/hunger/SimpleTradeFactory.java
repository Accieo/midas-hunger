package accieo.midas.hunger;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;

public class SimpleTradeFactory implements TradeOffers.Factory {
	private final TradeOffer offer;

	SimpleTradeFactory(TradeOffer offer) {
		this.offer = offer;
	}

	@Override
	public TradeOffer create(Entity entity, Random random) {
		// ALWAYS supply a copy of the offer.
		return new TradeOffer(this.offer.toNbt());
	}
}