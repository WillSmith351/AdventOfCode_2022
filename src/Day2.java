import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Objects;
public class Day2 {

    public static void main(String[] args) throws Exception{

        File file = new File("input\\InputDay2.txt");
        Scanner input = new Scanner(file);

        int scoreTotal = 0;
        String lineGame;
        String lineOpponent = "";
        String lineYourself = "";

        int scorePart2 = 0;

        while(input.hasNextLine()) {
            lineGame = input.nextLine();
            String[] game = lineGame.split("\\s");
            for (String i : game) {
                if (Objects.equals(i, "A") || Objects.equals(i, "B") || Objects.equals(i, "C")) {
                    lineOpponent = i;
                } else if (Objects.equals(i, "X") || Objects.equals(i, "Y") || Objects.equals(i, "Z")) {
                    lineYourself = i;
                    switch (lineYourself) {
                        case "X" -> scoreTotal += 1;
                        case "Y" -> scoreTotal += 2;
                        case "Z" -> scoreTotal += 3;
                    }
                }
            }
            if (lineOpponent.equals("A") && lineYourself.equals("X")) {
                scoreTotal += 3;
                scorePart2 += 3;
            } else if (lineOpponent.equals("A") && lineYourself.equals("Y")) {
                scoreTotal += 6;
                scorePart2 += 4;
            } else if (lineOpponent.equals("B") && lineYourself.equals("Y")) {
                scoreTotal += 3;
                scorePart2 += 5;
            } else if (lineOpponent.equals("B") && lineYourself.equals("Z")) {
                scoreTotal += 6;
                scorePart2 += 9;
            } else if (lineOpponent.equals("C") && lineYourself.equals("X")) {
                scoreTotal += 6;
                scorePart2 += 2;
            } else if (lineOpponent.equals("C") && lineYourself.equals("Z")) {
                scoreTotal += 3;
                scorePart2 += 7;
            }
            else if (lineOpponent.equals("A") && lineYourself.equals("Z")) {
                scorePart2 += 8;
            }else if (lineOpponent.equals("B") && lineYourself.equals("X")) {
                scorePart2 += 1;
            }
            else if (lineOpponent.equals("C") && lineYourself.equals("Y")) {
                scorePart2 += 6;
            }

            Arrays.fill(game, null);
        }
        System.out.println("Your final score is " + scoreTotal);
        System.out.println("Your final score part 2 is " + scorePart2);

    }
}
