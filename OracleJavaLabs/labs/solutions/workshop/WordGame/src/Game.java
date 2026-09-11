// The word guessing game
public class Game {
    // Create an array of words to initialise the game.
    private static String[] words = {"apple","potato","peach"};
    // Reserve a string variable to hold a word that needs to be guessed.
    private String word;
    // Reserve a char array to reflect the game state.
    private char[] state;

    // Perform a new game initialisation
    public Game() {
        // Pick a random word from the words array.
        word = words[(int)(Math.random()*words.length)];
        // Set the game state to be char array to be same length as the selected word and fill it with * symbols.
        state = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            state[i] = '*';
        }
    }

    public static void main(String[] args) {
        // Check if there are parameters passed to the main method.
        // Use these string values as elements of the words array.
        if (args.length != 0) {
            try {
                prepareWords(args);
            } catch(Exception e) {
                System.err.println(e.getMessage());
                System.exit(0);
            }
            words = args;
        }
        // Create a new game.
        Game game = new Game();
        // Auto-solve the game.
//    game.solve();
        // prompt user to enter one character at a time
        System.out.println("Enter a character to start playing:");
        // Analyse the character supplied by the user.
        // Exit the game if it is an '!'.
        char c = 0;
        while (c != '!') {
            try {
                c = (char)System.in.read();
            }catch (Exception e){
                System.err.println(e.getMessage());
                continue;
            }
            // Check if the character that user typed is a good guess,
            // or an already guessed letter, or a bad guess
            // and assign the response text based on the guess outcome.
            int result = game.guess(c);
            String response = (result > 0) ? "You have made a good guess: " :
                    (result < 0) ? "You have made a bad guess: " : "Character was already guessed: ";
            // Pint the guess status plus the character plus the current state of the game.
            System.out.println(response+c+" "+game);
            // Check if the complete word was guessed.
            if (game.word.equals(String.valueOf(game.state))) {
                // Congratulate the use and exit the game.
                System.out.println("Congratulations, you have guessed the word!");
                break;
            }
        }
        // print a game over message
        System.out.println("Game over, goodbye!");
    }

    // convert game object to string by presenting the game state array as a string
    public String toString() {
        return String.valueOf(state);
    }

    // Process a guess:
    // Accept a char value of the letter as an argument
    // Return a number of times the letter occurs in the word
    // Return -1 if the letter was already guessed
    // Return 0 if the letter does not exist within a word
    public int guess(char letter) {
        // Check if the character has been already guessed.
        // If that is the case, return 0.
        if (this.toString().indexOf(letter) != -1) {
            return 0;
        }
        int letterCount = 0;
        int index = 0;
        // Check if the letter occurs within thw word and find its position.
        // If the letter is found in the word, reveal its position by updating the game state.
        // Just in case, convert the letter to lower case before trying to match it within a word.
        // This check must be repeated, because the letter may occur in the word several times.
        // Use the previous letter position plus one as a start search position for the next letter position.
        // Count how many times a letter occurred with a word
        while ((index = word.indexOf(Character.toLowerCase(letter), index)) != -1) {
            state[index] = word.charAt(index);
            index++;
            letterCount++;
        }
        return (letterCount == 0) ? -1 : letterCount;
    }

    // Solve the word game:
    // Start at letter 'a' and continue to iterate through letters
    // until you either get to letter 'z' or you have solved the game.
    // Match each letter within the word.
    // Print the game status after every match attempt.
    public void solve() {
        char c = 'a';
        while (!word.equals(String.valueOf(state))) {
            System.out.print(c+" ");
            System.out.println(guess(c++)+" "+this);
            if( c == 'z') {
                break;
            }
        }
    }

    // Prepare words that can be used as an alternative list of words for players to guess.
    public static void prepareWords(String[] words) throws Exception {
        for (int i = 0;  i < words.length; i++) {
            String word = words[i].toLowerCase();
            validateWord(word);
            words[i] = word;
        }
    }
    // Validate the word by checking that all character are actual letters within the a to z range.
    public static void validateWord(String word) throws Exception {
        for(char c: word.toCharArray()) {
            if (c < 'a' || c > 'z') {
                throw new Exception("The word " + word + " must only use alphabet characters");
            }
// Alternatively, this method could have validated that character is a letter in any writing system
//      if (!Character.isLetter(c)) {
//        throw new Exception("The word must only use alphabet characters");
//      }
        }
    }
}