package encryption;

import java.util.*;

public class CeasarCypher implements Encryptor {
    public CeasarCypher() {
        this.enteredMessages = new ArrayList<>();
    }

    private final List<Decryptor> enteredMessages;

    public String encrypt(String input){
        return encryptWithDecryptor(input, null, null);
    }

    public String encryptWithDecryptor(String input, String decryptQuestion, String decryptAnswer) {
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
            result = String.valueOf(resultChars);
            enteredMessages.add(new Decryptor(input, result, decryptQuestion, decryptAnswer));
        } catch (InputMismatchException e) {
            System.out.println("Entered interval is not an integer");
            throw e;
        }
        return result;
    }

    public List<Decryptor> getEnteredMessages() {
        return enteredMessages;
    }

    private char swapLetter(char letter, int interval, int lowerInt, int higherInt) {
        letter += interval;
        if (letter > higherInt) letter = (char) (letter - (higherInt - lowerInt) - 1);
        return letter;
    }
}
