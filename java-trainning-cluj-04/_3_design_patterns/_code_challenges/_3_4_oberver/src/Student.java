public class Student implements Observer {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public void listen(Teacher teacher) {
        teacher.register(this);
    }

    @Override
    public void update(String message) {
        System.out.println("Sudent " + this.name + " learned about " + message);
    }
}
