import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day1 {
    private static final int START = 50;
    private static int pointingAt = START;
    private static int secretNumber = 0;
    private static int realSecretNumber = 0;

    public static void unlockTheDoor() {
        String file = "src/input/day1.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            char LorR;
            int numbers;

            while ((line = reader.readLine()) != null) {
                LorR = line.charAt(0);
                numbers = Integer.parseInt(line.substring(1));
                int rotation = decideDirection(LorR, numbers);
                turn1(rotation);
            }
        } catch (IOException e) {
            System.out.println(
                    "An error occurred while reading the file: "
                            + e.getMessage());
        }
        System.out.println("Secret Number is: " + secretNumber +
                "\nReal Secret Number is: " + realSecretNumber);
        System.out.println("Yas");
    }

    private static int decideDirection(char LorR, int numbers){
        if (LorR == 'L'){
            numbers = -numbers;
        }
        return numbers;
    }

    private static void turn1(int rotation) {
        int start = pointingAt;
        int end = pointingAt + rotation;

        // Count every zero crossed during the rotation
        int step = rotation > 0 ? 1 : -1;
        for (int pos = start + step; step > 0 ? pos <= end : pos >= end; pos += step) {
            int dialPos = ((pos % 100) + 100) % 100;
            if (dialPos == 0) realSecretNumber++;
        }

        // Update dial position (wrap 0-99)
        pointingAt = ((end % 100) + 100) % 100;

        // Part 1: count if final position is 0
        if (pointingAt == 0) secretNumber++;
    }


    private static void turn(int rotation){
        passingZero(rotation);
        pointingAt = (pointingAt + rotation) % 100;
        if (pointingAt < 0) pointingAt += 100;
        if (pointingAt == 0) {
            secretNumber++;
            realSecretNumber++;
        }
    }

    private static void passingZero(int rotation) {
        //counting full laps
        realSecretNumber += Math.abs(rotation) / 100;

        //counting if remainders pass
        if (rotation < 0 && (pointingAt + rotation) < 0) {
            realSecretNumber++;
        }
        if (rotation > 0 && (pointingAt + rotation) > 99) {
            realSecretNumber++;
        }
    }
}
