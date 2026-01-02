import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Day_One {
    // Goes from 0 to 99
    public static void main(String[] args) throws FileNotFoundException {
        // Files stuff
        File file = new File("input.txt");
        Scanner infile = new Scanner(file);

        String code;
        int result = 50; //Starts at 50
        int counter = 0;
        while (infile.hasNext()){
            // Get the number
            code = infile.nextLine();
            System.out.println(code);
            // Split into letter and number
             char letter = code.charAt(0);
             int number = Integer.parseInt(code.substring(1));
             counter += number/100;
             System.out.println("I added " + number/100 + " " + number%100);
             number %= 100;
             if (result != 0 && (number < 99)){
                 if (letter == 'L'){
                     result -= number;
                     if (result < 0){
                         System.out.println("This result is gonna pass through 0 (+1)");
                         counter++;
                     }
                     result = boundaryCheck(result);
                     if (result == 0){
                         System.out.println("This resulted in 0 (+1)");
                         counter++;
                     }
                 }
                 else if (letter == 'R'){
                     result += number;
                     if (result > 100){
                         System.out.println("This result is gonna pass through 0 (+1)");
                         counter++;
                     }
                     result = boundaryCheck(result);
                     if (result == 0){
                         System.out.println("This resulted in 0 (+1)");
                         counter++;
                     }
                 }
             }
             else if (result == 0 && (number < 99)){
                 if (letter == 'L'){
                     int prevResult = result;
                     result -= number;
                     result = boundaryCheck(result);
                     if (result == 0 && (prevResult-number)%100!=0){
                         System.out.println("This resulted in 0 (+1)");
                         counter++;
                     }
                 }
                 else if (letter == 'R'){
                     int prevResult = result;
                     result += number;
                     result = boundaryCheck(result);
                     if (result == 0 && (prevResult+number)%100!=0){
                         System.out.println("This resulted in 0 (+1)");
                         counter++;
                     }
                 }
             }


        }
        System.out.println("The number is " + counter);
    }

    public static int boundaryCheck(int n){

        if (n > 99){
            n = n % 100;
            System.out.println("c" + n + "--- "  +"\n");
        }
        else if (n < 0){
            n %= 100;
            n += 100;
            System.out.println("c " + n +"--- "+  "\n");
        }
        return n;
    }

}
