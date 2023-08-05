package accieo.midas.hunger.registry;

import accieo.midas.hunger.MidasHunger;
import accieo.midas.hunger.blocks.GoldenBeetrootsBlock;
import accieo.midas.hunger.blocks.GoldenKelpBlock;
import accieo.midas.hunger.blocks.GoldenKelpPlantBlock;
import accieo.midas.hunger.blocks.SweetGoldenBerryBushBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockRegistry {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MidasHunger.MODID);

    public static final RegistryObject<Block> SWEET_GOLDEN_BERRY_BUSH = BLOCKS.register("sweet_golden_berry_bush", () -> new SweetGoldenBerryBushBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).randomTicks().noCollission().sound(SoundType.SWEET_BERRY_BUSH).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> GOLDEN_KELP = BLOCKS.register("golden_kelp", () -> new GoldenKelpBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WATER).noCollission().randomTicks().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> GOLDEN_KELP_PLANT = BLOCKS.register("golden_kelp_plant", () -> new GoldenKelpPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WATER).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> GOLDEN_BEETROOTS = BLOCKS.register("golden_beetroots", () -> new GoldenBeetrootsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> DRIED_GOLDEN_KELP_BLOCK = BLOCKS.register("dried_golden_kelp_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(0.5F, 2.5F).sound(SoundType.GRASS)));

    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        //
    }

}
