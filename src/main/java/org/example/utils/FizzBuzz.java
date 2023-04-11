package org.example.utils;

public class FizzBuzz {
    public String makeMessage(int opcion) {
        if(opcion % 5 == 0 && opcion % 3 == 0){
            return "FizzBuzz";
        }else if(opcion % 3 ==0 && opcion % 5 !=0){
            return "Fizz";
        } else if (opcion % 5 == 0 && opcion % 3 != 0) {
            return "Buzz";
        }
        return String.valueOf(opcion);
    }
}
