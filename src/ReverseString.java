public class ReverseString{
    public static void main(String[] args) {
        String s="Aman Kumar";
        print(0,s);
    }
    public static void print(int i,String s){
        if(i==s.length()) return;

        print(i+1,s);
        System.out.print(s.charAt(i));
    }
}
