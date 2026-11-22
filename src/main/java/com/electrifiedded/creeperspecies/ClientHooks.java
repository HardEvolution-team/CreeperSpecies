package com.electrifiedded.creeperspecies;

import net.minecraft.client.renderer.entity.RenderCreeper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientHooks {
    public static void init() {
        RenderingRegistry.registerEntityRenderingHandler(EntityAngelCreeper.class, Angel::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityMysteryCreeper.class, m -> new Species(m, "mystery"));
        RenderingRegistry.registerEntityRenderingHandler(EntityPorkifiedCreeper.class, m -> new Species(m, "porkified"));
        RenderingRegistry.registerEntityRenderingHandler(EntityNetherStarCreeper.class, m -> new Species(m, "netherstargeneral"));
    }

    static class Angel extends RenderLiving<EntityAngelCreeper> {
        private static final ResourceLocation TEX = new ResourceLocation(Reference.MOD_ID, "textures/entity/angelcreeper.png");

        Angel(RenderManager m) {
            super(m, new ModelAngelCreeper(), 0.5F);
        }

        @Override
        protected ResourceLocation getEntityTexture(EntityAngelCreeper e) {
            return TEX;
        }
    }

    static class Species extends RenderCreeper {
        private final ResourceLocation tex;

        Species(RenderManager m, String name) {
            super(m);
            tex = new ResourceLocation(Reference.MOD_ID, "textures/entity/" + name + "creeper.png");
        }

        @Override
        protected ResourceLocation getEntityTexture(EntityCreeper e) {
            return tex;
        }
    }
}
