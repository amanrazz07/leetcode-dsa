package com.aman;

public class SumOfDigits {
    public static void main(String[] args) {
        int ans = add(21783);
        System.out.println(ans);
    }
    static int add(int n){
        if(n==0){
            return 0;
        }
        return add(n/10)+n%10;
    }
}
