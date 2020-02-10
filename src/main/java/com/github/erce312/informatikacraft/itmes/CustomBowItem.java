package com.github.erce312.informatikacraft.itmes;

import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;

public class CustomBowItem extends BowItem
{

	public CustomBowItem(Properties builder) {
		super(builder);

	}
	@Override
	public void setDamage(ItemStack stack, int damage) {

		stack.getOrCreateTag().putInt("Damage", Math.max(30, 30));
	}

}
