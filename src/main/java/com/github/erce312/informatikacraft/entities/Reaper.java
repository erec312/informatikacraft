package com.github.erce312.informatikacraft.entities;

import com.github.erce312.informatikacraft.init.InformatikacraftEntities;
import com.github.erce312.informatikacraft.init.InformatikacraftItems;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RangedBowAttackGoal;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class Reaper extends AbstractSkeletonEntity
{
  
    public Reaper(EntityType<? extends AbstractSkeletonEntity> type, World wotldIn) 
    {
        super((EntityType<? extends SkeletonEntity>) InformatikacraftEntities.REAPER, wotldIn);
    }
    @Override
     protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) 
    {
         super.setEquipmentBasedOnDifficulty(difficulty);
         this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(InformatikacraftItems.amethyst_bow));

    }
    @Override
    protected SoundEvent getStepSound() {
        return null;
    }
    @Override
    public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
          ItemStack itemstack = this.findAmmo(this.getHeldItem(ProjectileHelper.getHandWith(this, InformatikacraftItems.amethyst_bow)));
          AbstractArrowEntity abstractarrowentity = this.func_213624_b(itemstack, distanceFactor);
          if (this.getHeldItemMainhand().getItem() instanceof net.minecraft.item.BowItem)
             abstractarrowentity = ((net.minecraft.item.BowItem)this.getHeldItemMainhand().getItem()).customeArrow(abstractarrowentity);
          double d0 = target.posX - this.posX;
          double d1 = target.getBoundingBox().minY + (double)(target.getHeight() / 3.0F) - abstractarrowentity.posY;
          double d2 = target.posZ - this.posZ;
          double d3 = (double)MathHelper.sqrt(d0 * d0 + d2 * d2);
          abstractarrowentity.shoot(d0, d1 + d3 * (double)0.2F, d2, 1.6F, (float)(14 - this.world.getDifficulty().getId() * 4));
          this.playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
          this.world.addEntity(abstractarrowentity);
        super.attackEntityWithRangedAttack(target, distanceFactor);
    }          
}