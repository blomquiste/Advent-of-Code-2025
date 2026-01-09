import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.stream.Stream;

public class Day3 {
    public static int joltage = 0;

    public static void calculateJoltage() {
        String file = "src/input/day3.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int biggest = line.charAt(0)-48;
                for (int i = 1; i < line.length(); i++) {

                }
                System.out.println(line);
                System.out.println(biggest);
                joltage++;
            }
        } catch (IOException e) {
            System.out.println(
                    "An error occurred while reading the file: "
                            + e.getMessage());
        }

        System.out.println("Sum of Invalid IDs is: " + joltage +
                "\nSum of Super Invalid IDs is: " + joltage);
    }

    }