package Optimization;

/**
 * char 的运行效率远远高于substring
 * Created by XXH on 2016/8/20.
 */
public class Palindrome {
    public boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1)
            return true;

        char[] array = s.toCharArray();

        int left = 0; int right = array.length - 1;

        while (right - left >= 1) {
            if (!isValid(array[left])) left++;
            else if (!isValid(array[right])) right--;
            else{
                if (!isEqual(array[left++], array[right--])) return false;
            }
        }

        return true;
    }

    private boolean isValid(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c<='9');
    }

    private boolean isEqual(char a, char b) {
        return Character.toLowerCase(a) == Character.toLowerCase(b);
    }
}
