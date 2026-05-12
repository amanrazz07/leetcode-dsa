package com.aman;

public class TOH {
    public static void main(String[] args) {
        int n=3;
        search(3,'A','C','B');
    }
    static void search(int n,char source,char destination,char auxiliary){
        if(n==1){
            System.out.println("disc 1 move from "+source+"to"+destination);
            return;
        }
       search(n-1,source,auxiliary,destination);
       System.out.println("disc"+n+"move from"+source+"to"+destination);
       search(n-1,auxiliary,destination,source);
    }
}
