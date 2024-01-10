package Day3_11142023;

public class T4_ConditionWithLoop {
    public static void main(String[] args) {
        String[] fruitbasket = new String[]{"Grape", "Orange", "Apple", "Mango"};
        //Pick out only Apple from the Basket / Array
        //Start the for loop because we need to check everything in the basket / Array
        for (int i = 0; i < fruitbasket.length; i++) {
            // == (double equal sign) means its a comparison operator
            // = (single equal sign) assigns a value to  variable
            if (fruitbasket[i] == "Apple") {
                System.out.println("An Apple a day keeps the defects away");

            } // end of if clause
            else if (fruitbasket[i] == "Grape") {
                System.out.println("My Fruit is " + fruitbasket[i]);

            } // end of else if
        } // end of for loop
    } //end of main
} // end of class
