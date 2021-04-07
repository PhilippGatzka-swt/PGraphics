package net.internalerror.pgraphics.main.nodes;

import net.internalerror.pgraphics.main.PNode;

import java.awt.*;

public class PRectangle extends PNode<PRectangle> {
    private Color background;
    private Color border;
    private boolean rounded;
    private int arcWidth = 0;
    private int arcHeight = 0;
    private boolean filled;
    private boolean bordered;

    public PRectangle() {
        border = Color.black;
        background = Color.gray;
        rounded = false;
        filled = true;
        bordered = true;
    }

    @Override
    protected void render(Graphics2D g) {
        if (filled) {
            g.setColor(background);
            if (rounded) {
                g.fillRoundRect(transform.position.x, transform.position.y, transform.size.x, transform.size.y, arcWidth, arcHeight);
            } else {
                g.fillRect(transform.position.x, transform.position.y, transform.size.x, transform.size.y);
            }
        }
        if (bordered) {
            g.setColor(border);
            if (rounded) {
                g.drawRoundRect(transform.position.x, transform.position.y, transform.size.x, transform.size.y, arcWidth, arcHeight);
            } else {
                g.drawRect(transform.position.x, transform.position.y, transform.size.x, transform.size.y);
            }
        }


    }

    public void setBackground(Color background) {
        this.background = background;
    }

    public void setBorder(Color border) {
        this.border = border;
    }

    public void setRounded(boolean rounded, int arcWidth, int arcHeight) {
        this.rounded = rounded;
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public void setBordered(boolean bordered) {
        this.bordered = bordered;
    }
}
