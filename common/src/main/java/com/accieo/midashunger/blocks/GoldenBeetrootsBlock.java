package com.accieo.midashunger.blocks;

import com.accieo.midashunger.items.MidasItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.BeetrootBlock;

public class GoldenBeetrootsBlock extends BeetrootBlock {
  public GoldenBeetrootsBlock(Properties properties) {
    super(properties);
  }

  @Override
  protected ItemLike getBaseSeedId() {
    return MidasItems.GOLDEN_BEETROOT_SEEDS;
  }
}
