package com.aman;

//nested
public class NestedRecursion {
    public static int nestedRec(int n) {
        if (n <= 1)
            return 1;
        return nestedRec(nestedRec(n - 1));
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Result: " + nestedRec(n));
    }
}
