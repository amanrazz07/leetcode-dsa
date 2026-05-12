public class RemovalOfRecursion {
    static void print(int n) {
        for (n = 0; n <=5; n++) {
            System.out.println(n);  // Print n inside the loop
        }
    }

    public static void main(String[] args) {
        print(5);
    }
}
