import java.util.ArrayList;
import java.util.List;

public class ImpCollection implements Collection {
    private List<Integer> integerList;

    public ImpCollection() {
        this.integerList = new ArrayList<>();
    }

    @Override
    public void add(int element) {
        this.integerList.add(element);
    }

    @Override
    public void remove(int element) {
        this.integerList.remove(element);
    }

    @Override
    public ImpInterator iterator() {
        return new ImpInterator(this.integerList);
    }
}
