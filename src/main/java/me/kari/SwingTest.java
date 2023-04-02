package me.kari;

import me.kari.ui.KButton;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;

public class SwingTest {
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private JFrame frame;
    private JButton button;

    private int width, height;

    public SwingTest(int width, int height) {
        this.width = width;
        this.height = height;

        Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);

        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(31, 31, 31));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setIconImage(icon);
        frame.setLayout(null);

        button = new JButton("Close");
        button.setBackground(new Color(45, 45, 45));
        button.setPreferredSize(new Dimension(200, 20));
        button.setBorderPainted(true);
        button.setBorder(new LineBorder(new Color(20, 20, 20)));
        button.setUI(new KButton());
        button.addActionListener(e -> {
            frame.dispose();
        });

        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(button);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JButton getButton() {
        return button;
    }
}
