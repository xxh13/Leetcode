package datastructure;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class StringMatch {

    public static void main(String[] args) throws Exception{
        StringMatch stringMatch = new StringMatch();
        String text = stringMatch.readFile("src/main/java/demo1.txt");
        String search = "hello";
        stringMatch.search(text, search);
    }

    public String readFile(String path) throws Exception {
        File file = new File(path);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        FileChannel channel = randomAccessFile.getChannel();
        ByteBuffer buffer =  ByteBuffer.allocate(10);
        StringBuilder stringBuilder = new StringBuilder();
        while (channel.read(buffer) != -1) {
            byte[] bytes = buffer.array();
            stringBuilder.append(new String(bytes));
            buffer.flip();
        }

        return stringBuilder.toString();
    }


    //O(M * N)
    public void search(String text, String search) {
        char[] textArray = text.toCharArray();
        char[] searchArray = search.toCharArray();
        List<Integer> indexList = new ArrayList<>();

        int i = 0, j = 0;
        while (i < textArray.length) {
            int temp = i;
            for (j = 0; j < searchArray.length;) {
                if (textArray[temp] == searchArray[j]) {
                    temp++;
                    j++;
                } else {
                    break;
                }
            }
            //find it
            if (j == searchArray.length) {
                indexList.add(i);
            }
            i++;
        }

        indexList.forEach(System.out::println);
    }

    public void search2(String text, String search) {

    }

}
