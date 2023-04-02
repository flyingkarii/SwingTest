package me.kari.utils;

import java.awt.*;

public class ColorUtils {

    private final Color color;
    private int originalRedValue = Integer.MIN_VALUE;
    private int originalBlueValue = Integer.MIN_VALUE;
    private int originalGreenValue = Integer.MIN_VALUE;


    private static final int MAX_RGB_VALUE = 255;

    public ColorUtils(Color color) {
        this.color = color;

        if (originalRedValue == Integer.MIN_VALUE) {
            originalRedValue = color.getRed();
            originalBlueValue = color.getBlue();
            originalGreenValue = color.getGreen();
        }
    }

    private int incrementValue(int value, int increment) {
        return Math.min(255, value + increment);
    }

    public Color invert() {
        int alpha = color.getAlpha();
        int red = MAX_RGB_VALUE - color.getRed();
        int green = MAX_RGB_VALUE - color.getGreen();
        int blue = MAX_RGB_VALUE - color.getBlue();

        if ((red + green + blue > 740) || (red + green + blue < 20)) {
            return new Color(MAX_RGB_VALUE, MAX_RGB_VALUE, 40, alpha);
        } else {
            return new Color(red, green, blue, alpha);
        }
    }

    public Color brighter(int rIncrease, int gIncrease, int bIncrease) {
        return new Color(
                incrementValue(color.getRed(), rIncrease),
                incrementValue(color.getBlue(), bIncrease),
                incrementValue(color.getGreen(), gIncrease),
                color.getAlpha()
        );
    }


}
