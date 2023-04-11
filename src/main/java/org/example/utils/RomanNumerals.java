package org.example.utils;

public class RomanNumerals {
    public String arabicToRoman(int numberArabic) {
        String romanNumber="";
        for(int x=0; x<numberArabic; x++){
            romanNumber +="I";
            System.out.println(romanNumber+ " *");
            romanNumber = romanNumber.replaceAll("IIII", "IV");
            romanNumber = romanNumber.replaceAll("IVI", "V");

            romanNumber = romanNumber.replaceAll("VIV", "IX");
            romanNumber = romanNumber.replaceAll("IXI", "X");

            romanNumber = romanNumber.replaceAll("XXXX", "XL");
            romanNumber = romanNumber.replaceAll("XLX", "L");

            romanNumber = romanNumber.replaceAll("LXL", "XC");
            romanNumber = romanNumber.replaceAll("XCX", "C");

            romanNumber = romanNumber.replaceAll("CCCC", "CD");
            romanNumber = romanNumber.replaceAll("CDC", "D");

            romanNumber = romanNumber.replaceAll("DCD", "CM");
            romanNumber = romanNumber.replaceAll("CMC", "M");
        }

        return romanNumber;
    }
}
