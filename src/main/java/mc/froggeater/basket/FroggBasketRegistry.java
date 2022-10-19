package mc.froggeater.basket;

import net.minecraft.entity.effect.StatusEffect;
import org.slf4j.Logger;

public interface FroggBasketRegistry {
    Logger LOGGER = FroggBasket.LOGGER;

    static void registerAll() {
    }

    static void register(StatusEffect effect) {
    }
}
