package com.electrifiedded.creeperspecies;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;


public class ModelAngelCreeper extends ModelBase {
   ModelRenderer Shapespine3;
   ModelRenderer Shapespine2;
   ModelRenderer shapespine1;
   ModelRenderer wing1;
   ModelRenderer Shapeboxhead;
   ModelRenderer Shapespine;
   ModelRenderer head;
   ModelRenderer body;
   ModelRenderer leg3;
   ModelRenderer leg4;
   ModelRenderer leg1;
   ModelRenderer leg2;
   ModelRenderer Shapewing;

   public ModelAngelCreeper() {
      this.textureWidth = 64;
      this.textureHeight = 32;
      this.Shapespine3 = new ModelRenderer(this, 26, 25);
      this.Shapespine3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 6);
      this.Shapespine3.setRotationPoint(0.0F, 8.0F, 0.0F);
      this.Shapespine3.setTextureSize(64, 32);
      this.Shapespine3.mirror = true;
      this.setRotation(this.Shapespine3, 0.0698132F, 0.0698132F, 0.0F);
      this.Shapespine2 = new ModelRenderer(this, 26, 25);
      this.Shapespine2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 6);
      this.Shapespine2.setRotationPoint(-1.0F, 8.0F, 0.0F);
      this.Shapespine2.setTextureSize(64, 32);
      this.Shapespine2.mirror = true;
      this.setRotation(this.Shapespine2, 0.0698132F, -0.0698132F, 0.0F);
      this.shapespine1 = new ModelRenderer(this, 26, 25);
      this.shapespine1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 6);
      this.shapespine1.setRotationPoint(-1.0F, 10.0F, 0.0F);
      this.shapespine1.setTextureSize(64, 32);
      this.shapespine1.mirror = true;
      this.setRotation(this.shapespine1, 0.0698132F, -0.0698132F, 0.0F);
      this.wing1 = new ModelRenderer(this, 24, 0);
      this.wing1.addBox(0.0F, 0.0F, 0.0F, 13, 0, 5);
      this.wing1.setRotationPoint(0.0F, 8.0F, 2.0F);
      this.wing1.setTextureSize(64, 32);
      this.wing1.mirror = true;
      this.setRotation(this.wing1, 1.047198F, -0.3316126F, 0.0F);
      this.Shapeboxhead = new ModelRenderer(this, 19, 20);
      this.Shapeboxhead.addBox(0.0F, 0.0F, 0.0F, 4, 4, 5);
      this.Shapeboxhead.setRotationPoint(-2.0F, 4.0F, 2.0F);
      this.Shapeboxhead.setTextureSize(64, 32);
      this.Shapeboxhead.mirror = true;
      this.setRotation(this.Shapeboxhead, 0.0F, 0.0F, 0.0F);
      this.Shapespine = new ModelRenderer(this, 26, 25);
      this.Shapespine.addBox(0.0F, 0.0F, 0.0F, 1, 1, 6);
      this.Shapespine.setRotationPoint(0.0F, 10.0F, 0.0F);
      this.Shapespine.setTextureSize(64, 32);
      this.Shapespine.mirror = true;
      this.setRotation(this.Shapespine, 0.0698132F, 0.0698132F, 0.0F);
      this.head = new ModelRenderer(this, 0, 0);
      this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
      this.head.setRotationPoint(0.0F, 6.0F, 0.0F);
      this.head.setTextureSize(64, 32);
      this.head.mirror = true;
      this.setRotation(this.head, 0.0F, 0.0F, 0.0F);
      this.body = new ModelRenderer(this, 16, 16);
      this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4);
      this.body.setRotationPoint(0.0F, 6.0F, 0.0F);
      this.body.setTextureSize(64, 32);
      this.body.mirror = true;
      this.setRotation(this.body, 0.0F, 0.0F, 0.0F);
      this.leg3 = new ModelRenderer(this, 0, 16);
      this.leg3.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4);
      this.leg3.setRotationPoint(-2.0F, 18.0F, -4.0F);
      this.leg3.setTextureSize(64, 32);
      this.leg3.mirror = true;
      this.setRotation(this.leg3, 0.0F, 0.0F, 0.0F);
      this.leg4 = new ModelRenderer(this, 0, 16);
      this.leg4.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4);
      this.leg4.setRotationPoint(2.0F, 18.0F, -4.0F);
      this.leg4.setTextureSize(64, 32);
      this.leg4.mirror = true;
      this.setRotation(this.leg4, 0.0F, 0.0F, 0.0F);
      this.leg1 = new ModelRenderer(this, 0, 16);
      this.leg1.addBox(0.0F, 0.0F, -2.0F, 4, 6, 4);
      this.leg1.setRotationPoint(-4.0F, 18.0F, 4.0F);
      this.leg1.setTextureSize(64, 32);
      this.leg1.mirror = true;
      this.setRotation(this.leg1, 0.0F, 0.0F, 0.0F);
      this.leg2 = new ModelRenderer(this, 0, 16);
      this.leg2.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4);
      this.leg2.setRotationPoint(2.0F, 18.0F, 4.0F);
      this.leg2.setTextureSize(64, 32);
      this.leg2.mirror = true;
      this.setRotation(this.leg2, 0.0F, 0.0F, 0.0F);
      this.Shapewing = new ModelRenderer(this, 24, 0);
      this.Shapewing.addBox(0.0F, 0.0F, 0.0F, 13, 0, 5);
      this.Shapewing.setRotationPoint(0.0F, 8.0F, 2.0F);
      this.Shapewing.setTextureSize(64, 32);
      this.Shapewing.mirror = true;
      this.setRotation(this.Shapewing, -1.047198F, 0.3316126F, 3.141593F);
   }

   @Override public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      super.render(entity, f, f1, f2, f3, f4, f5);
      this.setRotationAngles(f, f1, f2, f3, f4, f5);
      this.Shapespine3.render(f5);
      this.Shapespine2.render(f5);
      this.shapespine1.render(f5);
      this.wing1.render(f5);
      this.Shapeboxhead.render(f5);
      this.Shapespine.render(f5);
      this.head.render(f5);
      this.body.render(f5);
      this.leg3.render(f5);
      this.leg4.render(f5);
      this.leg1.render(f5);
      this.leg2.render(f5);
      this.Shapewing.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
      this.wing1.rotateAngleX = MathHelper.cos(f * -0.6662F) * 1.0F * f1;
      this.Shapewing.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1;
   }
}
