package com.aman;
public class factorialll {
    public static void main(String[] args) {
        int n = 15;
        int result = 1;

        // Iteratively calculate the factorial
        for (int i = 1; i <= n; i++) {
            result =result* i;       // or result *=i
        }
        System.out.println("Factorial of " + n + " is " + result);
    }
}
