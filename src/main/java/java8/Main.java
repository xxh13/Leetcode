package java8;

import java.nio.ByteBuffer;
import java.time.Clock;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
//import static java.util.function.IntUnaryOperator.identity;

/**
 *
 * Created by XXH on 2016/5/30.
 */
public class Main {

    public static void main(String[] args) {

        Object list[] = new Integer[2];
//        list[0] = new Main();
//        list[1] = 10;




//        int[] nums = {1,2,3,4};
//        Arrays.sort(nums,
//                (o1, o2) -> {return Integer.parseInt(String.valueOf(o1)+String.valueOf(o2))
//                        - Integer.parseInt(String.valueOf(o2)+String.valueOf(o1));}
//        );

        /*StringBuilder sb = new StringBuilder("Hello");


        List<String> strings = Arrays.asList("a", "b", "c");

        strings.forEach(s -> {sb.append("World");} );

        IntStream sequence = IntStream.rangeClosed(1,4)
                .flatMap(i -> IntStream.generate(() -> i).limit(i));

        sequence.forEach(System.out::println);*/

//        Optional<String> fullName = Optional.ofNullable( null );
//        System.out.println("full name is set ?" + fullName.isPresent() );
//
//        List< Optional<String> > optionalList = new ArrayList<>();
//        optionalList.add(Optional.of("tom"));
//        optionalList.add(Optional.ofNullable( null ));

        // Get the zoned date/time

        /*final Clock clock = Clock.systemUTC();

        final ZonedDateTime zonedDatetime = ZonedDateTime.now();

        final ZonedDateTime zonedDatetimeFromClock = ZonedDateTime.now( clock );

        final ZonedDateTime zonedDatetimeFromZone = ZonedDateTime.now( ZoneId.of( "America/Los_Angeles" ) );



        System.out.println( zonedDatetime );

        System.out.println( zonedDatetimeFromClock );

        System.out.println( zonedDatetimeFromZone );*/

//        Stream<String> names = Stream.of("Lam", "Okanbi", "Oduduwa");
//
//        Optional<String> tmp = names.filter(name -> name.startsWith("L")).findFirst();
//
//        tmp.ifPresent(
//                    System.out::println
//              );
//
//        intToByteArray(100, 1);
//
//        ByteBuffer byteBuffer = ByteBuffer.allocate(4);
//        byteBuffer.putInt(1000);
//        byte[] result = byteBuffer.array();
//
//        byteBuffer = ByteBuffer.wrap(result);

//        byteBuffer.flip();

//        int r = byteBuffer.getInt();

//        Map<Character, Integer> map = Stream.of("qweqewqcs".toCharArray())
//		        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

//	    char[] arr = "dasdewqeq".toCharArray();
//	    Map<Character, Long> map = IntStream.range(0, arr.length).mapToObj(i -> arr[i]).
//			    collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
//	    for (Map.Entry<Character, Long> entry : map.entrySet()) {
//		    System.out.println(entry.getKey() + " : " + entry.getValue());
//	    }

	    Map<String, String> dict = new ConcurrentHashMap<>(4);
	    dict.put("1", "1");
	    dict.put("2", "1");
	    dict.put("3", "1");
	    dict.put("4", "1");
	    dict.put("5", "1");
	    dict.put("6", "1");
	    dict.put("7", "1");
//        System.out.println(r);

	    System.out.println(Integer.numberOfLeadingZeros(10));


	    String hello = new String("Hello");
	    String lo = "lo";
	    System.out.println(hello.intern() == "Hello");
	    System.out.println(Other.hello == hello);
	    System.out.println(hello == ("Hel"+"lo"));
	    System.out.println(hello == ("Hel"+lo));
	    System.out.println(hello == ("Hel"+lo).intern());
    }

	private static class Other { static String hello = "Hello"; }
}
