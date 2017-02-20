package Online;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * Created by XXH on 2016/10/10.
 */
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        List<String> result = new ArrayList<>();

        while (sc.hasNext()) {
            list.add(sc.nextLine());
        }

        result.add(list.get(0));

        for (int i = 0; i < result.size() - 1; i++) {
            String pre[] = list.get(i).split(" ");
            for (int j = i + 1; j < list.size(); j ++) {
                String cur[] = list.get(j).split(" ");
                //价格相同， 日期相邻
                if (Integer.parseInt(pre[1]) + 1 == Integer.parseInt(cur[0])
                    || Integer.parseInt(pre[2]) == Integer.parseInt(cur[2]))
                {
                    String newInfo = pre[0] + " " + cur[1] + " " + pre[2];
                    result.remove(i);
                    result.add(i, newInfo);
                }

                //前面时间区间全包含后面的时间区间
                 if (Integer.parseInt(pre[0]) < Integer.parseInt(cur[0])
                         && Integer.parseInt(pre[1]) > Integer.parseInt(cur[1]))
                 {
                     result.remove(i);
                     String newInfo = pre[0] + " " + (Integer.parseInt(cur[0]) - 1) + " " + pre[2];
                     result.add(i, newInfo);
                     result.add(i + 1, list.get(j));
                     newInfo = (Integer.parseInt(cur[1]) + 1) + " " + pre[1] + " " + pre[2];
                     result.add(i + 2, newInfo);
                 }

                //
            }
        }
    }

    private static boolean isLetter(char c) {
        return (c >= 'a' && c <='z') || (c >= 'A' && c <= 'Z');
    }
}
