package leetcode_1_20;

/**
 *
 * Created by XXH on 2017/1/17.
 */
public class _14 {

    public static void main(String[] args) {
        _14 demo = new _14();

        String[] strs = {"", ""};
        System.out.println(demo.longestCommonPrefix(strs));
    }


    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        char c;
        boolean isValid = true;

        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        while (isValid) {
            if (index < strs[0].length()) {
                c = strs[0].charAt(index);
            }
            else {
                break;
            }
            for (int i = 1; i < strs.length && isValid; i++) {
                if (index >= strs[i].length()) {
                    isValid = false;
                } else {
                    if (c != strs[i].charAt(index)) {
                        isValid = false;
                    }
                }
            }
            if (isValid) sb.append(c);
            index++;
        }

        return sb.toString();
    }

}
