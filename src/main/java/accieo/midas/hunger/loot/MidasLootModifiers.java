package accieo.midas.hunger.loot;

import accieo.midas.hunger.MidasHunger;
import com.mojang.serialization.Codec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MidasLootModifiers {

    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, MidasHunger.MODID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ENCHANTED_GOLDEN_CARROT_SIMPLE_DUNGEON =
            LOOT_MODIFIER_SERIALIZERS.register("enchanted_golden_carrot_simple_dungeon", EnchantedGoldenCarrotSimpleDungeon.CODEC);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ENCHANTED_GOLDEN_CARROT_ANCIENT_CITY =
            LOOT_MODIFIER_SERIALIZERS.register("enchanted_golden_carrot_ancient_city", EnchantedGoldenCarrotAncientCity.CODEC);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ENCHANTED_GOLDEN_CARROT_DESERT_PYRAMID =
            LOOT_MODIFIER_SERIALIZERS.register("enchanted_golden_carrot_desert_pyramid", EnchantedGoldenCarrotDesertPyramid.CODEC);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ENCHANTED_GOLDEN_CARROT_WOODLAND_MANSION =
            LOOT_MODIFIER_SERIALIZERS.register("enchanted_golden_carrot_woodland_mansion", EnchantedGoldenCarrotWoodlandMansion.CODEC);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ENCHANTED_GOLDEN_CARROT_RUINED_PORTAL =
            LOOT_MODIFIER_SERIALIZERS.register("enchanted_golden_carrot_ruined_portal", EnchantedGoldenCarrotRuinedPortal.CODEC);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ENCHANTED_GOLDEN_CARROT_BASTION_TREASURE =
            LOOT_MODIFIER_SERIALIZERS.register("enchanted_golden_carrot_bastion_treasure", EnchantedGoldenCarrotBastionTreasure.CODEC);
}
