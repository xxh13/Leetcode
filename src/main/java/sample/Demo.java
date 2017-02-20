package sample;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * Created by XXH on 2016/4/8.
**/
public class Demo {
    public static void main(String[] args)throws Exception{
        /*
        * copy file
        *
        RandomAccessFile fromFile = new RandomAccessFile("src/main/java/demo1.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("src/main/java/demo2.txt", "rw");
        FileChannel toChannel = toFile.getChannel();

        toChannel.transferFrom(fromChannel, 0, fromChannel.size());
        */

        RandomAccessFile file = new RandomAccessFile("src/main/java/demo1.txt", "rw");
        FileChannel channel = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        channel.position(4);
        channel.read(buffer);

        System.out.println(new String(buffer.array()));
    }

    //return the material size
    public int getMaterial(String filepath) throws Exception{
        String line = "";
        String line_array[];
        List<String> material_list = new LinkedList<>();

        BufferedReader br = new BufferedReader(new FileReader(filepath));

        while ((line = br.readLine()) != null){
            line_array = line.split(" ");
            for (String item : line_array){
                if (material_list.contains(item))
                    material_list.add(item);
            }
        }

        return material_list.size();
    }


}

