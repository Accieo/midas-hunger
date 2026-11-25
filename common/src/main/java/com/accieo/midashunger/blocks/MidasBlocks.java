package com.accieo.midashunger.blocks;

import com.accieo.midashunger.MidasHunger;
import com.accieo.midashunger.Registrar;
import java.util.function.Function;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
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

  private static Block register(
      Registrar<Block> registrar,
      String path,
      Function<BlockBehaviour.Properties, Block> factory,
      BlockBehaviour.Properties properties) {
    Identifier id = MidasHunger.id(path);
    // Blocks must know their registry key at construction time.
    Block block = factory.apply(properties.setId(ResourceKey.create(Registries.BLOCK, id)));
    registrar.register(id, block);
    return block;
  }

  public static void register(Registrar<Block> registrar) {
    SWEET_GOLDEN_BERRY_BUSH =
        register(
            registrar,
            "sweet_golden_berry_bush",
            SweetGoldenBerryBushBlock::new,
            BlockBehaviour.Properties.of()
                .mapColor(MapColor.PLANT)
                .randomTicks()
                .noCollision()
                .sound(SoundType.SWEET_BERRY_BUSH)
                .pushReaction(PushReaction.POPPED));
    DRIED_GOLDEN_KELP_BLOCK =
        register(
            registrar,
            "dried_golden_kelp_block",
            Block::new,
            BlockBehaviour.Properties.of()
                .mapColor(MapColor.SAND)
                .strength(0.5F, 2.5F)
                .sound(SoundType.GRASS));
    GOLDEN_KELP =
        register(
            registrar,
            "golden_kelp",
            GoldenKelpBlock::new,
            BlockBehaviour.Properties.of()
                .mapColor(MapColor.WATER)
                .noCollision()
                .randomTicks()
                .instabreak()
                .sound(SoundType.WET_GRASS)
                .pushReaction(PushReaction.POPPED));
    GOLDEN_KELP_PLANT =
        register(
            registrar,
            "golden_kelp_plant",
            GoldenKelpPlantBlock::new,
            BlockBehaviour.Properties.of()
                .mapColor(MapColor.WATER)
                .noCollision()
                .instabreak()
                .sound(SoundType.WET_GRASS)
                .pushReaction(PushReaction.POPPED));
    GOLDEN_BEETROOTS =
        register(
            registrar,
            "golden_beetroots",
            GoldenBeetrootsBlock::new,
            BlockBehaviour.Properties.of()
                .mapColor(MapColor.PLANT)
                .noCollision()
                .randomTicks()
                .instabreak()
                .sound(SoundType.CROP)
                .pushReaction(PushReaction.POPPED));
  }
}
