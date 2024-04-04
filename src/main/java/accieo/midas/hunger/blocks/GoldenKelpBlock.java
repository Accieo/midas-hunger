	package accieo.midas.hunger.blocks;
	
	import net.minecraft.block.Block;
	import net.minecraft.block.KelpBlock;
	
	public class GoldenKelpBlock extends KelpBlock {
	    protected GoldenKelpBlock(Settings settings) {
	        super(settings);
	    }
	
	    @Override
	    protected Block getPlant() {
	        return MidasBlocks.GOLDEN_KELP_PLANT;
	    }
	}
