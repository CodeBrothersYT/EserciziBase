package it.core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Autoclicker extends JDialog {

    public Autoclicker() throws AWTException {
        this.setSize(500, 500);
        JPanel panel = new JPanel();
        panel.setSize(500, 500);
        panel.setBackground(Color.BLACK);
        this.add(panel);
        this.setVisible(true);

        Robot robot = new Robot();
        Timer timer = new Timer(1000, e -> {
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            panel.setBackground(new Color(getHue(), getHue(), getHue(), 255));
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        });

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == ' ') {
                    timer.setRepeats(true);
                    timer.start();
                }
                if (e.getKeyChar() == 'x') {
                    timer.stop();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        });
    }

    private int getHue() {
        return (int) (Math.random() * 255);
    }

    public static void main(String[] args) throws AWTException {
        Autoclicker tester = new Autoclicker();
    }
}