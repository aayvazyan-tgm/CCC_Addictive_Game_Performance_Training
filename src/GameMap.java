/**
 * Created by Ari Ayvazyan on 26.10.2014.
 */
public class GameMap {
    int numberOfPoints = 0;
    Point[] points;
    int[][] map;

    public GameMap(int xSize, int ySize, int numberOfPoints, int... points) {
        this.map = new int[xSize][ySize];
        this.numberOfPoints = numberOfPoints;
        this.points = new Point[numberOfPoints];
        int tmp = 0;
        for (int i = 0; i < numberOfPoints; i++) {
            Point2D pointInGrid = calcPointXYPosition(points[tmp++]);
            this.points[i] = new Point(pointInGrid.x, pointInGrid.y, points[tmp++]);
        }
    }

    public Point2D calcPointXYPosition(int number) {
        int x = number / getWidth();
        int y = number - (x * getWidth());
        if (number % getWidth() == 0) {
            x--;
            y = getWidth();
        }
        return new Point2D(x, y - 1);
    }

    public int getHeight() {
        return this.map.length;
    }

    public int getWidth() {
        return this.map[0].length;
    }
}
