import java.util.Scanner;
public class Main {
    public static void main(String args[]) {
        int mark;
        System.out.println("Enter the marks:");
        Scanner sc = new Scanner(System.in);
        mark = sc.nextInt();

        if (mark > 80 && mark > 50) {
            System.out.println("S grade");

        } else if (mark > 50 && mark > 80) {
            System.out.println("A grade");
        } else if (mark > 30 && mark <= 50) {

            System.out.println("C grade");
        } else {
            System.out.println("Failed");
        }
    }
}