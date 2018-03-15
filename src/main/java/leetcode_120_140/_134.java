package leetcode_120_140;

public class _134 {

    public static void main(String[] args) {

    }

    private void test() {

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length;) {
            if (gas[i] >= cost[i]) {
                int m = i;
                int remain = 0;
                for (; m <= i - 1 + gas.length; m++) {
                    remain += gas[m % gas.length] - cost[m % gas.length];
                    if (remain < 0) {
                        break;
                    }
                }
                if (remain >= 0) return i;
                i = m;
            } else {
                i ++;
            }
        }

        return -1;
    }

}
