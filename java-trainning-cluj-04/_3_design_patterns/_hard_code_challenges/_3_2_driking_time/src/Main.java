
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Matei");
        IPerson iPerson = (IPerson) Proxy.newProxyInstance(IPerson.class.getClassLoader(), new Class[]{IPerson.class}, new PersonInvocationHandler(person));
        iPerson.walk();
        iPerson.drink();

        IPerson iPerson1 = (IPerson) new Person.BuildPerson().setName("Andrei").build();
        iPerson1.walk();
        iPerson1.drink();
    }
}
