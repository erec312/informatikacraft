package com.github.erce312.informatikacraft.client.renders;

import com.github.erce312.informatikacraft.entities.Reaper;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class InformatikacraftRenderRegistry 
{
	public static void registryEntityRenders() 
	{
		RenderingRegistry.registerEntityRenderingHandler(Reaper.class, new ReaperRender.RenderFactory());
	}
}
