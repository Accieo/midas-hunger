package accieo.midas.hunger.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MidasBlocks {
    
    public static final Block SWEET_GOLDEN_BERRY_BUSH = new SweetGoldenBerryBushBlock(AbstractBlock.Settings.of(Material.PLANT).ticksRandomly().noCollision().sounds(BlockSoundGroup.SWEET_BERRY_BUSH));
    public static final Block DRIED_GOLDEN_KELP_BLOCK = new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC).strength(0.5F, 2.5F).sounds(BlockSoundGroup.GRASS));

    public static void registerBlocks(){
        Registry.register(Registry.BLOCK, new Identifier("midashunger", "sweet_golden_berry_bush"), SWEET_GOLDEN_BERRY_BUSH);
        Registry.register(Registry.BLOCK, new Identifier("midashunger", "dried_golden_kelp_block"), DRIED_GOLDEN_KELP_BLOCK);
    }

}
