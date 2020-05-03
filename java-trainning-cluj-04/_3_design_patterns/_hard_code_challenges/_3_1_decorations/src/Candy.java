import java.util.ArrayList;
import java.util.List;

public class Candy implements CandyDecorator {
    private DecorableTree decorableTree;
    private List<List<String>> tree;
    private int lineToDecorate;

    public Candy(DecorableTree decorableTree, int lineToDecorate) {
        this.decorableTree = decorableTree;
        this.lineToDecorate = lineToDecorate;
        this.tree = this.decorableTree.getTree();
    }

    public Candy(DecorableTree decorableTree) {
        this.decorableTree = decorableTree;
        this.lineToDecorate = 3;
        this.tree = this.decorableTree.getTree();
    }

    @Override
    public void putCandy() {
        List<String> listModify = this.tree.get(this.lineToDecorate);
        int sizeList = listModify.size();
        int left = 9 - this.lineToDecorate + 1;
        int right = 10 + this.lineToDecorate + 1;
        for (int i = 0; i < sizeList; i++) {
            if ((i > left) && (i < right)) {
                listModify.set(i, "C");
            }
        }
    }

    @Override
    public List<List<String>> getTree() {
        putCandy();
        return this.tree;
    }

    @Override
    public void display() {
        for (int i = 0; i < this.tree.size(); i++) {
            for (int j = 0; j < this.tree.get(i).size(); j++) {
                System.out.print(this.tree.get(i).get(j));
            }
            System.out.println();
        }
    }
}
