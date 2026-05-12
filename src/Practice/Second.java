package Practice;

public class Second {
    public static void main(String[] args) {
        solve(5);
    }
    private static void solve(int n){
        if(n==0) return;
        System.out.print(n+" ");
        solve(n-1);
    }
}
