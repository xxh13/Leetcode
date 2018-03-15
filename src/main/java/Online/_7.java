package Online;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _7 {

    public static void main(String[] args) {
        _7 demo = new _7();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String seq = scanner.nextLine();
            demo.solve(seq);
        }
    }

    private static void test() {
        String parentheses = "())(()";
        _7 demo = new _7();
        demo.solve(parentheses);
    }

    // test if a string is valid parentheses
    private boolean test(String s) {
        char[] array = s.toCharArray();
        int count = 0;
        for (char c : array) {
            count = c == '(' ? count + 1 : count - 1;
            if (count < 0 ) return false;

        }
        return count == 0;
    }

    private void solve(String s) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            StringBuilder temp = new StringBuilder(s.substring(0, i) + s.substring(i + 1));
            for (int j = 1; j < s.length(); j++) {
                temp.insert(j, c);
                if (!temp.toString().equals(s)) {
                    if (test(temp.toString()))
                        set.add(temp.toString());
                }
                temp.deleteCharAt(j);
            }
        }
        System.out.println(set.size());
    }
}
