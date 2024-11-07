import java.util.Scanner;
public class conditiional {
    public static void main(String args[]){
        int age;
        Scanner sc=new Scanner(System.in);
        age=sc.nextInt();
        if(age>18){
            System.out.println("Eligible to vote");
        }
        if(age>50){
            System.out.println("Eligible to pention");
        }
        else{
            System.out.println("failed");
        }
    }
}

