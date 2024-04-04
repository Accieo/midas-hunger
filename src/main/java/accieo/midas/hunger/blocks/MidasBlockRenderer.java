	package accieo.midas.hunger.blocks;
	
	import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
	import net.minecraft.client.render.RenderLayer;
	
	public class MidasBlockRenderer {
	    
	    public static void renderBlocks(){
	        BlockRenderLayerMap.INSTANCE.putBlock(MidasBlocks.SWEET_GOLDEN_BERRY_BUSH, RenderLayer.getCutout());
	        BlockRenderLayerMap.INSTANCE.putBlock(MidasBlocks.GOLDEN_KELP, RenderLayer.getCutout());
	        BlockRenderLayerMap.INSTANCE.putBlock(MidasBlocks.GOLDEN_KELP_PLANT, RenderLayer.getCutout());
	        BlockRenderLayerMap.INSTANCE.putBlock(MidasBlocks.GOLDEN_BEETROOTS, RenderLayer.getCutout());
	    }
	
	}
