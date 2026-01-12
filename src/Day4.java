import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day4 {
    public static int joltage = 0;
    public static double bigJoltage = 0;
    public static int[] theTwelve = new int[12];

    public static void optimizeForklifts() {
        String file = "src/input/day4.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                findJoltage(line);
                findBiggest(line, 0, 0);
                calculateBigJoltage();
            }
        } catch (IOException e) {
            System.out.println(
                    "An error occurred while reading the file: "
                            + e.getMessage());
        }

        System.out.println("The number of moveable paper rolls is: " + joltage +
                "\nThe 12 battery joltage is: " + bigJoltage);
    }

    public static void findJoltage(String line) {

    }

    public static void findBiggest(String line, int index, int found) {

    }

    private static void calculateBigJoltage() {

    }
}