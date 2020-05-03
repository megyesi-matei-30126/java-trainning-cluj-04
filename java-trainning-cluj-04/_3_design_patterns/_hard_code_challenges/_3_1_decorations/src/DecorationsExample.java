
public class DecorationsExample {
    public static void main(String[] args) {
        DecorableTree christmasTree = new ChristmasTree();
        DecorableTree decorableTree = new Garland( new Bulbs(new Candy(christmasTree)));
        decorableTree.display();

        System.out.println();
        DecorableTree decorableTreeCustom = new Garland(new Bulbs(new Candy(christmasTree, 9), 4), 1);
        decorableTreeCustom.display();
    }
}
