import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class Day2 {
    static long sumInvalidIDs = 0;

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
        String[] codes = (line.split(","));

        for (String code : codes) {
            detectInvalid(code);
        }

        System.out.println("Sum of Invalid IDs is: " + sumInvalidIDs);
    }

    private static void detectInvalid(String code) {
        String[] ranges = code.split("-");
        long from = Long.parseLong(ranges[0]);
        long to = Long.parseLong(ranges[1]);

        for (long i = from; i <= to; i++) {
            String iS = Long.toString(i);

            if (iS.length() % 2 == 0) {
                int half = iS.length() / 2;
                if (Objects.equals(iS.substring(0, half), iS.substring(half))) {
                    sumInvalidIDs += i;
                }
        }

        }
    }
}