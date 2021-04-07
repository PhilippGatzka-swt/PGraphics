package net.internalerror.pgraphics.main;

import net.internalerror.pgraphics.main.hardwarelisteners.PKeyboardListener;
import net.internalerror.pgraphics.main.hardwarelisteners.PMouseListener;
import net.internalerror.pgraphics.main.nodes.PButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PApplicationManager extends JPanel implements KeyListener, MouseListener, ActionListener, MouseMotionListener {
    private final int width;
    private final int height;
    private Timer timer;
    private Color[] colors = new Color[]{
            Color.yellow,
            Color.orange,
            Color.red,
            Color.pink,
            Color.magenta,
            Color.blue,
            Color.cyan,
            Color.green
    };

    private String[] colorNames = new String[]{
            "Yellow",
            "Orange",
            "Red",
            "Pink",
            "Magenta",
            "Blue",
            "Cyan",
            "Green"
    };


    public PApplicationManager(int width, int height) {
        super();
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(width, height));
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        setFocusable(true);
        requestFocus();
        setBackground(Color.WHITE);
    }

    @Override
    public void addNotify() {
        super.addNotify();
        timer = new Timer(8, this);
        timer.start();

        addNodes();
    }

    private void addNodes() {
        new PButton().setPressed(Color.red).setHover(Color.blue);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setBackground(Color.BLACK);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        PRenderer.render(g2);
    }

    private void update() {
        PRenderer.update();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        PKeyboardListener.keyTyped(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        PKeyboardListener.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        PKeyboardListener.keyReleased(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        PMouseListener.mouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        PMouseListener.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        PMouseListener.mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        PMouseListener.mouseEntered(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        PMouseListener.mouseExited(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        PMouseListener.mouseDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        PMouseListener.mouseMoved(e);
    }
}
