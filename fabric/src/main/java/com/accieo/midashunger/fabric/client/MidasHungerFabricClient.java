package com.accieo.midashunger.fabric.client;

import com.accieo.midashunger.blocks.MidasBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

public final class MidasHungerFabricClient implements ClientModInitializer {
  @Override
  public void onInitializeClient() {
    // NeoForge gets this from "render_type" in the block model JSONs instead.
    MidasBlocks.cutoutBlocks()
        .forEach(block -> BlockRenderLayerMap.INSTANCE.putBlock(block, RenderType.cutout()));
  }
}
