package accieo.midas.hunger.items;

import accieo.midas.hunger.MidasHunger;
import accieo.midas.hunger.blocks.MidasBlocks;
import accieo.midas.hunger.foodcomponents.MidasFoodComponents;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;

public class MidasItems {
	public static final Item DRIED_GOLDEN_KELP = midasFoodItemBuilder(MidasFoodComponents.DRIED_GOLDEN_KELP);
	public static final Item COOKED_GOLDEN_SALMON = midasFoodItemBuilder(MidasFoodComponents.COOKED_GOLDEN_SALMON);
	public static final Item COOKED_GOLDEN_COD = midasFoodItemBuilder(MidasFoodComponents.COOKED_GOLDEN_COD);
	public static final Item GOLDEN_TURTLE_EGG = midasFoodItemBuilder(MidasFoodComponents.GOLDEN_TURTLE_EGG);
	public static final Item COOKED_GOLDEN_CHICKEN = midasFoodItemBuilder(MidasFoodComponents.COOKED_GOLDEN_CHICKEN);
	public static final Item GOLDEN_BEETROOT = midasFoodItemBuilder(MidasFoodComponents.GOLDEN_BEETROOT);
	public static final Item GOLDEN_CHORUS_FRUIT = midasFoodItemBuilder(MidasFoodComponents.GOLDEN_CHORUS_FRUIT);
	public static final Item POISONOUS_GOLDEN_POTATO = midasFoodItemBuilder(MidasFoodComponents.POISONOUS_GOLDEN_POTATO);
	public static final Item BAKED_GOLDEN_POTATO = midasFoodItemBuilder(MidasFoodComponents.BAKED_GOLDEN_POTATO);
	public static final Item COOKED_GOLDEN_MUTTON = midasFoodItemBuilder(MidasFoodComponents.COOKED_GOLDEN_MUTTON);
	public static final Item COOKED_GOLDEN_PORKCHOP = midasFoodItemBuilder(MidasFoodComponents.COOKED_GOLDEN_PORKCHOP);
	public static final Item COOKED_GOLDEN_RABBIT = midasFoodItemBuilder(MidasFoodComponents.COOKED_GOLDEN_RABBIT);
	public static final Item COOKED_GOLDEN_BEEF = midasFoodItemBuilder(MidasFoodComponents.COOKED_GOLDEN_BEEF);
	public static final Item GOLDEN_PUMPKIN_PIE = midasFoodItemBuilder(MidasFoodComponents.GOLDEN_PUMPKIN_PIE);
	public static final Item GOLDEN_BEETROOT_SOUP = new StewItem(
			new Item.Settings().maxCount(1).food(MidasFoodComponents.GOLDEN_BEETROOT_SOUP));
	public static final Item GOLDEN_BEETROOT_SEEDS = new AliasedBlockItem(MidasBlocks.GOLDEN_BEETROOTS,
			new Item.Settings());
	public static final Item SWEET_GOLDEN_BERRIES = new AliasedBlockItem(MidasBlocks.SWEET_GOLDEN_BERRY_BUSH,
			new Item.Settings().food(MidasFoodComponents.SWEET_GOLDEN_BERRIES));
	public static final Item ENCHANTED_GOLDEN_CARROT = new EnchantedGoldenAppleItem(
			new Item.Settings().rarity(Rarity.EPIC).food(Items.ENCHANTED_GOLDEN_APPLE.getFoodComponent()));

	private static Item midasFoodItemBuilder(FoodComponent foodComponent) {
		return new Item(new Item.Settings().food(foodComponent));
	}

	private static void midasRegisterItem(String itemId, Item item, RegistryKey<ItemGroup> group) {
		Registry.register(Registries.ITEM, new Identifier(MidasHunger.MOD_ID, itemId), item);
		ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
	}

	private static void midasRegisterBlockItem(String itemId, Block block, RegistryKey<ItemGroup> group) {
		Registry.register(Registries.ITEM, new Identifier(MidasHunger.MOD_ID, itemId), new BlockItem(block, new Item.Settings()));
		ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(block));
	}

	private static void midasRegisterCompostableItems() {
		// Vanilla items
		CompostingChanceRegistry.INSTANCE.add(Items.GOLDEN_CARROT, 1.0F);
		// Midas hunger
		CompostingChanceRegistry.INSTANCE.add(GOLDEN_BEETROOT_SEEDS, 0.5F);
		CompostingChanceRegistry.INSTANCE.add(POISONOUS_GOLDEN_POTATO, 0.5F);
		CompostingChanceRegistry.INSTANCE.add(GOLDEN_BEETROOT, 0.7F);
		CompostingChanceRegistry.INSTANCE.add(SWEET_GOLDEN_BERRIES, 0.7F);
		CompostingChanceRegistry.INSTANCE.add(DRIED_GOLDEN_KELP, 0.7F);
		CompostingChanceRegistry.INSTANCE.add(GOLDEN_PUMPKIN_PIE, 1.0F);
	}

	public static void registerItems() {
		// BlockItems -> Natural ; Items -> Food and Drink
		midasRegisterBlockItem("golden_kelp", MidasBlocks.GOLDEN_KELP, ItemGroups.NATURAL);
		midasRegisterBlockItem("dried_golden_kelp_block", MidasBlocks.DRIED_GOLDEN_KELP_BLOCK, ItemGroups.NATURAL);
		midasRegisterItem("dried_golden_kelp", DRIED_GOLDEN_KELP, ItemGroups.FOOD_AND_DRINK);
		midasRegisterItem("cooked_golden_salmon", COOKED_GOLDEN_SALMON, ItemGroups.FOOD_AND_DRINK);
		midasRegisterItem("cooked_golden_cod", COOKED_GOLDEN_COD, ItemGroups.FOOD_AND_DRINK);
		midasRegisterItem("golden_turtle_egg", GOLDEN_TURTLE_EGG, ItemGroups.FOOD_AND_DRINK);
		midasRegisterItem("cooked_golden_chicken", COOKED_GOLDEN_CHICKEN, ItemGroups.FOOD_AND_DRINK);
		midasRegisterItem("golden_beetroot", GOLDEN_BEETROOT, ItemGroups.FOOD_AND_DRINK);
		midasRegisterItem("golden_beetroot_soup", GOLDEN_BEETROOT_SOUP, ItemGroups.FOOD_AND_DRINK);
		midasRegisterItem("sweet_golden_berries", SWEET_GOLDEN_BERRIES, ItemGroups.FOOD_AND_DRINK);
		midasRegisterItem("golden_chorus_fruit", GOLDEN_CHORUS_FRUIT, ItemGroups.FOOD_AND_DRINK);
		midasRegisterItem("poisonous_golden_potato", POISONOUS_GOLDEN_POTATO, ItemGroups.FOOD_AND_DRINK);
		midasRegisterItem("baked_golden_potato", BAKED_GOLDEN_POTATO, ItemGroups.FOOD_AND_DRINK);
		midasRegisterItem("cooked_golden_mutton", COOKED_GOLDEN_MUTTON, ItemGroups.FOOD_AND_DRINK);
		midasRegisterItem("cooked_golden_porkchop", COOKED_GOLDEN_PORKCHOP, ItemGroups.FOOD_AND_DRINK);
		midasRegisterItem("cooked_golden_rabbit", COOKED_GOLDEN_RABBIT, ItemGroups.FOOD_AND_DRINK);
		midasRegisterItem("cooked_golden_beef", COOKED_GOLDEN_BEEF, ItemGroups.FOOD_AND_DRINK);
		midasRegisterItem("golden_pumpkin_pie", GOLDEN_PUMPKIN_PIE, ItemGroups.FOOD_AND_DRINK);
		midasRegisterItem("golden_beetroot_seeds", GOLDEN_BEETROOT_SEEDS, ItemGroups.NATURAL);
		midasRegisterItem("enchanted_golden_carrot", ENCHANTED_GOLDEN_CARROT, ItemGroups.FOOD_AND_DRINK);
		// Compostable items
		midasRegisterCompostableItems();
	}
}
