package java8;

import java.nio.ByteBuffer;
import java.time.Clock;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
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

        Optional<String> fullName = Optional.ofNullable( null );
        System.out.println("full name is set ?" + fullName.isPresent() );

        List< Optional<String> > optionalList = new ArrayList<>();
        optionalList.add(Optional.of("tom"));
        optionalList.add(Optional.ofNullable( null ));

        // Get the zoned date/time

        /*final Clock clock = Clock.systemUTC();

        final ZonedDateTime zonedDatetime = ZonedDateTime.now();

        final ZonedDateTime zonedDatetimeFromClock = ZonedDateTime.now( clock );

        final ZonedDateTime zonedDatetimeFromZone = ZonedDateTime.now( ZoneId.of( "America/Los_Angeles" ) );



        System.out.println( zonedDatetime );

        System.out.println( zonedDatetimeFromClock );

        System.out.println( zonedDatetimeFromZone );*/

        Stream<String> names = Stream.of("Lam", "Okanbi", "Oduduwa");

        Optional<String> tmp = names.filter(name -> name.startsWith("L")).findFirst();

        tmp.ifPresent(
                    System.out::println
              );

        intToByteArray(100, 1);

        ByteBuffer byteBuffer = ByteBuffer.allocate(4);
        byteBuffer.putInt(1000);
        byte[] result = byteBuffer.array();

        byteBuffer = ByteBuffer.wrap(result);

        int r = byteBuffer.getInt();

        System.out.println(byteBuffer.getInt());

//        Callable
    }

    public static byte[] intToByteArray(int source, int size){
        byte[] result = new byte[size];
        int index = result.length - 1;
        while(source > 0){
            int remain = source % 256;
            result[index] = (byte) remain;
            source = source / 256;
            index--;
        }

        return result;
    }

    public static int byteArrayToInt(byte[] source){
        if(source.length > 8){
            return -1;
        }
        int power = 1;
        int length = source.length;
        int result = 0;
        for (int i=length - 1; i >= 0; i--) {
            int base = (int)source[i] & 0x000000ff;
            result += base * power;
            power*=256;
        }
        return result;
    }

}
