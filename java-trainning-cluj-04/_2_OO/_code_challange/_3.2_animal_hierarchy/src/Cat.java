public class Cat extends Animal implements Pet {
    private String name;

    public Cat(){
        this("");
    }

    protected Cat(String name) {
        super(4);
        this.name = name;
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
        System.out.println("Play with wool balls");
    }

    @Override
    void eat() {
        System.out.println("Eat mice");
    }
}
