import java.util.List;

public class Garland implements GarlandDecorator {
    private DecorableTree decorableTree;
    private List<List<String>> treeWithBulbsAndCandy;
    private int lineToDecorate;

    public Garland(DecorableTree decorableTree) {
        this.decorableTree = decorableTree;
        this.treeWithBulbsAndCandy = this.decorableTree.getTree();
        this.lineToDecorate = 8;
        this.treeWithBulbsAndCandy = getTree();
    }

    public Garland(DecorableTree decorableTree, int lineToDecorate) {
        this.decorableTree = decorableTree;
        this.lineToDecorate = lineToDecorate;
        this.treeWithBulbsAndCandy = this.decorableTree.getTree();
        this.treeWithBulbsAndCandy = getTree();
    }


    @Override
    public void putGarland() {
        List<String> listModify = this.treeWithBulbsAndCandy.get(this.lineToDecorate);
        int sizeList = listModify.size();
        int left = 9 - this.lineToDecorate + 1;
        int right = 10 + this.lineToDecorate + 1;
        for (int i = 0; i < sizeList; i++) {
            if (i > left && i < right) {
                listModify.set(i, "G");
            }
        }
    }

    @Override
    public List<List<String>> getTree() {
        putGarland();
        return this.treeWithBulbsAndCandy;
    }

    @Override
    public void display() {
        for (int i = 0; i < this.treeWithBulbsAndCandy.size(); i++) {
            for (int j = 0; j < this.treeWithBulbsAndCandy.get(i).size(); j++) {
                System.out.print(this.treeWithBulbsAndCandy.get(i).get(j));
            }
            System.out.println();
        }
    }
}
