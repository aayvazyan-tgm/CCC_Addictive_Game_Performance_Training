/**
 * Created by Ari Ayvazyan on 26.10.2014.
 */
public class Point2D {
    public int x=-1;
    public int y=-1;
    public Point2D(int x, int y) {
        this.x=x;
        this.y=y;
    }

    @Override
    public String toString() {
        return "x: "+x+" y: "+y;
    }
}