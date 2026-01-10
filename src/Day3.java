import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.stream.Stream;

public class Day3 {
    public static int joltage = 0;
    public static int bigJoltage = 0;

    public static void calculateJoltage() {
        String file = "src/input/day3.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
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

                /*System.out.println(line);
                System.out.println(biggest);
                System.out.println(secondBiggest);*/
                joltage += (biggest*10) + secondBiggest;
            }
        } catch (IOException e) {
            System.out.println(
                    "An error occurred while reading the file: "
                            + e.getMessage());
        }

        System.out.println("The maximum 2 battery joltage is: " + joltage +
                "\nThe 12 battery joltage is: " + bigJoltage);
    }

    }