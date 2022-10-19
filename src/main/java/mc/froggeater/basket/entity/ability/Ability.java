package mc.froggeater.basket.entity.ability;

public class Ability {
    public int recharge;
    private int cooldown;
    private int duration;

    public void onDurationDepletion() {
        return;
    }
}
