import java.io.File;
import java.util.Scanner;

public class Day4 {

    public static void main(String[] args) throws Exception{

        //Read the file and retrieve the data.
        File file = new File("input\\InputDay4.txt");
        Scanner input = new Scanner(file);

        //Initialize variables for part 1.
        int firstPairsOne;
        int firstPairsTwo;
        int secondPairsOne;
        int secondPairsTwo;
        int scoreTotal = 0;
        String linePairs;

        int scoreTotalPart2 = 0;
        int numberOfPairs = 0;

        //Start of the challenge.
        while(input.hasNextLine()){

            //We get the pair of the line.
            linePairs = input.nextLine();

            //we get the pair and assign it to an array by deleting the comma.
            String[] completePairs = linePairs.split(",");

            //The first index is the first pair and the second index is the second pair. We remove the dashes.
            String[] firstPairs = completePairs[0].split("-");
            String[] secondPairs = completePairs[1].split("-");

            //The lower and higher numbers of the two pairs are recovered.
            firstPairsOne = Integer.parseInt(firstPairs[0]);
            firstPairsTwo = Integer.parseInt(firstPairs[1]);
            secondPairsOne = Integer.parseInt(secondPairs[0]);
            secondPairsTwo = Integer.parseInt(secondPairs[1]);

            //And we compare if the second pair is included in the first pair. One point is added to the score if the condition is accepted.
            if(firstPairsOne <= secondPairsOne && firstPairsTwo >= secondPairsTwo){
                scoreTotal += 1;
            }

            //We compare if the first pair is included in the second pair.
            else if (firstPairsOne >= secondPairsOne && firstPairsTwo <= secondPairsTwo){
                scoreTotal += 1;
            }

            //If one of the numbers is larger than the other, then it means that they do not overlap.
            if ( firstPairsOne > secondPairsTwo || firstPairsTwo < secondPairsOne){
                scoreTotalPart2 +=1;
            }

            //We calculate the number of pairs to be able to subtract the number of overlapping pairs.
            numberOfPairs += 1;

        }
        //Then subtract the number of pairs with the number of non-overlapping pairs to get the total number of overlapping pairs
        scoreTotalPart2 = numberOfPairs - scoreTotalPart2;

        //Finally, we display the result.
        System.out.println("Result of the first part :");
        System.out.println("There are " + scoreTotal + " pairs where one pair is contained in the other.\n");
        System.out.println("Result of the second part :");
        System.out.println("The are " + scoreTotalPart2 + " overlapping pairs");
    }
}
