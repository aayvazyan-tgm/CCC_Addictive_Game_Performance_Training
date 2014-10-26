import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * Created by Ari Ayvazyan on 26.10.2014.
     */
    public static void main(String[] args) {
        System.out.println(handleAllTests(readIntInput("level1-1.in")));
    }

    public static String handleAllTests(Integer... allTests) {
        Integer[][] separatedTests = new Integer[allTests[0]][];
        int testNum = 0;
        ArrayList<Integer> tmpTest = new ArrayList<Integer>();
        //we start form position 2, because the first one defines the number of tests
        for (int i = 1; i < allTests.length; i++) {
            if (allTests[i] == 0) {
                separatedTests[testNum] = tmpTest.toArray(new Integer[tmpTest.size()]);
                testNum++;
                tmpTest = new ArrayList<Integer>();
            } else {
                tmpTest.add(allTests[i]);
            }
        }
        String result = "";
        //Process the Tests
        for (int i = 0; i < separatedTests.length; i++) {
            int[] testX = new int[separatedTests[i].length-3];
            int xSize = separatedTests[i][0];
            int ySize = separatedTests[i][1];
            int numberOfPoints = separatedTests[i][2];
            for (int j = 3; j < separatedTests[i].length; j++) {
                testX[j-3] = separatedTests[i][j];
            }
            result += handleOneTest(xSize, ySize, numberOfPoints, testX);
        }
        return "";
    }

    private static String handleOneTest(int xSize, int ySize, int numberOfPoints, int[] testX) {
        String result = "";
        GameMap gm = new GameMap(xSize, ySize, numberOfPoints, testX);

        return result;
    }

    public static Integer[] readIntInput(String filePath) {
        File f = new File(filePath);
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (f.exists()) {
            Scanner scanner = null;
            try {
                scanner = new Scanner(f);
                while (scanner.hasNextInt()) {
                    result.add(scanner.nextInt());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            scanner.close();
        } else {
            System.out.println("File not found!");
        }
        return result.toArray(new Integer[result.size()]);
    }
}
