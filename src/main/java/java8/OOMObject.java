package java8;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OOMObject implements Serializable{

    public static void main(String[] args) throws Exception{
        fillHeap(1000);
        System.gc();
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OMObject());
        }
    }

    static class OMObject {
        public byte[] placeHolder = new byte[64 * 1024];
    }
}
