	package accieo.midas.hunger.entities.goals.fox;
	
	import accieo.midas.hunger.blocks.MidasBlocks;
	import accieo.midas.hunger.blocks.SweetGoldenBerryBushBlock;
	import accieo.midas.hunger.items.MidasItems;
	import net.minecraft.block.*;
	import net.minecraft.entity.EquipmentSlot;
	import net.minecraft.entity.ai.goal.MoveToTargetPosGoal;
	import net.minecraft.entity.passive.FoxEntity;
	import net.minecraft.item.ItemStack;
	import net.minecraft.sound.SoundEvents;
	import net.minecraft.util.math.BlockPos;
	import net.minecraft.world.GameRules;
	import net.minecraft.world.WorldView;
	
	public class EatSweetGoldenBerriesGoal extends MoveToTargetPosGoal {
	    protected int timer;
	
	    public EatSweetGoldenBerriesGoal(FoxEntity entity, double speed, int range, int maxYDifference) {
	        super(entity, speed, range, maxYDifference);
	    }
	
	    public double getDesiredDistanceToTarget() {
	        return 2.0D;
	    }
	
	    public boolean shouldResetPath() {
	        return this.tryingTime % 100 == 0;
	    }
	
	    protected boolean isTargetPos(WorldView world, BlockPos pos) {
	        BlockState blockState = world.getBlockState(pos);
	        return blockState.isOf(MidasBlocks.SWEET_GOLDEN_BERRY_BUSH) && blockState.get(SweetGoldenBerryBushBlock.AGE) >= 2 || CaveVines.hasBerries(blockState);
	    }
	
	    public void tick() {
	        if (this.hasReached()) {
	            if (this.timer >= 40) {
	                this.eatSweetBerry();
	            } else {
	                ++this.timer;
	            }
	        } else if (!this.hasReached() && this.mob.getRandom().nextFloat() < 0.05F) {
	            this.mob.playSound(SoundEvents.ENTITY_FOX_SNIFF, 1.0F, 1.0F);
	        }
	
	        super.tick();
	    }
	
	    protected void eatSweetBerry() {
	        if (this.mob.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
	            BlockState blockState = this.mob.getWorld().getBlockState(this.targetPos);
	            if (blockState.isOf(MidasBlocks.SWEET_GOLDEN_BERRY_BUSH)) {
	                this.pickSweetBerries(blockState);
	            }
	        }
	    }
	
	    private void pickSweetBerries(BlockState state) {
	        int i = state.get(SweetGoldenBerryBushBlock.AGE);
	        state.with(SweetGoldenBerryBushBlock.AGE, 1);
	        int j = 1 + this.mob.getWorld().random.nextInt(2) + (i == 3 ? 1 : 0);
	        ItemStack itemStack = this.mob.getEquippedStack(EquipmentSlot.MAINHAND);
	        if (itemStack.isEmpty()) {
	            this.mob.equipStack(EquipmentSlot.MAINHAND, new ItemStack(MidasItems.SWEET_GOLDEN_BERRIES));
	            --j;
	        }
	
	        if (j > 0) {
	            Block.dropStack(this.mob.getWorld(), this.targetPos, new ItemStack(MidasItems.SWEET_GOLDEN_BERRIES, j));
	        }
	
	        this.mob.playSound(SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, 1.0F, 1.0F);
	        this.mob.getWorld().setBlockState(this.targetPos, state.with(SweetGoldenBerryBushBlock.AGE, 1), 2);
	    }
	
	    public boolean canStart() {
	        return !this.mob.isSleeping() && super.canStart();
	    }
	
	    public void start() {
	        this.timer = 0;
	        ((FoxEntity)this.mob).setSitting(false);
	        super.start();
	    }
	
	}
