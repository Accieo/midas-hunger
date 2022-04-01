package accieo.midas.hunger.blocks;

import accieo.midas.hunger.items.MidasItems;
import net.minecraft.block.BeetrootsBlock;
import net.minecraft.item.ItemConvertible;

public class GoldenBeetrootsBlock extends BeetrootsBlock {
    public GoldenBeetrootsBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return MidasItems.GOLDEN_BEETROOT_SEEDS;
    }



}
