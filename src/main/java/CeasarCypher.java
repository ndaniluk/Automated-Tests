import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CeasarCypher implements Encryptor {

    public String encrypt(String input) {
        System.out.println("This encryptor supports only English alphabet.");
        String result;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter an interval: ");
            int interval = scanner.nextInt();
            scanner.close();
            char[] inputChars = input.toCharArray();
            char[] resultChars = new char[inputChars.length];
            for (int i = 0; i < resultChars.length; i++) {
                int lowerInt;
                int higherInt;
                if (inputChars[i] >= (lowerInt = 65) && inputChars[i] <= (higherInt = 90)) {
                    resultChars[i] = swapLetter(inputChars[i], interval, lowerInt, higherInt);
                } else if (inputChars[i] >= (lowerInt = 97) && inputChars[i] <= (higherInt = 122)) {
                    resultChars[i] = swapLetter(inputChars[i], interval, lowerInt, higherInt);
                } else {
                    System.out.println("Entered input contains not supported characters. Please use English alphabet only.");
                    return null;
                }
            }
            System.out.println(resultChars);
            result = Arrays.toString(resultChars);
        } catch (InputMismatchException e) {
            System.out.println("Entered interval is not an integer");
            return null;
        }
        return result;
    }

    private char swapLetter(char letter, int interval, int lowerInt, int higherInt) {
        letter += interval;
        if (letter > higherInt) letter = (char) (letter - (higherInt - lowerInt));
        return letter;
    }
}
