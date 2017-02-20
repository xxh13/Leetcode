package algorithm;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * to be optimized
 * num : 179
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * Created by XXH on 2016/8/20.
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        String result = "";

        String[] String_nums = new String[nums.length];
        for(int i=0 ;i <String_nums.length;i++){
            String_nums[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(String_nums, (o1, o2)->{
            return new BigInteger(o2+o1).compareTo(new BigInteger(o1+o2));
        });

        for(String num : String_nums){
            result = result + num;
        }

        while(result.startsWith("0") && result.length()>1){
            result = result.substring(1);
        }

        return result;
    }
}
