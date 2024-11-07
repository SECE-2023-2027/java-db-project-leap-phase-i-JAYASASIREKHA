/*import java.util.Scanner;
public class Patenum {
    public static void main(String args[]) {
        int r = 5;
        for (int i = 1; i <= r; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            System.out.println();
        }
    }
}
 */
import java.util.Scanner;

public class Patenum {
    public static void main(String[] args) {
        int r = 5; // Number of rows

        for (int i = r; i >= 1; i--) {
            // Print leading spaces
            for (int j = 1; j <= r - i; j++) {
                System.out.print(" ");
            }

            // Print numbers in descending order from i down to 1
            for (int k = i; k >= 1; k--) {
                System.out.print(k + " ");
            }

            // Move to the next line
            System.out.println();
        }
    }
}



