public class Test {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();

        Student student01 = new Student("Andrei");
        Student student02 = new Student("Calin");
        Student student03 = new Student("Matei");

        student01.listen(teacher);
        student02.listen(teacher);
        student03.listen(teacher);

        String[] javaTopics = new String[]{
                "basic",
                "oo",
                "design patterns"
        };

        for (int i = 0; i < javaTopics.length; i++) {
            teacher.teach(javaTopics[i]);
        }
    }
}
