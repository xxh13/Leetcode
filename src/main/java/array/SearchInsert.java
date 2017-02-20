package array;

/**
 * num: 35
 * Given a sorted array and a target value, return the index if the target is found. If not,
 * return the index where it would be if it were inserted in order.
 * Created by XXH on 2016/8/20.
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        if(target <= nums[0]) return 0;

        int left=0, right = nums.length, mid = nums[right/2];
        while(right != left+1){
            if(mid >= target){
                right = (left + right) / 2;
            }else{
                left = (left + right) /2;
            }
            mid = nums[(right+left)/2];
        }

        return right;
    }
}
