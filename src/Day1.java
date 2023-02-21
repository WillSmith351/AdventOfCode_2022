import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class Day1 {

    public static void main(String[] args) throws Exception {

        //Read the file and retrieve the data.
        File file = new File("Input\\InputDay1.txt");
        Scanner input = new Scanner(file);

        //Initialize variables for part 1.
        int calories;
        int totalCalories = 0;
        int highestCalories = 0;
        String lineCalories;

        //Initialize the array and the variable for part 2.
        int[] topThreeCalories = {0, 0, 0};
        int totalTopThreeCalories = 0;

        //Initialize the variables for the permutations to have the 3 highest numbers.
        int permutation;
        int permutation2;

        //Start of the challenge.
        while (input.hasNextLine()){

            //We get the number of the line.
            lineCalories = input.nextLine();

            //As long as there is a next number, we add it to the total variable.
            if (!Objects.equals(lineCalories, "")) {
                calories = Integer.parseInt(lineCalories);
                totalCalories += calories;
            }

            //When there is a space, it means that we have finished.
            else{

                //We compare the largest number for part 1.
                if(totalCalories >= highestCalories){
                    highestCalories = totalCalories;
                }

                //Start of part 2 :
                //If the number is higher than the first number, we shift the other two.
                if(totalCalories > topThreeCalories[0]){

                    //We store the numbers to be able to place them.
                    permutation = topThreeCalories[0];
                    permutation2 = topThreeCalories[1];

                    //And we can place the numbers at their position.
                    topThreeCalories[0] = totalCalories;
                    topThreeCalories[1] = permutation;
                    topThreeCalories[2] = permutation2;
                }

                //If the number is bigger than the second one, we have to exchange only one number. We repeat what we did before.
                else if(totalCalories > topThreeCalories[1]){
                    permutation = topThreeCalories[1];
                    topThreeCalories[1] = totalCalories;
                    topThreeCalories[2] = permutation;
                }

                //If the number is greater than the last number, we simply exchange it.
                else if(totalCalories > topThreeCalories[2]){
                    topThreeCalories[2] = totalCalories;
                }

                //We reset the number for the next elf.
                totalCalories = 0;
            }
        }

        //We sum the numbers of the table
        for (Integer topThree : topThreeCalories) {
            totalTopThreeCalories += topThree;
        }

        //Finally, we display the results.
        System.out.println("Result of the first part :");
        System.out.println("The elf who carries the most calories is carrying " + highestCalories + " calories.\n");
        System.out.println("Result of the second part :");
        System.out.println("The three elves who carry the most calories carry " + totalTopThreeCalories + " calories.");
    }
}