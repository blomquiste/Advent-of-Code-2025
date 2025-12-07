import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day2 {

    public static void findInvalidIDs() {
        String file = "src/input/day2.txt";
        String line = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            line = reader.readLine();
        } catch (IOException e) {
            System.out.println(
                    "An error occurred while reading the file: "
                            + e.getMessage());
        }
        String[] codes = line.split(",");

        for (int i = 0; i < codes.length; i++) {
            detectInvalid(codes[i]);
        }

        System.out.println("Secret Number is: " + 1 +
                "\nReal Secret Number is: " + 2);
    }

    private static void detectInvalid(String code) {

    }
}