package accieo.midas.hunger.items;

import accieo.midas.hunger.MidasHunger;
import accieo.midas.hunger.blocks.MidasBlocks;
import accieo.midas.hunger.foodcomponents.MidasFoodComponents;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

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
			new Item.Settings().maxCount(1).group(ItemGroup.FOOD).food(MidasFoodComponents.GOLDEN_BEETROOT_SOUP));
	public static final Item GOLDEN_BEETROOT_SEEDS = new AliasedBlockItem(MidasBlocks.GOLDEN_BEETROOTS,
			new Item.Settings().group(ItemGroup.MATERIALS));
	public static final Item SWEET_GOLDEN_BERRIES = new AliasedBlockItem(MidasBlocks.SWEET_GOLDEN_BERRY_BUSH,
			new Item.Settings().group(ItemGroup.FOOD).food(MidasFoodComponents.SWEET_GOLDEN_BERRIES));
	public static final Item ENCHANTED_GOLDEN_CARROT = new EnchantedGoldenAppleItem(
			new Item.Settings().group(ItemGroup.FOOD).rarity(Rarity.EPIC).food(Items.ENCHANTED_GOLDEN_APPLE.getFoodComponent()));

	private static Item midasFoodItemBuilder(FoodComponent foodComponent) {
		return new Item(new Item.Settings().group(ItemGroup.FOOD).food(foodComponent));
	}

	private static void midasRegisterItem(String item_id, Item item) {
		Registry.register(Registry.ITEM, new Identifier(MidasHunger.MOD_ID, item_id), item);
	}

	private static void midasRegisterBlockItem(String item_id, Block block, ItemGroup group) {
		Registry.register(Registry.ITEM, new Identifier(MidasHunger.MOD_ID, item_id), new BlockItem(block, new Item.Settings().group(group)));
	}

	public static void registerItems() {
		midasRegisterBlockItem("golden_kelp", MidasBlocks.GOLDEN_KELP, ItemGroup.DECORATIONS);
		midasRegisterBlockItem("dried_golden_kelp_block", MidasBlocks.DRIED_GOLDEN_KELP_BLOCK, ItemGroup.BUILDING_BLOCKS);
		midasRegisterItem("dried_golden_kelp", DRIED_GOLDEN_KELP);
		midasRegisterItem("cooked_golden_salmon", COOKED_GOLDEN_SALMON);
		midasRegisterItem("cooked_golden_cod", COOKED_GOLDEN_COD);
		midasRegisterItem("golden_turtle_egg", GOLDEN_TURTLE_EGG);
		midasRegisterItem("cooked_golden_chicken", COOKED_GOLDEN_CHICKEN);
		midasRegisterItem("golden_beetroot", GOLDEN_BEETROOT);
		midasRegisterItem("golden_beetroot_soup", GOLDEN_BEETROOT_SOUP);
		midasRegisterItem("sweet_golden_berries", SWEET_GOLDEN_BERRIES);
		midasRegisterItem("golden_chorus_fruit", GOLDEN_CHORUS_FRUIT);
		midasRegisterItem("poisonous_golden_potato", POISONOUS_GOLDEN_POTATO);
		midasRegisterItem("baked_golden_potato", BAKED_GOLDEN_POTATO);
		midasRegisterItem("cooked_golden_mutton", COOKED_GOLDEN_MUTTON);
		midasRegisterItem("cooked_golden_porkchop", COOKED_GOLDEN_PORKCHOP);
		midasRegisterItem("cooked_golden_rabbit", COOKED_GOLDEN_RABBIT);
		midasRegisterItem("cooked_golden_beef", COOKED_GOLDEN_BEEF);
		midasRegisterItem("golden_pumpkin_pie", GOLDEN_PUMPKIN_PIE);
		midasRegisterItem("golden_beetroot_seeds", GOLDEN_BEETROOT_SEEDS);
		midasRegisterItem("enchanted_golden_carrot", ENCHANTED_GOLDEN_CARROT);
	}
}
