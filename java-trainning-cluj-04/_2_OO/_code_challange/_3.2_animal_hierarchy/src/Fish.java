public class Fish extends Animal implements Pet {
    String name;

    public Fish(){
        this("");
    }

    protected Fish(String name) {
        super(0);
        this.name = name;
    }

    @Override
    public void walk() {
        System.out.println("Fish can't walk and don't have legs");
    }

    @Override
    void eat() {
        System.out.println("Eat fish food!");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println("Don't play");
    }
}
