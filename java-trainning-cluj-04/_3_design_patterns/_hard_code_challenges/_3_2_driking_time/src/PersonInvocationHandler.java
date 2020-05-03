import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;

public class PersonInvocationHandler implements InvocationHandler {
    private Object obj;

    public PersonInvocationHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(LogExecutionTime.class)) {
            Instant start = Instant.now();
            method.invoke(this.obj, args);
            Instant end = Instant.now();
            Duration interval = Duration.between(start, end);
            System.out.println("is driking for " + interval);
        } else {
            method.invoke(this.obj, args);
        }
        return null;
    }
}
