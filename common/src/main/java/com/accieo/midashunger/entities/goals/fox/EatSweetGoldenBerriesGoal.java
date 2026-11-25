package com.accieo.midashunger.entities.goals.fox;

import com.accieo.midashunger.blocks.MidasBlocks;
import com.accieo.midashunger.blocks.SweetGoldenBerryBushBlock;
import com.accieo.midashunger.items.MidasItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.animal.fox.Fox;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gamerules.GameRules;

public class EatSweetGoldenBerriesGoal extends MoveToBlockGoal {
  protected int timer;

  public EatSweetGoldenBerriesGoal(Fox entity, double speed, int range, int maxYDifference) {
    super(entity, speed, range, maxYDifference);
  }

  @Override
  public double acceptedDistance() {
    return 2.0D;
  }

  @Override
  public boolean shouldRecalculatePath() {
    return this.tryTicks % 100 == 0;
  }

  @Override
  protected boolean isValidTarget(LevelReader level, BlockPos pos) {
    BlockState blockState = level.getBlockState(pos);
    return blockState.is(MidasBlocks.SWEET_GOLDEN_BERRY_BUSH)
        && blockState.getValue(SweetGoldenBerryBushBlock.AGE) >= 2;
  }

  @Override
  public void tick() {
    if (this.isReachedTarget()) {
      if (this.timer >= 40) {
        this.eatSweetBerry();
      } else {
        ++this.timer;
      }
    } else if (this.mob.getRandom().nextFloat() < 0.05F) {
      this.mob.playSound(SoundEvents.FOX_SNIFF, 1.0F, 1.0F);
    }

    super.tick();
  }

  protected void eatSweetBerry() {
    if (this.mob.level() instanceof ServerLevel level
        && level.getGameRules().get(GameRules.MOB_GRIEFING)) {
      BlockState blockState = this.mob.level().getBlockState(this.blockPos);
      if (blockState.is(MidasBlocks.SWEET_GOLDEN_BERRY_BUSH)) {
        this.pickSweetBerries(blockState);
      }
    }
  }

  private void pickSweetBerries(BlockState state) {
    int i = state.getValue(SweetGoldenBerryBushBlock.AGE);
    int j = 1 + this.mob.getRandom().nextInt(2) + (i == 3 ? 1 : 0);
    ItemStack itemStack = this.mob.getItemBySlot(EquipmentSlot.MAINHAND);
    if (itemStack.isEmpty()) {
      this.mob.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MidasItems.SWEET_GOLDEN_BERRIES));
      --j;
    }

    if (j > 0) {
      Block.popResource(
          this.mob.level(), this.blockPos, new ItemStack(MidasItems.SWEET_GOLDEN_BERRIES, j));
    }

    this.mob.playSound(SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, 1.0F, 1.0F);
    this.mob.level().setBlock(this.blockPos, state.setValue(SweetGoldenBerryBushBlock.AGE, 1), 2);
  }

  @Override
  public boolean canUse() {
    return !this.mob.isSleeping() && super.canUse();
  }

  @Override
  public void start() {
    this.timer = 0;
    ((Fox) this.mob).setSitting(false);
    super.start();
  }
}
