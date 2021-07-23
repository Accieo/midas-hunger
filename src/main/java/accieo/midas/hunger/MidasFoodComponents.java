package accieo.midas.hunger;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class MidasFoodComponents {

    public static final FoodComponent DRIED_GOLDEN_KELP = (new FoodComponent.Builder()
    .hunger(6).saturationModifier(0.7F)
    .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 3600, 0), 1F))
    .snack().alwaysEdible().build();
    
    public static final FoodComponent COOKED_GOLDEN_SALMON = (new FoodComponent.Builder()
    .hunger(8).saturationModifier(1.0F)
    .statusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 2100, 0), 1F))
    .alwaysEdible().build();

    public static final FoodComponent COOKED_GOLDEN_COD = (new FoodComponent.Builder()
    .hunger(7).saturationModifier(0.8F)
    .statusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 1200, 0), 1F))
    .alwaysEdible().build(); 

    public static final FoodComponent GOLDEN_TURTLE_EGG = (new FoodComponent.Builder()
    .hunger(9).saturationModifier(1.2F)
    .statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 400, 4), 1F)
    .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 400, 3), 1F))
    .alwaysEdible().build(); 

    public static final FoodComponent COOKED_GOLDEN_CHICKEN = (new FoodComponent.Builder()
    .hunger(8).saturationModifier(1.0F)
    .statusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 1200, 0), 1F))
    .alwaysEdible().build();

    public static final FoodComponent GOLDEN_BEETROOT = (new FoodComponent.Builder()
    .hunger(6).saturationModifier(0.8F)
    .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 3600, 0), 1F))
    .alwaysEdible().build();

    public static final FoodComponent GOLDEN_BEETROOT_SOUP = (new FoodComponent.Builder()
    .hunger(8).saturationModifier(1.2F)
    .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 14400, 0), 1F))
    .alwaysEdible().build();

    public static final FoodComponent SWEET_GOLDEN_BERRIES = (new FoodComponent.Builder()
    .hunger(3).saturationModifier(0.4F)
    .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 400, 0), 1F))
    .alwaysEdible().build();

    public static final FoodComponent GOLDEN_CHORUS_FRUIT = (new FoodComponent.Builder()
    .hunger(8).saturationModifier(0.7F)
    .statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 400, 0), 1F))
    .alwaysEdible().build();

    public static final FoodComponent POISONOUS_GOLDEN_POTATO = (new FoodComponent.Builder()
    .hunger(6).saturationModifier(0.7F)
    .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 80, 0), 0.6F)
    .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 2400, 0), 1F))
    .alwaysEdible().build();

    public static final FoodComponent BAKED_GOLDEN_POTATO = (new FoodComponent.Builder()
    .hunger(8).saturationModifier(1.2F)
    .build());

    public static final FoodComponent COOKED_GOLDEN_MUTTON = (new FoodComponent.Builder()
    .hunger(8).saturationModifier(1.2F)
    .build());

    public static final FoodComponent COOKED_GOLDEN_PORKCHOP = (new FoodComponent.Builder()
    .hunger(10).saturationModifier(1.2F)
    .build());

    public static final FoodComponent COOKED_GOLDEN_RABBIT = (new FoodComponent.Builder()
    .hunger(8).saturationModifier(1.2F)
    .build());

    public static final FoodComponent COOKED_GOLDEN_BEEF = (new FoodComponent.Builder()
    .hunger(10).saturationModifier(1.2F)
    .build());

}
