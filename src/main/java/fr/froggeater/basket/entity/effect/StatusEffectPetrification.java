package fr.froggeater.basket.entity.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class StatusEffectPetrification extends StatusEffect {
    public StatusEffectPetrification() {
        super(StatusEffectCategory.HARMFUL, 0x000000);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration > 0;
    }
}
