import java.util.Objects;
import java.util.Scanner;
import java.io.File;
public class Day3 {
    
    public static void main(String[] args) throws Exception {

        //Read the file and retrieve the data, we do it twice for both parties.
        File file = new File("input\\InputDay3.txt");
        Scanner input = new Scanner(file);
        Scanner input2 = new Scanner(file);

        //Initialize variables for part 1.
        int lineLength;
        int indexArray = 0;
        int scoreTotal = 0;
        String lineWord;
        String letter1;
        String letter2;
        String letterCorrect = "";

        //We initialize the array for the letters, its index is its value + 1.
        String[] priorities = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        //Start of the challenge [Part 1].
        while (input.hasNextLine()) {

            //We get the word of the line and the length.
            lineWord = input.nextLine();
            lineLength = lineWord.length();

            //We create two tables to store the two halves of the word. Its length is half the length of the word.
            String[] item1 = new String[lineLength / 2];
            String[] item2 = new String[lineLength / 2];

            //We break down the words into letters to be able to compare them more easily.
            for (int i = 0; i < lineLength; i++) {

                //We move the letters in the first one as long as the variable is smaller than half the length.
                if (i < (lineLength / 2)) {
                    item1[i] = lineWord.split("")[i];
                }

                //And when the variable is higher than half, we move the letters to the second table.
                else if (i >= (lineLength / 2)) {
                    item2[indexArray] = lineWord.split("")[i];
                    indexArray++;
                }
            }

            //We reinitialize the variable for the next words.
            indexArray = 0;

            //We go through the two tables, and we recover two letters.
            for (String value1 : item1) {
                letter1 = value1;
                for (String value2 : item2) {
                    letter2 = value2;

                    //If the two letters are identical, then the same letter has been recovered.
                    if (Objects.equals(letter1, letter2)) {
                        letterCorrect = letter1;
                    }
                }
            }

            //We browse the table of letters to retrieve the index and therefore its value.
            for (int i = 0; i < priorities.length; i++) {
                if (Objects.equals(letterCorrect, priorities[i])) {
                    scoreTotal += i + 1;
                }
            }
        }

        //Finally, we display the result.
        System.out.println("Result of the first part :");
        System.out.println("The sum of the priorities of those item is " + scoreTotal + "\n");


        //Initialize variables for part 2.
        String lineBagPart2;
        char letterOne;
        char letterTwo;
        char letterThree;
        char letterCorrect2 = 0;
        int scoreTotal2= 0;

        //Start of the challenge [Part 2].
        while (input2.hasNextLine()) {

            //The three words are broken down into letters as in the first part.
            //The first word.
            lineBagPart2 = input2.nextLine();
            char[] list1 = lineBagPart2.toCharArray();

            //The second word.
            lineBagPart2 = input2.nextLine();
            char[] list2 = lineBagPart2.toCharArray();

            //The third word.
            lineBagPart2 = input2.nextLine();
            char[] list3 = lineBagPart2.toCharArray();

            //We go through the three tables, and we recover three letters.
            for (char value1 : list1) {
                letterOne = value1;
                for (char value2 : list2) {
                    letterTwo = value2;
                    for (char value3 : list3) {
                        letterThree = value3;

                        //If the three letters are identical, then the same letter has been recovered.
                        if (letterOne == letterTwo && letterTwo == letterThree) {
                            letterCorrect2 = value1;
                        }
                    }
                }
            }

            //We convert the variable to browse the table of letters as in the first part.
            String letter = String.valueOf(letterCorrect2);

            //We browse the table of letters to retrieve the index and therefore its value.
            for (int i = 0; i < priorities.length; i++) {
                if (Objects.equals(letter, priorities[i])) {
                    scoreTotal2 += i + 1;
                }
            }
        }

        //Finally, we display the result.
        System.out.println("Result of the second part :");
        System.out.println("The sum of the priorities of those item types is " + scoreTotal2);
    }
}
