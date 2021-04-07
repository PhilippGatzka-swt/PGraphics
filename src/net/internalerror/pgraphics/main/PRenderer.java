package net.internalerror.pgraphics.main;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PRenderer {
    private List<PNode> units = new ArrayList<>();
    private static PRenderer self;
    private boolean sorted = false;

    private PRenderer() {

    }

    private static PRenderer get() {
        if (self == null)
            self = new PRenderer();
        return self;
    }

    public enum Layers {
        BACKGROUND(1), MAIN(4), OVERLAY(8);

        private final int depth;

        private Layers(int depth) {
            this.depth = depth;
        }

        public int getDepth() {
            return depth;
        }
    }

    public static void render(Graphics2D g2) {
        if (!get().sorted)
            get().sortByLayer();
        get().units.forEach(n -> {
            n.render(g2);
        });
    }

    public static void update() {
        get().sortByLayer();
    }

    private void sortByLayer() {
        Collections.sort(get().units);
    }

    public static void addNode(PNode node) {
        get().units.add(node);
        get().sorted = false;
    }

}
