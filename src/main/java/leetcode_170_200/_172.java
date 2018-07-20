package leetcode_170_200;

// Given an integer n, return the number of trailing zeroes in n!.
public class _172 {

    public static void main(String[] args) {
        _172 demo = new _172();
        System.out.println(demo.trailingZeroes(2147483647));
    }

    public int trailingZeroes(int n) {

        int result = 0;
        for(long i=5; n/i>0; i*=5){
            result += (n/i);
        }
        return result;
    }
}
