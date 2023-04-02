package me.kari.ui;

import me.kari.utils.ColorUtils;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class KButton extends BasicButtonUI {

    private Color originalColor = null;

    @Override
    public void paint(Graphics graphics, JComponent component) {
        AbstractButton button = (AbstractButton) component;
        ButtonModel model = button.getModel();
        Color paintColor = component.getBackground();
        boolean passed = (model.isPressed() || model.isArmed() ||   model.isRollover());

        if (originalColor == null)
            originalColor = paintColor;

        if (passed) {
            button.setBorderPainted(true);
            paintColor = new ColorUtils(originalColor).brighter(10, 10, 10);
        } else {
            button.setBorderPainted(false);
            paintColor = originalColor;
        }

        component.setBackground(paintColor);
        component.setForeground(new ColorUtils(paintColor).invert());
        super.paint(graphics, component);
    }
}
