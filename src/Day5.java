import java.util.Scanner;
import java.io.File;

public class Day5 {

    public static void main(String[] args) throws Exception{
        File file = new File("input\\InputDay5.txt");
        Scanner input = new Scanner(file);

        char[][] letter = {
                {'D', 'M', 'S', 'Z', 'R', 'F'},
                {'W', 'P', 'Q', 'G', 'S'},
                {'W', 'R', 'V', 'Q', 'F', 'N'},
                {'T', 'P', 'S'},
                {'H', 'D', 'F', 'W', 'R', 'L'},
                {'Z', 'N', 'D', 'C'},
                {'W', 'N', 'R', 'F', 'V', 'S'},
                {'R', 'M', 'S', 'G', 'Z', 'W'},

        };

        
//        for (char[] tab: letter) {
//            for (char s: tab) {
//                System.out.print(s + "\t");
//            }
//            System.out.println("\n");
//        }

        String nextLine;

        for(int i = 0; i < 10; i++){
            input.nextLine();
        }

        while(input.hasNextLine()){

            nextLine = input.nextLine();
            System.out.println(nextLine);
        }



    }
}
