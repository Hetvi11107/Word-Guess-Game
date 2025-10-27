import java.util.*;

p       while (guesses > 0) {
            System.out.println("\nWord: " + String.valueOf(displayWord));
            System.out.println("Remaining Guesses: " + guesses);
            System.out.print("Enter a letter: ");
            String input = scanner.nextLine().toLowerCase();

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("❌ Please enter a single valid letter.");
                continue;
            }

            char guess = input.charAt(0);

            if (guessedLetters.contains(guess)) {
                System.out.println("⚠️ You already guessed that letter.");
                continue;
            }

            guessedLetters.add(guess);
            boolean found = false;

            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == guess) {
                    displayWord[i] = guess;
                    found = true;
                }
            }

            if (found) {
                System.out.println("✅ Good guess!");
            } else {
                guesses--;
                System.out.println("❌ Wrong guess.");
            }

            if (String.valueOf(displayWord).equals(secretWord)) {
                System.out.println("\n🎉 You Win! The word was: " + secretWord);
                return;
            }
        }

        System.out.println("\n💀 Game Over! The word was: " + secretWord);
    }
}
ublic class WordGuessGame {

    private static final String[] WORDS = {
        "india", "unitedstates", "china", "russia", "unitedkingdom",
        "canada", "australia", "germany", "france", "japan"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String secretWord = WORDS[new Random().nextInt(WORDS.length)];
        char[] displayWord = new char[secretWord.length()];
        Arrays.fill(displayWord, '_');

        int guesses = 10;
        Set<Character> guessedLetters = new HashSet<>();

        System.out.println("🎮 Welcome to the Country Guessing Game!");

 