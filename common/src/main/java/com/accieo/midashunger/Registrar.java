package com.accieo.midashunger;

import net.minecraft.resources.ResourceLocation;

/** Loader-agnostic registration callback; each platform supplies its own implementation. */
@FunctionalInterface
public interface Registrar<T> {
  void register(ResourceLocation id, T value);
}
