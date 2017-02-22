package leetcode_01_20;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * Created by XXH on 2017/02/14.
 */
public class _17 {

    public static void main(String[] args) {
        _17 demo = new _17();
        List<String> result = demo.letterCombinations("");

        result.forEach(System.out::println);
    }

    public List<String> letterCombinations(String digits) {
        char[][] array = new char[digits.length()][];
        for (int i = 0; i < digits.length(); i++) {
            array[i] = getString(digits.charAt(i) - '0').toCharArray();
        }

        List<String> combinations = new LinkedList<>();

        if (array.length == 0)
            return combinations;

        StringBuilder sb = new StringBuilder();
        getCombinations(array, combinations, sb, digits.length());
        return combinations;
    }

    private void getCombinations(char[][] array, List<String> combinations, StringBuilder sb, int n) {
        if (n == 0) {
            combinations.add(sb.toString());
            return;
        }

        int index = array.length - n;
        for (int i = 0; i < array[index].length; i++) {
            sb.append(array[index][i]);
            getCombinations(array, combinations, sb, n - 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    private String getString(int i) {
        switch (i) {
            case 2: return "abc";
            case 3: return "def";
            case 4: return "ghi";
            case 5: return "jkl";
            case 6: return "mno";
            case 7: return "pqrs";
            case 8: return "tuv";
            case 9: return "wxyz";
            default: return "";
        }
    }
}
