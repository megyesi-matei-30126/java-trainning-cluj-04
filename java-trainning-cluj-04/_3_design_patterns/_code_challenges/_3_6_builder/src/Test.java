public class Test {
    public static void main(String[] args) {
        Person person01 = new Person.Builder("Matei").setJob("Programator").setIsMaried(false).setDrivingLincense(false).build();
        System.out.println(person01.toString());
    }
}
