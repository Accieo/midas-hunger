package accieo.midas.hunger.blocks;

import accieo.midas.hunger.registry.ItemRegistry;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.BeetrootBlock;

public class GoldenBeetrootsBlock extends BeetrootBlock {

    public GoldenBeetrootsBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ItemRegistry.GOLDEN_BEETROOT_SEEDS.get();
    }
}
