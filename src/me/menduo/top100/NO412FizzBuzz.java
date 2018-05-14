package me.menduo.top100;

import java.util.ArrayList;
import java.util.List;

public class NO412FizzBuzz {
    public List<String> fizzBuzz(int n) {
        if (n <= 0) return null;
        List<String> res = new ArrayList<>();
        for (int i = 1, fizz = 0, buzz = 0; i <= n; i++) {
            fizz++;
            buzz++;
            if (fizz == 3 && buzz == 5) {
                res.add("FizzBuzz");
                fizz = 0;
                buzz = 0;
            } else if (fizz == 3) {
                res.add("Fizz");
                fizz = 0;
            } else if (buzz == 5) {
                res.add("Buzz");
                buzz = 0;
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NO412FizzBuzz no412FizzBuzz = new NO412FizzBuzz();
        for (String x : no412FizzBuzz.fizzBuzz(15)) {
            System.out.println(x);
        }
    }
}
