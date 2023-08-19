import interfaces.Map;

import java.util.InputMismatchException;
import java.util.Scanner;
/**

 The User class represents a user of the map application. It contains information about the user such as name, age, speed,

 user type. It also includes methods to get user input for the starting location and the type of

 tourist attraction.
 */


public class User {
    private String name;
    private int age;
    private int speed;
    private UserType userType;

    private Map graph;

    public User(String name, int age, int speed, UserType userType) {
        this.name = name;
        this.age = age;
//        this.startLocation = startLocation;
        this.speed = speed;
        this.userType = userType;
    }

    public static int getStartLocation() {
        Scanner scanner = new Scanner(System.in);
        int startLocation = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter a start location: ");
                startLocation = scanner.nextInt();
                if (startLocation >= 1 && startLocation <= Config.verticesAmount) {
                    validInput = true;
                } else {
                    System.out.println("Please enter a value between 1 and " + Config.verticesAmount);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer value.");             //exception
                scanner.next(); // consume invalid input
            }
        }
        return startLocation;
    }


 public static User createUser() {           // Factory Method
     UserType userType;
     Scanner scanner = new Scanner(System.in);
    System.out.print("Do you have a bike? (y/   n): ");
    String answer = scanner.next();
    if (answer.equalsIgnoreCase("y")) {
        userType = UserType.CYCLIST;
        return new UserCyclist("John", 25,  20, userType);
    } else {
        userType = UserType.WALKER;
        return new UserWalker("John", 25,  5, userType);
    }
}
    public int getSpeed() {
        return  speed;
    }


    public static String pickVertexType(String[] vertexTypes) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select one of the following type of tourist attraction, you are interested in:");
        for (int i = 0; i < vertexTypes.length; i++) {
            System.out.println((i+1) + ". " + vertexTypes[i]);
        }
        int choice = scanner.nextInt();
        while (choice < 1 || choice > vertexTypes.length) {
            System.out.println("Invalid choice. Please select again:");
            choice = scanner.nextInt();
        }
        return vertexTypes[choice-1];
    }
}
