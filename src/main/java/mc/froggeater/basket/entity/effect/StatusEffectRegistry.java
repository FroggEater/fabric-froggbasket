package mc.froggeater.basket.entity.effect;

import mc.froggeater.basket.FroggBasket;
import mc.froggeater.basket.FroggBasketRegistry;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.lang.reflect.Field;

public class StatusEffectRegistry implements FroggBasketRegistry {
  public static final FroggStatusEffect PETRIFICATION = new StatusEffectPetrification();

  public static void registerAll() {
    try {
      int registered = 0;

      for (Field field : StatusEffectRegistry.class.getDeclaredFields()) {
        if (StatusEffect.class.isAssignableFrom(field.getType())) {
          Identifier id = new Identifier(FroggBasket.MOD_ID, field.getName().toLowerCase());
          Registry.register(Registry.STATUS_EFFECT, id, ((FroggStatusEffect)field.get(null)).onRegister());
          registered++;
          LOGGER.info("FroggBasket - Registered status effect " + id);
        }
      }
    } catch (Exception e) {
      LOGGER.error(e.getMessage());
    }
  }
}
