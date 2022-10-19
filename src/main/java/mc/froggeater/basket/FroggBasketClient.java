package mc.froggeater.basket;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class FroggBasketClient implements ClientModInitializer {
  private static KeyBinding keyBindCrawl;
  private static KeyBinding keyBindAbility;
  private static KeyBinding keyBindRecharge;

  @Override
  public void onInitializeClient() {
    keyBindCrawl = KeyBindingHelper.registerKeyBinding(new KeyBinding(
        "key.froggbasket.crawl",
        InputUtil.Type.KEYSYM,
        GLFW.GLFW_KEY_X,
        "category.froggbasket"
    ));
    keyBindAbility = KeyBindingHelper.registerKeyBinding(new KeyBinding(
        "key.froggbasket.ability",
        InputUtil.Type.KEYSYM,
        GLFW.GLFW_KEY_F,
        "category.froggbasket"
    ));
    keyBindRecharge = KeyBindingHelper.registerKeyBinding(new KeyBinding(
        "key.froggbasket.recharge",
        InputUtil.Type.KEYSYM,
        GLFW.GLFW_KEY_R,
        "category.froggbasket"
    ));

    ClientTickEvents.END_CLIENT_TICK.register(client -> {
      while (keyBindCrawl.wasPressed()) {
        client.player.sendMessage(Text.literal("> keyBindCrawl was pressed"));
      }
      while (keyBindAbility.wasPressed()) {
        client.player.sendMessage(Text.literal("> keyBindAbility was pressed"));
      }
      while (keyBindRecharge.wasPressed()) {
        client.player.sendMessage(Text.literal("> keyBindRecharge was pressed"));
      }
    });
  }
}
