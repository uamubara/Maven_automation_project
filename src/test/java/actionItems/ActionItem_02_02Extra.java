package actionItems;

import java.util.Scanner;

public class ActionItem_02_02Extra {

    public static void main(String[] args) {

        // Declare numeric variable as grade
        int grade;

        // Declare string variable to read user input for do-while loop
        String answer;

        // Create a Scanner object for user input
        Scanner userInput = new Scanner(System.in);

        // do-while loop, to allow the user to input grade(s) for ease-of-use and testing conditional statements.
        do {
            // Prompt user to input a numerical grade
            System.out.println("Please enter a numerical grade: ");

            // Read user input and assign it to grade. (This allows changing grade without hard coding/code reusability)
            grade = userInput.nextInt();

            // Clear the buffer after reading the numerical grade
            userInput.nextLine();

            // Conditional Statements to check numerical grade entered by the user and assign letter grade
            if (grade >= 90 && grade <= 100) {
                // If the grade is between 90 and 100 (inclusive), assign 'A' grade
                System.out.println("Your Grade is: A");
            } else if (grade >= 80 && grade < 90) {
                // If the grade is between 80 and 89, assign 'B' grade
                System.out.println("Your Grade is: B");
            } else if (grade >= 70 && grade < 80) {
                // If the grade is between 70 and 79, assign 'C' grade
                System.out.println("Your Grade is: C");
            } else if (grade >= 60 && grade < 70) {
                // If the grade is between 60 and 69, assign 'D' grade
                System.out.println("Your Grade is: D");
            } else if (grade < 60) {
                // If the grade is below 60, assign 'F' grade
                System.out.println("Your Grade is: F");
            } else if (grade > 100) {
                // If the grade is above 100, display a special message.
                System.out.println("Your Grade is: " + grade + " A++");
            }

            // Prompt user to continue the loop (continue entering numerical grade(s))
            System.out.println("Do you wish to enter another Grade? Yes(Y) / No(N) ");

            // Read user input and assign it to userChoice.
            answer = userInput.nextLine();

            // while loop condition (continue loop if user enters any variation of "Y".
            // equalsIgnoreCase() -> ignores letter case and validates loop condition.
            // run loop while user input (answer == "Y" || "y")
            // any answer other than a variation of "y" will terminate the loop
        } while (answer.equalsIgnoreCase("y"));

        // Notify the user that they have exited the loop.
        System.out.println("Bye, Have a nice day! ");

        // Close the Scanner to prevent resource leak
        userInput.close();
    }
}
