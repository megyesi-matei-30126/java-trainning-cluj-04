import java.util.List;

public class Bulbs implements BublsDecorator {
    private DecorableTree decorableTreeCandy;
    private List<List<String>> treeWithCandy;
    private int lineToDecorate;

    public Bulbs(DecorableTree decorableTreeCandy) {
        this.decorableTreeCandy = decorableTreeCandy;
        this.lineToDecorate = 6;
        this.treeWithCandy = this.decorableTreeCandy.getTree();
    }

    public Bulbs(DecorableTree decorableTreeCandy, int lineToDecorate) {
        this.decorableTreeCandy = decorableTreeCandy;
        this.lineToDecorate = lineToDecorate;
        this.treeWithCandy = this.decorableTreeCandy.getTree();
    }


    @Override
    public void putBubls() {
        List<String> listModify = this.treeWithCandy.get(this.lineToDecorate);
        int sizeList = listModify.size();
        int left = 9 - this.lineToDecorate + 1;
        int right = 10 + this.lineToDecorate + 1;
        for (int i = 0; i < sizeList; i++) {
            if (i > left && i < right) {
                listModify.set(i, "B");
            }
        }
    }

    @Override
    public List<List<String>> getTree() {
        putBubls();
        return this.treeWithCandy;
    }

    @Override
    public void display() {
        for (int i = 0; i < this.treeWithCandy.size(); i++) {
            for (int j = 0; j < this.treeWithCandy.get(i).size(); j++) {
                System.out.print(this.treeWithCandy.get(i).get(j));
            }
            System.out.println();
        }
    }
}
