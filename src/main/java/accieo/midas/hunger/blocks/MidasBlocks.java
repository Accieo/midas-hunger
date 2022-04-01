package accieo.midas.hunger.blocks;

import accieo.midas.hunger.MidasHunger;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BeetrootsBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MidasBlocks {
    
    public static final Block SWEET_GOLDEN_BERRY_BUSH = new SweetGoldenBerryBushBlock(AbstractBlock.Settings.of(Material.PLANT).ticksRandomly().noCollision().sounds(BlockSoundGroup.SWEET_BERRY_BUSH));
    public static final Block DRIED_GOLDEN_KELP_BLOCK = new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC).strength(0.5F, 2.5F).sounds(BlockSoundGroup.GRASS));
    public static final Block GOLDEN_KELP = new GoldenKelpBlock(AbstractBlock.Settings.of(Material.UNDERWATER_PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.WET_GRASS));
    public static final Block GOLDEN_KELP_PLANT = new GoldenKelpPlantBlock(AbstractBlock.Settings.of(Material.UNDERWATER_PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.WET_GRASS));
    public static final Block GOLDEN_BEETROOTS = new GoldenBeetrootsBlock(AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));

    public static void registerBlocks(){
        Registry.register(Registry.BLOCK, new Identifier(MidasHunger.MOD_ID, "sweet_golden_berry_bush"), SWEET_GOLDEN_BERRY_BUSH);
        Registry.register(Registry.BLOCK, new Identifier(MidasHunger.MOD_ID, "dried_golden_kelp_block"), DRIED_GOLDEN_KELP_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(MidasHunger.MOD_ID, "golden_kelp"), GOLDEN_KELP);
        Registry.register(Registry.BLOCK, new Identifier(MidasHunger.MOD_ID, "golden_kelp_plant"), GOLDEN_KELP_PLANT);
        Registry.register(Registry.BLOCK, new Identifier(MidasHunger.MOD_ID, "golden_beetroots"), GOLDEN_BEETROOTS);
        FuelRegistry.INSTANCE.add(DRIED_GOLDEN_KELP_BLOCK, 5000);
    }

}
