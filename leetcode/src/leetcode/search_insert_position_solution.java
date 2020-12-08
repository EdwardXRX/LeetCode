package leetcode;

public class search_insert_position_solution {

    public static void main(String[] args) {


    }

    public static int searchInsert(int[] nums, int target) {
        if(nums.length == 0)
            return 0;

        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <= target)
            {
                temp = i;
                break;
            }
        }
        return temp;


    }
}
