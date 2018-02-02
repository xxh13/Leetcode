package anno;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by XXH on 2018/2/2.
 */
public class DemoProxy {
    private Demo demo;

    public DemoProxy(Demo demo) {
        this.demo = demo;
    }

    public DemoImp create() {
        return (DemoImp) Proxy.newProxyInstance(Demo.class.getClassLoader(), Demo.class.getInterfaces(), new Logger(demo));
    }

    private static class Logger implements InvocationHandler {

        private Demo obj;

        public Logger(Demo obj) {
            this.obj = obj;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            String methodName = method.getName();
            System.out.println(methodName + " start");
            Object result = method.invoke(obj, args);
            System.out.println(methodName + " end");
            return result;
        }
    }
}
