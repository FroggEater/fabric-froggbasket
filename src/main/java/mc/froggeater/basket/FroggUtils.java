package mc.froggeater.basket;

public class FroggUtils {
    public static int raise(int start, int exponent) {
        if (exponent == 0) return start;
        
        int absoluteExponent = Math.abs(exponent);
        return exponent > 0 ? start << absoluteExponent : start >> absoluteExponent;
    }
}
