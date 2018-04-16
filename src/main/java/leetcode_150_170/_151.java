package leetcode_150_170;

import java.util.ArrayList;
import java.util.List;

public class _151 {


    public static void main(String[] args) {
        _151 demo = new _151();

        String line = "I am a student  ,  ad sdas   sd asd  a    ";
        demo.reverseWords(line);
    }

    public String reverseWords(String s) {
        List<String> list = new ArrayList<>();
        char[] s1 = s.trim().toCharArray();

        StringBuilder sb = new StringBuilder();
        boolean whiteSpace = true;
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != ' ') {
                sb.append(s1[i]);
                whiteSpace = false;
            }
            if (!whiteSpace && s1[i] == ' ') {
                list.add(new String(sb));
                sb = new StringBuilder();
                whiteSpace = true;
            }
        }

        list.add(new String(sb));
        sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
            if (i != 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
