package net.internalerror.pgraphics.main;

public class PVector2D extends PComponent{
    public int x;
    public int y;

    public PVector2D(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
