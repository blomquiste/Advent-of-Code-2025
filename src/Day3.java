import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day3 {
    public static int joltage = 0;
    public static double bigJoltage = 0;
    public static int[] theTwelve = new int[12];

    public static void turnOnBattery() {
        String file = "src/input/day3.txt";
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

        System.out.println("The maximum 2 battery joltage is: " + joltage +
                "\nThe 12 battery joltage is: " + bigJoltage);
    }

    public static void findJoltage(String line) {
        int biggest = line.charAt(0)-48;
        int index = 0;
        for (int i = 1; i < line.length()-1; i++) {
            if (line.charAt(i)-48 > biggest) {
                biggest = line.charAt(i)-48;
                index = i;
            }
        }

        int secondBiggest = line.charAt(index+1)-48;
        for (int i = index+1; i < line.length(); i++) {
            if (line.charAt(i)-48 > secondBiggest) {
                secondBiggest = line.charAt(i)-48;
            }
        }
        joltage += (biggest*10) + secondBiggest;
    }

    public static void findBiggest(String line, int index, int found) {
        if (found == 12) {
            return;
        }

        int newIndex = index;
        theTwelve[found]=line.charAt(index)-48;

        for (int i = index; i < line.length()-(11-found); i++) {
            if (line.charAt(i)-48 > theTwelve[found]) {
                theTwelve[found]=line.charAt(i)-48;
                newIndex = i;
                System.out.println("INSIDE newIndex: "+newIndex);
            }
            System.out.println(i);
        }
        newIndex++;
        found++;
        findBiggest(line, newIndex, found);
    }

    private static void calculateBigJoltage() {
        int power = 11;
        for (int i = 0; i < 12; i++) {
            bigJoltage += theTwelve[i] * Math.pow(10,power);
            power--;
        }
    }
}