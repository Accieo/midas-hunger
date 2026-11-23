package com.accieo.midashunger;

import net.minecraft.resources.ResourceLocation;

public final class MidasHunger {
  public static final String MOD_ID = "midashunger";

  public static ResourceLocation id(String path) {
    return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
  }
}
