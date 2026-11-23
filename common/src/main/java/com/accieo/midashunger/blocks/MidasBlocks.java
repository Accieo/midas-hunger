package com.accieo.midashunger.blocks;

import com.accieo.midashunger.MidasHunger;
import com.accieo.midashunger.Registrar;
import java.util.List;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class MidasBlocks {

  // Assigned during registration: NeoForge does not allow constructing blocks before its
  // RegisterEvent.
  public static Block SWEET_GOLDEN_BERRY_BUSH;
  public static Block DRIED_GOLDEN_KELP_BLOCK;
  public static Block GOLDEN_KELP;
  public static Block GOLDEN_KELP_PLANT;
  public static Block GOLDEN_BEETROOTS;

  private static Block register(Registrar<Block> registrar, String id, Block block) {
    registrar.register(MidasHunger.id(id), block);
    return block;
  }

  public static void register(Registrar<Block> registrar) {
    SWEET_GOLDEN_BERRY_BUSH =
        register(
            registrar,
            "sweet_golden_berry_bush",
            new SweetGoldenBerryBushBlock(
                BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .randomTicks()
                    .noCollission()
                    .sound(SoundType.SWEET_BERRY_BUSH)
                    .pushReaction(PushReaction.DESTROY)));
    DRIED_GOLDEN_KELP_BLOCK =
        register(
            registrar,
            "dried_golden_kelp_block",
            new Block(
                BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND)
                    .strength(0.5F, 2.5F)
                    .sound(SoundType.GRASS)));
    GOLDEN_KELP =
        register(
            registrar,
            "golden_kelp",
            new GoldenKelpBlock(
                BlockBehaviour.Properties.of()
                    .mapColor(MapColor.WATER)
                    .noCollission()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.WET_GRASS)
                    .pushReaction(PushReaction.DESTROY)));
    GOLDEN_KELP_PLANT =
        register(
            registrar,
            "golden_kelp_plant",
            new GoldenKelpPlantBlock(
                BlockBehaviour.Properties.of()
                    .mapColor(MapColor.WATER)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.WET_GRASS)
                    .pushReaction(PushReaction.DESTROY)));
    GOLDEN_BEETROOTS =
        register(
            registrar,
            "golden_beetroots",
            new GoldenBeetrootsBlock(
                BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollission()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.CROP)
                    .pushReaction(PushReaction.DESTROY)));
  }

  /** Blocks that need the cutout render layer on the client. */
  public static List<Block> cutoutBlocks() {
    return List.of(SWEET_GOLDEN_BERRY_BUSH, GOLDEN_KELP, GOLDEN_KELP_PLANT, GOLDEN_BEETROOTS);
  }
}
