package net.internalerror.pgraphics.main;

import java.awt.*;

public abstract class PNode<C> implements Comparable<PNode<C>> {
    protected PTransform transform;
    protected PRenderer.Layers renderingLayer = PRenderer.Layers.MAIN;

    protected PNode() {
        transform = new PTransform();
        PRenderer.addNode(this);
    }

    @Override
    public int compareTo(PNode o) {
        int r = 1;
        if (o.renderingLayer.getDepth() > renderingLayer.getDepth())
            r = -1;
        return r;
    }

    protected PRenderer.Layers getRenderingLayer() {
        return renderingLayer;
    }

    protected C setRenderingLayer(PRenderer.Layers renderingLayer) {
        this.renderingLayer = renderingLayer;
        return null;
    }

    protected abstract void render(Graphics2D g);

    public C setSize(int x, int y) {
        transform.size.x = x;
        transform.size.y = y;
        return (C) this;
    }

    public C setPosition(int x, int y) {
        transform.position.x = x;
        transform.position.y = y;
        return (C) this;
    }
}
