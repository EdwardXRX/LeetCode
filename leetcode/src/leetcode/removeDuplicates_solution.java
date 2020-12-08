package leetcode;

public class removeDuplicates_solution {
    public static void main(String[] args) {

    }

    public static  int removeDuplicates(int[] nums) {

        if(nums == null )
        {
            return 0;
        }
        else if(nums.length == 1)
            return 1;

        int len = 1;


        for (int i = 0; i < nums.length-1; i++) {

            if(nums[i] == nums[i+1])
                continue;

            else
            {
                nums[len] = nums[i+1];
                len++;
            }
        }

        return len;






    }
}
