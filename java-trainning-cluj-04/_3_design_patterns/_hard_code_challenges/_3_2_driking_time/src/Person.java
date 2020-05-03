public class Person implements IPerson {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public Person(BuildPerson builder) {
        this.name = builder.name;
    }

    @Override
    public void walk() {
        System.out.println(this.name + " walking");
    }

    @Override
    public void drink() {
        System.out.println(this.name + " drinking");
    }

    @Override
    public String getName() {
        return this.name;
    }

    public static class BuildPerson {
        private String name;

        public BuildPerson setName(String name) {
            this.name = name;
            return this;
        }

        public Person build() {
            return (Person) java.lang.reflect.Proxy.newProxyInstance(PersonInvocationHandler.class.getClassLoader(), new Class[] {IPerson.class}, new PersonInvocationHandler(this));
        }
    }
}
