package actionItems;

import java.util.ArrayList;

public class ActionItem_02_1 {
    public static void main(String[] args) {

        //Declare Array list for String region
        ArrayList <String> region = new ArrayList<>();
        // Populate Array with 4 String Values
        region.add("New York, NY");
        region.add("Los Angeles, CA");
        region.add("Houston, TX");
        region.add("Miami, FL");

        //Declare Array list for Integer areaCode
        ArrayList <Integer> areaCode = new ArrayList<>();
        //Populate Array with 4 values
        areaCode.add(212);
        areaCode.add(213);
        areaCode.add(281);
        areaCode.add(305);

        //Iterate through each ArrayList and print values. Set number of iterations to the size of ArrayList.
        for (int i = 0; i < region.size(); i++){
            //print values of both ArrayList ( region & areaCode). concatenate to print values of both ArrayList on one line.
            System.out.println("My region is " + region.get(i) + " and my area code is " + areaCode.get(i) + ".");

        }




    }
}
