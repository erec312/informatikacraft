package com.github.erce312.informatikacraft.entities;

import com.github.erce312.informatikacraft.init.InformatikacraftEntities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class Reaper extends SkeletonEntity
{

	@SuppressWarnings("unchecked")
	public Reaper(EntityType<? extends AbstractSkeletonEntity> type, World wotldIn) 
	{
		super((EntityType<? extends SkeletonEntity>) InformatikacraftEntities.REAPER, wotldIn);
	}
	@Override
	 protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) 
	{
	     super.setEquipmentBasedOnDifficulty(difficulty);
	     this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.APPLE));
	}
	@Override
	protected SoundEvent getStepSound() {
		return null;
	}

}

