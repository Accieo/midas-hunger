package accieo.midas.hunger;

import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MidasItems {

	public static final Item DRIED_GOLDEN_KELP = new Item(
			new Item.Settings().group(ItemGroup.FOOD).food(MidasFoodComponents.DRIED_GOLDEN_KELP));
	public static final Item COOKED_GOLDEN_SALMON = new Item(
			new Item.Settings().group(ItemGroup.FOOD).food(MidasFoodComponents.COOKED_GOLDEN_SALMON));
	public static final Item COOKED_GOLDEN_COD = new Item(
			new Item.Settings().group(ItemGroup.FOOD).food(MidasFoodComponents.COOKED_GOLDEN_COD));
	public static final Item GOLDEN_TURTLE_EGG = new Item(
			new Item.Settings().group(ItemGroup.FOOD).food(MidasFoodComponents.GOLDEN_TURTLE_EGG));
	public static final Item COOKED_GOLDEN_CHICKEN = new Item(
			new Item.Settings().group(ItemGroup.FOOD).food(MidasFoodComponents.COOKED_GOLDEN_CHICKEN));
	public static final Item GOLDEN_BEETROOT = new Item(
			new Item.Settings().group(ItemGroup.FOOD).food(MidasFoodComponents.GOLDEN_BEETROOT));
	public static final Item GOLDEN_BEETROOT_SOUP = new Item(
			new Item.Settings().maxCount(1).group(ItemGroup.FOOD).food(MidasFoodComponents.GOLDEN_BEETROOT_SOUP));
	public static final Item GOLDEN_CHORUS_FRUIT = new Item(
			new Item.Settings().group(ItemGroup.FOOD).food(MidasFoodComponents.GOLDEN_CHORUS_FRUIT));
	public static final Item POISONOUS_GOLDEN_POTATO = new Item(
			new Item.Settings().group(ItemGroup.FOOD).food(MidasFoodComponents.POISONOUS_GOLDEN_POTATO));
	public static final Item BAKED_GOLDEN_POTATO = new Item(
			new Item.Settings().group(ItemGroup.FOOD).food(MidasFoodComponents.BAKED_GOLDEN_POTATO));
	public static final Item COOKED_GOLDEN_MUTTON = new Item(
			new Item.Settings().group(ItemGroup.FOOD).food(MidasFoodComponents.COOKED_GOLDEN_MUTTON));
	public static final Item COOKED_GOLDEN_PORKCHOP = new Item(
			new Item.Settings().group(ItemGroup.FOOD).food(MidasFoodComponents.COOKED_GOLDEN_PORKCHOP));
	public static final Item COOKED_GOLDEN_RABBIT = new Item(
			new Item.Settings().group(ItemGroup.FOOD).food(MidasFoodComponents.COOKED_GOLDEN_RABBIT));
	public static final Item COOKED_GOLDEN_BEEF = new Item(
			new Item.Settings().group(ItemGroup.FOOD).food(MidasFoodComponents.COOKED_GOLDEN_BEEF));
	public static final Item SWEET_GOLDEN_BERRIES = new AliasedBlockItem(MidasBlocks.SWEET_GOLDEN_BERRY_BUSH,
			new Item.Settings().group(ItemGroup.FOOD).food(MidasFoodComponents.SWEET_GOLDEN_BERRIES));

	public static void registerItems() {

		Registry.register(Registry.ITEM, new Identifier("midashunger", "dried_golden_kelp"), DRIED_GOLDEN_KELP);
		Registry.register(Registry.ITEM, new Identifier("midashunger", "dried_golden_kelp_block"), new BlockItem(
				MidasBlocks.DRIED_GOLDEN_KELP_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("midashunger", "cooked_golden_salmon"), COOKED_GOLDEN_SALMON);
		Registry.register(Registry.ITEM, new Identifier("midashunger", "cooked_golden_cod"), COOKED_GOLDEN_COD);
		Registry.register(Registry.ITEM, new Identifier("midashunger", "golden_turtle_egg"), GOLDEN_TURTLE_EGG);
		Registry.register(Registry.ITEM, new Identifier("midashunger", "cooked_golden_chicken"), COOKED_GOLDEN_CHICKEN);
		Registry.register(Registry.ITEM, new Identifier("midashunger", "golden_beetroot"), GOLDEN_BEETROOT);
		Registry.register(Registry.ITEM, new Identifier("midashunger", "golden_beetroot_soup"), GOLDEN_BEETROOT_SOUP);
		Registry.register(Registry.ITEM, new Identifier("midashunger", "sweet_golden_berries"), SWEET_GOLDEN_BERRIES);
		Registry.register(Registry.ITEM, new Identifier("midashunger", "golden_chorus_fruit"), GOLDEN_CHORUS_FRUIT);
		Registry.register(Registry.ITEM, new Identifier("midashunger", "poisonous_golden_potato"),
				POISONOUS_GOLDEN_POTATO);
		Registry.register(Registry.ITEM, new Identifier("midashunger", "baked_golden_potato"), BAKED_GOLDEN_POTATO);
		Registry.register(Registry.ITEM, new Identifier("midashunger", "cooked_golden_mutton"), COOKED_GOLDEN_MUTTON);
		Registry.register(Registry.ITEM, new Identifier("midashunger", "cooked_golden_porkchop"),
				COOKED_GOLDEN_PORKCHOP);
		Registry.register(Registry.ITEM, new Identifier("midashunger", "cooked_golden_rabbit"), COOKED_GOLDEN_RABBIT);
		Registry.register(Registry.ITEM, new Identifier("midashunger", "cooked_golden_beef"), COOKED_GOLDEN_BEEF);

	}

}
