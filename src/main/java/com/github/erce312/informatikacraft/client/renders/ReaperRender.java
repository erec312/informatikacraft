package com.github.erce312.informatikacraft.client.renders;

import com.github.erce312.informatikacraft.Informatikacraft.RegistryEvents;
import com.github.erce312.informatikacraft.client.models.ReaperModel;
import com.github.erce312.informatikacraft.entities.Reaper;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class ReaperRender extends LivingRenderer<Reaper, ReaperModel> 
{

	public ReaperRender(EntityRendererManager manager) 
	{

		super(manager, new ReaperModel(), 0.5f);
		this.addLayer(new HeldItemLayer<Reaper, ReaperModel>(this));
	}

	@Override
	protected ResourceLocation getEntityTexture(Reaper entity) 
	{

		return RegistryEvents.location("textures/entity/reaper.png");
	}
	

	public static class RenderFactory implements IRenderFactory<Reaper>
	{

		@Override
		public EntityRenderer<? super Reaper> createRenderFor(EntityRendererManager manager) {
			return new ReaperRender(manager);
		}

	}

}
