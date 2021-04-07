package net.internalerror.pgraphics.main.nodes;

import net.internalerror.pgraphics.main.PNode;
import net.internalerror.pgraphics.main.hardwarelisteners.PActionListener;
import net.internalerror.pgraphics.main.hardwarelisteners.PMouseListener;

import java.awt.*;
import java.awt.event.MouseEvent;

public class PButton extends PNode<PButton> {
    private PRectangle rectangle;
    private PLabel label;
    private PActionListener actionListener;
    private Color hoverColor, clickColor, defaultColor;
    private int cooldown = 0;

    public PButton() {
        rectangle = new PRectangle();
        label = new PLabel();
    }

    @Override
    protected void render(Graphics2D g) {
        update();
    }

    private void update() {
        if (cooldown > 0) cooldown--;
        rectangle.setBackground(defaultColor);
        if (PMouseListener.mouseBetween(transform.position.x, transform.position.y, transform.position.x + transform.size.x, transform.position.y + transform.size.y)) {
            rectangle.setBackground(hoverColor);
            if (PMouseListener.mousePressed(MouseEvent.BUTTON1)) {
                if (cooldown <= 0) {
                    if (actionListener != null)
                        actionListener.actionPerformed();
                    cooldown = 10;
                }
                rectangle.setBackground(clickColor);
            }
        }
    }

    @Override
    public PButton setSize(int x, int y) {
        rectangle.setSize(x, y);
        label.setSize(x, y);
        return super.setSize(x, y);
    }

    @Override
    public PButton setPosition(int x, int y) {
        rectangle.setPosition(x, y);
        label.setPosition(x, y);
        return super.setPosition(x, y);
    }

    public PButton setRectangleBackground(Color color) {
        rectangle.setBackground(color);
        defaultColor = color;
        return this;
    }

    public PButton setRectangleBorder(Color color) {
        rectangle.setBorder(color);
        return this;
    }

    public PButton setRectangleBordered(boolean bordered) {
        rectangle.setBordered(bordered);
        return this;
    }

    public PButton setRectangleFilled(boolean filled) {
        rectangle.setFilled(filled);
        return this;
    }

    public PButton setRectangleRounded(boolean rounded, int arcWidth, int arcHeight) {
        rectangle.setRounded(rounded, arcWidth, arcHeight);
        return this;
    }

    public PButton setLabelText(String text) {
        label.setText(text);
        return this;
    }

    public PButton setLabelAlignment(PLabel.Alignment alignment) {
        label.setAlignment(alignment);
        return this;
    }

    public PButton setLabelFont(Font font) {
        label.setFont(font);
        return this;
    }

    public PButton setLabelFontColor(Color color) {
        label.setFontColor(color);
        return this;
    }

    public PButton setLabelPadding(int[] padding) {
        label.setPadding(padding);
        return this;
    }

    public PButton addActionListener(PActionListener actionListener) {
        this.actionListener = actionListener;
        return this;
    }

    public PButton setPressed(Color color) {
        clickColor = color;
        return this;
    }

    public PButton setHover(Color color) {
        hoverColor = color;
        return this;
    }
}
