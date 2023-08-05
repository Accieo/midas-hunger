package accieo.midas.hunger.registry;

import accieo.midas.hunger.MidasHunger;
import accieo.midas.hunger.foods.MidasFoods;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MidasHunger.MODID);

    public static final RegistryObject<Item> DRIED_GOLDEN_KELP = ITEMS.register("dried_golden_kelp", () -> new Item(new Item.Properties().food(MidasFoods.DRIED_GOLDEN_KELP)));
    public static final RegistryObject<Item> COOKED_GOLDEN_SALMON = ITEMS.register("cooked_golden_salmon", () -> new Item(new Item.Properties().food(MidasFoods.COOKED_GOLDEN_SALMON)));
    public static final RegistryObject<Item> COOKED_GOLDEN_COD = ITEMS.register("cooked_golden_cod", () -> new Item(new Item.Properties().food(MidasFoods.COOKED_GOLDEN_COD)));
    public static final RegistryObject<Item> GOLDEN_TURTLE_EGG = ITEMS.register("golden_turtle_egg", () -> new Item(new Item.Properties().food(MidasFoods.GOLDEN_TURTLE_EGG)));
    public static final RegistryObject<Item> COOKED_GOLDEN_CHICKEN = ITEMS.register("cooked_golden_chicken", () -> new Item(new Item.Properties().food(MidasFoods.COOKED_GOLDEN_CHICKEN)));
    public static final RegistryObject<Item> GOLDEN_BEETROOT = ITEMS.register("golden_beetroot", () -> new Item(new Item.Properties().food(MidasFoods.GOLDEN_BEETROOT)));
    public static final RegistryObject<Item> GOLDEN_BEETROOT_SOUP = ITEMS.register("golden_beetroot_soup", () -> new BowlFoodItem(new Item.Properties().stacksTo(1).food(MidasFoods.GOLDEN_BEETROOT_SOUP)));
    public static final RegistryObject<Item> GOLDEN_CHORUS_FRUIT = ITEMS.register("golden_chorus_fruit", () -> new Item(new Item.Properties().food(MidasFoods.GOLDEN_CHORUS_FRUIT)));
    public static final RegistryObject<Item> POISONOUS_GOLDEN_POTATO = ITEMS.register("poisonous_golden_potato", () -> new Item(new Item.Properties().food(MidasFoods.POISONOUS_GOLDEN_POTATO)));
    public static final RegistryObject<Item> BAKED_GOLDEN_POTATO = ITEMS.register("baked_golden_potato", () -> new Item(new Item.Properties().food(MidasFoods.BAKED_GOLDEN_POTATO)));
    public static final RegistryObject<Item> COOKED_GOLDEN_MUTTON = ITEMS.register("cooked_golden_mutton", () -> new Item(new Item.Properties().food(MidasFoods.COOKED_GOLDEN_MUTTON)));
    public static final RegistryObject<Item> COOKED_GOLDEN_PORKCHOP = ITEMS.register("cooked_golden_porkchop", () -> new Item(new Item.Properties().food(MidasFoods.COOKED_GOLDEN_PORKCHOP)));
    public static final RegistryObject<Item> COOKED_GOLDEN_RABBIT = ITEMS.register("cooked_golden_rabbit", () -> new Item(new Item.Properties().food(MidasFoods.COOKED_GOLDEN_RABBIT)));
    public static final RegistryObject<Item> COOKED_GOLDEN_BEEF = ITEMS.register("cooked_golden_beef", () -> new Item(new Item.Properties().food(MidasFoods.COOKED_GOLDEN_BEEF)));
    public static final RegistryObject<Item> GOLDEN_PUMPKIN_PIE = ITEMS.register("golden_pumpkin_pie", () -> new Item(new Item.Properties().food(MidasFoods.GOLDEN_PUMPKIN_PIE)));
    public static final RegistryObject<Item> ENCHANTED_GOLDEN_CARROT = ITEMS.register("enchanted_golden_carrot", () -> new EnchantedGoldenAppleItem(new Item.Properties().rarity(Rarity.EPIC).food(Foods.ENCHANTED_GOLDEN_APPLE)));
    public static final RegistryObject<Item> SWEET_GOLDEN_BERRIES = ITEMS.register("sweet_golden_berries", () -> new ItemNameBlockItem(BlockRegistry.SWEET_GOLDEN_BERRY_BUSH.get(), new Item.Properties().food(MidasFoods.SWEET_GOLDEN_BERRIES)));
    public static final RegistryObject<Item> GOLDEN_KELP = ITEMS.register("golden_kelp", () -> new BlockItem(BlockRegistry.GOLDEN_KELP.get(), new Item.Properties()));
    public static final RegistryObject<Item> GOLDEN_BEETROOT_SEEDS = ITEMS.register("golden_beetroot_seeds", () -> new ItemNameBlockItem(BlockRegistry.GOLDEN_BEETROOTS.get(), new Item.Properties()));
    public static final RegistryObject<Item> DRIED_GOLDEN_KELP_BLOCK = ITEMS.register("dried_golden_kelp_block", () -> new BlockItem(BlockRegistry.DRIED_GOLDEN_KELP_BLOCK.get(), new Item.Properties()) {
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 5000;
        }
    });

    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(DRIED_GOLDEN_KELP);
            event.accept(COOKED_GOLDEN_SALMON);
            event.accept(COOKED_GOLDEN_COD);
            event.accept(GOLDEN_TURTLE_EGG);
            event.accept(COOKED_GOLDEN_CHICKEN);
            event.accept(GOLDEN_BEETROOT);
            event.accept(GOLDEN_BEETROOT_SOUP);
            event.accept(SWEET_GOLDEN_BERRIES);
            event.accept(GOLDEN_CHORUS_FRUIT);
            event.accept(POISONOUS_GOLDEN_POTATO);
            event.accept(BAKED_GOLDEN_POTATO);
            event.accept(COOKED_GOLDEN_MUTTON);
            event.accept(COOKED_GOLDEN_PORKCHOP);
            event.accept(COOKED_GOLDEN_RABBIT);
            event.accept(COOKED_GOLDEN_BEEF);
            event.accept(GOLDEN_PUMPKIN_PIE);
            event.accept(ENCHANTED_GOLDEN_CARROT);
        } else if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(GOLDEN_KELP);
            event.accept(GOLDEN_BEETROOT_SEEDS);
            event.accept(DRIED_GOLDEN_KELP_BLOCK);
        }
    }
}