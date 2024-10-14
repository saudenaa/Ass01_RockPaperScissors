import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String playAgain;

        do {
            String playerA = getMove(input, "Player A");
            String playerB = getMove(input, "Player B");
            determineWinner(playerA, playerB);

            System.out.print("Play again? [Y/N]: ");
            playAgain = input.nextLine().trim().toUpperCase();
        } while (playAgain.equals("Y"));

        System.out.println("Thanks for playing!");
    }

    // Method to get a valid move from a player with feedback on invalid input
    private static String getMove(Scanner input, String player) {
        String move;
        do {
            System.out.print(player + " (Enter R for Rock, P for Paper, S for Scissors): ");
            move = input.nextLine().trim().toUpperCase();

            // Check for invalid input and notify the user
            if (!move.matches("[RPS]")) {
                System.out.println("Invalid input! Please enter R, P, or S.");
            }

        } while (!move.matches("[RPS]"));  // Loop until a valid move is entered

        return move;
    }

    // Method to determine the winner of the game
    private static void determineWinner(String playerA, String playerB) {
        if (playerA.equals(playerB)) {
            System.out.println("It's a tie: " + playerA + " vs " + playerB);
        } else if ((playerA.equals("R") && playerB.equals("S")) ||
                (playerA.equals("S") && playerB.equals("P")) ||
                (playerA.equals("P") && playerB.equals("R"))) {
            System.out.println(playerA + " beats " + playerB + ": Player A wins!");
        } else {
            System.out.println(playerB + " beats " + playerA + ": Player B wins!");
        }
    }
}
