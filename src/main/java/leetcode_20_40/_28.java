package leetcode_20_40;

/**
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack
 * Created by XXH on 2017/2/18.
 */
public class _28 {

    public static void main(String[] args) {
        _28 demo = new _28();
        System.out.println(demo.strStr("abcd", "abcde"));
    }

    public int strStr(String haystack, String needle) {
        char[] hayStackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();

        if (hayStackArray.length < needleArray.length) return -1;

        int i = 0, j, index;
        while (i < hayStackArray.length - needleArray.length + 1) {
            index = i;
            j = 0;
            while (j < needleArray.length && hayStackArray[index] == needleArray[j]) {
                index++;
                j++;
            }
            if (j == needleArray.length) return i;
            i++;
        }

        return -1;
    }
}
