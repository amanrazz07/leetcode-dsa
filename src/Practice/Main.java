package Practice;

// 1 to n print
public class Main {
    public static void main(String[] args) {
        int n=5;
        solve(n);
    }
    public static void solve(int n){
         if(n==0) return;
         solve(n-1);
        System.out.print(n+" ");
    }
}
