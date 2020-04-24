public class TestAnimals {
    public static void main(String[] args) {
        Fish fish = new Fish();
        Fish fish1 = new Fish("Nemo");
        fish.walk();
        fish.eat();
        System.out.println(fish.getName());
        fish.setName("Nemo");
        System.out.println(fish.getName());
        System.out.println(fish1.getName());

        fish1.play();

        Animal animal1 = fish1;
        animal1.walk();

        Cat cat = new Cat("Cat1");
        cat.walk();
        cat.eat();

        Animal animal2 = new Spider();
        animal2.eat();
    }
}
