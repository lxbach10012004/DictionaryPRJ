import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Game {
    public static void play() {
        try {
            Scanner sc = new Scanner(System.in);
            BufferedReader reader = new BufferedReader(new FileReader("DictionaryPRJ/documents/game.txt"));
            ArrayList<String> lines = new ArrayList<>();
            String line = reader.readLine();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
            boolean loop = true;
            do {
                Random random = new Random();
                int randomIndex = random.nextInt(lines.size());
                String[] elements = lines.get(randomIndex).split(", ");
                System.out.println(elements[0]);
                System.out.println("[A] " + elements[1]);
                System.out.println("[B] " + elements[2]);
                System.out.println("[C] " + elements[3]);
                System.out.println("[D] " + elements[4]);
                System.out.print("Your answer: ");
                String ans = sc.nextLine();
                if (ans.equalsIgnoreCase(elements[5])) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect! The correct answer was " + elements[5]);
                }
                System.out.println("Play again? (Y/N)");
                if (sc.nextLine().equalsIgnoreCase("N")) {
                    loop = false;
                }
            } while (loop);

        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }

    }
}

