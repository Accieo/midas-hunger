package accieo.midas.hunger.blocks;

import accieo.midas.hunger.registry.BlockRegistry;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.KelpPlantBlock;
import org.jetbrains.annotations.NotNull;

public class GoldenKelpPlantBlock extends KelpPlantBlock {
    public GoldenKelpPlantBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected @NotNull GrowingPlantHeadBlock getHeadBlock() {
        return (GrowingPlantHeadBlock) BlockRegistry.GOLDEN_KELP.get();
    }

}
