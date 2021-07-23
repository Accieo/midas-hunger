package accieo.midas.hunger;

import net.fabricmc.api.ClientModInitializer;

public class MidasHungerClientModInitializer implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        
        MidasBlockRenderer.renderBlocks();

    }
    
}
