package java8;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Persons p = new Persons();
        p.setAge(10);
        ObjectOutputStream oos;
        try {
            //用新的类规范来反序列化
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/java/person.ser"));
            Persons sp = (Persons) ois.readObject();
            System.out.println(sp.getName());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
