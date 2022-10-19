package mc.froggeater.basket.entity.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class FroggStatusEffect extends StatusEffect {
    private boolean isRegistered = false;
    private boolean isInstant = false;
    private int delayAmount = 0;

    public FroggStatusEffect(StatusEffectCategory category, int color, int delay) {
        super(category, color);

        isInstant = delay < 0;
        delayAmount = Math.max(0, delay) * 20;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public boolean isInstant() {
        return isInstant;
    }

    public int getDelay() {
        return delayAmount;
    }

    public FroggStatusEffect onRegister() {
        isRegistered = true;
        return this;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        if (isInstant()) {
            return canApplyInstantEffect(duration, amplifier);
        }

        return canApplyEffect(duration, amplifier);
    }

    public boolean canApplyInstantEffect(int duration, int amplifier) {
        return true;
    }

    public boolean canApplyEffect(int duration, int amplifier) {
        return (duration % Math.max(1, getDelay()) == 0);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (isInstant()) {
            applyInstantEffect(null, null, entity, amplifier, 1.0d);
        }
    }
}
