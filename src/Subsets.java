import java.util.*;

public class Subsets {

    public static void main(String[] args) {
        int[] nums={1,2,3};

        List<List<Integer>> ans=subsets(nums);

        System.out.println(ans);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();

        solve(0,nums,list,temp);
        return list;
    }

    public static void solve(int i,int[] nums,List<List<Integer>> list,List<Integer> temp){

        // base case: all elements processed
        if(i==nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }

        // include current element
        temp.add(nums[i]);
        solve(i+1,nums,list,temp);

        // backtrack
        temp.remove(temp.size()-1);

        // exclude current element
        solve(i+1,nums,list,temp);
    }
}