package com.company;

public class Conversion {
    public Boolean conversion(String input, String price) {

        char[] chars = input.toCharArray();
        Boolean charges =false;
        for (char c : chars) {
            if (Character.isDigit(c)) {
                charges = true;
            }
        }
        if (charges==false){
            System.out.println("Your final price is: " + price);
            return false;
        }
        else {
            System.out.println("BEWARE THERE ARE ADDITIONAL CHARGES!!! PLEASE CHECK BOOKING PAYMENT PAGE");
            return true;
        }

    }

}
