package anno;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by XXH on 2018/2/2.
 */
public class AssignmentInvocationHandler<T> implements InvocationHandler{

    final T obj;
    public AssignmentInvocationHandler(T obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
