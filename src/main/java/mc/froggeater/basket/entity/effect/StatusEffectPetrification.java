package mc.froggeater.basket.entity.effect;

import mc.froggeater.basket.FroggUtils;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.math.Vec3d;

public class StatusEffectPetrification extends FroggStatusEffect {
    public StatusEffectPetrification() {
        super(StatusEffectCategory.HARMFUL, 0x000000, 1);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        double speed = 0.6 + 1.0 / (double) FroggUtils.raise(1, amplifier + 1);
        float damage = (float) FroggUtils.raise(1, amplifier) / 2.0f;
        Vec3d newSpeed = new Vec3d(speed, speed, speed);

        entity.slowMovement(entity.getSteppingBlockState(), newSpeed);
        entity.damage(DamageSource.MAGIC, damage);
    }
}
