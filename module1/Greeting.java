import java.util.Scanner; 
public class Greeting { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        System.out.print("What is your name? "); 
        String name = scanner.nextLine(); 
        System.out.print("What is your occupation? "); 
        String occupation = scanner.nextLine(); 
        System.out.print("How old are you? ");
        int age = scanner.nextInt();
        System.out.println("Hello, " + name + "! You are a " + occupation + " and you are " + age + " years old."); 
        scanner.close(); 
    } 
} 