package leetcode_150_170;


import java.util.stream.IntStream;

public class _167{


    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        int[] nums = {1, 2, 3, 4 ,5 ,6};
        _167 runner = new _167();
        IntStream.of(runner.twoSum(nums, 8)).forEach(System.out::println);
    }


    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            result[0] = i + 1;
            int index = indexOf(numbers, target - numbers[i], i + 1, numbers.length - 1);
            if (index != -1) {
                result[1] = index + 1;
                return result;
            }
        }

        return result;
    }

    private int indexOf(int[] numbers, int target, int start, int end) {
        int left = start, right = end;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (numbers[mid] < target) {
                left = mid + 1;
            }
            else if (numbers[mid] > target) {
                right = mid - 1;
            }
            else {
                return mid;
            }
        }

        return -1;
    }
}
