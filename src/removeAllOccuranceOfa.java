public class removeAllOccuranceOfa {
    public static void main(String[] args) {
        String s = "Aman Kumar";
        print(0, s);
    }

    public static void print(int i, String s) {
        if (i==s.length()) return;
        if(s.charAt(i)!='a') {
            System.out.print(s.charAt(i));
        }
        print(i+1,s);
    }
}
