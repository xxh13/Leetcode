package leetcode_01_20;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 455. Assign Cookies
 * Created by XXH on 2017/1/7.
 */
public class _455 {

    public static void main(String[] args) {
        _455 demo = new _455();
        int[] g = {1,2};
        int[] s = {1,2,3};
        int count = demo.findContentChildren(g, s);
        System.out.println(count);
    }


    public int findContentChildren(int[] g, int[] s) {
        List<Integer> s_list = IntStream.of(s).boxed().collect(Collectors.toList());
        Collections.sort(s_list);

        int count = 0;

        for (int element : g) {
            int index = findMinIndex(element, s_list);
            if ( index != -1 ) {
                count ++;
                s_list.remove(index);
            }
        }

        return count;
    }

    private int findMinIndex(int value, List<Integer> list) {
        int i = 0;
        for (; i < list.size(); i++) {
            if (value <= list.get(i)) break;
        }

        return i == list.size() ? -1 : i;
    }
}
