package com.accieo.midashunger.foodcomponents;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

public class MidasFoodComponents {

  public static final FoodProperties DRIED_GOLDEN_KELP =
      (new FoodProperties.Builder()
              .nutrition(6)
              .saturationModifier(0.7F)
              .effect(new MobEffectInstance(MobEffects.WATER_BREATHING, 600, 0), 1F))
          .fast()
          .alwaysEdible()
          .build();

  public static final FoodProperties COOKED_GOLDEN_SALMON =
      (new FoodProperties.Builder()
              .nutrition(8)
              .saturationModifier(1.0F)
              .effect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 2100, 0), 1F))
          .alwaysEdible()
          .build();

  public static final FoodProperties COOKED_GOLDEN_COD =
      (new FoodProperties.Builder()
              .nutrition(7)
              .saturationModifier(0.8F)
              .effect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 1200, 0), 1F))
          .alwaysEdible()
          .build();

  public static final FoodProperties GOLDEN_TURTLE_EGG =
      (new FoodProperties.Builder()
              .nutrition(9)
              .saturationModifier(1.2F)
              .effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 400, 4), 1F)
              .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400, 3), 1F))
          .alwaysEdible()
          .build();

  public static final FoodProperties COOKED_GOLDEN_CHICKEN =
      (new FoodProperties.Builder()
              .nutrition(8)
              .saturationModifier(1.0F)
              .effect(new MobEffectInstance(MobEffects.SLOW_FALLING, 1200, 0), 1F))
          .alwaysEdible()
          .build();

  public static final FoodProperties GOLDEN_BEETROOT =
      (new FoodProperties.Builder()
              .nutrition(6)
              .saturationModifier(0.8F)
              .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 3600, 0), 1F))
          .alwaysEdible()
          .build();

  public static final FoodProperties GOLDEN_BEETROOT_SOUP =
      (new FoodProperties.Builder()
              .nutrition(8)
              .saturationModifier(1.2F)
              .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 14400, 0), 1F))
          .alwaysEdible()
          .usingConvertsTo(Items.BOWL)
          .build();

  public static final FoodProperties SWEET_GOLDEN_BERRIES =
      (new FoodProperties.Builder()
              .nutrition(3)
              .saturationModifier(0.4F)
              .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0), 1F))
          .alwaysEdible()
          .build();

  public static final FoodProperties GOLDEN_CHORUS_FRUIT =
      (new FoodProperties.Builder()
              .nutrition(8)
              .saturationModifier(0.7F)
              .effect(new MobEffectInstance(MobEffects.LEVITATION, 400, 0), 1F))
          .alwaysEdible()
          .build();

  public static final FoodProperties POISONOUS_GOLDEN_POTATO =
      (new FoodProperties.Builder()
              .nutrition(6)
              .saturationModifier(0.7F)
              .effect(new MobEffectInstance(MobEffects.POISON, 80, 0), 0.6F)
              .effect(new MobEffectInstance(MobEffects.LUCK, 2400, 0), 1F))
          .alwaysEdible()
          .build();

  public static final FoodProperties BAKED_GOLDEN_POTATO =
      (new FoodProperties.Builder().nutrition(8).saturationModifier(1.2F).build());

  public static final FoodProperties COOKED_GOLDEN_MUTTON =
      (new FoodProperties.Builder().nutrition(8).saturationModifier(1.2F).build());

  public static final FoodProperties COOKED_GOLDEN_PORKCHOP =
      (new FoodProperties.Builder().nutrition(10).saturationModifier(1.2F).build());

  public static final FoodProperties COOKED_GOLDEN_RABBIT =
      (new FoodProperties.Builder().nutrition(8).saturationModifier(1.2F).build());

  public static final FoodProperties COOKED_GOLDEN_BEEF =
      (new FoodProperties.Builder().nutrition(10).saturationModifier(1.2F).build());

  public static final FoodProperties GOLDEN_PUMPKIN_PIE =
      (new FoodProperties.Builder()
              .nutrition(8)
              .saturationModifier(1.2F)
              .effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 14400, 0), 1F))
          .alwaysEdible()
          .build();

  public static final FoodProperties ENCHANTED_GOLDEN_CARROT =
      new FoodProperties.Builder()
          .nutrition(4)
          .saturationModifier(1.2F)
          .effect(new MobEffectInstance(MobEffects.REGENERATION, 400, 1), 1.0F)
          .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0), 1.0F)
          .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1.0F)
          .effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 3), 1.0F)
          .alwaysEdible()
          .build();
}
