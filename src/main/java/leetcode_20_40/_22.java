package leetcode_20_40;

import java.util.LinkedList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * Created by XXH on 2017/2/14.
 */
public class _22 {

    public static void main(String[] args) {
        _22 demo = new _22();
        List<String> list = demo.generateParenthesis(3);
        list.forEach(System.out::println);
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        generateParenthesis(result, sb, n, n);
        return result;
    }

    private void generateParenthesis(List<String> result,  StringBuilder sb, int left ,int right) {
        if (left == 0 && right == 0) {
            result.add(sb.toString());
        }

        //add a left parentheses
        if (left > 0) {
            sb.append('(');
            generateParenthesis(result, sb, left - 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }

        //add a right parentheses
        if (right > left) {
            sb.append(')');
            generateParenthesis(result, sb, left, right - 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
