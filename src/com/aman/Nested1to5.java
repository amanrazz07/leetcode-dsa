package com.aman;

public class Nested1to5 {
    public static int nestedRecc(int n) {
        if (n > 5) {
            return n;
        }
        System.out.println(n );
        return nestedRecc(nestedRecc(n + 1));  // Nested recursive call
    }

    public static void main(String[] args) {
        nestedRecc(1);
    }
}
