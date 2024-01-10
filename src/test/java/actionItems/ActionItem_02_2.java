package actionItems;

public class ActionItem_02_2 {
    public static void main(String[] args) {

        // Declare numeric variable as grade
        int grade = 94;

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
        }

    }
}
