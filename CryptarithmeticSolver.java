import java.util.HashMap;
import java.util.Map;

public class CryptarithmeticSolver {

    // Map to store the digit assigned to each letter
    private static Map<Character, Integer> letterToDigit = new HashMap<>();

    public static void main(String[] args) {
        // Example puzzle: SEND + MORE = MONEY
        String addend1 = "SEND";
        String addend2 = "MORE";
        String sum = "MONEY";
        
        // Get all unique letters in the puzzle
        String letters = getUniqueLetters(addend1 + addend2 + sum);

        // Create a puzzle object
        Puzzle puzzle = new Puzzle(addend1, addend2, sum);

        // Solve the puzzle
        if (exhaustiveSolve(puzzle, letters)) {
            System.out.println("Solution found:");
            for (Map.Entry<Character, Integer> entry : letterToDigit.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
        } else {
            System.out.println("No solution found.");
        }
    }

    // Helper function to get all unique letters from the puzzle
    private static String getUniqueLetters(String puzzle) {
        StringBuilder uniqueLetters = new StringBuilder();
        for (char ch : puzzle.toCharArray()) {
            if (Character.isLetter(ch) && uniqueLetters.indexOf(String.valueOf(ch)) == -1) {
                uniqueLetters.append(ch);
            }
        }
        return uniqueLetters.toString();
    }

    // Recursive exhaustive solve function
    static boolean exhaustiveSolve(Puzzle puzzle, String lettersToAssign) {
        if (lettersToAssign.isEmpty()) { // No more choices to make
            return puzzleSolved(puzzle); // Checks arithmetic to see if it works
        }

        for (int digit = 0; digit <= 9; digit++) { // Try all digits
            if (assignLetterToDigit(lettersToAssign.charAt(0), digit)) {
                if (exhaustiveSolve(puzzle, lettersToAssign.substring(1))) {
                    return true;
                }
                unassignLetterFromDigit(lettersToAssign.charAt(0), digit);
            }
        }

        return false; // Nothing worked, need to backtrack
    }

    // Assigns a digit to a letter if it's not already used by another letter
    private static boolean assignLetterToDigit(char letter, int digit) {
        if (letterToDigit.containsValue(digit)) {
            return false; // Digit already used
        }
        letterToDigit.put(letter, digit);
        return true;
    }

    // Unassigns a digit from a letter
    private static void unassignLetterFromDigit(char letter, int digit) {
        letterToDigit.remove(letter);
    }

    // Check if the current letter-to-digit assignment solves the puzzle
    private static boolean puzzleSolved(Puzzle puzzle) {
        int addend1Value = getWordValue(puzzle.addend1);
        int addend2Value = getWordValue(puzzle.addend2);
        int sumValue = getWordValue(puzzle.sum);

        return addend1Value + addend2Value == sumValue;
    }

    // Helper function to get the numeric value of a word
    private static int getWordValue(String word) {
        int value = 0;
        for (char ch : word.toCharArray()) {
            value = value * 10 + letterToDigit.get(ch);
        }
        return value;
    }

    // Puzzle class to encapsulate the puzzle strings
    static class Puzzle {
        String addend1;
        String addend2;
        String sum;

        public Puzzle(String addend1, String addend2, String sum) {
            this.addend1 = addend1;
            this.addend2 = addend2;
            this.sum = sum;
        }
    }
}
