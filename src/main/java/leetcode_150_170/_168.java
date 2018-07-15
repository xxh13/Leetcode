package leetcode_150_170;

public class _168 {

    public static void main(String[] args) {
        _168 runner = new _168();
        System.out.println(runner.convertToTitle(26 * 26 * 26 + 23));
    }

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        int i = n;
        int j = 0;
        while (i != 0) {
            char c;
            if (i % 26 == 0) {
                c = 'Z';
                j = 26;
            } else {
                c = (char) ('A' + i % 26 - 1) ;
                j = i % 26;
            }

            sb.insert(0, c);
            i = (i - j) / 26;
        }

        return sb.toString();
    }
}
