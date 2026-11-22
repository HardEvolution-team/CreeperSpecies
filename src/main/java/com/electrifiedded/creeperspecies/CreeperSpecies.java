package com.electrifiedded.creeperspecies;

import com.electrifiedded.archaiclib.original.OriginalModAssets;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, dependencies = "required-after:archaiclib")
@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class CreeperSpecies {
    public static final String ORIGINAL_NAME = "creeper_species_mod_1.7.10.jar - Creeper Species 1.7.2 for 1.7.10";
    public static final String ORIGINAL_URL = "https://www.curseforge.com/minecraft/mc-mods (search: Creeper Species)";

    @Mod.Instance(Reference.MOD_ID)
    public static CreeperSpecies instance;

    public static Item mysteryStone;
    public static final Map<String, Class<? extends EntityLiving>> NAMES = new LinkedHashMap<>();

    static {
        NAMES.put("NetherStarCreeper", EntityNetherStarCreeper.class);
        NAMES.put("PorkifiedCreeper", EntityPorkifiedCreeper.class);
        NAMES.put("AngelCreeper", EntityAngelCreeper.class);
        NAMES.put("MysteryCreeper", EntityMysteryCreeper.class);
    }

    public CreeperSpecies() {
        // the 1.7 jar keeps the texture as textures/items/MysteryStone.png, 1.12 asks lower-case
        OriginalModAssets.alias(Reference.MOD_ID, "textures/items/mysterystone.png", "textures/items/MysteryStone.png");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> e) {
        mysteryStone = new ItemMysteryStone().setRegistryName(Reference.MOD_ID, "mysterystone").setTranslationKey("MysteryStone");
        e.getRegistry().register(mysteryStone);
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        OriginalModAssets.require(Reference.MOD_ID, Reference.MOD_ID, ORIGINAL_NAME, ORIGINAL_URL, Reference.MOD_ID);
        int id = 0;
        List<Biome> biomes = new ArrayList<>();
        for (Biome b : ForgeRegistries.BIOMES.getValuesCollection()) biomes.add(b);
        Biome[] spawn = biomes.toArray(new Biome[0]);
        for (Map.Entry<String, Class<? extends EntityLiving>> ent : NAMES.entrySet()) {
            EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, ent.getKey().toLowerCase()), ent.getValue(),
                    ent.getKey(), id++, this, 80, 1, true, 894731, 0x150F06);
            EntityRegistry.addSpawn(ent.getValue(), 15, 1, 1, EnumCreatureType.MONSTER, spawn);
        }
        if (FMLCommonHandler.instance().getSide().isClient()) ClientHooks.init();
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onPlayerHurt(LivingHurtEvent event) {
        if (event.getSource().isExplosion() && event.getEntity() instanceof EntityPlayer
                && ((EntityPlayer) event.getEntity()).inventory.hasItemStack(new ItemStack(mysteryStone))) {
            event.setAmount(0.0F);
        }
    }
}
