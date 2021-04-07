package net.internalerror.pgraphics.main.hardwarelisteners;

import java.awt.event.KeyEvent;

public class PKeyboardListener {
    public static void keyTyped(KeyEvent e) {
        System.out.println("keyTyped" + e);
    }

    public static void keyPressed(KeyEvent e) {
        System.out.println("keyPressed" + e);
    }

    public static void keyReleased(KeyEvent e) {
        System.out.println("keyReleased" + e);
    }
}
