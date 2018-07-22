package leetcode_170_200;

import org.junit.Test;

public class _190 {

    @Test
    public void test() {
        assert reverseBits(7) == 3;
    }

    public int reverseBits(int n) {
        int t = n;
        int i = 0, count = 0;
        while (i < 32) {
            if((t & 1) != 0) {
                count++;
            }
            i++;
            t >>>= 1;
        }

        return count;
    }
}
