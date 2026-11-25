package com.accieo.midashunger.foodcomponents;

import java.util.Arrays;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class MidasFoodComponents {

  /** A status effect applied on eating, with the chance that it applies. */
  public record Effect(Holder<MobEffect> effect, int duration, int amplifier, float chance) {
    static Effect of(Holder<MobEffect> effect, int duration, int amplifier) {
      return new Effect(effect, duration, amplifier, 1.0F);
    }

    ApplyStatusEffectsConsumeEffect toConsumeEffect() {
      return new ApplyStatusEffectsConsumeEffect(
          new MobEffectInstance(effect, duration, amplifier), chance);
    }
  }

  /** Nutrition, eating behaviour and optional remainder for a food item. */
  public record Food(FoodProperties properties, Consumable consumable, Item usingConvertsTo) {
    public static Food create(
        int nutrition,
        float saturation,
        boolean alwaysEdible,
        float consumeSeconds,
        Item usingConvertsTo,
        Effect... effects) {
      FoodProperties.Builder food =
          new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturation);
      if (alwaysEdible) {
        food.alwaysEdible();
      }
      Consumable.Builder consumable = Consumable.builder().consumeSeconds(consumeSeconds);
      Arrays.stream(effects).map(Effect::toConsumeEffect).forEach(consumable::onConsume);
      return new Food(food.build(), consumable.build(), usingConvertsTo);
    }
  }

  private static final float NORMAL = Consumable.DEFAULT_CONSUME_SECONDS;
  private static final float FAST = 0.8F;

  private static Food magic(int nutrition, float saturation, Effect... effects) {
    return Food.create(nutrition, saturation, true, NORMAL, null, effects);
  }

  private static Food plain(int nutrition, float saturation) {
    return Food.create(nutrition, saturation, false, NORMAL, null);
  }

  public static final Food DRIED_GOLDEN_KELP =
      Food.create(6, 0.7F, true, FAST, null, Effect.of(MobEffects.WATER_BREATHING, 600, 0));

  public static final Food COOKED_GOLDEN_SALMON =
      magic(8, 1.0F, Effect.of(MobEffects.DOLPHINS_GRACE, 2100, 0));

  public static final Food COOKED_GOLDEN_COD =
      magic(7, 0.8F, Effect.of(MobEffects.DOLPHINS_GRACE, 1200, 0));

  public static final Food GOLDEN_TURTLE_EGG =
      magic(
          9,
          1.2F,
          Effect.of(MobEffects.SLOWNESS, 400, 4),
          Effect.of(MobEffects.RESISTANCE, 400, 3));

  public static final Food COOKED_GOLDEN_CHICKEN =
      magic(8, 1.0F, Effect.of(MobEffects.SLOW_FALLING, 1200, 0));

  public static final Food GOLDEN_BEETROOT =
      magic(6, 0.8F, Effect.of(MobEffects.FIRE_RESISTANCE, 3600, 0));

  public static final Food GOLDEN_BEETROOT_SOUP =
      Food.create(
          8, 1.2F, true, NORMAL, Items.BOWL, Effect.of(MobEffects.FIRE_RESISTANCE, 14400, 0));

  public static final Food SWEET_GOLDEN_BERRIES =
      magic(3, 0.4F, Effect.of(MobEffects.SPEED, 400, 0));

  public static final Food GOLDEN_CHORUS_FRUIT =
      magic(8, 0.7F, Effect.of(MobEffects.LEVITATION, 400, 0));

  public static final Food POISONOUS_GOLDEN_POTATO =
      magic(
          6, 0.7F, new Effect(MobEffects.POISON, 80, 0, 0.6F), Effect.of(MobEffects.LUCK, 2400, 0));

  public static final Food BAKED_GOLDEN_POTATO = plain(8, 1.2F);

  public static final Food COOKED_GOLDEN_MUTTON = plain(8, 1.2F);

  public static final Food COOKED_GOLDEN_PORKCHOP = plain(10, 1.2F);

  public static final Food COOKED_GOLDEN_RABBIT = plain(8, 1.2F);

  public static final Food COOKED_GOLDEN_BEEF = plain(10, 1.2F);

  public static final Food GOLDEN_PUMPKIN_PIE =
      magic(8, 1.2F, Effect.of(MobEffects.NIGHT_VISION, 14400, 0));

  public static final Food ENCHANTED_GOLDEN_CARROT =
      magic(
          4,
          1.2F,
          Effect.of(MobEffects.REGENERATION, 400, 1),
          Effect.of(MobEffects.RESISTANCE, 6000, 0),
          Effect.of(MobEffects.FIRE_RESISTANCE, 6000, 0),
          Effect.of(MobEffects.ABSORPTION, 2400, 3));
}
