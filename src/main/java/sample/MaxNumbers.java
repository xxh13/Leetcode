package sample;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 *  对于给定的一组数据，组合出他们的最大值
 * Created by XXH on 2016/4/6.
 */
public class MaxNumbers {
    public static void main(String args[]){
        int[] numbers = {2,20,23,24};
    }

    public int getMax(int[] numbers){
        String nums[] =new String[numbers.length];

        for(int i = 0; i< numbers.length ;i++){
            nums[i] = String.valueOf(numbers[i]);
        }


        Arrays.sort(nums, ((o1, o2) -> (o2+o1).compareTo(o1+o2)) );

        StringBuilder sb = new StringBuilder("");
        for (String num : nums){
            sb.append(num);
        }

        return Integer.valueOf(sb.toString());
    }

}
