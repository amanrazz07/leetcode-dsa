import static com.aman.TailRecursion.print;

public class PrintAnArray {
    public static void main(String[] args) {
        int[] arr={10,20,30,40};
        print(0,arr);
    }

    private static void print(int i,int[] arr) {
        int n=arr.length;
        if(i==n) return;
        System.out.println(arr[i]);
        print(i+1,arr);
    }
}
