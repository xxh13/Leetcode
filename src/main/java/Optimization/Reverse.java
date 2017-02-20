package Optimization;

/**
 * Created by XXH on 2016/8/20.
 */
public class Reverse {
    public String reverseString(String s) {

        int length = s.length();
        char[] array = s.toCharArray();
        char[] result = new char[length];

        for (int i = length - 1; i>=0; i--)
            result[i] = array[length - 1 - i];
        return String.valueOf(result);
    }
}
