package net.internalerror.pgraphics.main.hardwarelisteners;

import net.internalerror.pgraphics.main.PPoint;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class PMouseListener {
    private static PMouseListener self;
    List<String> buttons = new ArrayList<>();
    private PPoint lastClick = new PPoint(0, 0);
    private PPoint mousePosition = new PPoint(0, 0);

    private PMouseListener() {

    }

    private static PMouseListener get() {
        if (self == null) self = new PMouseListener();
        return self;
    }


    public static void mouseClicked(MouseEvent e) {
        // Nothing
    }

    public static boolean mousePressed(int button) {
        return get().buttons.contains(button + "$");
    }

    public static void mousePressed(MouseEvent e) {
        get().buttons.add(e.getButton() + "$");
        get().lastClick.x = e.getX();
        get().lastClick.y = e.getY();
    }

    public static boolean mouseBetween(int x1, int y1, int x2, int y2) {
        return y1 < get().mousePosition.y && y2 > get().mousePosition.y && x1 < get().mousePosition.x && x2 > get().mousePosition.x;
    }

    public static void mouseReleased(MouseEvent e) {
        self.buttons.remove(e.getButton() + "$");
    }

    public static void mouseExited(MouseEvent e) {
        // Nothing
    }

    public static void mouseDragged(MouseEvent e) {
        // Nothing
    }

    public static void mouseMoved(MouseEvent e) {
        get().mousePosition.x = e.getX();
        get().mousePosition.y = e.getY();
    }

    public static void mouseEntered(MouseEvent e) {
        // Nothing
    }
}
