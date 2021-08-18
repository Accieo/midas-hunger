package accieo.midas.hunger;

import accieo.midas.hunger.blocks.MidasBlockRenderer;
import net.fabricmc.api.ClientModInitializer;

public class MidasHungerClientModInitializer implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        
        MidasBlockRenderer.renderBlocks();

    }
    
}
