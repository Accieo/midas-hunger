	package accieo.midas.hunger.blocks;
	
	import net.minecraft.block.AbstractPlantStemBlock;
	import net.minecraft.block.KelpPlantBlock;
	
	public class GoldenKelpPlantBlock extends KelpPlantBlock {
	    public GoldenKelpPlantBlock(Settings settings) {
	        super(settings);
	    }
	
	    @Override
	    protected AbstractPlantStemBlock getStem() {
	        return (AbstractPlantStemBlock)MidasBlocks.GOLDEN_KELP;
	    }
	}
