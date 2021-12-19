package Render;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RGBColor {
    private int R;
    private int G;
    private int B;

    RGBColor(int R, int G, int B) {
        try {
            if (isRGBValue(R, G, B)) {
                this.R = R;
                this.G = G;
                this.B = B;
            }
        } catch (IllegalAccessError e) { e.printStackTrace(); }
    }

    private boolean isRGBValue(int R, int G, int B) {
        boolean isInRangeOfRGB =
                R < 0 || R > 255 || G < 0 || G > 255 || B < 0 || B > 255;
        if (isInRangeOfRGB) {
            String errorFormat = "ERROR: (%d, %d, %d) RGB value must be in " +
                    "range of 0-255";
            throw new IllegalArgumentException(
                    String.format(errorFormat, R, G, B));
        }
        return true;
    }

    public void setColor(String RGBValue) {
        Pattern RGB_PATTERN = Pattern.compile(
                "(\\s*(\\d{1,3})\\s*,\\s*(\\d{1,3})\\s*,\\s*(\\d{1,3})\\s*)",
                Pattern.MULTILINE);
        Matcher matcher = RGB_PATTERN.matcher(RGBValue);
        if (matcher.find()) {
            int configR = Integer.parseInt(matcher.group(2));
            int configG = Integer.parseInt(matcher.group(3));
            int configB = Integer.parseInt(matcher.group(4));
            if (isRGBValue(configR, configG, configB)) {
                R = configR;
                G = configG;
                B = configB;
            }
        }
    }

    public int getR() {
        return R;
    }

    public int getG() {
        return G;
    }

    public int getB() {
        return B;
    }
}
