import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class Day2 {
    static long sumInvalidIDs = 0;
    static long sumSuperInvalidIDs = 0;

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

        System.out.println("Sum of Invalid IDs is: " + sumInvalidIDs +
                "\nSum of Super Invalid IDs is: " + sumSuperInvalidIDs);
    }

    private static void detectInvalid(String code) {
        String[] ranges = code.split("-");
        long from = Long.parseLong(ranges[0]);
        long to = Long.parseLong(ranges[1]);

        for (long nrID = from; nrID <= to; nrID++) {
            String stID = Long.toString(nrID);

            if (stID.length() % 2 == 0) {
                int half = stID.length() / 2;
                if (Objects.equals(stID.substring(0, half), stID.substring(half))) {
                    sumInvalidIDs += nrID;
                }
            }

            if (isRepeating(stID)) {sumSuperInvalidIDs += nrID;} ;

        }
    }

    private static boolean isRepeating(String stID) {
        int maxCombinationLength = stID.length()/2;
        for (int p = 1; p <= maxCombinationLength; p++) {
            String repeatingSequence = stID.substring(0, p);
            int repetitions = 2;
            String comparingSequence = repeatingSequence.repeat(repetitions);
            while (comparingSequence.length() <= stID.length()) {
                if (Objects.equals(comparingSequence, stID)) { return true; }
                repetitions++;
                comparingSequence = repeatingSequence.repeat(repetitions);
            }
        }
        return false;
    }
}