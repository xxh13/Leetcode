package array;

public class StaticResolution {

    static int init = 0;

    static {
        System.out.println("hello world");
	    System.out.println(init);
    }

    public static void main(String[] args) {
//        StaticResolution.sayHello();
    }
}
