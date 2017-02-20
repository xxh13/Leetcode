package algorithm;

import sample.Main;

/**
 * 求最大公约数
 * Created by XXH on 2016/5/16.
 */
public class GCD {

    public static void main(String[] args) {
        System.out.println(getGcd(getValue(1451515693,934244239,1271477516), getValue(1451515693,934244239,1199922842)));
    }

    public static long getValue(long a, long b, long pow) {
//        System.out.println((long) (Math.pow(a, pow) - Math.pow(b ,pow)));
        return (long) (Math.pow(a, pow) - Math.pow(b ,pow));
    }

    public static long getGcd(long a, long b) {
        if ( a == 0 ) return b;
        if ( b == 0 ) return a;
        if(a % 2 ==0 && b %2 == 0) return 2 * getGcd(a >> 1, b >> 1);
        else if (a % 2 == 0) return getGcd(a >> 1, b);
        else if (b % 2 == 0) return getGcd(a, b >> 1);
        else return getGcd(Math.abs(a-b), Math.min(a, b));
    }
}
