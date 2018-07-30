package leetcode_170_200;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                List<Integer> list = new LinkedList<>();
                list.add(i);
                map.put(nums[i], list);
            } else {
                List<Integer> list = map.get(nums[i]);
                list.add(i);
                map.put(nums[i], list);
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            for (int i = 0; i < list.size() - 1; i++) {
                if (Math.abs(list.get(i) - list.get(i + 1)) <= k) {
                    return true;
                }
            }
        }

        return false;
    }
}
