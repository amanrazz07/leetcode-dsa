public class BinarySearch {
    public static void main(String[] args) {
        int[]arr={10,22,34,42,67,89,10};
        int target=879;
        System.out.println(search(arr,target,0 ,  arr.length-1));
    }
    static int search(int[]arr,int target,int s,int e){
        if(s>e){
            return -1;
        }
        int m=s+(e-s)/2;
        if(target==arr[m]){
            return m;
        }
        if(target<arr[m]){
            return search(arr,target,s,m-1);
        }
        return search(arr,target,m+1,e);
    }
}
