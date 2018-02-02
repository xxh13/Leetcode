package anno;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

/**
 * Created by XXH on 2018/2/2.
 */
public class Test {

    public static void main(String[] args) throws Throwable{
        test_proxy();
    }

    public static void test_annotation() throws Throwable{
        Demo demo = new Demo();
        Field[] fields = Demo.class.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Assignment.class)) {
                Assignment assignment = field.getAnnotation(Assignment.class);
                String assignee = assignment.assignee();
                int effort = assignment.effort();
                double finished = assignment.finished();

                System.out.println(assignee + " assign job to " + field.get(demo) + ". effort: " + effort + " finished: " + finished);
            }
        }
    }

    public static void  test_proxy() {
        Demo demo = new Demo();
        DemoProxy demoProxy = new DemoProxy(demo);
        DemoImp demoImp = demoProxy.create();
        demoImp.print("hello world");
    }
}
