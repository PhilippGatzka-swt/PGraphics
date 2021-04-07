package net.internalerror.pgraphics.main.nodes;

import net.internalerror.pgraphics.main.PNode;

import java.awt.*;

public class PLabel extends PNode {
    private Alignment alignment = Alignment.CENTER;
    private int[] padding = new int[]{0, 0, 0, 0};
    private Font font;
    private Color fontColor;
    private String text;

    public PLabel() {
        setAlignment(Alignment.CENTER);
        setPadding(new int[]{0, 0, 0, 0});
        setFont(new Font("TimesRoman", Font.PLAIN, 11));
        setFontColor(Color.black);
        setText("HelloWorld!");
    }

    @Override
    protected void render(Graphics2D g) {
        //g.setFont(font);
        g.setColor(fontColor);
        int stringWidth = g.getFontMetrics().stringWidth(text);
        int stringHeight = g.getFont().getSize();
        int _x = 0;
        int _y = 0;
        int centeredX = transform.size.x / 2 + transform.position.x - stringWidth / 2;
        int centeredY = transform.size.y / 2 + transform.position.y + stringHeight / 2;
        int leftX = transform.position.x + padding[0];
        int rightX = transform.size.x + transform.position.x - stringWidth - padding[1];
        int topY = transform.position.y + stringHeight - 2 + padding[2];
        int bottomY = transform.size.y + transform.position.y - padding[3];
        switch (alignment) {
            case CENTER:
                _x = centeredX;
                _y = centeredY;
                break;
            case RIGHT_CENTER:
                _x = rightX;
                _y = centeredY;
                break;
            case RIGHT_TOP:
                _x = rightX;
                _y = topY;
                break;
            case RIGHT_BOTTOM:
                _x = rightX;
                _y = bottomY;
                break;
            case LEFT_CENTER:
                _x = leftX;
                _y = centeredY;
                break;
            case LEFT_TOP:
                _x = leftX;
                _y = topY;
                break;
            case LEFT_BOTTOM:
                _x = leftX;
                _y = bottomY;
                break;
            case TOP_CENTER:
                _x = centeredX;
                _y = topY;
                break;
            case BOTTOM_CENTER:
                _x = centeredX;
                _y = bottomY;
                break;
        }
        g.drawString(text, _x, _y);
    }

    public enum Alignment {
        CENTER,
        RIGHT_CENTER,
        RIGHT_TOP,
        RIGHT_BOTTOM,
        LEFT_CENTER,
        LEFT_TOP,
        LEFT_BOTTOM,
        TOP_CENTER,
        BOTTOM_CENTER
    }

    public PLabel setAlignment(Alignment alignment) {
        this.alignment = alignment;
        return this;
    }

    public PLabel setPadding(int[] padding) {
        this.padding = padding;
        return this;
    }

    public PLabel setFont(Font font) {
        this.font = font;
        return this;
    }

    public PLabel setFontColor(Color fontColor) {
        this.fontColor = fontColor;
        return this;
    }

    public PLabel setText(String text) {
        this.text = text;
        return this;
    }
}
