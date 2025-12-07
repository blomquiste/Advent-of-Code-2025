import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day1 {
    private static final int START = 50;
    private static int stoppedAt = START;
    private static int secretNumber = 0;
    private static int realSecretNumber = 0;

    public static void unlockTheDoor() {
        String file = "src/input/day1.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            char LorR;
            int rotation;

            while ((line = reader.readLine()) != null) {
                LorR = line.charAt(0);
                rotation = Integer.parseInt(line.substring(1));
                rotation = setDirection(LorR, rotation);
                turnAndCount(rotation);
            }
        } catch (IOException e) {
            System.out.println(
                    "An error occurred while reading the file: "
                            + e.getMessage());
        }

        System.out.println("Secret Number is: " + secretNumber +
                "\nReal Secret Number is: " + realSecretNumber);
    }

    private static int setDirection(char LorR, int numbers){
        if (LorR == 'L'){
            numbers = -numbers;
        }
        return numbers;
    }

    private static void turnAndCount(int rotation) {
        int end = stoppedAt + rotation;
        int step = rotation > 0 ? 1 : -1;

        for (int i = stoppedAt + step; step > 0 ? i <= end : i >= end; i += step) {
            int pointingAt = ((i % 100) + 100) % 100;
            if (pointingAt == 0) realSecretNumber++;    // Count for task 2
        }

        stoppedAt = (stoppedAt + rotation) % 100;

        if (stoppedAt == 0) secretNumber++;     // Count for task 1
    }
}
