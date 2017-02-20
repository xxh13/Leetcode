package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * java联系一
 * Created by XXH on 2016/4/17.
 */
public class Demo1 {

    /*
    * 去除数组中相同的元素
    * */
    public static void main(String[] args){
        int[] a= {1,2,2,3,4,4,5,5};
        int[] b = {1,2,3,5,6};
        int[] c = {1,2,5,6};
        List result = getSameItem(a,b,c);
        result.stream().forEach(e->System.out.print(e + " "));
        System.out.println();

    }
    public static int[] removeElement(int[] a){
        int smallIndex = 0;
        int bigIndex = 1;
        while (bigIndex < a.length){
            if( a[smallIndex] == a[bigIndex]){
                bigIndex++;
            }else {
                a[++smallIndex] = a[bigIndex++];
            }
        }
        int result[]=new int[smallIndex+1];
        System.arraycopy(a, 0, result, 0, result.length);
        return result;
    }


    /*
    * 反转字符串
    * */
    public static String reverse(String s){
        if (s.isEmpty() || s.length() == 1){
            return s;
        }

        return reverse(s.substring(1)) + s.charAt(0);
    }

    /*
    * 判断是否是回文
    * */
    public static boolean isParadox(String s){
        if(s.length() == 1 || s.length()==0) return true;
        return s.charAt(0)==s.charAt(s.length()-1) && isParadox(s.substring(1,s.length()-1));
    }

    /*
    * 找出2个有序数组的共同元素
    *
    * */

    public static List<Integer> getSameItem(int a[], int b[]){
        List<Integer> result = new ArrayList<>();
        int i=0,j=0;
        while (i < a.length && j <b.length){
            if(a[i] < b[j]) {i++;}
            else if(a[i] > b[j]) {j++;}
            else {
                result.add((Integer) a[i++]);
                j++;
            }
        }
        return result;
    }

    /*
    * find the same item in 3 ordered array
    * */
    public static List<Integer> getSameItem(int a[], int b[], int c[]){
        List<Integer> result = new ArrayList<>();
        int i=0,j=0,k=0;
        while(i<a.length && j<b.length && k<c.length){
            if(a[i] == b[j] && b[j] == c[k]){
                result.add((Integer) a[i]);
               i++;
               j++;
               k++;
            }else{
                int max=getMax(a[i], b[j], c[k]);
                if(a[i] < max) i++;
                if(b[j] < max) j++;
                if(c[k] < max) j++;
            }
        }
        return result;
    }

    public static int getMax(int a, int b, int c){
        int max = a;
        if(b > max){
            max = b;
        }
        if (c > max){
            max = c;
        }
        return max;
    }

}
