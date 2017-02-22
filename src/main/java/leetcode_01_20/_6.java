package leetcode_01_20;

/**
 *
 * Created by XXH on 2017/1/11.
 */
public class _6 {

    public static void main(String[] args) {
        _6 demo = new _6();
        String s = "PAYPALISHIRING";
        System.out.println(demo.convert(s, 3));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        char[] charArray = s.toCharArray();
        int gap = (numRows - 1) * 2;
        StringBuilder stringBuilder = new StringBuilder("");

        int i = 0, j;
        int count;
        while (i < numRows) {
            count = 0;
            j = i;
            if (i == 0 || i == numRows - 1) {
                for (; j < charArray.length; j += gap) {
                    stringBuilder.append(charArray[j]);
                }
            }else {
                while (j < charArray.length) {
                    stringBuilder.append(charArray[j]);
                    if (count % 2 == 0){
                        j += (numRows - 1 - i) * 2;
                    } else {
                        j += (gap - (numRows - 1 - i) * 2);
                    }
                    count++;
                }
            }
            i++;
        }

        return stringBuilder.toString();
    }
}
