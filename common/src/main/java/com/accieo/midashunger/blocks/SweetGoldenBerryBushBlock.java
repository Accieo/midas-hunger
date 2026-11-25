package com.accieo.midashunger.blocks;

import com.accieo.midashunger.items.MidasItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

public class SweetGoldenBerryBushBlock extends SweetBerryBushBlock {
  public SweetGoldenBerryBushBlock(Properties properties) {
    super(properties);
  }

  @Override
  protected ItemStack getCloneItemStack(
      LevelReader level, BlockPos pos, BlockState state, boolean includeData) {
    return new ItemStack(MidasItems.SWEET_GOLDEN_BERRIES);
  }

  @Override
  protected InteractionResult useWithoutItem(
      BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
    int i = state.getValue(AGE);
    boolean bl = i == 3;
    if (i > 1) {
      int j = 1 + level.getRandom().nextInt(2);
      popResource(level, pos, new ItemStack(MidasItems.SWEET_GOLDEN_BERRIES, j + (bl ? 1 : 0)));
      level.playSound(
          null,
          pos,
          SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES,
          SoundSource.BLOCKS,
          1.0F,
          0.8F + level.getRandom().nextFloat() * 0.4F);
      BlockState blockState = state.setValue(AGE, 1);
      level.setBlock(pos, blockState, 2);
      level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, blockState));
      return InteractionResult.SUCCESS;
    } else {
      return super.useWithoutItem(state, level, pos, player, hit);
    }
  }
}
