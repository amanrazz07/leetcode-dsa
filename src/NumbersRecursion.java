public class NumbersRecursion {
    public static void main(String[] args) {
        print(1);
    }
    static void print(int n){
        if(n==5){
            System.out.println(5);
            return;
        }
        System.out.println(n);
        //this is tail recursion ...bcoz it's the last function called in this code
        print(n+1);
    }
}
