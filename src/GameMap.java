/**
 * Created by Ari Ayvazyan on 26.10.2014.
 */
public class GameMap {
    int numberOfPoints = 0;
    Point[] points;
    int[][] map;

    public GameMap(int xSize, int ySize, int numberOfPoints, int... rawPoints) {
        this.map = new int[xSize][ySize];
        this.numberOfPoints = numberOfPoints;
        this.points = new Point[numberOfPoints];
        int tmp = 0;
        for (int i = 0; i < numberOfPoints; i++) {
            Point2D pointInGrid = calcPointXYPosition(rawPoints[tmp++]);
            if (pointInGrid.x < 0 || pointInGrid.y < 0) System.err.println("nope");
            this.points[i] = new Point(pointInGrid.x, pointInGrid.y, rawPoints[tmp++]);
        }
        //Sets the colors on the map
        for (int i = 0; i < this.points.length; i++) {
            this.map[this.points[i].x][this.points[i].y] = this.points[i].color;
        }
        printMap();
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

    public void printMap() {
        System.out.println("--------------------------------------");
        for (int i = 0; i < map.length; i++) {
            String row = "";
            for (int j = 0; j < map[0].length; j++) {
                row +=map[i][j] + "\t";
            }
            System.out.println(row);
        }
        System.out.println("--------------------------------------");

    }
}
