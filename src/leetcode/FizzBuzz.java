package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public static void main(String[] args) {
        ArrayList<String>List = new ArrayList<>();
        int n = 15;

        for (int i = 1; i <=n ; i++) {
            if (i % 3 == 0 && i % 5 == 0){
                List.add("FizzBuzz");
            }else if (i % 3 == 0){
                List.add("Fizz");
            }else if (i % 5 == 0){
                List.add("Buzz");
            }else
                List.add(String.valueOf(i));
        }

        System.out.println(List);
    }
}
