package com.accieo.midashunger;

import net.minecraft.resources.Identifier;

public final class MidasHunger {
  public static final String MOD_ID = "midashunger";

  public static Identifier id(String path) {
    return Identifier.fromNamespaceAndPath(MOD_ID, path);
  }
}
