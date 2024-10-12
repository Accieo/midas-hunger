package accieo.midas.hunger.foodcomponents;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Items;

public class MidasFoodComponents {

    public static final FoodComponent DRIED_GOLDEN_KELP = (new FoodComponent.Builder()
            .nutrition(6).saturationModifier(0.7F)
            .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 600, 0), 1F))
            .snack().alwaysEdible().build();

    public static final FoodComponent COOKED_GOLDEN_SALMON = (new FoodComponent.Builder()
            .nutrition(8).saturationModifier(1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 2100, 0), 1F))
            .alwaysEdible().build();

    public static final FoodComponent COOKED_GOLDEN_COD = (new FoodComponent.Builder()
            .nutrition(7).saturationModifier(0.8F)
            .statusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 1200, 0), 1F))
            .alwaysEdible().build();

    public static final FoodComponent GOLDEN_TURTLE_EGG = (new FoodComponent.Builder()
            .nutrition(9).saturationModifier(1.2F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 400, 4), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 400, 3), 1F))
            .alwaysEdible().build();

    public static final FoodComponent COOKED_GOLDEN_CHICKEN = (new FoodComponent.Builder()
            .nutrition(8).saturationModifier(1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 1200, 0), 1F))
            .alwaysEdible().build();

    public static final FoodComponent GOLDEN_BEETROOT = (new FoodComponent.Builder()
            .nutrition(6).saturationModifier(0.8F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 3600, 0), 1F))
            .alwaysEdible().build();

    public static final FoodComponent GOLDEN_BEETROOT_SOUP = (new FoodComponent.Builder()
            .nutrition(8).saturationModifier(1.2F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 14400, 0), 1F))
            .alwaysEdible()
            .usingConvertsTo(Items.BOWL)
            .build();

    public static final FoodComponent SWEET_GOLDEN_BERRIES = (new FoodComponent.Builder()
            .nutrition(3).saturationModifier(0.4F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 400, 0), 1F))
            .alwaysEdible().build();

    public static final FoodComponent GOLDEN_CHORUS_FRUIT = (new FoodComponent.Builder()
            .nutrition(8).saturationModifier(0.7F)
            .statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 400, 0), 1F))
            .alwaysEdible().build();

    public static final FoodComponent POISONOUS_GOLDEN_POTATO = (new FoodComponent.Builder()
            .nutrition(6).saturationModifier(0.7F)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 80, 0), 0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 2400, 0), 1F))
            .alwaysEdible().build();

    public static final FoodComponent BAKED_GOLDEN_POTATO = (new FoodComponent.Builder()
            .nutrition(8).saturationModifier(1.2F)
            .build());

    public static final FoodComponent COOKED_GOLDEN_MUTTON = (new FoodComponent.Builder()
            .nutrition(8).saturationModifier(1.2F)
            .build());

    public static final FoodComponent COOKED_GOLDEN_PORKCHOP = (new FoodComponent.Builder()
            .nutrition(10).saturationModifier(1.2F)
            .build());

    public static final FoodComponent COOKED_GOLDEN_RABBIT = (new FoodComponent.Builder()
            .nutrition(8).saturationModifier(1.2F)
            .build());

    public static final FoodComponent COOKED_GOLDEN_BEEF = (new FoodComponent.Builder()
            .nutrition(10).saturationModifier(1.2F)
            .build());

    public static final FoodComponent GOLDEN_PUMPKIN_PIE = (new FoodComponent.Builder()
            .nutrition(8).saturationModifier(1.2F)
            .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 14400, 0), 1F))
            .alwaysEdible().build();

    public static final FoodComponent ENCHANTED_GOLDEN_CARROT = new FoodComponent.Builder()
            .nutrition(4)
            .saturationModifier(1.2F)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 400, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 6000, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6000, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 3), 1.0F)
            .alwaysEdible()
            .build();
}
