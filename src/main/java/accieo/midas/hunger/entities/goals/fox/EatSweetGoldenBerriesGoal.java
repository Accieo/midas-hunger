package accieo.midas.hunger.entities.goals.fox;

import accieo.midas.hunger.blocks.SweetGoldenBerryBushBlock;
import accieo.midas.hunger.registry.BlockRegistry;
import accieo.midas.hunger.registry.ItemRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CaveVines;
import net.minecraft.world.level.block.state.BlockState;

public class EatSweetGoldenBerriesGoal extends MoveToBlockGoal {

    protected int timer;

    public EatSweetGoldenBerriesGoal(Fox fox, double speed, int range, int maxYDifference) {
        super(fox, speed, range, maxYDifference);
    }

    public double acceptedDistance() {
        return 2.0D;
    }

    public boolean shouldRecalculatePath() {
        return this.tryTicks % 100 == 0;
    }

    protected boolean isValidTarget(LevelReader world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos);
        return blockState.is(BlockRegistry.SWEET_GOLDEN_BERRY_BUSH.get()) && (Integer)blockState.getValue(SweetGoldenBerryBushBlock.AGE) >= 2 || CaveVines.hasGlowBerries(blockState);
    }

    public void tick() {
        if (this.isReachedTarget()) {
            if (this.timer >= 40) {
                this.onReachedTarget();
            } else {
                ++this.timer;
            }
        } else if (!this.isReachedTarget() && this.mob.getRandom().nextFloat() < 0.05F) {
            this.mob.playSound(SoundEvents.FOX_SNIFF, 1.0F, 1.0F);
        }

        super.tick();
    }

    protected void onReachedTarget() {
        if (this.mob.level().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)) {
            BlockState blockState = this.mob.level().getBlockState(this.blockPos);
            if (blockState.is(BlockRegistry.SWEET_GOLDEN_BERRY_BUSH.get())) {
                this.pickSweetBerries(blockState);
            }
        }
    }

    private void pickSweetBerries(BlockState state) {
        int i = (Integer)state.getValue(SweetGoldenBerryBushBlock.AGE);
        state.setValue(SweetGoldenBerryBushBlock.AGE, 1);
        int j = 1 + this.mob.level().random.nextInt(2) + (i == 3 ? 1 : 0);
        ItemStack itemStack = this.mob.getItemBySlot(EquipmentSlot.MAINHAND);
        if (itemStack.isEmpty()) {
            this.mob.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ItemRegistry.SWEET_GOLDEN_BERRIES.get()));
            --j;
        }

        if (j > 0) {
            Block.popResource(this.mob.level(), this.blockPos, new ItemStack(ItemRegistry.SWEET_GOLDEN_BERRIES.get(), j));
        }

        this.mob.playSound(SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, 1.0F, 1.0F);
        this.mob.level().setBlock(this.blockPos, (BlockState)state.setValue(SweetGoldenBerryBushBlock.AGE, 1), 2);
    }

    public boolean canUse() {
        return !this.mob.isSleeping() && super.canUse();
    }

    public void start() {
        this.timer = 0;
        ((Fox)this.mob).setSitting(false);
        super.start();
    }

}
