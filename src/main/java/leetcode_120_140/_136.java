package leetcode_120_140;

public class _136 {

//    public int singleNumber(int[] nums) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (!map.keySet().contains(nums[i])) {
//                map.put(nums[i], 1);
//            } else {
//                map.put(nums[i], map.get(nums[i]) + 1);
//            }
//        }
//
//        for (Map.Entry entry : map.entrySet()) {
//            if ((Integer) entry.getValue() == 1) {
//                return (Integer) entry.getKey();
//            }
//        }
//        return -1;
//    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }

        return result;
    }
}
