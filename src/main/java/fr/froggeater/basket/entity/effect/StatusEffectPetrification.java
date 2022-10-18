package fr.froggeater.basket.entity.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.math.Vec3d;

public class StatusEffectPetrification extends StatusEffect {
    public StatusEffectPetrification() {
        super(StatusEffectCategory.HARMFUL, 0x000000);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration > 0;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        double speedMultiplier = 0.5 + (1.0 / (double)(1 << (amplifier + 1)));
        Vec3d speedMultiplier3d = new Vec3d(speedMultiplier, speedMultiplier, speedMultiplier);

        entity.slowMovement(entity.getSteppingBlockState(), speedMultiplier3d);
        entity.damage(DamageSource.MAGIC, (float)(1 << amplifier) / 2.0f);
    }
}
