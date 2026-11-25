package com.accieo.midashunger.items;

import com.accieo.midashunger.MidasHunger;
import com.accieo.midashunger.Registrar;
import com.accieo.midashunger.blocks.MidasBlocks;
import com.accieo.midashunger.foodcomponents.MidasFoodComponents;
import com.accieo.midashunger.foodcomponents.MidasFoodComponents.Food;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProvider;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

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
    return ResourceKey.create(Registries.CREATIVE_MODE_TAB, Identifier.withDefaultNamespace(path));
  }

  public record TabEntry(ResourceKey<CreativeModeTab> tab, ItemLike item) {}

  /** Creative tab entries, filled during registration and consumed by each platform. */
  public static final List<TabEntry> TAB_ENTRIES = new ArrayList<>();

  private static ResourceKey<Item> itemKey(Identifier id) {
    return ResourceKey.create(Registries.ITEM, id);
  }

  /** Mirrors vanilla's dried kelp block, but burns for 5000 ticks (see data/.../cooking). */
  private static final ResourceKey<ContextIntProvider> DRIED_GOLDEN_KELP_BLOCK_FUEL =
      ResourceKey.create(
          Registries.CONTEXT_INT_PROVIDER, MidasHunger.id("cooking/time_dried_golden_kelp_block"));

  private static Item.Properties foodProperties(Food food) {
    Item.Properties properties = new Item.Properties().food(food.properties(), food.consumable());
    return food.usingConvertsTo() == null
        ? properties
        : properties.usingConvertsTo(food.usingConvertsTo());
  }

  private static Item midasFoodItem(
      Registrar<Item> registrar, String itemId, Food food, ResourceKey<CreativeModeTab> group) {
    return midasRegisterItem(registrar, itemId, foodProperties(food), Item::new, group);
  }

  private static Item midasRegisterItem(
      Registrar<Item> registrar,
      String itemId,
      Item.Properties properties,
      Function<Item.Properties, Item> factory,
      ResourceKey<CreativeModeTab> group) {
    Identifier id = MidasHunger.id(itemId);
    // Items must know their registry key at construction time.
    Item item = factory.apply(properties.setId(itemKey(id)));
    registrar.register(id, item);
    TAB_ENTRIES.add(new TabEntry(group, item));
    return item;
  }

  private static void midasRegisterBlockItem(
      Registrar<Item> registrar,
      String itemId,
      Block block,
      Item.Properties properties,
      ResourceKey<CreativeModeTab> group) {
    Identifier id = MidasHunger.id(itemId);
    registrar.register(
        id, new BlockItem(block, properties.setId(itemKey(id)).useBlockDescriptionPrefix()));
    TAB_ENTRIES.add(new TabEntry(group, block));
  }

  /** A block item that is named after the item (not the block), like vanilla seeds and berries. */
  private static Item midasSeedItem(
      Registrar<Item> registrar,
      String itemId,
      Block block,
      Item.Properties properties,
      ResourceKey<CreativeModeTab> group) {
    return midasRegisterItem(
        registrar,
        itemId,
        properties,
        p -> new BlockItem(block, p.useItemDescriptionPrefix()),
        group);
  }

  /** Must run after {@link MidasBlocks#register}. */
  public static void register(Registrar<Item> r) {
    // BlockItems -> Natural ; Items -> Food and Drink
    midasRegisterBlockItem(
        r, "golden_kelp", MidasBlocks.GOLDEN_KELP, new Item.Properties(), NATURAL_BLOCKS);
    midasRegisterBlockItem(
        r,
        "dried_golden_kelp_block",
        MidasBlocks.DRIED_GOLDEN_KELP_BLOCK,
        new Item.Properties().cookingFuel(DRIED_GOLDEN_KELP_BLOCK_FUEL),
        NATURAL_BLOCKS);
    DRIED_GOLDEN_KELP =
        midasRegisterItem(
            r,
            "dried_golden_kelp",
            foodProperties(MidasFoodComponents.DRIED_GOLDEN_KELP)
                .compostable(ContextIntProviders.COMPOSTABLE_MEDIUM),
            Item::new,
            FOOD_AND_DRINKS);
    COOKED_GOLDEN_SALMON =
        midasFoodItem(
            r, "cooked_golden_salmon", MidasFoodComponents.COOKED_GOLDEN_SALMON, FOOD_AND_DRINKS);
    COOKED_GOLDEN_COD =
        midasFoodItem(
            r, "cooked_golden_cod", MidasFoodComponents.COOKED_GOLDEN_COD, FOOD_AND_DRINKS);
    GOLDEN_TURTLE_EGG =
        midasFoodItem(
            r, "golden_turtle_egg", MidasFoodComponents.GOLDEN_TURTLE_EGG, FOOD_AND_DRINKS);
    COOKED_GOLDEN_CHICKEN =
        midasFoodItem(
            r, "cooked_golden_chicken", MidasFoodComponents.COOKED_GOLDEN_CHICKEN, FOOD_AND_DRINKS);
    GOLDEN_BEETROOT =
        midasRegisterItem(
            r,
            "golden_beetroot",
            foodProperties(MidasFoodComponents.GOLDEN_BEETROOT)
                .compostable(ContextIntProviders.COMPOSTABLE_MEDIUM),
            Item::new,
            FOOD_AND_DRINKS);
    GOLDEN_BEETROOT_SOUP =
        midasFoodItem(
            r, "golden_beetroot_soup", MidasFoodComponents.GOLDEN_BEETROOT_SOUP, FOOD_AND_DRINKS);
    SWEET_GOLDEN_BERRIES =
        midasSeedItem(
            r,
            "sweet_golden_berries",
            MidasBlocks.SWEET_GOLDEN_BERRY_BUSH,
            foodProperties(MidasFoodComponents.SWEET_GOLDEN_BERRIES)
                .compostable(ContextIntProviders.COMPOSTABLE_MEDIUM),
            FOOD_AND_DRINKS);
    GOLDEN_CHORUS_FRUIT =
        midasFoodItem(
            r, "golden_chorus_fruit", MidasFoodComponents.GOLDEN_CHORUS_FRUIT, FOOD_AND_DRINKS);
    BAKED_GOLDEN_POTATO =
        midasFoodItem(
            r, "baked_golden_potato", MidasFoodComponents.BAKED_GOLDEN_POTATO, FOOD_AND_DRINKS);
    COOKED_GOLDEN_MUTTON =
        midasFoodItem(
            r, "cooked_golden_mutton", MidasFoodComponents.COOKED_GOLDEN_MUTTON, FOOD_AND_DRINKS);
    COOKED_GOLDEN_PORKCHOP =
        midasFoodItem(
            r,
            "cooked_golden_porkchop",
            MidasFoodComponents.COOKED_GOLDEN_PORKCHOP,
            FOOD_AND_DRINKS);
    COOKED_GOLDEN_RABBIT =
        midasFoodItem(
            r, "cooked_golden_rabbit", MidasFoodComponents.COOKED_GOLDEN_RABBIT, FOOD_AND_DRINKS);
    COOKED_GOLDEN_BEEF =
        midasFoodItem(
            r, "cooked_golden_beef", MidasFoodComponents.COOKED_GOLDEN_BEEF, FOOD_AND_DRINKS);
    POISONOUS_GOLDEN_POTATO =
        midasRegisterItem(
            r,
            "poisonous_golden_potato",
            foodProperties(MidasFoodComponents.POISONOUS_GOLDEN_POTATO)
                .compostable(ContextIntProviders.COMPOSTABLE_LOW_MEDIUM),
            Item::new,
            FOOD_AND_DRINKS);
    GOLDEN_PUMPKIN_PIE =
        midasRegisterItem(
            r,
            "golden_pumpkin_pie",
            foodProperties(MidasFoodComponents.GOLDEN_PUMPKIN_PIE)
                .compostable(ContextIntProviders.COMPOSTABLE_ALWAYS_ADD_ONE),
            Item::new,
            FOOD_AND_DRINKS);
    GOLDEN_BEETROOT_SEEDS =
        midasSeedItem(
            r,
            "golden_beetroot_seeds",
            MidasBlocks.GOLDEN_BEETROOTS,
            new Item.Properties().compostable(ContextIntProviders.COMPOSTABLE_LOW_MEDIUM),
            NATURAL_BLOCKS);
    ENCHANTED_GOLDEN_CARROT =
        midasRegisterItem(
            r,
            "enchanted_golden_carrot",
            foodProperties(MidasFoodComponents.ENCHANTED_GOLDEN_CARROT)
                .rarity(Rarity.EPIC)
                .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true),
            Item::new,
            FOOD_AND_DRINKS);
  }
}
