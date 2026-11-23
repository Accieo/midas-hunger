package com.accieo.midashunger.blocks;

import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.KelpPlantBlock;

public class GoldenKelpPlantBlock extends KelpPlantBlock {
  public GoldenKelpPlantBlock(Properties properties) {
    super(properties);
  }

  @Override
  protected GrowingPlantHeadBlock getHeadBlock() {
    return (GrowingPlantHeadBlock) MidasBlocks.GOLDEN_KELP;
  }
}
