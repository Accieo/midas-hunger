	package accieo.midas.hunger.blocks;
	
	import accieo.midas.hunger.MidasHunger;
	import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
	import net.fabricmc.fabric.api.registry.FuelRegistry;
	import net.minecraft.block.AbstractBlock;
	import net.minecraft.block.Block;
	import net.minecraft.block.MapColor;
	import net.minecraft.block.piston.PistonBehavior;
	import net.minecraft.sound.BlockSoundGroup;
	import net.minecraft.util.Identifier;
	import net.minecraft.registry.Registry;
	import net.minecraft.registry.Registries;
	
	public class MidasBlocks {
	    
	    public static final Block SWEET_GOLDEN_BERRY_BUSH = new SweetGoldenBerryBushBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).ticksRandomly().noCollision().sounds(BlockSoundGroup.SWEET_BERRY_BUSH).pistonBehavior(PistonBehavior.DESTROY));
	    public static final Block DRIED_GOLDEN_KELP_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.PALE_YELLOW).strength(0.5F, 2.5F).sounds(BlockSoundGroup.GRASS));
	    public static final Block GOLDEN_KELP = new GoldenKelpBlock(AbstractBlock.Settings.create().mapColor(MapColor.WATER_BLUE).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.WET_GRASS).pistonBehavior(PistonBehavior.DESTROY));
	    public static final Block GOLDEN_KELP_PLANT = new GoldenKelpPlantBlock(AbstractBlock.Settings.create().mapColor(MapColor.WATER_BLUE).noCollision().breakInstantly().sounds(BlockSoundGroup.WET_GRASS).pistonBehavior(PistonBehavior.DESTROY));
	    public static final Block GOLDEN_BEETROOTS = new GoldenBeetrootsBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY));
	
	    private static void midasRegisterBlock(String itemId, Block block) {
	        Registry.register(Registries.BLOCK, new Identifier(MidasHunger.MOD_ID, itemId), block);
	    }
	
	    public static void registerBlocks(){
	        midasRegisterBlock("sweet_golden_berry_bush", SWEET_GOLDEN_BERRY_BUSH);
	        midasRegisterBlock("dried_golden_kelp_block", DRIED_GOLDEN_KELP_BLOCK);
	        midasRegisterBlock("golden_kelp", GOLDEN_KELP);
	        midasRegisterBlock("golden_kelp_plant", GOLDEN_KELP_PLANT);
	        midasRegisterBlock("golden_beetroots", GOLDEN_BEETROOTS);
	        FuelRegistry.INSTANCE.add(DRIED_GOLDEN_KELP_BLOCK, 5000);
	    }
	}
