package com.accieo.midashunger.items;

import com.accieo.midashunger.MidasHunger;
import com.accieo.midashunger.Registrar;
import com.accieo.midashunger.blocks.MidasBlocks;
import com.accieo.midashunger.foodcomponents.MidasFoodComponents;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

public class MidasItems {
  // Assigned during registration: NeoForge does not allow constructing items before its
  // RegisterEvent.
  public static Item DRIED_GOLDEN_KELP;
  public static Item COOKED_GOLDEN_SALMON;
  public static Item COOKED_GOLDEN_COD;
  public static Item GOLDEN_TURTLE_EGG;
  public static Item COOKED_GOLDEN_CHICKEN;
  public static Item GOLDEN_BEETROOT;
  public static Item GOLDEN_CHORUS_FRUIT;
  public static Item POISONOUS_GOLDEN_POTATO;
  public static Item BAKED_GOLDEN_POTATO;
  public static Item COOKED_GOLDEN_MUTTON;
  public static Item COOKED_GOLDEN_PORKCHOP;
  public static Item COOKED_GOLDEN_RABBIT;
  public static Item COOKED_GOLDEN_BEEF;
  public static Item GOLDEN_PUMPKIN_PIE;
  public static Item GOLDEN_BEETROOT_SOUP;
  public static Item GOLDEN_BEETROOT_SEEDS;
  public static Item SWEET_GOLDEN_BERRIES;
  public static Item ENCHANTED_GOLDEN_CARROT;

  // Vanilla's CreativeModeTabs keys are private (each loader widens them, but common can't see
  // that).
  private static final ResourceKey<CreativeModeTab> NATURAL_BLOCKS = vanillaTab("natural_blocks");
  private static final ResourceKey<CreativeModeTab> FOOD_AND_DRINKS = vanillaTab("food_and_drinks");

  private static ResourceKey<CreativeModeTab> vanillaTab(String path) {
    return ResourceKey.create(
        Registries.CREATIVE_MODE_TAB, ResourceLocation.withDefaultNamespace(path));
  }

  public record TabEntry(ResourceKey<CreativeModeTab> tab, ItemLike item) {}

  /** Creative tab entries, filled during registration and consumed by each platform. */
  public static final List<TabEntry> TAB_ENTRIES = new ArrayList<>();

  private static Item midasFoodItemBuilder(FoodProperties foodComponent) {
    return new Item(new Item.Properties().food(foodComponent));
  }

  private static Item midasRegisterItem(
      Registrar<Item> registrar, String itemId, Item item, ResourceKey<CreativeModeTab> group) {
    registrar.register(MidasHunger.id(itemId), item);
    TAB_ENTRIES.add(new TabEntry(group, item));
    return item;
  }

  private static void midasRegisterBlockItem(
      Registrar<Item> registrar, String itemId, Block block, ResourceKey<CreativeModeTab> group) {
    registrar.register(MidasHunger.id(itemId), new BlockItem(block, new Item.Properties()));
    TAB_ENTRIES.add(new TabEntry(group, block));
  }

  /**
   * Compost chances. Used by Fabric; NeoForge reads data/neoforge/data_maps/item/compostables.json
   * instead.
   */
  public static Map<ItemLike, Float> compostables() {
    Map<ItemLike, Float> map = new LinkedHashMap<>();
    // Vanilla items
    map.put(Items.GOLDEN_CARROT, 1.0F);
    // Midas hunger
    map.put(GOLDEN_BEETROOT_SEEDS, 0.5F);
    map.put(POISONOUS_GOLDEN_POTATO, 0.5F);
    map.put(GOLDEN_BEETROOT, 0.7F);
    map.put(SWEET_GOLDEN_BERRIES, 0.7F);
    map.put(DRIED_GOLDEN_KELP, 0.7F);
    map.put(GOLDEN_PUMPKIN_PIE, 1.0F);
    return map;
  }

  /** Must run after {@link MidasBlocks#register}. */
  public static void register(Registrar<Item> r) {
    // BlockItems -> Natural ; Items -> Food and Drink
    midasRegisterBlockItem(r, "golden_kelp", MidasBlocks.GOLDEN_KELP, NATURAL_BLOCKS);
    midasRegisterBlockItem(
        r, "dried_golden_kelp_block", MidasBlocks.DRIED_GOLDEN_KELP_BLOCK, NATURAL_BLOCKS);
    DRIED_GOLDEN_KELP =
        midasRegisterItem(
            r,
            "dried_golden_kelp",
            midasFoodItemBuilder(MidasFoodComponents.DRIED_GOLDEN_KELP),
            FOOD_AND_DRINKS);
    COOKED_GOLDEN_SALMON =
        midasRegisterItem(
            r,
            "cooked_golden_salmon",
            midasFoodItemBuilder(MidasFoodComponents.COOKED_GOLDEN_SALMON),
            FOOD_AND_DRINKS);
    COOKED_GOLDEN_COD =
        midasRegisterItem(
            r,
            "cooked_golden_cod",
            midasFoodItemBuilder(MidasFoodComponents.COOKED_GOLDEN_COD),
            FOOD_AND_DRINKS);
    GOLDEN_TURTLE_EGG =
        midasRegisterItem(
            r,
            "golden_turtle_egg",
            midasFoodItemBuilder(MidasFoodComponents.GOLDEN_TURTLE_EGG),
            FOOD_AND_DRINKS);
    COOKED_GOLDEN_CHICKEN =
        midasRegisterItem(
            r,
            "cooked_golden_chicken",
            midasFoodItemBuilder(MidasFoodComponents.COOKED_GOLDEN_CHICKEN),
            FOOD_AND_DRINKS);
    GOLDEN_BEETROOT =
        midasRegisterItem(
            r,
            "golden_beetroot",
            midasFoodItemBuilder(MidasFoodComponents.GOLDEN_BEETROOT),
            FOOD_AND_DRINKS);
    GOLDEN_BEETROOT_SOUP =
        midasRegisterItem(
            r,
            "golden_beetroot_soup",
            midasFoodItemBuilder(MidasFoodComponents.GOLDEN_BEETROOT_SOUP),
            FOOD_AND_DRINKS);
    SWEET_GOLDEN_BERRIES =
        midasRegisterItem(
            r,
            "sweet_golden_berries",
            new ItemNameBlockItem(
                MidasBlocks.SWEET_GOLDEN_BERRY_BUSH,
                new Item.Properties().food(MidasFoodComponents.SWEET_GOLDEN_BERRIES)),
            FOOD_AND_DRINKS);
    GOLDEN_CHORUS_FRUIT =
        midasRegisterItem(
            r,
            "golden_chorus_fruit",
            midasFoodItemBuilder(MidasFoodComponents.GOLDEN_CHORUS_FRUIT),
            FOOD_AND_DRINKS);
    POISONOUS_GOLDEN_POTATO =
        midasRegisterItem(
            r,
            "poisonous_golden_potato",
            midasFoodItemBuilder(MidasFoodComponents.POISONOUS_GOLDEN_POTATO),
            FOOD_AND_DRINKS);
    BAKED_GOLDEN_POTATO =
        midasRegisterItem(
            r,
            "baked_golden_potato",
            midasFoodItemBuilder(MidasFoodComponents.BAKED_GOLDEN_POTATO),
            FOOD_AND_DRINKS);
    COOKED_GOLDEN_MUTTON =
        midasRegisterItem(
            r,
            "cooked_golden_mutton",
            midasFoodItemBuilder(MidasFoodComponents.COOKED_GOLDEN_MUTTON),
            FOOD_AND_DRINKS);
    COOKED_GOLDEN_PORKCHOP =
        midasRegisterItem(
            r,
            "cooked_golden_porkchop",
            midasFoodItemBuilder(MidasFoodComponents.COOKED_GOLDEN_PORKCHOP),
            FOOD_AND_DRINKS);
    COOKED_GOLDEN_RABBIT =
        midasRegisterItem(
            r,
            "cooked_golden_rabbit",
            midasFoodItemBuilder(MidasFoodComponents.COOKED_GOLDEN_RABBIT),
            FOOD_AND_DRINKS);
    COOKED_GOLDEN_BEEF =
        midasRegisterItem(
            r,
            "cooked_golden_beef",
            midasFoodItemBuilder(MidasFoodComponents.COOKED_GOLDEN_BEEF),
            FOOD_AND_DRINKS);
    GOLDEN_PUMPKIN_PIE =
        midasRegisterItem(
            r,
            "golden_pumpkin_pie",
            midasFoodItemBuilder(MidasFoodComponents.GOLDEN_PUMPKIN_PIE),
            FOOD_AND_DRINKS);
    GOLDEN_BEETROOT_SEEDS =
        midasRegisterItem(
            r,
            "golden_beetroot_seeds",
            new ItemNameBlockItem(MidasBlocks.GOLDEN_BEETROOTS, new Item.Properties()),
            NATURAL_BLOCKS);
    ENCHANTED_GOLDEN_CARROT =
        midasRegisterItem(
            r,
            "enchanted_golden_carrot",
            new Item(
                new Item.Properties()
                    .rarity(Rarity.EPIC)
                    .food(MidasFoodComponents.ENCHANTED_GOLDEN_CARROT)
                    .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)),
            FOOD_AND_DRINKS);
  }
}
