	package accieo.midas.hunger.blocks;
	
	import accieo.midas.hunger.items.MidasItems;
	import net.fabricmc.api.EnvType;
	import net.fabricmc.api.Environment;
	import net.minecraft.block.*;
	import net.minecraft.entity.player.PlayerEntity;
	import net.minecraft.item.ItemStack;
	import net.minecraft.item.Items;
	import net.minecraft.sound.SoundCategory;
	import net.minecraft.sound.SoundEvents;
	import net.minecraft.util.ActionResult;
	import net.minecraft.util.Hand;
	import net.minecraft.util.hit.BlockHitResult;
	import net.minecraft.util.math.BlockPos;
	import net.minecraft.world.BlockView;
	import net.minecraft.world.World;
	import net.minecraft.world.event.GameEvent;
	
	public class SweetGoldenBerryBushBlock extends SweetBerryBushBlock {
	   public SweetGoldenBerryBushBlock(Settings settings) {
	      super(settings);
	   }
	
	    @Environment(EnvType.CLIENT)
	    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
	       return new ItemStack(MidasItems.SWEET_GOLDEN_BERRIES);
	    }
	
	   @Override
	   public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
	      int i = (Integer)state.get(AGE);
	        boolean bl = i == 3;
	        if (!bl && player.getStackInHand(hand).isOf(Items.BONE_MEAL)) {
	            return ActionResult.PASS;
	        } else if (i > 1) {
	            int j = 1 + world.random.nextInt(2);
	            dropStack(world, pos, new ItemStack(MidasItems.SWEET_GOLDEN_BERRIES, j + (bl ? 1 : 0)));
	            world.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
	            BlockState blockState = (BlockState)state.with(AGE, 1);
	            world.setBlockState(pos, blockState, 2);
	            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, blockState));
	            return ActionResult.success(world.isClient);
	        } else {
	            return super.onUse(state, world, pos, player, hand, hit);
	        }
	   }
	}