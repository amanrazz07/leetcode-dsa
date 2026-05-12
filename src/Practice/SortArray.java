package Practice;
import java.util.*;

public class SortArray {
    public static void main(String[]args){
        int[]arr={3,1,4,2};
        sort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[]arr,int n){
        if(n<=1)return;

        int last=arr[n-1];
        sort(arr,n-1);
        insert(arr,n-1,last);
    }

    static void insert(int[]arr,int n,int val){
        if(n==0||arr[n-1]<=val){
            arr[n]=val;
            return;
        }

        int temp=arr[n-1];
        insert(arr,n-1,val);
        arr[n]=temp;
    }
}