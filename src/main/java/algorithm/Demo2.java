package algorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * java 练习2 背包问题
 * Created by XXH on 2016/4/21.
 */
public class Demo2 {

    public static void main(String[] args){
//        System.out.println(isChineseCharacter('许'));

        List<String> data = new ArrayList<>();
//        String s = "";
        data.add("A");
        data.add("B");
        data.add("C");
        data.add("D");
        data.add("E");
//        getPermutation(data, s);

//        data.stream().forEach(System.out::println);
        /*for (int i = 0; i < data.size(); i++) {
            String s = "";
            getCombination(data, s, i+1);
        }*/
//        testSwitch("DD");
        testDynamicArgs("1", "2");
        int billion = 1_000_000_000;
    }

    /*
    * 判断是不是中文字符
    * */
    public static boolean isChineseCharacter(char c){
        return c>='\u4E00' && c<='\u9FBF';
    }


    /*
    * 输出全排列
    */
    public static void getPermutation(List<String> data, String currentString){
        if (data.size() == 0) return;

        if (1== data.size()){
            System.out.println(currentString +data.get(0));
        }
        else {
            for (int i = 0; i < data.size(); i++) {
                List<String> tempList = new ArrayList<>(data);
                getPermutation(tempList, currentString +tempList.remove(i));
            }
        }
    }

    /*
    * 输入所有组合的情况
    * */

    public static void getCombination(List<String> data, String result,int k){
        if (data.size() == 0) return;

        if (k==1){
            data.stream().forEach(e->System.out.println(result+e));
        }else{
            for (int i = 0; i < data.size(); i++) {
                getCombination(data.subList(i+1, data.size()),result+data.get(i), k-1);
            }
        }
    }

    public static void testSwitch(String test){
        switch (test){
            case "MONDAY" :
                System.out.println("MONDAY");
                break;
            case "TUESDAY":
                System.out.println("TUESDAY");
                break;
            case "WEDNESDAY":
                System.out.println("WEDNESDAY");
                break;
            case "THURSDAY":
                System.out.println("THURSDAY");
                break;
            default:
                System.out.println("OTHER");
        }
    }

    public static void testDynamicArgs(String ... args){
        for (String arg : args){
            System.out.println(arg);
        }
    }

    public static void testTry(){
        try(FileInputStream fin = new FileInputStream("info.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fin))
        ){

        }catch (FileNotFoundException ex){

        }catch (IOException ex){

        }

    }
}
