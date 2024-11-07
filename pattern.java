import java.util.Scanner;

public class pattern {
    public static void main(String args[]){
        int r = 5; // Number of rows
        for(int i = 1; i <= r; i++) {
            // Print spaces
            for (int j = 1; j <= r - i; j++) {
                System.out.print(" ");
            }
            // Print stars
            for(int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            // Move to the next line
            System.out.println();
        }
    }
}

