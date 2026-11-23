package com.accieo.midashunger.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.KelpBlock;

public class GoldenKelpBlock extends KelpBlock {
  protected GoldenKelpBlock(Properties properties) {
    super(properties);
  }

  @Override
  protected Block getBodyBlock() {
    return MidasBlocks.GOLDEN_KELP_PLANT;
  }
}
