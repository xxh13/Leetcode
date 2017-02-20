package sample;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {

    public static int doubleIt(int number){
        try{Thread.sleep(1000);}catch (Exception e){}
        return number * 2;
    }

    public static boolean isEven(int number){
        return number%2==0;
    }

    public static int totalValues(List<Integer> numbers, Predicate<Integer> selector){
        return numbers.stream().filter(selector).reduce(0, (x,y)->x+y);
    }

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Predicate<Integer> isGreaterThan3 = e -> e >3;

        Function<Integer, Predicate<Integer> > isGreaterThan = privot ->
                number -> number > privot;

        final Stream<Integer> temp = values.stream()
                .filter(isGreaterThan.apply(4))
                .filter(Main::isEven)
                .map(e -> e*2);


        System.out.println(values.parallelStream()
                            .mapToInt(Main::doubleIt)
                            .sum());
    }
}
