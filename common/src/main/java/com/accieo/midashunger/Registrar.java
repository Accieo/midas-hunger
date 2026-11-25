package com.accieo.midashunger;

import net.minecraft.resources.Identifier;

/** Loader-agnostic registration callback; each platform supplies its own implementation. */
@FunctionalInterface
public interface Registrar<T> {
  void register(Identifier id, T value);
}
