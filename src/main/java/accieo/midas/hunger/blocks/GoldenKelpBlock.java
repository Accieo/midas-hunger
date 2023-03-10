package accieo.midas.hunger.blocks;

import accieo.midas.hunger.registry.BlockRegistry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.KelpBlock;
import org.jetbrains.annotations.NotNull;

public class GoldenKelpBlock extends KelpBlock {

    public GoldenKelpBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected @NotNull Block getBodyBlock() {
        return BlockRegistry.GOLDEN_KELP_PLANT.get();
    }

}
