package leetcode_40_60;

/**
 * to be optimized
 * num : 43
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Created by XXH on 2016/8/20.
 */
public class _43 {

    public static void main(String[] args) {
        long time1 = System.nanoTime() / 1000000;
        System.out.println(multiply("123456789", "987654321"));
        System.out.println(122111 * 999);
        long time2 = System.nanoTime() / 1000000;
        System.out.println(time2 - time1);
    }

    public static String multiply(String num1, String num2){
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        String result = "0";
        int i=num1.length()-1;
        while(i>=0){
            String temp_result = "0";
            for(int j = 0; j<num1.charAt(i)-'0' ;j++){
                temp_result = add(temp_result, num2);
            }
            temp_result = appendZero(temp_result, num1.length()-1-i);
            result = add(result, temp_result);
            i--;
        }

        return result;
    }

    private static String appendZero(String s, int num){
        char result[] = new char[s.length() + num];

        System.arraycopy(s.toCharArray(), 0, result, 0, s.length());
        for(int i = s.length(); i < s.length() + num; i++){
            result[i] = '0';
        }

        return String.valueOf(result);
    }

    private static String add(String num1, String num2){

        int i = num1.length() - 1, j=num2.length() - 1;
        int len = i < j ? (j + 2 ) : (i + 2);
        int carry = 0, temp = 0;

        char array1[] = num1.toCharArray();
        char array2[] = num2.toCharArray();
        char result[] = new char[len];

        while(i>=0 && j>=0){
            temp = array1[i] - '0' + array2[j] - '0' + carry;
            result[--len] = (char) (temp % 10 + '0');
            carry = temp / 10;
            i--;
            j--;
        }

        if (i > j) {
            while (i >= 0) {
                temp = array1[i--] - '0' + carry;
                result[--len] = (char) (temp % 10 + '0');
                carry = temp / 10;
            }
        } else {
            while (j >= 0) {
                temp = array2[j--] - '0' + carry;
                result [--len] = (char) (temp % 10 + '0');
                carry = temp / 10;
            }
        }


        result[0] = (char) (carry + '0');

        if (result[0] == '0') {
            char resultReturn[] = new char[result.length - 1];
            System.arraycopy(result, 1, resultReturn, 0, resultReturn.length);
            return String.valueOf(resultReturn);
        }

        return String.valueOf(result);
    }
}
