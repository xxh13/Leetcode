package java8;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerailizeTest1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Persons p = new Persons();
        p.setAge(10);
        ObjectOutputStream oos;
        try {
            //先对旧的类对象进行序列化
            oos = new ObjectOutputStream(new FileOutputStream("src/main/java/person.ser"));
            oos.writeObject(p);
            oos.flush();
            oos.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
